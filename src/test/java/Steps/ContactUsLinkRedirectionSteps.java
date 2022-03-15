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

public class ContactUsLinkRedirectionSteps {
    private RemoteWebDriver _driver;

    public ContactUsLinkRedirectionSteps(BaseUtilities base) {
        _driver= base._driver;
    }

    @When("user click on Footer link Contact us")
    public void userClickOnFooterLinkContactUs() throws InterruptedException {
        Home home = new Home(_driver);
        home.IsFooterDisplayed();
        home.ClickOnContactUsLink();
        Thread.sleep(5);
    }

    @Then("Contact us page should be displayed")
    public void contactUsPageShouldBeDisplayed() throws InterruptedException {
        Thread.sleep(10);
        Home home = new Home(_driver);
        home.IsContactUsPageDisplayed();

    }
}
