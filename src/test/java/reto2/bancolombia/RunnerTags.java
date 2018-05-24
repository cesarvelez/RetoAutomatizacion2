package reto2.bancolombia;

//import org.junit.runner.

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
//import java.io;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions (features = "src/test/resources/features/forms/PrecioDeTiquetesAereos.feature", tags = "@TestCase1")
public class RunnerTags { 

}
