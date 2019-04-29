package com.googleapi.runners;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = { "src/test/resources/features/api/googlemaps.feature" }, glue = {
		"com.googleapi.steps" })
public class GoogleGeoAPITest {
}
