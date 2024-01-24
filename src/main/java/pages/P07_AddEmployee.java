package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static pages.PageBase.shortWait;

public class P07_AddEmployee {
    //Todo Declare web driver
    WebDriver driver;
    //Todo constructor
    public P07_AddEmployee(WebDriver driver){
        this.driver= driver;

    }
    //Todo Locators
    private final By employeeFirstNameInputField=By.xpath("//input[@class=\"oxd-input oxd-input--active orangehrm-firstname\"]");
    private final By employeeMiddleNameInputField=By.xpath("//input[@class=\"oxd-input oxd-input--active orangehrm-middlename\"]");
    private final By employeeLastNameInputField=By.xpath("//input[@class=\"oxd-input oxd-input--active orangehrm-lastname\"]");
    private final By employeeID=By.xpath("(//html//body//div//div[2]//input)[6]");
    private final By createLoginDetailsToggle=By.xpath("//span[@class=\"oxd-switch-input oxd-switch-input--active --label-right\"]");
    private final By userNameInputField=By.xpath("(//input[@class=\"oxd-input oxd-input--active\"])[3]");
    private final By passwordInputField=By.xpath("(//input[@type=\"password\"])[1]");
    private final By confirmPasswordInputField=By.xpath("(//input[@type=\"password\"])[2]");

    private final By saveEmployeeButton=By.xpath("//button[@type=\"submit\"]");

    private final By successMessage=By.id("oxd-toaster_1");

    //Todo Methods
    public P07_AddEmployee insertEmployeeFirstName(String employeeFirstName) {
        driver.findElement(this.employeeFirstNameInputField).sendKeys(employeeFirstName);
        return this;
    }
    public P07_AddEmployee insertEmployeeMiddleName(String employeeMiddleName) {
        driver.findElement(this.employeeMiddleNameInputField).sendKeys(employeeMiddleName);
        return this;
    }
    public P07_AddEmployee insertEmployeeLastName(String employeeLastName) {
        driver.findElement(this.employeeLastNameInputField).sendKeys(employeeLastName);
        return this;
    }
    public P07_AddEmployee openLoginDetailsToggle() {
        driver.findElement(this.createLoginDetailsToggle).click();
        return this;
    }
    public P07_AddEmployee insertEmployeeUserName(String employeeUserName) {
        driver.findElement(this.userNameInputField).sendKeys(employeeUserName);
        return this;
    }
    public P07_AddEmployee insertEmployeePassword(String employeePassword) {
        driver.findElement(this.passwordInputField).sendKeys(employeePassword);
        System.out.println("password is " +employeePassword);
        return this;
    }
    public P07_AddEmployee insertEmployeeConfirmPassword(String employeeConfirmPassword) {
        driver.findElement(this.confirmPasswordInputField).sendKeys(employeeConfirmPassword);
        System.out.println("Confirm password is "+employeeConfirmPassword);
        return this;
    }
    public String getEmployeeID() {
       String employeeIDText= driver.findElement(this.employeeID).getText();
       System.out.println("EmployeeId in Add new Employee page "+ employeeIDText);
        return employeeIDText;
    }
    public P07_AddEmployee clickOnSaveEmployeeData(){
        driver.findElement(this.saveEmployeeButton).click();
        return this;
    }
    public String checkSuccessMessageAppearance(){
        String successMessage=driver.findElement(this.successMessage).getText();
        System.out.println(successMessage);
        return successMessage;
    }
}
