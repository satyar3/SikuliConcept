package com.qa.main;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.basics.Settings;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Finder;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class YoutubeVideoTest {

	public static void main(String[] args) throws FindFailed, InterruptedException, IOException {
		
		// Refer below link for sikuli exapmles :		 * 
		// https://www.programcreek.com/java-api-examples/index.php?api=org.sikuli.basics.Setting 		 

		System.setProperty("webdriver.chrome.driver", "src\\main\\java\\com\\qa\\exe\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//driver.get("https://www.flipkart.com");
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
		
		Pattern skip = new Pattern("Skip_AD.PNG");
		screen.wait(pauseImg, 2000);
		screen.click();
		screen.click();
		
		Pattern sale = new Pattern("Sale.PNG");
		
		//Code to compare images
		//Comparison is happening based on the patterns		
		Finder f = new Finder(pauseImg.getImage());
		f.find(pauseImg);
		if(f.hasNext())
		{
			Match m = f.next();
			System.out.println("Image matched with "+(m.getScore()*100)+"%");
		}
		else
		{
			System.out.println("No Match between two images");
		}
		
		
		//Code to find image in a screenshot
			
		BufferedImage sc = screen.capture().getImage();
		
		Finder f2 = new Finder(sc);
		f.find(pauseImg);
		if(f.hasNext())
		{
			Match m = f.next();
			System.out.println("Image found in screenshot "+(m.getScore()*100)+"%");
			f2.destroy(); 
		}
		else
		{
			System.out.println("No Match found in screenshot");
		}
		
		
		//Code to read text from an image
		Settings.OcrTextSearch = true;
		Settings.OcrTextRead = true;
		Pattern skipad = new Pattern("Skip_AD.PNG");
		
		if(screen.exists(skipad) != null)
		{
			System.out.println("Text in the image is : "+screen.find(skipad).text());
		}
		else
		{
			System.out.println("No Text in the image");
		}
		
	}

}
