package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P01_LoginPage {
    //Todo declare web driver
    WebDriver driver;

    //Todo constructor
    public P01_LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //Todo define Locators
    private final By userName = By.xpath("//input[@name=\"username\"]");
    private final By password = By.xpath("//input[@name=\"password\"]");
    private final By loginButton=By.xpath("//button[@type=\"submit\"]");
    private final By invalidCredentialMessage=By.xpath("//p[@class=\"oxd-text oxd-text--p oxd-alert-content-text\"]");

    //Todo define Methods
    public P01_LoginPage insertUserName(String userName){
        driver.findElement(this.userName).sendKeys(userName);
        return this;
    }
    public P01_LoginPage insertPassword(String password){
        driver.findElement(this.password).sendKeys(password);
        return this;
    }
    public P01_LoginPage clickLoginButton() {
        driver.findElement(this.loginButton).click();
        return this;
    }
    public String checkInvalidCredentialMessage(){
        String invalidCredentialMSG=driver.findElement(this.invalidCredentialMessage).getText();
        return invalidCredentialMSG;
    }

}


