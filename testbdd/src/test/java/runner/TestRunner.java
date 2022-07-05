package runner;

import org.junit.runner.RunWith;

import io.cucumber.core.backend.CucumberBackendException;

@RunWith(Cucumbe.class)
@CucumberOptions(features="testbdd/src/test/java/features",glue="/testbdd/src/test/java/stepdefinitions/AddToCart.java")
public class TestRunner {

}
