package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.loginConstants;

public class LoginFactory {
	
	@FindBy (css = loginConstants.inputUsername)private WebElement inputUsername;
	@FindBy (css = loginConstants.inputPassword)private WebElement inputPassword;
	@FindBy (css = loginConstants.bttnLogin)private WebElement buttonLogin;
	@FindBy (css = loginConstants.loginErrorMessage)private WebElement logginError;
	
	
	public LoginFactory(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getInputUsername() {
		return inputUsername;
	}

	public WebElement getInputPassword() {
		return inputPassword;
	}

	public WebElement getButtonLogin() {
		return buttonLogin;
	}
	
	public WebElement getLogginError() {
		return logginError;
	}
	
}
