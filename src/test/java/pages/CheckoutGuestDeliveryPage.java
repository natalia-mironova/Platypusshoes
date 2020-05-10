package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import data.URLs;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.net.URL;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;

public class CheckoutGuestDeliveryPage extends BasePage {
    WebElement CHECKOUTEMAILFIELD = $(By.id("customer-email"));
    WebElement YOURDETAILSELEMENT = $(By.xpath("//*[text()='Your details']"));
    WebElement CHECKOUTASGUESTBUTTON = $(By.xpath("//*[@id='customer-email-fieldset']/div[3]/div[2]/div/button[1]"));
    WebElement FIRSTNAMEFIELD = $(".fieldset.address input[name='firstname']");
    WebElement LASTNAME = $(".fieldset.address input[name='lastname']");
    WebElement ADDRESSFIELD = $("#checkout-step-shipping input[name='street[0]']");
    WebElement SUBURBPOSTCODEFIELD = $("#checkout-step-shipping input[name='suburb_postcode']");
    WebElement SELECTEDPOSTCODE = $("#ui-id-1 li:nth-child(2) a");
    WebElement PHONEFIELD = $("#checkout-step-shipping input[name='telephone']");
    WebElement CREDITCARD = $(By.className("credit-card-types"));
    WebElement CCNUMBERFRAME = $(By.xpath("//form[contains(@class,'form-braintree')]//iframe[@name='braintree-hosted-field-number']"));
    WebElement CREDITCARDNUMBER = $(By.id("credit-card-number"));
    WebElement CCDATEFRAME = $(By.xpath("//form[contains(@class,'form-braintree')]//iframe[@name='braintree-hosted-field-expirationDate']"));
    WebElement CREDITCARDDATE = $(By.id("expiration"));
    WebElement CVVFRAME = $(By.xpath("//form[contains(@class,'form-braintree')]//iframe[@name='braintree-hosted-field-cvv']"));
    WebElement CREDITCARDCVV = $(By.id("cvv"));
    WebElement PLACEORDERBUTTON = $(".place-order-container");

    @Step("User navigates to Checkout page")
    public CheckoutGuestDeliveryPage openPage() {
        open(URLs.checkoutURL);
        return this;
    }

    @Step("Validation: is Checkout page opened")
    public CheckoutGuestDeliveryPage isPageOpened() {
        url();
        Assert.assertEquals(url(), URLs.checkoutURL, "Checkout page is not opened");
        return this;
    }

    @Step("Guest User enters email on checkout")
    public CheckoutGuestDeliveryPage enterEmail(String email) {
        sleep(15000);
        $(CHECKOUTEMAILFIELD).waitUntil(Condition.appears, 20000).setValue(email);
        sleep(10000);
        $(YOURDETAILSELEMENT).click();
        return this;
    }

    @Step("User clicks 'Checkout as Guest' button")
    public CheckoutGuestDeliveryPage checkoutAsGuestButtonClick() {
        $(CHECKOUTASGUESTBUTTON).waitUntil(Condition.appears, 20000).click();
        return this;
    }

    @Step("Validation: is Shipping Step opened")
    public CheckoutGuestDeliveryPage isShippingStepOpened() {
        $(FIRSTNAMEFIELD).waitUntil(Condition.appears, 10000);
        return this;
    }

    @Step("User enters Firstname at checkout")
    public CheckoutGuestDeliveryPage enterFirstname(String firstName) {
        $(FIRSTNAMEFIELD).waitUntil(Condition.visible, 10000).setValue(firstName);
        return this;
    }

    @Step("User enters Lastname at checkout")
    public CheckoutGuestDeliveryPage enterLastname(String lastname) {
        $(LASTNAME).waitUntil(Condition.visible, 10000).setValue(lastname);
        return this;
    }

    @Step("User enters address at checkout")
    public CheckoutGuestDeliveryPage enterAddress(String address) {
        $(ADDRESSFIELD).waitUntil(Condition.visible, 10000).setValue(address);
        return this;
    }

    @Step("User enters suburb/postcode at checkout")
    public CheckoutGuestDeliveryPage enterSuburbPostcode(int postcode) {
        $(SUBURBPOSTCODEFIELD).waitUntil(Condition.visible, 10000).setValue(String.valueOf(postcode));
        sleep(5000);
        return this;
    }

    @Step("User selects postcode")
    public CheckoutGuestDeliveryPage selectPostcode() {
        $(SELECTEDPOSTCODE).waitUntil(Condition.visible, 10000).click();
        sleep(5000);
        return this;
    }

    @Step("User enters phone number at checkout")
    public CheckoutGuestDeliveryPage enterPhone(int phone) {
        $(PHONEFIELD).waitUntil(Condition.visible, 10000).setValue(String.valueOf(phone));
        return this;
    }

    @Step("User selects Credit Card method")
    public CheckoutGuestDeliveryPage selectCreditCard() {
        $(CREDITCARD).click();
        sleep(5000);
        return this;
    }

    @Step("User enters Credit Card Number")
    public CheckoutGuestDeliveryPage enterCreditCardNumber(String cardNumber) {
        sleep(5000);
        Selenide.switchTo().frame($(CCNUMBERFRAME));
        $(CREDITCARDNUMBER).waitUntil(Condition.visible, 10000).setValue(cardNumber);
        Selenide.switchTo().defaultContent();
        return this;
    }

    @Step("User enters Credit Card Date")
    public CheckoutGuestDeliveryPage enterCreditCardDate(int cardDate) {
        sleep(3000);
        Selenide.switchTo().frame($(CCDATEFRAME));
        $(CREDITCARDDATE).waitUntil(Condition.visible, 10000).setValue(String.valueOf(cardDate));
        Selenide.switchTo().defaultContent();
        return this;
    }

    @Step("User enters CVV")
    public CheckoutGuestDeliveryPage enterCVV(int CVV) {
        sleep(3000);
        Selenide.switchTo().frame($(CVVFRAME));
        $(CREDITCARDCVV).waitUntil(Condition.visible, 10000).setValue(String.valueOf(CVV));
        Selenide.switchTo().defaultContent();
        return this;
    }

    @Step("User clicks 'Place Order' button")
    public CheckoutGuestDeliveryPage placeOrderButtonClick() {
        sleep(5000);
        $(PLACEORDERBUTTON).click();
        sleep(20000);
        return this;
    }

    @Step("Validation: is Order Success Page opened")
    public CheckoutGuestDeliveryPage isOSPOpened() {
        sleep(20000);
        url();
        Assert.assertEquals(url(), URLs.OSP, "OSP is not opened");
        return this;
    }
}
