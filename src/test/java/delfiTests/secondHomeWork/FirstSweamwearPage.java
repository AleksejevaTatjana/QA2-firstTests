package delfiTests.secondHomeWork;

import org.junit.Assert;
import org.openqa.selenium.By;


public class FirstSweamwearPage {
    BaseFunc baseFunc;
    //   String sarkans;
    //   String jauns;
    // String rajons;
    //  String peldkostims;


    public final By RIGAS_RAJONS = By.xpath(".//p[@class='user-horizontal-address']");
    private final By JAUNS = By.xpath(".//b[contains(text(), 'Jauns')]");
    private final By PELDKOSTIMS = By.xpath(".//a[@itemprop='item']/span");
    private final By SARKANS = By.xpath(".//b[contains(text(), 'sarkan')]");
    private final String FILTRED_SWEAMWEAR_PAGE = "http://atverskapi.delfi.lv/lv/style/sludinajumi/sievietem/18-apaksvela-peldkostimi?color%5B%5D=16&condition%5B%5D=1&district=1&tags%5B%5D=135&groups%5B%5D=7&groups%5B%5D=18&groups%5B%5D=135&sizegrp=4&type=products";

    public FirstSweamwearPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    //   public WebElement checkJauns() {
    //      Assert.assertTrue(jauns.contains("Jauns"));
    //      return baseFunc.getElement(JAUNS);
    //    }

    //  public WebElement checkPeldkostims() {
    //    peldkostims.contains("Peldkostīmi");
    //      return baseFunc.getElement(PELDKOSTIMS);
    //  }

    // public WebElement checkSarkans() {
    //     sarkans.contains("sarkan");
    //    return baseFunc.getElement(SARKANS);
    // }


    //  public WebElement checkRajons() {
    //     rajons.contains("Rīgas");
    //     return baseFunc.getElement(RIGAS_RAJONS);
    // }


    public String sweamwearItem() {
        return baseFunc.getElement(PELDKOSTIMS).getText();
    }

    public void checkItem(String item) {
        sweamwearItem().contains("Peldkostīmi");
        Assert.assertTrue("Item is not equal", sweamwearItem().contains(item));
    }


    public String sweamwearColor() {
        return baseFunc.getElement(SARKANS).getText();
    }

    public void checkColor(String color) {
        sweamwearColor().contains("sarkan");
        Assert.assertTrue("Color is not equal", sweamwearColor().contains(color));
    }

    public String sweamswearCondition() {
        return baseFunc.getElement(JAUNS).getText();
    }

    public void checkCondition(String condition) {
        sweamswearCondition().contains("Jauns");
        Assert.assertTrue("Condition is not equal", sweamswearCondition().contains(condition));
    }

    public String sweamwearRegion() {
        return baseFunc.getElement(RIGAS_RAJONS).getText();
    }

    public void checkRegion(String region) {
        sweamwearRegion().contains("Rīgas");
        Assert.assertTrue("Item is not equal", sweamwearRegion().contains(region));
    }

    public void checkAllFilters() {
        checkItem("Peldkostīmi");
        checkColor("sarkan");
        checkRegion("Rīgas");
        checkCondition("Jauns");
        baseFunc.openPage(FILTRED_SWEAMWEAR_PAGE);
    }
}




