package Setup;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


public class Driverconfig {

	public enum Browser {
		FIREFOX, CHROME, MICROSOFTEDGE
	}

	
	public static WebDriver getDriverInitializer(String browserName) {
		WebDriver driver = null;
		browserName = browserName.toUpperCase();
		Browser browser = Browser.valueOf(browserName);
		
		switch(browser) {
		
		case FIREFOX:
			driver = getFirefoxDriver();
				break;
		case CHROME:
			driver = getChromeDriver();
				break;
		case MICROSOFTEDGE:
			driver = getMicrosoftEdgeDriver();
				break;
		
		}
		return driver;
	}


	private static WebDriver getChromeDriver() {
		
		ChromeOptions options = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.notifications", 2);
		options.setExperimentalOption("prefs", prefs);
		
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/test/resources/drivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		WebDriver driver = new ChromeDriver(options);
		
		return driver;

	}


	private static WebDriver getFirefoxDriver() {
		
		 FirefoxOptions options = new FirefoxOptions();
		 options.addPreference("dom.webnotifications.enabled",false);
		
		System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"/src/test/resources/drivers/geckodriver.exe");
		System.setProperty("webdriver.gecko.silentOutput", "true");
		WebDriver driver = new FirefoxDriver(options);
		
		return driver;

	}
	
	private static WebDriver getMicrosoftEdgeDriver() {
		
		HashMap<String, Object> edgePrefs = new HashMap<String, Object>();
		edgePrefs.put("profile.default_content_settings.popups", 0);
		edgePrefs.put("profile.default_content_setting_values.notifications", 2);		
		edgePrefs.put("profile.default_content_setting_values.automatic_downloads" , 1);		
		edgePrefs.put("profile.content_settings.pattern_pairs.*,*.multiple-automatic-downloads",1);
		
		EdgeOptions options = new EdgeOptions();
		options.setExperimentalOption("prefs",edgePrefs);
		
		
		System.setProperty("webdriver.edge.driver",System.getProperty("user.dir")+"/src/test/resources/drivers/msedgedriver.exe");
		System.setProperty("webdriver.edge.silentOutput", "true");
		WebDriver driver = new EdgeDriver(options);
		
		return driver;

	}
	
}


