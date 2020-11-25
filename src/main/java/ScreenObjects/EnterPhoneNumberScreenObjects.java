package ScreenObjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class EnterPhoneNumberScreenObjects {

    private AppiumDriver driver;

    public EnterPhoneNumberScreenObjects(AppiumDriver driver){
        this.driver = driver;
    }

    By _scrollCountryList = By.id("dk.dantaxi.app:id/rlClickConsumer");
    By _enterNameForCountryField = By.id("dk.dantaxi.app:id/editText_search");
    By _denmarkCountrySelection = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout");
    By _phoneNumberField = By.id("dk.dantaxi.app:id/edit_phone_number");
    By _nextButton = By.id("dk.dantaxi.app:id/btn_action");

    public ConfirmPhoneNumberScreenObjects EnterPhoneNumber(String country, String phone){
        driver.findElement(_scrollCountryList).click();
        driver.findElement(_enterNameForCountryField).sendKeys(country);
        driver.findElement(_denmarkCountrySelection).click();
        driver.findElement(_phoneNumberField).sendKeys(phone);
        driver.findElement(_nextButton).click();
        return new ConfirmPhoneNumberScreenObjects(driver);
    }


}
