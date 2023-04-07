package web;

import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.Login;
import pages.MyPosts;
import pages.Posts;

public class AuthTest extends AbstractTest {

    Login login;
    MyPosts myPosts;
    Posts posts;
    protected String username = "bug";
    protected String password = "ae0e4bdad7";

    @BeforeEach
    void init() {
    login = new Login(getWebDriver());
    myPosts = new MyPosts(getWebDriver());
    posts = new Posts(getWebDriver());
}
    @Test
    @Story("Проверка граничных значений")
    @DisplayName("1: Авторизация с логином из 3 символов")
    public void test2() throws InterruptedException {
        login.loginIn(username,password);
        myPosts.checkChangeUrl();
    }
    @Test
    @Story("Проверка граничных значений")
    @DisplayName("2: Авторизация с логином из 20 символов")
    public void test3() throws InterruptedException {
        login.loginIn("bugmanbugmanbugman20","d0b85ec0bb");
        myPosts.checkChangeUrl();
    }

    @Test
    @Story("Не валидная авторизация")
    @DisplayName("3: Авторизация с пустыми полями логина и пароля")
    public void test4() throws InterruptedException {
        login.loginIn("","");
        login.checkUrl();
    }
    @Test
    @Story("Не валидная авторизация")
    @DisplayName("4: Авторизация недействительного логина с действующим паролем")
    public void test5() throws InterruptedException {
        login.loginIn("monkey", password);
        login.checkUrl();
    }
    @Test
    @Story("Проверка граничных значений")
    @DisplayName("5: Авторизация с логином из 2 символов")
    public void test6() throws InterruptedException {
        login.loginIn("bu","97bf9c5c97");
        login.checkUrl();
    }
    @Test
    @Story("Проверка граничных значений")
    @DisplayName("6: Авторизация с логином из 21 символа")
    public void test7() throws InterruptedException {
        login.loginIn("bugmanbugmanbugman211","3e19aaeef0");
        login.checkUrl();
    }

    @Test
    @Story("НЕвалидная авторизация")
    @DisplayName("7: Авторизация с логином со спецсимволом")
    public void test10() throws InterruptedException {
        login.loginIn("bu>","5b59ab12d7");
        login.checkUrl();//проверяем что остались на той же странице
    }

}
