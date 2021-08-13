package webTests.testsitself;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {


  @Test
  public void testContactDeletion() throws Exception {

    app.selectContact();
    app.deleteSelectedContact();
    app.returntohomepage();

  }

}
