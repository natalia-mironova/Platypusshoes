package steps;

import io.qameta.allure.Step;
import pages.MyAccountPage;

public class MyAccountSteps {
    private MyAccountPage myAccountPage;

    public MyAccountSteps() {
        myAccountPage = new MyAccountPage();
    }

    @Step("Open My Account")
    public MyAccountSteps openMyAccountPage(String email, String password) {
        myAccountPage.openMyAccountPage(email, password);
        return this;
    }

    @Step("Validation: is My Account Page opened")
    public MyAccountSteps isMyAccountPageOpened() {
        myAccountPage.isPageOpened();
        return this;
    }
}
