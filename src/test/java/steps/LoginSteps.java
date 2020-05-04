package steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import pages.LoginPage;
import pages.MyAccountPage;

@Log4j2

public class LoginSteps {
    private LoginPage loginPage;
    private MyAccountPage myAccountPage;

    public LoginSteps() {
        loginPage = new LoginPage();
        myAccountPage = new MyAccountPage();
    }

    @Step("Login with valid credentials")
    public LoginSteps loginAsExistingUserStep(String email, String password) {
        log.info("User loggs in into an account entering: " + email + ", " + password);
        loginPage
                .openPage()
                .isPageOpened()
                .enterEmailAddress(email)
                .enterPassword(password)
                .clickLoginButton();
        myAccountPage.isPageOpened();
        return this;
    }
}
