package delfiTests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.List;

public class ArticleExiistenceTest {

    private WebDriver driver;
    private final String HOME_PAGE = "http://rus.delfi.lv/";
    private final String ARTICLE_NAME = "Пошаговый рецепт: как приготовить домашние мясные консервы";
    private final By ARTICLE_PATH = By.xpath("(//a[@class='top2012-title'])");
    private final Logger LOGGER = LogManager.getLogger(ArticleExiistenceTest.class);

    @Test
    public void checkArticleAtHomePageTest() {

        LOGGER.info("Setting Gecko global property");
        System.setProperty("webdriver.gecko.driver", "C:/geckodriver.exe");

        LOGGER.info("Open Browser");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();

        LOGGER.info("Opening Home Page");
        driver.get(HOME_PAGE);

        LOGGER.info("Checking defined article's existence.");
        List<WebElement> articleList = driver.findElements(ARTICLE_PATH);
        boolean isArticleExist = false;
        for (int i = 0; i < articleList.size(); i++) {
            if (articleList.get(i).getText().equals(ARTICLE_NAME)) {
                isArticleExist = true;
                break;
            }
        }
        LOGGER.info("Checking is ARTICLE_PATH identical with ARTICLE_NAME");
        Assert.assertTrue("This article is not found!", isArticleExist);
    }
}
