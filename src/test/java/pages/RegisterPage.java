package pages;

import com.codeborne.selenide.Condition;
import data.URLs;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegisterPage extends BasePage {

    WebElement FIRSTNAMEFIELD = $(By.id("firstname"));
    WebElement LASTNAMEFIELD = $(By.id("lastname"));
    WebElement EMAILFIELD = $(By.id("email_address"));
    WebElement PASSWORDFIELD = $(By.id("password"));
    WebElement CONFIRMPASSWORDFIELD = $(By.id("password-confirmation"));
    WebElement CREATEACCOUNTBUTTON = $(".action.submit");

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @Step("User opens Register page URL")
    public RegisterPage openPage() {
        open(URLs.registerPageURL);
        return this;
    }

    @Step("Validation: is Register Page opened")
    public RegisterPage isPageOpened() {
        $(CREATEACCOUNTBUTTON).waitUntil(Condition.visible, 5000);
        return this;
    }

    @Step("User is entering First Name")
    public RegisterPage enterFirstName(String firstName) {
        $(FIRSTNAMEFIELD).setValue(firstName);
        return this;
    }

    @Step("User is entering Last Name")
    public RegisterPage enterLastName(String lastName) {
        $(LASTNAMEFIELD).setValue(lastName);
        return this;
    }

    @Step("User is entering Email")
    public RegisterPage enterEmail(String email) {
        $(EMAILFIELD).setValue(email);
        return this;
    }

    @Step("User is entering Password")
    public RegisterPage enterPassword(String password) {
        $(PASSWORDFIELD).setValue(password);
        return this;
    }

    @Step("User is entering Password Confirmation")
    public RegisterPage enterPasswordConfirmation(String password) {
        $(CONFIRMPASSWORDFIELD).setValue(password);
        return this;
    }

    @Step("User clicks 'Create Account' button")
    public RegisterPage clickCreateAccountButton() {
        $(CREATEACCOUNTBUTTON).click();
        return this;
    }
}

