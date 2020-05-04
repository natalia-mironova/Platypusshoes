package steps;

import io.qameta.allure.Step;
import pages.ProductListingPage;

public class ProductListingPageSteps {
    private ProductListingPage productListingPage;

    public ProductListingPageSteps() {
        productListingPage = new ProductListingPage();
    }

    @Step("User loads more products")
    public ProductListingPageSteps loadMoreStep() {
        productListingPage
                .openPage()
                .loadMore()
                .loadMoreVerification();
        return this;
    }

    @Step("User applies Black Colour filter")
    public ProductListingPageSteps filterStep() {
        productListingPage
                .openPage()
                .filter()
                .isPageFiltered();
        return this;
    }

    @Step("User sorts Product Listing Page by highest price")
    public ProductListingPageSteps sortStep() {
        productListingPage
                .openPage()
                .sort()
                .isPageSorted();
        return this;
    }
}
