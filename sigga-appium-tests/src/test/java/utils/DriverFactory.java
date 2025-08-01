package utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class DriverFactory {

    public static AndroidDriver<MobileElement> createDriver() throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "RX8W3084SSY");
        caps.setCapability(MobileCapabilityType.APP_PACKAGE, "com.sigga.eam.empower");
        caps.setCapability(MobileCapabilityType.APP_ACTIVITY, "com.sigga.eam.empower.MainActivity");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

        return new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), caps);
    }
}