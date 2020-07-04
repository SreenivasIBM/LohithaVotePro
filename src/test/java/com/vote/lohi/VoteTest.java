package com.vote.lohi;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VoteTest {

	public static WebDriver driver;
	@Test
	public void voteTest()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("http://mycutebaby.in/contest/participant/?n=5edd313ba9a6d&utm_source=wsapp_share_status&utm_campaign=June_2020&utm_medium=shared&utm_term=wsapp_shared_5edd313ba9a6d&utm_content=participant");
		try {
			Thread.sleep(10000);
			WebElement v_button = driver.findElement(By.id("vote_btn"));
			v_button.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(driver.findElement(By.xpath("//*[@id='vote_msg' and contains(.,'Thank You For Vote!')]")).getText());
		driver.close();
	}
}