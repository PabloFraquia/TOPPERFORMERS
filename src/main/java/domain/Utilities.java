package domain;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Utilities {

	public static String returnLocator(WebElement welement) {
		String locator = "";
		String aux = welement.toString();
		if (aux.contains("selector")) {
			locator = aux.substring(aux.indexOf("selector:"), aux.length() - 2);
		} else if (aux.contains("xpath")) {
			locator = aux.substring(aux.indexOf("xpath:"), aux.length() - 2);

		}
		return locator;
	}

}
