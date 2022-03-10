package Steps;

import Base.BaseUtilities;
import Pages.Home;
import Pages.Product;
import Pages.Signup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.bouncycastle.asn1.cms.Time;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

public class ProductListingPageTemplateValidation {

    private Product product;
    private RemoteWebDriver _driver;
    public ProductListingPageTemplateValidation(BaseUtilities base) {

        _driver= base._driver;
    }

    @When("navigate to Product Listing page")
    public void navigateToProductListingPage() {
        Home _home = new Home(_driver);
        _driver= _home.ClickOnWhereToBuyLink();
    }

    @Then("all components should be displayed on Product Listing page")
    public void allComponentsShouldBeDisplayedOnProductListingPage() throws InterruptedException {
        product=new Product(_driver);
        product.IsProductPageTitleDisplayed();
        product.IsBreadcrumbDisplayed();
        product.getBreadcrumb();
        product.IsFilterSectionDisplayed();
        product.IsProductListingItemsDisplayed();
        product.IsProductListingItemsDisplayedWithRating();
        product.IsProductListingItemsDisplayedWithBuyNow();
        product.IsGallerySectionDisplayed();

    }


}
