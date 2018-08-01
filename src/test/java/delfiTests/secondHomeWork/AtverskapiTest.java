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
    private final By CHECKBOX_FILTER = By.xpath("//div[@class='filters-content']/div/label");
    private final By COLOR_FILTER = By.xpath("//div[@class='col-xs-2 filter-colors-item']");
    private final By REGION_DROPDOWN_BTN = By.name("district");
    private final By REGION_REGION_NAME = By.xpath("//div[@class='filters-content']/select/option");
    private final By FILTRET_BTN = By.xpath("//button[@class='btn btn-block btn-blue']");

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

        selectFilter("Peldkostīmi", CHECKBOX_FILTER);
        // waitLoadCheckbox();

        selectFilter("Jauns", CHECKBOX_FILTER);
        // waitLoadCheckbox();

        selectFilter("Tumši sarkana", COLOR_FILTER);
        // waitLoadColor();

        driver.findElement(REGION_DROPDOWN_BTN).click();
        selectRegionFilterItem("Rīgas rajons", REGION_REGION_NAME);

        driver.findElement(FILTRET_BTN).click();
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

    private void selectFilter(String filterName, By locator) {

        List<WebElement> filterItems = driver.findElements(locator);

        for (WebElement filterItem : filterItems) {
            if (filterItem.getText().contains(filterName)) {
                filterItem.click();
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

    // private void waitLoadCheckbox() {
    //      new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(CHECKBOX_FILTER));
    //   }

    // private void waitLoadColor() {
    //     new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(COLOR_FILTER));
    // }
}

