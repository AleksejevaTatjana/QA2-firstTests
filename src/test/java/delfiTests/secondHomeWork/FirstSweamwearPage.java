package delfiTests.secondHomeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FirstSweamwearPage {

    BaseFunc baseFunc;

    public final By RIGAS_RAJONS = By.xpath("//p[@class='user-horizontal-address']");
    private final By JAUNS_PELDOSTIMS = By.xpath(".//h1[@itemprop = 'name']");
    private final By SARKANS = By.xpath(".//b[@itemprop = 'color']");


    public FirstSweamwearPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public WebElement checkFirstJaunsPeldkostims() {
        return baseFunc.getElement(JAUNS_PELDOSTIMS);
    }

    public WebElement checkFirstRajons() {
       return baseFunc.getElement(RIGAS_RAJONS);
    }

    public WebElement checkFirstSarkans() {
        return baseFunc.getElement(SARKANS);
    }
}



