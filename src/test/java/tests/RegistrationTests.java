package tests;

import data.CustomerData;
import io.qameta.allure.*;
import org.testng.annotations.Test;

public class RegistrationTests extends BaseTest {
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Test 1: Account Registration with valid credentials")
    @Description("Check if user is able to register an account")
    @Link("https://staging.platypusshoes.com.au/customer/account/create")
    @Issue("no_issue")
    @TmsLink("555555")
    public void register() {
        registrationSteps.registerNewUserStep(CustomerData.customerName, CustomerData.customerLastName, CustomerData.email, CustomerData.customerPassword);
    }

}
