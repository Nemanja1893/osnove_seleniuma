package p_27_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Zadatak3 {
    public static void main(String[] args) throws InterruptedException {
//        Napisati program koji ucitava stranicu
//        https://github.com/orgs/embedly/repositories?q=&type=all&language=&sort=
//        Klik na Type drawdown
//        Klik na Public iz drowdowna
//        Kilk na Clear filter u desnom uglu

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.manage().window().maximize();
        driver.get("https://github.com/orgs/embedly/repositories?q=&type=all&language=&sort=");

        driver.findElement(By.xpath("//*[@id='type-options']/summary")).click();
        driver.findElement(By.xpath("//div[@class = 'SelectMenu-list']/label[2]")).click();

        Helper helper = new Helper();
        if(helper.elementExist(driver, By.xpath("//div[@id = 'org-repositories']" +
                                                   "//a[@href='/orgs/embedly/repositories']"))){
            driver.findElement(By.xpath("//div[@id = 'org-repositories']" +
                                               "//a[@href='/orgs/embedly/repositories']")).click();
        }else {
            System.out.println("Clear filter nije vidljiv");
        }
        Thread.sleep(5000);

        driver.quit();

    }
}
