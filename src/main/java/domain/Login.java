package domain;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import factory.LoginFactory;

public class Login extends Global{
	LoginFactory lf;
	public Login(WebDriver driver) {
		super(driver);
		lf=new LoginFactory(driver);
	}

	public void login(String user, String password) {
		lf.getInputUsername().sendKeys(user);
		lf.getInputPassword().sendKeys(password);
		lf.getButtonLogin().click();
	}

	public String checkErrorMessage() {
		return wait.until(ExpectedConditions.visibilityOf(lf.getLogginError())).getText();
		
	}
	public Boolean checkElementDisplayed() {
		return lf.getLogginError().isDisplayed();
		
	}
}
