package com.vtiger.stepdefinitions;

import com.aventstack.extentreports.ExtentTest;
import com.codoid.products.exception.FilloException;
import com.vtiger.pages.HomePage;
import com.vtiger.pages.LeadPage;
import com.vtiger.pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class loginsteps extends basesteps {

    @Before
    public void getscenario(Scenario scenario) throws FilloException {
        if(extent==null) {
            createExtentReport();
        }
       ScenarioName =  scenario.getName();
       report = extent.createTest(ScenarioName);
    }

    @After
    public void tierdown()
    {
        //driver.quit();
        driver.findElement(By.linkText("Logout")).click();
        extent.flush();
    }



    @Given("user should be on login page")
    public void user_should_be_on_login_page() throws FilloException {
        initiation();
    }
    @When("user enters valid userid and password")
    public void user_enters_valid_userid_and_password() {
        loginpage.setUsername(dt.get(ScenarioName).get("Userid"));
        loginpage.setPassword(dt.get(ScenarioName).get("Password"));

    }
    @When("click in login button")
    public void click_in_login_button() {
        loginpage.clickLogin();
    }
    @Then("user should be navigated to home page")
    public void user_should_be_navigated_to_home_page() {
        driver.findElement(By.linkText("Home")).isDisplayed();


    }
    @Then("user can see the logout")
    public void user_can_see_the_logout() {
        driver.findElement(By.linkText("Logout")).isDisplayed();
    }

    @When("user enters invalid userid and password")
    public void user_enters_invalid_userid_and_password() {

        loginpage.setUsername(dt.get(ScenarioName).get("Userid"));
        loginpage.setPassword(dt.get(ScenarioName).get("Password"));
    }
    @Then("user should be navigated to login page")
    public void user_should_be_navigated_to_login_page() {
        loginpage.verifyUsername();
    }
    @Then("user can see the error message")
    public void user_can_see_the_error_message() {
        loginpage.verifyErrorMsg();
    }

    @When("user enters invalid userid as {string} and password as {string}")
    public void user_enters_invalid_userid_as_and_password_as(String uid, String pass) {
        loginpage.setUsername(uid);
        loginpage.setPassword(pass);
    }

}
