package Tests;

import static org.testng.Assert.assertEquals;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Setup.DriverConfig;
import Setup.PropertiesConfig;
import domain.Login;

@Test
public class LoginTest {
	WebDriver driver;
	String emailAdmin;
	String password;
	String url;
	Login login;

	@BeforeClass
	public void initializeProperties() {

		Properties prop = PropertiesConfig.getCredentialsProperties();
		emailAdmin = prop.getProperty("emailAdmin");
		password = prop.getProperty("password");
		url = prop.getProperty("url");

	}

	@BeforeMethod
	public void InitializeDriverAndLoginPage() {
		this.driver = DriverConfig.getDriverInitializer("chrome");
		driver.get(url);
		login = new Login(driver);
	}

	@Test
	public void correctCredentials() {
		login.login(emailAdmin, password);
		
		
	}

	@Test
	public void wrongCredentials() {
		login.login(emailAdmin, password + "asd");
		assertEquals(login.checkErrorMessage(), "Please check your username and password. If you still can't log in, contact your Salesforce administrator.");
	}
	@Test
	public void noPassword() {
		login.login(emailAdmin, "");
		assertEquals(login.checkErrorMessage(), "Please enter your password.");
	}

	@AfterMethod
	public void CloseDriver() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
	}
}
