package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class DreamDiaryPage {

    WebDriver driver;
    WebDriverWait wait;

    By dreamRows = By.cssSelector("table tbody tr");

    public DreamDiaryPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait until rows are visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(dreamRows));
    }

    // Return count of rows
    public int getRowsCount() {
        return driver.findElements(dreamRows).size();
    }

    // Return list of all dream names
    public List<String> getAllDreamNames() {
        List<WebElement> rows = driver.findElements(dreamRows);
        List<String> names = new ArrayList<>();
        for (WebElement row : rows) {
            names.add(row.getText());
        }
        return names;
    }

    // Validate good and bad dreams
    public int getGoodDreamsCount() {
        return driver.findElements(By.cssSelector("tr.good")).size();
    }

    public int getBadDreamsCount() {
        return driver.findElements(By.cssSelector("tr.bad")).size();
    }
}
