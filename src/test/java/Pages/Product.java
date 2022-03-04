package Pages;

import Utility.Helper;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Product {

    private final RemoteWebDriver driver;

    public Product(RemoteWebDriver _driver) {
        Helper.WaitForPageLoad(_driver, 120);
        PageFactory.initElements(_driver, this);
        driver = _driver;
    }

    @FindBy(css = "h1.c-page-header__title")
    WebElement ProductsPageTitle;

    public boolean IsProductPageTitleDisplayed() {
        return ProductsPageTitle.isDisplayed();

    }
}
