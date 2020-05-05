package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;

public class CartPageTests extends BaseTest {
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "User opens Cart page")
    @Description("Check if user is able to register an account")
    @Link("https://staging.platypusshoes.com.au/checkout/cart")
    @Issue("no_issue")
    @TmsLink("555555")
    public void openCartPage() {
        cartPageSteps.openCartPage();
    }
}
