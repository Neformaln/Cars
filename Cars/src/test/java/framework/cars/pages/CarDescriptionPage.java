package framework.cars.pages;

import framework.cars.elements.BasePage;
import framework.cars.elements.Image;
import framework.webdriver.BrowserFactory;
import org.openqa.selenium.By;

/**
 * Created by d.korobkin on 6/22/17.
 */
public class CarDescriptionPage extends BasePage {
    private static final String MODIFICATION_LOCATOR = "//div[@class='trim_listing'][1]/*/div[@class='trim_listing__image']/img";
    Image imgFirstModif;

    public CarDescriptionPage() {
    }

    public void selectFirstModification(){
        BrowserFactory.waitPageToLoad();
        BrowserFactory.waitPageToLoad();
        logger.info("Input locator of the first available modification");
        imgFirstModif = new Image(By.xpath(MODIFICATION_LOCATOR));
        logger.info("Click on the image of the first modification");
        imgFirstModif.click();
    }
}
