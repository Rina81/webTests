package webTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.chrome.ChromeDriver; -to test with chrome
import org.testng.annotations.*;

    public class MakeGroup {


        private WebDriver wd;

        public MakeGroup() {
        }

        @BeforeMethod(
                alwaysRun = true
        )
        public void setUp() throws Exception {
            System.setProperty("webdriver.gecko.driver", "c:\\Tools\\geckodriver.exe");
            this.wd = new FirefoxDriver();

            //System.setProperty("webdriver.chrome.driver", "c:\\Tools\\chromedriver.exe");
            // this.driver = new ChromeDriver();
            this.wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            this.wd.get("https://localhost/addressbook/");
            login("admin", "secret");
        }

        private void login(String username, String password) {
            this.wd.findElement(By.name("user")).click();
            this.wd.findElement(By.name("user")).sendKeys(username);
            this.wd.findElement(By.name("pass")).click();
            this.wd.findElement(By.name("pass")).clear();
            this.wd.findElement(By.name("pass")).sendKeys(password);
            this.wd.findElement(By.xpath("//input[@value='Login']")).click();
        }

        @Test
        public void testCreateGroup() throws Exception {

            gotoGroupPage();
            initGroupCreation();
            fillGroupForm(new GroupData("Tests1", "Tests2"));
            submitGroupCreation();
            returnToGroupPage();
            logout();
        }

        private void logout() {
            this.wd.findElement(By.linkText("Logout")).click();
        }

        private void returnToGroupPage() {
            this.wd.findElement(By.linkText("group page")).click();
        }

        private void submitGroupCreation() {
            this.wd.findElement(By.name("submit")).click();
        }

        private void fillGroupForm(GroupData groupData) {
            this.wd.findElement(By.name("group_name")).click();
            this.wd.get("https://localhost/addressbook/group.php?new=New+group");
            this.wd.findElement(By.name("group_name")).clear();
            this.wd.findElement(By.name("group_name")).sendKeys(groupData.getName());
            this.wd.findElement(By.name("group_header")).click();
            this.wd.findElement(By.name("group_header")).clear();
            this.wd.findElement(By.name("group_header")).sendKeys(groupData.getHeader());
        }

        private void initGroupCreation() {
            this.wd.findElement(By.name("new")).click();
        }

        private void gotoGroupPage() {
            this.wd.findElement(By.linkText("groups")).click();
        }

        @AfterMethod(

        )
        public void tearDown() {
            wd.quit();

        }

        private boolean isElementPresent(By by) {
            try {
                this.wd.findElement(by);
                return true;
            } catch (NoSuchElementException var3) {
                return false;
            }
        }

        private boolean isAlertPresent() {
            try {
                this.wd.switchTo().alert();
                return true;
            } catch (NoAlertPresentException var2) {
                return false;
            }
        }
    }



