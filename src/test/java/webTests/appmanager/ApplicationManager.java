package webTests.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import webTests.model.ContactData;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class ApplicationManager {
    FirefoxDriver wd;
    private   NavigationHelper  navigationHelper;
    private   GroupHelper groupHelper;
    private SessionHelper sessionHelper;
    public boolean acceptNextAlert = true;

    public void init() {
        System.setProperty("webdriver.gecko.driver", "c:\\Tools\\geckodriver.exe");
        wd = new FirefoxDriver();
        navigationHelper = new NavigationHelper(wd);
        groupHelper = new GroupHelper(wd);
        sessionHelper = new SessionHelper(wd);
        //System.setProperty("webdriver.chrome.driver", "c:\\Tools\\chromedriver.exe");
        // this.driver = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wd.get("https://localhost/addressbook/");
        sessionHelper.login("admin", "secret");
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

    public void gotoAddContact() {
        wd.findElement(By.linkText("add new")).click();
    }

    public void logout() {
        wd.findElement(By.linkText("Logout")).click();
    }

    public void stop() {
        wd.quit();
    }

    public boolean isElementPresent(By by) {
        try {
            wd.findElement(by);
            return true;
        } catch (NoSuchElementException var3) {
            return false;
        }
    }



    public void deleteSelectedContact() {
        acceptNextAlert = true;
        groupHelper.deleteSelectedGroups();
        assertTrue(closeAlertAndGetItsText().matches("^Delete 1 addresses[\\s\\S]$"));
    }

    public void selectContact() {
        wd.findElement(By.id("4")).click();
        // acceptNextAlert = true; wd.findElement(By.xpath("//input[@value='Delete']")).click();

        //assertTrue(closeAlertAndGetItsText().matches("^Delete 1 addresses[\\s\\S]$"));
        // wd.findElement(By.name("select")).click();
    }

    public String closeAlertAndGetItsText() {
        try {
            Alert alert = wd.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public SessionHelper getSessionHelper () {
        return sessionHelper;
    }
}
