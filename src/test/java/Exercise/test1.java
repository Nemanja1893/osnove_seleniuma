package Exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.Key;

public class test1 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://cms.demo.katalon.com/");
        driver.findElement(By.linkText("Hello world!")).click();
        Thread.sleep(1000);

        driver.navigate().back();
        driver.findElement(By.partialLinkText("April")).click();
        Thread.sleep(3000);

        driver.navigate().back();
        driver.findElement(By.cssSelector(".search-field")).sendKeys("Ninja");
        driver.findElement(By.cssSelector(".search-field")).sendKeys(Keys.ENTER);
        Thread.sleep(3000);



        driver.quit();
    }
}
