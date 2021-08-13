package webTests.testsitself;

import org.testng.annotations.Test;
import webTests.model.GroupData;

public class MakeGroup extends TestBase {


        public MakeGroup() {
        }

        @Test
        public void testCreateGroup() throws Exception {

            app.getNavigationHelper().gotoGroupPage();
            app.getGroupHelper().initGroupCreation();
            app.getGroupHelper().fillGroupForm(new GroupData("Tests1", "Tests2"));
            app.getGroupHelper().submitGroupCreation();
            app.getGroupHelper().returnToGroupPage();
           // logout();
        }


    }



