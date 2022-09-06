package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import junit.framework.Assert;
import utilities.BaseTest;

public class TechfiosPage extends BaseTest {

	WebDriver driver;

	public TechfiosPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@onclick='myFunctionSky()']")
	private WebElement setBlueSkyBgButton;

	@FindBy(xpath = "//button[@onclick='myFunctionWhite()']")
	private WebElement setWhiteSkyBgButton;

	@FindBy(xpath = "//body")
	private WebElement backgroundColor;

	public void verifySkyBlueBgButton() throws InterruptedException {
		Assert.assertTrue(isElementDisplayed(setBlueSkyBgButton, "sky blue bg button"));
	}

	public void clickOnSkyBlueBgButton() {

		clickElement(setBlueSkyBgButton, "set sky blue bg button");
	}

	public void verifyWhiteBgButton() throws InterruptedException {
		isElementDisplayed(setWhiteSkyBgButton, "White bg button");
	}

	public void clickOnWhiteBgButton() {

		clickElement(setWhiteSkyBgButton, "set sky blue bg button");
	}
	
	public void verifyBGColorForSkyBlue() throws InterruptedException {

		verifyAttribute(backgroundColor, "style", "skyblue", "verify sky blue color");
		Thread.sleep(5000);
	}
	
	public void verifyBGColorForWhite() throws InterruptedException {
       
		verifyAttribute(backgroundColor, "style", "white", "verify white color");
	    Thread.sleep(5000);
	}

}
