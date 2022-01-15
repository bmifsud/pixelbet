package com.pixel.steps;

import com.pixel.steps.base.BaseStep;
import com.pixel.steps.commons.StepContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes=StepContext.class)
public class LoginSteps extends BaseStep {

    @Autowired
    private StepContext stepContext;

    public LoginSteps(StepContext stepContext) {
        super(stepContext.getDriver());
    }

    @Given("^a web browser is at the home page$")
    public void aWebBrowserIsAtTheHomePage() throws Throwable {//////////////////////////////////////////
        try {
            //Opens Main page
            geturl(stepContext.getServerURL());
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }


    @When("^the user view login dialogue$")
    public void theUserViewLoginDialogue() throws Throwable {

        try {
            //Clicks login button
            findElementClick("#pixel-header > div > div.user-section > div.header-buttons-container > a.menu-text.login-button",Pather.cssSelector);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }


    @Then("^depends on the credentials the user is or is not (.+) access$")
    public void dependsOnTheCredentialsTheUserIsOrIsNotAccess(String granted) throws Throwable {
        try {
            // When login granted
            if ((   // Granted Access
                    Boolean.parseBoolean(granted)
                    && findElement("pixelBalance",Pather.id,TimeOut.HIGH) == null )
                    // Not Granted Access
                    ||(!Boolean.parseBoolean(granted)
                    && findElement("pixelBalance",Pather.id,TimeOut.HIGH) != null)){

                Assert.fail();
                DriverQuit();
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    @And("^the user fills the (.+) and (.+) fields$")
    public void theUserFillsTheAndFields(String username, String password) throws Throwable {
        try {
            //Enters Username
            findElement("email",Pather.id,TimeOut.LOW).sendKeys(username);
            //Enters Password
            findElement("password",Pather.id,TimeOut.LOW).sendKeys(password);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @And("^the user press login$")
    public void theUserPressLogin() throws Throwable {
        try {
            //Pressing Enter
            findElement("password",Pather.id,TimeOut.LOW).sendKeys(Keys.ENTER);

        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    @And("the user exits with logout")
    public void theUserExitsWithLogout() {
        findElementClick("#nav-menu-icon > div",Pather.cssSelector);
        findElementClick("body > div:nth-child(18) > div.fade.MenuModal.right.in.modal > div > div > div.modal-body > div.account-menu-container > a.account-menu.logout",Pather.cssSelector);
        DriverQuit();
    }

    @Given("the user is logged in")
    public void the_user_is_logged_in() {
        //Opens Main page
        geturl(stepContext.getServerURL());
        //Clicks login button
        findElementClick("#pixel-header > div > div.user-section > div.header-buttons-container > a.menu-text.login-button",Pather.cssSelector);
        //Enters Valid Username
        findElement("email",Pather.id,TimeOut.LOW).sendKeys("BernardMifsud@gmail.com");
        //Enters Valid Password
        findElement("password",Pather.id,TimeOut.LOW).sendKeys("bV3etsZ5FG!QU5Z");
        //Press Enter key
        findElement("password",Pather.id,TimeOut.LOW).sendKeys(Keys.ENTER);
    }

}
