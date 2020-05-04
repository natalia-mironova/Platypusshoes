package pages;

import com.codeborne.selenide.Condition;
import data.URLs;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.*;

public class ProductDetailsPage extends BasePage {

    WebElement COLLECTPRODUCTNAME = $(By.xpath("//span[text()='Superstar Originals Foundation']"));
    WebElement DELIVERYPRODUCTNAME = $(By.xpath("//span[text()='CT All Star Lo']"));
    WebElement SIZE10 = $(By.xpath("//*[@id='tab-content-size_us_mens-93-3552']/div[8]"));
    WebElement SIZE7 = $(By.xpath("//*[@id='tab-content-size_us_mens-93-3653']//div[7]"));
    WebElement ADDTOCARTBUTTON = $(By.id("product-addtocart-button"));
    WebElement BUYANDCOLLECTBUTTON = $(By.xpath("//*[@id='product_addtocart_form']/div[2]/div[2]/div/div/button[1]"));
    WebElement ADDTOCARTSUCESSMESSAGE = $(By.xpath("//div[contains(text(),'You added')]"));
    WebElement CLICKANDCOLLECTOPTION = $(By.xpath("//*[@class='delivery-block'][1]//*[@id='delivery_type_collect']"));
    WebElement COLLECTPOSTCODEFIELD = $(By.id("postcode"));
    WebElement CHECKLINK = $(By.cssSelector(".as-link.check"));
    WebElement COLLECTSTORE = $(By.xpath("//*[text()='Platypus Shoes Chadstone']"));

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

    @Step("Is PDP opened")
    public ProductDetailsPage isPageOpened() {
        $(DELIVERYPRODUCTNAME).waitUntil(Condition.visible, 15000);
        return null;
    }

    @Step("Is C&C page opened")
    public ProductDetailsPage isCollectPageOpened() {
        $(COLLECTPRODUCTNAME).waitUntil(Condition.visible, 10000);
        return this;
    }

    @Step("Add product to Cart (Standard Delivery Shipping Method")
    public ProductDetailsPage addDeliveryProductToCart() {
        $(SIZE10).click();
        sleep(10000);
        $(ADDTOCARTBUTTON).click();
        return this;
    }

    @Step("Add product to Cart (Click&Collect Shipping Method")
    public ProductDetailsPage addClickAndCollectProductToCart(int postcode) {
        $(SIZE7).click();
        sleep(5000);
        $(CLICKANDCOLLECTOPTION).click();
        $(COLLECTPOSTCODEFIELD).setValue(String.valueOf(postcode));
        $(CHECKLINK).click();
        sleep(15000);
        $(COLLECTSTORE).click();
        $(BUYANDCOLLECTBUTTON).click();
        return this;
    }

    @Step("Is product added to Cart")
    public ProductDetailsPage isProductAdded() {
        $(ADDTOCARTSUCESSMESSAGE).waitUntil(Condition.visible, 20000);
        return this;
    }
}
