package DriverFactory;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;

public class driverManager {


    public static WebDriver driver;
    public static WebDriverWait wait;
    public static int timeout = 30;
    String url= "https://techcrunch.com/";
    String driverPath="/Users/hakantektas/commencisTestProject/drivers/chromedriver";
    String driverPath_2="/Users/hakantektas/commencisTestProject/drivers/geckodriver";
    String driverPath_3="/Users/mobven/IdeaProjects/pageFactoryWithPageObjectModelProject/drivers/operadriver";



    @Parameters("browser")
    @BeforeTest(alwaysRun = true)
    public void setup(@Optional("browser") String browser){

        switch (browser){

            case "chrome":{

                System.setProperty("webdriver.chrome.driver",driverPath);
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("start-maximized");
                driver=new ChromeDriver();
                System.out.println("***** Browser is chrome *****");
                before();
                break;
            }
            case "firefox":{

                System.setProperty("webdriver.gecko.driver",driverPath_2);
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("start-maximized");
                driver=new FirefoxDriver();
                System.out.println("***** Browser is firefox *****");
                before();
                break;
            }
            case "opera":{

                System.setProperty("webdriver.opera.driver",driverPath_3);
                OperaOptions operaOptions = new OperaOptions();
                operaOptions.addArguments("start-maximized");
                driver=new OperaDriver();
                System.out.println("***** Browser is opera *****");
                before();
                break;
            }
            case "safari":{

                SafariOptions safariOptions = new SafariOptions();
                driver=new SafariDriver();
                System.out.println("***** Browser is safari *****");
                before();
                break;
            }
            default:{
                WebDriverManager.chromedriver().setup();
                driver= new ChromeDriver();
                System.out.println("*****browser start Chrome Bonigarcia");
                before();
                break;
            }
        }



    }
    protected void waitForLoad(WebDriver driver) {
        new WebDriverWait(driver, timeout).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
    }

    /* @Parameters("browser")
    @BeforeClass(alwaysRun = true)
    public void beforeTest(@Optional("browser") String browser) {
    setup(browser);
    waitForLoad(driver);
}*/
    public void before(){
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        waitForLoad(driver);
    }
    @AfterTest(alwaysRun = true)
    public void close(){

            driver.quit();

    }
}
