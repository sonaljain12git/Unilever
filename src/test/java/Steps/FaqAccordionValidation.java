package Steps;

import Base.BaseUtilities;
import Pages.Home;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

public class FaqAccordionValidation {

    private RemoteWebDriver _driver;

    public FaqAccordionValidation(BaseUtilities base) {
        _driver = base._driver;
    }

    @When("i try to click on + icon")
    public void i_try_to_click_on_icon() {
        Home home = new Home(_driver);
        home.selectFAQAns();
    }

    @Then("the answer should be visible")
    public void the_answer_should_be_visible() {
        Home home = new Home(_driver);
        Assert.assertTrue(home.isAnswerDisplay());
    }

    @When("i try to click on cross * icon")
    public void i_try_to_click_on_cross_icon() {
        Home home = new Home(_driver);
        home.clickCrossMark();
    }

    @Then("the answer should be hidden again")
    public void the_answer_should_be_hidden_again() {
        Home home = new Home(_driver);
        Assert.assertFalse(home.isAnswerDisplay());
    }
}

