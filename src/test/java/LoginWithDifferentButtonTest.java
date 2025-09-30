import api.User;
import api.UserRequest;
import constants.DataTestGenerate;
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


    //вход по кнопке «Войти в аккаунт» на главной;
    @Test
    public void loginWithButtonOnMainPage() {
        objMainPage.buttonLoginMainPageClick();
        objLoginPage.loginUser(email, password);
        objMainPage.waitForLoadMainPage();
        String actualResult = objMainPage.getHeaderBurgerText();
        assertEquals(TEXT_HEADER_BURGER, actualResult);
    }

    //вход через кнопку «Личный кабинет»;
    @Test
    public void loginWithButtonPersonalAccount() {
        objMainPage.buttonPersonalAccountClick();
        objLoginPage.loginUser(email, password);
        objMainPage.waitForLoadMainPage();
        String actualResult = objMainPage.getHeaderBurgerText();
        assertEquals(TEXT_HEADER_BURGER, actualResult);
    }

    //вход через кнопку в форме регистрации;
    @Test
    public void loginWithButtonOnRegisterPage() {
        objRegisterPage.openRegisterBurgerSite();
        objRegisterPage.waitForLoadRegisterPage();
        objRegisterPage.buttonLoginFromRegisterPageClick();
        objLoginPage.loginUser(email, password);
        objMainPage.waitForLoadMainPage();
        String actualResult = objMainPage.getHeaderBurgerText();
        assertEquals(TEXT_HEADER_BURGER, actualResult);
    }


    //вход через кнопку в форме восстановления пароля.
    @Test
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
