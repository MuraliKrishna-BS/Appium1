package Practice1;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class P7_DragDrop {

	public static void main(String[] args) throws MalformedURLException, URISyntaxException {
		UiAutomator2Options option = new UiAutomator2Options();
		option.setDeviceName("Small Phone API Baklava");
		option.setApp("C:\\Users\\murali.krishna\\eclipse-workspace\\Practice\\AppiumP1\\src\\test\\resources\\ApiDemos-debug.apk");
		option.setNoReset(true);
		
		AndroidDriver Driver= new AndroidDriver(new URI("http://192.168.0.111:4723").toURL(),option);
		Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Driver.executeScript("mobile: swipeGesture", 
				ImmutableMap.of("left", 100, "top", 100, "height", 200, "width", 200, 
						"direction","up", "percent",1.0));
		
		Driver.findElement(AppiumBy.accessibilityId("Views")).click();

		Driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Drag and Drop\"))"));
		
		
		Driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
		
		WebElement DragElement=Driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));
		WebElement DropElement=Driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_2"));
		
		Point Ldot1 = DropElement.getLocation();
		Dimension Ddot1=DropElement.getSize();
		Point P1 = new Point(Ldot1.x+Ddot1.getWidth()/2,Ldot1.y+Ddot1.getWidth()/2 );
		int x =Ldot1.x+Ddot1.getWidth()/2;
		int y =Ldot1.y+Ddot1.getWidth()/2 ;
		
		System.out.println("Point :"+P1 +"\n X Cordinate:" +x+ "  Y Cordinate:" +y);
		
		Driver.executeScript("mobile: dragGesture", 
		ImmutableMap.of("element", DragElement, "endX",x ,"endY",y));

	}

}
