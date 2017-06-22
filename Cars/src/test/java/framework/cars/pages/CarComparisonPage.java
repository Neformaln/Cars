package framework.cars.pages;

import framework.cars.elements.BasePage;
import framework.cars.elements.Button;
import framework.cars.elements.ComboBox;
import framework.cars.elements.Label;
import framework.cars.model.Car;
import framework.webdriver.BrowserFactory;
import org.openqa.selenium.By;

import java.util.List;

/**
 * Created by d.korobkin on 6/22/17.
 */
public class CarComparisonPage extends BasePage {
    private ComboBox cmbMake;
    private ComboBox cmbModel;
    private ComboBox cmbYear;
    private Button btnDone;
    Label labelFirstTransmission;
    private Label labelAddCar;
    private static final String ADD_CAR_LOCATOR = "//div[@id='icon-div']";
    private static final String MAKE_LOCATOR = "//select[@name='makeDropdown']";
    private static final String VALUE_MAKE_LOCATOR = "//select[@name='makeDropdown']/option[text()='%s']";
    private static final String MODEL_LOCATOR = "//select[@name='modelDropdown']";
    private static final String VALUE_MODEL_LOCATOR = "//select[@name='modelDropdown']/option[text()='%s']";
    private static final String YEAR_LOCATOR = "//select[@name='yearDropdown']";
    private static final String VALUE_YEAR_LOCATOR = "//select[@name='yearDropdown']/option[text()='%s']";
    private static final String BUTTON_LOCATOR = "//button[@class='modal-button']";
    private static final String FIRST_ENGINE_LOCATOR = "//cars-compare-compare-info[@header='Engine']/*/span";
    private static final String FIRST_TRANSMISSION_LOCATOR = "//cars-compare-compare-info[@header='Transmission']/*/span";



    public CarComparisonPage() {
    }

    public void clickToAddAnotherCar() {
        logger.info("Initializing locator and click on Label Add another Car");
        labelAddCar = new Label(By.xpath(ADD_CAR_LOCATOR));
        labelAddCar.click();
    }

    public void inputSavedParameters(Car firstCar) {
        logger.info("Get a string object make locator");
        BrowserFactory.waitImplicitly();
        String locator = String.format(VALUE_MAKE_LOCATOR, firstCar.getMake());
        cmbMake = new ComboBox(By.xpath(MAKE_LOCATOR), By.xpath(locator));
        logger.info("Input Make locator with saved values");
        cmbMake.dropComboBox();
        locator = String.format(VALUE_MODEL_LOCATOR, firstCar.getModel());
        cmbModel = new ComboBox(By.xpath(MODEL_LOCATOR), By.xpath(locator));
        logger.info("Input Model locator with saved values");
        cmbModel.dropComboBox();
        locator = String.format(VALUE_YEAR_LOCATOR, firstCar.getYear());
        cmbYear = new ComboBox(By.xpath(YEAR_LOCATOR), By.xpath(locator));
        logger.info("Input Year locator with saved values");
        cmbYear.dropComboBox();
        btnDone = new Button(By.xpath(BUTTON_LOCATOR));
        btnDone.click();
    }

    public void compareCars(Car firstCar, Car secondCar) {
        BrowserFactory.waitPageToLoad();
        List<Label> ll = Label.getConvertedElements((FIRST_TRANSMISSION_LOCATOR));
        labelFirstTransmission =  new Label(By.xpath(FIRST_TRANSMISSION_LOCATOR));
        System.out.println(ll.size());
        System.out.println(ll.get(0).getText());
        System.out.println(ll.get(1).getText());
        String firstEngine[] = ll.get(0).getText().split(",");
        int colEngine = firstEngine.length / 2;
        for (int i = 0; i < colEngine; ) {
        }
    }
}