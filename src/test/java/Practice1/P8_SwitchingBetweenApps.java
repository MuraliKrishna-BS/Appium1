package Practice1;

import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Properties;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

class P8BaseClass{
	
	public AndroidDriver driver;
	
	@BeforeClass
public void P8SwitchApps() throws IOException, URISyntaxException {
		
		Properties P = new Properties();
		FileReader fr = new FileReader(".\\src\\test\\resources\\myconstants.properties");
		P.load(fr);
		
		String Name = P.getProperty("DeviceName");
		String Package = P.getProperty("Package");
		String Activity = P.getProperty("Activity");
		Boolean NoResetStatus = P.contains("NoReset");
		String Server =P.getProperty("Server");
		
		UiAutomator2Options op= new UiAutomator2Options()
		.setDeviceName(Name)
		.setAppPackage(Package)
		.setAppActivity(Activity)
		.setNoReset(NoResetStatus);
		
		 driver = new AndroidDriver(new URI(Server).toURL(),op);
		
		
		
		
	}

}

public class P8_SwitchingBetweenApps extends P8BaseClass {
	
	@Test
	public void P8FSwithcBetweenApps() {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(AppiumBy.accessibilityId("App")).click();
		
		
		
		driver.executeScript("mobile: startActivity", 
				ImmutableMap.of("intent","com.google.android.deskclock / com.android.deskclock.DdeskClock"));
		
		
		
	}
	

}
