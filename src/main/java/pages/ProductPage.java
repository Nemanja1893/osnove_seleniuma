package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage extends BasePage {

    public ProductPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getQuantityInput(){
        return driver.findElement(By.xpath("//*[@class='quantity']//input"));
    }
    public WebElement getAddToCartButton(){
        return driver.findElement(By.name("add-to-cart"));
    }
    public WebElement getAddToCartMessageDiv(){
        return driver.findElement(By.className("woocommerce-message"));
    }

}
