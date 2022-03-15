package Steps;
import Base.BaseUtilities;
import Pages.Home;
import Pages.Product;
import Pages.Signup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.bouncycastle.asn1.cms.Time;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

public class FAQLinkRedirectionSteps {
    private RemoteWebDriver _driver;

    public FAQLinkRedirectionSteps(BaseUtilities base) {
        _driver= base._driver;
    }

    @When("user click on Footer link FAQ")
    public void userClickOnFooterLinkFAQ() throws InterruptedException {
        Home home = new Home(_driver);
        home.IsFooterDisplayed();
        home.ClickOnFAQLink();
        Thread.sleep(5);
    }

    @Then("FAQ page should be displayed")
    public void faqPageShouldBeDisplayed() throws InterruptedException {
        Thread.sleep(10);
        Home home = new Home(_driver);
        home.IsFAQPageDisplayed();
        Thread.sleep(10);
    }

    @And("Click on last Accordion and click on Contact us link")
    public void clickOnLastAccordionAndClickOnContactUsLink() throws InterruptedException {
        Thread.sleep(10);
        Home home = new Home(_driver);
        home.ClickOnLastAccordionOnFAQ();
        home.ClickOnContactUsLinkInFAQAccordion();
    }
}
