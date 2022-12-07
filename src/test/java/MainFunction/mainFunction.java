package MainFunction;

import DriverFactory.driverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class mainFunction extends driverManager {

    String folderName;
    DateFormat df;

    /*
        Test project written without using Page factory and Page Object Model...
         */
    public mainFunction() {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void captureScreenShots() throws IOException {

        folderName = "screenshot";
        File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        df = new SimpleDateFormat("dd-MM-yyyy__hh_mm_ssaa");

        new File(folderName).mkdir();

        String file_name = df.format(new Date()) + ".png";
        FileUtils.copyFile(f, new File(folderName + "/" + file_name));
    }

    /**
     * The constructor.
     */
    public void waitCondition() {
        wait = new WebDriverWait(driverManager.driver, timeout);
    }

    /**
     * Wait for visibility of element located by web element.
     *
     * @param locator the locator.
     * @return the web element.
     */
    public WebElement waitForVisibilityOfElementLocatedBy(final By locator) {
        wait = new WebDriverWait(driverManager.driver, timeout);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}