import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileInputStream;
import java.util.Properties;

public class DriverFactory {
    public WebDriver getDriver() {
        Properties props = new Properties();
        try {
            props.load(new FileInputStream("src/test/resources/config.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        String browserName = props.getProperty("browser","chrome"); // По умолчанию chrome

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