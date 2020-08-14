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
	
	public WebElement getObjectManagerDetail (String detail) {
		return driver.findElement(By.cssSelector(objectManagerConstants.objectManagerDetail.replace("$x", detail)));
	}

	public By getNameObjectLocator(String object) {
		
		return By.xpath(objectManagerConstants.nameObject.replace("$x", object));
	}

	public By getObjectManagerDetailLocator(String detail) {
		return By.cssSelector(objectManagerConstants.objectManagerDetail.replace("$x", detail));
	}

	public By getObjectManagerButtonNewLocator() {
		return By.xpath(objectManagerConstants.objectManagerButtonNew);
	}
}

