package steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import pages.MyAccountPage;
import pages.RegisterPage;

@Log4j2

public class RegistrationSteps {
    private RegisterPage registerPage;
    private MyAccountPage myAccountPage;

    public RegistrationSteps(WebDriver driver) {
        registerPage = new RegisterPage(driver);
        myAccountPage = new MyAccountPage(driver);

    }

    @Step("Step 1: Account Registration")
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
        return this;
    }

    @Step("Step 2: Validation: is My Account Page opened after registration")
    public RegistrationSteps isMyAccountPageOpenedAfterRegistration() {
        log.info("Validating: is My Account page opened after registration");
        myAccountPage.isPageOpened();
        return this;
    }
}
