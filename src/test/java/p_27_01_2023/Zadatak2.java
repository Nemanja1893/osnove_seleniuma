package p_27_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {
//        Napisati program koji ucitava stranicu p31_01_2023.Zadatak4.html
//        Skinite p31_01_2023.Zadatak4.html sa drajva. Otvorite u pretrazivacu duplim klikom na fajl i Downloads-a
//        i ikopirajte url. To je url za get u programu
//        I na stranici dodaje 5 poruka “IT Bootcamp”
//        Potrebno  je u svakoj iteraciji kliknuti na dugme Show in
//        Sacekati da se novi element pojavi pre nego sto se doda sledeci



        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.manage().window().maximize();
        driver.get("file:///C:/Users/Sejn/Downloads/p31_01_2023.Zadatak4.html");


        for (int i = 0; i < 5; i++) {
            driver.findElement(By.tagName("button")).click();
            driver.findElement(By.id("id-"+i));
        }

        Thread.sleep(5000);
        driver.quit();

    }
}
