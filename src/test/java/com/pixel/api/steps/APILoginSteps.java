package com.pixel.api.steps;

import com.pixel.api.steps.commons.ApiClient;
import com.pixel.api.steps.commons.ApiConfig;
import com.pixel.api.model.auth.response.LoginResponse;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes={ApiClient.class,ApiConfig.class})
public class APILoginSteps{

    @Autowired
    ApiClient apiClient;

    private LoginResponse loginResponse;
    private int logoutResponse;

    @Given("^API User Login using (.+) and (.+) login$")
    public void aPIUserLoginUsingAndLogin(String email, String password) throws Throwable {

        loginResponse = apiClient.apiLogin(email,password);
    }

    @Then("^API User should receive response with (.+) and (.+)$")
    public void aPIUserShouldReceiveResponseWithAnd(int statusCode, String resultbody) throws Throwable {
        //verifies status code and body result
        if(statusCode != loginResponse.getStatusCode() && resultbody != loginResponse.getResponseBody().getResult()){
            Assert.fail();
        }
    }

}
