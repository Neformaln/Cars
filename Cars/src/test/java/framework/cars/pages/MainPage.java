package framework.cars.pages;


import framework.GeneralFunctions;
import framework.cars.elements.*;
import framework.cars.menu.Menu;
import framework.cars.model.Car;
import framework.webdriver.BrowserFactory;
import org.openqa.selenium.By;
import java.util.List;
import java.util.Properties;


/**
 * Created by d.korobkin on 6/20/17.
 */
public class MainPage extends BasePage {

    String selectAMakeLocator = "selectAMakeLocator";
    String selectAMakeOptionsLocator = "selectAMakeOptionsLocator";
    String selectAModelLocator = "selectAModelLocator";
    String selectAModelOptionsLocator = "selectAModelOptionsLocator";
    String selectAYearLocator = "selectAYearLocator";
    String selectAYearOptionsLocator = "selectAYearOptionsLocator";
    String btnSearchLocator = "btnSearchLocator";
    Button searchBtn;
    Properties locatorproperties;

    public Menu menu = new Menu();

    public MainPage(){
        super(By.xpath("//div[@class='promo-copy container']"), null);
    }


    public Car InputRandomValue(){
        BrowserFactory.waitPageToLoad();
        BrowserFactory.waitImplicitly();
        logger.info("Creating object car");
        Car car = new Car();
        locatorproperties = getLocatorProperties();
        logger.info("Creating List listSelectMake and convert");
        List<Label> listSelectMake = Label.getConvertedElements(locatorproperties.getProperty(selectAMakeOptionsLocator));
        logger.info("Creating a random value Make");
        int rand = GeneralFunctions.generateRandomValue(listSelectMake.size());
        String locator = locatorproperties.getProperty(selectAMakeOptionsLocator) + "[" + rand + "]";
        ComboBox cmbMake = new ComboBox(By.xpath(locatorproperties.getProperty(selectAMakeLocator)), By.xpath(locator));
        logger.info("Input random value of Make");
        cmbMake.dropComboBox();
        car.setMake(cmbMake.getText());
        List<Label> listSelectModel = Label.getConvertedElements(locatorproperties.getProperty(selectAModelOptionsLocator));
        rand = GeneralFunctions.generateRandomValue(listSelectModel.size());
        locator = locatorproperties.getProperty(selectAModelOptionsLocator) + "[" + rand + "]";
        ComboBox cmbModel = new ComboBox(By.xpath(locatorproperties.getProperty(selectAModelLocator)), By.xpath(locator));
        logger.info("Input random value of Model");
        cmbModel.dropComboBox();
        car.setModel(cmbModel.getText());
        List<Label> listSelectYear = Label.getConvertedElements(locatorproperties.getProperty(selectAYearOptionsLocator));
        rand = GeneralFunctions.generateRandomValue(listSelectYear.size());
        locator = locatorproperties.getProperty(selectAYearOptionsLocator) + "[" + rand + "]";
        ComboBox cmbYear = new ComboBox(By.xpath(locatorproperties.getProperty(selectAYearLocator)), By.xpath(locator));
        logger.info("Input random value of Year");
        cmbYear.dropComboBox();
        car.setYear(cmbYear.getText());
        BrowserFactory.waitImplicitly();
        logger.info("Submit Search button");
        searchBtn = new Button(By.xpath(locatorproperties.getProperty(btnSearchLocator)));
        searchBtn.submit();
        return car;
    }

}
