package domain.ObjectManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import constants.setup.objectManager.objectManagerConstants;
import domain.Global;
import factory.ObjectManagerFactory;

public class ObjectManager extends Global{
	private ObjectManagerFactory omf;
	public ObjectManager(WebDriver driver) {
		super(driver);
		omf=new ObjectManagerFactory(driver);
	}
	
	public void goToValidationRules(String tab, String object, String detail) {
		
		omf.getSetupTab(tab).click();
		waitForWorkspace(); // Waits might not be necessary when using implicit wait
		waitForSpinner();
		//must learn how to use presenceOfElementLocated in POM, since we can't use webElements
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(objectManagerConstants.nameObject.replace("$x", object)))).click();
		omf.getObjectManagerDetail(detail).click();
		omf.getObjectManagerButtonNew().click();
		
		
	}
}
