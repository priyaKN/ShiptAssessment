package utils;

import com.google.common.base.Function;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by C842045 on 1/10/2019.
 */
public class BaseTest extends BrowserDriverFactory {
    protected WebDriver driver;
    private static final long TIMEOUT_IN_SECONDS = 10;
    private static final long POLLING_TIME       = 20000;
    protected Logger     log;
    protected Properties prop;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        BrowserDriverFactory bf = new BrowserDriverFactory();
        driver = bf.createDriver();
        driver.get("https://shop.shipt.com/login");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("disable-infobars");
        DesiredCapabilities dc = DesiredCapabilities.chrome();
        dc.setCapability(ChromeOptions.CAPABILITY, options);
        this.waitUntilPageLoad();
    }

    @AfterMethod()
    public void tearDown() {
        driver.quit();
    }

    /**
     * Wait until page loads
     */
    public void waitUntilPageLoad() {
        new WebDriverWait(driver, TIMEOUT_IN_SECONDS).until(
                (ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
    }

    /**
     * wait until the webelement is visible on the web page
     *
     * @param element
     * @return
     */
    protected WebElement waitUntilElementIsVisible(final By element) {
        return new FluentWait<>(driver).withTimeout(TIMEOUT_IN_SECONDS, TimeUnit.SECONDS).pollingEvery(POLLING_TIME, TimeUnit.MILLISECONDS).ignoring(
                NoSuchElementException.class).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    /**
     * wait until the webelement hides
     *
     * @param byLocator
     * @param timeout
     * @param pollingTime
     */
    protected void waitUntilElementHides(final By byLocator, final long timeout, final long pollingTime) {
        new FluentWait<>(driver).withTimeout(timeout, TimeUnit.SECONDS).pollingEvery(pollingTime, TimeUnit.MILLISECONDS).ignoring(
                org.openqa.selenium.NoSuchElementException.class).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.invisibilityOfElementLocated(byLocator));
    }

    /**
     * Wait until the webelement is clickable
     *
     * @param byLocator
     */
    protected void waitUntilElementClickable(final By byLocator) {
        new FluentWait<>(driver).withTimeout(TIMEOUT_IN_SECONDS, TimeUnit.SECONDS).pollingEvery(POLLING_TIME, TimeUnit.MILLISECONDS).ignoring(
                org.openqa.selenium.NoSuchElementException.class).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(byLocator));
    }

    /**
     * Wait until the list of web elements exists
     *
     * @param byLocator
     * @param timeout
     * @param pollingTime
     * @return
     */
    protected List<WebElement> waitUntilElementListExists(final By byLocator, final long timeout, final long pollingTime) {
        return new FluentWait<>(driver).withTimeout(timeout, TimeUnit.SECONDS).pollingEvery(pollingTime, TimeUnit.MILLISECONDS).ignoring(
                org.openqa.selenium.NoSuchElementException.class).ignoring(StaleElementReferenceException.class).until(
                (Function<WebDriver, List<WebElement>>) webDriver -> driver.findElements(byLocator));
    }

    /**
     * return the webelment
     *
     * @param element
     * @return
     */
    protected WebElement getWebElement(By element) {
        return driver.findElement(element);
    }

    /**
     * Click function to click on a webelement
     *
     * @param element
     */
    protected void click(By element) {
        this.waitUntilElementIsVisible(element);
        this.getWebElement(element).click();
    }

    /**
     * Enter data into the textbox
     *
     * @param element
     * @param text
     */
    public void sendKeys(By element, String text) {
        this.waitUntilElementIsVisible(element).sendKeys(text);
    }

    /**
     * Using actions class, Enter data into the textbox
     *
     * @param element
     * @param text
     */
    public void sendKeysByAction(By element, String text) {
        Actions actions = new Actions(driver);
        actions.moveToElement(this.getWebElement(element));
        actions.click();
        actions.sendKeys(text);
        actions.build().perform();
    }

    /**
     * Using actions class, Click function to click on a webelement
     *
     * @param element
     */
    public void clickByAction(By element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(this.getWebElement(element));
        actions.click();
        actions.build().perform();
    }

    /**
     * Get text from the webelement specified
     *
     * @param element
     * @return
     */
    public String getText(By element) {
        return this.waitUntilElementIsVisible(element).getText();
    }

    @DataProvider(name = "expectedOutput")
    protected static Object[][] files() {
        return new Object[][]{{1, "Reset Password"}};
    }
}
