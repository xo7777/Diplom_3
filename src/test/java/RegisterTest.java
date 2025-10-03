import constants.DataTestGenerate;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageobject.LoginPage;
import pageobject.MainPage;
import pageobject.RegisterPage;

import static constants.ExpectedResult.TEXT_ERROR_MESSAGE;
import static constants.ExpectedResult.TEXT_HEADER_BURGER;
import static org.junit.Assert.assertEquals;


public class RegisterTest {
    private DataTestGenerate dataTestGenerate;
    private RegisterPage objRegisterPage;
    private LoginPage objLoginPage;
    private MainPage objMainPage;
    private WebDriver driver;
    private String name;
    private String email;
    private String password;


    @Before
    public void setUp() {
        DriverFactory driverFactory = new DriverFactory();
        driver = driverFactory.getDriver();
        dataTestGenerate = new DataTestGenerate();
        name = dataTestGenerate.generateName();
        email = dataTestGenerate.generateEmail();
        password = dataTestGenerate.generatePassword();
        objRegisterPage = new RegisterPage(driver);
        objLoginPage = new LoginPage(driver);
        objMainPage = new MainPage(driver);
        objRegisterPage.openRegisterBurgerSite();

    }

    @Test
    @DisplayName("Регистрация пользователя")
    @Description("Успешная регистрация пользователя с валидными значениями")
    public void registerTest() {
        objRegisterPage.waitForLoadRegisterPage();
        objRegisterPage.setName(name);
        objRegisterPage.setEmail(email);
        objRegisterPage.setPassword(password);
        objRegisterPage.buttonRegisterClick();
        objLoginPage.waitForLoadEntrancePage();
        objLoginPage.setEmail(email);
        objLoginPage.setPassword(password);
        objLoginPage.buttonLoginClick();
        objMainPage.waitForLoadMainPage();
        String actualResult = objMainPage.getHeaderBurgerText();
        assertEquals(TEXT_HEADER_BURGER, actualResult);
    }

    @Test
    @DisplayName("Регистрация пользователя с некорректным паролем")
    @Description("Ошибка Некорректнвй пароль при вводе пароля менее 6 символов")
    public void errorMessagePasswordTest() {
        objRegisterPage.waitForLoadRegisterPage();
        password = "12345";
        objRegisterPage.setName(name);
        objRegisterPage.setEmail(email);
        objRegisterPage.setPassword(password);
        objRegisterPage.buttonRegisterClick();
        objRegisterPage.waitErrorMessage();
        String actualResult = objRegisterPage.getErrorMessageText();
        assertEquals(TEXT_ERROR_MESSAGE, actualResult);
    }


    @After
    public void tearDown() {
        driver.quit();
    }

}
