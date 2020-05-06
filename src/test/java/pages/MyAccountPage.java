package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import steps.MyAccountSteps;

import static com.codeborne.selenide.Selenide.$;

public class MyAccountPage extends BasePage {
//    private LoginPage loginPage;
//    private MyAccountPage myAccountPage;

    WebElement MYACCOUNTDASHBOARDELEMENT = $(By.xpath("//span[contains(text(),'dashboard')]"));
    WebElement LOGOUTLINK = $(By.cssSelector(".logged-out-user"));
    WebElement LOGINLINK = $(By.xpath("//div[3]/header/div[1]/div/div[1]/a/span"));

//    public MyAccountPage() {
//        loginPage = new LoginPage();
//        myAccountPage = new MyAccountPage();
//    }

    @Step("User opens My Account Page")
    public MyAccountPage openPage() {
        return this;
    }

    public MyAccountPage isPageOpened() {
        $(MYACCOUNTDASHBOARDELEMENT).waitUntil(Condition.visible, 20000);
        return this;
    }

    public MyAccountPage logout(String email, String password) {
        $(LOGOUTLINK).click();
        return this;
    }

    public MyAccountPage isLoggedOut() {
        $(LOGINLINK).waitUntil(Condition.visible, 10000);
        return this;
    }
}
