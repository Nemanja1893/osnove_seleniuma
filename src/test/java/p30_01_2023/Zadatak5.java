package p30_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Zadatak5 {
    public static void main(String[] args) throws InterruptedException {
//        Napisati program koji:
//        Ucitava stranicu https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example
//        Vrsi klik na Primary dugme, Secondary, Sucess, Danger
//        Ceka da broj toasts-a bude 4
//        Ispisuje poruku, toasts su prikazani
//        Ceka da broj toasts-a bude 0
//        Ispisuje poruku, toasts su se izgubili

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        driver.manage().window().maximize();
        driver.get("https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.findElement(By.id("basic-primary-trigger")).click();
        driver.findElement(By.id("basic-secondary-trigger")).click();
        driver.findElement(By.id("basic-success-trigger")).click();
        driver.findElement(By.id("basic-danger-trigger")).click();

        System.out.println("Toasts appeared");
        wait.until(ExpectedConditions.numberOfElementsToBe(By
                .xpath("//div[contains(@class,'toast fade')][contains(@class, 'show')]")
                , 4));



        Thread.sleep(2000);


        driver.quit();

    }
}
