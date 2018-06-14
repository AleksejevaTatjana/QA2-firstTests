package delfiTests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class FirstHomeWorkTest {
    private final String HOME_PAGE = "http://rus.delfi.lv";
    private final String ARTICLE_NAME = "Четыре желтые буквы. Как IKEA изменит жизнь в Латвии";
    private final By ARTICLE_PATH = By.xpath(".//a[@href=\"http://www.delfi.lv/biznes/bizopinion/chetyre-zheltye-bukvy-kak-ikea-izmenit-zhizn-v-latvii.d?id=50121303\"]");

    @Test
    public void сheckArticleAtHomePageTest() {
        System.setProperty("webdriver.gecko.driver", "C:/Java/geckodriver/geckodriver.exe");
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
