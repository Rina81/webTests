package webTests.testsitself;

import org.testng.annotations.Test;
import webTests.model.ContactData;

public class MakeContact extends TestBase {
    @Test
    public void testMakeContact() throws Exception {
        app.gotoAddContact();
        app.completeContactForm(new ContactData("Sara", "Picasso", "Superstar", "123456", "ddd.aaa@nnn.mmm"));
        app.submitContact();
        app.returntohomepage();
        //logout();
    }

}
