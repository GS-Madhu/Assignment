package com.hotelbooking.testscripts;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "Features"
				,glue = "com.shopclues.testscripts"	
				)

public class TestRunner extends AbstractTestNGCucumberTests
{

}
