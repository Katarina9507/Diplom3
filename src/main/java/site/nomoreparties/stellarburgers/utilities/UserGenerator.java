package site.nomoreparties.stellarburgers.utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class UserGenerator {
    public UserCreate randomDataCourier() {
        return new UserCreate(RandomStringUtils.randomAlphabetic(10) + "@mail.ru", "Qwerty1","Олег");
    }
}
