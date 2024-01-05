package components;

import actions.CommonActions;
import annotations.Component;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public abstract class BaseComponent<T> extends CommonActions {

    {
        this.waiters.waitForCondition(ExpectedConditions.visibilityOfElementLocated(getLocator()));
    }

    protected BaseComponent(WebDriver driver) {
        super(driver);
    }

    private By getLocator() {
        Class<? extends BaseComponent> clazz = this.getClass();
        if (clazz.isAnnotationPresent(Component.class)) {
            Component component = clazz.getAnnotation(Component.class);
            if (!component.xpath().isEmpty()) {
                return By.xpath(component.xpath());
            }
            if (!component.css().isEmpty()) {
                return By.cssSelector(component.css());
            }
        }
        return null;
    }
}
