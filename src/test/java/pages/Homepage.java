package pages;

import com.codeborne.selenide.Condition;
import data.URLs;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Homepage extends BasePage {

    WebElement TRENDINGNOWBLOCK = $(By.cssSelector(".row"));

    public Homepage(WebDriver driver) {
        super(driver);
    }

    @Step("Opening Homepage")
    public Homepage openPage() {
        open(URLs.baseURL);
        return this;
    }

    @Step("Validating if Homepage is opened")
    public Homepage isPageOpened() {
        $(TRENDINGNOWBLOCK).waitUntil(Condition.visible, 30000);
        return this;
    }

}
