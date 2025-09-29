import constants.DataTestGenerate;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
    public void setUp(){
        driver = new ChromeDriver();
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
public void registerTest(){
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
public void errorMessagePasswordTest(){
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
    public void tearDown(){
        driver.quit();
    }

}
