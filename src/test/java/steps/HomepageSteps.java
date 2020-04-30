package steps;

import data.URLs;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import pages.Homepage;

@Log4j2

public class HomepageSteps {
    private Homepage homepage;

    public HomepageSteps() {
        homepage = new Homepage();
    }

    @Step("Step 1: User Opens Homepage")
    public HomepageSteps openHomepageStep() {
        log.info("User opens Homepage URL: " + URLs.baseURL);
        homepage
                .openPage()
                .isPageOpened();
        return this;
    }

}
