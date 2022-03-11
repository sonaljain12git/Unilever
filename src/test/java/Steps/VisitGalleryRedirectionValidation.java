package Steps;
import Base.BaseUtilities;
import Pages.Home;
import Pages.OlapicGallery;
import Utility.Helper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;

public class VisitGalleryRedirectionValidation {
    private Home _home;
    private OlapicGallery olapicGallery;
    private RemoteWebDriver _driver;
    private String tagUrl;

    public VisitGalleryRedirectionValidation(BaseUtilities base) {
        _driver = base._driver;
    }

    @When("click on Visit Gallery button")
    public void clickOnVisitGalleryButton() throws InterruptedException {
        _home=new Home(_driver);
        ((JavascriptExecutor) _driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(5);
        _home.IsGallerySliderDisplayed();
       _driver = _home.ClickOnVisitGalleryBtn();
        Thread.sleep(5);
    }

    @Then("Olapic Gallery page is displayed")
    public void OlapicGalleryPageIsDisplayed() {
        olapicGallery = new OlapicGallery(_driver);
        olapicGallery.IsOlapicGalleryPageDisplayed();
        olapicGallery.GetUrl();
    }
}
