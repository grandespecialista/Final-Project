package pages;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Posts extends AbstractPage {
    public Posts(WebDriver driver) {super(driver);
    }
        @FindBy(xpath = "//div[contains(@class,\"button-block\")]")
        private WebElement buttonsBlock;

    @Step("Проверка перехода к посту")
    public Posts checkMoveToPostPage() throws InterruptedException {
        ExpectedConditions.elementToBeClickable(buttonsBlock);
        Assertions.assertTrue(buttonsBlock.isEnabled());
        return this;
    }

}
