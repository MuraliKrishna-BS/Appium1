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

public class P5 {

	public static void main(String[] args) throws MalformedURLException, URISyntaxException {


		UiAutomator2Options option = new UiAutomator2Options();
		option.setDeviceName("Small Phone API Baklava");
		option.setApp("C:\\Users\\murali.krishna\\eclipse-workspace\\Practice\\AppiumP1\\src\\test\\resources\\ApiDemos-debug.apk");
		option.setNoReset(true);
		
		AndroidDriver Driver = new AndroidDriver(new URI("http://192.168.0.111:4723").toURL(), option);
		Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		Driver.executeScript("mobile: scrollGesture", 
				ImmutableMap.of("left",100, "top",100 , "height", 200, "width",200,
						"direction", "down", "percent", 1
						));
		
		Driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		Driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"ImageView\"))"));
	
		Driver.findElement(AppiumBy.accessibilityId("ImageView")).click();
		
		WebElement image1 = Driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(0)"));
		
		Driver.executeScript("mobile: pinchOpenGesture", 
				ImmutableMap.of("element",image1, "percent",1));
		
		

	}

}
