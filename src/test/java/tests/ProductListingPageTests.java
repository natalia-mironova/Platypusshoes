package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;

public class ProductListingPageTests extends BaseTest {
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "User loads more products")
    @Description("Check if user is able to load more products on the PLP")
    @Link("https://staging.platypusshoes.com.au/shop/womens")
    @Issue("no_issue")
    @TmsLink("555555")
    public void loadMoreProducts() {
        productListingPageSteps.loadMoreStep();
    }

    @Severity(SeverityLevel.NORMAL)
    @Test(description = "User filters Product Listing Page")
    @Description("Check if user is able to apply a filter on the PLP")
    @Link("https://staging.platypusshoes.com.au/shop/womens")
    @Issue("no_issue")
    @TmsLink("555555")
    public void filterProductListingPage() {
        productListingPageSteps.filterStep();
    }

    @Severity(SeverityLevel.NORMAL)
    @Test(description = "User applies sorting on the Product Listing Page")
    @Description("Check if user is able to sort the PLP")
    @Link("https://staging.platypusshoes.com.au/shop/womens")
    @Issue("no_issue")
    @TmsLink("555555")
    public void sortProductListingPageDesc() {
        productListingPageSteps.sortStep();
    }

}
