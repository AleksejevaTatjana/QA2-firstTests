package delfiTests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class FirstHomeWorkTest {
    private final String HOME_PAGE = "http://rus.delfi.lv/";
    private final String ARTICLE_NAME = "Таиланд: из затопленной пещеры спасли всех подростков";
    private final By ARTICLE_PATH = By.xpath(".//div[@id=\"content\"]");

    @Test
    public void сheckArticleAtHomePageTest() {
        System.setProperty("webdriver.gecko.driver", "C:/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(HOME_PAGE);

        List<WebElement> articleList = driver.findElements(ARTICLE_PATH);

        boolean isArticleExist = false;
        for (int i = 0; i < articleList.size(); i++) {
            if (articleList.get(i).getText().equals(ARTICLE_NAME)) {
                isArticleExist = true;
                break;
            }
        }
        Assert.assertTrue("This article is not found!", isArticleExist);
    }
}
