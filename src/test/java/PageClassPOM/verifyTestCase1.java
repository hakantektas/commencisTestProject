package PageClassPOM;

import MainFunction.mainFunction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;

public class verifyTestCase1 extends mainFunction {

    String url= "https://techcrunch.com/";

    public verifyTestCase1(WebDriver driver){
        this.driver = driver;
    }
    public void home(){
        System.out.println("Title Bilgisi"+":"+driver.getTitle());
    }
    public void verify_1() throws  IOException ,InterruptedException{

        List<WebElement> elements = driver.findElements(By.xpath("(//*[starts-with(@class,'post-block post-block')])"));

        String size_1 = String.valueOf(elements.size());
        int pars = Integer.parseInt(size_1);
        System.out.println("SİZE ...."+":"+pars);
        for (int i =1 ; i<pars; i++)
        {
            Thread.sleep(5000);
            By element1 = By.xpath("(//*[starts-with(@class,'post-block post-block')])"+"["+i+"]");
            driver.findElement(element1).click();
            System.out.println(i +":" +"element clicked\t---" + elements.get(i).getAttribute("outerText"));
            By element2 = By.xpath("(//*[starts-with(@aria-label,'Posts by')])"+"["+i+"]");
            System.out.println("Post By "+" : "+driver.findElement(element2).getAttribute("textContent"));

            // WebElement elem = driver.findElement(By.xpath("(//*[starts-with(@class,'article__featured-image')])"+"["+i+"]"));
            // Javascript executor to check image
            // Boolean p = (Boolean) ((JavascriptExecutor)driver) .executeScript("return arguments[0].complete " + "&& typeof arguments[0].naturalWidth != \"undefined\" " + "&& arguments[0].naturalWidth > 0", elem);
            // Boolean r = driver.findElement(By.xpath("(//*[starts-with(@class,'article__featured-image')])"+"["+i+"]")).isDisplayed();

            //verify if status is true
            if (driver.findElement(By.xpath("(//*[starts-with(@class,'article__featured-image')])[1]")).isDisplayed()) {
                System.out.println("Logo present");
            } else {
                System.out.println("Logo not present");
            }
            Thread.sleep(5000);
            driver.navigate().back();
            Thread.sleep(5000);
           /* driver.findElement(element1).click();
            Thread.sleep(2000);
            */


/*
            WebElement elem = driver.findElement
                    (By.xpath("(//*[starts-with(@class,'article__featured-image')])" +"["+i+"]"));
            // Javascript executor to check image
            Boolean p = (Boolean) ((JavascriptExecutor)driver) .executeScript("return arguments[0].complete " + "&& typeof arguments[0].naturalWidth != \"undefined\" " + "&& arguments[0].naturalWidth > 0", elem);
            Thread.sleep(4000);
            //verify if status is true
            if (p) {
                System.out.println("Logo present");
            } else {
                System.out.println("Logo not present");
            }
*/

            //Thread.sleep(4000);
        }
    }
    public void verifyTheLatestNews1() throws  IOException,InterruptedException{

        this.home();
        this.verify_1();
        /*this.verify_2();
        this.verify_3();
        this.verify_4();*/
    }
}
