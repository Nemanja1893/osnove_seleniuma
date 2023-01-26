package p26_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Zadatak5 {
    public static void main(String[] args) throws InterruptedException {
//        Napisati program koji ucitava stranicu https://www.ebay.com/ i bira kategoriju “Crafts”


        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.ebay.com/");



        Select dropDown = new Select(driver.findElement(By.xpath("//select[@id = 'gh-cat']")));
        dropDown.selectByVisibleText("Crafts");



        Thread.sleep(5000);
        driver.quit();
    }
}
