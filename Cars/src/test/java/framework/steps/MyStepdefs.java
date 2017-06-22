package framework.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.cars.elements.BaseEntity;
import framework.cars.elements.BasePage;
import framework.cars.menu.Menu;
import framework.cars.model.Car;
import framework.cars.pages.CarComparisonPage;
import framework.cars.pages.CarDescriptionPage;
import framework.cars.pages.CarModificationPage;
import framework.cars.pages.MainPage;
import framework.webdriver.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Properties;

/**
 * Created by d.korobkin on 6/20/17.
 */
public class MyStepdefs {

    WebDriver driver;
    BaseEntity baseEntity;
    Car firstCar;
    Car secondCar;
    MainPage mainPage;
    CarDescriptionPage carDescriptionPage;
    CarModificationPage carModificationPage;
    CarComparisonPage carComparisonPage;

    @Given("^User was opened main page cars$")
    public void userWasOpenedMainPageCars() throws Throwable {
        BasePage basePage = new BasePage();
        Properties properties = basePage.initProperties();
        basePage.initLocatorProperties();
        String browser = properties.getProperty("browser");
        driver = BrowserFactory.getDriver(browser);
        String mainPage = properties.getProperty("main_page_url");
        basePage = new BasePage(driver);
        basePage.maximiseWindow();
        basePage.navigate(mainPage);
        baseEntity = new BaseEntity();
    }

    @When("^In the search, the user choose \"([^\"]*)\"$")
    public void inTheSearchTheUserChoose(String arg0) throws Throwable {
        mainPage.menu.navigateMenu(Menu.MenuItem.READ);
    }

    @Then("^\"([^\"]*)\" tab is displayed$")
    public void tabIsDisplayed(String arg0) throws Throwable {
        mainPage.assertTrue(true);
    }

    @When("^The user searches for randomly selected characteristics$")
    public void theUserSearchesForRandomlySelectedCharacteristics() throws Throwable {
        firstCar = mainPage.InputRandomValue();
    }

    @Then("^After clicking on the Search button, a page describing the auto$")
    public void afterClickingOnTheSearchButtonAPageDescribingTheAuto() throws Throwable {

    }

    @When("^On the Trims tab, the user select the first available vehicle modification$")
    public void onTheTrimsTabTheUserSelectTheFirstAvailableVehicleModification() throws Throwable {
        carDescriptionPage.selectFirstModification();
    }

    @Then("^The page with the characteristics of the selected modification was opened$")
    public void thePageWithTheCharacteristicsOfTheSelectedModificationWasOpened() throws Throwable {

    }

    @When("^Remember 'Available Engines', 'Transmissions' for later comparison$")
    public void rememberAvailableEnginesTransmissionsForLaterComparison() throws Throwable {
        firstCar = carModificationPage.saveModification();
        firstCar.setEngine(firstCar.getEngine());
        firstCar.setTransmission(firstCar.getTransmission());
    }

    @Then("^Features 'Available Engines', 'Transmissions'  saved$")
    public void featuresAvailableEnginesTransmissionsSaved() throws Throwable {

    }

    @When("^The user goes to the main page cars$")
    public void theUserGoesToTheMainPageCars() throws Throwable {
        BrowserFactory.navigateUrl(BasePage.getProperties().getProperty("main_page_url"));
    }

    @Then("^The main page of the site is opened$")
    public void theMainPageOfTheSiteIsOpened() throws Throwable {
        mainPage.assertTrue(true);
    }

    /*---------------------------------------------------------------------------------------------------------------- */
    @When("^In the search, the user choose \"([^\"]*)\" for second Car$")
    public void inTheSearchTheUserChooseForSecondCar(String arg0) throws Throwable {
        mainPage.menu.navigateMenu(Menu.MenuItem.READ);
    }

    @Then("^\"([^\"]*)\" tab for second Car is displayed$")
    public void tabForSecondCarIsDisplayed(String arg0) throws Throwable {

    }

    @When("^The user searches for randomly selected characteristics for second Car$")
    public void theUserSearchesForRandomlySelectedCharacteristicsForSecondCar() throws Throwable {
        secondCar = mainPage.InputRandomValue();
    }

    @Then("^After clicking on the Search button, a page describing the second auto$")
    public void afterClickingOnTheSearchButtonAPageDescribingTheSecondAuto() throws Throwable {

    }

    @When("^On the Trims tab, the user select the first available vehicle modification of second car$")
    public void onTheTrimsTabTheUserSelectTheFirstAvailableVehicleModificationOfSecondCar() throws Throwable {
        carDescriptionPage.selectFirstModification();
    }

    @Then("^The page with the characteristics for second car of the selected modification was opened$")
    public void thePageWithTheCharacteristicsForSecondCarOfTheSelectedModificationWasOpened() throws Throwable {

    }

    @When("^Remember 'Available Engines', 'Transmissions' of second car for later comparison$")
    public void rememberAvailableEnginesTransmissionsOfSecondCarForLaterComparison() throws Throwable {
        secondCar = carModificationPage.saveModification();
    }

    @Then("^Features 'Available Engines', 'Transmissions'  for second car saved$")
    public void featuresAvailableEnginesTransmissionsForSecondCarSaved() throws Throwable {

    }

    @When("^In the Trims list, select the first current modification for comparison$")
    public void inTheTrimsListSelectTheFirstCurrentModificationForComparison() throws Throwable {
       carModificationPage.selectCarToCompare();
    }

    @Then("^Moved to the car comparison page$")
    public void movedToTheCarComparisonPage() throws Throwable {

    }

    @When("^User Selects the first car for comparison press the Add Another Car button and select the desired model$")
    public void userSelectsTheFirstCarForComparisonPressTheAddAnotherCarButtonAndSelectTheDesiredModel() throws Throwable {
        carComparisonPage.clickToAddAnotherCar();
        carComparisonPage.inputSavedParameters(firstCar);
    }

    @Then("^Models have been successfully selected for comparison$")
    public void modelsHaveBeenSuccessfullySelectedForComparison() throws Throwable {

    }

    @When("^User checks the comparison page of (\\d+) models$")
    public void userChecksTheComparisonPageOfModels(int arg0) throws Throwable {
       carComparisonPage.compareCars(firstCar, secondCar);
    }

    @Then("^The auto characteristics on the page correspond to those obtained in steps (\\d+)-(\\d+)$")
    public void theAutoCharacteristicsOnThePageCorrespondToThoseObtainedInSteps(int arg0, int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}















