package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.DreamSummaryPage;

import java.time.Duration;
import java.util.List;

import static org.testng.Assert.*;

public class DreamSummaryTest {

    WebDriver driver;
    DreamSummaryPage summaryPage;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://arjitnigam.github.io/myDreams/dreams-total.html");
        summaryPage = new DreamSummaryPage(driver);
    }

    @Test
    public void validateDreamCounts() {
        assertEquals(summaryPage.getGoodDreams(), 6, "Good dreams count mismatch");
        assertEquals(summaryPage.getBadDreams(), 4, "Bad dreams count mismatch");
        assertEquals(summaryPage.getTotalDreams(), 10, "Total dreams count mismatch");
        assertEquals(summaryPage.getRecurringDreams(), 2, "Recurring dreams count mismatch");
    }

    @Test
    public void validateRecurringDreamNames() {
        List<String> recurringNames = summaryPage.getRecurringDreamNames();
        assertTrue(recurringNames.contains("Flying over mountains"), "Missing 'Flying over mountains'");
        assertTrue(recurringNames.contains("Lost in maze"), "Missing 'Lost in maze'");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
