package com.vtiger.stepdefinitions;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SeleniumFeatures {

    public static WebDriver driver;

    public static void main(String[] args) {

         driver = new ChromeDriver();
        driver.get("http://localhost:100");
        driver.manage().window().maximize();
        driver.findElement(By.name("user_name")).sendKeys("admin");
        driver.findElement(By.name("user_password")).sendKeys("admin");
        driver.findElement(By.name("Login")).click();
        driver.findElement(By.linkText("New Product")).click();
        driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\Users\\rajes\\Desktop\\CyberSecurity.docx");
    }

    public static void clickLink(String linktext)
    {
        WebElement elm = driver.findElement(By.xpath("//a[text()='"+linktext+"']"));
        elm.click();

        driver.switchTo().frame("frame1");
        driver.switchTo().defaultContent();
       // driver.switchTo().alert().sendKeys("");
    }
}
