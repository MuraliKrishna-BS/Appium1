package Post1;

import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import javax.swing.JList;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;


class Base1{
	
	public AndroidDriver Driver;
	
	@BeforeClass
	public void ADriver() throws IOException, URISyntaxException {
		 
		Properties p = new Properties();
		FileReader fr = new FileReader(".\\src\\test\\resources\\myconstants.properties");
		p.load(fr);
		
		String path= p.getProperty("Path");
		String name= p.getProperty("DeviceName");
		String url= p.getProperty("Server");
		Boolean NoResetStatus= p.containsValue("NoReset");
		
		UiAutomator2Options op = new UiAutomator2Options();
		op.setApp(path);
		op.setDeviceName(name);
		op.setNoReset(NoResetStatus);
		
		  Driver = new AndroidDriver(new URI(url).toURL(),op);
		
	}
	
}


public class P9 extends Base1 {
	
	 
	 
	 @Test
	 public void Base_P9() throws IOException, URISyntaxException {
	 
				Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				
				Driver.findElement(AppiumBy.accessibilityId("App")).click();
				Driver.findElement(AppiumBy.accessibilityId("Activity")).click();
				Driver.findElement(AppiumBy.accessibilityId("Animation")).click();
				Driver.findElement(AppiumBy.accessibilityId("Fade in")).click();
				
				Driver.findElement(AppiumBy.accessibilityId("List dialog")).click();
				
				WebElement frame = Driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout"));
				System.out.println("Pop-Up Menu Sucessfully Loaded");
				
				WebElement title = Driver.findElement(AppiumBy.id("android:id/alertTitle"));
				System.out.println("Pop-Up Menu Header Title: " +title.getText());
				
				List<WebElement> elements = Driver.findElements(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\"]"));
				
				System.out.println("Total number of Elements: "+elements.size());
				int i ;
				for ( i = 1; i < elements.size(); i++) {
					
					if(i!=1) {
						Driver.findElement(AppiumBy.accessibilityId("List dialog")).click();
					}
					
					
						
					
					WebElement Element = Driver.findElement(
							AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\"]["+i+"]"));
					System.out.println("Expected Text: " + Element.getText());
					String Expected = Element.getText();
					Element.click();
					WebElement cfm = Driver.findElement(AppiumBy.id("android:id/message"));
					System.out.println("Confirmation Message on selection" + cfm.getText());
					String[] cmsg = cfm.getText().split(",");
					System.out.println("Actual Text: " + cmsg[1]);
					Assert.assertEquals(cmsg[1].trim(), Expected.trim(),
							"Actual: " + cmsg[1] + "Expected: " + Expected);
					for (String ms : cmsg) {

						System.out.println(ms.trim());

					} 
					
					Driver.navigate().back();
				
				}
				
				
	
}

	
	
}
