package domain.ObjectManager.Capabilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import domain.Global;
import domain.Utilities;
import factory.ValidationRulesFactory;

public class ValidationRule extends Global {
	ValidationRulesFactory vf;
	WebDriver driver;
	public ValidationRule(WebDriver driver) {
		super(driver);
		vf = new ValidationRulesFactory(driver);
		this.driver=driver;
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
		waitForTitle("Object Manager");
		System.out.println(driver.getTitle());
		wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("iframe")));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
		return vf.getEditButton().isDisplayed();
	}
	
	public void deleteValidationRule() {
		vf.getBackToValidationRuleLink().click();
		driver.switchTo().defaultContent();
		wait.until(ExpectedConditions.presenceOfElementLocated(vf.getDropDownArrowLocator()));
		vf.getDropDownArrow().click();
		vf.getSelectDelete().click();
		vf.getButtonDelete().click();
	}
	

	public String returnWebElement() {
		return Utilities.returnLocator(vf.getInputValidatioRuleName());
		}
	
}
