package AutomatitionExercisePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TopNavPage extends BasePage {
    public TopNavPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getHomeLink(){
        return driver.findElement(By.cssSelector("a[href='/']"));
    }
    public WebElement getProductsLink(){
        return driver.findElement(By.cssSelector("a[href='/products']"));
    }
    public WebElement getCartLink(){
        return driver.findElement(By.cssSelector("a[href='/view_cart']"));
    }
    public WebElement getLoginLink(){
        return driver.findElement(By.cssSelector("a[href='/login']"));
    }
    public WebElement getLoggedInLink(){
        return driver.findElement(By.cssSelector(".fa.fa-user"));
    }
    public WebElement getDeleteAccountButton(){
        return driver.findElement(By.cssSelector("a[href='/delete_account']"));
    }

}
