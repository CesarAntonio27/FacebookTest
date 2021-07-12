package com.titaniumSolutions.mx;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.github.javafaker.Faker;

public class BasePage {
	//private WebDriver driver;
	Faker faker = new Faker();
	
	public void disableChromenotification() {
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.notifications", 2);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		WebDriver driver = new ChromeDriver(options);
		
	};

	public String generateFullRandomName(){
		String fullName= "";
		
		
		String name = faker.name().fullName();
		String firstName = faker.name().firstName();
		String lastName = faker.name().lastName();
		
		fullName = name + firstName + lastName;
		return fullName;
	};
	
	public String generatefirstRandomName(){
		
		String firstName = faker.name().firstName();
		
		return firstName;
	};
	
	
	public String generateLastRandomName(){
	
		String lastName = faker.name().lastName();
		
		return lastName;
	};
	
	
	
	
	public void waitToElement(int seconds){
		//driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
		/*Wait<WebDriver> fluentwait = new FluentWait<WebDriver>(driver)
			       .withTimeout(seconds, TimeUnit.SECONDS)
			       .pollingEvery(2, TimeUnit.SECONDS)
			       .ignoring(NoSuchElementException.class);
		WebElement Locator = fluentwait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.xpath(locator));
			}
		});*/
	}
	
	/*public void click(String element){
		driver.findElement(By.xpath(element)).click();
	}*/
	
	/*public void sendKeys(String element,String Keys) {
		driver.findElement(By.xpath()).sendKeys();
	};*/
	
	
}
