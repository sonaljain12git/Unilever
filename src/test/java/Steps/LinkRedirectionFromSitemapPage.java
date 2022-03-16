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

public class LinkRedirectionFromSitemapPage {
    private RemoteWebDriver _driver;

    public LinkRedirectionFromSitemapPage(BaseUtilities base) {
        _driver = base._driver;
    }

    @And("user click on link which is on Sitemap page")
        public void user_click_on_link_which_is_on_Sitemap_page() throws InterruptedException {
        Home home = new Home(_driver);
        Thread.sleep(10);
        home.ClickOnLinkOnSitemapPage();
        }

    @Then("user should be redirected to correct page")
    public void user_should_be_redirected_to_correct_page() throws InterruptedException {
        Home home = new Home(_driver);
        home.GetLinkRedirectedUrl();
        System.out.println(_driver.getCurrentUrl());
    }
}
