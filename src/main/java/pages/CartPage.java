package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CartPage extends BasePage{

    public CartPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getRemoveFromCartButton(int row){
        return driver.findElement(By.xpath("//tr[contains(@class,'cart-item')]["+row+"]/td[1]/a"));
    }
    public WebElement getCouponInput(){
        return driver.findElement(By.xpath("//*[@class='coupon']/input"));
    }
    public WebElement getCouponButton(){
        return driver.findElement(By.xpath("//*[@class='coupon']/button"));
    }
    public WebElement getUpdateCartButton(){
        return driver.findElement(By.name("update_cart"));
    }
    public List<WebElement> getProductRows(){
        return driver.findElements(By.xpath("//form[@class='woocommerce-cart-form']//tbody/tr[@class]"));
    }

}
