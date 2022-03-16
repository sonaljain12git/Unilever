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

public class PrivacyPolicyLinkRedirectionSteps {
    private RemoteWebDriver _driver;

    public PrivacyPolicyLinkRedirectionSteps(BaseUtilities base) {
        _driver= base._driver;
    }

    @When("user click on Footer link Privacy Policy")
    public void user_click_on_Footer_link_Privacy_Policy() throws InterruptedException {
        Home home = new Home(_driver);
        home.IsFooterDisplayed();
        home.ClickOnPrivacyPolicyLink();
        Thread.sleep(5);
    }

    @Then("Privacy Policy page should be opened into new tab")
    public void privacy_policy_page_should_be_opened_into_new_tab() throws InterruptedException {
        Thread.sleep(10);
        Home home = new Home(_driver);
        home.IsPrivacyPolicyPageDisplayed();

    }

}


