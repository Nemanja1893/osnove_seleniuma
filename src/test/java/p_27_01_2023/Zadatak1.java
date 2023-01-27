package p_27_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Zadatak1 {
    public static void main(String[] args) {
//        Ucitati stranicu https://demoqa.com/modal-dialogs
//        Kliknuti na dugme Large modal
//        Proverite da li se prikazao dijalog i ispisite u konzoli odgovarajuce poruke

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.manage().window().maximize();
        driver.get("https://demoqa.com/modal-dialogs");

        driver.findElement(By.xpath("//*[@id='showLargeModal']")).click();

        Helper helper = new Helper();
        if(helper.elementExist(driver, By.xpath("//*[@class='modal-content']"))){
            System.out.println("Postoji");
        }else {
            System.out.println("Ne postoji");
        }

        driver.quit();







    }
}
