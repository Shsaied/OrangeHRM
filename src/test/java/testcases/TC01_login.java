package testcases;

import io.qameta.allure.*;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P01_LoginPage;
import pages.P02_Dashboard;
import util.Utility;

import java.io.IOException;

import static util.Utility.getSingleJsonData;

@Feature("Login Feature")
@Epic("Login Epic")
public class TC01_login extends TestBase {
  String  validUserName=getSingleJsonData(System.getProperty("user.dir")+"/src/test/resources/DataDriven/LoginData.json","validUserName");
  String  invalidUserName=getSingleJsonData(System.getProperty("user.dir")+"/src/test/resources/DataDriven/LoginData.json","invalidUserName");

  String validPassword= Utility.getExcelData(1,1,"validdata");
  String invalidPassword= Utility.getExcelData(1,1,"invaliddata");


    public TC01_login() throws IOException, ParseException {
    }

    @Description("Login With Valid User and Password")
    @Severity(SeverityLevel.CRITICAL)

    @Test(priority = 1, description = "Login With Valid User and Password", retryAnalyzer = retryTest.Retry.class)
    public void loginWithValidUser_P(){
    new P01_LoginPage(driver).insertUserName(validUserName).insertPassword(validPassword).clickLoginButton();
    Assert.assertEquals(new P02_Dashboard(driver).checkDashBoardPage(),"Dashboard");
    Utility.captureScreenshot(driver,"LoginSuccessfully");

  }
  @Description("Login With Invalid User and valid Password")
  @Severity(SeverityLevel.CRITICAL)
  @Test(priority = 2, description = "Login With Invalid User and Valid password")
  public void loginWithInvalidUser_N(){
    new P01_LoginPage(driver).insertUserName(invalidUserName).insertPassword(validPassword).clickLoginButton();
    Assert.assertEquals(new P01_LoginPage(driver).checkInvalidCredentialMessage(),"Invalid credentials");
    Utility.captureScreenshot(driver,"LoginWithInvalidUser");
  }

  @Description("Login With valid user name and invalid password")
  @Severity(SeverityLevel.CRITICAL)
  @Test(priority = 3, description = "Login With valid user name and invalid password")
  public void loginWithInvalidPassword_N(){
    new P01_LoginPage(driver).insertUserName(validUserName).insertPassword(invalidPassword).clickLoginButton();
    Assert.assertEquals(new P01_LoginPage(driver).checkInvalidCredentialMessage(),"Invalid credentials");
  Utility.captureScreenshot(driver,"LoginWithInvalidPassword");
    }
@Description("Login With Invalid User and invalid password")
@Severity(SeverityLevel.NORMAL)
  @Test(priority = 4, description = "Login With Invalid User and invalid password")
  public void loginWithInvalidCredential_N(){
    new P01_LoginPage(driver).insertUserName(invalidUserName).insertPassword(invalidPassword).clickLoginButton();
    Assert.assertEquals(new P01_LoginPage(driver).checkInvalidCredentialMessage(),"Invalid credentials");
    Utility.captureScreenshot(driver,"LoginWithInvalidCredintial");
  }


}
