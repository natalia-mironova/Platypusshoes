package steps;

import data.URLs;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import pages.CartPage;
import pages.ProductDetailsPage;

@Log4j2

public class ProductDetailsPageSteps {
    private ProductDetailsPage deliveryProductDetailsPage;
    private ProductDetailsPage collectProductDetailsPage;
    private CartPage cartPage;

    public ProductDetailsPageSteps() {
        deliveryProductDetailsPage = new ProductDetailsPage();
        collectProductDetailsPage = new ProductDetailsPage();
        cartPage = new CartPage();
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
}
