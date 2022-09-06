package utilities;

import managers.BrowserFactory;
import managers.FrameworkException;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class BaseTest {
	BrowserFactory browserFactory = new BrowserFactory();
	WebDriver driver = browserFactory.createDriver();
	public WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));

	public void sendText(WebElement element, String text, String elementName) {

		waitTill(element, "visible");
		element.sendKeys(text);

	}

	public void clickElement(WebElement element, String buttonName) {
		try {
			waitTill(element, "enable");

			element.click();

		} catch (Exception e) {

			throw new FrameworkException("Unknown exception occured while click on: " + buttonName + "---"
					+ e.getClass() + "---" + e.getMessage());
		}

	}

	public boolean isElementDisplayed(WebElement element, String elementName) {

		try {
			wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(element));
			return true;
		} catch (Exception e) {

			return false;
		}

	}

	public void waitTill(WebElement element, String state) {

		switch (state.toLowerCase()) {
		case "visible":

			wait.until(ExpectedConditions.visibilityOf(element));
			break;
		case "enable":
			wait.until(ExpectedConditions.elementToBeClickable(element));
			break;
		case "invisible":
			wait.until(ExpectedConditions.invisibilityOf(element));
			break;
		default:
			wait.until(ExpectedConditions.visibilityOf(element));
		}

	}

	public void selectValuefromDropdown(WebElement dropdown, String selectBy, String value) {

		Select select = new Select(dropdown);
		if (selectBy.toLowerCase().contains("value")) {
			select.selectByVisibleText(value);
		} else if (selectBy.toLowerCase().contains("index")) {
			select.selectByIndex(Integer.valueOf(value));
		}

	}

	/*
	 * public static String getText(WebElement element) { String Text =
	 * element.getText(); return Text; }
	 */

	/*
	 * public void veriyTextInList(List<WebElement> list, String element) { try {
	 * wait.until(ExpectedConditions.visibilityOfAllElements(list)); for (WebElement
	 * el : list) { if (el.getText().trim().equals(element)) {
	 * System.out.println("Passed"); } } } catch (Exception e) { throw new
	 * FrameworkException("Unknown exception occured while verifying list for: " +
	 * element + "---" + e.getClass() + "---" + e.getMessage()); } }
	 */

	public void verifyAttribute(WebElement element, String attributeDesc, String value, String desc) {
		try {
			System.out.println(element.getAttribute(attributeDesc).toLowerCase());
			element.getAttribute(attributeDesc).toLowerCase().replace(" ", "").replaceAll("\u00a0", "")
					.replaceAll("&nbsp", "")
					.contains(value.toLowerCase().replace(" ", "").replaceAll("\u00a0", "").replaceAll("&nbsp", ""));
		}

		catch (Exception e) {
			throw new FrameworkException("Value to be matched of attribute can not be Null for: " + desc);
		}
	}
}