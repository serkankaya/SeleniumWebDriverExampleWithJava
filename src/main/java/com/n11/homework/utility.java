package com.n11.homework;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class utility {
	static String webSiteMainUrl="http://www.n11.com";
	static WebDriver driver;
	static String selectedFavoriteProduct;
	static boolean deletedFavorite=false;
	static int favoriesCount=0;
	static int willDeleteFavorite=0;
	
	@BeforeClass
	public static void setUp(){
		System.setProperty("webdriver.gecko.driver", "/home/host/Downloads/geckodriver");
		driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterClass
	public static void tearDown() throws InterruptedException{
		Thread.sleep(3000);
		driver.quit();
	}

}
