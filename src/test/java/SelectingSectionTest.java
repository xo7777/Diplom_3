import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageobject.MainPage;

import static constants.ExpectedResult.*;
import static org.junit.Assert.assertEquals;

public class SelectingSectionTest {
    private WebDriver driver;
    private MainPage objMainPage;


    @Before
    public void setUp() {
        DriverFactory driverFactory = new DriverFactory();
        driver = driverFactory.getDriver("yandex"); //Чтобы использовать chrome измените параметр на "chrome"
        objMainPage = new MainPage(driver);
        objMainPage.openBurgerSite();
        objMainPage.waitForLoadMainPage();
    }

    @Test
    @DisplayName("Выбор раздела Булки")
    @Description("Раздел Булки успешно выбирается")
    public void selectBunTest() {
        objMainPage.buttonFillingClick();
        objMainPage.buttonBunClick();
        String actualResult = objMainPage.getTextActiveSection();
        assertEquals(NAME_BUN, actualResult);
    }

    @Test
    @DisplayName("Выбор раздела Соусы")
    @Description("Раздел Соусы успешно выбирается")
    public void selectSauceTest() {
        objMainPage.buttonSauceClick();
        String actualResult = objMainPage.getTextActiveSection();
        assertEquals(NAME_SAUCE, actualResult);
    }

    @Test
    @DisplayName("Выбор раздела Начинки")
    @Description("Раздел Начинки успешно выбирается")
    public void selectFillingTest() {
        objMainPage.buttonFillingClick();
        String actualResult = objMainPage.getTextActiveSection();
        assertEquals(NAME_FILLING, actualResult);
    }

    @After
    public void tearDown() {
        driver.quit();
    }


}
