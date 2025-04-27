package com.vtiger.pages;

import com.vtiger.utilities.CommonActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadPage extends HeaderPage {

    private WebDriver driver;

    public LeadPage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(name = "lastname")
    WebElement tb_lastname;

    @FindBy(xpath = "//input[@name='company']")
    WebElement tb_company;

    @FindBy(name = "button")
    WebElement btn_save;

    public void createlead(String lname, String comp)
    {
        setLastname(lname);
        setCompany(comp);
        clickSave();
    }

    public void setLastname(String lname)
    {
        setInput(tb_lastname,lname,"lastname entered successfully");
    }

    public void setCompany(String comp)
    {
        setInput(tb_company,comp,"Company entered successfully");
    }

    public void clickSave()
    {
        clickElement(btn_save,"save button clicked");
    }

    public void verifyleaddetails(String label,String txt)
    {
        WebElement elm = driver.findElement(By.xpath("//td[text()='"+label+":']/following::td[text()='"+txt+"']"));
        elementDisplay(elm,txt+" displayed against label "+label);
    }

}
