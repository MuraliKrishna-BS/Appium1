package Post1;

import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class p4 {

	@Test
	public  void Practice4() throws URISyntaxException, IOException {

		String path,Dname,Server;
		Properties pr = new Properties();
		FileReader fr = new FileReader(".\\src\\test\\resources\\myconstants.properties");
		pr.load(fr);
		
		path = pr.getProperty("Path");
		Dname = pr.getProperty("DeviceName");
		Server = pr.getProperty("Server");
		
		UiAutomator2Options op = new UiAutomator2Options();
		op.setApp(path);
		op.setDeviceName(Dname);
		op.setNoReset(true);
		
		AndroidDriver Driver = new AndroidDriver(new URI(Server).toURL(),op);
		
		Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Driver.findElement(AppiumBy.accessibilityId("App")).click();
		Driver.findElement(AppiumBy.accessibilityId("Action Bar")).click();
		Driver.findElement(AppiumBy.accessibilityId("Action Bar Usage")).click();
		
		Driver.findElement(AppiumBy.accessibilityId("More options")).click();
			
			try {
				WebElement listscreen = Driver.findElement(AppiumBy.className("android.widget.ListView"));
			} catch (Exception e) {
				Assert.fail("Exception Class: " +e.getClass().getName());
				
			}
			
		
		
		


	}

}
