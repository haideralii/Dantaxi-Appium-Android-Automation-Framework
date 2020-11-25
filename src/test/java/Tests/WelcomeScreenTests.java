package Tests;

import org.testng.annotations.Test;

public class WelcomeScreenTests extends BaseTests {


    @Test
    public void VerifyGetStartedBtnTest(){ _welcomeScreen.TapGetStartedBtn(); }

    @Test
    public void VerifyLoginAsAnonymousUserBtnTest(){
        _welcomeScreen.TapLoginAsAnonymousUserBtn();
    }
}
