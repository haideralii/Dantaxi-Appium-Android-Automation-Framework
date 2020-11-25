package Tests.DataProvider;

import org.testng.annotations.DataProvider;

public class DataSetForTest {

    @DataProvider(name = "AlreadyRegisteredPhoneNumberData")
    public Object[] AlreadyRegisteredPhoneNumberData(){
        Object[][] _phoneNumber = new Object[][]
                {
                        {"63636363"}
                };
        return _phoneNumber;
    }

}
