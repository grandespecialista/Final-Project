package pages;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MyPosts extends AbstractPage {

    public MyPosts(WebDriver driver) {super(driver);
    }
    @FindBy(xpath = "//span[@class='svelte-1rc85o5']")
    private WebElement homeHeader;

    @FindBy(xpath = "//ul[@class='svelte-1rc85o5'")
    private WebElement blockInHerders;

    @FindBy(xpath = "//button[@id='SMUI-form-field-1']")
    private WebElement switchButtonNotMyPosts;

    @FindBy(xpath = " //button[@id='SMUI-form-field-1'and @aria-checked='true']")
    private WebElement switchButtonNotMyPostsON;

    @FindBy(xpath = "//div[@class='mdc-form-field']//button[@aria-pressed='true']")
    private WebElement buttonOrderOn;

    @FindBy(xpath = "//div[@class='mdc-form-field']//span[text ()= 'Order']/parent::label/preceding-sibling::button")
    private WebElement buttonOrderOff;

    @FindBy(xpath = "//a[@href and text() = 'Next Page']")
    private WebElement NextPage;

    @FindBy(xpath = "//a[@href and text() = 'Previous Page']")
    private WebElement PreviousPage;

    @FindBy(xpath = "//div[@class = 'content']/div[1]]")
    private WebElement listOfPosts;

    @FindBy(xpath = "//div[@class = 'content']/div/a[1]/img")
    private WebElement img;

    @FindBy(xpath = "//div[@class = 'content']/div/a[1]/h2")
    private WebElement title;

    @FindBy(xpath = "//div[@class = 'content']/div/a[1]/div")
    private WebElement description;

    @FindBy(xpath = "//div[@class = 'content']/div/a[1]/div")
    private WebElement disabledPreviousPage;

    @FindBy(xpath = "//div[@class = 'content']/div/a[1]")
    private WebElement firstPost;

    @Step("Проверка, по URL, местоположения пользователя после авторизации")
    public void checkChangeUrl() throws InterruptedException {
        ExpectedConditions.visibilityOf(homeHeader);
        ExpectedConditions.visibilityOf(blockInHerders);
        Assertions.assertFalse(driver.getCurrentUrl().contains("login"));
    }

    @Step("Проверка, по элементу на странице, отображение превью постов")
    public void checkPosts(){
        Assertions.assertTrue(img.isEnabled());
        Assertions.assertTrue(title.isEnabled());
        Assertions.assertTrue(description.isEnabled());
    }
    @Step("Переход на следущую страницу")
    public MyPosts toNextPage() {
        NextPage.click();
        return this;
    }
    @Step("Проверка перехода на следующую страницу по активности кнопки Previous Page")
    public void checkToNextPage() throws InterruptedException {
        Thread.sleep(2000);
        ExpectedConditions.elementToBeClickable(PreviousPage);
        Assertions.assertTrue(PreviousPage.isEnabled());
    }
    @Step("Возврат на предыдущую страницу")
    public MyPosts moveToPreviousPage() throws InterruptedException {
        NextPage.click();
        Thread.sleep(2000);
        ExpectedConditions.elementToBeClickable(PreviousPage);
        PreviousPage.click();
        return this;}

    @Step("Проверка перехода на следующую страницу по деактивации кнопки Previous Page")
    public MyPosts checkMoveToPreviousPage() {
       Assertions.assertTrue(disabledPreviousPage.isEnabled());
        return this;}

    @Step("Открываем пост с картинкой")
    public Posts clickPost() throws InterruptedException {
        ExpectedConditions.visibilityOf(img);
        firstPost.click();
        return new Posts(driver);}

    @Step("Включаем сортировку постов от старых к новым")
    public MyPosts clickOrder() throws InterruptedException {
        ExpectedConditions.visibilityOf(buttonOrderOff);
        buttonOrderOff.click();
        return this;}

    @Step("Проверка сортировки постов от старых к новым")
    public MyPosts checkOrderDESC() throws InterruptedException {
        ExpectedConditions.visibilityOf(buttonOrderOn);
        Assertions.assertTrue(Boolean.parseBoolean(String.valueOf(buttonOrderOff.getAttribute("aria-pressed").equals("true"))));
        return this;}

    @Step("Включаем сортировку постов от новых к старым")
    public MyPosts clickOrderOn() throws InterruptedException {
        ExpectedConditions.visibilityOf(buttonOrderOn);
        buttonOrderOn.click();
        return this;}

    @Step("роверка сортировки постов от новых к старым")
    public MyPosts checkOrderASC() throws InterruptedException {
        ExpectedConditions.visibilityOf(buttonOrderOff);
        Assertions.assertTrue(Boolean.parseBoolean(String.valueOf(buttonOrderOff.getAttribute("aria-pressed").equals("false"))));
        return this;}

    @Step("Переход к чужим постам")
    public MyPosts moveNotMyPostsPage() throws InterruptedException {
        ExpectedConditions.visibilityOf(switchButtonNotMyPosts);
        switchButtonNotMyPosts.click();
        return this;}

    @Step("Проверка перехода к чужим постам")
    public MyPosts checkMoveNotMyPostsPage() throws InterruptedException {
        ExpectedConditions.visibilityOf(switchButtonNotMyPostsON);
        Assertions.assertTrue(Boolean.parseBoolean(String.valueOf(switchButtonNotMyPosts.getAttribute("aria-checked").equals("true"))));
        return this;}

    @Step("Возврат к своим постам через кнопку Home")
    public MyPosts moveToHomePage() throws InterruptedException {
        ExpectedConditions.visibilityOf(homeHeader);
        homeHeader.click();
        Assertions.assertTrue(Boolean.parseBoolean(String.valueOf(switchButtonNotMyPosts.getAttribute("aria-checked").equals("true"))));
        return this;}

    @Step("Проверка перехода на страницу со своими постами")
    public MyPosts checkMoveToHomePage() throws InterruptedException {
        ExpectedConditions.visibilityOf(switchButtonNotMyPosts);
        Assertions.assertTrue(switchButtonNotMyPostsON.isEnabled());
        return this;}
}

