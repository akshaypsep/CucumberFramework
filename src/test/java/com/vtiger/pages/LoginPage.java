package com.vtiger.pages;

import com.vtiger.utilities.CommonActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends CommonActions {


    private WebDriver driver;

    public LoginPage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    //String userid = "//input[@name='user_name']";

   // By userid = By.xpath("//input[@name='user_name']");
   // By pwd = By.name("user_password");

    @FindBy(name = "user_name")
    WebElement tb_userid;

    @FindBy(xpath = "//input[@name='user_password']")
    WebElement tb_pwd;

    @FindBy(name = "Login")
    WebElement btn_login;

    @FindBy(xpath = "//*[contains(text(),'You must specify a valid username and password.')]")
    WebElement errorMsg;




    public void login(String uid, String pwd)
    {
      setUsername(uid);
      setPassword(pwd);
      clickLogin();
    }

    public void login(String uid, String pwd, String them)
    {
       // System.out.println("hello");
        setUsername(uid);
        setPassword(pwd);
        selectTheme("");
        clickLogin();
    }

    public void setUsername(String uid)
    {
       setInput(tb_userid,uid,"username entered successfully");
    }

    public void setPassword(String pwd)
    {
       setInput(tb_pwd,pwd,"password entered successfully");
    }

    public void selectTheme(String them)
    {
       // setInput(tb_pwd,pwd,"password entered successfully");
    }

    public void clickLogin()
    {
        clickElement(btn_login,"Login button clicked");
    }

    public void verifyUsername()
    {
        elementDisplay(tb_userid,"textbox username is displayed");
    }

    public void verifyErrorMsg()
    {
        elementDisplay(errorMsg,"Error msg is displayed");
    }




}
