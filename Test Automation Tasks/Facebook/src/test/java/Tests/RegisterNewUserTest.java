package Tests;

import Pages.LoginPage;
import Pages.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import Utilities.TestData;

public class RegisterNewUserTest extends TestBase{

    RegistrationPage registrationPage;
    LoginPage loginPage;
    @Test(dataProviderClass =TestData.class,dataProvider = "getRegistrationExcelData")
    public void registerNewUser(String firstName,String surName,String email,String pass){
        loginPage=new LoginPage(driver);
        registrationPage=loginPage.openSignUp();
        registrationPage.registerNewUser(firstName,surName,email,pass);
    }
}
