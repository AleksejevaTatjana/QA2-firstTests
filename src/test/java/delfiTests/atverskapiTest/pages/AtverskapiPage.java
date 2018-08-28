package delfiTests.atverskapiTest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AtverskapiPage {

    private final By DROPDOWN_MENU_WOMAN = By.xpath("//a[@class='dropdown-toggle']");
    private final By WOMAN_DROPDOWN_MENU_ITEM = By.xpath("//ul[@class='dropdown-menu']/li");

    BaseFunc baseFunc;

    public AtverskapiPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void selectWomanDropdownBtn(String dropdownMenuWoman) {
        List<WebElement> dropdownMenuWomanMan = baseFunc.getElements(DROPDOWN_MENU_WOMAN);

        for (int i = 0; i < dropdownMenuWomanMan.size(); i++) {
            if (dropdownMenuWomanMan.get(i).getText().equals(dropdownMenuWoman)) {
                dropdownMenuWomanMan.get(i).click();
                break;
            }
        }
    }

    public void selectWomanDropdownMenuItem(String menuItemName) {

        List<WebElement> womanDropdownMenuList = baseFunc.getElements(WOMAN_DROPDOWN_MENU_ITEM);

        for (int i = 0; i < womanDropdownMenuList.size(); i++) {
            if (womanDropdownMenuList.get(i).getText().equals(menuItemName)) {
                womanDropdownMenuList.get(i).click();
                break;
            }
        }
    }

}


