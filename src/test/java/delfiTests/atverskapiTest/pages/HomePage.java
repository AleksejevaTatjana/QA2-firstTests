package delfiTests.atverskapiTest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {

    private final By DELFI_DROPDOWN_BTN = By.xpath("//a[@class='headerSeparatedNavDropButton']");
    private final By DROPDOWN_MENU_SECTIONS = By.xpath("//a[@class='sitemap-link']");

    BaseFunc baseFunc;

    public HomePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void selectDropdownMenuSection(String dropdownMenuSection) {

        List<WebElement> dropdownMenuSections = baseFunc.getElements(DROPDOWN_MENU_SECTIONS);

        for (int i = 0; i < dropdownMenuSections.size(); i++) {
            if (dropdownMenuSections.get(i).getText().equals(dropdownMenuSection)) {
                dropdownMenuSections.get(i).click();
                break;
            }
        }
    }

        public void clickdelfiDropdownBtn() {
            baseFunc.getElement(DELFI_DROPDOWN_BTN).click();
        }
    }



