package domain.ObjectManager;

import org.openqa.selenium.WebDriver;
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
		//waitForWorkspace(); // Waits might not be necessary when using implicit wait
		//waitForSpinner();
		//must learn how to use presenceOfElementLocated in POM, since we can't use webElements
		omf.getNameObject(object).click();
		omf.getObjectManagerDetail(detail).click();
		omf.getObjectManagerButtonNew().click();
		/*wait.until(ExpectedConditions.presenceOfElementLocated(omf.getNameObjectLocator(object))).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(omf.getObjectManagerDetailLocator(detail))).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(omf.getObjectManagerButtonNewLocator())).click();
		*/
		
	}
}
