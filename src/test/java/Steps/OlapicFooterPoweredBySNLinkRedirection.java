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


public class OlapicFooterPoweredBySNLinkRedirection {
    private RemoteWebDriver _driver;

    public OlapicFooterPoweredBySNLinkRedirection(BaseUtilities base) {
        _driver= base._driver;

    }

    @When("click on Powered By Social Native link which is in Olapic gallery footer")
    public void clickOnPoweredBySocialNativeLinkWhichIsInOlapicGalleryFooter() throws InterruptedException {
        Home _home=new Home(_driver);
        ((JavascriptExecutor) _driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(5);
        _home.IsGallerySliderDisplayed();
        _driver = _home.ClickOnOlapicFooterPoweredBySNLink();
    }


    @Then("Olapic site page is displayed")
    public void OlapicSitePageIsDisplayed() {
        Home _home=new Home(_driver);
        _home.IsOlapicPageDisplayed();
        String OlapicPageURL;
        OlapicPageURL = _driver.getCurrentUrl();
        Assert.assertEquals(OlapicPageURL, "https://www.olapic.com/?utm_source=referral&utm_medium=powered-by-olapic&utm_campaign=nexxusus");
    }


}
