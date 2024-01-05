package waiters;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseWaiters {
    private static final int DEFAULT_TIMEOUT = 5;

    private final WebDriverWait webDriverWait;

    public BaseWaiters(WebDriver driver) {
        int timeout = Integer.getInteger("webdriver.waiters.timeout", DEFAULT_TIMEOUT);
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
    }

    public boolean waitForCondition(ExpectedCondition<WebElement> condition) {
        try {
            webDriverWait.until(condition);
            return true;
        } catch (TimeoutException ignore) {
            return false;
        }
    }
}
