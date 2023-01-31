package p31_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.time.Duration;

public class Zadatak3 {
    public static void main(String[] args) {
//        Napisati program koji
//        Kreirati folder downloads folder u projektu
//        Ucitava stranu https://cms.demo.katalon.com/product/flying-ninja/
//        Cita href atribut sa glavne slike sa stranice
//        Koristi link iz href atributa za skidanje slike
//        Sliku sacuvajte u folderu downloads pod nazivom flying-ninja.jpg
//        Koristan link za skidanje fajlova u javi
//        Azurirajte gitignore da ignorise downloads folder

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));

        driver.manage().window().maximize();
        driver.get("https://cms.demo.katalon.com/product/flying-ninja/");

        String url = driver.findElement(By.xpath("//*[@class='flex-viewport']//a"))
                                        .getAttribute("href");

        String saveLoc = new File("downloads/flying-ninja.jpg").getAbsolutePath();

        try {
            downloadUsingNIO(url, saveLoc);

        } catch (IOException e) {
            e.printStackTrace();
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
