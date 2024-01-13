package exceptions;

import java.lang.reflect.Field;

public class WebDriverSetUpException extends Exception {
    public WebDriverSetUpException(Field field) {
        super(String.format("Could not access or set webdriver in field: %s - is this field public?", field));
    }
}
