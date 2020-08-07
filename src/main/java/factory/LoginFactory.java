package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginFactory {
	
	
	
	public LoginFactory(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
