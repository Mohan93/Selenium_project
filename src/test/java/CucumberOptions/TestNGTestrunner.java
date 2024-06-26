package CucumberOptions;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/resources/features",
glue={"SetpDefinations"} ,monochrome=true, plugin = { "pretty", "json:target/cucumber-reports/cucumber.json" })

public class TestNGTestrunner extends AbstractTestNGCucumberTests{

	@Override
	@DataProvider(parallel = false)
	public Object[][] scenarios() {
		return super.scenarios();
	}
}
