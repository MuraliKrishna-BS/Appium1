package Practice1;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.openqa.selenium.WebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class P1_LongPress {

	public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {


		UiAutomator2Options option = new UiAutomator2Options();
		option.setDeviceName("Small Phone API Baklava");
		option.setApp("C:\\Users\\murali.krishna\\eclipse-workspace\\Practice\\AppiumP1\\src\\test\\resources\\ApiDemos-debug.apk");
		option.setNoReset(true);
		
		AndroidDriver Driver= new AndroidDriver(new URI("http://127.0.0.1:4723/").toURL(),option);
		Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Driver.executeScript("mobile: swipeGesture", 
				ImmutableMap.of("left", 100, "top", 100, "height", 200, "width", 200, 
						"direction","up", "percent",1.0));
		
		Driver.findElement(AppiumBy.accessibilityId("Views")).click();
		Driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
		Driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();
		WebElement webelemnt=	Driver.findElement(AppiumBy.xpath("//android.widget.Gallery[@resource-id=\"io.appium.android.apis:id/gallery\"]/android.widget.ImageView[1]"));
		
		Driver.executeScript("mobile: longClickGesture", 
				ImmutableMap.of("element", webelemnt , "duration", 2000));
	}

}
