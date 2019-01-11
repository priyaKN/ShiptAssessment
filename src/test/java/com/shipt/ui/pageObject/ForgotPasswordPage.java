package com.shipt.ui.pageObject;

import org.openqa.selenium.By;

/**
 * Created by C842045 on 1/10/2019.
 */
public class ForgotPasswordPage {
    private By forgotPasswordHeader = By.cssSelector("body > div:nth-child(2) > div > div > div > form > fieldset > h2");

    public By getForgotPasswordHeader() {
        return forgotPasswordHeader;
    }
}
