package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.setup.objectManager.objectManagerCapabilities.validationRulesConstants;

public class ValidationRulesFactory {
	
	WebDriver driver;

	@FindBy (xpath = validationRulesConstants.validatioRuleName)private WebElement validatioRuleName;
	@FindBy (css = validationRulesConstants.formulaText)private WebElement formulaText;
	@FindBy (css = validationRulesConstants.validatioMessage)private WebElement validationRuleMessage;
	@FindBy (css = validationRulesConstants.errorFormulaMsg)private WebElement errorFormulaMsg;
	@FindBy (css = validationRulesConstants.ErrorInvalidData)private WebElement errorInvalidData;
	@FindBy (xpath = validationRulesConstants.editButton)private WebElement editButton;
	
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
	
	
	
	
}


