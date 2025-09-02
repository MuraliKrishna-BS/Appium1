package Post1;

import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class P8 {
	
	@Test
	public void MP8() throws IOException, URISyntaxException {
		
		Properties p = new Properties();
		FileReader fr = new FileReader("C:\\Users\\Muralikrishna\\git\\Appium1\\src\\test\\resources\\myconstants.properties");
		p.load(fr);
		
		String Path = p.getProperty("Path");
		String Name = p.getProperty("DeviceName");
		String url = p.getProperty("Server");
		boolean status = p.containsValue("NoReset");
		
		System.out.println(status);
		
		
		UiAutomator2Options op = new UiAutomator2Options();
		op.setApp(Path);
		op.setDeviceName(Name);
		op.setNoReset(status);
		
		AndroidDriver Driver = new AndroidDriver(new URI(url).toURL(),op);
		
		Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		Driver.findElement(AppiumBy.accessibilityId("App")).click();
		Driver.findElement(AppiumBy.accessibilityId("Activity")).click();
		Driver.findElement(AppiumBy.accessibilityId("Animation")).click();
		Driver.findElement(AppiumBy.accessibilityId("Fade in")).click();
		
		
		
		
		
		try {
			 
			for (int i = 1; i <= 3; i++) {
				Driver.findElement(AppiumBy.accessibilityId("OK Cancel dialog with ultra long message")).click();
				Driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout"));
				System.out.println("Pop Frame Appeared Successfully");
				WebElement title = Driver.findElement(AppiumBy.id("android:id/alertTitle"));
				System.out.println("Title of Frame: " + title.getText());
				WebElement Message = Driver.findElement(AppiumBy.id("android:id/message"));
				System.out.println("############# MESSAGE ##############");
				System.out.println("Title of Frame: \n" + Message.getText());
				System.out.println("############# MESSAGE END ##############");
				
				
				
				switch(i)  {
					
				case 1 : WebElement Something = Driver.findElement(AppiumBy.id("android:id/button3")); 
						Something.click(); 
						System.out.println("Click on Something Button: " );
						break;
				case 2:  WebElement Cancel = Driver.findElement(AppiumBy.id("android:id/button2"));
						Cancel.click(); 
						System.out.println("Click on Cancel Button: " );
						break;
				case 3:  WebElement Ok = Driver.findElement(AppiumBy.id("android:id/button1"));
							Ok.click(); 
							System.out.println("Click on Click Button: " );
							break;
				default:  System.out.println("Not able to find the Pop up buttons to click");
					
					
				}
				
				
			}
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
