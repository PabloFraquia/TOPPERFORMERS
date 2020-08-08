package factory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.setup.objectManager.objectManagerConstants;

public class ObjectManagerFactory {
	
	WebDriver driver;
	
	@FindBy (xpath = objectManagerConstants.objectManagerButtonNew)private WebElement objectManagerButtonNew;
	@FindBy (css = objectManagerConstants.inputQuickfind)private WebElement inputQuickfind;

	public ObjectManagerFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
	
	public WebElement getObjectManagerButtonNew() {
		return objectManagerButtonNew;
	}
	
	public WebElement getInputQuickfind() {
		return inputQuickfind;
	}

	public WebElement getSetupTab (String tab) {
		return driver.findElement(By.cssSelector(objectManagerConstants.setupTab.replace("$x", tab)));
	}
	
	public WebElement getNameObject (String tab) {
		return driver.findElement(By.xpath(objectManagerConstants.nameObject.replace("$x", tab)));
	}
	
	public WebElement getObjectManagerDetail (String tab) {
		return driver.findElement(By.cssSelector(objectManagerConstants.objectManagerDetail.replace("$x", tab)));
	}
}

