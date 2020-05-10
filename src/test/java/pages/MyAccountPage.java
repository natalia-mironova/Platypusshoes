package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;

public class MyAccountPage extends BasePage {

    WebElement MYACCOUNTDASHBOARDELEMENT = $(By.xpath("//span[contains(text(),'dashboard')]"));
    WebElement LOGOUTLINK = $(By.cssSelector(".logged-out-user"));
    WebElement LOGINLINK = $(By.xpath("//div[3]/header/div[1]/div/div[1]/a/span"));

    @Step("User opens My Account Page")
    public MyAccountPage openPage() {
        return this;
    }

    public MyAccountPage isPageOpened() {
        $(MYACCOUNTDASHBOARDELEMENT).waitUntil(Condition.visible, 20000);
        return this;
    }

    @Step("User is logging out")
    public MyAccountPage logout() {
        $(LOGOUTLINK).click();
        return this;
    }

    @Step("Validation: is User logged out")
    public MyAccountPage isLoggedOut() {
        $(LOGINLINK).waitUntil(Condition.visible, 10000);
        return this;
    }
}
