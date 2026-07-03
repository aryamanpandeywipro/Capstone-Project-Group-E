package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {"src/test/java/features/A_signIn.feature",
		"src/test/java/features/B_Navbar.feature"},
		glue={"stepDef", "Hooks"}, monochrome=true,
		plugin= {"pretty","html:target/CapstoneReport.html"}
		)
public class Runner extends AbstractTestNGCucumberTests{

}
