package Tests;

import static org.testng.Assert.assertEquals;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Setup.DriverConfig;
import Setup.ValidationPropConfig;
import domain.Login;
import domain.ValidationRule;
import factory.GlobalFactory;

@Test
public class ValidationRuleTest {
	WebDriver driver;
	Login login;
	String url = "https://login.salesforce.com";
	String user = "pablofraquia@gmail.com";
	String pass = "Selenium2020!";
	String validationRuleName;
	String formula;
	String wrongFormula;
	String errorMessage;
	ValidationRule vRule;
	GlobalFactory gf;
	
	
	
	@BeforeClass
	public void InitializeDriverAndLoginPage() throws InterruptedException {
		this.driver = DriverConfig.getDriverInitializer("chrome");
		driver.get(url);
		login = new Login(driver);
		login.login(user, pass);
		Thread.sleep(7000);
		
	}
	
	@BeforeMethod
	public void initValidationRuleProperties() {
		Properties prop = ValidationPropConfig.getValidationProperties();
		validationRuleName = prop.getProperty("validationRuleName");
		formula = prop.getProperty("formula");
		wrongFormula = prop.getProperty("wrongFormula");
		errorMessage = prop.getProperty("errorMessage");
	}
	
	@Test
	public void noRequiredField() throws InterruptedException {
		vRule.validationRuleConstruction(validationRuleName, formula, "");
		assertEquals(vRule.checkErrorDisplay(), " You must enter a value");
		Thread.sleep(5000);
		gf.getCancelButton().click();
		
	}
	
	@Test
	public void wrongFormulaText() throws InterruptedException {
		vRule.validationRuleConstruction(validationRuleName, wrongFormula, errorMessage);
		assertEquals(vRule.checkFormulaError(), " Syntax error.  Found 'Banana'");
		Thread.sleep(5000);
		gf.getCancelButton().click();
	}
	
	@Test
	public void correctFilledFields() {
		vRule.validationRuleConstruction(validationRuleName, formula, errorMessage);
		assertEquals(vRule.checkEditButton(), true);
		
	}

}
