package Tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Setup.DriverConfig;
import Setup.ValidationPropConfig;
import domain.Global;
import domain.Home;
import domain.Login;
import domain.ObjectManager.ObjectManager;
import domain.ObjectManager.Capabilities.ValidationRule;

@Test
public class ValidationRuleTest extends TestingBase{
	String tabName = "Object Manager";
	String objectName = "Account";
	String detailName = "Validation Rules";
	String validationRuleName;
	String formula;
	String wrongFormula;
	String errorMessage;
	
	
	
	/*@BeforeMethod
	public void initializeDriverAndLoginPage() throws InterruptedException {
		
		driver.get(url);
		Login login = new Login(driver);
		login.login(adminUser, password);
		vRule = new ValidationRule(driver);
		Home home=new Home(driver);
		home.waitForHomeLoading();
		ObjectManager objectManager=new ObjectManager(driver);
		objectManager.goToValidationRules(tabName, objectName, detailName); 		
		
	}*/
	@AfterMethod
	public void closeDriver() {
		//driver.close();
	}
	
	@BeforeSuite
	public void initValidationRuleProperties() {
		
		Properties valProperties = ValidationPropConfig.getValidationProperties();
		validationRuleName = valProperties.getProperty("validationRuleName");
		formula = valProperties.getProperty("formula");
		wrongFormula = valProperties.getProperty("wrongFormula");
		errorMessage = valProperties.getProperty("errorMessage");
	}
	
	@Test (priority = 0)
	public void noRequiredField() {
		WebDriver driver = DriverConfig.getDriverInitializer("firefox");
		
		Home home=new Home(driver);
		ObjectManager objectManager=new ObjectManager(driver);
		ValidationRule vRule=new ValidationRule(driver);
		driver.get(url);
		login(driver);
		home.waitForHomeLoading();
		objectManager.goToValidationRules(tabName, objectName, detailName);
		vRule.validationRuleConstruction(validationRuleName, formula, "");
		assertEquals(vRule.checkErrorDisplay(), "Error: You must enter a value");
		Global g=new Global(driver);
		g.cancelValidationRule();
		driver.quit();
		
		
	}
	
	@Test (priority = 1)
	public void wrongFormulaText() {
		WebDriver driver = DriverConfig.getDriverInitializer("firefox");
		
		Home home=new Home(driver);
		ObjectManager objectManager=new ObjectManager(driver);
		ValidationRule vRule=new ValidationRule(driver);
		driver.get(url);
		login(driver);
		home.waitForHomeLoading();
		objectManager.goToValidationRules(tabName, objectName, detailName);
		vRule.validationRuleConstruction(validationRuleName, wrongFormula, errorMessage);
		assertEquals(vRule.checkFormulaError(), "Error: Syntax error. Found 'Banana'");
		Global g=new Global(driver);
		g.cancelValidationRule();
		driver.quit();
	}
	
	@Test (priority = 2)
	public void correctFilledFields() {
		WebDriver driver = DriverConfig.getDriverInitializer("firefox");
		
		Home home=new Home(driver);
		ObjectManager objectManager=new ObjectManager(driver);
		ValidationRule vRule=new ValidationRule(driver);
		driver.get(url);
		login(driver);
		home.waitForHomeLoading();
		objectManager.goToValidationRules(tabName, objectName, detailName);
		vRule.validationRuleConstruction(validationRuleName, formula, errorMessage);
		driver.switchTo().defaultContent();
		assertTrue(vRule.checkEditButton());
		vRule.deleteValidationRule();
	}
	
	public void login(WebDriver driver) {
		Login PageLogin=new Login(driver);
		PageLogin.login(adminUser, password);
	}
	
	/*@AfterSuite
	public void deleteValidationRules() {
		vRule.deleteValidationRule();
	}*/
	

}
