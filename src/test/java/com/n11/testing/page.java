package com.n11.testing;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class page extends utility{
	
	public WebElement findByName(String name){
		WebElement Element=driver.findElement(By.name(name));
		return Element;
	}
	public WebElement findByClassName(String name){
		WebElement Element=driver.findElement(By.className(name));
		return Element;
	}
	public WebElement findByXpad(String name){
		WebElement Element=driver.findElement(By.xpath(name));
		return Element;
	}
	public WebElement findById(String name){
		WebElement Element=driver.findElement(By.id(name));
		return Element;
	}
	public List<WebElement> findListByXpad(String name){
		List<WebElement> Element=driver.findElements(By.xpath(name));
		return Element;
	}
	public ExpectedCondition<WebElement> elementClickableByClassName(String name){
		ExpectedCondition<WebElement> clickable=ExpectedConditions.elementToBeClickable((By.className(name)));
		return clickable;
	}
	public ExpectedCondition<WebElement> elementClickableById(String name){
		ExpectedCondition<WebElement> clickable=ExpectedConditions.elementToBeClickable((By.id(name)));
		return clickable;
	}
	public ExpectedCondition<WebElement> elementClickableByXpad(String name){
		ExpectedCondition<WebElement> clickable=ExpectedConditions.elementToBeClickable((By.xpath(name)));
		return clickable;
	}
	public String getElementTextByXpad(String name){
		return driver.findElement(By.xpath(name)).getText();
	}
	public void waitForPageLoad() {

	    Wait<WebDriver> wait = new WebDriverWait(driver, 10);
	    wait.until(new Function<WebDriver, Boolean>() {
	        public Boolean apply(WebDriver driver) {
	            System.out.println("Current Window State       : "
	                + String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState")));
	            return String
	                .valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
	                .equals("complete");
	        }
	    });
	}
}
