package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    WebDriver driver;
    WebDriverWait wait;

    By header = By.tagName("h1");
    By diaryLink = By.cssSelector("a[href='dreams.html']");
    By summaryLink = By.cssSelector("a[href='dreams-total.html']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(header));
    }

    public boolean isMainContentVisible() {
        return driver.findElement(header).isDisplayed();
    }

    public void openDreamDiary() {
        driver.findElement(diaryLink).click();
    }

    public void openDreamSummary() {
        driver.findElement(summaryLink).click();
    }
}
