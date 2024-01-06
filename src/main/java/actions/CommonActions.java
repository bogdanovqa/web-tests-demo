package actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import waiters.BaseWaiters;
import wrappers.ExtendedFieldDecorator;

public abstract class CommonActions {
    protected WebDriver driver;
    protected BaseWaiters waiters;
    protected Actions actions;

    protected CommonActions(WebDriver driver) {
        this.driver = driver;
        waiters = new BaseWaiters(driver);
        actions = new Actions(driver);
        PageFactory.initElements(new ExtendedFieldDecorator(driver), this);
    }
}