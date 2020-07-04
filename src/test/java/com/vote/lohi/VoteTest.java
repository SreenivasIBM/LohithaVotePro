package com.vote.lohi;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VoteTest {

	public static WebDriver driver;
	@Test
	public void voteTest() throws IOException, InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("http://mycutebaby.in/contest/participant/?n=5edd313ba9a6d&utm_source=wsapp_share_status&utm_campaign="
				+ "June_2020&utm_medium=shared&utm_term=wsapp_shared_5edd313ba9a6d&utm_content=participant");
		try {
			driver.findElement(By.id("vote_btn")).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
//		try {
//			WebElement fb_popup = driver.findElement(By.id("fb-close"));
//			if(fb_popup.isDisplayed())
//				fb_popup.click();
//			
//			WebElement x_button = driver.findElement(By.xpath("//button[@class='close' and contains(.,'×')]"));
//			WebElement No_button = driver.findElement(By.xpath("//button[contains(.,'No')]"));
//			if(No_button.isDisplayed())
//				No_button.click();
//			else if(x_button.isDisplayed())
//				x_button.click();
//		}
//		catch(Exception e)
//		{
//			WebElement x_button = driver.findElement(By.xpath("//button[@class='close' and contains(.,'×')]"));
//			WebElement No_button = driver.findElement(By.xpath("//button[contains(.,'No')]"));
//			if(No_button.isDisplayed())
//				No_button.click();
//			else if(x_button.isDisplayed())
//				x_button.click();
//			
//			WebElement fb_popup = driver.findElement(By.id("fb-close"));
//			if(fb_popup.isDisplayed())
//				fb_popup.click();
//		}
		
		
		
		Thread.sleep(1000);
		File f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File d = new File(System.getProperty("user.dir")+"/screenShots/"+"Vote.png");
		FileUtils.copyFile(f, d);

		driver.close();
	}
}
