package domain;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Utilities {

	public static String returnLocator(WebElement welement) {
		String locator = "";
		String aux = welement.toString();
		if (aux.contains("selector")) {
			aux = aux.split("selector:")[1];
			locator=aux.substring(1, aux.length()-2);
		} else if (aux.contains("xpath")) {
			aux = aux.split("xpath:")[1];
			locator=aux.substring(1, aux.length()-2);
		}
		return locator;
	}

}
