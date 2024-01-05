package drivers;

import enums.BrowserData;
import exceptions.BrowserNotSupportedException;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;

import java.util.Locale;

public class DriverFactory implements IDriverFactory {
    @SneakyThrows
    @Override
    public WebDriver getInstance() {
        String browserName = System.getProperty("browser").toUpperCase(Locale.ROOT);
        BrowserData browser;

        try {
            browser = BrowserData.valueOf(browserName);
        } catch (IllegalArgumentException exception) {
            throw new BrowserNotSupportedException(browserName);
        }

        switch (browser) {
            case CHROME:
                return WebDriverManager.chromedriver().create();
            case FIREFOX:
                return WebDriverManager.firefoxdriver().create();
            case OPERA:
                return WebDriverManager.operadriver().create();
            case EDGE:
                return WebDriverManager.edgedriver().create();
            default:
                return null;
        }
    }
}
