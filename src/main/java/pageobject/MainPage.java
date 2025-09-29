package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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


    //Краторная булка
    private By craterBun = By.cssSelector("img[alt ='Краторная булка N-200i']");

    //Соус с шипами плоскоходца
    private By antarianSauce = By.cssSelector("img[alt ='Соус с шипами Антарианского плоскоходца']");


    // Биокотлета из марсианской Магнолии
    private By cutletMartian = By.cssSelector("img[alt ='Биокотлета из марсианской Магнолии']");



    //Конструктор
    public MainPage (WebDriver driver){
        this.driver = driver;
    }



    //Клик по кнопке "Войти в аккаунт" на главной странице
    public void buttonLoginMainPageClick(){
        driver.findElement(buttonLoginMainPage).click();
    }


    //Клик по кнопке "Личный кабинет" на главной странице
    public void buttonPersonalAccountClick(){
        driver.findElement(buttonPersonalAccount).click();
    }

    //Клик по кнопке Булки
    public void buttonBunClick(){
        driver.findElement(buttonBun).click();
    }

    //Клик по кнопке Соусы
    public void buttonSauceClick(){
        driver.findElement(buttonSauce).click();
    }

    //Клик по кнопке Начинки
    public void buttonFillingClick(){
        driver.findElement(buttonFilling).click();
    }


    //Ожидание кликабельности краторной булки
    public void waitCraterBun(){
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(craterBun));
    }


    //Ожидание кликабельности Соуса с шипами плоскоходца
    public void waitAntarianSauce(){
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(antarianSauce));
    }


    //Ожидание кликабельности Биокотлеты из марсианской Магнолии
    public void waitCutletMartian(){
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(cutletMartian));
    }


    //Клик по краторной булке
    public void craterBunClick(){
        driver.findElement(craterBun).click();
    }


    //Клик по Соусу с шипами плоскоходца
    public void antarianSauceClick(){
        driver.findElement(antarianSauce).click();
    }

    //Клик по Биокотлете из марсианской Магнолии
    public void cutletMartianClick(){
        driver.findElement(cutletMartian).click();
    }


    //Получение текста имени ингредиента
    public String getNameOfIngredient(){
        String text = driver.findElement(By.className("text text_type_main-medium mb-8")).getText();
        return text;
    }



    //Ожидание загрузки главной страницы
    public void waitForLoadMainPage(){
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(headerBurger));
    }


    //Получение текста заголовка "Соберите бургер"
    public String getHeaderBurgerText(){
        String text = driver.findElement(headerBurger).getText();
        return text;
    }

}
