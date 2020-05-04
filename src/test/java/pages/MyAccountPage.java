package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;

public class MyAccountPage extends BasePage {
    private LoginPage loginPage;

    WebElement MYACCOUNTDASHBOARDELEMENT = $(By.xpath("//span[contains(text(),'dashboard')]"));

    public MyAccountPage() {
        loginPage = new LoginPage();
    }

    public MyAccountPage openPage() {
        return this;
    }

    public MyAccountPage openMyAccountPage(String email, String password) {
        loginPage
                .openPage()
                .enterEmailAddress(email)
                .enterPassword(password)
                .clickLoginButton();
        return this;
    }

    public MyAccountPage isPageOpened() {
        $(MYACCOUNTDASHBOARDELEMENT).waitUntil(Condition.visible, 20000);
        return this;
    }
}
