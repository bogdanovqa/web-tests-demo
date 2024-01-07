package utils;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.util.Calendar;
import java.util.Date;

public class CookieUtils {
    public static final String CARTOSHKA = "Cartoshka";
    public static final String CARTOSHKA_LEGACY = "Cartoshka-legacy";
    public static final String VALUE_TRUE = "true";
    public static final String DOMAIN = "qa-scooter.praktikum-services.ru";
    public static final String PATH = "/";

    public static void setUpDefaultCookie(WebDriver driver) {
        driver.manage().addCookie(generateByName(CARTOSHKA));
        driver.manage().addCookie(generateByName(CARTOSHKA_LEGACY));
    }

    private static Cookie generateByName(String name) {
        Calendar expiry = Calendar.getInstance();
        expiry.setTime(new Date());
        expiry.add(Calendar.YEAR, 1);

        return new Cookie.Builder(name, VALUE_TRUE)
                .domain(DOMAIN)
                .path(PATH)
                .expiresOn(expiry.getTime())
                .build();
    }
}