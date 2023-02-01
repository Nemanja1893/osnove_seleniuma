package d31_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.time.Duration;
import java.util.List;

public class Zadatak3 {
    public static void main(String[] args) throws IOException {
//        Napisati program koji:
//        Ucitava stranicu https://itbootcamp.rs/
//        Skrola do slajdera na dnu stranice (u kome su slike Java, Php, Selenium, …)
//        Cita sve linkove slika iz slajdera
//        Proverava url svake slike, i za sve slike koje imaju status veci i jednak od 200 a manji od 300, skida i smesta u folder itbootcamp_slider u okviru projekta
//        Azurirajte gitignore da ignorise itbootcamp_slider folder

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));

        driver.manage().window().maximize();
        driver.get("https://itbootcamp.rs/");

        WebElement div = driver.findElement(By.xpath("//div[contains(@class,'slider_bkgd')]"));
        Actions actions = new Actions(driver);
        actions.scrollToElement(div).perform();

        List<WebElement> pics = div.findElements(By.xpath("//div[@class='owl-stage']/div//img"));

        for (int i = 0; i < pics.size(); i++) {
            URL url = new URL(pics.get(i).getAttribute("src"));
            HttpURLConnection http = (HttpURLConnection)url.openConnection();

            String link = pics.get(i).getAttribute("src");
            String saveLoc = new File("itbootcamp_slider/pic"+ i +".jpg").getAbsolutePath();

            if(http.getResponseCode()>= 200 && http.getResponseCode() < 300){
                try {
                    downloadUsingNIO(link, saveLoc);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        driver.quit();
    }
    private static void downloadUsingNIO(String urlStr, String file) throws IOException {
        URL url = new URL(urlStr);
        ReadableByteChannel rbc = Channels.newChannel(url.openStream());
        FileOutputStream fos = new FileOutputStream(file);
        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        fos.close();
        rbc.close();
    }
}
