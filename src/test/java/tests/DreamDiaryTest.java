package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.DreamDiaryPage;

import java.time.Duration;
import java.util.List;

import static org.testng.Assert.*;

public class DreamDiaryTest {

    WebDriver driver;
    DreamDiaryPage diaryPage;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://arjitnigam.github.io/myDreams/dreams.html");
        diaryPage = new DreamDiaryPage(driver);
    }

    @Test
    public void validateRowsCount() {
        assertEquals(diaryPage.getRowsCount(), 10, "Rows mismatch — Expected 10 dreams in diary");
    }

    @Test
    public void validateDreamsData() {
        List<String> names = diaryPage.getAllDreamNames();
        assertTrue(names.contains("Flying over mountains"), "Missing dream: Flying over mountains");
        assertTrue(names.contains("Lost in maze"), "Missing dream: Lost in maze");
    }

    @Test
    public void validateDreamsCategories() {
        assertEquals(diaryPage.getGoodDreamsCount(), 6, "Good dreams mismatch");
        assertEquals(diaryPage.getBadDreamsCount(), 4, "Bad dreams mismatch");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
