package p26_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import sun.awt.windows.ThemeReader;

import java.util.List;

public class Zadatak7 {
    public static void main(String[] args) throws InterruptedException {

//        Ucitati stranicu https://netoglasi.rs/
//        Ispisati sve nazive kategorija iz leve navigacije
//        Validirati da je kategorija Automobili na prvom mestu
//        Klik na kategoriju Automobili
//        Validarati da je kategorija Automobili na prvom mestu

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://netoglasi.rs/");

        Thread.sleep(1000);

//        Actions act = new Actions(driver);
//        act.sendKeys(Keys.PAGE_DOWN).build().perform();

//        new Actions(driver)
//                .scrollByAmount(0, 1000)
//                .perform();

//        for (int i = 0; i < 3; i++) {
//            driver.findElement(By.xpath("/html")).sendKeys(Keys.chord(Keys.CONTROL,Keys.SUBTRACT));
//        }


        List<WebElement> lista = driver
                .findElements(By.xpath("//ion-list[@class='category-list category-list-dark" +
                        " md list-md hydrated']/app-category-picker-item/ion-item/a"));

        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i).getText());
            Thread.sleep(500);
        }

        driver.quit();
    }
}
