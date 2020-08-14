package factory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.setup.objectManager.objectManagerCapabilities.validationRulesConstants;

public class ValidationRulesFactory {
	
	WebDriver driver;

	@FindBy (xpath = validationRulesConstants.validatioRuleName)private WebElement inputValidatioRuleName;
	@FindBy (css = validationRulesConstants.formulaText)private WebElement inputFormulaText;
	@FindBy (css = validationRulesConstants.validatioMessage)private WebElement inputValidationRuleMessage;
	@FindBy (css = validationRulesConstants.errorFormulaMsg)private WebElement errorFormulaMsg;
	@FindBy (css = validationRulesConstants.ErrorInvalidData)private WebElement errorInvalidData;
	@FindBy (xpath = validationRulesConstants.editButton)private WebElement editButton;
	@FindBy (xpath = validationRulesConstants.backToValidatioRule)private WebElement backToValidationRuleLink;
	@FindBy (css = validationRulesConstants.dropDownArrow)private WebElement dropDownArrow;
	@FindBy (css = validationRulesConstants.selectDelete)private WebElement selectDelete;
	@FindBy (xpath = validationRulesConstants.buttonDelete)private WebElement buttonDelete;
	
	public ValidationRulesFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}

	public WebElement getInputValidatioRuleName() {
		return inputValidatioRuleName;
	}

	public WebElement getInputFormulaText() {
		return inputFormulaText;
	}

	public WebElement getInputValidationRuleMessage() {
		return inputValidationRuleMessage;
	}

	public WebElement getErrorFormulaMsg() {
		return errorFormulaMsg;
	}

	public WebElement getErrorInvalidData() {
		return errorInvalidData;
	}

	public WebElement getEditButton() {
		return editButton;
	}

	public WebElement getBackToValidationRuleLink() {
		return backToValidationRuleLink;
	}

	public WebElement getDropDownArrow() {
		return dropDownArrow;
	}

	public WebElement getSelectDelete() {
		return selectDelete;
	}
	
	public By getDropDownArrowLocator() {
		return By.cssSelector(validationRulesConstants.dropDownArrow);
	}

	public WebElement getButtonDelete() {
		return buttonDelete;
	}
	
}


