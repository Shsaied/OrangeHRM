package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P02_Dashboard {
    //Todo declare Web driver
    WebDriver driver;
    //Todo constructor
    public P02_Dashboard(WebDriver driver){
        this.driver=driver;
    }
    //todo define locator
    private final By dashBoardTitle= By.xpath("//h6[@class=\"oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module\"]");

    //todo define methods
public String checkDashBoardPage(){
    String dashBoardTitle=driver.findElement(this.dashBoardTitle).getText();
    return dashBoardTitle;

}
}
