package tests;

import data.ProductData;
import io.qameta.allure.*;
import org.testng.annotations.Test;

public class CartPageTests extends BaseTest {
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "User opens Cart page with 'Delivery' product in the Cart")
    @Description("Check if user is able to navigate to Cart page with 'Delivery' product in the Cart")
    @Link("https://staging.platypusshoes.com.au/checkout/cart")
    @Issue("no_issue")
    @TmsLink("555555")
    public void openCartPageWithDeliveryProductInCart() {
        cartPageSteps.openCartPageWithDeliveryProduct();
    }

    @Severity(SeverityLevel.NORMAL)
    @Test(description = "User opens Cart page with C&C product in the Cart")
    @Description("Check if user is able to navigate to Cart page with 'C&C' product in the Cart")
    @Link("https://staging.platypusshoes.com.au/checkout/cart")
    @Issue("no_issue")
    @TmsLink("555555")
    public void openCartPageWithCCProductInCart() {
        cartPageSteps.openCartPageWithCCProduct(ProductData.collectPostcode);
    }

}
