package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class DreamSummaryPage {

    WebDriver driver;
    WebDriverWait wait;

    By goodCount = By.id("good-count");
    By badCount = By.id("bad-count");
    By totalCount = By.id("total-count");
    By recurringCount = By.id("recurring-count");
    By recurringRows = By.cssSelector("#recurring-dreams li");

    public DreamSummaryPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait until summary numbers are visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(goodCount));
    }

    public int getGoodDreams() {
        return Integer.parseInt(driver.findElement(goodCount).getText());
    }

    public int getBadDreams() {
        return Integer.parseInt(driver.findElement(badCount).getText());
    }

    public int getTotalDreams() {
        return Integer.parseInt(driver.findElement(totalCount).getText());
    }

    public int getRecurringDreams() {
        return Integer.parseInt(driver.findElement(recurringCount).getText());
    }

    public List<String> getRecurringDreamNames() {
        List<WebElement> rows = driver.findElements(recurringRows);
        List<String> names = new ArrayList<>();
        for (WebElement row : rows) {
            names.add(row.getText());
        }
        return names;
    }
}
