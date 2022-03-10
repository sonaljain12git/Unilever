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

public class Signup {

    private final RemoteWebDriver driver;

    public Signup(RemoteWebDriver _driver) {
        Helper.WaitForPageLoad(_driver,120);
        PageFactory.initElements(_driver, this);
        driver = _driver;
    }

    @FindBy(css = "input#givenName")
    WebElement txtName;

    @FindBy(css = "input#familyName")
    WebElement txtLastName;

    @FindBy(css = "input#email")
    WebElement txtEmail;

    @FindBy(css = "input#birthday")
    WebElement txtDOB;

    @FindBy(css = "button.c-button.c-button--block")
    WebElement btnToSend;


    @FindBy(xpath = "//output[normalize-space()='First Name is mandatory']")
    WebElement errName;

    @FindBy(xpath = "//h1[normalize-space()='Sign Up - Thank you']")
    WebElement thankyouMessage;


    public void clickOkBtn(){
        Helper.scrollAndClick(driver,btnToSend);

    }

    public Boolean ValidationForNameDisplay(){
        return errName.isDisplayed();
    }

    public Boolean ThankYouMessageDisplay() { return thankyouMessage.isDisplayed();}


    public void SignUpWithDetails(String firstName, String lastName, String email, String DOB)  {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(txtName));
        Helper.scrollAndClick(driver, txtName);
        txtName.sendKeys(firstName);
        txtLastName.sendKeys(lastName);
        txtEmail.sendKeys(email);
        txtDOB.sendKeys(DOB);
        btnToSend.click();

    }

    @FindBy(css = "h1.c-form__title.o-heading-xl")
    WebElement SignUpPageTitle;

    public boolean IsSignUpPageTitleDisplayed() {
        return SignUpPageTitle.isDisplayed();
    }
}
