import com.codeborne.selenide.junit.ScreenShooter;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.Rule;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		tags ={},
		features = "src/test/java/com/ipresence/features",
		plugin = {"pretty", "com.ipresence.framework.listener.TestListener", "html:target/cucumber",
				"junit:target/cucumber.xml"}
)
public class RunCucumberTest {
	@Rule
	public ScreenShooter makeScreenshotOnFailure = ScreenShooter.failedTests().succeededTests();
}
