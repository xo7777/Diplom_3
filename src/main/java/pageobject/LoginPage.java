package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private WebDriver driver;
    //Поле Email
    private By emailField = By.xpath(".//label[text()='Email']/../input[@name='name']");
    //Поле Пароль
    private By passwordField = By.xpath(".//label[text()='Пароль']/../input[@name='Пароль']");
    //Кнопка Войти
    private By buttonLogin = By.xpath(".//button[text()='Войти']");
    //Заголовок Вход
    private By headerEntrance = By.xpath(".//h2[text()='Вход']");
    //Кнопка "Восстановить пароль" на странице входа
    private By buttonForgotPassword = By.xpath(".//a[@href='/forgot-password']");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }


    @Step("Ожидание загрузки страницы Входа")
    public void waitForLoadEntrancePage() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(headerEntrance));
    }

    @Step("Заполнение поля Email")
    public void setEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    @Step("Заполнение поля Пароль")
    public void setPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    @Step("Клик по кнопке Войти")
    public void buttonLoginClick() {
        driver.findElement(buttonLogin).click();
    }

    @Step("Клик по кнопке Восстановить пароль на странице входа")
    public void buttonForgotPasswordClick() {
        driver.findElement(buttonForgotPassword).click();
    }

    @Step("Авторизация пользователя")
    public void loginUser(String email, String password) {

        waitForLoadEntrancePage();
        setEmail(email);
        setPassword(password);
        buttonLoginClick();

    }


}
