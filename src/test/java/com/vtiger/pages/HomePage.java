package com.vtiger.pages;

import com.vtiger.utilities.CommonActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends HeaderPage {

    private WebDriver driver;

    public HomePage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
}
