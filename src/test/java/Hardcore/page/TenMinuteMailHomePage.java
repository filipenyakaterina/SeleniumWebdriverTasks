package Hardcore.page;

import Hardcore.helper.Executor;
import Hardcore.helper.Switcher;
import Hardcore.helper.Waiter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TenMinuteMailHomePage extends AbstractPage {
    public static final String TEN_MINUTE_MAIL_URL = "https://10minutemail.com";

    @FindBy(xpath = "//input[@id = 'mailAddress']")
    private WebElement emailAddress;

    public TenMinuteMailHomePage(WebDriver driver) {
        super(driver);
        Switcher.switchToFrame();
    }

    public TenMinuteMailHomePage openPage() {
        Switcher.openNewTab();
        Waiter.waitUntilNewWindowHandleAppear();
        Switcher.switchToNewTab(TEN_MINUTE_MAIL_URL);
        return this;
    }

    public String getEmailAddress(){
        Waiter.waitUntilElementToBeVisible(emailAddress);
        Executor.scrollToElement(emailAddress);
        return emailAddress.getAttribute("value");
    }
}
