package steps;

import data.URLs;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import pages.CheckoutPage;
import pages.ProductDetailsPage;

@Log4j2

public class CheckoutSteps {
    private CheckoutPage checkoutPage;
    private ProductDetailsPage deliveryProductDetailsPage;
    private ProductDetailsPage collectProductPage;

    public CheckoutSteps() {
        checkoutPage = new CheckoutPage();
        deliveryProductDetailsPage = new ProductDetailsPage();
        collectProductPage = new ProductDetailsPage();
    }

    @Step("Guest User places an order with Credit Card (Delivery method)")
    public CheckoutSteps guestOrderDelivery(String email, String firstname, String lastname, String address, int postcode, int phone, String cardNumber, int date, int CVV) {
        log.info("Guest User places the order with Credit Card, 'Delivery' method, product URL: " + URLs.deliveryProductPageURL);
        deliveryProductDetailsPage
                .openPage()
                .isPageOpened()
                .addDeliveryProductToCart()
                .isProductAdded()
                .minicartClick()
                .proceedToCheckoutButtonClick();
        checkoutPage
                .isPageOpened()
                .enterEmail(email)
                .checkoutAsGuestButtonClick()
                .isShippingStepOpened()
                .enterShippingFirstname(firstname)
                .enterShippingLastname(lastname)
                .enterShippingAddress(address)
                .enterShippingSuburbPostcode(postcode)
                .selectShippingPostcode()
                .enterShippingPhone(phone)
                .selectCreditCard()
                .enterCreditCardNumber(cardNumber)
                .enterCreditCardDate(date)
                .enterCVV(CVV)
                .placeOrderButtonClick()
                .isOSPOpened();
        return this;
    }


    @Step("Guest User places an order with Credit Card (Click&Collect method)")
    public CheckoutSteps guestOrderClickCollect(int postcode, String email, String firstname, String lastname, String address, int phone, String cardNumber, int date, int CVV) {
        log.info("Guest User places the order with Credit Card, 'Click&Collect' method, product URL: " + URLs.collectProductPageURL);
        collectProductPage
                .openClickAndCollectPage()
                .isCollectPageOpened()
                .addClickAndCollectProductToCart(postcode)
                .isProductAdded()
                .minicartClick()
                .proceedToCheckoutButtonClick();
        checkoutPage
                .isPageOpened()
                .enterEmail(email)
                .checkoutAsGuestButtonClick()
                .selectCreditCard()
                .enterBillingFirstname(firstname)
                .enterBillingLastname(lastname)
                .enterBillingAddress(address)
                .enterBillingSuburbPostcode(postcode)
                .selectBillingPostcode()
                .enterBillingPhone(phone)
                .updateButtonClick()
                .enterCreditCardNumber(cardNumber)
                .enterCreditCardDate(date)
                .enterCVV(CVV)
                .placeOrderButtonClick()
                .isOSPOpened();
        return this;
    }

}
