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

public class OlapicFooterTCLinkRedirection {
    private RemoteWebDriver _driver;

    public OlapicFooterTCLinkRedirection(BaseUtilities base) {
        _driver= base._driver;

    }

    @When("click on Term and Conditions link which is in Olapic gallery footer")
    public void clickOnTermAndConditionsLinkWhichIsInOlapicGalleryFooter() throws InterruptedException {
       Home _home=new Home(_driver);
       ((JavascriptExecutor) _driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
       Thread.sleep(5);
       _home.IsGallerySliderDisplayed();
       _driver = _home.ClickOnOlapicFooterTCLink();
    }


    @Then("UGC Policy page is displayed")
    public void ugcPolicyPageIsDisplayed() {
        Home _home=new Home(_driver);
        _home.IsUGCPolicyPageDisplayed();
        String UGCPolicyURL;
        UGCPolicyURL = _driver.getCurrentUrl();
        Assert.assertEquals(UGCPolicyURL, "https://www.unileverus.com/UGCPolicy.html");
    }


}
