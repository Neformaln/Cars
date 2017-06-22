package framework.cars.pages;

import framework.cars.elements.BasePage;
import framework.cars.elements.Button;
import framework.cars.elements.CheckBox;
import framework.cars.elements.Label;
import framework.cars.model.Car;
import framework.webdriver.BrowserFactory;
import org.openqa.selenium.By;

/**
 * Created by d.korobkin on 6/22/17.
 */
public class CarModificationPage extends BasePage {

    private static final String ENGINE_LOCATOR = "//td[@id='engine']";
    private static final String TRANSMISSION_LOCATOR = "//td[@id='transmission']";
    private static final String CHECK_BOX_LOCATOR = "//div[@class='trim_listing__footer']//div//div[@class='checkbox']";
    private static final String BUTTON_LOCATOR = "//button[@class='cui-button']";
    Label labelEngine;
    Label labelTransmission;
    private CheckBox ckbCompare;
    private Button btnCompareNow;

    public CarModificationPage() {
        }

    public Car saveModification() {
        BrowserFactory.waitPageToLoad();
        logger.info("Initializing locators of the Engine and Transmission");
        labelEngine = new Label(By.xpath(ENGINE_LOCATOR));
        labelTransmission = new Label(By.xpath(TRANSMISSION_LOCATOR));
        Car car = new Car(labelEngine.getText(), labelTransmission.getText());
        System.out.println(car.toString());
        logger.info("Save parameters of the modification");
        return car;
        }

    public void selectCarToCompare() {
        logger.info("Select car to compare");
        ckbCompare = new CheckBox(By.xpath(CHECK_BOX_LOCATOR));
        ckbCompare.check();
        BrowserFactory.waitPageToLoad();
        btnCompareNow = new Button(By.xpath(BUTTON_LOCATOR));
        logger.info("Click button Compare now");
        btnCompareNow.click();
        BrowserFactory.waitPageToLoad();
        }
}
