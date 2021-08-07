package webTests;

import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {


    @Test
    public void testGroupdeletion() throws Exception {
        gotoGroupPage();
        selectGroup();
        deleteSelectedGroups();
        //assertTrue(closeAlertAndGetItsText().matches("^Delete 1 addresses[\\s\\S]$"));
        returnToGroupPage();

    }


}
