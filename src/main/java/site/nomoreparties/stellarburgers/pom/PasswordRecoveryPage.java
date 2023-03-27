package site.nomoreparties.stellarburgers.pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PasswordRecoveryPage {
    WebDriver driver;
    private final String url = "https://stellarburgers.nomoreparties.site/forgot-password";
    public final By signInLink = By.linkText("Войти"); //Кнопка войти

    public PasswordRecoveryPage(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Открыть страницу восстановления пароля")
    public PasswordRecoveryPage openPage() {
        driver.get(url);
        return this;
    }
    @Step("Кликнуть на линк Войти на странице восстановления пароля")
    public PasswordRecoveryPage clickSignInLink() {
        driver.findElement(signInLink).click();
        return this;
    }
}
