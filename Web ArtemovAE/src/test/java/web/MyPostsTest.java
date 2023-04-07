package web;

import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.Login;
import pages.MyPosts;
import pages.Posts;

public class MyPostsTest extends AbstractTest {
    Login login;
    MyPosts myPosts;
    Posts posts;
    protected String username = "bugman";
    protected String password = "0ea95f2628";

    @BeforeEach
    void init() {
        login = new Login(getWebDriver());
        myPosts = new MyPosts(getWebDriver());
        posts = new Posts(getWebDriver());
    }

    @Test
    @Story("Лента своих постов")
    @DisplayName("1: Переход к следущей странице в ленте своих постов")
    public void test1() throws InterruptedException {
        login.loginIn(username,password);
        myPosts.toNextPage();
        myPosts.checkToNextPage();
    }
    @Test
    @Story("Лента своих постов")
    @DisplayName("2: У превью поста отображается картинка, заголовок и описание")
    public void test2() throws InterruptedException {
        login.loginIn(username,password);
        myPosts.checkPosts();

    }
    @Test
    @Story("Лента своих постов")
    @DisplayName("3: Переход на предыдущую страницу ленты своих постов ")
    public void test3() throws InterruptedException {
        login.loginIn(username,password);
        myPosts.moveToPreviousPage();
        myPosts.checkMoveToPreviousPage();

    }
    @Test
    @Story("Лента своих постов")
    @DisplayName("4: Переход на страницу конкретного поста ")
    public void test4() throws InterruptedException {
        login.loginIn(username, password);
        myPosts.clickPost();
        posts.checkMoveToPostPage();

    }

    @Test
    @Story("Лента своих постов")
    @DisplayName("5: Сортировка постов от старых к новым и наоборот")
    public void test5() throws InterruptedException {
        login.loginIn(username, password);
        myPosts.clickOrder();
        myPosts.checkOrderDESC();
        myPosts.clickOrderOn();
        myPosts.checkOrderASC();

    }

    @Test
    @Story("Лента своих постов")
    @DisplayName("6: Переход к странице чужих постов")
    public void test6() throws InterruptedException {
        login.loginIn(username, password);
        myPosts.moveNotMyPostsPage();
        myPosts.checkMoveNotMyPostsPage();
    }
    @Test
    @Story("Лента своих постов")
    @DisplayName("7: Переход к домашней странице")
    public void test7() throws InterruptedException {
        login.loginIn(username, password);
        myPosts.moveNotMyPostsPage();
        myPosts.moveToHomePage();
        myPosts.checkMoveToHomePage();
    }


}
