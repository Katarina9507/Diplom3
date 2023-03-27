package site.nomoreparties.stellarburgers.pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final String url = "https://stellarburgers.nomoreparties.site/login";
    private final By emailField = By.xpath(".//fieldset[1]//input"); //Поле ввода email
    private final By passwordFiled = By.xpath(".//fieldset[2]//input"); //Поле ввода пароля
    private final By signInButtonOnLogin = By.xpath(".//button[text()='Войти']"); //Кнопка войти

    private final String expectedTextButtonSingIn = "Войти";

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private WebDriver driver;

    @Step("Заполнить пароль и email для входа в аккаунт пользователя")
    public LoginPage dataUserLogin(String valueEmail, String valuePassword) {
        driver.findElement(emailField).sendKeys(valueEmail);
        driver.findElement(passwordFiled).sendKeys(valuePassword);
        return this;
    }

    @Step("Открыть страницу логина пользователя")
    public LoginPage openPage() {
        driver.get(url);
        return this;
    }
    @Step("Кликнуть на кнопку Войти на странице логина")
    public LoginPage clickButtonLoginIn() {
        driver.findElement(signInButtonOnLogin).click();
        return this;
    }
    public String getExpectedTextButtonSingIn() {
        return expectedTextButtonSingIn;
    }
    public String getTextButtonSingIn(){
        return driver.findElement(signInButtonOnLogin).getText();
    }
}
