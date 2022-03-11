package Steps;
import Base.BaseUtilities;
import Pages.Home;
import Pages.Product;
import Pages.ProductListing;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.remote.RemoteWebDriver;
import io.cucumber.java.en.And;

public class ImageRedirectionFromExploreMore {

    private Home _home;
    private ProductListing productListing;
    private RemoteWebDriver _driver;

    public ImageRedirectionFromExploreMore(BaseUtilities base) {
        _driver = base._driver;
    }

    @When("verifying the Explore More section visibility")
    public void verifyingTheExploreMoreSectionVisibility() {
        _home=new Home(_driver);
        _home.IsExploreMoreSectionDisplayed();
    }

    @And("click on Image")
    public void clickOnImage() {
        _driver = _home.ClickOnEditorialCard();
    }

    @Then("user should be redirected to Product Listing page")
    public void userShouldBeRedirectedToProductListingPage() {
        productListing  = new ProductListing(_driver);
        productListing.IsBreadcrumbDisplayed();
        productListing.getBreadcrumb();

    }
}
