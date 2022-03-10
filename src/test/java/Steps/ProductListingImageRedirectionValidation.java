package Steps;

import Base.BaseUtilities;
import Pages.Home;
import Pages.PDP;
import Pages.Product;
import Pages.Signup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.bouncycastle.asn1.cms.Time;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

public class ProductListingImageRedirectionValidation {

    private Product product;
    private PDP pdp;
    private RemoteWebDriver _driver;
    public ProductListingImageRedirectionValidation(BaseUtilities base) {

        _driver= base._driver;
    }

    @And("click on Product image in Product Listing Section")
    public void clickOnProductImageInProductListingSection() {
        product = new  Product(_driver);
        product.IsProductListingItemsDisplayed();
        _driver = product.ClickOnAnyProductImage();

    }


    @Then("Product Image should be redirected to PDP Page")
    public void productImageShouldBeRedirectedToPDPPage() {
        pdp = new PDP(_driver);
        pdp.IsProductSummarySectionDisplayed();

    }
}
