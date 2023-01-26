package p26_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak4 {
    public static void main(String[] args) throws InterruptedException {
//        Napisati program koji ucitava stranicu http://cms.demo.katalon.com/my-account/, cekira Remember me checkbox.
//        Na kraju programa proverite da li je element cekiran.
//        Izguglajte kako mozemo da proverimo da li je element cekiran.

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("http://cms.demo.katalon.com/my-account/");

        WebElement checkbox =  driver.findElement(By.xpath("//input[@id = 'rememberme']"));
        checkbox.click();
        Thread.sleep(1000);

        if(checkbox.isSelected()){
            System.out.println("Checkbox selected");
        }else {
            System.out.println("Checkbox not selected");
        }

        driver.quit();
    }
}
