package Post1;

import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class P3 {

	public static void main(String[] args) throws URISyntaxException, IOException, NoSuchFieldException, SecurityException {
		
		
		FileReader pfile = new FileReader(".//src//test//resources//myconstants.properties");
		Properties p = new Properties();
		p.load(pfile);

		String path = p.getProperty("Path");
		String DName = p.getProperty("DeviceName");
		String url =p.getProperty("Server");

		
		
		UiAutomator2Options op = new UiAutomator2Options();
		op.setApp(path);
		op.setDeviceName(DName);
		op.setNoReset(true);
		
		AndroidDriver Driver = new AndroidDriver(new URI(url).toURL(),op);
		Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Driver.findElement(AppiumBy.accessibilityId("App")).click();
		Driver.findElement(AppiumBy.accessibilityId("Action Bar")).click();
		Driver.findElement(AppiumBy.accessibilityId("Action Bar Tabs")).click();
		
		WebElement title=Driver.findElement(AppiumBy.className("android.widget.TextView"));
		
		System.out.println("Before Click: "+title.isDisplayed());
		
		
		
		try {
			Driver.findElement(AppiumBy.accessibilityId("Toggle tab mode")).click();
			System.out.println("After Click: "+title.isDisplayed());
		} catch (Exception e) {
			System.out.println("After Click: " +e.getCause());
			
		}
		
		
		

	}

}
