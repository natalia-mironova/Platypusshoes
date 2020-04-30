package steps;

import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class LoginSteps {

    private LoginPage loginPage;

    public LoginSteps(WebDriver driver){
        loginPage = new LoginPage(driver);
    }
}
