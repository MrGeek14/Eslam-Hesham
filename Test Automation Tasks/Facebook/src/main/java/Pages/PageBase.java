package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {

    private WebDriver driver;
    private final static int TIMEOUT=30;
    private WebDriverWait wait;

    public PageBase(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver,TIMEOUT);
    }

    public WebDriver getDriver(){
        return driver;
    }

    public WebDriverWait getWait(){
        return wait;
    }
}
