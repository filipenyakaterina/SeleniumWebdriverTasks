package Hardcore.page;

import Hardcore.helper.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {
    protected WebDriver driver;

    public abstract AbstractPage openPage();

    public AbstractPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        HelperInitializer.initHelpers(driver);
    }
}
