package com.shipt.ui.pageObject;

import org.openqa.selenium.By;

/**
 * Created by C842045 on 1/10/2019.
 */
public class LoginPage {
    private By userNameTextbox    = By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/form[3]/fieldset/div[1]/div[1]");
    private By passwordTextbox    = By.id("password");
    private By loginButton        = By.cssSelector("#root > div > div.min-vh-100.pb4 > div > div.w-50-m.ph4.ph7-m.body-2.relative > form:nth-child(5) > fieldset > button");
    private By forgotPasswordLink = By.cssSelector("#root > div > div.min-vh-100.pb4 > div > div.w-50-m.ph4.ph7-m.body-2.relative > form:nth-child(5) > fieldset > p > a");
    private By errorMessage       = By.cssSelector(
            "#root > div > div.min-vh-100.pb4 > div > div.w-50-m.ph4.ph7-m.body-2.relative > form:nth-child(5) > fieldset > div.burgundy.mb3.body-3.tc");

    public By getUserNameTextbox() {
        return userNameTextbox;
    }

    public By getPasswordTextbox() {
        return passwordTextbox;
    }

    public By getLoginButton() {
        return loginButton;
    }

    public By getForgotPasswordLink() {
        return forgotPasswordLink;
    }

    public By getErrorMessage() {
        return errorMessage;
    }
}
