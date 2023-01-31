package d30_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {

//        Napisati program koji testira infinity scroll.
//        Ucitati stranu https://web.dev/patterns/web-vitals-patterns/infinite-scroll/infinite-scroll/demo.html
//        Selektujte delay od 2000ms, koristeci Select klasu.
//        Skrol do Show more dugmeta koje se nalazi na dnu stranice
//        Sacekajte da dugme bude klikljivo
//        Klik na Show more dugme
//        Sacekjate da broj elemenata bude X (X je koliko se kod vas ucitava)
//        Sacekajte da dugme vise ne bude klikljivo

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        driver.manage().window().maximize();
        driver.get("https://web.dev/patterns/web-vitals-patterns/infinite-scroll/infinite-scroll/demo.html");

        driver.findElement(By.id("delay-select")).click();
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                        .xpath("//*[@value = '2000']"))).click();

        Actions actions = new Actions(driver);


        for (int i = 0; i < 5; i++) {
            //Mora da skroluje gore dole, inace nikad dugme ne postane klikljivo

            actions.scrollToElement(driver
                            .findElement(By.className("footer")))
                    .perform();
            actions.scrollByAmount(0,-400).perform();
            wait.until(ExpectedConditions.elementToBeClickable(By.tagName("button")));
            actions.scrollToElement(driver
                            .findElement(By.className("footer")))
                    .perform();
            //---------------------------------------------------------------------

            driver.findElement(By.tagName("button")).click();

            wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By
                    .xpath("//div[contains(@style,'background')]"),i+2));
            actions.scrollToElement(driver
                            .findElement(By.className("footer")))
                    .perform();

            wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(By.tagName("button"))));
        }

        driver.quit();
    }
}
