package com.pixel.steps;

import com.pixel.steps.base.BaseStep;
import com.pixel.steps.commons.StepContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes=StepContext.class)
public class CasinoSteps extends BaseStep {

    @Autowired
    private StepContext stepContext;

    public CasinoSteps(StepContext stepContext) {
        super(stepContext.getDriver());
    }

    @And("the user navigates to Casino page")
    public void theUserNavigatesToCasinoPage() {
        geturl(stepContext.getServerURL()+stepContext.getLanguageURL()+"/casino");

    }

    @When("the user view search dialogue")
    public void theUserViewSearchDialogue() { //
        findElementClick("#casino-lobby > div:nth-child(1) > section > span",Pather.cssSelector);
    }


    @And("^the user searches for (.+)$")
    public void theUserSearchesFor(String gamename) throws Throwable {
        stepContext.setGameNameContext(gamename);
        findElement("search-box",Pather.id,TimeOut.MIDDLE).sendKeys(gamename);
        findElement("search-box",Pather.id,TimeOut.MIDDLE).sendKeys(Keys.ENTER);
        waitForElementNotPresent("(//*[contains(text(), 'Recommended')])[last()]",Pather.xPath,TimeOut.MIDDLE);
        if(!isTextPresent(gamename)){
            Assert.fail();}

    }

    @And("^the user opens the game$")
    public void theUserOpensTheGame() throws Throwable {
        // waits for results to populate
        findElement("//body > div:nth-child(15) > div.fade.PixelPurpleNew.CasinoSearchModal.in.modal > div > div > div.modal-body > div > div > section.search-section.sticky-search > div > div.casino-search-res",
                Pather.cssSelector,
                TimeOut.LOW);
        findElementClick("(//*[contains(text(), '"+stepContext.getGameNameContext()+"')])[last()]",Pather.xPath);
    }

    @Then("the user is confirms the game has loaded")
    public void theUserIsConfirmsTheGameHasLoaded() {
        waitForIFrameToLoad("game-iframe",Pather.id,TimeOut.HIGH);

    }

    @And("the user exits game")
    public void theUserExitsGame() {
        stepContext.getDriver().switchTo().defaultContent();
        findElementClick("#casino-desktop-iframe > div > div > span.close-game",
                Pather.cssSelector);

    }




}
