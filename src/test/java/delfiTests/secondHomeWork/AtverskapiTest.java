package delfiTests.secondHomeWork;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class AtverskapiTest {
    private final String HOME_PAGE = "http://www.delfi.lv/";
    private final By CHECKBOX_ITEM = By.xpath("//div[@class='step3-container']/div/label");
    private final By CHECKBOX_CONDITION = By.xpath("//div[@class='filters-content filter-condition']/div/label");
    private final By COLOR_FILTER = By.xpath("//div[@class='col-xs-2 col-sm-1 filter-colors-item']/label");
    private final By REGION_DROPDOWN_BTN = By.name("district");
    private final By REGION_NAME = By.xpath("//div[@class='filters-content']/select/option");

    //private final By LIST_OF_SWIMWEARS = By.xpath();
    //private final String SECOND_SWEAMWEAR = "http://atverskapi.delfi.lv/lv/style/sludinajumi/2009283-sarkans-peldkostims";

    BaseFunc baseFunc = new BaseFunc();

    @Test
    public void swimwearFilterTest() {

        baseFunc.openPage(HOME_PAGE);
        HomePage homePage = new HomePage(baseFunc);

        homePage.clickdelfiDropdownBtn();
        homePage.selectDropdownMenuSection("Atverskapi");

        AtverskapiPage atverskapiPage = new AtverskapiPage(baseFunc);
        atverskapiPage.selectWomanDropdownBtn("Sievietēm");
        atverskapiPage.selectWomanDropdownMenuItem("Apakšveļa / Peldkostīmi");

        ApaksvelaPeldkostimiPage apaksvelaPeldkostimiPage = new ApaksvelaPeldkostimiPage(baseFunc);
        apaksvelaPeldkostimiPage.selectCheckboxItem("Peldkostīmi", CHECKBOX_ITEM);
        apaksvelaPeldkostimiPage.selectCheckboxCondition("Jauns", CHECKBOX_CONDITION);
        apaksvelaPeldkostimiPage.selectColorFilter("Tumši sarkana", COLOR_FILTER);
        baseFunc.getElement(REGION_DROPDOWN_BTN).click();
        apaksvelaPeldkostimiPage.selectRegionFilterItem("Rīgas rajons", REGION_NAME);


        String sweamwear = apaksvelaPeldkostimiPage.getSweamwearById(0);
        apaksvelaPeldkostimiPage.openFirstSweamwearPage(0);

        FirstSweamwearPage firstSweamwearPage = new FirstSweamwearPage(baseFunc);
        String firstSweamwear = FirstSweamwearPage.getSweamwear("Peldkostīmi", "Tumši sarkana", "Jauns", "Rīgas rajons");
        Assert.assertEquals("Sweamwear does not filtred", sweamwear, firstSweamwear);

    }
}

