package pages;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import util.Utility;

import java.util.ArrayList;

import java.util.concurrent.TimeUnit;

import static pages.PageBase.shortWait;

public class P04_Admin_UserManagement {

    //Todo declare Webdriver
    WebDriver driver;
    //Todo constructor
    public P04_Admin_UserManagement(WebDriver driver){
        this.driver=driver;
    }
    //Todo Locators
    private final By userNameInputField=By.xpath("(//input[@class=\"oxd-input oxd-input--active\"])[2]");
    private final By userRoleDropDownListArrow=By.xpath("(//i[@class=\"oxd-icon bi-caret-down-fill oxd-select-text--arrow\"])[1]");
    private final By userRoleDropDownList=By.xpath("(//div[@class=\"oxd-select-text-input\"])[1]");
    private final By statusDropDownListArrow=By.xpath("(//i[@class=\"oxd-icon bi-caret-down-fill oxd-select-text--arrow\"])[2]");
    private final By statusDropDownList=By.xpath("(//div[@class=\"oxd-select-text-input\"])[2]");
    private final By employeeNameInputField=By.xpath("//input[@placeholder=\"Type for hints...\"]");
    private final By searchButton=By.xpath("//button[@class=\"oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space\"]");
    private final By addSystemUserButton=By.xpath("//button[@class=\"oxd-button oxd-button--medium oxd-button--secondary\"]");
private final By userNameInSearchResult=By.xpath("(//div[@class=\"oxd-table-cell oxd-padding-cell\"])[2]");

    //tODO Method
    public P04_Admin_UserManagement insertUserName(String systemUserName){
        try {
            shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.userNameInputField));
            driver.findElement(this.userNameInputField).sendKeys(systemUserName);
        } catch(TimeoutException ex){ex.printStackTrace();}
        return this;
    }
    public P04_Admin_UserManagement insertEmployeeName(String systemEmployeeName){
        driver.findElement(this.employeeNameInputField).sendKeys(systemEmployeeName);
        return this;
    }
    public P04_Admin_UserManagement selectUserRole() throws InterruptedException {
        driver.findElement(this.userRoleDropDownListArrow).click();
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.userRoleDropDownList));
        driver.findElement(this.userRoleDropDownList).sendKeys("Admin");
        driver.findElement(this.userRoleDropDownList).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(this.userRoleDropDownList).sendKeys(Keys.ENTER);

        return this;
    }
    public P04_Admin_UserManagement selectStatus(){
        driver.findElement(this.statusDropDownListArrow).click();
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.statusDropDownList));
        WebElement dropDownListElement=driver.findElement(this.statusDropDownList);
        ArrayList<String> records = new ArrayList<>();
        records.add("Enabled");
        records.add("Disabled");
        Utility selectRandomData= new Utility();
        String x= selectRandomData.selectAndSendRandomRecord(records,dropDownListElement);
        driver.findElement(this.statusDropDownList).sendKeys(x);
        System.out.println(x);
        //driver.findElement(this.statusDropDownList).sendKeys("Enabled");
       driver.findElement(this.statusDropDownList).sendKeys(Keys.ARROW_DOWN);
       driver.findElement(this.statusDropDownList).sendKeys(Keys.ARROW_DOWN);
       driver.findElement(this.statusDropDownList).sendKeys(Keys.ENTER);
        return this;
    }
    public P04_Admin_UserManagement clickSearchButton(){
        driver.findElement(this.searchButton).click();
        return this;
    }
public P04_Admin_UserManagement clickAddSystemUserButton(){
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.addSystemUserButton));
            driver.findElement(this.addSystemUserButton).click();
        }catch (TimeoutException ex){
           ex.printStackTrace();
        }
        return this;
}

public String getUserNameInSearchResult(){
   String theTextOfUserNameInSearchResult=driver.findElement(this.userNameInSearchResult).getText();
       System.out.println(theTextOfUserNameInSearchResult);
        return theTextOfUserNameInSearchResult;
}
}
