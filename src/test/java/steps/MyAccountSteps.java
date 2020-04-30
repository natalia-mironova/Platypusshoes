package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.MyAccountPage;

public class MyAccountSteps {
    private MyAccountPage myAccountPage;

    public MyAccountSteps(WebDriver driver) {
        myAccountPage = new MyAccountPage(driver);
    }

    @Step("Validation: is My Account Page opened")
    public MyAccountSteps isMyAccountPageOpened() {
        myAccountPage.isPageOpened();
        return this;
    }
}
