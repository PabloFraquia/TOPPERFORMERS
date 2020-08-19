package domain;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import factory.GlobalFactory;

public class Global {
	protected WebDriverWait wait;
	protected GlobalFactory gf;
	WebDriver driver;
	public Global(WebDriver driver) {
		this.wait=new WebDriverWait(driver, Duration.ofSeconds(15));
		this.gf=new GlobalFactory(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		this.driver = driver;
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
		//wait.until(ExpectedConditions.titleContains(title));

		Wait<WebDriver> fwait = new FluentWait<WebDriver>(driver)
			       .withTimeout(Duration.ofSeconds(20))
			       .pollingEvery(Duration.ofSeconds(5))
			       .ignoring(NoSuchElementException.class);
		
		fwait.until(ExpectedConditions.titleContains(title));
		
	}
}
