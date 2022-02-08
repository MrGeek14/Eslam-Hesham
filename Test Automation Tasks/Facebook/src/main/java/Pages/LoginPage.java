package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends PageBase{

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    By emailTxt=By.id("email");
    By passTxt=By.id("pass");
    By loginBtn=By.name("login");
    By createNewAccountBtn=By.linkText("Create New Account");

    public String login(String email,String password){
        getWait().until(ExpectedConditions.elementToBeClickable(emailTxt));
        getDriver().findElement(emailTxt).sendKeys(email);
        getDriver().findElement(passTxt).sendKeys(password);
        getDriver().findElement(loginBtn).click();
        getWait().until(ExpectedConditions.urlContains("welcome"));
        return getDriver().getCurrentUrl();
    }
    public RegistrationPage openSignUp(){
        getWait().until(ExpectedConditions.elementToBeClickable(createNewAccountBtn));
        getDriver().findElement(createNewAccountBtn).click();
        return new RegistrationPage(getDriver());
    }
}
