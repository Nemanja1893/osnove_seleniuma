package p26_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak6 {
    public static void main(String[] args) throws InterruptedException {

//        Ucitati stranicu https://cms.demo.katalon.com/
//        Maksimizovati prozor
//        Proveriri da li je je crno MENU dugme vidljivo (Ispisati poruke u konzoli)
//        Prostavite duzinu prozora na 700px i visinu na 700px
//        Proverite da li je crno MENU dugme vidljivo (Ispisati poruke u konzoli)

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://cms.demo.katalon.com/");

        WebElement menuButton = driver.findElement(By.xpath("//button[@class = 'menu-toggle']"));

        if(menuButton.isDisplayed()){
            System.out.println("Vidljivo dugme");
        }else{
            System.out.println("Nije vidljivo dugme");
        }

        driver.manage().window().setSize(new Dimension(700, 700));

        Thread.sleep(1000);

        if(menuButton.isDisplayed()){
            System.out.println("Vidljivo dugme");
        }else{
            System.out.println("Nije vidljivo dugme");
        }

        driver.quit();
    }
}
