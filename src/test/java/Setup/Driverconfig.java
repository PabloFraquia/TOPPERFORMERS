package Setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utility.MainUtility;

public class Driverconfig {

	public static WebDriver getChromeDriverInitializer() {
		
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Executables\\chromedriver.exe");
			System.setProperty("webdriver.chrome.silentOutput", "true");
			WebDriver driver = new ChromeDriver(MainUtility.setOptions());
			return driver;
			
		}

	}

}
