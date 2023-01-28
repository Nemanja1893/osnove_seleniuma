package d26_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Zadatak3 {
    public static void main(String[] args) throws InterruptedException {
//        Napisati program koji:
//        Ucitava stranicu https://s.bootsnipp.com/iframe/Dq2X
//        Klikce na svaki iks da ugasi obavestenje i proverava da li se nakon klika element
//        obrisao sa stranice i ispisuje odgovarajuce poruke (OVO JE POTREBNO RESITI PETLJOM)
//        POMOC: Brisite elemente odozdo.
//        (ZA VEZBANJE)Probajte da resite da se elemementi brisu i odozgo

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.manage().window().maximize();
        driver.get("https://s.bootsnipp.com/iframe/Dq2X");

        List<WebElement> buttons = driver.findElements(By.xpath("//*[@class = 'col-md-12']/div"));
        Helper helper = new Helper();
        for (int i = 0; i < buttons.size(); i++) {

            String item = buttons.get(i).getAttribute("class");
            System.out.println("Brise se item: " + item);
            buttons.get(i).findElement(By.tagName("button")).click();
            System.out.println("Obrisao se item: " + item);

        }

        driver.quit();

    }
}
