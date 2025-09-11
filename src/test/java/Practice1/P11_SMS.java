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

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

class BaseP11{
	
	public AndroidDriver driver;
	public Properties p;
	public String Activity, Package, Name, url;
	
	@BeforeClass
	public void setup() throws URISyntaxException, IOException {
		
		p= new Properties();
		FileReader fr = new FileReader(".\\src\\test\\resources\\myconstants.properties");
		p.load(fr);
		
		Name= p.getProperty("DeviceName");
		url= p.getProperty("Server");
		Activity = p.getProperty("Activity");
		Package = p.getProperty("Package");
		
		UiAutomator2Options cap = new UiAutomator2Options();
		cap.setDeviceName(Name);
		cap.setNoReset(true);
		
		driver = new AndroidDriver(new URI(url).toURL(),cap);
		
	}
}

public class P11_SMS extends BaseP11 {
	
	@Test
	public void FP11() {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.openNotifications();
		driver.sendSMS("2233445566", "Test SMS Sending 33440");
		System.out.println("Present Orientation: "+driver.getOrientation());
		
		driver.activateApp(Package);
		driver.rotate(ScreenOrientation.LANDSCAPE);

;
		
		
	}

}
