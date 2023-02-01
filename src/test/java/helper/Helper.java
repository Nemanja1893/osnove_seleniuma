package helper;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class Helper {

    public boolean elementExist(WebDriver driver, By by){
        boolean exists = true;
        try {
            driver.findElement(by);
        }catch (NoSuchElementException error){
            exists = false;
        }
        return exists;
    }
}
