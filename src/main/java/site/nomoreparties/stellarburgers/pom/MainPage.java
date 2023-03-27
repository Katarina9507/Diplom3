package site.nomoreparties.stellarburgers.pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class MainPage {
    private WebDriver driver;
    private final String url = "https://stellarburgers.nomoreparties.site";
    private final By signInAccountButton = By.xpath("//button[text()='Войти в аккаунт']"); //Кнопка войти в аккаунт
    private final By createOrder = By.xpath(".//button[text()='Оформить заказ']"); //Кнопка Оформить заказ
    private final By personalAccountButton = By.linkText("Личный Кабинет"); //Кнопка входа в личный кабинет
    private final By bunsTab = By.xpath(".//div/span[text()='Булки']"); //Раздел Булки в конструкторе
    private final By saucesTab = By.xpath(".//div/span[text()='Соусы']"); //Раздел Соусы в конструкторе
    private final By fillingsTab = By.xpath(".//div/span[text()='Начинки']"); //Раздел Начинки в конструкторе
    private final By activeTab = By.xpath(".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[@class='text text_type_main-default']"); // Название активной вкладки на странице в конструкторе

    private final String expectedTextButtonСreateOrder = "Оформить заказ";
    private final String expectedNameActiveTubBuns = "Булки";
    private final String expectedNameActiveTubSauces = "Соусы";
    private final String expectedNameActiveTubFillings = "Начинки";
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Открыть главную страницу")
    public MainPage openPage() {
        driver.get(url);
        return this;
    }
    @Step("Кликнуть на кнопку Войти в аккаунт для незарегистрированных пользователей")
    public MainPage clickButtonSignInAccount() {
        driver.findElement(signInAccountButton).click();
        return this;
    }
    @Step("Кликнуть на кнопку Личный кабинет на главной странице")
    public MainPage clickPersonalAccountButton() {
        driver.findElement(personalAccountButton).click();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(driver -> driver.findElement(personalAccountButton)).click();
        return this;
    }

    public String getExpectedTextButtonСreateOrder() {
        return expectedTextButtonСreateOrder;
    }

    public String getTextButtonСreateOrder(){
        return driver.findElement(createOrder).getText();
    }
    @Step("Кликнуть на вкладку Булочки в конструкторе бургеров")
    public MainPage clickBunsTabConstructor() {
        driver.findElement(bunsTab).click();
        return this;
    }
    @Step("Кликнуть на вкладку Соусы в конструкторе бургеров")
    public MainPage clickSaucesTabConstructor() {
        driver.findElement(saucesTab).click();
        return this;
    }
    @Step("Кликнуть на вкладку Начинки в конструкторе бургеров")
    public MainPage clickFillingsTabConstructor() {
        driver.findElement(fillingsTab).click();
        return this;
    }
    public String getTextActiveTab() {
        return driver.findElement(activeTab).getText();
    }

    public String getExpectedNameActiveTubBuns() {
        return expectedNameActiveTubBuns;
    }

    public String getExpectedNameActiveTubSauces() {
        return expectedNameActiveTubSauces;
    }

    public String getExpectedNameActiveTubFillings() {
        return expectedNameActiveTubFillings;
    }
}
