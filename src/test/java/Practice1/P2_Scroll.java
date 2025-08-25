package Practice1;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.openqa.selenium.WebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class P2_Scroll {

	public static void main(String[] args) throws MalformedURLException, URISyntaxException {
		
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Small Phone API Baklava");
		options.setApp("C:\\Users\\murali.krishna\\eclipse-workspace\\Practice\\AppiumP1\\src\\test\\resources\\ApiDemos-debug.apk");
		options.setNoReset(true);
	
		
		AndroidDriver Driver = new AndroidDriver(new URI("http://192.168.0.111:4723").toURL(),options);
		Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Just one Scroll
		Driver.executeScript("mobile: scrollGesture", 
				ImmutableMap.of("left", 100, "top", 100, "height", 200, "width", 200,
						"direction", "down" , "percent", 1.0
						));
		
		// Scroll till end
		//	boolean scroll;
//		do {
//			scroll=(boolean)Driver.executeScript("mobile: scrollGesture", 
//				ImmutableMap.of("left", 100, "top", 100, "height", 300, "width", 200, "direction","down", "percent", 1.0));	
//	
//		}while(scroll);
		
		Driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		//Scroll till element
		Driver.findElement(AppiumBy.androidUIAutomator(
			"new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView2\"))"));
		WebElement view=	Driver.findElement(AppiumBy.accessibilityId("WebView2"));
		view.click();
		
	}

}
