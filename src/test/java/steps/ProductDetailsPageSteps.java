package steps;

import io.qameta.allure.Step;
import pages.ProductDetailsPage;

public class ProductDetailsPageSteps {
    private ProductDetailsPage deliveryProductDetailsPage;
    private ProductDetailsPage collectProductDetailsPage;

    public ProductDetailsPageSteps() {
        deliveryProductDetailsPage = new ProductDetailsPage();
        collectProductDetailsPage = new ProductDetailsPage();
    }

    @Step("Step1: User opens PDP")
    public ProductDetailsPageSteps openPDPStep() {
        deliveryProductDetailsPage
                .openPage()
                .isPageOpened();
        return this;
    }

    @Step("Step 2: User adds 'Delivery' product to Cart")
    public ProductDetailsPageSteps addDeliveryProductToCartStep() {
        deliveryProductDetailsPage
                .openPage()
                .isPageOpened()
                .addDeliveryProductToCart()
                .isProductAdded();
        return this;
    }

    @Step("Step 3: User adds 'C&C' product to Cart")
    public ProductDetailsPageSteps addClickAndCollectProductToCartStep(int postcode) {
        collectProductDetailsPage
                .openClickAndCollectPage()
                .isCollectPageOpened()
                .addClickAndCollectProductToCart(postcode)
                .isProductAdded();
        return this;
    }
}
