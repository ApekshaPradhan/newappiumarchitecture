package com.pCloudy.testNG;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class LocalRunnerAndroid {

	AppiumDriverLocalService service;
	AppiumDriver<WebElement> driver;
//	RemoteWebDriver driver;
	String folder_name;
	DateFormat df;
	
	@BeforeTest
	public void setUpSuite() throws Exception {
		
	}
		
	@BeforeMethod
	public void prepareTest() throws IOException, InterruptedException {
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		//capabilities.setCapability("pCloudy_ApiEndpoint", "https://device.pcloudy.com");
		capabilities.setCapability("pCloudy_Username", "apeksha.pradhan@sstsinc.com");
		capabilities.setCapability("pCloudy_ApiKey", "jy59zmhzfmg9vfsnp4qyc4sn");
		capabilities.setCapability("pCloudy_ApplicationName", "pCloudyAppiumDemo.apk");
		capabilities.setCapability("pCloudy_DurationInMinutes", 10);
		capabilities.setCapability("pCloudy_DeviceManafacturer", "Samsung");
		//capabilities.setCapability("pCloudy_DeviceVersion", "6.0.1");
		//capabilities.setCapability("pCloudy_DeviceFullName", "Samsung_GalaxyTabA_Android_7.1.1");
		capabilities.setCapability("newCommandTimeout", 600);
		capabilities.setCapability("launchTimeout", 90000);
		//capabilities.setBrowserName("Chrome");
		capabilities.setCapability("appPackage", "com.pcloudy.appiumdemo");
		capabilities.setCapability("appActivity", "com.ba.mobile.LaunchActivity");
		driver = new AndroidDriver(new URL("https://device.pcloudy.com/appiumcloud/wd/hub"), capabilities);
		
	}

	@Test
	public void Test1() throws IOException, InterruptedException {

		//Click on Accept button
        driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.pcloudy.appiumdemo:id/accept']")).click();  
        
        //Click on Flight button
        driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.pcloudy.appiumdemo:id/flightButton']")).click();
        
        //Select from location
        driver.findElement(By.xpath("//android.widget.Spinner[@resource-id='com.pcloudy.appiumdemo:id/spinnerfrom']")).click();
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@resource-id='android:id/text1' and @text='Bangalore, India (BLR)']")).click();
		
		//Select to location
		driver.findElement(By.xpath("//android.widget.Spinner[@resource-id='com.pcloudy.appiumdemo:id/spinnerto']")).click();
        driver.findElement(By.xpath("//android.widget.CheckedTextView[@resource-id='android:id/text1' and @text='Pune, India (PNQ)']")).click();
        
        //Select one way trip
        driver.findElement(By.xpath("//android.widget.RadioButton[@resource-id='com.pcloudy.appiumdemo:id/singleTrip']")).click();
        
        //Select departure time
        driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.pcloudy.appiumdemo:id/txtdepart']")).click();
        driver.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button1' and @text='OK']")).click();
        
        //Click on search flights button
        driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.pcloudy.appiumdemo:id/searchFlights']")).click();
	}

	@AfterMethod
	public void endTest() throws  IOException {

		driver.quit();
	}

	
	public void captureScreenShots() throws IOException {
        folder_name="screenshot";
        File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //Date format fot screenshot file name
        df=new  SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
        //create dir with given folder name
        new File(folder_name).mkdir();
        //Setting file name
        String file_name=df.format(new Date())+".png";
        //coppy screenshot file into screenshot folder.
        FileUtils.copyFile(f, new File(folder_name + "/" + file_name));
    }
}
