package tests;

import data.ProductData;
import io.qameta.allure.*;
import org.testng.annotations.Test;

public class ProductDetailsPageTests extends BaseTest {
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "User opens PDP")
    @Description("Check if user is able to register an account")
    @Link("https://staging.platypusshoes.com.au/ct-all-star-lo-19166-blk.html#93=3552")
    @Issue("no_issue")
    @TmsLink("555555")
    public void openPDP() {
        productDetailsPageSteps.openPDPStep();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "User adds product to Cart (Delivery)")
    @Description("Check if user is able to add product to Cart with Standard Delivery method")
    @Link("https://staging.platypusshoes.com.au/ct-all-star-lo-19166-blk.html#93=3552")
    @Issue("no_issue")
    @TmsLink("555555")
    public void addDeliveryProductToCart() {
        productDetailsPageSteps.addDeliveryProductToCartStep();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "User adds product to Cart (Click&Collect)")
    @Description("Check if user is able to add product to Cart with Click&Collect Delivery method")
    @Link("https://staging.platypusshoes.com.au/ct-all-star-lo-19166-blk.html#93=3552")
    @Issue("no_issue")
    @TmsLink("555555")
    public void addClickAndCollectProductToCart() {
        productDetailsPageSteps.addClickAndCollectProductToCartStep(ProductData.collectPostcode);
    }
}
