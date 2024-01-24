package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P06_ViewEmployeeList {
    //Todo Declare web driver
    WebDriver driver;
    //Todo constructor
    public P06_ViewEmployeeList (WebDriver driver){
        this.driver= driver;

    }
    //Todo Locators
    private final By addEmployeeButton=By.xpath("//i[@class=\"oxd-icon bi-plus oxd-button-icon\"]");
    private final By searchOnEmployeeButton=By.xpath("//button[@type=\"submit\"]");
    private final By employeeNameInputField=By.xpath("(//input[@placeholder=\"Type for hints...\"])[1]");

    private final By employeeIDInputField=By.xpath("(//input[@class=\"oxd-input oxd-input--active\"])[2]");

    private final By employeeIdInSearchResult=By.xpath("(//div[@data-v-6c07a142])[1]");
    private final By employeeNameInSearchResult=By.xpath("(//div[@data-v-6c07a142])[2]");
    //Todo Methods
    public P06_ViewEmployeeList clickOnAddEmployeeButton(){
        driver.findElement(this.addEmployeeButton).click();
        return this;
    }

    public P06_ViewEmployeeList clickOnSearchButton(){
        driver.findElement(this.searchOnEmployeeButton).click();
        return this;
    }
    public P06_ViewEmployeeList insertEmployeeName(String employeeFirstName, String employeeMiddleName){
        driver.findElement(this.employeeNameInputField).sendKeys(employeeFirstName+" "+employeeMiddleName);
        return this;
    }
    public P06_ViewEmployeeList insertEmployeeId(String employeeID){
        driver.findElement(this.employeeIDInputField).sendKeys(employeeID);
        return this;
    }

    public String getEmployeeIdInSearchResult(){
        String employeeIdInSearchResultText= driver.findElement(this.employeeIdInSearchResult).getText();
       System.out.println("employeeId in Search result is "+employeeIdInSearchResultText);
        return employeeIdInSearchResultText;
    }

    public String getEmployeeNameInSearchResult(){
        String employeeNameInSearchResultText= driver.findElement(this.employeeNameInSearchResult).getText();
        System.out.println("employee Name in Search result is "+employeeNameInSearchResultText);
        return employeeNameInSearchResultText;
    }
}
