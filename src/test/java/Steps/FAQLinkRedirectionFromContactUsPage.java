package Steps;

import Base.BaseUtilities;
import Pages.Home;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

public class FAQLinkRedirectionFromContactUsPage {

    private RemoteWebDriver _driver;

    public FAQLinkRedirectionFromContactUsPage(BaseUtilities base) {
        _driver = base._driver;
    }

    @And("Click on FAQ Accordion and click on FAQ link")
    public void click_on_FAQ_Accordion_and_click_on_FAQ_link() throws InterruptedException {
        Home home = new Home(_driver);
        home.ClickOnFAQAccordion();
        Thread.sleep(5);
        home.ClickOnFAQLnkInAccordion();
        home.GetFirstFAQAccordionText();
    }

}