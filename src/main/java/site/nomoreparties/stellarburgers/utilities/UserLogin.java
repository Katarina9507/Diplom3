package site.nomoreparties.stellarburgers.utilities;

public class UserLogin {
    private String email;
    private String password;

    public UserLogin(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public UserLogin() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static UserLogin from(UserCreate userCreate) {
        return new UserLogin(userCreate.getEmail(), userCreate.getPassword());
    }
}