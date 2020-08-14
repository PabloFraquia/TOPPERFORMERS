package domain;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import factory.HomeFactory;

public class Home extends Global {
	private HomeFactory hf;
	public Home(WebDriver driver) {
		super(driver);
		hf=new HomeFactory(driver);
	}

	public void waitForHomeLoading() {
		this.wait.until(ExpectedConditions.visibilityOf(hf.getImgContainer()));
	}
}
