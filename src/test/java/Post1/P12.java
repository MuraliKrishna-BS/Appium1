package Post1;

import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

class BaseP12{
	
	public AndroidDriver driver;
	
	@BeforeClass
	public void BP12() throws URISyntaxException, IOException {
		
		
		Properties p = new Properties();
		FileReader fr = new FileReader(".\\src\\test\\resources\\myconstants.properties");
		p.load(fr);
		
		String url = p.getProperty("Server");
		String Name = p.getProperty("DeviceName");
		Boolean NoResetStatus = p.contains("NoReset");
		String Package = p.getProperty("Package");
		String Activity = p.getProperty("Activity");
		
		
		
		UiAutomator2Options op = new UiAutomator2Options();
		op.setAppPackage(Package);
		op.setAppActivity(Activity);
		
		
		//op.setApp(Path);
		op.setDeviceName(Name);
		op.setNoReset(NoResetStatus);
		
		driver = new AndroidDriver(new URI(url).toURL(),op);


	}
}

public class P12 extends BaseP12 {
	
	@Test
	public void FP12() throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(AppiumBy.accessibilityId("App")).click();
		driver.findElement(AppiumBy.accessibilityId("Activity")).click();
		driver.findElement(AppiumBy.accessibilityId("Finish Affinity")).click();
		
		WebElement seq=driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"io.appium.android.apis:id/seq\")"));
		
		String[] count1 = seq.getText().split(":");
		
		System.out.println("Count Before Click: " +count1[1]);
		
		for (int i = 1; i <= 5; i++) {
			driver.findElement(AppiumBy.accessibilityId("Nest some more")).click();
			Thread.sleep(Duration.ofSeconds(3));
			String[] count2 = seq.getText().split(":");
			System.out.println("Count After "+i+" Click: " + count2[1]);
		}
	}

}
