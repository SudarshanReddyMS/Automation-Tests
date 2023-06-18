package FunctionalTesting;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class TestCase1_FT {

	public static void main(String[] args) throws IOException, InterruptedException {
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.dealsdray.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("username")).sendKeys("prexo.mis@dealsdray.com");
		driver.findElement(By.name("password")).sendKeys("prexo.mis@dealsdray.com");
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		driver.findElement(By.xpath("//span[@class='sidenavHoverShow css-1s178v5']")).click();
		driver.findElement(By.xpath("//span[text()='Orders'  and  @mode='full']")).click();
		driver.findElement(By.xpath("//button[text()='Add Bulk Orders']")).click();
		driver.findElement(By.xpath("//div[contains(@class,'MuiOutlinedInput-root')]")).click();
		Runtime.getRuntime().exec("./Autoitupload/uploadfile.exe");
		Thread.sleep(10000);
		driver.switchTo().defaultContent();
	    driver.findElement(By.xpath("//button[text()='Import']")).click();
	    WebElement validatebutton=driver.findElement(By.xpath("//button[text()='Validate Data']"));
	    JavascriptExecutor js=(JavascriptExecutor) driver;
	    js.executeScript("arguments[0].click();" ,validatebutton);
	    Thread.sleep(2000);
	    driver.switchTo().alert().accept();
	    System.out.println("done");
	    Thread.sleep(2000);
		TakesScreenshot take=(TakesScreenshot)driver;
		File source=take.getScreenshotAs(OutputType.FILE);
		String timestamp=LocalDateTime.now().toString().replace(':', '-');
		String name="ScreenShotFT "+timestamp;
		System.out.println(timestamp);
		String path="./FunctionalTesting/"+name+".png";
	    File designation=new File(path);
		FileUtils.copyFile(source, designation);
	    Thread.sleep(2000);
	    driver.quit();

	}

}
