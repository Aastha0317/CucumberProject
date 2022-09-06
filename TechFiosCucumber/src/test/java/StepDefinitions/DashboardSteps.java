package StepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import managers.BrowserFactory;
import managers.PageObjectManager;

public class DashboardSteps {
    BrowserFactory browserFactory = new BrowserFactory();
    PageObjectManager pageObjectManager = new PageObjectManager(browserFactory.getDriver());

    @Given("^Set SkyBlue background Button exists$")
    public void verifySkyBlueButton() throws Throwable {
        pageObjectManager.getTechFiosPage().verifySkyBlueBgButton();
    }

    @When("^I click on the button$")
    public void clickOnSkyBlueButton() throws Throwable {
        pageObjectManager.getTechFiosPage().clickOnSkyBlueBgButton();
    }

    @Then("^the background color will change to sky blue$")
    public void verifyBGColorForSkyblue() throws Throwable {
       
        pageObjectManager.getTechFiosPage().verifyBGColorForSkyBlue();
    }

    
    @Given("^Set white background Button exists$")
    public void verifywhiteButton() throws Throwable {
        pageObjectManager.getTechFiosPage().verifyWhiteBgButton();
    }

    @When("^I click on the white button$")
    public void clickOnWhiteButton() throws Throwable {
        pageObjectManager.getTechFiosPage().clickOnWhiteBgButton();
    }

    @Then("^the background color will change to white$")
    public void verifyBGColorForWhite() throws Throwable {
       
        pageObjectManager.getTechFiosPage().verifyBGColorForWhite();
    }

}


