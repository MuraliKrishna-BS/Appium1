package Practice1;

import org.apache.commons.io.FileUtils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.time.Duration;
import java.util.Base64;
import java.util.Properties;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidStartScreenRecordingOptions;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.screenrecording.BaseStopScreenRecordingOptions;

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
	public void P8FSwithcBetweenApps() throws IOException, InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		Thread.sleep(Duration.ofSeconds(5));
		
		driver.startRecordingScreen();
		
		
		driver.findElement(AppiumBy.accessibilityId("App")).click();
		
		
		
//		driver.executeScript("mobile: startActivity", 
//				ImmutableMap.of("intent","com.google.android.deskclock / com.android.deskclock.DdeskClock"));
		
		driver.activateApp("com.google.android.deskclock");
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.google.android.deskclock:id/navigation_bar_item_content_container\").instance(2)")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.google.android.deskclock:id/play_pause\").instance(0)")).click();
		
		driver.activateApp("io.appium.android.apis");
		
		driver.findElement(AppiumBy.accessibilityId("Activity")).click();
		driver.findElement(AppiumBy.accessibilityId("Finish Affinity")).click();
		
//		Runtime.getRuntime().exec("adb shell am start -a android.intent.action.CALL -d tel:1234567890");

		driver.activateApp("com.phonepe.app");
	//	driver.executeScript("mobile:fingerprint", ImmutableMap.of("fingerprintId",true));
		

		String Videodata = driver.stopRecordingScreen();
		Thread.sleep(Duration.ofSeconds(5));
		
		byte[] decode = Base64.getDecoder().decode(Videodata);

		FileUtils.writeByteArrayToFile(new File("RecordingClip1.mp4"), decode);
        
		
		
	}
	

}
