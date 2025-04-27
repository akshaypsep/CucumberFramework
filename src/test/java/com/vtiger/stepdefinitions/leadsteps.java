package com.vtiger.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import java.util.List;
import java.util.Map;

public class leadsteps extends basesteps {

    @When("user click on new lead link and fill mandatory form and save")
    public void user_click_on_new_lead_link_and_fill_mandatory_form_and_save() {
        leadpage.clickNewLead();
        leadpage.createlead(dt.get(ScenarioName).get("lastname"),dt.get(ScenarioName).get("company"));
    }
    @Then("lead should be created successfully")
    public void lead_should_be_created_successfully() {

     leadpage.verifyleaddetails("Last Name123",dt.get(ScenarioName).get("lastname"));
        leadpage.verifyleaddetails("Company",dt.get(ScenarioName).get("company"));
    }

    @When("user click on new lead link and fill mandatory form and save and verify")
    public void user_click_on_new_lead_link_and_fill_mandatory_form_and_save_and_verify(io.cucumber.datatable.DataTable dataTable) {
             List<List<String>> lst = dataTable.asLists();
             for(int i=0;i<lst.size();i++)
             {
                 leadpage.clickNewLead();
                 leadpage.createlead(lst.get(i).get(0),lst.get(i).get(1));
             }
    }

    @When("User need to create multiple leads and validate based on data")
    public void user_need_to_create_multiple_leads_and_validate_based_on_data(io.cucumber.datatable.DataTable dataTable) {
        List<List<String>> ls = dataTable.asLists();
        for (int i = 0; i < ls.size(); i++) {
            driver.findElement(By.xpath("//a[contains(text(),'New Lead')]")).click();
            // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name = 'lastname']")));
            driver.findElement(By.xpath("//input[@name = 'lastname']")).sendKeys(ls.get(i).get(0));
            driver.findElement(By.xpath("//input[@name = 'company']")).sendKeys(ls.get(i).get(1));
            driver.findElement(By.name("button")).click();
            driver.findElement(By.xpath("//td[text()='Last Name:']/following-sibling::td[1][text()='" + ls.get(i).get(0) + "']")).isDisplayed();
            driver.findElement(By.xpath("//td[text()='Company:']/following-sibling::td[1][text()='" + ls.get(i).get(1) + "']")).isDisplayed();
        }

    }

    @When("Close Browser")
    public void close_browser() {
        driver.close();
    }
}
