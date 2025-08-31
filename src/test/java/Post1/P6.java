package Post1;

import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class P6 {
	
	@Test
	public void MP6() throws URISyntaxException, IOException {
		
		Properties p = new Properties();
		FileReader f = new FileReader(".\\src\\test\\resources\\myconstants.properties");
		p.load(f);
		
		String path, name, url;
		
		path= p.getProperty("Path");
		name= p.getProperty("DeviceName");
		url= p.getProperty("Server");
		
		 UiAutomator2Options op = new UiAutomator2Options();
		 op.setApp(path);
		 op.setDeviceName(name);
		 op.setNoReset(true);
		 
		 AndroidDriver Driver = new AndroidDriver( new URI(url).toURL(),op);
		 
		 Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Driver.findElement(AppiumBy.accessibilityId("App")).click();
			Driver.findElement(AppiumBy.accessibilityId("Activity")).click();
			Driver.findElement(AppiumBy.accessibilityId("Animation")).click();
			Driver.findElement(AppiumBy.accessibilityId("Fade in")).click();
			
			Driver.findElement(AppiumBy.accessibilityId("OK Cancel dialog with a message")).click();
			
			try {
				WebElement toppanel = Driver.findElement(AppiumBy.id("android:id/topPanel"));
				WebElement tptxt = Driver.findElement(AppiumBy.id("android:id/alertTitle"));
				System.out.println("Top Panel Available for Action");
				
				System.out.println("\n Top Panel Text is: " +tptxt.getText());
				
				Driver.findElement(AppiumBy.id("android:id/button1")).click();
				
				System.out.println("OK click Done");
				
				Driver.findElement(AppiumBy.accessibilityId("OK Cancel dialog with a message")).click();
				WebElement toppanel1 = Driver.findElement(AppiumBy.id("android:id/topPanel"));
				WebElement tptxt1 = Driver.findElement(AppiumBy.id("android:id/alertTitle"));
				System.out.println("Top Panel Available for Action");
				
				System.out.println("\n Top Panel Text is: " +tptxt1.getText());
				
				Driver.findElement(AppiumBy.id("android:id/button2")).click();
				
				System.out.println("Cancel click Done");
				
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Top Panel Not Available for Action");
			}
			
			
		 
		 
		
		
	}

}
