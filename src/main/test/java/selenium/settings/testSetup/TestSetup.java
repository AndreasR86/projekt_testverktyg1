package selenium.settings.testSetup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import selenium.settings.drivers.ChromeDriverManager;

import java.time.Duration;

public class TestSetup {

    protected String localHost = "http://localhost:8080/laptimes";
    protected String lapTime1 = "11.1";
    protected String lapTime2 = "12.1";
    protected String lapTime3 = "13.1";
    protected String lapTime4 = "14.1";
    protected String lapTime5 = "15.1";


    protected WebDriver driver;
    protected WebDriverWait wait;
    protected WebDriverWait getWait() {
        return wait;
    }


    @BeforeClass(alwaysRun = true)
    public void setupClass() {
    }

    @BeforeMethod
    public void initDriver() {
        driver = ChromeDriverManager.createDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofMillis(2000));
        driver.get(localHost);

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }


    @Test
    public void addLapTime() {

        WebElement addNewLapTime = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[id='addtodo-button'] button")));
        addNewLapTime.click();

    }

}