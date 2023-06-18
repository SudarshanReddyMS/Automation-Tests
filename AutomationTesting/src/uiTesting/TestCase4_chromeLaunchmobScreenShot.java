package uiTesting;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase4_chromeLaunchmobScreenShot 
{
	public static void main(String[] args) throws IOException
	{
		ChromeDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.getcalley.com/page-sitemap.xml");
		
		Dimension dim=new Dimension(360, 640);
		driver.manage().window().setSize(dim);
		
		TakesScreenshot take=(TakesScreenshot)driver;
		File source=take.getScreenshotAs(OutputType.FILE);
		String timestamp=LocalDateTime.now().toString().replace(':', '-');
		String name="chrome Windows-360-640 "+timestamp;
		System.out.println(timestamp);
		
		String path="./ScreenShot360×640/"+name+".png";
	    File designation=new File(path);
		FileUtils.copyFile(source, designation);
		
		String url=driver.getCurrentUrl();
		if(url.equals("https://www.getcalley.com/page-sitemap.xml"))
		{
			System.out.println("TestCase Passed");
		}
		else
		{
			System.out.println("TestCase Failed" );
		}
		driver.close();


	}

}
