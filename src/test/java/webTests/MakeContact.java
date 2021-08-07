package webTests;

import org.testng.annotations.Test;

public class MakeContact extends TestBase {
    @Test
    public void testMakeContact() throws Exception {
        gotoAddContact();
        completeContactForm(new ContactData("Sara", "Picasso", "Superstar", "123456", "ddd.aaa@nnn.mmm"));
        submitContact();
        returntohomepage();
        //logout();
    }

}
