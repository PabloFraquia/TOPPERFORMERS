package Tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Setup.DriverConfig;
import domain.Login;
import domain.ObjectManager.ObjectManager;
import domain.ObjectManager.Capabilities.ValidationRule;

public class ExerciseLocatorPrinter extends TestingBase {
	
	public ExerciseLocatorPrinter() {
	super();
	}
	
	@Test
	public void printLoginLocator() {
		WebDriver driver=DriverConfig.getDriverInitializer("chrome");
		driver.get(url);
		Login login=new Login(driver);
		System.out.println(login.returnWebElement());
	}
	
	@Test
	public void printVRuleLocator() {
		WebDriver driver=DriverConfig.getDriverInitializer("firefox");
		driver.get(url);
		Login login=new Login(driver);
		login.login(adminUser, password);
		ObjectManager oM = new ObjectManager(driver);
		oM.goToValidationRules("Object Manager", "Account", "Validation Rules");
		ValidationRule vRule = new ValidationRule(driver);
		System.out.println(vRule.returnWebElement());
		
	}
	
}
