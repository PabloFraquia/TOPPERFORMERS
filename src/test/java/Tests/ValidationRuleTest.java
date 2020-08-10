package Tests;

import static org.testng.Assert.assertEquals;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Setup.DriverConfig;
import Setup.ValidationPropConfig;
import constants.setup.objectManager.objectManagerConstants;
import domain.Login;
import domain.ValidationRule;
import factory.GlobalFactory;
import factory.ObjectManagerFactory;

@Test
public class ValidationRuleTest {
	WebDriver driver;
	Login login;
	String url = "https://login.salesforce.com";
	String user = "pablofraquia@gmail.com";
	String pass = "Selenium2020!";
	String tabName = "Object Manager";
	String objectName = "Account";
	String detailName = "Validation Rules";
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
		Thread.sleep(10000);
		//vRule.goToValidationRules(tabName, objectName, detailName); // aca es donde esta saltando la falla 
		
		/* también intenté manual pero no encuentra los elementos
		 
		driver.findElement(By.xpath("//*[@title = 'Object Manager']")).click();
		driver.findElement(By.xpath("//*[text() = 'Account']")).click();
		driver.findElement(By.xpath("//*[text() = 'Validation Rules']")).click();
		*/
		
	}
	
	@BeforeMethod
	public void initValidationRuleProperties() {
		
		Properties prop = ValidationPropConfig.getValidationProperties();
		validationRuleName = prop.getProperty("validationRuleName");
		formula = prop.getProperty("formula");
		wrongFormula = prop.getProperty("wrongFormula");
		errorMessage = prop.getProperty("errorMessage");
		
	}
	
	@Test (priority = 0)
	public void noRequiredField() throws InterruptedException {
		vRule.validationRuleConstruction(validationRuleName, formula, "");
		assertEquals(vRule.checkErrorDisplay(), " You must enter a value");
		Thread.sleep(5000);
		gf.getCancelButton().click();
		
	}
	
	@Test (priority = 1)
	public void wrongFormulaText() throws InterruptedException {
		vRule.validationRuleConstruction(validationRuleName, wrongFormula, errorMessage);
		assertEquals(vRule.checkFormulaError(), " Syntax error.  Found 'Banana'");
		Thread.sleep(5000);
		gf.getCancelButton().click();
	}
	
	@Test (priority = 2)
	public void correctFilledFields() {
		vRule.validationRuleConstruction(validationRuleName, formula, errorMessage);
		//assertEquals(vRule.checkEditButton(), true);
		
	}

}
