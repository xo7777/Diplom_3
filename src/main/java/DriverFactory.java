import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {
    public WebDriver getDriver(String browserName) {
        if ("chrome".equalsIgnoreCase(browserName)) {
            return new ChromeDriver();
        } else if ("yandex".equalsIgnoreCase(browserName)) {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/yandexdriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.setBinary("C:/Program Files/Yandex/YandexBrowser/Application/browser.exe");
            WebDriver driver = new ChromeDriver(options);
            return driver;
        } else {
            throw new IllegalArgumentException("Unsupported browser: " + browserName);
        }
    }
}