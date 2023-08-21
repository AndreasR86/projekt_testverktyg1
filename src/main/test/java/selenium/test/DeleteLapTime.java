package selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import selenium.settings.testSetup.TestSetup;

import static org.testng.AssertJUnit.assertTrue;

public class DeleteLapTime extends TestSetup {

    @Test
    public void deleteLapTime() {

        WebElement addNewLapTime = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[id='addtodo-button'] button")));
        addNewLapTime.click();

        WebElement addLapTime = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#input-laptime")));
        addLapTime.sendKeys(lapTime1);

        WebElement saveLapTime = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#save-button")));
        saveLapTime.click();

        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("body"), lapTime1));
        boolean LapTimeUpdate = driver.getPageSource().contains("Varvtid: 11.1");
        assertTrue(LapTimeUpdate);

        WebElement deleteLapTime = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[data-id='1']")));
        deleteLapTime.click();

    }
}

