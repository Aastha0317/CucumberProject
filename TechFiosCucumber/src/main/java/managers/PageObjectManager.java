package managers;

import org.openqa.selenium.WebDriver;
import pageObjects.TechfiosPage;

public class PageObjectManager {
	private WebDriver driver;
	private TechfiosPage techFiosPage;

	public PageObjectManager(WebDriver driver) {

		this.driver = driver;

	}

	public TechfiosPage getTechFiosPage() {

		return (techFiosPage == null) ? techFiosPage = new TechfiosPage(driver) : techFiosPage;

	}

}
