package p31_01_2023;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

public class Zadatak4 {
    public static void main(String[] args) throws IOException {
//        Napisati program koji:
//        Kreirati screenshots folder u projektu
//        Ucitava stranicu https://cms.demo.katalon.com/
//        Kreira screenshot stranice
//        Sacuvati screenshot u folderu screenshots pod imenom screenshot1.jpg
//        Koristan link

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));

        driver.manage().window().maximize();
        driver.get("https://cms.demo.katalon.com/");

        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String strDate = dateFormat.format(date);


        File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        Files.copy(f.toPath(), new File("screenshots/screenshot" + strDate + ".jpg").toPath());

        driver.quit();

    }

}
