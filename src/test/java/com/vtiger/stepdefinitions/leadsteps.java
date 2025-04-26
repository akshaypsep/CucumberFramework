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

}
