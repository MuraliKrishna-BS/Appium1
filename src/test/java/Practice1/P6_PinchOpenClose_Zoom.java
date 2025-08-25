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

public class P6_PinchOpenClose_Zoom {

	public static void main(String[] args) throws InterruptedException, MalformedURLException, URISyntaxException {
		
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Small Phone API Baklava");
		options.setApp("C:\\Users\\murali.krishna\\eclipse-workspace\\Practice\\AppiumP1\\src\\test\\resources\\ApiDemos-debug.apk");
		options.setNoReset(true);
	
		
		AndroidDriver Driver = new AndroidDriver(new URI("http://192.168.0.111:4723").toURL(),options);
		Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		Driver.executeScript("mobile: scrollGesture", 
				ImmutableMap.of("left", 100, "top", 100, "height", 200, "width", 200,
						"direction", "down" , "percent", 1.0
						));
		
		Driver.findElement(AppiumBy.accessibilityId("Views")).click();
		Driver.findElement(AppiumBy.androidUIAutomator(
			"new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView2\"))"));
		WebElement view=	Driver.findElement(AppiumBy.accessibilityId("WebView2"));
		view.click();
	
		WebElement web=Driver.findElement(AppiumBy.id("io.appium.android.apis:id/wv1"));
		Driver.executeScript("mobile: pinchOpenGesture", 
			ImmutableMap.of("element", web, "percent", 1));
		System.out.println("Zoom In");
	//Switch to Hydride web veiw?
	
		Thread.sleep(Duration.ofSeconds(5));
	
		Driver.executeScript("mobile: pinchCloseGesture", 
			ImmutableMap.of("element", web, "percent", 1));
		System.out.println("Zoom Out");
	}

}
