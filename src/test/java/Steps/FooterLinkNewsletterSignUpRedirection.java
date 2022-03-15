package Steps;

import Base.BaseUtilities;
import Pages.Home;
import Pages.Product;
import Pages.Signup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.bouncycastle.asn1.cms.Time;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;


public class FooterLinkNewsletterSignUpRedirection {
    private RemoteWebDriver signUp;
    private RemoteWebDriver _driver;

    public FooterLinkNewsletterSignUpRedirection(BaseUtilities base) {
        _driver= base._driver;

    }

    @When("user click on Footer link Newsletter Sign Up link")
    public void userClickOnFooterLinkNewsletterSignUpLink() {
        Home home = new Home(_driver);
        home.IsFooterDisplayed();
        signUp = home.ClickOnNewsletterSignUpLink();
    }


}
