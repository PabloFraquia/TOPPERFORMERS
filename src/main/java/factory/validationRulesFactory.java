package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.setup.objectManager.objectManagerCapabilities.validationRulesConstants;

public class ValidationRulesFactory {
	
	WebDriver driver;

	@FindBy (css = validationRulesConstants.validatioRuleName)private WebElement validatioRuleName;
	@FindBy (css = validationRulesConstants.formulaText)private WebElement formulaText;
	@FindBy (css = validationRulesConstants.validatioMessage)private WebElement validationRuleMessage;
	@FindBy (css = validationRulesConstants.errorFormulaMsg)private WebElement errorFormulaMsg;
	@FindBy (css = validationRulesConstants.errorMessage)private WebElement errorMessage;
	@FindBy (xpath = validationRulesConstants.editButton)private WebElement editButton;
	
	public ValidationRulesFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}

	
	public WebElement getValidatioRuleName() {
		return validatioRuleName;
	}

	public WebElement getFormulaText() {
		return formulaText;
	}

	public WebElement getValidationRuleMessage() {
		return validationRuleMessage;
	}
	

	public WebElement getErrorFormulaMsg() {
		return errorFormulaMsg;
	}


	public WebElement getErrorMessage() {
		return errorMessage;
	}

	public WebElement getEditButton() {
		return editButton;
	}
	
	
	
	
}


