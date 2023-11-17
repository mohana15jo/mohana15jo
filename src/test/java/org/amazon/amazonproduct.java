package org.amazon;

import java.util.List;
import java.util.Set;

import org.Utilities.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.pom.POM_amazon;

public class amazonproduct extends BaseClass{
	
	public static <WebElelemnet> void main(String[] args) throws InterruptedException  {
		/*
		System.setProperty("WebDriver.Edge.Driver","C:\\Users\\Mohana\\eclipse-workspace\\Selenium_learning\\Browser\\msedgedriver.exe");
		WebDriver drive= new EdgeDriver();
	
		drive.get("https://www.amazon.com/");
		drive.manage().window().maximize();
		Thread.sleep(5000);
		drive.findElement(By.xpath("//input[@type=\"text\"]")).sendKeys("iphone x");
		drive.findElement(By.xpath("//input[@type=\"submit\"]")).click();
		String parent_window = drive.getWindowHandle();
		Set<String> child_windows = drive.getWindowHandles();
		//System.out.println(child_windows);
		for (String next_window : child_windows) {
			if(!next_window.equals(parent_window)) {
				drive.switchTo().window(next_window);
				
			}
		}
		WebElement first_iphone = drive.findElement(By.xpath("(//img[@class=\"s-image\"])[1]"));
		Actions a=new Actions(drive);
		a.contextClick(first_iphone).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		
		String prize = drive.findElement(By.xpath("(//span[@class=\"a-price-whole\"])[1]")).getText();
		
		System.out.println("The mobile prize is: "+prize);
	*/
		
		
		browser_launch();
		passurl("https://www.flipkart.com/");
		maxwindow();
		implicit_wait(20);
		POM_amazon p=new POM_amazon();
		fill(p.getSearch(),"iphone 14");
		click_option(p.getSubmit());
		static_wait(2000);
		click_option(p.getClose());
		
		List<WebElelemnet> mobile=(List<WebElelemnet>) p.getMobiles();
		for(int i=0;i<mobile.size();i++) {
			WebElement mob=(WebElement) mobile.get(i);
			get_text(mob);
			
		}
		
		}
}
