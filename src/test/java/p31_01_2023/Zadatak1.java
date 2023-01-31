package p31_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {
//        Napisati program koji:
//        Krairajte folder za fajlove u okviru projekta pod nazivom test_data
//        U folder skinite i postavite proizvoljnu sliku
//        Ucitava stranu https://tus.io/demo.html
//        Skrola do dela za upload fajla
//        Aploadujte sliku
//        Cekajte da se pojava dugme za download fajla


        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));

        driver.manage().window().maximize();
        driver.get("https://tus.io/demo.html");

        Actions actions = new Actions(driver);
        actions.scrollToElement(driver.findElement(By.xpath("//input[@type='file']"))).perform();

        driver.findElement(By.xpath("//input[@type='file']"))
                .sendKeys(new File("test_data/download.jfif").getAbsolutePath());

        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                .xpath("//*[@id='js-upload-container']//a")));

        Thread.sleep(5000);

        driver.quit();
    }
}
