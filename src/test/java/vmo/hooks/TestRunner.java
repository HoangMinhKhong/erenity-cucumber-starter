package vmo.hooks;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "F:\\work_space\\MyEC\\serenity-cucumber\\src\\test\\resources\\features\\taskManagement\\TaskManagement.feature",
        glue = "stepDefinition",
        tags = "@taskManagement"
        )
public class TestRunner {
}
