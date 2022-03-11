package Pages;

import Utility.Helper;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ProductListing {

    private final RemoteWebDriver driver;

    public ProductListing(RemoteWebDriver _driver) {
        Helper.WaitForPageLoad(_driver, 120);
        PageFactory.initElements(_driver, this);
        driver = _driver;
    }

    @FindBy(css = "div.breadcrumb")
    WebElement Breadcrumb;

    public boolean IsBreadcrumbDisplayed() {
        return Breadcrumb.isDisplayed();
    }

    public void getBreadcrumb() {
        String ActBreadcrumbText = Breadcrumb.getText();
        System.out.println(ActBreadcrumbText);
        String ExpBrdCrmbText = "HomeProductsShampoo";
        Assert.assertEquals("HomeProductsShampoo", ExpBrdCrmbText);
    }

}