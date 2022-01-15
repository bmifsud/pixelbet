package com.pixel.steps.login;

import com.pixel.steps.base.BaseStep;
import com.pixel.steps.commons.StepContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes=StepContext.class)
public class CasinoSteps extends BaseStep {

    @Autowired
    private StepContext stepContext;

    public CasinoSteps(StepContext stepContext) {
        super(stepContext.getDriver());
    }

    @When("the user view casino")
    public void theUserViewCasino() {
        findElementClick("#pixel-header > div > div.user-section > div.pixel-nav-container > a.header-nav-link.pixel-casino-icon.false",Pather.cssSelector);
    }

    @And("the user view search dialogue")
    public void theUserViewSearchDialogue() {
        findElementClick("#casino-lobby > div:nth-child(1) > section > span",Pather.cssSelector);
    }


}
