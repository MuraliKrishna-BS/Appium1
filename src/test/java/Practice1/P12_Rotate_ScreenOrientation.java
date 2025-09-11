package Practice1;

import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.ScreenOrientation;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

class P12Base{
	public AndroidDriver driver;
	public Properties p;
	public String Name,Activity,Package,url;
	
	@BeforeClass
	public void SetUp() throws URISyntaxException, IOException {
		
		p= new Properties();
		FileReader r = new FileReader(".\\src\\test\\resources\\myconstants.properties");
		p.load(r);
		Name = p.getProperty("DeviceName");
		Activity=p.getProperty("Activity");
		Package=p.getProperty("Package");
		url=p.getProperty("Server");
		
		
		UiAutomator2Options cap = new UiAutomator2Options();
		cap.setPlatformName("android");
		cap.setAutomationName("UiAutomator2");
		cap.setCapability("appium:avd", "Small_Phone");
		cap.setDeviceName("Small_Phone");
		cap.setAppPackage(Package);
		cap.setAppActivity(Activity);
		
		cap.setOrientation(ScreenOrientation.LANDSCAPE); //Changing the orientation in Capabilities
		
		cap.setDeviceName(Name);
		cap.setNoReset(true);
		
		driver = new AndroidDriver(new URI(url).toURL(),cap);
		
	}
}

public class P12_Rotate_ScreenOrientation extends P12Base {
	@Test
	public void FP12() throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(AppiumBy.accessibilityId("App")).click();
		driver.rotate(ScreenOrientation.PORTRAIT); //Changing the orientation runtime
		Thread.sleep(Duration.ofSeconds(10));
		driver.terminateApp(Package);
		driver.quit();
	}

}
