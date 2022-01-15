package com.pixel.steps.login;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true,
        features = "src/test/resources/features/",
        //tags="@login",
        plugin = {"pretty", "html:target/cucumber/report"},
        extraGlue = "com.pixel.steps.commons")
public class Run {
}
