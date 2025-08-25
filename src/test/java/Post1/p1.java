package Post1;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class p1 {

	public static void main(String[] args) throws MalformedURLException, URISyntaxException, InterruptedException {

		UiAutomator2Options cababilities = new UiAutomator2Options();
		cababilities.setApp("C:\\Users\\murali.krishna\\eclipse-workspace\\Practice\\AppiumP1\\src\\test\\resources\\ApiDemos-debug.apk");
		cababilities.setDeviceName("Small_Phone_API_Baklava");
		cababilities.setNoReset(true);
		
		AndroidDriver Driver = new AndroidDriver(new URI("http://192.168.0.107:4723").toURL(),cababilities);
		
		Driver.findElement(AppiumBy.accessibilityId("Animation")).click();
		
		
		Driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text ( \"View Flip\"))")).click();
		
		//WebElement Ele1=
			//	Driver.findElement(AppiumBy.accessibilityId("View Flip")).click();
				Driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"View Flip\"]")).click();
		//Ele1.click();    									
		
		List<WebElement> items= Driver.findElements(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" ]"));
		System.out.println("Defult Without Clicking Flip");
		for(WebElement itms:items) {
			System.out.println(itms.getText());
		}
		Driver.findElement(AppiumBy.accessibilityId("Flip")).click();
		List<WebElement> item= Driver.findElements(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" ]"));
		System.out.println(" Clicking Flip");
		for(WebElement itms:item) {
			System.out.println(itms.getText());
		}
	}

}
