package testcases;

import io.qameta.allure.*;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P01_LoginPage;
import pages.P03_Menu;
import pages.P04_Admin_UserManagement;
import pages.P05_Admin_AddUser;
import util.Utility;

import java.io.IOException;
import static util.Utility.getSingleJsonData;
@Feature("Create new Admin User")
@Epic("Create New Admin")
public class TC03_AddNewAdminUser extends TestBase{
    //Todo test paramters
    String loginUserName=getSingleJsonData(System.getProperty("user.dir")+"\\src\\test\\resources\\DataDriven\\LoginData.json","validUserName");
    String passwordForLoginUser=Utility.getExcelData(1,1,"validdata");
    String userName=faker.name().fullName();
    String password= Utility.getExcelData(1,1,"validdata");
    String confirmPassword= Utility.getExcelData(1,1,"validdata");

    public TC03_AddNewAdminUser() throws IOException, ParseException {
    }

    @Description("Create new Admin user")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 1, description = "create new Admin user",retryAnalyzer = retryTest.Retry.class)
    public void createNewAdminUser_P() throws InterruptedException {
        new P01_LoginPage(driver).insertUserName(loginUserName).insertPassword(passwordForLoginUser).clickLoginButton();
        new P03_Menu(driver).navigateToAdminLink();
        new P04_Admin_UserManagement(driver).clickAddSystemUserButton();
        new P05_Admin_AddUser(driver).selectUserRole().insertEmployeeName().selectUserStatus().insertUserName(userName).insertPassword(password).insertConfirmPassword(confirmPassword).clickAddButton();
       // Thread.sleep(3000);
        Assert.assertTrue(new P05_Admin_AddUser(driver).checkSuccessToast().contains("Success"));
        Utility.captureScreenshot(driver,"CreateAdminSuccessMessage");
        Thread.sleep(3000);
        new P04_Admin_UserManagement(driver).insertUserName(userName).clickSearchButton();
        Assert.assertEquals(new P04_Admin_UserManagement(driver).getUserNameInSearchResult(), userName);
        Utility.captureScreenshot(driver,"SearchOnCreatedAdmin");

    }
}
