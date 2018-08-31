package com.cg.testrunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= {"Features"},
		glue= {"com.cg.stepdefinition"},
		tags= {"@create"}
		)
public class Runner {

}
