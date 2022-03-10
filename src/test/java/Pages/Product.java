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

    @FindBy(css = "div.breadcrumb")
    WebElement Breadcrumb;

    public boolean IsBreadcrumbDisplayed() {
        return Breadcrumb.isDisplayed();
    }

    public void getBreadcrumb() {
        String ActBreadcrumbText = Breadcrumb.getText();
        System.out.println(ActBreadcrumbText);
        String ExpBrdCrmbText = "HomeProducts";
        Assert.assertEquals("HomeProducts", ExpBrdCrmbText );
    }

    @FindBy(css = "div.us-c-listings__filters__inner")
    WebElement FilterSection;

    public boolean IsFilterSectionDisplayed() {
        return FilterSection.isDisplayed();
    }

    @FindBy(css = "div.us-c-listings__items")
    WebElement ProductListingSection;

    public boolean IsProductListingItemsDisplayed() {
        return ProductListingSection.isDisplayed();
    }

    @FindBy(xpath = "//a[@href='/us/en/products/oil-and-serum/nexxus-smooth-frizz-defy-serum/']/div/div[@class='c-product-card__ratings']")
    WebElement ProductwithRating;

    public boolean IsProductListingItemsDisplayedWithRating() {
        return ProductwithRating.isDisplayed();
    }

    @FindBy(xpath = "//a[@href='/us/en/products/oil-and-serum/nexxus-smooth-frizz-defy-serum/']/../div[@class='c-product-card__buy']")
    WebElement ProductWithBuyNow;

    public boolean IsProductListingItemsDisplayedWithBuyNow() {
        return ProductWithBuyNow.isDisplayed();
    }

    @FindBy(css = "div.olapic-slider-widget")
    WebElement GallerySection;
    @FindBy(css = "section.c-footer__locale")
    WebElement LocaleFooter;

    public boolean IsGallerySectionDisplayed() throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", LocaleFooter);
        Thread. sleep(5);
        return GallerySection.isDisplayed();
    }

    @FindBy(xpath = "//article/a[@href='/us/en/products/oil-and-serum/nexxus-smooth-frizz-defy-serum/']")
    WebElement ProductImage;
    public RemoteWebDriver ClickOnAnyProductImage() {
        Helper.scrollAndClick(driver, ProductImage);
        return driver;
    }


}
