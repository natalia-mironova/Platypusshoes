package tests;

import data.ProductData;
import io.qameta.allure.*;
import org.testng.annotations.Test;

public class ProductDetailsPageTests extends BaseTest {
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "User opens PDP")
    @Description("Check if user is able to open PDP")
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

    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "User clicks 'View or Update Cart' link in minicart")
    @Description("Check if user is able to proceed to Cart page from PDP")
    @Link("https://staging.platypusshoes.com.au/ct-all-star-lo-19166-blk.html#93=3552")
    @Issue("no_issue")
    @TmsLink("555555")
    public void viewCartLinkClick() {
        productDetailsPageSteps.viewOrUpdateCartLinkClick();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "User clicks 'Proceed to Checkout' button in minicart with C&C product in Cart")
    @Description("Check if user is able to proceed to Checkout page from PDP with C&C product in Cart")
    @Link("https://staging.platypusshoes.com.au/checkout")
    @Issue("no_issue")
    @TmsLink("555555")
    public void proceedToCheckoutButtonClick() {
        productDetailsPageSteps.proceedToCheckoutButtonClickCCProduct(ProductData.collectPostcode);
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "User clicks 'Proceed to Checkout' button in minicart with Delivery product in Cart")
    @Description("Check if user is able to proceed to Checkout page from PDP with Delivery product in Cart")
    @Link("https://staging.platypusshoes.com.au/checkout")
    @Issue("no_issue")
    @TmsLink("555555")
    public void proceedToCheckoutButtonClickDeliveryProduct() {
        productDetailsPageSteps.proceedToCheckoutButtonClickDeliveryProduct();
    }
}
