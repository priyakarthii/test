package Tests;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;

public class Phptravels extends MainChrome {
    @Test

    public void test1() throws IOException {

        //load url
        chromeDriver.get("https://phptravels.com/demo/");

        //locate send path all the fields and send keys
        WebElement firstName = chromeDriver.findElement(By.xpath("//input[@name='first_name']"));
        WebElement lastName = chromeDriver.findElement(By.xpath("//input[@name='last_name']"));
        WebElement business = chromeDriver.findElement(By.xpath("//input[@name='business_name']"));
        WebElement email = chromeDriver.findElement(By.xpath("//input[@name='email']"));
        firstName.sendKeys("vishnu");
        lastName.sendKeys("priya");
        business.sendKeys("vishnu priya Enterprises");
        email.sendKeys("test@gmail.com");

        //handle the capcha
        WebElement number1 =chromeDriver.findElement(By.xpath("//span[@id='numb1']"));
        WebElement number2 =chromeDriver.findElement(By.xpath("//span[@id='numb2']"));
        int num1 = Integer.parseInt(number1.getText());
        int num2 = Integer.parseInt(number2.getText());
        int sum = num1 + num2;

        WebElement input = chromeDriver.findElement(By.xpath("//input[@id='number']"));
        input.sendKeys(String.valueOf(sum));

        // locate submit xpath
        WebElement submit = chromeDriver.findElement(By.xpath("//button[@id='demo']"));
        submit.click();

        //verify the page submission
        WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(15));
        WebElement success = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[contains(text(),'Thank you!')]")));
        if(success.getText().equals("Thank you!")) {
            System.out.println("Form successfully submitted");
        }
        else {
            System.out.println("Form is not submitted");
        }

        // Take a screenshot of the page after submission
        TakesScreenshot screenshot = (TakesScreenshot) chromeDriver;
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File("screenshot.png");
        Files.copy(srcFile.toPath(), destFile.toPath());


    }


}
