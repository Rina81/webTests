package webTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.chrome.ChromeDriver; -to test with chrome
import org.testng.annotations.*;

public class MakeContact {
    private WebDriver wd;
    @BeforeMethod(
            alwaysRun = true
    )
    public void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver", "c:\\Tools\\geckodriver.exe");
        this.wd = new FirefoxDriver();

        //System.setProperty("webdriver.chrome.driver", "c:\\Tools\\chromedriver.exe");
        // this.driver = new ChromeDriver();
        this.wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
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
    public void testMakeContact() throws Exception {
        gotoAddContact();
        completeContactForm(new ContactData("Sara", "Picasso", "Superstar", "123456", "ddd.aaa@nnn.mmm"));
        submitContact();
        returntohomePage();
        logout();

    }

    private void returntohomePage() {
        wd.findElement(By.linkText("home page")).click();
    }

    private void submitContact() {
        wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
    }

    private void completeContactForm(ContactData contactData) {
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

    private void gotoAddContact() {
        this.wd.findElement(By.linkText("add new")).click();
    }
    private void logout() {
        this.wd.findElement(By.linkText("Logout")).click();
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
