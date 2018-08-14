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
    private final By FIRST_SWEAMWEAR_ITEM_CONDITION = By.xpath("//div[@class='card-info-title']");

    private final String FILTRED_SWEAMWEAR_PAGE = "http://atverskapi.delfi.lv/lv/style/sludinajumi/sievietem/18-apaksvela-peldkostimi?color%5B%5D=16&condition%5B%5D=1&district=1&tags%5B%5D=135&groups%5B%5D=7&groups%5B%5D=18&groups%5B%5D=135&sizegrp=4&type=products";

    public final By FIRST_SWEAMWEAR_PAGE_ITEM_CONDITION = By.xpath("//div[@class='col-xs-12']/h1");
    public final By FIRST_SWEAMWEAR_PAGE_COLOR = By.xpath("//b[@itemprop='color']");
    public final By FIRST_SWEAMWEAR_PAGE_REGION = By.xpath("//p[@class='user-horizontal-address']");

    public final By SECOND_SWEAMWEAR_ITEM_COLOR = By.xpath("//div[@class='col-xs-12']/h1");
    public final By SECOND_SWEAMWEAR_CONDITION = By.xpath("//tr[@class='']/td/b");


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

        String firstItemCondition = "JAUNS PELDKOSTĪMS";
        String firstSweamwearItemCondition = apaksvelaPeldkostimiPage.baseFunc.getElement(FIRST_SWEAMWEAR_ITEM_CONDITION).getText();
        Assert.assertEquals("Item and condition on ApaksvelaPeldkostimiPage is not equels with expected itemCondition", firstItemCondition, firstSweamwearItemCondition);
        apaksvelaPeldkostimiPage.baseFunc.openSweamwearPage(0);

        FirstSweamwearPage firstSweamwearPage = new FirstSweamwearPage(baseFunc);
        String firstSweamwearPageItemCondition = firstSweamwearPage.baseFunc.getElement(FIRST_SWEAMWEAR_PAGE_ITEM_CONDITION).getText();
        Assert.assertEquals("FirstSweamwearItem on FirstSweamwearPage is not equels with expected firstItemCondition", firstItemCondition, firstSweamwearPageItemCondition);

        String firstColor = "Tumši sarkana";
        String firstSweamwearColor = firstSweamwearPage.baseFunc.getElement(FIRST_SWEAMWEAR_PAGE_COLOR).getText();
        Assert.assertEquals("FirstSweamwearColor on FirstSweamwearPage is not equels with expected firstColor", firstColor, firstSweamwearColor);

        String firstRegion = "Centrs, Rīgas rajons";
        String firstSweamwearRegion = firstSweamwearPage.baseFunc.getElement(FIRST_SWEAMWEAR_PAGE_REGION).getText();
        Assert.assertEquals("FirstSweamwearColor on FirstSweamwearPage is not equels with expected firstRegion", firstRegion, firstSweamwearRegion);

        baseFunc.openPage(FILTRED_SWEAMWEAR_PAGE);
        ApaksvelaPeldkostimiPage filteredSweamwearPage = new ApaksvelaPeldkostimiPage(baseFunc);
        filteredSweamwearPage.baseFunc.openSweamwearPage(1);


        SecondSweamwearPage secondSweamwearPage = new SecondSweamwearPage(baseFunc);
        String secondItemColor = "Sarkans peldkostīms";
        String actualResult;
        secondSweamwearPage.baseFunc.checkSweamwearsFiltered(actualResult = "Sarkans peldkostīms", SECOND_SWEAMWEAR_ITEM_COLOR);
        Assert.assertEquals("Second actual result on SecondSweamwearPage is not equels with expected secondItemColor", secondItemColor, actualResult);

        String secondCondition = "Jauns";
        secondSweamwearPage.baseFunc.checkSweamwearsFiltered(actualResult = "Jauns", SECOND_SWEAMWEAR_CONDITION);

        Assert.assertEquals("SecondSweamweaCondition on SecondSweamwearPage is not equels with expected secondCondition", secondCondition, actualResult);
    }
}



