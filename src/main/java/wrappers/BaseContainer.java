package wrappers;

import org.openqa.selenium.WebElement;

public abstract class BaseContainer {
    private WebElement wrappedElement;

    public void wrap(WebElement wrappedElement) {
        this.wrappedElement = wrappedElement;
    }

    protected boolean isDisplayed() {
        return wrappedElement.isDisplayed();
    }
}