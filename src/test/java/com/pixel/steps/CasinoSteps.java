package com.pixel.steps;

import com.pixel.steps.base.BaseStep;
import com.pixel.steps.commons.StepContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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

    @And("the user uses wild card to load all games")
    public void theUserUsesWildCardToLoadAllGames() {


    }

    @And("the users scrolls and saves all game names")
    public void theUsersScrollsAndSavesAllGameNames() {

    }

    @Then("the user is confirms all the games accessed have loaded")
    public void theUserIsConfirmsAllTheGamesAccessedHaveLoaded() {

    }


}
