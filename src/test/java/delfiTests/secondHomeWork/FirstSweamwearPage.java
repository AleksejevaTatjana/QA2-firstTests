package delfiTests.secondHomeWork;

import org.openqa.selenium.By;


public class FirstSweamwearPage {

    BaseFunc baseFunc;
    public final By FIRST_SWEAMWEAR = By.xpath("//div[@class='row']");

    public FirstSweamwearPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public String getSweamwear(String itemName, String colorName, String conditionName,String regionName) {
        return baseFunc.getElement(FIRST_SWEAMWEAR).getText();
    }

}



