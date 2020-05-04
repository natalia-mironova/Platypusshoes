package steps;

import io.qameta.allure.Step;
import pages.ProductListingPage;

public class ProductListingPageSteps {
    private ProductListingPage productListingPage;

    public ProductListingPageSteps() {
        productListingPage = new ProductListingPage();
    }

    @Step("Step 1: User loads more products")
    public ProductListingPageSteps loadMoreStep() {
        productListingPage
                .openPage()
                .loadMore()
                .loadMoreVerification();
        return this;
    }

    @Step("Step 2: User applies Black Colour filter")
    public ProductListingPageSteps filterStep() {
        productListingPage
                .openPage()
                .filter()
                .isPageFiltered();
        return this;
    }

    @Step("Step 3: User sorts Product Listing Page by highest price")
    public ProductListingPageSteps sortStep() {
        productListingPage
                .openPage()
                .sort()
                .isPageSorted();
        return this;
    }
}
