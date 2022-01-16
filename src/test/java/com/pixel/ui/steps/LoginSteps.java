package com.pixel.ui.steps;

import com.pixel.ui.steps.base.BaseStep;
import com.pixel.ui.steps.commons.StepContext;
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
            //Clear cookies notification
            findElementClick("#app > div > div > div.cookie-notice > div > a",Pather.cssSelector);
            waitForElementNotPresent("#app > div > div > div.cookie-notice > div > a",Pather.cssSelector,TimeOut.MIDDLE);
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

                //Then above true then fail test
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
            findElement("password",Pather.id,TimeOut.MIDDLE).sendKeys(Keys.ENTER);


        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    @And("the user exits with logout")
    public void theUserExitsWithLogout() {
        findElementClick(".nav-menu-inner > span:nth-child(1)",Pather.cssSelector);
        findElementClick("Quit",Pather.linkText);
        waitForElementNotPresent("pixelBalance",Pather.id,TimeOut.LOW);
        if(findElement("pixelBalance",Pather.id,TimeOut.LOW) != null){
            Assert.fail();}

        DriverQuit();
    }

    // Used in Casino Steps and other future step classes as a background.
    @Given("the user is logged in")
    public void the_user_is_logged_in() {
        //Opens Main page
        geturl(stepContext.getServerURL());
        //Clear cookies notification
        findElementClick("#app > div > div > div.cookie-notice > div > a",Pather.cssSelector);
        waitForElementNotPresent("#app > div > div > div.cookie-notice > div > a",Pather.cssSelector,TimeOut.MIDDLE);
        //Clicks login button
        findElementClick("#pixel-header > div > div.user-section > div.header-buttons-container > a.menu-text.login-button",Pather.cssSelector);
        //Enters Valid Username
        findElement("email",Pather.id,TimeOut.MIDDLE).sendKeys("BernardMifsud@gmail.com");
        //Enters Valid Password
        findElement("password",Pather.id,TimeOut.MIDDLE).sendKeys("bV3etsZ5FG!QU5Z");
        //Press Enter key
        findElement("password",Pather.id,TimeOut.MIDDLE).sendKeys(Keys.ENTER);
        //Confirms login
        if(findElement("pixelBalance",Pather.id,TimeOut.HIGH) == null){
            Assert.fail();
            DriverQuit();}
    }

}
