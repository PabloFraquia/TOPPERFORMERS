package Tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Properties;

import org.checkerframework.checker.units.qual.g;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Setup.DriverConfig;
import Setup.ValidationPropConfig;
import domain.Global;
import domain.Home;
import domain.Login;
import domain.ObjectManager.ObjectManager;
import domain.ObjectManager.Capabilities.ValidationRule;
import factory.GlobalFactory;

@Test
public class ValidationRuleTest extends TestingBase{
	WebDriver driver;
	String tabName = "Object Manager";
	String objectName = "Account";
	String detailName = "Validation Rules";
	String validationRuleName;
	String formula;
	String wrongFormula;
	String errorMessage;
	ValidationRule vRule;
	GlobalFactory gf;
	
	
	
	@BeforeMethod
	public void initializeDriverAndLoginPage() throws InterruptedException {
		this.driver = DriverConfig.getDriverInitializer("firefox");
		driver.get(url);
		Login login = new Login(driver);
		login.login(adminUser, password);
		vRule = new ValidationRule(driver);
		Home home=new Home(driver);
		home.waitForHomeLoading();
		ObjectManager objectManager=new ObjectManager(driver);
		objectManager.goToValidationRules(tabName, objectName, detailName); 		
		
	}
	@AfterMethod
	public void closeDriver() {
		//driver.close();
	}
	
	@BeforeClass
	public void initValidationRuleProperties() {
		Properties valProperties = ValidationPropConfig.getValidationProperties();
		validationRuleName = valProperties.getProperty("validationRuleName");
		formula = valProperties.getProperty("formula");
		wrongFormula = valProperties.getProperty("wrongFormula");
		errorMessage = valProperties.getProperty("errorMessage");
	}
	
	@Test (priority = 0)
	public void noRequiredField() {
		vRule.validationRuleConstruction(validationRuleName, formula, "");
		assertEquals(vRule.checkErrorDisplay(), "Error: You must enter a value");
		Global g=new Global(driver);
		g.cancelValidationRule();
		
		
	}
	
	@Test (priority = 1)
	public void wrongFormulaText() {
		vRule.validationRuleConstruction(validationRuleName, wrongFormula, errorMessage);
		assertEquals(vRule.checkFormulaError(), "Error: Syntax error. Found 'Banana'");
		Global g=new Global(driver);
		g.cancelValidationRule();
		
	}
	
	@Test (priority = 2)
	public void correctFilledFields() {
		vRule.validationRuleConstruction(validationRuleName, formula, errorMessage);
		driver.switchTo().defaultContent();
		
		assertTrue(vRule.checkEditButton());
		
	}

}
