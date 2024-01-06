package pages;

import actions.CommonActions;
import annotations.Path;
import exceptions.PathEmptyException;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;

public abstract class BasePage<T> extends CommonActions {

    protected BasePage(WebDriver driver) {
        super(driver);
    }

    @SneakyThrows
    public T open() {
        String baseUrl = System.getProperty("webdriver.base.url");
        driver.get(baseUrl + getPath());
        return (T) this;
    }

    private String getPath() throws PathEmptyException {
        Class<? extends BasePage> clazz = this.getClass();
        if (clazz.isAnnotationPresent(Path.class)) {
            Path path = clazz.getAnnotation(Path.class);
            return path.value();
        }
        throw new PathEmptyException();
    }

    public abstract T shouldDisplayed();
}