package Practice1;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;

import com.google.common.collect.ImmutableMap;
import com.google.common.io.Files;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class P4_Native_Hybride {
	
	public static void main(String[] args) throws URISyntaxException, InterruptedException, IOException {
		
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
	
	//Switch to Hydride web veiw?
	
	Thread.sleep(Duration.ofSeconds(5));
	
	Driver.executeScript("mobile: pinchCloseGesture", 
			ImmutableMap.of("element", web, "percent", 1));
	
	Set<String> contxt = Driver.getContextHandles();
	
	for(String cont:contxt) {
		
		System.out.println("Context" +cont);
	}
	
	Driver.context("WEBVIEW_io.appium.android.apis");
	
	//hybried web view
	WebElement tbox =Driver.findElement(By.id("i_am_a_textbox"));
	tbox.clear();
	tbox.sendKeys("MURALIKRISHNA");
	Thread.sleep(Duration.ofSeconds(10));
	Driver.context("NATIVE_APP");
	Thread.sleep(Duration.ofSeconds(5));
	Driver.navigate().back();
	Driver.navigate().back();
	
	File f=Driver.getScreenshotAs(OutputType.FILE);

Files.copy(f, new File("c:\\"));
	
	
	
	
	
		
		
	}

}
