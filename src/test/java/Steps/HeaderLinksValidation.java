package Steps;

import Base.BaseUtilities;
import Utility.Helper;
import Pages.Home;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.asserts.SoftAssert;



public class HeaderLinksValidation {

    private Home _home;
    private List<String> linkTxt=new ArrayList<String>();
    private int links=0;
    private final RemoteWebDriver _driver;
    public HeaderLinksValidation(BaseUtilities base) {
        this._driver= base._driver;
    }

    @Given("The site is Up and Running")
    public void the_site_is_up_and_running() throws ParserConfigurationException, IOException, SAXException {
        Helper.NavigateToUAT(_driver);
        _home=new Home(_driver);
        System.out.println("Given");

    }
    @When("i try to get the header links")
    public void i_try_to_get_the_header_links() {
        System.out.println("When");
        linkTxt=_home.getHeaderLinkText();
        links=_home.getHeaderLink().size();
    }
    @Then("All the header link should load within {int} second")
    public void all_the_header_link_should_load_within_second(Integer timeSecond) {

        SoftAssert softAssert=new SoftAssert();
        System.out.println("Then");
        if(links==0)
            return;
        for (int i=0;i<links;i++) {
            System.out.println(linkTxt);
            long start = System.currentTimeMillis();
            Helper.click(_driver,_home.getHeaderLink().get(i));
            Helper.WaitForPageLoad(_driver,60);
            long finish = System.currentTimeMillis();
            long totalTime = finish - start;
            softAssert.assertTrue(_driver.getCurrentUrl().contains(linkTxt.get(i)),
                    "Expected link should contain the text");
            System.out.println("The Url is "+_driver.getCurrentUrl());
            System.out.println("================");
            System.out.println("The expected Url is "+linkTxt.get(i));
            softAssert.assertTrue((0.001*totalTime) <= timeSecond,"Page should load within " +timeSecond);
            System.out.println("Loading time is ..."+(0.001*totalTime));
        }

    }
}
