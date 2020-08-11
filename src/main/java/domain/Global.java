package domain;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import factory.GlobalFactory;

public abstract class Global {
	protected WebDriverWait wait;
	protected GlobalFactory gf;
	public Global(WebDriver driver) {
		this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		this.gf=new GlobalFactory(driver);
	}
}
