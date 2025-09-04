package Post1;

import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;


class BaseP10{
	
	static  AndroidDriver driver;
	
	@BeforeClass
	public void BP10() throws URISyntaxException, IOException {
		
		Properties p = new Properties();
		FileReader fr = new FileReader(".\\src\\test\\resources\\myconstants.properties");
		p.load(fr);
		
		String AppPath= p.getProperty("Path");
		String DName = p.getProperty("DeviceName");
		Boolean NoResetStatus = p.containsValue("NoReset");
		String url = p.getProperty("Server");
		
		UiAutomator2Options op = new UiAutomator2Options();
		op.setApp(AppPath);
		op.setDeviceName(DName);
		op.setNoReset(NoResetStatus);
		
		 driver = new AndroidDriver(new URI(url).toURL(),op);
		 
	}
	
	
	
}

class ReuseCode extends BaseP10{
	
	public void SelectionStatus() {
		
		WebElement Map = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Map\")"));
		WebElement Sat = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Satellite\")"));
		WebElement Tra = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Traffic\")"));
		WebElement Str = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Street view\")"));
		
		System.out.println("Status of Selected :\n ");		
		System.out.println("Map option: "+Map.getAttribute("checked"));
		System.out.println("Satellite option: "+Sat.getAttribute("checked"));
		System.out.println("Traffic option: "+Tra.getAttribute("checked"));
		System.out.println("Street view: "+Str.getAttribute("checked"));
	}
}

public class P10 extends BaseP10{
	
	
	
	@Test
	public void FP10() throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(AppiumBy.accessibilityId("App")).click();
		driver.findElement(AppiumBy.accessibilityId("Activity")).click();
		driver.findElement(AppiumBy.accessibilityId("Animation")).click();
		driver.findElement(AppiumBy.accessibilityId("Fade in")).click();
		
		
		driver.findElement(AppiumBy.accessibilityId("Single choice list")).click();
		
		WebElement Map = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Map\")"));
		WebElement Sat = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Satellite\")"));
		WebElement Tra = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Traffic\")"));
		WebElement Str = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Street view\")"));
		
		ReuseCode reuse = new ReuseCode();
		
		System.out.println("By Default Map is Selected");
		
		reuse.SelectionStatus();
		
		Thread.sleep(Duration.ofSeconds(2));
		
		
		System.out.println("\nSelect Satellite option: ");
		Sat.click();
		
		System.out.println("Selected Satellite option");
		
		System.out.println("Status of Selected :\n ");		
		reuse.SelectionStatus();
		
		Thread.sleep(Duration.ofSeconds(2));
		
		System.out.println("\nSelect Traffic option: ");
		Tra.click();
		
		System.out.println("Selected Traffic option");
		
		System.out.println("Status of Selected :\n ");		
		reuse.SelectionStatus();
		
		Thread.sleep(Duration.ofSeconds(2));
		
		System.out.println("\nSelect Street option: ");
		Str.click();
		
		System.out.println("Selected Street option");
		
		System.out.println("Status of Selected :\n ");		
		reuse.SelectionStatus();
		
		Thread.sleep(Duration.ofSeconds(4));
		
		System.out.println("Click on OK ");		
		driver.findElement(AppiumBy.id("android:id/button1")).click();
		System.out.println("Clickec OK ");	
		
	}

}
