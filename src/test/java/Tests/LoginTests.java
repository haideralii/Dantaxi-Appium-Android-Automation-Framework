package Tests;

import ScreenObjects.ConfirmPhoneNumberScreenObjects;
import ScreenObjects.EnterPhoneNumberScreenObjects;
import Tests.DataProvider.DataSetForTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTests{

    @Test(dataProvider = "AlreadyRegisteredPhoneNumberData", dataProviderClass = DataSetForTest.class)
    public void LoginWithNormalUser(String _phoneNumber) throws InterruptedException {

        EnterPhoneNumberScreenObjects _enterPhoneNumberScreen = _welcomeScreen.TapGetStartedBtn();
        ConfirmPhoneNumberScreenObjects _text = _enterPhoneNumberScreen.EnterPhoneNumber("denmark", _phoneNumber);
        Thread.sleep(1000);
        Assert.assertEquals("Confirm your phone number", _text.GetScreenTitle());
    }

}
