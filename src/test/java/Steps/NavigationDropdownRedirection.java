package Steps;

import Base.BaseUtilities;
import Pages.Home;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;


public class NavigationDropdownRedirection {

    private final RemoteWebDriver _driver;
    private Home _home;
    SoftAssert softAssert = new SoftAssert();
    private List<String> SubmenuLinktext = new ArrayList<String>();
    private int SubmenuLinks = 0;


    public NavigationDropdownRedirection(BaseUtilities base) {
        this._driver = base._driver;
    }

    @When("Navigation item having dropdown and user click on it")
    public void verifying_Navigation_with_dropdown() {
        System.out.println("Verifying the navigation with dropdown");
        _home=new Home(_driver);
        Assert.assertTrue(_home.IsdropdownArrowDisplayed());
        _home.ClickOnDropdownArrow();
    }

    @Then("Submenu items should be visible and clickable")
    public void verifying_submenu_visibility() {
        System.out.println("Verifying the submenu items presence");
        Assert.assertTrue(_home.IsSubmenusDisplayed());
        SubmenuLinktext=_home.getSubmenuLinkText();
        SubmenuLinks=_home.getSubmenuLink().size();
        System.out.println(SubmenuLinktext);
        _home.ClickOnSubmenuLinkInProducts();
        Assert.assertTrue(_home.IsShampooPageDisplayed());
        System.out.println(_driver.getCurrentUrl());
        System.out.println("Submenu items should be redirected to correct page");


    }



}