package webTests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {


  @Test
  public void testContactDeletion() throws Exception {
    selectContact();
    //acceptNextAlert = true;
    deleteSelectedContact();
    //assertTrue(closeAlertAndGetItsText().matches("^Delete 1 addresses[\\s\\S]$"));
    returntohomepage();

  }

}
