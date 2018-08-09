package delfiTests.secondHomeWork;

import org.openqa.selenium.By;


public class FirstSweamwearPage {

    BaseFunc baseFunc;
    public final By FIRST_SWEAMWEAR = By.xpath("//div[@class='col-xs-12 col-md-6 product-description']/table");

    public FirstSweamwearPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public String getSweamwear(String item, String color, String condition,String region) {
        return baseFunc.getElement(FIRST_SWEAMWEAR).getText();
    }

}



