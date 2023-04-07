package pages;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login extends AbstractPage {

    public Login(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@type=\"text\"]")
    private WebElement usernameField;

    @FindBy(xpath = "//input[@type=\"password\"]")
    private WebElement passwordField;

    @FindBy(xpath = "//span[@class=\"mdc-button__label\"]")
    private WebElement loginButton;

   @Step ("Авторизация пользователя")
    public MyPosts loginIn(String login, String password) throws InterruptedException {
        usernameField.click();
        usernameField.sendKeys(login);
        passwordField.click();
        passwordField.sendKeys(password);
        loginButton.click();
        Thread.sleep(4000);
        return new MyPosts(driver);
    }



    @Step("Проверка местоположения пользователя с помощью URL")
    public void checkUrl(){
        Assertions.assertTrue(driver.getCurrentUrl().contains("login"));
    }

}

