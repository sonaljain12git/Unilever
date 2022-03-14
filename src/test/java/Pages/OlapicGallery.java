package Pages;
import Utility.Helper;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OlapicGallery {
    private final RemoteWebDriver driver;

    public OlapicGallery(RemoteWebDriver _driver) {

        Helper.WaitForPageLoad(_driver,120);
        PageFactory.initElements(_driver, this);
        driver = _driver;
    }

    @FindBy(css = "div.c-page-header")
    WebElement OlapicGalleryPageTitle ;

    public boolean IsOlapicGalleryPageDisplayed() {
        System.out.println(OlapicGalleryPageTitle.getText());
        return OlapicGalleryPageTitle.isDisplayed();

    }

    public void GetUrl() {
        String currUrl= driver.getCurrentUrl();
        System.out.println(currUrl);
        String expUrl="https://www.nexxus.com/us/en/olapic-gallery";
        Assert.assertEquals("Current url is same as exp url", expUrl, currUrl);
    }



}
