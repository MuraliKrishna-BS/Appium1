package Practice1;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Base64;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

class BaseP9{
	
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

public class P9_RecordingExecution extends BaseP9 {
	
	@Test
	public void FP9() throws InterruptedException, IOException {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.startRecordingScreen();
		
		Thread.sleep(Duration.ofSeconds(5));
		
		driver.activateApp("io.appium.android.apis");
		
		Thread.sleep(Duration.ofSeconds(5));
		
		driver.findElement(AppiumBy.accessibilityId("App")).click();
		
		String Videodata =  driver.stopRecordingScreen();
		
		Thread.sleep(Duration.ofSeconds(5));
		
		byte[] decode = Base64.getDecoder().decode(Videodata);

		FileUtils.writeByteArrayToFile(new File("RecordingClip2.mp4"), decode);
		
		Thread.sleep(Duration.ofSeconds(5));
		
		driver.terminateApp("io.appium.android.apis");
		driver.quit();
		
	}
	

}
