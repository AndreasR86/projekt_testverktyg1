package selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import selenium.settings.testSetup.TestSetup;

import static org.testng.AssertJUnit.assertTrue;

public class AddLapTime extends TestSetup {
    @Test
    public void addLapTime() {

        WebElement addNewLapTime = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[id='addtodo-button'] button")));
        addNewLapTime.click();

        WebElement addLapTime = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#input-laptime")));
        addLapTime.sendKeys(lapTime3);

        WebElement saveLapTime = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#save-button")));
        saveLapTime.click();

        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("body"), lapTime3));
        boolean LapTimeUpdate = driver.getPageSource().contains("Varvtid: 13.1");
        assertTrue(LapTimeUpdate);

    }
}