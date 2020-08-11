package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.HomeConstants;

public class HomeFactory {
	private WebDriver driver;
	public HomeFactory(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy (css = HomeConstants.imgContainer) WebElement imgContainer;
	
	
	public WebElement getImgContainer() {
		return imgContainer;
	} 
	
}
