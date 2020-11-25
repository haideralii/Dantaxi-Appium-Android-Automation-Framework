package ScreenObjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class ConfirmPhoneNumberScreenObjects {

    private AppiumDriver driver;

    public ConfirmPhoneNumberScreenObjects(AppiumDriver driver){
        this.driver = driver;
    }

    private By _screenTitle = By.id("dk.dantaxi.app:id/text_title");

    public String GetScreenTitle(){
       String _title = driver.findElement(_screenTitle).getText();
       return _title;
    }

}
