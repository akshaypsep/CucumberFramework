package com.vtiger.pages;

import com.vtiger.utilities.CommonActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderPage extends CommonActions {

    private WebDriver driver;

    public HeaderPage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(linkText = "Logout")
    WebElement lnk_logout;

    @FindBy(linkText = "New Lead")
    WebElement lnk_newlead;

    @FindBy(linkText = "Leads")
    WebElement lnk_leads;

    public void clickLogout()
    {
        clickElement(lnk_logout,"Link logout clicked");
    }

    public void verifyLogout()
    {
        elementDisplay(lnk_logout,"Link logout is displayed");
    }

    public void clickNewLead()
    {
        clickElement(lnk_newlead,"Link New Lead clicked");
    }

    public void clickLeads()
    {
        clickElement(lnk_leads,"Link Leads clicked");
    }





}
