package Post1;

import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

class BaseP11{
	
	public AndroidDriver driver;
	
	@BeforeClass
	public void BP11() throws URISyntaxException, IOException {
		
		Properties p = new Properties();
		FileReader fr= new FileReader(".\\src\\test\\resources\\myconstants.properties");
		p.load(fr);
		
		String Path = p.getProperty("Path");
		String Name = p.getProperty("DeviceName");
		Boolean NoResetStatus = p.containsValue("NoReset");
		String url = p.getProperty("Server");
		

		UiAutomator2Options op = new UiAutomator2Options();
		op.setApp(Path);
		op.setDeviceName(Name);
		op.setNoReset(NoResetStatus);
		
		driver = new AndroidDriver(new URI(url).toURL(),op);
		
	}
}


public class P11 extends BaseP11 {
	
	@Test
	public void FP11() {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(AppiumBy.accessibilityId("App")).click();
		driver.findElement(AppiumBy.accessibilityId("Activity")).click();
		driver.findElement(AppiumBy.accessibilityId("Animation")).click();
		driver.findElement(AppiumBy.accessibilityId("Fade in")).click();
		
		driver.findElement(AppiumBy.accessibilityId("Repeat alarm")).click();
		
		WebElement title = driver.findElement(AppiumBy.id("android:id/alertTitle"));
		System.out.println("Title of PopUp: " +title.getText());
		
		String Expectedtitle = "Repeat alarm";
		String Actualtitle =  title.getText();
		
		Assert.assertEquals(Actualtitle, Expectedtitle, "Actual: "+Actualtitle+ "Expected: "+Expectedtitle);
		
		WebElement Mon = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Every Monday\")"));
		WebElement okbtn = driver.findElement(AppiumBy.id("android:id/button1"));
		
		System.out.println(" Every Monday Selection Status before Clicking: " +Mon.getAttribute("checked"));
		Mon.click();
		System.out.println(" Every Monday Selection Status after Clicking: " +Mon.getAttribute("checked"));
		String Actual = Mon.getAttribute("checked");
		okbtn.click();
		driver.findElement(AppiumBy.accessibilityId("Repeat alarm")).click();
		String Expected = Mon.getAttribute("checked");
		System.out.println(" Every Monday Selection Status after Reopening: " +Mon.getAttribute("checked"));
		Assert.assertEquals(Actual, Expected, "BOTH ARE NOT SAME");
		
		
//		for (int i = 1; i <=3; i++) {
//			String MonStatus = Mon.getAttribute("checked");
//			
//			System.out.println("Status of MonStatus:  " +MonStatus);
//			
//			if (MonStatus.equals("true") ) {
//
//				Mon.click();
//				System.out.println("Every Monday UnSelected");
//
//			} else {
//
//				Mon.click();
//				System.out.println("Every Monday Selected");
//			} 
//			
//			
//		}
		
	}

	
	
	
	
	

}
