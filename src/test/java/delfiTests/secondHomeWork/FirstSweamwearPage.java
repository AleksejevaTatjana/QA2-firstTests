package delfiTests.secondHomeWork;

import org.openqa.selenium.By;

public class FirstSweamwearPage {

    public final String FIRST_SWEAMWEAR_PAGE = "http://atverskapi.delfi.lv/lv/style/sludinajumi/1978862-jauns-peldkostims";
    public final By FIRST_SWEAMWEAR_PARAMETRES = By.xpath("//div[@class='col-xs-12 col-md-6 product-description']");

    BaseFunc baseFunc;


    public FirstSweamwearPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }


    public String getSweamwearParapeter() {
        return baseFunc.getElement(FIRST_SWEAMWEAR_PARAMETRES).getText();
    }
}


