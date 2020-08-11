package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.GlobalConstants;

public class GlobalFactory {

	@FindBy(css = GlobalConstants.btnSearchAppBox)private WebElement btnSearchAppBox;
	@FindBy(css = GlobalConstants.inputSearchAppBox)private WebElement inputSearchAppBox;
	@FindBy(css = GlobalConstants.btnSetup)private WebElement btnSetup;
	@FindBy(css = GlobalConstants.selectSetup)private WebElement selectSetup;
	@FindBy(css = GlobalConstants.selectServiceSetup)private WebElement selectServiceSetup;
	@FindBy(css = GlobalConstants.selectDeveloperConsole)private WebElement selectDeveloperConsole;

	@FindBy(xpath = GlobalConstants.saveAndNewButton)private WebElement saveAndNewButton;
	@FindBy(xpath = GlobalConstants.saveButton)private WebElement saveButton;
	@FindBy(xpath = GlobalConstants.cancelButton)private WebElement cancelButton;
	//WAIT FOR ELEMENTS
	@FindBy(css = GlobalConstants.spinner)private WebElement spinner;
	@FindBy(xpath = GlobalConstants.workspace)private WebElement workspace;

	
	
	public GlobalFactory(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getBtnSearchAppBox() {
		return btnSearchAppBox;
	}

	public WebElement getInputSearchAppBox() {
		return inputSearchAppBox;
	}

	public WebElement getSpinner() {
		return spinner;
	}

	public WebElement getBtnSetup() {
		return btnSetup;
	}

	public WebElement getSelectSetup() {
		return selectSetup;
	}

	public WebElement getSelectServiceSetup() {
		return selectServiceSetup;
	}

	public WebElement getSelectDeveloperConsole() {
		return selectDeveloperConsole;
	}

	public WebElement getSaveAndNewButton() {
		return saveAndNewButton;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getCancelButton() {
		return cancelButton;
	}

	public WebElement getWorkspace() {
		return workspace;
	}

	
}
