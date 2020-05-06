package steps;

import data.URLs;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import pages.CartPage;
import pages.ProductDetailsPage;

@Log4j2

public class CartPageSteps {
    private ProductDetailsPage deliveryProductDetailsPage;
    private ProductDetailsPage collectProductDetailsPage;
    private CartPage cartPage;


    public CartPageSteps() {
        deliveryProductDetailsPage = new ProductDetailsPage();
        collectProductDetailsPage = new ProductDetailsPage();
        cartPage = new CartPage();
    }

    @Step("User navigates to Cart page ('Delivery' product in the Cart)")
    public CartPageSteps openCartPage() {
        log.info("User adds 'Delivery' product: " + URLs.deliveryProductPageURL + " to Cart and navigates to Cart page " + URLs.cartPageURL);
        deliveryProductDetailsPage
                .openPage()
                .isPageOpened()
                .addDeliveryProductToCart()
                .isProductAdded()
                .minicartClick()
                .viewCartLinkClick();
        cartPage.isPageOpened();
        return this;
    }

    @Step("User navigates to Cart page ('Delivery' product in the Cart)")
    public CartPageSteps openCartPageWithCCProduct(int postcode) {
        log.info("User adds 'C&C' product: " + URLs.collectProductPageURL + " to Cart and navigates to Cart page " + URLs.cartPageURL);
        deliveryProductDetailsPage
                .openClickAndCollectPage()
                .isCollectPageOpened()
                .addClickAndCollectProductToCart(postcode)
                .isProductAdded()
                .minicartClick()
                .viewCartLinkClick();
        cartPage.isPageOpened();
        return this;
    }

}

