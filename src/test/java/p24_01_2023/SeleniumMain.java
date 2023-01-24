package p24_01_2023;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumMain {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://cms.demo.katalon.com/");
//        driver.get("https://google.com");
//        driver.navigate().back();
//        driver.navigate().forward();

        driver.quit();
    }
}
