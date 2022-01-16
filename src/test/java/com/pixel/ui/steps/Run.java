package com.pixel.ui.steps;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true,
                 features = "src/test/resources/features/",
        tags="@apiLogin",
        plugin = {"pretty", "html:target/cucumber/report"},
        extraGlue = "com.pixel.ui.steps.commons")
public class Run {
}
