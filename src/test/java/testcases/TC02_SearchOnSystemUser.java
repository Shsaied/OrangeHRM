package testcases;

import io.qameta.allure.*;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import pages.P01_LoginPage;
import pages.P03_Menu;
import pages.P04_Admin_UserManagement;
import util.Utility;

import java.io.IOException;

import static util.Utility.getSingleJsonData;

@Feature("Search on admin User")
@Epic("Search On Admin")

public class TC02_SearchOnSystemUser extends TestBase{

    String userName=getSingleJsonData(System.getProperty("user.dir")+"\\src\\test\\resources\\DataDriven\\LoginData.json","validUserName");

    String employeeName="doaa nwider";

    String password= Utility.getExcelData(1,1,"validdata");
    public TC02_SearchOnSystemUser() throws IOException, ParseException {
    }
  @Description("Check Search function")
  @Severity(SeverityLevel.CRITICAL)
  @Test(priority = 1, description = "Serach on System user ",retryAnalyzer = retryTest.Retry.class)
    public void searchOnSystemUser_P() throws InterruptedException {
        new P01_LoginPage(driver).insertUserName(userName).insertPassword(password).clickLoginButton();
        new P03_Menu(driver).navigateToAdminLink();
        new P04_Admin_UserManagement(driver).insertUserName(userName).selectUserRole().insertEmployeeName(employeeName).selectStatus();
        Thread.sleep(3000);
    new P04_Admin_UserManagement(driver).clickSearchButton();
}
}
