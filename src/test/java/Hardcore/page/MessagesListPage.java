package Hardcore.page;

import Hardcore.helper.Executor;
import Hardcore.helper.Switcher;
import Hardcore.helper.Waiter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MessagesListPage extends AbstractPage {
    private final String COST_TITLE = "Estimated Monthly Cost:";

    @FindBy(xpath = "//div[@id = 'messagesList']")
    private WebElement messagesList;

    @FindBy(xpath = "//div[@id = 'messagesList']//h3[1]")
    private WebElement messagesListTab;

    @FindBy(xpath = "//div[@id = 'messagesList']//tbody//h2[contains(text(), 'Estimated Monthly Cost:')]")
    private WebElement estimateCost;

    public MessagesListPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public MessagesListPage openPage(){
        Switcher.switchToOtherTab();
        if(!driver.getCurrentUrl().contains(TenMinuteMailHomePage.TEN_MINUTE_MAIL_URL)){
            throw new IllegalStateException("This is not the 10MinuteMail page!");
        }
        return this;
    }

    public String getEstimateCost(){
        Waiter.waitUntilElementToBeVisible(messagesList);
        Executor.scrollToElement(messagesList);
        Executor.clickElement(messagesListTab);
        Waiter.waitUntilTextToBe(estimateCost, COST_TITLE);
        return estimateCost.getText();
    }
}
