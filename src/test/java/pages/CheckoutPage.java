package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import data.URLs;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;

public class CheckoutPage extends BasePage {
    WebElement CHECKOUTEMAILFIELD = $(By.id("customer-email"));
    WebElement YOURDETAILSELEMENT = $(By.xpath("//*[text()='Your details']"));
    WebElement CHECKOUTASGUESTBUTTON = $(By.xpath("//*[@id='customer-email-fieldset']//div[3]//div[2]//span[contains(text(),'Checkout as a guest')]"));
    WebElement FIRSTNAMEFIELD = $(".fieldset.address input[name='firstname']");
    WebElement BILLINGFIRSTNAME = $("#billing-new-address-form div[name='billingAddressbraintree.firstname'] input[name='firstname']");
    WebElement LASTNAME = $(".fieldset.address input[name='lastname']");
    WebElement BILLINGLASTNAME = $("#billing-new-address-form div[name='billingAddressbraintree.lastname'] input[name='lastname']");
    WebElement ADDRESSFIELD = $("#checkout-step-shipping input[name='street[0]']");
    WebElement BILLINGADDRESSFIELD = $("#billing-new-address-form div[name='billingAddressbraintree.street.0'] input[name='street[0]']");
    WebElement SUBURBPOSTCODEFIELD = $("#checkout-step-shipping input[name='suburb_postcode']");
    WebElement BILLINGSUBURBPOSTCODE = $("#billing-new-address-form div[name='billingAddressbraintree.suburb_postcode'] input[name='suburb_postcode']");
    WebElement SELECTEDPOSTCODE = $("#ui-id-1 li:nth-child(2) a");
    WebElement PHONEFIELD = $("#checkout-step-shipping input[name='telephone']");
    WebElement BILLINGPHONEFIELD = $("#billing-new-address-form div[name='billingAddressbraintree.telephone'] input[name='telephone']");
//    WebElement UPDATEBILLINGINFOBUTTON = $(By.xpath("//div[@class='payment-method payment-method-braintree _active']//div[contains(text(),'Update')]"));
    WebElement UPDATEBILLINGINFOBUTTON = $(By.xpath("//div[@class='payment-method payment-method-braintree _active']//div//button[@class='action action-update']"));
    WebElement CREDITCARD = $(By.className("credit-card-types"));
    WebElement CCNUMBERFRAME = $(By.xpath("//form[contains(@class,'form-braintree')]//iframe[@name='braintree-hosted-field-number']"));
    WebElement CREDITCARDNUMBER = $(By.id("credit-card-number"));
    WebElement CCDATEFRAME = $(By.xpath("//form[contains(@class,'form-braintree')]//iframe[@name='braintree-hosted-field-expirationDate']"));
    WebElement CREDITCARDDATE = $(By.id("expiration"));
    WebElement CVVFRAME = $(By.xpath("//form[contains(@class,'form-braintree')]//iframe[@name='braintree-hosted-field-cvv']"));
    WebElement CREDITCARDCVV = $(By.id("cvv"));
    WebElement PLACEORDERBUTTON = $(".place-order-container");

    @Step("User navigates to Checkout page")
    public CheckoutPage openPage() {
        open(URLs.checkoutURL);
        return this;
    }

    @Step("Validation: is Checkout page opened")
    public CheckoutPage isPageOpened() {
        url();
        Assert.assertEquals(url(), URLs.checkoutURL, "Checkout page is not opened");
        return this;
    }

    @Step("Guest User enters email on checkout")
    public CheckoutPage enterEmail(String email) {
        sleep(15000);
        $(CHECKOUTEMAILFIELD).waitUntil(Condition.appears, 20000).setValue(email);
        sleep(10000);
        $(YOURDETAILSELEMENT).waitUntil(Condition.appears, 20000).click();
        return this;
    }

    @Step("User clicks 'Checkout as Guest' button")
    public CheckoutPage checkoutAsGuestButtonClick() {
        $(CHECKOUTASGUESTBUTTON).waitUntil(Condition.visible, 60000).click();
        return this;
    }

    @Step("Validation: is Shipping Step opened")
    public CheckoutPage isShippingStepOpened() {
        $(FIRSTNAMEFIELD).waitUntil(Condition.appears, 20000);
        return this;
    }

    @Step("User enters Firstname at checkout")
    public CheckoutPage enterShippingFirstname(String firstName) {
        $(FIRSTNAMEFIELD).waitUntil(Condition.visible, 10000).setValue(firstName);
        return this;
    }

    @Step("User enters Billing Firstname at checkout")
    public CheckoutPage enterBillingFirstname(String firstName) {
        $(BILLINGFIRSTNAME).waitUntil(Condition.visible, 30000).setValue(firstName);
        return this;
    }

    @Step("User enters Lastname at checkout")
    public CheckoutPage enterShippingLastname(String lastname) {
        $(LASTNAME).waitUntil(Condition.visible, 30000).setValue(lastname);
        return this;
    }

    @Step("User enters Billing Lastname at checkout")
    public CheckoutPage enterBillingLastname(String lastname) {
        $(BILLINGLASTNAME).waitUntil(Condition.visible, 30000).setValue(lastname);
        return this;
    }

    @Step("User enters address at checkout")
    public CheckoutPage enterShippingAddress(String address) {
        $(ADDRESSFIELD).waitUntil(Condition.visible, 30000).setValue(address);
        return this;
    }

    @Step("User enters Billing Lastname at checkout")
    public CheckoutPage enterBillingAddress(String address) {
        $(BILLINGADDRESSFIELD).waitUntil(Condition.appears, 30000).setValue(address);
        return this;
    }

    @Step("User enters suburb/postcode at checkout")
    public CheckoutPage enterShippingSuburbPostcode(int postcode) {
        $(SUBURBPOSTCODEFIELD).waitUntil(Condition.visible, 30000).setValue(String.valueOf(postcode));
        sleep(5000);
        return this;
    }

    @Step("User enters Billing suburb/postcode at checkout")
    public CheckoutPage enterBillingSuburbPostcode(int postcode) {
        $(BILLINGSUBURBPOSTCODE).waitUntil(Condition.visible, 30000).setValue(String.valueOf(postcode));
        return this;
    }

    @Step("User selects postcode")
    public CheckoutPage selectShippingPostcode() {
        sleep(7000);
        $(SELECTEDPOSTCODE).waitUntil(Condition.visible, 30000).click();
        sleep(5000);
        return this;
    }

    @Step("User selects Billing postcode")
    public CheckoutPage selectBillingPostcode() {
        sleep(7000);
        $(SELECTEDPOSTCODE).waitUntil(Condition.visible, 30000).click();
        sleep(5000);
        return this;
    }

    @Step("User enters phone number at checkout")
    public CheckoutPage enterShippingPhone(int phone) {
        $(PHONEFIELD).waitUntil(Condition.visible, 30000).setValue(String.valueOf(phone));
        return this;
    }

    @Step("User enters Billing phone number at checkout")
    public CheckoutPage enterBillingPhone(int phone) {
        $(BILLINGPHONEFIELD).waitUntil(Condition.appears, 30000).setValue(String.valueOf(phone));
        return this;
    }

    @Step("User clicks 'Update' button after entering billing information")
    public CheckoutPage updateButtonClick() {
        $(UPDATEBILLINGINFOBUTTON).waitUntil(Condition.visible,30000).click();
        return this;
    }

    @Step("User selects Credit Card method")
    public CheckoutPage selectCreditCard() {
        sleep(7000);
        $(CREDITCARD).click();
        sleep(5000);
        return this;
    }

    @Step("User enters Credit Card Number")
    public CheckoutPage enterCreditCardNumber(String cardNumber) {
        sleep(5000);
        Selenide.switchTo().frame($(CCNUMBERFRAME));
        $(CREDITCARDNUMBER).waitUntil(Condition.visible, 30000).setValue(cardNumber);
        Selenide.switchTo().defaultContent();
        return this;
    }

    @Step("User enters Credit Card Date")
    public CheckoutPage enterCreditCardDate(int cardDate) {
        sleep(3000);
        Selenide.switchTo().frame($(CCDATEFRAME));
        $(CREDITCARDDATE).waitUntil(Condition.visible, 30000).setValue(String.valueOf(cardDate));
        Selenide.switchTo().defaultContent();
        return this;
    }

    @Step("User enters CVV")
    public CheckoutPage enterCVV(int CVV) {
        sleep(3000);
        Selenide.switchTo().frame($(CVVFRAME));
        $(CREDITCARDCVV).waitUntil(Condition.visible, 30000).setValue(String.valueOf(CVV));
        Selenide.switchTo().defaultContent();
        return this;
    }

    @Step("User clicks 'Place Order' button")
    public CheckoutPage placeOrderButtonClick() {
        sleep(5000);
        $(PLACEORDERBUTTON).click();
        sleep(20000);
        return this;
    }

    @Step("Validation: is Order Success Page opened")
    public CheckoutPage isOSPOpened() {
        sleep(20000);
        url();
        Assert.assertEquals(url(), URLs.OSP, "OSP is not opened");
        return this;
    }
}
