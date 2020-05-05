package steps;

import io.qameta.allure.Step;
import pages.CartPage;
import pages.ProductDetailsPage;

public class CartPageSteps {
    private ProductDetailsPage deliveryProductDetailsPage;
    private ProductDetailsPage collectProductDetailsPage;
    private CartPage cartPage;


    public CartPageSteps() {
        deliveryProductDetailsPage = new ProductDetailsPage();
        collectProductDetailsPage = new ProductDetailsPage();
        cartPage = new CartPage();
    }

    @Step("User navigates to Cart page")
    public CartPageSteps openCartPage() {
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

}

