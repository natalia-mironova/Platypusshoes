package tests;

import lombok.*;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.*;
import steps.HomepageSteps;
import steps.LoginSteps;
import steps.MyAccountSteps;
import steps.RegistrationSteps;
import utils.CapabilitiesGenerator;
import utils.TestListener;

import java.util.concurrent.TimeUnit;

@Data //getter, setter, equals, hashcode, toString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Log4j2
@Listeners(TestListener.class)

public class BaseTest {
    private WebDriver driver;

    Homepage homePage;
    RegisterPage registerPage;
    LoginPage loginPage;
    MyAccountPage myAccountPage;
//    CartPage cartPage;
//    CheckoutGuestPage checkoutGuestpage;
//    CheckoutLoggedInUserPage checkoutLoggedInUserpage;
//    ProductDetailsPage productDetailsPage;
//    ProductListingPage productListingPage;

    protected HomepageSteps homepageSteps;
    protected RegistrationSteps registrationSteps;
    protected MyAccountSteps myAccountSteps;
    protected LoginSteps loginSteps;

    @BeforeMethod(description = "Opening Chrome Driver")
    public void setDriver(ITestContext context) { //adding ITestContext context for IListener (screenshots)
        int timeout = 20;
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");
        driver = new ChromeDriver(CapabilitiesGenerator.getChromeOptions());
        log.debug("Setup ImplicitWait to" + timeout);
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        //adding context for taking screenshots
        context.setAttribute("driver", driver);

        // initializing Pages' Objects
        homePage = new Homepage(driver);
        registerPage = new RegisterPage(driver);
        loginPage = new LoginPage(driver);
        myAccountPage = new MyAccountPage(driver);
//        productListingPage = new ProductListingPage(driver);
//        productDetailsPage = new ProductDetailsPage(driver);
//        cartPage = new CartPage(driver);
//        checkoutGuestpage = new CheckoutGuestPage(driver);
//        checkoutLoggedInUserpage = new CheckoutLoggedInUserPage(driver);

        //initializing Steps' Objects
        homepageSteps = new HomepageSteps(driver);
        registrationSteps = new RegistrationSteps(driver);
        myAccountSteps = new MyAccountSteps(driver);
//      loginSteps = new LoginSteps(driver);
    }

    @AfterMethod(alwaysRun = true, description = "Closing Chrome Driver")
    public void closeDriver() {
        driver.quit();
    }
}
