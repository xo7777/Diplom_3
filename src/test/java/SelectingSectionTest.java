import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobject.MainPage;

import static constants.ExpectedResult.*;
import static org.junit.Assert.assertEquals;

public class SelectingSectionTest {
    private WebDriver driver;
    private MainPage objMainPage;


    @Before
    public void setUp() {
        driver = new ChromeDriver();
        objMainPage = new MainPage(driver);
        objMainPage.openBurgerSite();
        objMainPage.waitForLoadMainPage();
    }


    //Тест на выбор раздела Булки
    @Test
    public void selectBunTest() {
        objMainPage.buttonFillingClick();
        objMainPage.buttonBunClick();
        String actualResult = objMainPage.getTextActiveSection();
        assertEquals(NAME_BUN, actualResult);
    }

    //Тест на выбор раздела Соусы
    @Test
    public void selectSauceTest() {
        objMainPage.buttonSauceClick();
        String actualResult = objMainPage.getTextActiveSection();
        assertEquals(NAME_SAUCE, actualResult);
    }

    //Тест на выбор раздела Начинки
    @Test
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
