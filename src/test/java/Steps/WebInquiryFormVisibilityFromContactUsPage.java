package Steps;

import Base.BaseUtilities;
import Pages.Home;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

public class WebInquiryFormVisibilityFromContactUsPage {

    private RemoteWebDriver _driver;

    public WebInquiryFormVisibilityFromContactUsPage(BaseUtilities base) {
        _driver = base._driver;
    }

    @And("Click on Web Inquiry Accordion and check the Web Inquiry Form")
    public void click_on_Web_Inquiry_Accordion_and_check_the_Web_Inquiry_Form() throws InterruptedException {
        Home home = new Home(_driver);
        home.ClickOnWebInquiryAccordion();
        home.GetWebInquiryForm();
    }

}