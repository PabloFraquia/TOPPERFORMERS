package domain.ObjectManager.Capabilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import domain.Global;
import factory.ValidationRulesFactory;

public class ValidationRule extends Global {
	ValidationRulesFactory vf;
	public ValidationRule(WebDriver driver) {
		super(driver);
		vf = new ValidationRulesFactory(driver);
	}
	
	
	
	public void validationRuleConstruction(String name, String formula, String message) {
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("iframe")));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
		vf.getInputValidatioRuleName().sendKeys(name);
		vf.getInputFormulaText().sendKeys(formula);
		vf.getInputValidationRuleMessage().sendKeys(message);
		this.gf.getSaveButton().click();
	}
	
	public String checkErrorDisplay() {
		return vf.getErrorFormulaMsg().getText();
	}
	
	public String checkFormulaError() {
		return vf.getErrorFormulaMsg().getText();
	}
	
	public boolean checkEditButton() {
		return vf.getEditButton().isDisplayed();
	}
	
}
