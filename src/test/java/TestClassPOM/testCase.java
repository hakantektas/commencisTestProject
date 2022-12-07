package TestClassPOM;

import DriverFactory.driverManager;
import PageClassPOM.verifyTestCase1;
import PageClassPOM.verifyTestCase2;
import org.testng.annotations.Test;

import java.io.IOException;

public class testCase extends driverManager {

    verifyTestCase1 verifyTest1;
    verifyTestCase2 verifyTest2;
    @Test(priority=1,description ="test")
    public void verifyTest_1() throws IOException ,InterruptedException{
        verifyTest1 = new verifyTestCase1(driver);
        verifyTest1.verifyTheLatestNews1();
    }
    @Test(priority=2,description ="test")
    public void verifyTest_2() throws IOException ,InterruptedException{
        verifyTest2 = new verifyTestCase2(driver);
        verifyTest2.verifyTheLatestNews2();
    }
}
