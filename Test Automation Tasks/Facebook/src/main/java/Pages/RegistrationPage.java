package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends PageBase{

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }
    By firstNameTxt=By.name("firstname");
    By surNameTxt=By.name("lastname");
    By emailTxt=By.name("reg_email__");
    By confirmEmailTxt=By.name("reg_email_confirmation__");
    By passwordTxt=By.id("password_step_input");
    By selectYearDDL=By.id("year");
    By maleGenderRadioBtn=By.xpath("//input[@value=\"1\"]");
    By signUpBtn=By.name("websubmit");

    public void registerNewUser(String firstName,String surName,String email,String pass){
        getWait().until(ExpectedConditions.elementToBeClickable(signUpBtn));
        getDriver().findElement(firstNameTxt).sendKeys(firstName);
        getDriver().findElement(surNameTxt).sendKeys(surName);
        getDriver().findElement(emailTxt).sendKeys(email);
        getDriver().findElement(confirmEmailTxt).sendKeys(email);
        getDriver().findElement(passwordTxt).sendKeys(pass);
       new Select(getDriver().findElement(selectYearDDL)).selectByIndex(10);
        getDriver().findElement(maleGenderRadioBtn).click();
        getDriver().findElement(signUpBtn).click();
    }
}
