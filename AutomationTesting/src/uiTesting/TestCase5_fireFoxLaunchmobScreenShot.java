package uiTesting;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestCase5_fireFoxLaunchmobScreenShot 
{
	public static void main(String[] args) throws IOException 
	{
		FirefoxDriver driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.getcalley.com/page-sitemap.xml");
		
		Dimension dim=new Dimension(414, 896);
		driver.manage().window().setSize(dim);
		
		TakesScreenshot take=(TakesScreenshot)driver;
		File source=take.getScreenshotAs(OutputType.FILE);
		String timestamp=LocalDateTime.now().toString().replace(':', '-');
		String name="Firefox Windows-414-896 "+timestamp;
		System.out.println(timestamp);
		
		String path="./ScreenShot414×896/"+name+".png";
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
