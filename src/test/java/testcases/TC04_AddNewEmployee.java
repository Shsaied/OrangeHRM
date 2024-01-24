package testcases;

import io.qameta.allure.*;
import junit.framework.Assert;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;
import pages.P01_LoginPage;
import pages.P03_Menu;
import pages.P06_ViewEmployeeList;
import pages.P07_AddEmployee;
import util.Utility;

import java.io.IOException;
@Feature("Create new Employee")
@Epic("Create Employee")
public class TC04_AddNewEmployee extends TestBase{
    String username= Utility.getSingleJsonData(System.getProperty("user.dir")+"/src/test/resources/DataDriven/LoginData.json","validUserName");
    String password=Utility.getExcelData(1,1,"validdata");
    String employeeFirstName=faker.name().firstName();
    String employeeMiddleName=faker.name().firstName();
    String employeelastname=faker.name().lastName();
    String employeeUserName=faker.name().username();
    String employeePassword=Utility.getExcelData(1,1,"validdata");
    String employeeConfirmPassword=Utility.getExcelData(1,1,"validdata");
    public TC04_AddNewEmployee() throws IOException, ParseException {
    }

@Description("Create new Employee then Search On him to confirm Success Creation ")
@Severity(SeverityLevel.CRITICAL)
@Test(priority = 1, description="Create new Employee",retryAnalyzer = retryTest.Retry.class)
    public void createNewEmployee_P() throws InterruptedException {
        new P01_LoginPage(driver).insertUserName(username).insertPassword(password).clickLoginButton();
        new P03_Menu(driver).navigateToPIMLink();
        new P06_ViewEmployeeList(driver).clickOnAddEmployeeButton();
        new P07_AddEmployee(driver).insertEmployeeFirstName(employeeFirstName).insertEmployeeMiddleName(employeeMiddleName).insertEmployeeLastName(employeelastname).openLoginDetailsToggle().insertEmployeeUserName(employeeUserName).insertEmployeePassword(employeePassword);
        Thread.sleep(3000);
        new P07_AddEmployee(driver).insertEmployeeConfirmPassword(employeePassword);
        Thread.sleep(3000);
        new P07_AddEmployee(driver).clickOnSaveEmployeeData();
        Thread.sleep(3000);
        Assert.assertTrue(new P07_AddEmployee(driver).checkSuccessMessageAppearance().contains("Success"));
        Utility.captureScreenshot(driver,"AddEmployeeSuccessMessage");
        new P03_Menu(driver).navigateToPIMLink();
        new P06_ViewEmployeeList(driver).insertEmployeeName(employeeFirstName,employeeMiddleName).insertEmployeeId(new P07_AddEmployee(driver).getEmployeeID()).clickOnSearchButton();
        Thread.sleep(3000);
        Utility.captureScreenshot(driver,"SearchOnCreatedEmployee");
       // Assert.assertEquals(new P06_ViewEmployeeList(driver).getEmployeeIdInSearchResult(),new P07_AddEmployee(driver).getEmployeeID());Assert.assertEquals(new P06_ViewEmployeeList(driver).getEmployeeNameInSearchResult(),employeeFirstName+" "+employeeMiddleName);
       System.out.println(employeeFirstName+" "+employeeMiddleName);
    }
}
