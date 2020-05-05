package steps;

import io.qameta.allure.Step;
import pages.CartPage;
import pages.ProductDetailsPage;

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
        deliveryProductDetailsPage
                .openPage()
                .isPageOpened();
        return this;
    }

    @Step("User adds 'Delivery' product to Cart")
    public ProductDetailsPageSteps addDeliveryProductToCartStep() {
        deliveryProductDetailsPage
                .openPage()
                .isPageOpened()
                .addDeliveryProductToCart()
                .isProductAdded();
        return this;
    }

    @Step("User adds 'C&C' product to Cart")
    public ProductDetailsPageSteps addClickAndCollectProductToCartStep(int postcode) {
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
                .minicartClick()
                .viewCartLinkClick();
        return cartPage;
    }
}
