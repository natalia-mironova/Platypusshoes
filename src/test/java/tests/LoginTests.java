package tests;

import data.CustomerData;
import io.qameta.allure.*;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Test 1: User loggs in with valid credentials")
    @Description("Check if existing user is able to login into account")
    @Link("https://staging.platypusshoes.com.au/customer/account/login")
    @Issue("no_issue")
    @TmsLink("888777")
    public void login() {
        loginSteps.loginAsExistingUserStep(CustomerData.loginEmail, CustomerData.customerPassword);
    }
}
