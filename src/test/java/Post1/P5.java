package Post1;

import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class P5 {
	
	@Test
	public void MP5() throws URISyntaxException, IOException {
		
		
		String Path, Device, url;
		
		Properties P = new Properties() ;
		FileReader fr = new FileReader(".\\src\\test\\resources\\myconstants.properties");
		P.load(fr);
		
		Path= P.getProperty("Path");
		Device= P.getProperty("DeviceName");
		url= P.getProperty("Server");
		
		
		UiAutomator2Options Op = new UiAutomator2Options();
		Op.setApp(Path);
		Op.setDeviceName(Device);
		Op.setNoReset(true);
		
		AndroidDriver Driver = new AndroidDriver(new URI(url).toURL(),Op);
		
		Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Driver.findElement(AppiumBy.accessibilityId("App")).click();
		Driver.findElement(AppiumBy.accessibilityId("Action Bar")).click();
		Driver.findElement(AppiumBy.accessibilityId("Display Options")).click();
		
		
		WebElement NavUp =Driver.findElement(AppiumBy.accessibilityId("DISPLAY_HOME_AS_UP"));
		
		
		for (int i = 0; i < 3; i++) {
			NavUp.click();
			
			try {
				WebElement Status = Driver.findElement(AppiumBy.accessibilityId("Navigate up"));

				Assert.assertEquals(Status.isDisplayed(), true);
				System.out.println("Navigate Up Button is Visable");

			} 	
				catch (NoSuchElementException e) {

				System.out.println("Navigate Up Button is not Visable");
				
			} 
			catch (Exception e) {

				System.out.println("Other Exception" + e);
				
			} 
		}
		
		
	}

}
