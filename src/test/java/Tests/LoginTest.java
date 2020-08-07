package Tests;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Setup.DriverConfig;
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
		
		FileReader reader;
		try {
			reader = new FileReader("credentials.properties");
			Properties prop=new Properties();
			prop.load(reader);
			emailAdmin=prop.getProperty("emailAdmin");
			password=prop.getProperty("password");
			url=prop.getProperty("url");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	@BeforeTest
	public void InitializeDriverAndLoginPage() {
		this.driver=DriverConfig.getDriverInitializer("chrome");
		driver.get(url);
		login=new Login(driver);
	}
	@Test
	public void correctCredentials() {
		login.login(emailAdmin, password);
	}
	
	@Test
	public void wrongCredentials() {
		login.login(emailAdmin, password+"asd");
	}
	@Test
	public void noCredentials() {
		login.login("", "");
	}
	@Test
	public void noPassword() {
		login.login(emailAdmin, "");
	}
	@Test
	public void noEmail() {
		login.login("", password);
	}
	
	
}
