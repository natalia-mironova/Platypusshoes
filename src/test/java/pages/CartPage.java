package pages;

import com.codeborne.selenide.Condition;
import data.URLs;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CartPage extends BasePage {

    WebElement PRODUCTNAMEELEMENT = $(By.xpath("//span[contains(text(),'Product name')]"));

    @Step("User navigates to Cart page")
    public CartPage openPage() {
        open(URLs.cartPageURL);
        return this;
    }

    @Step("Validation: is Cart page opened")
    public CartPage isPageOpened() {
        $(PRODUCTNAMEELEMENT).waitUntil(Condition.visible, 10000).shouldBe(Condition.visible);
        return this;
    }
}
