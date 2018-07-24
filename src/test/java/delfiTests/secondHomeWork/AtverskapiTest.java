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
    private final By DROP_DOWN_BTN = By.xpath("//a[@class='headerSeparatedNavDropButton']");
    private final By DROPDOWN_MENU_ITEMS = By.xpath("//a[@class='sitemap-link']");
    private final By DROPDOWN_MENU_WOMAN = By.xpath("//a[@class='dropdown-toggle']");
    private final By DROPDOWN_MENU_SWIMWEAR = By.xpath("//ul[@class='dropdown-menu']/li");
    private final By FILTER_CHECKBOX = By.xpath("//div[@class='filters-content']");
    private final By COLOR_FILTER = By.xpath("//div[@class='row filter-colors']");

    @Test
    public void swimwearFilterTest() {

        System.setProperty("webdriver.gecko.driver", "c:/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(HOME_PAGE);

        driver.findElement(DROP_DOWN_BTN).click();
        selectDropdownMenuItem("Atverskapi");
        selectWomanDropdownBtn("Sievietēm");
        selectSwimwearItem("Peldostīmi");

        selectFilter("Peldkostīmi", FILTER_CHECKBOX);
        selectFilter("Red", COLOR_FILTER);

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

    private void selectSwimwearItem(String sweamwearItem) {

        List<WebElement> dropdownMenuList = driver.findElements(DROPDOWN_MENU_SWIMWEAR);

        for (int i = 0; i < dropdownMenuList.size(); i++) {
            if (dropdownMenuList.get(i).getText().contains(sweamwearItem)) {
                dropdownMenuList.get(i).click();
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
}

