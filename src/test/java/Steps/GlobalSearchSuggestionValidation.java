package Steps;

import Base.BaseUtilities;
import Pages.Home;
import Utility.Helper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GlobalSearchSuggestionValidation {
    private final RemoteWebDriver _driver;
    private Home _home;
    private List<String> linkTxt=new ArrayList<String>();
    private int links=0;
    SoftAssert softAssert=new SoftAssert();

    public GlobalSearchSuggestionValidation(BaseUtilities base) {
        this._driver = base._driver;
    }

    @When("try to write and click on search icon")
    public void tryToWriteAndClickOnSearchIcon() throws InterruptedException {
        _home=new Home(_driver);
        //Assert.assertTrue(_home.IsSearchDisplayed());
        //_home.ClickOnSearch();
        _home.writeInSearch("shampoo");

    }

    @Then("search Results should be displayed")
    public void searchResultsShouldBeDisplayed() {
        Assert.assertTrue(_home.IsSearchResultCountTextDisplayed());
        Assert.assertTrue(_home.IsSearchResultListDisplayed());

    }

    @And("if click on search result, user should be redirected to respective page")
    public void ifClickOnSearchResultUserShouldBeRedirectedToRespectivePage() {
        linkTxt =_home.getSearchResultsText();
        links =_home.getSearchResultsLink().size();
        _home.selectAnySearchResult();
        System.out.println(_driver.getCurrentUrl());

    }


}
