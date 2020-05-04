package tests;

import com.codeborne.selenide.Configuration;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import steps.*;
import utils.TestListener;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@Log4j2
@Listeners(TestListener.class)

public class BaseTest {

    protected HomepageSteps homepageSteps;
    protected RegistrationSteps registrationSteps;
    protected MyAccountSteps myAccountSteps;
    protected LoginSteps loginSteps;
    protected ProductListingPageSteps productListingPageSteps;
    protected ProductDetailsPageSteps productDetailsPageSteps;

    @BeforeMethod(description = "Opening Chrome Driver")
    public void setDriver() {
        Configuration.startMaximized = true;
        Configuration.timeout = 20;

        //initializing Steps' Objects
        homepageSteps = new HomepageSteps();
        registrationSteps = new RegistrationSteps();
        myAccountSteps = new MyAccountSteps();
        loginSteps = new LoginSteps();
        productListingPageSteps = new ProductListingPageSteps();
        productDetailsPageSteps = new ProductDetailsPageSteps();
    }

    @AfterMethod(alwaysRun = true, description = "Closing Chrome Driver")
    public void closeDriver() {
        getWebDriver().quit();
    }
}
