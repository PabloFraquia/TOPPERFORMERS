package Tests;

import static org.testng.Assert.assertEquals;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Setup.DriverConfig;
import Setup.ValidationPropConfig;
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
		this.driver = DriverConfig.getDriverInitializer("chrome");
		driver.get(url);
		Login login = new Login(driver);
		login.login(adminUser, password);
		vRule = new ValidationRule(driver);
		Home home=new Home(driver);
		home.waitForHomeLoading();
		ObjectManager objectManager=new ObjectManager(driver);
		objectManager.goToValidationRules(tabName, objectName, detailName); // aca es donde esta saltando la falla 
		
		/* también intenté manual pero no encuentra los elementos
		 
		driver.findElement(By.xpath("//*[@title = 'Object Manager']")).click();
		driver.findElement(By.xpath("//*[text() = 'Account']")).click();
		driver.findElement(By.xpath("//*[text() = 'Validation Rules']")).click();
		*/
		
		
	}
	@AfterMethod
	public void closeDriver() {
		driver.close();
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
