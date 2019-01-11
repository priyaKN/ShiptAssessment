package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by C842045 on 1/10/2019.
 */
public class BrowserDriverFactory {
    private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

    public WebDriver createDriver() {
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        driver.set(new ChromeDriver());
        return driver.get();
    }
}
