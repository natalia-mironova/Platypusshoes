package tests;

import data.CustomerData;
import data.ProductData;
import io.qameta.allure.*;
import org.testng.annotations.Test;

public class CheckoutTests extends BaseTest {
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Guest User places an order with Delivery item in Cart")
    @Description("Check if Guest User is able to place an order with Credit Card, 'Delivery' item")
    @Link("https://staging.platypusshoes.com.au/checkout/")
    @Issue("no_issue")
    @TmsLink("555555")
    public void guestCheckoutDeliveryCreditCard() {
        checkoutSteps.guestOrderDelivery(CustomerData.email, CustomerData.customerName, CustomerData.customerLastName, CustomerData.guestCustomerAddress, CustomerData.shippingPostcode, CustomerData.customerPhone, CustomerData.creditCardNumber, CustomerData.creditCardDate, CustomerData.CVV);
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Guest User places an order with C&C item in Cart")
    @Description("Check if Guest User is able to place an order with Credit Card, 'C&C' item")
    @Link("https://staging.platypusshoes.com.au/checkout/")
    @Issue("no_issue")
    @TmsLink("555555")
    public void guestCheckoutClickCollectCreditCard() {
        checkoutSteps.guestOrderClickCollect(ProductData.collectPostcode, CustomerData.email, CustomerData.customerName, CustomerData.customerLastName, CustomerData.guestCustomerAddress, CustomerData.customerPhone, CustomerData.creditCardNumber, CustomerData.creditCardDate, CustomerData.CVV);
    }

}
