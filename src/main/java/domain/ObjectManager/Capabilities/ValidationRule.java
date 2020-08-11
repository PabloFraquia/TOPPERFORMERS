package domain.ObjectManager.Capabilities;

import org.openqa.selenium.WebDriver;

import domain.Global;
import factory.ValidationRulesFactory;

public class ValidationRule extends Global {
	
	ValidationRulesFactory vf;
	public ValidationRule(WebDriver driver) {
		super(driver);
		vf = new ValidationRulesFactory(driver);
	}
	
	
	
	public void validationRuleConstruction(String name, String formula, String message) {
		
		vf.getValidatioRuleName().sendKeys(name);
		vf.getFormulaText().sendKeys(formula);
		vf.getValidatioRuleName().sendKeys(message);
		this.gf.getSaveButton().click();	
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
