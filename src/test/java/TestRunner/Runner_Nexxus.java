package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
//import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Feature/Nexxus",
        //format={"json:target/cucumber.json"},
        //plugin = {"json:resources/cucumber.json","html:resources/cucumber.html"},

        glue = "Steps",
        plugin = {"pretty","io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"},
        tags = "@logo",
        monochrome = true
)

public class Runner_Nexxus {
}
