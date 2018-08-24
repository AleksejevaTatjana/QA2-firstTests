package delfiTests.secondHomeWork;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AtverskapiTest {
    private final Logger LOGGER = LogManager.getLogger(AtverskapiTest.class);
    private final String HOME_PAGE = "http://www.delfi.lv/";
    private final By REGION_DROPDOWN_BTN = By.name("district");
    private final String FILTRED_SWEAMWEAR_PAGE = "http://atverskapi.delfi.lv/lv/style/sludinajumi/sievietem/18-apaksvela-peldkostimi?color%5B%5D=16&condition%5B%5D=1&district=1&tags%5B%5D=135&groups%5B%5D=7&groups%5B%5D=18&groups%5B%5D=135&sizegrp=4&type=products";
    private final By FILTER = By.xpath("//div[@class='card-info-title']");


    BaseFunc baseFunc = new BaseFunc();

    @Test
    public void swimwearFilterTest() {

        LOGGER.info("Opening home page");
        baseFunc.openPage(HOME_PAGE);
        HomePage homePage = new HomePage(baseFunc);

        LOGGER.info("Click Delfi dropdown btn");
        homePage.clickdelfiDropdownBtn();

        LOGGER.info("Click Atverskapi item");
        homePage.selectDropdownMenuSection("Atverskapi");
        AtverskapiPage atverskapiPage = new AtverskapiPage(baseFunc);

        LOGGER.info("Click Sievietēm");
        atverskapiPage.selectWomanDropdownBtn("Sievietēm");

        LOGGER.info("Click Apakšveļa / Peldkostīmi");
        atverskapiPage.selectWomanDropdownMenuItem("Apakšveļa / Peldkostīmi");

        ApaksvelaPeldkostimiPage apaksvelaPeldkostimiPage = new ApaksvelaPeldkostimiPage(baseFunc);

        LOGGER.info("Click 'Peldkostīmi' checkbox");
        apaksvelaPeldkostimiPage.selectCheckboxItem("Peldkostīmi");

        LOGGER.info("Click 'Jauns' checkbox");
        apaksvelaPeldkostimiPage.selectCheckboxCondition("Jauns");

        LOGGER.info("Click 'Tumši sarkana' checkbox");
        apaksvelaPeldkostimiPage.selectColorFilter("Tumši sarkana");

        LOGGER.info("Click Region drop down btn");
        baseFunc.getElement(REGION_DROPDOWN_BTN).click();

        LOGGER.info("Click 'Rīgas rajons' item");
        apaksvelaPeldkostimiPage.selectRegionFilterItem("Rīgas rajons");

        String firstItemCondition = "Jauns peldkostīmi";
        LOGGER.info("checking if filtered sweamwears Item and Condition on apaksvela/pelkostimi page are equels with firstItemCondition");
        Assert.assertEquals("first sweamwear ItemCondition is not equels with first sweamwear page jauns", firstItemCondition, apaksvelaPeldkostimiPage.atverskapiJauns());

        LOGGER.info("Opening FIRST sweamwear page");
        apaksvelaPeldkostimiPage.openSweamwearPage(0);
        FirstSweamwearPage firstSweamwearPage = new FirstSweamwearPage(baseFunc);

        LOGGER.info("checking if FIRST sweamwear Item and Condition is equels with firstItemCondition");
        Assert.assertEquals("firstpage sweamwear ITEM AND CONDITION is not equels with jauns peldkostims", firstItemCondition, firstSweamwearPage.checkFirstJaunsPeldkostims());

        String firstColor = "Tumši sarkana";
        LOGGER.info("checking if FIRST sweamwear Color is equels with firstColor");
        Assert.assertEquals("firstpage sweamwear COLOR is not equels with sarkans", firstColor, firstSweamwearPage.checkFirstSarkans());
        String firstRegion = "Rīgas rajons";
        LOGGER.info("checking if FIRST sweamwear Region is equels with firstRegion");
        Assert.assertEquals("firstpage sweamwear REGION not equels with Rigas rajons", firstRegion, firstSweamwearPage.checkFirstRajons());

        LOGGER.info("Opening Apaksvela/pelkostimi filtered page");
        baseFunc.openPage(FILTRED_SWEAMWEAR_PAGE);

        ApaksvelaPeldkostimiPage filteredSweamwearPagee = new ApaksvelaPeldkostimiPage(baseFunc);

        filteredSweamwearPagee.openSweamwearPage(1);
        for (int id = 1; id < 5; id++) {


            LOGGER.info("Next page" + id);
        }
    }
}





