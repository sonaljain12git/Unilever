package Steps;
import Base.BaseUtilities;
import Pages.Home;
import Utility.Helper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;


public class OlapicGalleryCarouselValidation {
    private RemoteWebDriver _driver;

    public OlapicGalleryCarouselValidation(BaseUtilities base){
        _driver= base._driver;


    }
    @When("Gallery displayed then click on next arrow")
    public void clickOnNextArrow() throws InterruptedException {
        Home home = new Home(_driver);
        Thread.sleep(5);
        home.IsGallerySliderDisplayed();
        Thread.sleep(5);
        home.IsNextArrowDisplayed();
        home.ClickOnNextArrow();

    }

    @And("Last image got changed")
    public void GetLastImage(){
        Home home = new Home(_driver);
        home.IsNextImageChanged();
    }

    @Then("click on previous arrow")
    public void clickOnPreviousArrow() {
        Home home = new Home(_driver);
        home.IsPreviousArrowDisplayed();
        home.ClickOnPreviousArrow();
    }


    @And("Previous image got changed")
    public void GetPreviousImage(){
        Home home = new Home(_driver);
        home.IsPreviousImageChanged();
    }
}
