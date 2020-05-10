package steps;

import data.URLs;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import pages.CartPage;
import pages.CheckoutGuestDeliveryPage;
import pages.ProductDetailsPage;

@Log4j2

public class ProductDetailsPageSteps {
    private ProductDetailsPage deliveryProductDetailsPage;
    private ProductDetailsPage collectProductDetailsPage;
    private CartPage cartPage;
    private CheckoutGuestDeliveryPage checkoutPage;

    public ProductDetailsPageSteps() {
        deliveryProductDetailsPage = new ProductDetailsPage();
        collectProductDetailsPage = new ProductDetailsPage();
        cartPage = new CartPage();
        checkoutPage = new CheckoutGuestDeliveryPage();
    }

    @Step("User opens PDP")
    public ProductDetailsPageSteps openPDPStep() {
        log.info("User opens PDP of 'Delivery' product, " + URLs.deliveryProductPageURL);
        deliveryProductDetailsPage
                .openPage()
                .isPageOpened();
        return this;
    }

    @Step("User adds 'Delivery' product to Cart")
    public ProductDetailsPageSteps addDeliveryProductToCartStep() {
        log.info("User adds 'Delivery' product to Cart, " + URLs.deliveryProductPageURL);
        deliveryProductDetailsPage
                .openPage()
                .isPageOpened()
                .addDeliveryProductToCart()
                .isProductAdded();
        return this;
    }

    @Step("User adds 'C&C' product to Cart")
    public ProductDetailsPageSteps addClickAndCollectProductToCartStep(int postcode) {
        log.info("User adds 'Click&Collect' product to Cart, " + URLs.collectProductPageURL);
        collectProductDetailsPage
                .openClickAndCollectPage()
                .isCollectPageOpened()
                .addClickAndCollectProductToCart(postcode)
                .isProductAdded();
        return this;
    }

    @Step("User clicks 'View or update Cart' link")
    public CartPage viewOrUpdateCartLinkClick() {
        deliveryProductDetailsPage
                .openPage()
                .isPageOpened()
                .addDeliveryProductToCart()
                .isProductAdded()
                .minicartClick()
                .viewCartLinkClick();
        return cartPage;
    }

    @Step("User clicks 'Proceed to Checkout' button in minicart with 'Delivery' product added")
    public CheckoutGuestDeliveryPage proceedToCheckoutButtonClickDeliveryProduct() {
        deliveryProductDetailsPage
                .openPage()
                .isPageOpened()
                .addDeliveryProductToCart()
                .isProductAdded()
                .minicartClick()
                .proceedToCheckoutButtonClick();
        return checkoutPage;
    }

    @Step("User clicks 'Proceed to Checkout' button in minicart with 'C&C' product added")
    public CheckoutGuestDeliveryPage proceedToCheckoutButtonClickCCProduct(int postcode) {
        collectProductDetailsPage
                .openClickAndCollectPage()
                .isCollectPageOpened()
                .isCollectPageOpened()
                .addClickAndCollectProductToCart(postcode)
                .isProductAdded()
                .minicartClick()
                .proceedToCheckoutButtonClick();
        return checkoutPage;
    }
}
