package p02_02_2023;

import com.sun.org.glassfish.gmbal.Description;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class KatalonLoginTests {

//    Kreirati klasu KatalonLoginTests za testove
//    Base url: https://cms.demo.katalon.com
//    Test #1: Visit login page from Nav bar
//    Koraci:
//    Ucitati home stranicu
//    Kliknuti na My account link
//    Verifikovati da je naslov stranice My account – Katalon Shop
//    Verifikovati da se u url-u stranice javlja /my-account
//    Za sve validacije ispisati odgovarajuce poruke u slucaju greske

    private WebDriver driver;
    private WebDriverWait wait;
    @BeforeClass
    public void beforeClass(){

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    }
    @BeforeMethod
    public void beforeMethod(){
        driver.get("https://cms.demo.katalon.com");
        driver.manage().window().maximize();
    }
    @Test
    @Description("TC - #1")
    public void VisitLoginPageFromNavBar(){
        driver.findElement(By.id("primary-menu")).findElement(By.xpath("//ul/li[3]/a")).click();
        Assert.assertEquals(driver.getTitle(), "My account – Katalon Shop", "Title verification");
        Assert.assertTrue(driver.getCurrentUrl().contains("/my-account"), "Url verification");

//        Assert.assertEquals(driver.getTitle(), "My account – Katlon Shop", "Title verification");
//        Assert.assertTrue(driver.getCurrentUrl().contains("/my-account"), "Url verification");
    }
    @Test
    @Description("TC - #2")
    public void CheckInputTypes(){
       // driver.findElement(By.id("primary-menu")).findElement(By.xpath("//ul/li[3]/a")).click();
        driver.get("https://cms.demo.katalon.com/my-account/");
        WebElement emailField = driver.findElement(By.xpath("//*[@class = 'woocommerce']//input"));
        WebElement passField = driver.findElement(By
                .xpath("//*[@class = 'woocommerce']//input[@id='password']"));

        WebElement checkboxField = driver.findElement(By.id("rememberme"));

        Assert.assertEquals(emailField.getAttribute("type"),"text",
                                    "Email field has attribute type that doesn't equals text");

        Assert.assertEquals(passField.getAttribute("type"),"password",
                                "Password field has attribute type that doesn't equals text");

        Assert.assertEquals(checkboxField.getAttribute("type"),"checkbox",
                            "Checkbox field has attribute type that doesn't equals text");

        Assert.assertFalse(checkboxField.isSelected(), "Checkbox shouldn't be selected");


    }
    @Test
    public void DisplayErrorWhenCredentialsAreWrong(){
        driver.get("https://cms.demo.katalon.com/my-account/");
        String email = "invalidemail@gmail.com";
        String password = "invalid123";

        driver.findElement(By.xpath("//input[@id='username']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        WebElement errorClass = driver.findElement(By.xpath("//*[@class='woocommerce-error']/li"));

//        wait.until(ExpectedConditions.presenceOfElementLocated(By
//                .xpath("//*[@class='woocommerce-error']")));

        Assert.assertTrue(errorClass.isEnabled(), "Error message is not shown");
        Assert.assertEquals(errorClass.getText(), "ERROR: Invalid email address. Lost your password?",
                                    "Error message is not right");

        Assert.assertEquals(driver.getCurrentUrl(), "https://cms.demo.katalon.com/my-account/",
                                    "The page is different then my account page");

    }
    @AfterClass
    public void afterClass() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }

}
