package firstTest;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import java.util.ArrayList;

public class JavaGuruTest {
    private static final By QA_COURSE_MENU_LINK = By.xpath(".//[text()='Курс Тустирования(QA)']");
    private static  final By ERROR_FIELD_TXT = By.xpath(".//div[text()=Šis ir obligāts jauntājums.']");
    private static final By QA_REGISTRATION_BTN = By.className("regCourseA");
    private static final By SEND_BTN = By.id("ss-submit");
    private static final By NAME_FIELD = By.id("entry_1000000");
    private String HOME_PAGE = "http://javaguru.lv";

    @Test
    private void javaGuruReqTest() {
        System.setProperty("webdriver.gecko.driver", "C:/Java/geckodriver/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(HOME_PAGE);
        driver.findElement(QA_COURSE_MENU_LINK).click();
        driver.findElement(QA_REGISTRATION_BTN).click();
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        while (tabs.size() != 2) {
            tabs.clear();
            tabs.addAll(driver.getWindowHandles());
        }
        driver.switchTo().window(tabs.get(1));
        driver.findElement(NAME_FIELD).sendKeys("Name");
        driver.findElement(SEND_BTN).click();
        Assert.assertTrue("No Error message")", driver.findElements(ERROR_FIELD_TXT).size()>0);
    }
}
