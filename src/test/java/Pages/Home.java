package Pages;


import Utility.Helper;
import lombok.var;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class Home {

    private RemoteWebDriver driver;

    public Home(RemoteWebDriver _driver) {
        //Helper.WaitForPageLoad(_driver,60);
        PageFactory.initElements(_driver, this);
        driver = _driver;
    }

    @FindBy(css = "div[class='c-header__logo']")
    WebElement Nexxuslogo;

    public boolean IsLogoImageDisplayed() {
        return Nexxuslogo.isDisplayed();
    }

    public String logoText() {
        return Nexxuslogo.getAttribute("alt");
    }

    public void ClickOnLogo() {
        Helper.scrollAndClick(driver, Nexxuslogo);
    }

    @FindBy(css = "button[id='nav-link-0'] span")
    WebElement DropdownArrow;

    public boolean IsdropdownArrowDisplayed() {
        return DropdownArrow.isDisplayed();
    }

    public void ClickOnDropdownArrow() {
        Helper.scrollAndClick(driver, DropdownArrow);
    }

    @FindBy(xpath = "//ul[@id='sub-nav-0' and @class='c-header-sub-nav__menu']")
    WebElement Submenus;

    public boolean IsSubmenusDisplayed() {
        return Submenus.isDisplayed();
    }

    public List<WebElement> getSubmenuLink() {
        return Submenus.findElements(By.tagName("li"));
    }

    public List<String> getSubmenuLinkText() {
        List<String> linkTxt = new ArrayList<>();
        List<WebElement> links = Submenus.findElements(By.tagName("li"));
        for (WebElement var : links) {
            linkTxt.add(var.findElement(By.tagName("a")).getAttribute("href"));
        }
        return linkTxt;
    }

    @FindBy(xpath = "//ul[@id='sub-nav-0' and @class='c-header-sub-nav__menu']/li/a")
    WebElement SubmenuLinkTitle;

    public void ClickOnSubmenuLinkInProducts() {
        Helper.scrollAndClick(driver, SubmenuLinkTitle);
    }

    @FindBy(xpath = "//h1[contains(text(),'Professional Shampoos')]")
    WebElement ShampooPageTitle;

    public boolean IsShampooPageDisplayed() {
        return ShampooPageTitle.isDisplayed();

    }

    @FindBy(css = "ul.c-header-nav__menu")
    WebElement HeaderNavigationItems;

    public List<WebElement> getHeaderLink() {
        return HeaderNavigationItems.findElements(By.tagName("li"));
    }

    public List<String> getHeaderLinkText() {
        List<String> linkTxt = new ArrayList<>();
        List<WebElement> links = HeaderNavigationItems.findElements(By.tagName("li"));
        for (WebElement var : links) {
            linkTxt.add(var.findElement(By.tagName("a")).getAttribute("href"));
        }
        return linkTxt;

    }


    @FindBy(css = "button.c-header-actions__action--search")
    WebElement Search;

    public boolean IsSearchDisplayed() {
        return Search.isDisplayed();
    }

    public void ClickOnSearch() {
        Helper.click(driver, Search);
    }

    @FindBy(css = "input.c-basic-search-input__input")
    WebElement Searchbox;

    @FindBy(css = "button.c-basic-search-input__button")
    WebElement SearchIcon;

    public void writeInSearch(String productName) throws InterruptedException {
        //Helper.click(driver, Searchbox);
        driver.executeScript("arguments[0].click();", Searchbox);
        //Helper.EnterText(driver, Searchbox, productName);
        Helper.click(driver, SearchIcon);
        Thread.sleep(5000);
    }

    @FindBy(xpath = "//h2[contains(text(),'Showing')]")
    WebElement SearchResultsCountText;

    @FindBy(css = "div.us-c-search__list")
    WebElement SearchResultList;

    public boolean IsSearchResultCountTextDisplayed() {
        return SearchResultsCountText.isDisplayed();
    }

    public boolean IsSearchResultListDisplayed() {
        return SearchResultList.isDisplayed();

    }

    public List<WebElement> getSearchResultsLink() {
        return SearchResultList.findElements(By.tagName("article"));
    }

    public List<String> getSearchResultsText() {
        List<String> articlelinkTxt = new ArrayList<>();
        List<WebElement> links = SearchResultList.findElements(By.tagName("article"));
        for (WebElement var : links) {
            articlelinkTxt.add(var.findElement(By.tagName("a")).getAttribute("href"));
        }
        return articlelinkTxt;

    }

    String getSitecurrentUrl = "";

    public void selectAnySearchResult() {
        List<WebElement> lstElements = driver.findElements(By.cssSelector("div.us-c-search__list article"));
        Random rand = new Random();
        int upperbound = lstElements.size() - 1;
        int int_random = rand.nextInt(upperbound);
        WebElement element = lstElements.get(int_random);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.executeScript("arguments[0].click();", element);
        //getSitecurrentUrl = driver.getCurrentUrl();
    }

    public RemoteWebDriver NavSignUp() throws InterruptedException {
        var element = driver.findElements(By.xpath("//footer//a[contains(@href,'sign-up')]"));
        Helper.scrollAndClick(driver, element.get(0));
        ArrayList<String> tabs2 = new ArrayList<>(driver.getWindowHandles());
        if (tabs2.size() > 1) {
            driver.switchTo().window(tabs2.get(1));
        }

        return driver;

    }

    @FindBy(css = "a.c-header-actions__action.c-header-actions__action__link")
    WebElement WhereTobuyLnk;

    public RemoteWebDriver ClickOnWhereToBuyLink() {
        Helper.click(driver, WhereTobuyLnk);
        return driver;
    }

    @FindBy(css = "h2.c-section__title")
    WebElement BestSellingProductSection;

    public void isBestSellingProductSectionDisplayed() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", BestSellingProductSection);
        Assert.assertTrue("Expected Product Carousal should displayed", BestSellingProductSection.isDisplayed());
    }
    //public boolean isBestSellingProductSectionDisplayed() { return BestSellingProductSection.isDisplayed(); }

    public List<WebElement> getProductCarouselList() {
        return driver
                .findElements(By.xpath("//div[@class='c-slider']//h2")).stream().filter(WebElement::isDisplayed)
                .collect(Collectors.toList());

    }

    @FindBy(xpath = "//div[@aria-label='Next Slide']")
    WebElement nextArrow;

    @FindBy(xpath = "//div[@aria-label='Previous Slide']")
    WebElement prevArrow;

    public void verifyProductCarouselRotation() throws InterruptedException {

        while (nextArrow.isEnabled()) {
            Helper.scrollAndClick(driver, nextArrow);
        }
        var currentItems = getProductCarouselList();
        if (currentItems.size() == driver.findElements(By.xpath("//div[@class='c-slider']//h2")).size())
            return;


        while (prevArrow.isEnabled()) {
            Helper.scrollAndClick(driver, prevArrow);
            Thread.sleep(50);
            var newItems = getProductCarouselList();
            System.out.println(currentItems.size());
            System.out.println(newItems.size());
            Assert.assertNotEquals(newItems, currentItems);
        }

    }

    @FindBy(xpath = "//button[@data-testid='add-to-basket-display-button']")
    WebElement BuyNowButton;

    public void ClickOnBuyNow() {
        var buyItems = driver.findElements(By.xpath("//button[@data-testid='add-to-basket-display-button']"));
        Random rand = new Random();
        int upperbound = buyItems.size() - 2;
        int int_random = rand.nextInt(upperbound);
        Helper.scrollAndClick(driver, buyItems.get(int_random));
        //buyItems.get(int_random).click();
    }

    @FindBy(xpath = "//ul[@class='ps-online-sellers']")
    WebElement FindOnlinePopup;

    public boolean verifyFindOnlinePopup() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(FindOnlinePopup));
        return FindOnlinePopup.isDisplayed();
    }

    public String selectVendor() throws InterruptedException {
        Helper.WaitForPageLoad(driver,20);
        WebElement tblVendorLst = driver.findElement(By.cssSelector("ul.ps-online-sellers"));
        var items=tblVendorLst.findElements(By.tagName("li"));
        Random rand = new Random();
        int upperbound = items.size() - 1;
        int int_random = rand.nextInt(upperbound);
        String navUrl=items.get(int_random).getAttribute("href");
        Helper.scrollAndClick(driver,items.get(int_random));
        Helper.WaitForPageLoad(driver,20);
        Thread.sleep(3000);
        return  navUrl;
    }


    public RemoteWebDriver getActiveWindow(){
        ArrayList<String> tabs2 = new ArrayList<>(driver.getWindowHandles());
        if (tabs2.size() > 1) {
            driver.switchTo().window(tabs2.get(1));
        }
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        return driver;
    }


    @FindBy(xpath = "button#nav-link-0")
    WebElement ProductsNavLnk;

    public RemoteWebDriver ClickOnProductsNavLink() {
        Helper.click(driver, ProductsNavLnk);
        return driver;
    }

    @FindBy(css = "section.us-c-newsletter-sign-up-popup__box.is-active")
    WebElement SignupDrawerPopup;

    public boolean IsSignUpPopupDisplayed() {
        return SignupDrawerPopup.isDisplayed();

    }

    @FindBy(xpath = "//input[@id='email-popup']")
    WebElement EmailField;

    public void EnterEmail(String email) {
        Helper.click(driver, EmailField);
        EmailField.sendKeys(email);
    }

    @FindBy(css = "button.us-c-newsletter-sign-up-popup__continue")
    WebElement ContinueBtn;
    public void ClickOnContinueButton() {
        Helper.click(driver, ContinueBtn );
    }
}








