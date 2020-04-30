package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;

public class HomepageTests extends BaseTest {
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "User opens Homepage", priority = 1)
    @Description("User opens Homepage")
    @Link("https://staging.platypusshoes.com.au/")
    @Issue("123123")
    @TmsLink("333444")
    public void openHomepageTest() {
        homepageSteps.openHomepageStep("https://staging.platypusshoes.com.au/");
    }

    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Validation if Homepage is opened", priority = 2)
    @Description("Check if Homepage is opened")
    @Link("https://staging.platypusshoes.com.au/")
    @Issue("555444")
    @TmsLink("555666")
    public void isHomepageOpenedTest() {
        homepageSteps.openHomepageStep("https://staging.platypusshoes.com.au/");
        homepageSteps.isHomepageOpenedValidation();
    }
}
