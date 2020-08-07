package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.setup.objectManager.objectManagerCapabilities.validationRulesConstants;

public class validationRulesFactory {
	
	WebDriver driver;

	@FindBy (css = validationRulesConstants.validatioRuleName)private WebDriver validatioRuleName;
	@FindBy (css = validationRulesConstants.formulaText)private WebDriver formulaText;
	@FindBy (css = validationRulesConstants.validatioMessage)private WebDriver validationRuleMessage;
	@FindBy (css = validationRulesConstants.errorMessage)private WebDriver errorMessage;
	
	public validationRulesFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}

	public WebDriver getDriver() {
		return driver;
	}

	public WebDriver getValidatioRuleName() {
		return validatioRuleName;
	}

	public WebDriver getFormulaText() {
		return formulaText;
	}

	public WebDriver getValidationRuleMessage() {
		return validationRuleMessage;
	}

	public WebDriver getErrorMessage() {
		return errorMessage;
	}
	
	
}


