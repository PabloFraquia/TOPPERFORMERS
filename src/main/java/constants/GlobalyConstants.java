package constants;

public class GlobalyConstants {
	
	//AppBox
	public static final String btnSearchAppBox = "*[class = 'slds-icon-waffle']";
	public static final String inputSearchAppBox = "//*[@class = 'slds-input']";
	
	//FANTASTIC SOLUTION FOR WAITING THE SPINNER
	public static final String spinner = "//div[contains(@class, 'forceListViewManagerPrimaryDisplayManager')]/div[contains(@class,'slds-spinner_container')]";
	
	//GLOBAL ACTIONS BUTTONS
	public static final String btnSetup = "//*[@data-key = 'setup']";
	
	// OTHER BUTTONS
	public static final String btnCancel = "//div[contains(@class,'button-container-inner')]/button/span[text()='Cancel']/parent::button";
	public static final String btnSaveAndNew = "//div[contains(@class,'button-container-inner')]/button/span[text()='Save & New']/parent::button";

}
