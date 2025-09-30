import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class YandexBrowser {


    public WebDriver startYandexBrowser() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/yandexdriver.exe");
        //driver = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:/Program Files/Yandex/YandexBrowser/Application/browser.exe");
        WebDriver driver = new ChromeDriver(options);
        return driver;
    }
}