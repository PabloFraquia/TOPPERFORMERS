package Tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import Setup.DriverConfig;
import domain.Home;
import domain.Login;

@Test
public class LoginTest extends TestingBase{
	public LoginTest() {
		super();
	}

	@Test (groups = {"Funtional", "Login"})
	public void correctCredentials() {
		WebDriver driver=DriverConfig.getDriverInitializer("chrome");
		driver.get(url);
		Login login=new Login(driver);
		login.login(adminUser, password);
		Home home=new Home(driver);
		home.waitForHomeLoading();
		assertTrue(driver.getTitle().contains("Home"));
		driver.close();
	}

	@Test (groups = {"Non-Funtional", "Login"})
	public void wrongCredentials() {
		WebDriver driver=DriverConfig.getDriverInitializer("chrome");
		driver.get(url);
		Login login=new Login(driver);
		login.login(adminUser, password + "asd");
		assertEquals(login.checkErrorMessage(), "Please check your username and password. If you still can't log in, contact your Salesforce administrator.");
		driver.close();
	}
	
	@Test (groups = {"Non-Funtional", "Login"})
	public void noPassword() {
		WebDriver driver=DriverConfig.getDriverInitializer("chrome");
		driver.get(url);
		Login login=new Login(driver);
		login.login(adminUser, "");
		assertEquals(login.checkErrorMessage(), "Please enter your password.");
		driver.close();
	}

}
