package delfiTests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class firstHomeWorkTest {
    private final String HOME_PAGE = "http://rus.delfi.lv/";
    private final By LINK_ELEMENT_SINOPTIKI = By.linkText("Синоптики обещают: к концу недели в Латвии станет теплее");

    @Test
    public void sgdExistTest() {
        System.setProperty("webdriver.gecko.driver", "C:/Java/geckodriver/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(HOME_PAGE);
        driver.findElement(LINK_ELEMENT_SINOPTIKI);
    }
}
