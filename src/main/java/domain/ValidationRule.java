package domain;

import org.openqa.selenium.WebDriver;

import factory.GlobalFactory;
import factory.ObjectManagerFactory;
import factory.ValidationRulesFactory;

public class ValidationRule extends Base {
	
	ValidationRulesFactory vf;
	GlobalFactory gf;
	ObjectManagerFactory of;
	
	public ValidationRule(WebDriver driver) {
		super(driver);
		vf = new ValidationRulesFactory(driver);
		gf = new GlobalFactory(driver);
		of = new ObjectManagerFactory(driver);
	}
	
	public void goToValidationRules(String tab, String object, String detail) {
		of.getSetupTab(tab).click();
		of.getNameObject(object).click();
		of.getObjectManagerDetail(detail).click();
		
	}
	
	public void validationRuleConstruction(String name, String formula, String message) {
		of.getObjectManagerButtonNew().click();
		vf.getValidatioRuleName().sendKeys(name);
		vf.getFormulaText().sendKeys(formula);
		vf.getValidatioRuleName().sendKeys(message);
		gf.getSaveButton().click();	
	}
	
	public boolean checkErrorDisplay() {
		return vf.getErrorMessage().isDisplayed();
	}
	
	public boolean checkFormulaError() {
		return vf.getErrorFormulaMsg().isDisplayed();
	}
	
	public boolean checkEditButton() {
		return vf.getEditButton().isDisplayed();
	}
	
}
