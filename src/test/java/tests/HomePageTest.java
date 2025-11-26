package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.HomePage;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class HomePageTest {

    WebDriver driver;
    HomePage homePage;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://arjitnigam.github.io/myDreams/");
        homePage = new HomePage(driver);
    }

    @Test
    public void testHomePageContent() {
        assertTrue(homePage.isMainContentVisible(), "Main content is not visible");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
