package domain;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import factory.GlobalFactory;

public class Global {
	protected WebDriverWait wait;
	protected GlobalFactory gf;
	public Global(WebDriver driver) {
		this.wait=new WebDriverWait(driver, Duration.ofSeconds(15));
		this.gf=new GlobalFactory(driver);
	}
	
	public void waitForSpinner() {
		wait.until(ExpectedConditions.attributeContains(gf.getSpinner(), "class", "hidden"));
	}
	public void waitForWorkspace() {
		wait.until(ExpectedConditions.not(ExpectedConditions.attributeContains(gf.getWorkspace(), "class", "active")));
	}

	public void cancelValidationRule() {
		gf.getCancelButton().click();
		
	}
	public void waitForTitle(String title) {
		wait.until(ExpectedConditions.titleContains(title));
	}
}
