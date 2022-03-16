package Steps;

import Base.BaseUtilities;
import Pages.Home;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class VerifyWebInquiryContactUsForm {

    private RemoteWebDriver _driver;
    SoftAssert softAssert = new SoftAssert();

    public VerifyWebInquiryContactUsForm(BaseUtilities base) {
        this._driver = base._driver;
    }


    @And("Fill the data in form and click on Contact Us button{},{},{},{},{},{} and {}")
    public void Fill_the_data_in_form_and_click_on_Contact_Us_button(String firstname, String lastname,
                                                                     String email, String streetAddress1,
                                                                     String City, String postalCode, String comments) throws InterruptedException {
        Home home = new Home(_driver);
        home.EnterTextDetails(firstname, lastname, email, streetAddress1, City);
        home.SelectState("AK");
        home.EnterPostalCode(postalCode);
        home.SelectLanguage("en");
        home.SelectInquiryType("Product Question");
        home.EnterComment(comments);
        home.ClickOnCaptchaCheckbox();

    }

    @Then("user should get message based on {} Criteria")
    public void user_should_get_message_based_on_valid(String Criteria) {
        switch (Criteria) {
            case "Valid":
                Home home = new Home(_driver);
                home.setValid(true);
                home.ClickOnSubmitButton();
                home.clickConfirm();
                Assert.assertTrue(home.VerifySuccessContactUS());
                System.out.println(home.getMessage());
                break;

            default:
                System.out.println("No Criteria");

        }
    }
}
