package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static constants.Url.BASE_URL;

public class MainPage {
    private WebDriver driver;
    //Заголовок соберите бургер
    private By headerBurger = By.xpath(".//h1[text()='Соберите бургер']");
    //Кнопка "Войти в аккаунт" на главной странице
    private By buttonLoginMainPage = By.xpath(".//button[text()='Войти в аккаунт']");
    //Кнопка "Личный кабинет"
    private By buttonPersonalAccount = By.xpath(".//p[text()='Личный Кабинет']");
    //Кнопка Булки
    private By buttonBun = By.xpath(".//span[text()='Булки']");
    //Кнопка Соусы
    private By buttonSauce = By.xpath(".//span[text()='Соусы']");
    //Кнопка Начинки
    private By buttonFilling = By.xpath(".//span[text()='Начинки']");
    //Локатор выбранного раздела
    private By activeSection = By.cssSelector(".tab_tab__1SPyG.tab_tab_type_current__2BEPc.pt-4.pr-10.pb-4.pl-10.noselect");


    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step ("Вход на главную страницу")
    public void openBurgerSite() {
        driver.get(BASE_URL);
    }

    @Step("Клик по кнопке Войти в аккаунт на главной странице")
    public void buttonLoginMainPageClick() {
        driver.findElement(buttonLoginMainPage).click();
    }

    @Step ("Клик по кнопке Личный кабинет на главной странице")
    public void buttonPersonalAccountClick() {
        driver.findElement(buttonPersonalAccount).click();
    }

    @Step ("Клик по кнопке Булки")
    public void buttonBunClick() {
        driver.findElement(buttonBun).click();
    }

    @Step ("Клик по кнопке Соусы")
    public void buttonSauceClick() {
        driver.findElement(buttonSauce).click();
    }

    @Step ("Ожидание выбора раздела Булки")
    public void waitForLoadBunSection() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.textToBePresentInElementLocated(activeSection,"Булки"));
    }

    @Step ("Клик по кнопке Начинки")
    public void buttonFillingClick() {
        driver.findElement(buttonFilling).click();
    }

    @Step("Получение текста из активного раздела")
    public String getTextActiveSection() {
        String text = driver.findElement(activeSection).getText();
        return text;
    }

    @Step ("Ожидание загрузки главной страницы")
    public void waitForLoadMainPage() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(headerBurger));
    }

    @Step ("Получение текста заголовка Соберите бургер")
    public String getHeaderBurgerText() {
        String text = driver.findElement(headerBurger).getText();
        return text;
    }

}
