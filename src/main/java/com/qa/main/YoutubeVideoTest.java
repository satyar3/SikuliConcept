package com.qa.main;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.*;

public class YoutubeVideoTest {

	public static void main(String[] args) throws FindFailed {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "src\\main\\java\\com\\qa\\exe\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.youtube.com/watch?v=qvE2miLMbNk");
		

		//Create object of Screen Class - Sikuli		
		Screen screen = new Screen();		
		Pattern pauseImg = new Pattern("Youtube_Pause.PNG");
		screen.wait(pauseImg, 2000);
		screen.click();
		screen.click();
		
		Pattern playImg = new Pattern("Youtube_Play.PNG");
		screen.wait(pauseImg, 2000);
		screen.click();
		screen.click();
		
		Pattern settingsImg = new Pattern("Youtube_Settings_New.PNG");
		screen.wait(pauseImg, 2000);
		screen.click();
		screen.click();
	}

}
