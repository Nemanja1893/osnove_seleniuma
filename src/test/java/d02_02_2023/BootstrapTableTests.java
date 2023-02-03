package d02_02_2023;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sun.security.util.PropertyExpander;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;
import java.util.List;

public class BootstrapTableTests {
//    Kreirati BootstrapTableTests klasu koja ima:
//    Base url: https://s.bootsnipp.com
//    Test #1: Edit Row
//    Podaci:
//    First Name: ime polaznika
//    Last Name: prezime polaznika
//    Middle Name: srednje ime polanzika
//    Koraci:
//    Ucitati stranu /iframe/K5yrx
//    Verifikovati naslov stranice Table with Edit and Update Data - Bootsnipp.com
//    Klik na Edit dugme prvog reda
//    Sacekati da dijalog za Editovanje bude vidljiv
//    Popuniti formu podacima.
//    Bice potrebno da pre unosa tekst pobrisete tekst koji vec postoji, za to se koristi metoda clear. Koristan link
//    Klik na Update dugme
//    Sacekati da dijalog za Editovanje postane nevidljiv
//    Verifikovati da se u First Name celiji prvog reda tabele javlja uneto ime
//    Verifikovati da se u Last Name celiji prvog reda tabele javlja uneto prezime
//    Verifikovati da se u Middle Name celiji prvog reda tabele javlja uneto srednje ime
//    Za sve validacije ispisati odgovarajuce poruke u slucaju greske
//
//    Test #2: Delete Row
//    Podaci:
//    First Name: ime polaznika
//    Last Name: prezime polaznika
//    Middle Name: srednje ime polanzika
//    Koraci:
//    Ucitati stranu /iframe/K5yrx
//    Verifikovati naslov stranice Table with Edit and Update Data - Bootsnipp.com
//    Klik na Delete dugme prvog reda
//    Sacekati da dijalog za brisanje bude vidljiv
//    Klik na Delete dugme iz dijaloga
//    Sacekati da dijalog za Editovanje postane nevidljiv
//    Verifikovati da je broj redova u tabeli za jedan manji
//    Za sve validacije ispisati odgovarajuce poruke u slucaju greske
//
//    Test #3: Take a Screenshot
//    Koraci:
//    Ucitati stranu  /iframe/K5yrx
//    Verifikovati naslov stranice Table with Edit and Update Data - Bootsnipp.com
//    Kreirati screenshot stranice.
//    Fajl cuvajte na putanji gde su vam bile slike od proslog domaceg. Na putanji: screenshots/slike.png
    private String baseUrl= "https://s.bootsnipp.com";
    private WebDriver driver;
    private WebDriverWait wait;
    private String firstName = "Nemanja";
    private String lastName = "Nikolic";
    private String middleName = "Bratislav";

    @BeforeClass
    public void beforeClass(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        driver.manage().window().maximize();
    }
    @BeforeMethod
    public void beforeMethod(){
        driver.get(baseUrl + "/iframe/K5yrx");
    }
    @Test(priority = 1)
    public void EditRow(){

        Assert.assertEquals(driver.getTitle(),
                    "Table with Edit and Update Data - Bootsnipp.com",
                    "Page title is incorrect");
        //Click on edit button in first row
        driver.findElement(By.xpath("//*[@id='d1']/td[5]/button")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By
                .xpath("//*[@id='edit']//*[@class='modal-content']")));

        //Clear input fields
        driver.findElement(By.id("fn")).clear();
        driver.findElement(By.id("ln")).clear();
        driver.findElement(By.id("mn")).clear();

        //Fill input fields
        driver.findElement(By.id("fn")).sendKeys(firstName);
        driver.findElement(By.id("ln")).sendKeys(lastName);
        driver.findElement(By.id("mn")).sendKeys(middleName);

        //Click on update button in modal
        driver.findElement(
                By.className("modal-content")).findElement(
                By.xpath("//button[@id='up']")).click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("modal-content")));

        Assert.assertEquals(driver.findElement(By.id("f1")).getText(), firstName,"First name is incorrect");
        Assert.assertEquals(driver.findElement(By.id("l1")).getText(), lastName, "Last name is incorrect");
        Assert.assertEquals(driver.findElement(By.id("m1")).getText(), middleName, "Middle name is incorrect");

    }
    @Test(priority = 2)
    public void DeleteRow(){
        Assert.assertEquals(driver.getTitle(),
                "Table with Edit and Update Data - Bootsnipp.com",
                "Page title is incorrect");

        //Click on delete button in first row
        driver.findElement(By.xpath("//*[@id='d1']/td[6]/button")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By
                        .xpath("//*[@id='delete']//*[@class='modal-content']")));

        //Click on delete button in modal
        driver.findElement(
                By.className("modal-content")).findElement(
                By.xpath("//button[@id='del']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("row")));

        int numberOfRows = driver.findElements(By.xpath("//*[@class='row']//tbody/tr")).size();
        List<WebElement> rows = driver.findElements(By.xpath("//*[@class='row']//tbody/tr"));
        for (int i = 0; i < rows.size(); i++) {
            if(!rows.get(i).isDisplayed()){
                rows.remove(i);
            }
        }
        Assert.assertEquals(rows.size(),numberOfRows - 1, "Number of rows should be less by one");
    }

    @Test(priority = 3)
    public void TakeAScreenshot() throws IOException {
        Assert.assertEquals(driver.getTitle(),
                "Table with Edit and Update Data - Bootsnipp.com",
                "Page title is incorrect");

        File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        Files.copy(f.toPath(), new File("screenshots/screenshot_bootstrap_1.png").toPath());

    }
    @AfterClass
    public void afterClass() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

}
