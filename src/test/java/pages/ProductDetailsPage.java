package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import data.URLs;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.*;

public class ProductDetailsPage extends BasePage {

    WebElement COLLECTPRODUCTNAME = $(By.xpath("//span[text()='Superstar Originals Foundation']"));
    WebElement DELIVERYPRODUCTNAME = $(By.xpath("//span[text()='CT All Star Lo']"));
    WebElement SIZEDELIVERY = $(By.xpath("//*[@id='tab-content-size_us_mens-93-3552']//div[8]"));
    WebElement SIZECOLLECT = $(By.xpath("//*[@id='tab-content-size_us_mens-93-3653']//div[7]"));
    WebElement ADDTOCARTBUTTON = $(By.id("product-addtocart-button"));
    WebElement BUYANDCOLLECTBUTTON = $(By.xpath("//*[@id='product_addtocart_form']/div[2]/div[2]/div/div/button[1]"));
    WebElement ADDTOCARTSUCESSMESSAGE = $(By.xpath("//div[contains(text(),'You added')]"));
    WebElement CLICKANDCOLLECTOPTION = $(By.xpath("//span[contains(text(),'Click')]"));
    WebElement COLLECTPOSTCODEFIELD = $(By.id("postcode"));
    WebElement CHECKLINK = $(By.cssSelector(".as-link.check"));
    WebElement COLLECTSTORE = $(By.xpath("//*[text()='Platypus Shoes Chadstone']"));
    WebElement MINICARTICON = $(By.cssSelector(".showcart"));
    WebElement VIEWCARTLINK = $(By.xpath("//*[@id='minicart-content-wrapper']//*[@class='actions']//a"));
    WebElement PROCEEDTOCHECKOUTBUTTON = $(By.id("top-cart-btn-checkout"));

    @Step("User opens PDP (Delivery)")
    public ProductDetailsPage openPage() {
        open(URLs.deliveryProductPageURL);
        return this;
    }

    @Step("User opens PDP (Click&Collect)")
    public ProductDetailsPage openClickAndCollectPage() {
        open(URLs.collectProductPageURL);
        return this;
    }

    @Step("Is Delivery product PDP opened")
    public ProductDetailsPage isPageOpened() {
        $(DELIVERYPRODUCTNAME).waitUntil(Condition.visible, 20000);
        return this;
    }

    @Step("Is C&C product PDP opened")
    public ProductDetailsPage isCollectPageOpened() {
        $(COLLECTPRODUCTNAME).waitUntil(Condition.visible, 20000);
        return this;
    }

    @Step("Add product to Cart (Standard Delivery Shipping Method)")
    public ProductDetailsPage addDeliveryProductToCart() {
        sleep(20000);
        $(SIZEDELIVERY).waitUntil(Condition.appears, 30000).click();
        $(ADDTOCARTBUTTON).waitUntil(Condition.visible, 15000).click();
        return this;
    }

    @Step("Add product to Cart (Click&Collect Shipping Method)")
    public ProductDetailsPage addClickAndCollectProductToCart(int postcode) {
        sleep(20000);
        $(SIZECOLLECT).waitUntil(Condition.appears, 50000).click();
        $(CLICKANDCOLLECTOPTION).waitUntil(Condition.visible, 50000).click();
        $(COLLECTPOSTCODEFIELD).setValue(String.valueOf(postcode));
        $(CHECKLINK).click();
        $(COLLECTSTORE).waitUntil(Condition.visible, 50000).click();
        $(BUYANDCOLLECTBUTTON).waitUntil(Condition.visible, 50000).click();
        return this;
    }

    @Step("Is product added to Cart")
    public ProductDetailsPage isProductAdded() {
        $(ADDTOCARTSUCESSMESSAGE).waitUntil(Condition.visible, 60000);
        return this;
    }

    @Step("Click on minicart")
    public ProductDetailsPage minicartClick() {
        $(MINICARTICON).waitUntil(Condition.visible, 60000).click();
        return this;
    }

    @Step("Click 'View or update cart' link in minicart")
    public ProductDetailsPage viewCartLinkClick() {
        $(VIEWCARTLINK).waitUntil(Condition.visible, 60000).click();
        return this;
    }

    @Step("User clicks 'Proceed to Checkout' button in minicart")
    public ProductDetailsPage proceedToCheckoutButtonClick() {
        $(PROCEEDTOCHECKOUTBUTTON).waitUntil(Condition.visible, 60000).click();
        return this;
    }
}
