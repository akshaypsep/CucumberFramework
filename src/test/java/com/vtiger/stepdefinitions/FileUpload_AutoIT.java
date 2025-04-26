package com.vtiger.stepdefinitions;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FileUpload_AutoIT {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
	//	System.setProperty("webdriver.chrome.driver", "C:/Selenium/Selenium_Software/chromedriver.exe");
	    WebDriver driver = new ChromeDriver();	    
	    driver.get("http://localhost:100");
	    driver.manage().window().maximize();
	    driver.findElement(By.name("user_name")).sendKeys("admin");
        driver.findElement(By.name("user_password")).sendKeys("admin");        
        driver.findElement(By.name("Login")).click();
        driver.findElement(By.linkText("New Product")).click();
        
        
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)", "");
        Thread.sleep(2000);
       // driver.findElement(By.xpath("//input[@type='file']")).click();
        Actions act = new Actions(driver);
        act.click(driver.findElement(By.xpath("//input[@type='file']"))).build().perform();
        Thread.sleep(3000);
        Runtime.getRuntime().exec("C:\\Users\\Rajesh\\Desktop\\rachana.exe");

	}

}
