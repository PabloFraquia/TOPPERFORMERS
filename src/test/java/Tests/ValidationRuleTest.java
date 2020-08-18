package Tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
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

	
	@BeforeSuite (groups = {"Non-Funtional", "VRuleTest"})
	public void initValidationRuleProperties() {
		
		Properties valProperties = ValidationPropConfig.getValidationProperties();
		validationRuleName = valProperties.getProperty("validationRuleName");
		formula = valProperties.getProperty("formula");
		wrongFormula = valProperties.getProperty("wrongFormula");
		errorMessage = valProperties.getProperty("errorMessage");
	}
	
	@Test (groups = {"Non-Funtional", "VRuleTest"})
	public void noRequiredField() {
		WebDriver driver = DriverConfig.getDriverInitializer("firefox");
		
		Home home=new Home(driver);
		ObjectManager objectManager=new ObjectManager(driver);
		ValidationRule vRule=new ValidationRule(driver);
		
		driver.get(url);
		Login PageLogin=new Login(driver);
		PageLogin.login(adminUser, password);
		home.waitForHomeLoading();
		objectManager.goToValidationRules(tabName, objectName, detailName);
		vRule.validationRuleConstruction(validationRuleName, formula, "");
		assertEquals(vRule.checkErrorDisplay(), "Error: You must enter a value");
		Global g=new Global(driver);
		g.cancelValidationRule();
		driver.quit();
		
		
	}
	
	@Test (groups = {"Non-Funtional", "VRuleTest"})
	public void wrongFormulaText() {
		WebDriver driver = DriverConfig.getDriverInitializer("firefox");
		
		Home home=new Home(driver);
		ObjectManager objectManager=new ObjectManager(driver);
		ValidationRule vRule=new ValidationRule(driver);
		
		driver.get(url);
		Login PageLogin=new Login(driver);
		PageLogin.login(adminUser, password);
		home.waitForHomeLoading();
		objectManager.goToValidationRules(tabName, objectName, detailName);
		vRule.validationRuleConstruction(validationRuleName, wrongFormula, errorMessage);
		assertEquals(vRule.checkFormulaError(), "Error: Syntax error. Found 'Banana'");
		Global g=new Global(driver);
		g.cancelValidationRule();
		driver.quit();
	}
	
	@Test (groups = {"Funtional", "VRuleTest"})
	public void correctFilledFields() {
		WebDriver driver = DriverConfig.getDriverInitializer("firefox");
		
		Home home=new Home(driver);
		ObjectManager objectManager=new ObjectManager(driver);
		ValidationRule vRule=new ValidationRule(driver);
		
		driver.get(url);
		Login PageLogin=new Login(driver);
		PageLogin.login(adminUser, password);
		home.waitForHomeLoading();
		objectManager.goToValidationRules(tabName, objectName, detailName);
		vRule.validationRuleConstruction(validationRuleName, formula, errorMessage);
		driver.switchTo().defaultContent();
		assertTrue(vRule.checkEditButton());
		vRule.deleteValidationRule();
		driver.quit();
	}


}
