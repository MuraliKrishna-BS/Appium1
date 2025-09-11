package Practice1;

import io.appium.java_client.android.options.UiAutomator2Options;

class P13Base{
	
	public void Setup() {
		
		UiAutomator2Options cap = new UiAutomator2Options();
		cap.setPlatformName("Android");
		cap.setAutomationName("UiAutomator2");
		cap.setDeviceName("Small_Phone");
		cap.setNoReset(true);
		//If Application is not installed in device
		cap.setApp(".\\src\\test\\resources\\ApiDemos-debug.apk");
		cap.setAutoGrantPermissions(true);// avoids the popups for permissions
		// if Application is installed in device
		cap.setAppPackage("");
		cap.setAppActivity("");
		
		
		
	}
}

public class P13_Cababilities {

}
