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

public class SitemapLinkRedirectionSteps {
    private RemoteWebDriver _driver;

    public SitemapLinkRedirectionSteps(BaseUtilities base) {
        _driver= base._driver;
    }

    @When("user click on Footer link Sitemap")
    public void user_click_on_Footer_link_Sitemap() throws InterruptedException {
        Home home = new Home(_driver);
        home.IsFooterDisplayed();
        home.ClickOnSitemapLink();
        Thread.sleep(5);
    }

    @Then("Sitemap page should be displayed")
    public void Sitemap_page_should_be_displayed() throws InterruptedException {
        Thread.sleep(10);
        Home home = new Home(_driver);
        home.IsSitemapPageDisplayed();
        Thread.sleep(10);
    }

}
