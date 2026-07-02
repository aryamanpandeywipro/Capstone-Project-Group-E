package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/java/features",
		glue={"stepDef", "Hooks"}, monochrome=true,
		plugin= {"pretty","html:target/BStackDemo.html"}
		)
public class Runner extends AbstractTestNGCucumberTests{

}
