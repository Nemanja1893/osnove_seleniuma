package p24_01_2023;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Zadatak3 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        ArrayList<String> links = new ArrayList<>();
        links.add("https://google.com/");
        links.add("https://youtube.com/");
        links.add("https://www.ebay.com/");
        links.add("https://www.kupujemprodajem.com/");

        for (int i = 0; i < links.size(); i++) {
            driver.get(links.get(i));
            System.out.println(driver.getTitle());
        }

        driver.quit();

    }
}
