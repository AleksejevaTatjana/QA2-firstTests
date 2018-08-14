package delfiTests.secondHomeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ApaksvelaPeldkostimiPage {

    BaseFunc baseFunc;

    public ApaksvelaPeldkostimiPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void selectCheckboxItem(String itemName, By locator) {
        List<WebElement> filterItems = baseFunc.getElements(locator);
        for (WebElement filterItem : filterItems) {
            if (filterItem.getText().contains(itemName)) {
                filterItem.click();
                break;
            }
        }
    }

    public void selectCheckboxCondition(String conditionName, By locator) {
        List<WebElement> filterConditions = baseFunc.getElements(locator);
        for (WebElement filterCondition : filterConditions) {
            if (filterCondition.getText().equals(conditionName)) {
                filterCondition.click();
                break;
            }
        }
    }

    public void selectColorFilter(String colorName, By locator) {
        List<WebElement> filterColors = baseFunc.getElements(locator);
        for (WebElement filterColor : filterColors) {
            if (filterColor.getAttribute("data-title").equals(colorName)) {
                filterColor.click();
                break;
            }
        }
    }

    public void selectRegionFilterItem(String regionName, By locator) {
        List<WebElement> dropdownRegionList = baseFunc.getElements(locator);
        for (int i = 0; i < dropdownRegionList.size(); i++) {
            if (dropdownRegionList.get(i).getText().contains(regionName)) {
                dropdownRegionList.get(i).click();
                break;
            }
        }
    }

}






