package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static constants.Url.URL_REGISTER;

public class RegisterPage {
    private WebDriver driver;
    //Поле Имя
    private By nameField = By.xpath(".//label[text()='Имя']/../input[@name='name']");
    //Поле Email
    private By emailField = By.xpath(".//label[text()='Email']/../input[@name='name']");
    //Поле Пароль
    private By passwordField = By.xpath(".//label[text()='Пароль']/../input[@name='Пароль']");
    //Кнопка зарегистрироваться
    private By buttonRegister = By.xpath("//button[text()='Зарегистрироваться']");
    //Заголовок Регистрация
    private By headerRegister = By.xpath(".//h2[text()='Регистрация']");
    //Сообщение об ошибке
    private By errorPasswordMessage = By.xpath(".//p[text()='Некорректный пароль']");
    //Кнопка "Войти" на странице регистрации
    private By buttonLoginFromRegisterPage = By.xpath(".//a[text()='Войти']");


    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Вход на страницу регистрации")
    public void openRegisterBurgerSite() {
        driver.get(URL_REGISTER);
    }

    @Step("Заполнение поля Имя")
    public void setName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    @Step("Заполнение поля Email")
    public void setEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    @Step("Заполнение поля Пароль")
    public void setPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    @Step("Клик по кнопке Зарегистрироваться")
    public void buttonRegisterClick() {
        driver.findElement(buttonRegister).click();
    }

    @Step("Ожидание загрузки страницы Регистрации")
    public void waitForLoadRegisterPage() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(headerRegister));
    }

    @Step("Ожидание появления ошибки Некорректный пароль")
    public void waitErrorMessage() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(errorPasswordMessage));
    }

    @Step("Получение текста ошибки Некорректный пароль")
    public String getErrorMessageText() {
        String text = driver.findElement(errorPasswordMessage).getText();
        return text;
    }

    @Step("Клик по кнопке Войти на странице регистрации")
    public void buttonLoginFromRegisterPageClick() {
        driver.findElement(buttonLoginFromRegisterPage).click();
    }

    @Step("Регистрация пользователя")
    public void registerUser(String name, String email, String password) {
        waitForLoadRegisterPage();
        setName(name);
        setEmail(email);
        setPassword(password);
        buttonRegisterClick();
    }

}
