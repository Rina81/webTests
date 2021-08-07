package webTests;

import org.testng.annotations.Test;

    public class MakeGroup extends TestBase {


        public MakeGroup() {
        }

        @Test
        public void testCreateGroup() throws Exception {

            gotoGroupPage();
            initGroupCreation();
            fillGroupForm(new GroupData("Tests1", "Tests2"));
            submitGroupCreation();
            returnToGroupPage();
           // logout();
        }


    }



