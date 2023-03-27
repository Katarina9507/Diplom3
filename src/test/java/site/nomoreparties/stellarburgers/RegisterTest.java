package site.nomoreparties.stellarburgers;

import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import site.nomoreparties.stellarburgers.pom.LoginPage;
import site.nomoreparties.stellarburgers.pom.RegisterPage;
import site.nomoreparties.stellarburgers.utilities.*;
import java.time.Duration;
import static org.junit.Assert.assertEquals;

public class RegisterTest {

    private String email, password, name, accessToken, actualTextButtonSingIn;
    private final UserGenerator userGenerator = new UserGenerator();
    UserCreate uniqueUser = userGenerator.randomDataCourier();

    private WebDriver driver;

    @Before
    public void setup() {
        driver = DriverFactory.getBrowser("chrome");
        //driver = DriverFactory.getBrowser("yandex");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @After
    public void loginAndDeleteUserAndCloseBrowser() {
        if(actualTextButtonSingIn != null) {
            UserApi userApi = new UserApi();
            UserLogin userLogin = UserLogin.from(uniqueUser);
            ValidatableResponse login = userApi.login(userLogin);
            accessToken = userApi.loginInSusses(login);
            ValidatableResponse response = userApi.delete(accessToken);
            userApi.assertDeleteSuccess(response);
        }
        driver.quit();
    }

    @DisplayName("Успешная регистрация валидного пользователя")
    @Test
    public void successfulRegistrationOfValidUser() {
        RegisterPage registerPage = new RegisterPage(driver);
        email = uniqueUser.getEmail();
        name = uniqueUser.getName();
        password = uniqueUser.getPassword();
        registerPage.openPage().dataUserCreate(name, email, password).clickButtonRegistr();
        LoginPage loginPage = new LoginPage(driver);
        actualTextButtonSingIn = loginPage.getTextButtonSingIn();
        assertEquals("Ошибка регистрации", loginPage.getExpectedTextButtonSingIn(), actualTextButtonSingIn);
    }

    @DisplayName("Неуспешная регистрация пользователяс c паролем меньше 6 символов")
    @Test
    public void registeringUserWithPasswordLessThenSixCharacters () {
        RegisterPage registerPage = new RegisterPage(driver);
        email = uniqueUser.getEmail();
        name = uniqueUser.getName();
        uniqueUser.setPassword(RandomStringUtils.randomAlphanumeric(5));
        password = uniqueUser.getPassword();
        registerPage.openPage().dataUserCreate(name, email, password).clickButtonRegistr();
        assertEquals("Ошибочная проверка на ввод некорректного пароля", registerPage.getExpectedTextErrorMessage(), registerPage.getPasswordErrorText());
    }
}