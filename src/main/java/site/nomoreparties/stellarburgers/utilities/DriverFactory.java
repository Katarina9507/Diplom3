package site.nomoreparties.stellarburgers.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {
    public static WebDriver getBrowser(String browserName) {

        switch (browserName) {
            case "yandex":
                System.setProperty("webdriver.chrome.driver", "/Users/karina/Desktop/JavaTests/chromedriver");
                return new ChromeDriver();

            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                return new ChromeDriver(chromeOptions);

            default: throw new RuntimeException("Только Хром и Яндекс!");
        }
    }
}