package com.shipt.ui.automated.loginPage;

import com.shipt.ui.pageObject.AccountPage;
import com.shipt.ui.pageObject.ForgotPasswordPage;
import com.shipt.ui.pageObject.HomePage;
import com.shipt.ui.pageObject.LoginPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.TakeScreenshot;
import utils.TestPlanReader;

import java.util.Map;

/**
 * Created by C842045 on 1/10/2019.
 */
public class TestLoginPage extends TakeScreenshot {
    private              HomePage           homePage           = new HomePage();
    private              LoginPage          loginPage          = new LoginPage();
    private              ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();
    private              AccountPage        accountPage        = new AccountPage();
    private final static String             POSITIVE           = "positive";
    private final static String             NEGATIVE           = "negative";
    private final static String             FORGOT_PASSWORD    = "forgot password";

    @Test(priority = 1, dataProvider = "csvReader", dataProviderClass = TestPlanReader.class)
    public void testLoginPage(Map<String, String> testData) {
        switch (testData.get("case")) {
            case POSITIVE:
                this.loginpage(testData.get("email"), testData.get("password"), testData.get("expectedoutput"), accountPage.getAccountProfile());
                break;
            case NEGATIVE:
                this.loginpage(testData.get("email"), testData.get("password"), testData.get("expectedoutput"), loginPage.getErrorMessage());
                break;
            case FORGOT_PASSWORD:
                this.testForgotPassword(testData.get("expectedoutput"));
                break;
            default:
                log.error("An Error has occurred while testing " + testData.get("description"));
        }
    }

    /**
     * Enter user and password and click on login button to validate the expected behavior based on the input entered
     *
     * @param email
     * @param password
     * @param expectedOutput
     * @param expectedText
     */
    private void loginpage(String email, String password, String expectedOutput, By expectedText) {
        super.waitUntilElementClickable(loginPage.getUserNameTextbox());
        super.sendKeysByAction(loginPage.getUserNameTextbox(), email);
        super.sendKeysByAction(loginPage.getPasswordTextbox(), password);
        super.takeScreenshot("TestLoginPage");
        super.clickByAction(loginPage.getLoginButton());
        super.waitUntilElementClickable(expectedText);
        super.takeScreenshot("TestLoginPage");
        Assert.assertEquals(expectedOutput, super.getText(expectedText));
    }

    /**
     * Test forgot password link is taking to reset password page
     *
     * @param output
     */
    private void testForgotPassword(String output) {
        super.waitUntilElementClickable(loginPage.getForgotPasswordLink());
        super.clickByAction(loginPage.getForgotPasswordLink());
        super.waitUntilElementClickable(forgotPasswordPage.getForgotPasswordHeader());
        Assert.assertEquals(output, super.getText(forgotPasswordPage.getForgotPasswordHeader()));
    }
}
