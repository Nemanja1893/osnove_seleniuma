package p31_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class Zadatak5 {
    public static void main(String[] args) throws IOException {
//        Napisati program koji:
//        Ucitava stranicu https://cms.demo.katalon.com/
//        Hvata  sve href atribute svih linkova iz navigacije
//        Za svaki link proverava status da je veci ili jednak od 200 i manji od 400
//        Koristan link za citanje status koda nekog url-a

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));

        driver.manage().window().maximize();
        driver.get("https://cms.demo.katalon.com/");

        List<WebElement> links = driver.findElements(By.xpath("//a[@href]"));

        for (int i = 0; i < links.size(); i++) {
            URL url = new URL(links.get(i).getAttribute("href"));
            HttpURLConnection http = (HttpURLConnection)url.openConnection();

            if(http.getResponseCode() >= 200 && http.getResponseCode() < 400){
                System.out.println(links.get(i).getAttribute("href")+ ": status je izmedju 200 i 400");
            }else{
                System.out.println(links.get(i).getAttribute("href")+ ": nema status je izmedju 200 i 400");
            }
        }

        driver.quit();

    }
}
