package com.pixel.steps.commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

@Component
@Scope(SCOPE_CUCUMBER_GLUE)
public class StepContext {

    private WebDriver driver;



    private final String SERVER_URL = "http://localhost";
    private final String THINGS_ENDPOINT = "/things";

    @PostConstruct
    public WebDriver driver(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\drivers\\chromedriver.exe");
        System.setProperty("webdriver.chrome.whitelistedIps", "");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }
    public WebDriver getDriver() {
        return driver;
    }
}