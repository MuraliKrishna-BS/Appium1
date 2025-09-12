package Post1;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

class P13Base{
	
	public AndroidDriver driver;
	@BeforeClass
	public void Setup() throws MalformedURLException, URISyntaxException {
		
		UiAutomator2Options cap = new UiAutomator2Options();
		cap.setPlatformName("Android");
		cap.setAutomationName("UiAutomator2");
		//cap.setDeviceName("Small_Phone");
		cap.setUdid("ZD2225Q2ZS");
		//cap.setCapability("appium:avd", "Small_Phone");
//		cap.setAppPackage("in.amazon.mShop.android.shopping");
//		cap.setAppActivity("com.amazon.mShop.navigation.MainActivity");
		
		//cap.setAppActivity("com.phonepe.app.ui.activity.Navigator_OldMainActivity");
		cap.setNoReset(true);
		
		driver =new AndroidDriver(new URI("http://MURALI-LAPTOP:4723").toURL(),cap);
		
		
	}
	
}

public class P13 extends P13Base {
	
	@Test
	public void FP13() throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.activateApp("in.amazon.mShop.android.shopping");
		driver.findElement(AppiumBy.id("in.amazon.mShop.android.shopping:id/chrome_search_hint_view")).click();
		driver.findElement(AppiumBy.id("in.amazon.mShop.android.shopping:id/rs_search_src_text")).sendKeys("Mobile");
		Thread.sleep(Duration.ofSeconds(2));
		driver.findElement(AppiumBy.id("in.amazon.mShop.android.shopping:id/rs_search_src_text"));
		


	}

}
