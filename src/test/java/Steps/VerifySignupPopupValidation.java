package Steps;

import Base.BaseUtilities;
import Pages.Home;
import Pages.Signup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

public class VerifySignupPopupValidation {

    private Signup signUp;
    private RemoteWebDriver _driver;

    public VerifySignupPopupValidation(BaseUtilities base) {

        _driver= base._driver;
    }

    @When("SignUp popup is visible")
    public void SignUp_popup_is_visible() {
        Home _home = new Home(_driver);
        _home.IsSignUpPopupDisplayed();
    }

    @And("enter email and click on Continue button")
    public void enterEmailAndClickOnContinueButton() {
        Home _home = new Home(_driver);
        _home.EnterEmail("sadhu1@gmail.com");
        _home.ClickOnContinueButton();

    }

    @Then("Signup page and Signup form should on displayed")
    public void signupPageAndSignupFormShouldOnDisplayed() {
        signUp = new Signup(_driver);
        signUp.IsSignUpPageTitleDisplayed();
    }
}

