package delfiTests.atverskapiTest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ApaksvelaPeldkostimiPage {
    private final By CHECKBOX_ITEM = By.xpath("//div[@class='step3-container']/div/label");
    private final By CHECKBOX_CONDITION = By.xpath("//div[@class='filters-content filter-condition']/div/label");
    private final By COLOR_FILTER = By.xpath("//div[@class='col-xs-2 col-sm-1 filter-colors-item']/label");
    private final By REGION_NAME = By.xpath("//div[@class='filters-content']/select/option");
    private final By LIST_OF_SWEAMWEARS = By.xpath("//section[@class='row']/div");
    private final By APAKSVELA_PELDKOSTIMI_PAGE_ITEM = By.xpath(".//div[contains(text(), 'Jauns peldkostīmi')]");
    private final By FILTERED_LIST_OF_SWEAMWEARS = By.xpath("//div[@class='col-xs-6 col-sm-3']/div");

    BaseFunc baseFunc;

    public ApaksvelaPeldkostimiPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void selectCheckboxItem(String itemName) {
        List<WebElement> filterItems = baseFunc.getElements(CHECKBOX_ITEM);
        for (WebElement filterItem : filterItems) {
            if (filterItem.getText().contains(itemName)) {
                filterItem.click();
                break;
            }
        }
    }

    public void selectCheckboxCondition(String conditionName) {
        List<WebElement> filterConditions = baseFunc.getElements(CHECKBOX_CONDITION);
        for (WebElement filterCondition : filterConditions) {
            if (filterCondition.getText().equals(conditionName)) {
                filterCondition.click();
                break;
            }
        }
    }

    public void selectColorFilter(String colorName) {
        List<WebElement> filterColors = baseFunc.getElements(COLOR_FILTER);
        for (WebElement filterColor : filterColors) {
            if (filterColor.getAttribute("data-title").equals(colorName)) {
                filterColor.click();
                break;
            }
        }
    }

    public void selectRegionFilterItem(String regionName) {
        List<WebElement> dropdownRegionList = baseFunc.getElements(REGION_NAME);
        for (int i = 0; i < dropdownRegionList.size(); i++) {
            if (dropdownRegionList.get(i).getText().contains(regionName)) {
                dropdownRegionList.get(i).click();
                break;
            }
        }
    }

    public String apaksvelaPeldkostimiItem() {
        return baseFunc.getElement(APAKSVELA_PELDKOSTIMI_PAGE_ITEM).getText();
    }


    public void openSweamwearPage(Integer id) {
        baseFunc.getSweamwearByID(id).click();
    }


    public void selectSweamwearsById(Integer id) {

        List<WebElement> sweamwears = baseFunc.getElements(LIST_OF_SWEAMWEARS);
        for (int i = 0; i < sweamwears.size(); i++) {
            if (sweamwears.get(i).getText().equals(i)) {
                sweamwears.get(i).click();
                break;
            }
        }
    }

    public void listAndLoops() {
        List<WebElement> sweamwears = new ArrayList<WebElement>();
        sweamwears.get(1).findElements(FILTERED_LIST_OF_SWEAMWEARS);

        List<String> links = new ArrayList<String>();

        for (int i = 1; i < sweamwears.size(); i++) {
            String link = sweamwears.get(i).getAttribute("href");
            links.add(link);

            for (int id = 1; id < 5; id++) {
                ApaksvelaPeldkostimiPage apaksvelaPeldkostimiPage = new ApaksvelaPeldkostimiPage(baseFunc);
                FirstSweamwearPage firstSweamwearPage = new FirstSweamwearPage(baseFunc);
                apaksvelaPeldkostimiPage.openSweamwearPage(id);
                firstSweamwearPage.checkAllFilters();

            }
        }
    }
}




