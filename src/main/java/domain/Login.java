package domain;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import factory.LoginFactory;

public class Login {
	LoginFactory lf;
	public Login(WebDriver driver) {
		lf=new LoginFactory(driver);
	}

	public void login(String user, String password) {
		
	}

	public String checkErrorMessage() {
		return null; //Error message from WebElement
		
	}
}
