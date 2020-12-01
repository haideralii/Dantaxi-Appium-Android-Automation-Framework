package Tests;

import ScreenObjects.WelcomeScreenObjects;
import com.google.common.io.Files;
import com.microsoft.appcenter.appium.EnhancedAndroidDriver;
import com.microsoft.appcenter.appium.Factory;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;


public class BaseTests {
   // private static EnhancedAndroidDriver<MobileElement> driver;


    private EnhancedAndroidDriver<MobileElement> driver;
    protected WelcomeScreenObjects _welcomeScreen;
    private AppiumDriverLocalService service;

    // To Run on DevOps
    @Rule
    public TestWatcher watcher = Factory.createWatcher();

    public AppiumDriverLocalService startServer() throws IOException {
        boolean _serverStarted = CheckIfServerStarted(4723);
        if (!_serverStarted){
            service = AppiumDriverLocalService.buildDefaultService();
            service.start();
        }
        return service;
    }


    @BeforeTest
    public void killAllNodes() throws IOException {
        Runtime.getRuntime().exec("taskkill /F /IM node.exe");
    }

    @BeforeMethod
    public void setUp() throws IOException, InterruptedException {
        //starting server
        service = startServer();

        FileInputStream _fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\global.properties");
        Properties _prop = new Properties();
        _prop.load(_fis);
        String _appName = (String) _prop.get("DantaxiApp");

        // This line was to get device name from properties file
        //     String _device = (String) _prop.get("DEVICE");

        // This line will be used to get Device name at run time
        String deviceName = System.getProperty("deviceName");

        File _fileFolderPath = new File("src");
        File _filepath = new File(_fileFolderPath, _appName);

         DesiredCapabilities dc = new DesiredCapabilities();

         if (deviceName.contains("emulator")){ startEmulator(); }
         dc.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);

         dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
         dc.setCapability(MobileCapabilityType.APP, _filepath.getAbsolutePath());
         dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");

            // connect to server

        URL url = new URL("http://127.0.0.1:4723/wd/hub");
    //    driver = (EnhancedAndroidDriver<MobileElement>) new AndroidDriver<MobileElement>(url, dc);

        driver = Factory.createAndroidDriver(url, dc);


        _welcomeScreen = new WelcomeScreenObjects(driver);
    }


    public boolean CheckIfServerStarted(int port) throws IOException {
        boolean _isServerRunning = false;
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(port);
            serverSocket.close();
        }catch (IOException e){
            _isServerRunning = true;
        }finally {
            serverSocket = null;
        }
        return _isServerRunning;
    }

    public void startEmulator() throws IOException, InterruptedException {
        Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\src\\main\\resources\\startEmulator.bat");
        Thread.sleep(10000);
    }

    //ScreenShots
    @AfterMethod
    public void recordFailure(ITestResult result){

        if (ITestResult.FAILURE == result.getStatus()){
            TakesScreenshot _camera = (TakesScreenshot)driver;
            File _screenShot = _camera.getScreenshotAs(OutputType.FILE);

            try {
                Files.move(_screenShot, new File("ScreenShots/"  + result.getName() + ".png"));
            }catch (IOException e){
                e.printStackTrace();
            }
        }

        // and stop service
        driver.label("Stopping App");
        service.stop();

    }

}


