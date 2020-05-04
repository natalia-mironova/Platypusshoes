package pages;

import com.codeborne.selenide.Condition;
import data.URLs;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ProductListingPage extends BasePage {
    WebElement WOMENSHEADING = $(By.xpath("//*[@id=\"page-title-heading\"]/h1"));
    WebElement LOADMOREBUTTON = $(By.xpath("//*[@id=\"js_infinity_scroll_load_more\"]"));
    WebElement COLOURFILTER = $(By.xpath("//*[@id=\"narrow-by-list\"]/div[1]/div[2]/div[2]/div[1]/div"));
    WebElement BLACKCOLOUR = $(By.xpath("//*[@id=\"facet-colour\"]/li[1]/a/label"));
    WebElement SORTING = $(By.xpath("//*[@id=\"amasty-shopby-product-list\"]/div[2]/div[2]/div/div/div[1]/div/label/span"));
    WebElement PRICEDESC = $(By.xpath("//*[@id=\"sorter\"]/a[2]"));

    @Step("User opens Product Listing pPage URL")
    public ProductListingPage openPage() {
        open(URLs.productListingPageURL);
        return this;
    }

    @Step("Validation: is Product Listing Page opened")
    public ProductListingPage isPageOpened() {
        $(WOMENSHEADING).waitUntil(Condition.visible, 5000);
        return this;
    }

    @Step("User clicks 'Load more' button")
    public ProductListingPage loadMore() {
        $(LOADMOREBUTTON).click();
        return this;
    }

    @Step("Load more verification")
    public ProductListingPage loadMoreVerification() {
        return this;
    }

    @Step("User applies filter option")
    public ProductListingPage filter() {
        $(COLOURFILTER).click();
        $(BLACKCOLOUR).click();
        return this;
    }

    @Step("Is Page Filtered")
    public ProductListingPage isPageFiltered() {
        return this;
    }

    @Step("User applies sorting option")
    public ProductListingPage sort() {
        $(SORTING).click();
        $(PRICEDESC).click();
        return this;
    }

    @Step("Is Page Sorted")
    public ProductListingPage isPageSorted() {
        return this;
    }

}
