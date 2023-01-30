package p30_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak4 {
    public static void main(String[] args) {
//        Napisati program koji:
//        Ucitava stranicu https://mdbootstrap.com/docs/standard/components/toasts/
//        Vrsi klik na Basic example link iz desne navigacije
//        Ceka da url sadrzi #section-basic-example

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.manage().window().maximize();
        driver.get("https://mdbootstrap.com/docs/standard/components/toasts/");

        driver.findElement(By.xpath("//*[@id = 'scrollspy']//ul/li[2]/a")).click();
        wait.until(ExpectedConditions.attributeContains(By.xpath("//*[@id = 'scrollspy']//ul/li[2]/a"),
                                                  "href", "#section-basic-example"));







        driver.quit();

    }
}
