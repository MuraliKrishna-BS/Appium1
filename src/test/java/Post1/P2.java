package Post1;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class P2 {

	public static void main(String[] args) throws MalformedURLException, URISyntaxException, InterruptedException {

		UiAutomator2Options op = new UiAutomator2Options();
		op.setApp("C:\\Users\\murali.krishna\\eclipse-workspace\\Practice\\AppiumP1\\src\\test\\resources\\ApiDemos-debug.apk");
		op.setDeviceName("Small_Phone_API_Baklava");
		op.setNoReset(true);
		
		AndroidDriver Driver = new AndroidDriver(new URI("http://192.168.0.107:4723").toURL(),op);
		Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Driver.findElement(AppiumBy.accessibilityId("App")).click();
		Driver.findElement(AppiumBy.accessibilityId("Action Bar")).click();
		Driver.findElement(AppiumBy.accessibilityId("Action Bar Mechanics")).click();
		
		
		Driver.findElement(AppiumBy.accessibilityId("Action Button")).click();
		
		WebElement tstmsg = Driver.findElement(AppiumBy.xpath("//android.widget.Toast"));
		System.out.println(tstmsg.getText());
		
		
		
		Driver.findElement(AppiumBy.accessibilityId("More options")).click();
		Driver.findElement(AppiumBy.id("android:id/title")).click();
		Thread.sleep(Duration.ofSeconds(1));
		WebElement tstmsg1 = Driver.findElement(AppiumBy.xpath("//android.widget.Toast"));
		System.out.println(tstmsg1.getText());
		
		

	}

}
