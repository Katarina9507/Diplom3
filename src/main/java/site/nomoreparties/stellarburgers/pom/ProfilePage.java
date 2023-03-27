package site.nomoreparties.stellarburgers.pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage {
    WebDriver driver;
    private final String url = "https://stellarburgers.nomoreparties.site/account/profile";
    public final By logOffButton = By.xpath(".//button[text()='Выход']"); //Кнопка Выйти из аккаунта

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Кликнуть на кнопку Выйте на странице просмотра профиля")
    public ProfilePage clickLogOffButton() {
        driver.findElement(logOffButton).click();
        return this;
    }
    @Step("Открыть страницу профиля пользователя")
    public ProfilePage openPage() {
        driver.get(url);
        return this;
    }
}
