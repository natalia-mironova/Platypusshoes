package steps;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import pages.Homepage;

@Log4j2

public class HomepageSteps {
    private Homepage homepage;

    public HomepageSteps(WebDriver driver) {
        homepage = new Homepage(driver);
    }

    @Step("User Opens Homepage")
    public HomepageSteps openHomepageStep(String homepageURL){
        log.info("User opens Homepage URL: " + homepageURL);
        homepage
                .openPage();
        return this;
    }

    @Step("Validation: is Homepage Opened")
    public HomepageSteps isHomepageOpenedValidation() {
        log.info("Validation: is Homepage Opened");
        homepage
                .isPageOpened();
        return this;
    }

}
