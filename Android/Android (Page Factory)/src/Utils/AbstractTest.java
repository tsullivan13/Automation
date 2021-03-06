package Utils;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;

import Pages.SplashScreenPage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class AbstractTest {
	
	public static AndroidDriver<MobileElement> driver;
	
	@BeforeClass
	public void beforeMethod() throws MalformedURLException, InterruptedException {
		File appDir = new File("src");
		File app = new File(appDir, "MobileApp.apk");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "100");
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());

	 try {
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
	} catch (MalformedURLException e) {
		e.printStackTrace();
	} 
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	PageFactory.initElements(new AppiumFieldDecorator(driver), new SplashScreenPage());
	
}
}
