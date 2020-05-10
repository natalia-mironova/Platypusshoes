package steps;

import data.URLs;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import pages.CartPage;
import pages.CheckoutGuestDeliveryPage;
import pages.ProductDetailsPage;

@Log4j2

public class CheckoutGuestDeliverySteps {
    private CheckoutGuestDeliveryPage checkoutGuestDeliveryPage;
    private ProductDetailsPage deliveryProductDetailsPage;
    private ProductDetailsPage collectProductDetailsPage;
    private CartPage cartPage;
    private CheckoutGuestDeliveryPage checkoutPage;

    public CheckoutGuestDeliverySteps() {
        checkoutGuestDeliveryPage = new CheckoutGuestDeliveryPage();
        deliveryProductDetailsPage = new ProductDetailsPage();
        collectProductDetailsPage = new ProductDetailsPage();
        cartPage = new CartPage();
        checkoutPage = new CheckoutGuestDeliveryPage();
    }

    @Step("Guest User places an order with Credit Card (Delivery method)")
    public CheckoutGuestDeliverySteps guestOrderDelivery(String email, String firstname, String lastname, String address, int postcode, int phone, String cardNumber, int date, int CVV) {
        log.info("Guest User places the order with Credit Card, 'Delivery' method");
        deliveryProductDetailsPage
                .openPage()
                .isPageOpened()
                .addDeliveryProductToCart()
                .isProductAdded()
                .minicartClick()
                .proceedToCheckoutButtonClick();
        checkoutGuestDeliveryPage
                .isPageOpened()
                .enterEmail(email)
                .checkoutAsGuestButtonClick()
                .isShippingStepOpened()
                .enterFirstname(firstname)
                .enterLastname(lastname)
                .enterAddress(address)
                .enterSuburbPostcode(postcode)
                .selectPostcode()
                .enterPhone(phone)
                .selectCreditCard()
                .enterCreditCardNumber(cardNumber)
                .enterCreditCardDate(date)
                .enterCVV(CVV)
                .placeOrderButtonClick()
                .isOSPOpened();
        return this;
    }


}
