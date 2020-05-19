import com.ipresence.framework.utilities.Utils;
import io.cucumber.java.Scenario;
import io.cucumber.java.After;

public class Hooks {
	@After
	public void afterScenario(Scenario scenario) {
		if (scenario.isFailed()) {
			Utils.reportError(scenario);
		}
	}
}
