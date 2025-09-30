import api.User;
import api.UserRequest;
import constants.DataTestGenerate;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobject.ForgotPasswordPage;
import pageobject.LoginPage;
import pageobject.MainPage;
import pageobject.RegisterPage;

import static constants.ExpectedResult.TEXT_HEADER_BURGER;
import static org.junit.Assert.assertEquals;

public class LoginWithDifferentButtonTest {
    private WebDriver driver;
    private MainPage objMainPage;
    private LoginPage objLoginPage;
    private RegisterPage objRegisterPage;
    private ForgotPasswordPage objForgotPasswordPage;
    DataTestGenerate dataTestGenerate = new DataTestGenerate();
    private User user;
    private UserRequest userRequest;
    private String accessToken;
    private Response userCreate;
    private String email;
    private String password;
    private String name;


    @Before
    public void setUp() {
        email = dataTestGenerate.generateEmail();
        password = dataTestGenerate.generatePassword();
        name = dataTestGenerate.generateName();
        user = new User();
        userRequest = new UserRequest(email, password, name);
        userCreate = user.createUser(userRequest);
        accessToken = userCreate.jsonPath().getString("accessToken");
        driver = new ChromeDriver();
        objLoginPage = new LoginPage(driver);
        objRegisterPage = new RegisterPage(driver);
        objMainPage = new MainPage(driver);
        objMainPage.openBurgerSite();
        objMainPage.waitForLoadMainPage();
    }


    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной странице")
    @Description("Успешный вход с главной страницы")
    public void loginWithButtonOnMainPage() {
        objMainPage.buttonLoginMainPageClick();
        objLoginPage.loginUser(email, password);
        objMainPage.waitForLoadMainPage();
        String actualResult = objMainPage.getHeaderBurgerText();
        assertEquals(TEXT_HEADER_BURGER, actualResult);
    }

    @Test
    @DisplayName("Вход через кнопку «Личный кабинет» на главной странице")
    @Description("Успешный вход через кнопку «Личный кабинет»")
    public void loginWithButtonPersonalAccount() {
        objMainPage.buttonPersonalAccountClick();
        objLoginPage.loginUser(email, password);
        objMainPage.waitForLoadMainPage();
        String actualResult = objMainPage.getHeaderBurgerText();
        assertEquals(TEXT_HEADER_BURGER, actualResult);
    }

    @Test
    @DisplayName("Вход через кнопку Войти в форме регистрации")
    @Description("Успешный вход через кнопку Войти в форме регистрации")
    public void loginWithButtonOnRegisterPage() {
        objRegisterPage.openRegisterBurgerSite();
        objRegisterPage.waitForLoadRegisterPage();
        objRegisterPage.buttonLoginFromRegisterPageClick();
        objLoginPage.loginUser(email, password);
        objMainPage.waitForLoadMainPage();
        String actualResult = objMainPage.getHeaderBurgerText();
        assertEquals(TEXT_HEADER_BURGER, actualResult);
    }

    @Test
    @DisplayName("Вход через кнопку Войти форме восстановления пароля")
    @Description("Успешный вход через кнопку Войти в восстановления пароля")
    public void loginWithButtonOnForgotPasswordPage() {
        objForgotPasswordPage = new ForgotPasswordPage(driver);
        objForgotPasswordPage.openForgotPasswordPage();
        objForgotPasswordPage.waitForLoadForgotPasswordPage();
        objForgotPasswordPage.buttonLoginFromForgotPasswordPageClick();
        objLoginPage.loginUser(email, password);
        objMainPage.waitForLoadMainPage();
        String actualResult = objMainPage.getHeaderBurgerText();
        assertEquals(TEXT_HEADER_BURGER, actualResult);
    }


    @After
    public void tearDown() {
        driver.quit();
        user.deleteUser(accessToken);
    }


}
