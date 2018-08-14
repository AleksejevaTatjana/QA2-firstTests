package delfiTests.secondHomeWork;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.List;

public class BaseFunc {

    private final By LIST_OF_SWEAMWEARS = By.xpath("//section[@class='row']/div");

    WebDriver driver;

    public BaseFunc() {
        System.setProperty("webdriver.gecko.driver", "c:/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    public void openPage(String url) {
        if (!url.contains("http://") && !url.contains("https://")) {
            url = "http://" + url;
        }
        driver.get(url);
    }


    public List<WebElement> getElements(By locator) {
        Assert.assertFalse("No elements found", driver.findElements(locator).isEmpty());
        return driver.findElements(locator);
    }

    public boolean isElementPresent(By locator) {
        return getElements(locator).isEmpty();

    }

    public WebElement getElement(By locator) {
        waitForElement(locator);
        return driver.findElement(locator);
    }


    public void waitForElement(By locator) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


    public WebElement getSweamwearByID(Integer id) {
        List<WebElement> sweamwears = driver.findElements(LIST_OF_SWEAMWEARS);
        return sweamwears.get(id);
    }


    public String getSweamwearById(Integer id) {
        return getSweamwearByID(id).getText();
    }


    public void openSweamwearPage(Integer id) {
        getSweamwearByID(id).click();
    }


    public void checkSweamwearsFiltered(String actualResult, By locator) {
        List<WebElement> listOfCheckNames = driver.findElements(locator);
        for (int i = 0; i < listOfCheckNames.size(); i++) {
            if (listOfCheckNames.get(i).getText().equals(actualResult)) {
                listOfCheckNames.get(i).click();
                break;
            }
        }
    }
}