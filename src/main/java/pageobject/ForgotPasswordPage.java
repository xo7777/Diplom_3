package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static constants.Url.URL_FORGOT_PASSWORD;

public class ForgotPasswordPage {
    private WebDriver driver;

    //Кнопка "Войти" на странице "Забыли пароль"
    private By buttonLoginFromForgotPasswordPage = By.className("Auth_link__1fOlj");

    //Заголовок Восстановление пароля
    private By headerPasswordRecovery = By.xpath(".//h2[text()='Восстановление пароля']");


    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }


    @Step("Вход на страницу восстановления пароля")
    public void openForgotPasswordPage() {
        driver.get(URL_FORGOT_PASSWORD);
    }


    @Step ("Клик по кнопке Войти на странице Забыли пароль")
    public void buttonLoginFromForgotPasswordPageClick() {
        driver.findElement(buttonLoginFromForgotPasswordPage).click();
    }


    @Step ("Ожидание загрузки страницы восстановления пароля")
    public void waitForLoadForgotPasswordPage() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(headerPasswordRecovery));
    }


}
