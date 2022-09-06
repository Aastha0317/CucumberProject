package StepDefinitions;


import org.openqa.selenium.WebDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import managers.BrowserFactory;


public class Hooks {
    BrowserFactory browserFactory = new BrowserFactory();
    WebDriver driver;
  
    @Before
    public void beforeScenario() {
        driver=browserFactory.createDriver();
        driver.get("https://techfios.com/test/101/");
        driver.manage().window().maximize();
    }
   @After
    public void afterScenario() {
        browserFactory.closeDriver();
    }
}