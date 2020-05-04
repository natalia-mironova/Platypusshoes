package steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import pages.MyAccountPage;
import pages.RegisterPage;

@Log4j2

public class RegistrationSteps {
    private RegisterPage registerPage;
    private MyAccountPage myAccountPage;

    public RegistrationSteps() {
        registerPage = new RegisterPage();
        myAccountPage = new MyAccountPage();
    }

    @Step("Account Registration with valid credentials")
    public RegistrationSteps registerNewUserStep(String firstName, String lastName, String email, String password) {
        log.info("User registers an account entering: " + firstName + ", " + lastName + ", " + email + ", " + password);
        registerPage
                .openPage()
                .isPageOpened()
                .enterFirstName(firstName)
                .enterLastName(lastName)
                .enterEmail(email)
                .enterPassword(password)
                .enterPasswordConfirmation(password)
                .clickCreateAccountButton();
        myAccountPage.isPageOpened();
        return this;
    }

}
