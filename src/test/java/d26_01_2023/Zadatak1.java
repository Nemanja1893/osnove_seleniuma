package d26_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;



public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {

//        Niz todo-a (niz stringova) koje treba da uneti. Niz je:
//        Visit Paris
//        Visit Prague
//        Visit London
//        Visit New York
//        Visit Belgrade
//        Maksimizirati prozor
//        Ucitati stranicu https://example.cypress.io/todo
//        Program petljom prolazi kroz niz todo-a i svaki unosi na stranicu
//        Nakon svakog unosa todo-a, unosi se enter
//        Validira da li je novi todo dodat na stranici
//        Na kraju programa proci petljom i izbrisati svaki todo sa stranice (klikom na x dugme svakog todo-a)
//        Validirati da je na kraju programa broj todo-a na stranici 0.
//        Cekanje od 5s
//        Zatvorite pretrazivac


        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        ArrayList<String> todos = new ArrayList<>();
        todos.add("Visit Paris");
        todos.add("Visit Prague");
        todos.add("Visit London");
        todos.add("Visit New York");
        todos.add("Visit Belgrade");

        driver.manage().window().maximize();
        driver.get("https://example.cypress.io/todo");
        Thread.sleep(2000);



        for (int i = 0; i < todos.size(); i++) {
            driver.findElement(By.className("new-todo")).sendKeys(todos.get(i));
            driver.findElement(By.className("new-todo")).sendKeys(Keys.ENTER);

        }
        List<WebElement> elementList = driver.findElements(By.xpath("//*[@class = 'todo-list']/li"));
        Thread.sleep(1000);

        for (int i = 0; i < elementList.size(); i++) {
//            System.out.println(elementList.get(i).getText());
            for (int j = 0; j < todos.size(); j++) {
                if(elementList.get(i).getText().equals(todos.get(j))){
                    System.out.println("Uneto je: " + todos.get(j));
                }
            }
        }
        List<WebElement> buttons = driver.findElements(By.xpath("//li//button"));
        for (int i = 0; i < buttons.size(); i++) {

            Actions actions = new Actions(driver);
            actions.moveToElement(elementList.get(i).findElement(By.xpath("//div/label")))
                    .perform();

            Thread.sleep(1000);
            buttons.get(i).click();

        }
        elementList = driver.findElements(By.xpath("//*[@class = 'todo-list']/li"));
//        System.out.println(elementList.size());
        if(elementList.size() == 0){
            System.out.println("Svi todos su obrisani");
        }
        Thread.sleep(5000);

        driver.quit();
    }
}
