package Tests;

import TestResultLoggers.TestResultLogger;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(TestResultLogger.class)
public class BaseTest {

    public AppiumDriver driver;


    @BeforeAll
    public  void setup() throws  Exception{

        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        caps.setCapability(MobileCapabilityType.DEVICE_NAME,"Android");
        caps.setCapability(MobileCapabilityType.UDID,"5200c385ea39352d");
        caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"com.lcwaikiki.android");
        caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"com.lcwaikiki.android.ui.HomeActivity");
        caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 250);

        URL url = new URL("http://localhost:4723/wd/hub");
        driver = new AppiumDriver(url, caps);
        driver.manage().timeouts().implicitlyWait(60L, TimeUnit.SECONDS);

    }

    @AfterAll
    public  void tearDown(){

       // driver.quit();

    }

}
