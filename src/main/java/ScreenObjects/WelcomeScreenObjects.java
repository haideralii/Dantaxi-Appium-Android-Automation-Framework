package ScreenObjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class WelcomeScreenObjects {

    private AppiumDriver driver;

    public WelcomeScreenObjects(AppiumDriver driver){
        this.driver = driver;
    }

    private By _getStartedBtn = By.id("dk.dantaxi.app:id/btn_create_profile");

    private By _loginAsAnonymousBtn = By.id("dk.dantaxi.app:id/btn_no_profile");


    public EnterPhoneNumberScreenObjects TapGetStartedBtn(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(_getStartedBtn).click();
        return new EnterPhoneNumberScreenObjects(driver);
    }
     public HomeMapScreenObjects TapLoginAsAnonymousUserBtn(){
         driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
         driver.findElement(_loginAsAnonymousBtn).click();
         return new HomeMapScreenObjects(driver);
     }

}
