package p30_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak1 {
    public static void main(String[] args) {
//        Napisati program koji ucitava stranicu https://s.bootsnipp.com/iframe/klDWV
//        i ceka da se ucita progress bar na 100% a zatim ispisuje tekst u konzoli “Stranica ucitana”

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        driver.manage().window().maximize();
        driver.get("https://s.bootsnipp.com/iframe/klDWV");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        wait.until(ExpectedConditions.attributeContains(By.className("preloader-wrap"),"style", "none"));

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("percentage")));

        driver.quit();
    }
}
