package p30_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.time.Duration;
import java.util.List;
public class Zadatak6 {
    public static void main(String[] args) throws InterruptedException {

//        Napisati program koji:
//        Ucitava stranicu https://tus.io/demo.html
//        Hvata sve linkove sa stranice
//        Skrola do svakog linka
//        Od svakog linka cita href atribut i stampa ga na ekranu

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        driver.manage().window().maximize();
        driver.get("https://tus.io/demo.html");

        List<WebElement> h3s = driver.findElements(By.tagName("h3"));

        Actions actions = new Actions(driver);

        for (int i = 0; i < h3s.size(); i++) {
            actions.scrollToElement(h3s.get(i)).perform();
            System.out.println(h3s.get(i).getText());
            Thread.sleep(1000);
        }
        driver.quit();
    }
}
