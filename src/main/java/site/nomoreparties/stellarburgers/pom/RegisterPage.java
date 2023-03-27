package site.nomoreparties.stellarburgers.pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    private WebDriver driver;
    private final String url = "https://stellarburgers.nomoreparties.site/register"; //Страница регистрации
    private final By filedName = By.xpath(".//fieldset[1]//input"); //Поле ввода имени
    private final By filedEmail = By.xpath(".//fieldset[2]//input"); //Поле ввода email
    private final By filedPassword = By.xpath(".//fieldset[3]//input"); //Поле ввода пароля
    private final By registerButton = By.xpath(".//button[text()='Зарегистрироваться']"); //Кнопка зарегистрироваться
    private final By signInButton = By.linkText("Войти"); //Кнопка войти
    private final By passwordErrorText = By.xpath(".//p[text()='Некорректный пароль']"); //Надпить с ошибкой некорректный пароль
    private final String expectedTextErrorMessage = "Некорректный пароль";


    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Открыть страницу регистрации пользователя")
    public RegisterPage openPage() {
        driver.get(url);
        return this;
    }
    @Step("Заполнить пароль, email, имя для регистрации нового пользователя")
    public RegisterPage dataUserCreate(String valueName, String valueEmail, String valuePassword) {
        driver.findElement(filedName).sendKeys(valueName);
        driver.findElement(filedEmail).sendKeys(valueEmail);
        driver.findElement(filedPassword).sendKeys(valuePassword);
        return this;
    }
    @Step("Кликнуть на кнопку Регистрации на странице регистрации")
    public RegisterPage clickButtonRegistr() {
        driver.findElement(registerButton).click();
        return this;
    }
    @Step("Кликнуть на кнопку Войти на странице регистрации")
    public RegisterPage clickButtonSignInButton() {
        driver.findElement(signInButton).click();
        return this;
    }

    public String getPasswordErrorText(){
        return driver.findElement(passwordErrorText).getText();
    }
    public String getExpectedTextErrorMessage() {
        return expectedTextErrorMessage;
    }
}
