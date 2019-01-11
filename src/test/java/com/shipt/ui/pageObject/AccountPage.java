package com.shipt.ui.pageObject;

import org.openqa.selenium.By;

/**
 * Created by C842045 on 1/10/2019.
 */
public class AccountPage {
    private By accountProfile = By.xpath("//*[@id=\"root\"]/div/div[1]/div[2]/header/div/a[2]/span");

    public By getAccountProfile() {
        return accountProfile;
    }
}
