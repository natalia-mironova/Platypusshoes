package pages;

import com.codeborne.selenide.Condition;
import data.URLs;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MyAccountPage extends BasePage {

    WebElement MYACCOUNTDASHBOARDELEMENT = $(By.xpath("//span[contains(text(),'dashboard')]"));

    public MyAccountPage openPage() {
        open(URLs.myAccountPageURL);
        return this;
    }

    public MyAccountPage isPageOpened() {
        $(MYACCOUNTDASHBOARDELEMENT).waitUntil(Condition.visible, 10000);
        return this;
    }
}
