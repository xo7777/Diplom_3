package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ForgotPasswordPage {
    private WebDriver driver;

    //Кнопка "Войти" на странице "Забыли пароль"
    private By buttonLoginFromForgotPasswordPage = By.className("Auth_link__1fOlj");

    //Заголовок Восстановление пароля
    private By headerPasswordRecovery = By.xpath(".//h2[text()='Восстановление пароля']");


    //Конструктор
    public ForgotPasswordPage (WebDriver driver){
        this.driver = driver;
    }


    //Клик по кнопке "Войти" на странице "Забыли пароль"
    public void buttonLoginFromForgotPasswordPageClick(){
        driver.findElement(buttonLoginFromForgotPasswordPage).click();
    }


    //Ожидание загрузки страницы восстановления пароля
    public void waitForLoadForgotPasswordPage(){
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(headerPasswordRecovery));
    }






}
