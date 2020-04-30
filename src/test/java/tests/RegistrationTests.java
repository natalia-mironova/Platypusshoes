package tests;

import data.CustomerData;
import io.qameta.allure.*;
import org.testng.annotations.Test;

public class RegistrationTests extends BaseTest {
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Test 1: Account Registration", priority = 1)
    @Description("Check if user is able to register an account")
    @Link("https://staging.platypusshoes.com.au/customer/account/create")
    @Issue("no_issue")
    @TmsLink("555555")
    public void register() {
        registrationSteps.registerNewUserStep(CustomerData.customerName, CustomerData.customerLastName, CustomerData.customerEmail, CustomerData.customerPassword);
    }

    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Test 2: Check if My Account Page is opened after registration", priority = 2)
    @Description("Check if My Account Page is opened after registration")
    @Link("https://staging.platypusshoes.com.au/customer/account/create")
    @Issue("no_issue")
    @TmsLink("555555")
    public void validateIfMyAccountPageOpened(){
        registrationSteps.isMyAccountPageOpenedAfterRegistration();
    }
}
