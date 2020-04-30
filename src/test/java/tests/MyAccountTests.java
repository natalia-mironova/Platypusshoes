package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;

public class MyAccountTests extends BaseTest{
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Test 1: Check if My Account Page is opened after registration")
    @Description("Check if My Account Page is opened after registration")
    @Link("https://staging.platypusshoes.com.au/customer/account/")
    @Issue("no_issue")
    @TmsLink("555555")
    public void validateIfMyAccountPageOpened() {
        myAccountSteps.isMyAccountPageOpened();
    }
}
