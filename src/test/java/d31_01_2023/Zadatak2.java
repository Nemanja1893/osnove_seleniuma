package d31_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak2 {
    public static void main(String[] args) {
//        Napisati program koji:
//        Ucitava stranu https://itbootcamp.rs/
//        Misem prelazi preko Vesti iz navigacionog menija
//        Ceka da se prikaze padajuci meni za Vesti
//        Misem prelazi preko Kursevi iz navigacionog menija
//        Ceka da se prikaze padajuci meni za Kursevi
//        Misem prelazi preko Prijava i pravilnik iz navigacionog menija
//        Ceka da se prikaze padajuci meni za Prijava i pravilnik

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        driver.manage().window().maximize();
        driver.get("https://itbootcamp.rs/");

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.id("menu-item-6408"))).perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By
                .xpath("//*[@id='menu-item-6408']/ul")));

        actions.moveToElement(driver.findElement(By.id("menu-item-5362"))).perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By
                .xpath("//*[@id='menu-item-5362']/ul")));

        actions.moveToElement(driver.findElement(By.id("menu-item-5453"))).perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By
                .xpath("//*[@id='menu-item-5453']/ul")));


        driver.quit();

    }
}
