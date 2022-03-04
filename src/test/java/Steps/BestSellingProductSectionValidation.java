package Steps;

import Base.BaseUtilities;
import Pages.Home;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BestSellingProductSectionValidation {

    private Home _home;
    private final RemoteWebDriver _driver;

    public BestSellingProductSectionValidation(BaseUtilities base) {
        _driver = base._driver;
    }

    @When("verifying the best selling product section visibility")
    public void verifying_the_best_selling_product_section() {
        _home=new Home(_driver);
        _home.isBestSellingProductSectionDisplayed();
    }
    @Then("arrows should be working as expected")
    public void arrows_should_be_working_as_expected() throws InterruptedException {
        _home.verifyProductCarouselRotation();
    }

}
