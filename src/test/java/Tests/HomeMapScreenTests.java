package Tests;

import ScreenObjects.HomeMapScreenObjects;
import org.testng.annotations.Test;

public class HomeMapScreenTests extends BaseTests {

    @Test
    public void VerifyDenySystemLocationAccessTest(){
       HomeMapScreenObjects _homeMapScreen = _welcomeScreen.TapLoginAsAnonymousUserBtn();
       _homeMapScreen.TapOnDenyOptionOfSystemLocationAccess();
    }

    @Test
    public void VerifyFullScreenCloseTest(){
       HomeMapScreenObjects _homeMapScreen = _welcomeScreen.TapLoginAsAnonymousUserBtn();
        _homeMapScreen.TapOnDenyOptionOfSystemLocationAccess();
        _homeMapScreen.TapOnCloseIconOfFullScreenPopup();
}

}
