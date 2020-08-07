package domain;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {
	WebDriverWait wait;
	public Base(WebDriver driver) {
		wait=new WebDriverWait(driver, Duration.ofSeconds(5));
	}
}
