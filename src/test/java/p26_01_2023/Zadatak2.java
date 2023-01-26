package p26_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {

//        Napisti program koji:
//        Ucitava stranicu https://s.bootsnipp.com/iframe/z80en
//        Hvata sve elemente prve kolone i stampa tekst svakog elementa. Kako da od nekog elementa procitamo tekst imate na sledecem linku
//        Ceka 1s
//        Hvata sve elemente prvog reda i stampa tekst svakog elementa
//        Ceka 5s
//        Zatvara pretrazivac
//        Stampa treba da bude kao u primeru:
//        John
//        Mary
//        July


        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://s.bootsnipp.com/iframe/z80en");

        WebElement table = driver.findElement(By.xpath("//div[@id='lorem']/table"));

        List<WebElement> names = table
                .findElements(By.xpath("//tbody/tr/td[1]"));

        for (int i = 0; i < names.size(); i++) {


            System.out.println(names.get(i).getText());
            Thread.sleep(1000);
        }

        List<WebElement> row = table.findElements(By.xpath("//tbody/tr[1]/td"));

        for (int i = 0; i < row.size(); i++) {
            System.out.println(row.get(i).getText() + "\t");
        }
        
        Thread.sleep(5000);

        driver.quit();
    }
}
