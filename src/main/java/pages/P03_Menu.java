package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P03_Menu {
    //Todo Declare web driver
    WebDriver driver;
    //Todo constructor
    public P03_Menu(WebDriver driver){
        this.driver= driver;

    }
    //Todo Locators
    private final By adminLink=By.xpath("(//span[@class=\"oxd-text oxd-text--span oxd-main-menu-item--name\"])[1]");
    private final By PIMLink=By.xpath("(//span[@class=\"oxd-text oxd-text--span oxd-main-menu-item--name\"])[2]");

    //Todo Methods
public P03_Menu navigateToAdminLink(){
    driver.findElement(this.adminLink).click();
    return this;
}
    public P03_Menu navigateToPIMLink(){
        driver.findElement(this.PIMLink).click();
        return this;
    }
}
