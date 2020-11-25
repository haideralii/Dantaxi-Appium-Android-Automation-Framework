package ScreenObjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class HomeMapScreenObjects {

    private AppiumDriver driver;

    public HomeMapScreenObjects(AppiumDriver driver){
        this.driver = driver;
    }

    private By _denyPermissionBtn = By.id("com.android.permissioncontroller:id/permission_deny_button");

    private By _closeFullScreenPopupIcon = By.id("dk.dantaxi.app:id/image_cancel");

    public void TapOnDenyOptionOfSystemLocationAccess(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(_denyPermissionBtn).click();
    }

    public void TapOnCloseIconOfFullScreenPopup(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(_closeFullScreenPopupIcon).click();
    }

}
