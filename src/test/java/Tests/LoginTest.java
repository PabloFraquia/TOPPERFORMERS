package Tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Setup.DriverConfig;
import domain.Login;

@Test
public class LoginTest extends TestingBase{
	WebDriver driver;
	Login login;
	
	public LoginTest() {
		super();
	}

	@BeforeMethod
	public void InitializeDriverAndLoginPage() {
		this.driver = DriverConfig.getDriverInitializer("chrome");
		driver.get(url);
		login = new Login(driver);
	}

	@Test
	public void correctCredentials() {
		login.login(adminUser, password);
		
		
	}

	@Test
	public void wrongCredentials() {
		login.login(adminUser, password + "asd");
		assertEquals(login.checkErrorMessage(), "Please check your username and password. If you still can't log in, contact your Salesforce administrator.");
	}
	@Test
	public void noPassword() {
		login.login(adminUser, "");
		assertEquals(login.checkErrorMessage(), "Please enter your password.");
	}

	@AfterMethod
	public void closeDriver() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
	}
}
