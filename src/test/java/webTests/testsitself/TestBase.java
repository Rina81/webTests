package webTests.testsitself;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import webTests.appmanager.ApplicationManager;

public class TestBase {
    protected final ApplicationManager app = new ApplicationManager();
    //private WebDriver wd;

    @BeforeMethod(
            alwaysRun = true
    )
    public void setUp() throws Exception {
        app.init();
    }

    @AfterMethod(  alwaysRun = true  )
    public void tearDown() {
        app.stop();
    }

}