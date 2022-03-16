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

public class TermsOfUseLinkRedirectionSteps {
    private RemoteWebDriver _driver;

    public TermsOfUseLinkRedirectionSteps(BaseUtilities base) {
        _driver= base._driver;
    }

    @When("user click on Footer link Terms of use")
    public void user_click_on_Footer_link_Terms_of_use() throws InterruptedException {
        Home home = new Home(_driver);
        home.IsFooterDisplayed();
        home.ClickOnTermsOfUseLink();
        Thread.sleep(5);
    }

    @Then("Terms Of Use page should be opened into new tab")
    public void terms_of_use_page_should_be_opened_into_new_tab() throws InterruptedException {
        Thread.sleep(10);
        Home home = new Home(_driver);
        home.IsTermsOfUsePageDisplayed();

    }

}




