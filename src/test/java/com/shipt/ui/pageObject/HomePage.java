package com.shipt.ui.pageObject;

import org.openqa.selenium.By;

/**
 * Created by C842045 on 1/10/2019.
 */
public class HomePage {
    private By loginButton      = By.cssSelector("#home > div.page-container > header > nav > ul.right > li:nth-child(1) > a");
    private By popupCloseButton = By.cssSelector("#interstitial-modal > section > button");
    private By popup            = By.id("interstitial-modal");

    public By getLoginButton() {
        return loginButton;
    }

    public By getPopupCloseButton() {
        return popupCloseButton;
    }

    public By getPopup() {
        return popup;
    }
}
