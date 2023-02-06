package p06_02_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class KatalonShopTests extends BaseTests{

    @Test
    public void AddingProductWithQuantityToTheCart(){
        driver.get(baseUrl + "/product/flying-ninja/");
        productPage.getQuantityInput().clear();
        productPage.getQuantityInput().sendKeys("3");
        productPage.getAddToCartButton().click();
        Assert.assertTrue(productPage.getAddToCartMessageDiv().getText().contains("Flying Ninja"),
                "Message doesnt contain the right text");

        navPage.getCartLink().click();
        Assert.assertEquals(driver.getCurrentUrl(),baseUrl+"cart/",
                                    "The route doesn't contain cart");

        int cartElements = cartPage.getProductRows().size();
        Assert.assertEquals(cartElements,1,"There are no products in the cart");
    }
    @Test
    public void removingProductFromCart() {

        navPage.getCartLink().click();
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl+"cart/", "The route doesn't contain cart");

        int cartElements = cartPage.getProductRows().size();
        Assert.assertEquals(cartElements,1,"There are no products in the cart");

        cartPage.getRemoveFromCartButton(1).click();

        cartElements = cartPage.getProductRows().size();
        Assert.assertEquals(cartElements,0,"There are still products in the cart");
    }
}
