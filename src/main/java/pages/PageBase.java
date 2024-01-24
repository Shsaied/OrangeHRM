package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {

    public static WebDriverWait longWait (WebDriver driver){
        return new WebDriverWait(driver, 25);

    }

    public static WebDriverWait shortWait (WebDriver driver){
        return  new WebDriverWait (driver, 10);

    }

}
