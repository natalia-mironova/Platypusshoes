package tests;

import data.CustomerData;
import io.qameta.allure.*;
import org.testng.annotations.Test;

public class MyAccountTests extends BaseTest{
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Check if My Account Page is opened after registration")
    @Description("Check if My Account Page is opened after registration")
    @Link("https://staging.platypusshoes.com.au/customer/account/")
    @Issue("no_issue")
    @TmsLink("555555")
    public void openMyAccountPage() {
        myAccountSteps
                .openMyAccountPage(CustomerData.loginEmail, CustomerData.customerPassword)
                .isMyAccountPageOpened();
    }

}
