package Tests;

import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import Utilities.TestData;

public class LoginTest extends TestBase{

    LoginPage loginPage;
    String homePageURL;
    @Test(dataProviderClass =TestData.class,dataProvider = "getLoginExcelData")
    public void login(String email,String pass){
        loginPage=new LoginPage(driver);
        homePageURL=loginPage.login(email,pass);
        Assert.assertTrue(homePageURL.contains("welcome"));
    }
}
