package constants.setup.objectManager;

public class objectManagerConstants {
	
	
	public static final String objectManagerButtonNew = "//button[text() = 'New']";
	public static final String inputQuickfind = "input#globalQuickfind";
	
	//REPLACEABLE
	public static final String setupTab = "a[title = '$x']";
	//public static final String nameObject = "//a[text() = '$x']";
	public static final String nameObject = "//section[@role='tabpanel']//div[@id='brandBand_3']//div[@id='setupComponent']//div[@class='setupcontent']//a[text()='$x']";
	public static final String objectManagerDetail ="a[data-list = '$x']";
	
	

}
