package Post1;

import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;

class P13Base{
	
	public AndroidDriver driver;
	public Properties p;
	public String Platform,Autmation,Name,Udid,url;
	
	@BeforeClass
	public void Setup() throws URISyntaxException, IOException {
		
		Boolean NoReset ;		 
		p= new Properties();
		FileReader r = new FileReader(".\\src\\test\\resources\\myconstants.properties");
		p.load(r);
		Platform = p.getProperty("Platform_Name");
		Autmation = p.getProperty("Automation_Name");
		Name = p.getProperty("DeviceName");
		Udid = p.getProperty("Udid");
		NoReset = p.contains("NoReset");
		url=p.getProperty("Server");
		
		
		UiAutomator2Options cap = new UiAutomator2Options();
		cap.setPlatformName(Platform);
		cap.setAutomationName(Autmation);
		cap.setUdid(Udid);
		//cap.setCapability("appium:avd", Name);
//		cap.setAppPackage("in.amazon.mShop.android.shopping");
//		cap.setAppActivity("com.amazon.mShop.navigation.MainActivity");
		
		//cap.setAppActivity("com.phonepe.app.ui.activity.Navigator_OldMainActivity");
		cap.setNoReset(true);
		
		driver =new AndroidDriver(new URI(url).toURL(),cap);
		
		
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
		WebElement search=driver.findElement(AppiumBy.id("in.amazon.mShop.android.shopping:id/rs_search_src_text"));
		//search.sendKeys(Keys.ENTER); //Not working
		Actions act = new Actions(driver);
		//act.sendKeys(Keys.ENTER).build().perform(); //working

		KeyEvent ke = new KeyEvent(AndroidKey.ENTER);
		driver.pressKey(ke); //Working
		
		WebElement Item= driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"iPhone 16 Pro 128 GB: 5G Mobile Phone with Camera Control, 4K 120 fps Dolby Vision and a Huge Leap in Battery Life. Works with AirPods; Desert Titanium\"]"));
		
		Item.click();
	}

}
