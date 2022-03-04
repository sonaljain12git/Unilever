package Steps;

import Base.BaseUtilities;
import Pages.Home;
import Pages.Signup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

public class SignupSteps {

    private Signup signUp;
    private RemoteWebDriver _driver;
    public SignupSteps(BaseUtilities base) {

        _driver= base._driver;
    }

    @And("navigate to signup page")
    public void navigate_to_signup_page() throws InterruptedException {
        Home _home = new Home(_driver);
        _driver= _home.NavSignUp();
    }
    @When("enter all the details and submit")
    public void enter_all_the_details_and_submit() {
        signUp=new Signup(_driver);
        signUp.SignUpWithDetails("sadhu","sahab","sadhu@gmail.com", "11051980");
    }
    @Then("it should submit and redirect to thank you page.")
    public void it_should_submit_and_redirect_to_thankYou_page() {
        Assert.assertTrue(signUp.ThankYouMessageDisplay());
    }

    @When("enter all the details except name and submit")
    public void enter_all_the_details_except_name_and_submit() {
        signUp=new Signup(_driver);
        signUp.SignUpWithDetails("","sahab","sadhu1@gmail.com", "11051980");
    }
    @Then("it should display validation message with respect to name")
    public void it_should_display_validation_message_with_respect_to_name() {
        Assert.assertTrue(signUp.ValidationForNameDisplay());
    }
}
