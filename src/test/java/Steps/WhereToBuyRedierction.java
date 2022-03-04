package Steps;

import Base.BaseUtilities;
import Pages.Home;
import Pages.Product;
import Pages.Signup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

public class WhereToBuyRedierction {

    private Product product;
    private RemoteWebDriver _driver;
    public WhereToBuyRedierction(BaseUtilities base) {

        _driver= base._driver;
    }

    @When("User try to click on Where to Buy link")
    public void userTryToClickOnWhereToBuyLink() {
        Home _home = new Home(_driver);
        _driver= _home.ClickOnWhereToBuyLink();

    }

    @Then("user should be redirected to Products page")
    public void userShouldBeRedirectedToProductsPage() {
        product=new Product(_driver);
        Assert.assertTrue(product.IsProductPageTitleDisplayed());

    }
}
