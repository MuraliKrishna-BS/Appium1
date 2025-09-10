package Practice1;

import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Properties;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.GsmCallActions;
import io.appium.java_client.android.options.UiAutomator2Options;

class BaseP10{
	
	public AndroidDriver driver;
	
	@BeforeClass
	public void setup() throws URISyntaxException, IOException {
		
		Properties p = new Properties();
		FileReader r = new FileReader(".\\src\\test\\resources\\myconstants.properties");
		p.load(r);
		
		String Name = p.getProperty("DeviceName");
		String url = p.getProperty("Server");
		
		
		
		UiAutomator2Options cap = new UiAutomator2Options();
		cap.setDeviceName(Name);
		cap.setNoReset(true);
		
		driver = new AndroidDriver(new URI(url).toURL(),cap);
		
		
	}
	
}

public class P10_CallsDemo extends BaseP10 {
	
	@Test
	
	public void FP10() throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.openNotifications();
		Thread.sleep(Duration.ofSeconds(5));
		driver.makeGsmCall("1234567890", GsmCallActions.CALL);
		Thread.sleep(Duration.ofSeconds(10));
		driver.makeGsmCall("1234567890", GsmCallActions.CANCEL);
		
		
	}

}
