package webTests;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {
    protected WebDriver wd;
    //private WebDriver wd;

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



    public void login(String username, String password) {
        this.wd.findElement(By.name("user")).click();
        this.wd.findElement(By.name("user")).sendKeys(username);
        this.wd.findElement(By.name("pass")).click();
        this.wd.findElement(By.name("pass")).clear();
        this.wd.findElement(By.name("pass")).sendKeys(password);
        this.wd.findElement(By.xpath("//input[@value='Login']")).click();
    }

    public void returntohomepage() {
        wd.findElement(By.linkText("home")).click();
    }

    public void submitContact() {
        wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
    }

    public void completeContactForm(ContactData contactData)  {
        wd.findElement(By.name("firstname")).click();
        wd.findElement(By.name("firstname")).clear();
        wd.findElement(By.name("firstname")).sendKeys(contactData.getFirstName());
        wd.findElement(By.name("lastname")).click();
        wd.findElement(By.name("lastname")).clear();
        wd.findElement(By.name("lastname")).sendKeys(contactData.getLastname());
        wd.findElement(By.name("nickname")).click();
        wd.findElement(By.name("nickname")).clear();
        wd.findElement(By.name("nickname")).sendKeys(contactData.getNickname());
        wd.findElement(By.name("mobile")).click();
        wd.findElement(By.name("mobile")).clear();
        wd.findElement(By.name("mobile")).sendKeys(contactData.getMobile());
        wd.findElement(By.name("email")).click();
        wd.findElement(By.name("email")).clear();
        wd.findElement(By.name("email")).sendKeys(contactData.getEmail());
    }

    protected void gotoAddContact() {
        this.wd.findElement(By.linkText("add new")).click();
    }

    protected void logout() {
        this.wd.findElement(By.linkText("Logout")).click();
    }

    protected void returnToGroupPage() {
        this.wd.findElement(By.linkText("group page")).click();
    }

    protected void submitGroupCreation() {
        this.wd.findElement(By.name("submit")).click();
    }

    protected void fillGroupForm(GroupData groupData) {
        this.wd.findElement(By.name("group_name")).click();
        this.wd.get("https://localhost/addressbook/group.php?new=New+group");
        this.wd.findElement(By.name("group_name")).clear();
        this.wd.findElement(By.name("group_name")).sendKeys(groupData.getName());
        this.wd.findElement(By.name("group_header")).click();
        this.wd.findElement(By.name("group_header")).clear();
        this.wd.findElement(By.name("group_header")).sendKeys(groupData.getHeader());
    }

    protected void initGroupCreation() {
        this.wd.findElement(By.name("new")).click();
    }

    protected void gotoGroupPage() {
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

    protected void deleteSelectedGroups() {
      wd.findElement(By.xpath("//input[@value='Delete']")).click();
    }

    protected void selectGroup() {
      wd.findElement(By.name("selected")).click();
    }

    protected void deleteSelectedContact() {
      wd.findElement(By.xpath("//input[@value='Delete']")).click();
    }

    protected void selectContact() {
      wd.findElement(By.name("select")).click();
    }
}
