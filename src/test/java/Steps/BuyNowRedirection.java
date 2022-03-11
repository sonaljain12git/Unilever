package Steps;

import Base.BaseUtilities;
import Pages.Home;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BuyNowRedirection {
    private Home _home;
    private final RemoteWebDriver _driver;
    private String tagUrl;

    public BuyNowRedirection(BaseUtilities base) {
        _driver = base._driver;
    }

    @And("click on Buy Now button")
    public void click_on_buy_now_button() throws InterruptedException {
        _home=new Home(_driver);
        _home.isBestSellingProductSectionDisplayed();
        _home.ClickOnBuyNow();
        Thread.sleep(50);
        System.out.println("BuyNow button is clicked");
    }

    @Then("Find Online popup is displayed")
    public void findOnlinePopupIsDisplayed() {
        Assert.assertTrue("Expected Find online pop up should visible",
                _home.verifyFindOnlinePopup());
    }

    @When("Select the vendor from the list")
    public void select_the_vendor_from_the_list() throws InterruptedException {
        tagUrl= _home.selectVendor();
    }
    @Then("it should redirect to the vendor page")
    public void it_should_redirect_to_the_vendor_page() {

        System.out.println(_driver.getCurrentUrl());
        System.out.println(tagUrl);
        Assert.assertTrue("",_home.getActiveWindow().getCurrentUrl().equalsIgnoreCase(tagUrl));
    }

    @And("click on cross button on popup")
    public void clickOnCrossButtonOnPopup() {
        _home.ClickonCrossBtn();
    }


}
