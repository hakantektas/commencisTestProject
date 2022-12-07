package PageClassPOM;

import MainFunction.mainFunction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class verifyTestCase2 extends mainFunction {

    String url= "https://techcrunch.com/";

    public verifyTestCase2(WebDriver driver){
        this.driver = driver;
    }

    public void verify_2() {


        By element1 = By.xpath("(//*[contains(@class,'post-block__title')])[1]");
        String title_1 = driver.findElement(element1).getAttribute("text")+" | TechCrunch";
        System.out.println("Link Title"+" : "+ title_1);

        driver.findElement(element1).click();
        String title_2 = driver.getTitle();
        System.out.println("Link Detail Title"+" : "+ title_2);
        assertThat(driver.findElement(element1).getAttribute("text")+" | TechCrunch", is(driver.getTitle()));



    /*
        //*[contains(@class,'post-block__footer')]
        for (int i =1 ; i<elements.size(); i++)
        {


            driver.findElements(By.xpath("(//*[contains(@class,'river-byline__authors')])[i]")).get(i-1).click();
            elements.get(i).click();
            System.out.println(i +":" +"element clicked\t---");
            System.out.printf("pass");
            driver.navigate().back();
        }
    */
    }
    public void verify_4() {


        //Get list of web-elements with tagName  - a
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));

        //Traversing through the list and printing its text along with link address
        for (WebElement link : allLinks) {
            System.out.println(link.getText() + " - " + link.getAttribute("a"));
        }

    }
    public void verifyTheLatestNews2() throws  IOException,InterruptedException{

        this.verify_2();
        this.verify_4();
    }
}

