package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;

public class HomepageTests extends BaseTest {
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "User opens Homepage")
    @Description("User opens Homepage")
    @Link("https://staging.platypusshoes.com.au/")
    @Issue("123123")
    @TmsLink("333444")
    public void openHomepageTest() {
        homepageSteps.openHomepageStep();
    }

}
