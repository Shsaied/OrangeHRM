package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static pages.PageBase.shortWait;

public class P05_Admin_AddUser {
    //todo declare Web driver
    WebDriver driver;
    //todo constructor
    public P05_Admin_AddUser(WebDriver driver){
        this.driver=driver;
    }

    //Todo locators
    private final By userRoleDropDownListArrow=By.xpath("(//i[@class=\"oxd-icon bi-caret-down-fill oxd-select-text--arrow\"])[1]");
    private final By userRoleDropDownList=By.xpath("(//div[@class=\"oxd-select-text-input\"])[1]");
    private final By statusDropListArrow=By.xpath("(//i[@class=\"oxd-icon bi-caret-down-fill oxd-select-text--arrow\"])[2]");
    private final By statusDropDownList=By.xpath("(//div[@class=\"oxd-select-text-input\"])[2]");
    private final By employeeNameInputField=By.xpath("//input[@placeholder=\"Type for hints...\"]");
    private final By userNameInputField=By.xpath("(//input[@class=\"oxd-input oxd-input--active\"])[2]");
    private final By passwordInputField=By.xpath("(//input[@type=\"password\"])[1]");
    private final By confirmPasswordInputField=By.xpath("(//input[@type=\"password\"])[2]");
    private final By newUserSubmitButton=By.xpath("//button[@type=\"submit\"]");
    private final  By successToast=By.id("oxd-toaster_1");


    //Todo methods
    public P05_Admin_AddUser insertEmployeeName() throws InterruptedException {
        driver.findElement(this.employeeNameInputField).sendKeys("a");
       Thread.sleep(3000);
        driver.findElement(this.employeeNameInputField).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(this.employeeNameInputField).sendKeys(Keys.ENTER);



        return this;
    }
    public P05_Admin_AddUser insertUserName(String userName){
        driver.findElement(this.userNameInputField).sendKeys(userName);
        return this;
    }
    public P05_Admin_AddUser insertPassword(String password){
        driver.findElement(this.passwordInputField).sendKeys(password);
        System.out.println(password);
        return this;
    }
    public P05_Admin_AddUser insertConfirmPassword(String confirmPassword){
        driver.findElement(this.confirmPasswordInputField).sendKeys(confirmPassword);
        System.out.println(confirmPassword);

        return this;
    }
    public P05_Admin_AddUser selectUserRole(){
        driver.findElement(this.userRoleDropDownListArrow).click();
        driver.findElement(this.userRoleDropDownList).sendKeys("Admin");
        driver.findElement(this.userRoleDropDownList).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(this.userRoleDropDownList).sendKeys(Keys.ENTER);
        return this;
    }
    public P05_Admin_AddUser selectUserStatus(){
        driver.findElement(this.statusDropListArrow).click();
        driver.findElement(this.statusDropDownList).sendKeys("Enabled");
        driver.findElement(this.statusDropDownList).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(this.statusDropDownList).sendKeys(Keys.ENTER);
        return this;
    }
    public P05_Admin_AddUser clickAddButton(){
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.newUserSubmitButton));
            driver.findElement(this.newUserSubmitButton).click();
        }catch (TimeoutException ex) {ex.printStackTrace();}
        return this;
    }
    public String checkSuccessToast() {
        String successToastText=null;
        try {
            shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.successToast));
            successToastText = driver.findElement(this.successToast).getText();
        } catch (TimeoutException ex) {
            ex.printStackTrace();
        }
        System.out.println(successToastText);
        return successToastText;

    }
}
