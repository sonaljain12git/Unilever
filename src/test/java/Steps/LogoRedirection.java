package Steps;

import Base.BaseUtilities;
import Pages.Home;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class LogoRedirection {

    private final RemoteWebDriver _driver;
    private Home _home;
    SoftAssert softAssert=new SoftAssert();

    public LogoRedirection(BaseUtilities base) {
        this._driver = base._driver;
    }


    @When("verifying logo")
    public void verifying_logo() {
        System.out.println("Verifying the logo on the Page");
        _home=new Home(_driver);
        Assert.assertTrue(_home.IsLogoImageDisplayed());

    }
    @Then("user should be redirected to Home page, if click on logo")
    public void on_click_on_logo_redirected_to_home_page() {
        System.out.println("Verifying the logo redirection");
        _home.ClickOnLogo();

    }
}
