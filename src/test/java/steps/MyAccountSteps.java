package steps;

import io.qameta.allure.Step;
import pages.LoginPage;
import pages.MyAccountPage;

public class MyAccountSteps {
    private MyAccountPage myAccountPage;
    private LoginPage loginPage;

    public MyAccountSteps() {
        myAccountPage = new MyAccountPage();
        loginPage = new LoginPage();
    }

    @Step("Open My Account")
    public MyAccountSteps openMyAccountPage(String email, String password) {
        loginPage
                .openPage()
                .enterEmailAddress(email)
                .enterPassword(password)
                .clickLoginButton();
        myAccountPage.isPageOpened();
        return this;
    }

    @Step("Logout")
    public MyAccountSteps logout(String email, String password) {
        loginPage
                .openPage()
                .enterEmailAddress(email)
                .enterPassword(password)
                .clickLoginButton();
        myAccountPage
                .isPageOpened()
                .logout(email, password)
                .isLoggedOut();
        return this;
    }
}
