package pages;

import com.codeborne.selenide.Condition;
import data.URLs;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage extends BasePage {

    WebElement LOGINORCREATEACCOUNT = $(By.xpath("//span[contains(text(),'Login or')]"));
    WebElement EMAILADDRESSFIELD = $(By.id("email"));
    WebElement PASSWORDFIELD = $(By.id("pass"));
    WebElement LOGINBUTTON = $(By.id("send2"));

    @Step("Validation: is Login Page opened")
    public LoginPage isPageOpened() {
        $(LOGINORCREATEACCOUNT).waitUntil(Condition.visible, 5000);
        return this;
    }

    @Step("User opens Login page URL")
    public LoginPage openPage() {
        open(URLs.loginPageURL);
        return this;
    }

    @Step("User is entering Email Address")
    public LoginPage enterEmailAddress(String email) {
        $(EMAILADDRESSFIELD).setValue(email);
        return this;
    }

    @Step("User is entering Password")
    public LoginPage enterPassword(String password) {
        $(PASSWORDFIELD).setValue(password);
        return this;
    }

    @Step("User is clicking Login button")
    public LoginPage clickLoginButton() {
        $(LOGINBUTTON).click();
        return this;
    }
}
