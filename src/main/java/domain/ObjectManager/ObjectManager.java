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
		omf.getNameObject(object).click();
		omf.getObjectManagerDetail(detail).click();
		omf.getObjectManagerButtonNew().click();
		
	}
}
