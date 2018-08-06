package delfiTests.secondHomeWork;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class AtverskapiTest {

    private WebDriver driver;
    private final String HOME_PAGE = "http://www.delfi.lv/";
    private final By DROPDOWN_BTN = By.xpath("//a[@class='headerSeparatedNavDropButton']");
    private final By DROPDOWN_MENU_ITEMS = By.xpath("//a[@class='sitemap-link']");
    private final By DROPDOWN_MENU_WOMAN = By.xpath("//a[@class='dropdown-toggle']");
    private final By WOMAN_DROPDOWN_MENU_ITEM = By.xpath("//ul[@class='dropdown-menu']/li");
    private final By CHECKBOX_ITEM = By.xpath("//div[@class='step3-container']/div/label");
    private final By CHECKBOX_CONDITION = By.xpath("//div[@class='filters-content filter-condition']/div/label");
    private final By COLOR_FILTER = By.xpath("//span[@class='glyphicon glyphicon-ok']");
    private final By REGION_DROPDOWN_BTN = By.name("district");
    private final By REGION_REGION_NAME = By.xpath("//div[@class='filters-content']/select/option");
    // private final By FILTRET_BTN = By.xpath("//button[@class='btn btn-block btn-blue']");

    @Test
    public void swimwearFilterTest() {

        System.setProperty("webdriver.gecko.driver", "c:/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(HOME_PAGE);

        driver.findElement(DROPDOWN_BTN).click();
        selectDropdownMenuItem("Atverskapi");
        selectWomanDropdownBtn("Sievietēm");
        selectWomanDropdownMenuItem("Apakšveļa / Peldkostīmi");
        selectCheckboxItem("Peldkostīmi", CHECKBOX_ITEM);
        selectCheckboxCondition("Jauns", CHECKBOX_CONDITION);

        selectColorFilter("Tumši sarkana", COLOR_FILTER);

        driver.findElement(REGION_DROPDOWN_BTN).click();
        selectRegionFilterItem("Rīgas rajons", REGION_REGION_NAME);

        //driver.findElement(FILTRET_BTN).click();
    }

    private void selectDropdownMenuItem(String dropdownMenuItem) {

        List<WebElement> dropdownMenuItems = driver.findElements(DROPDOWN_MENU_ITEMS);

        for (int i = 0; i < dropdownMenuItems.size(); i++) {
            if (dropdownMenuItems.get(i).getText().equals(dropdownMenuItem)) {
                dropdownMenuItems.get(i).click();
                break;
            }
        }
    }

    private void selectWomanDropdownBtn(String dropdownMenuWoman) {
        List<WebElement> dropdownMenuWomanMan = driver.findElements(DROPDOWN_MENU_WOMAN);

        for (int i = 0; i < dropdownMenuWomanMan.size(); i++) {
            if (dropdownMenuWomanMan.get(i).getText().equals(dropdownMenuWoman)) {
                dropdownMenuWomanMan.get(i).click();
                break;
            }
        }
    }

    private void selectWomanDropdownMenuItem(String item) {

        List<WebElement> womanDropdownMenuList = driver.findElements(WOMAN_DROPDOWN_MENU_ITEM);

        for (int i = 0; i < womanDropdownMenuList.size(); i++) {
            if (womanDropdownMenuList.get(i).getText().equals(item)) {
                womanDropdownMenuList.get(i).click();
                break;
            }
        }
    }

    private void selectCheckboxItem(String filterName, By locator) {
        List<WebElement> filterItems = driver.findElements(locator);
        for (WebElement filterItem : filterItems) {
            if (filterItem.getText().contains(filterName)) {
                filterItem.click();
                break;
            }
        }
    }

    private void selectColorFilter(String colorName, By locator) {
        List<WebElement> filterColors = driver.findElements(locator);
                for (WebElement filterColor : filterColors) {
            if (filterColor.getText().contains(colorName)) {
                filterColor.click();
                break;
            }
        }
    }

    private void selectCheckboxCondition(String filterName, By locator) {
        List<WebElement> filterConditions = driver.findElements(locator);
        for (WebElement filterCondition : filterConditions) {
            if (filterCondition.getText().equals(filterName)) {
                filterCondition.click();
                break;
            }
        }
    }

    private void selectRegionFilterItem(String regionName, By locator) {
        List<WebElement> dropdownRegionList = driver.findElements(locator);
        driver.findElement(REGION_REGION_NAME).click();

        for (int i = 0; i < dropdownRegionList.size(); i++) {
            if (dropdownRegionList.get(i).getText().contains(regionName)) {
                dropdownRegionList.get(i).click();
                break;
            }
        }
    }

}

