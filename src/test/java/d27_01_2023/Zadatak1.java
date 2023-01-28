package d27_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {

//        Ucitati stranicu https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example
//        Klik na svako dugme od PRIMARY do DARK
//        Sacekati da se toasts u desnom gornjem uglu pojavi
//        Pauza izmedju klikova 1s
//        Postavite implicitno cekanje za ucitavanje stranice i trazenje elemenata na 10s



        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.manage().window().maximize();
        driver.get("https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example");



        List< WebElement> buttons = driver
                .findElements(By.xpath("//*[@class = 'container text-center']" +
                                                        "/button[contains(@id, 'basic')]"));

//        Thread.sleep(2000);
        System.out.println(buttons.size());
        for (int i = 0; i < buttons.size(); i++) {
            buttons.get(i).click();

            String subtract = "-trigger";
            String s = buttons.get(i).getAttribute("id");
            s = s.substring(0, s.length() - subtract.length());

            driver.findElement(By.xpath("//*[@id = '" + s + "-example" + "']"));
            Thread.sleep(1000);

        }



        driver.quit();
    }
}
