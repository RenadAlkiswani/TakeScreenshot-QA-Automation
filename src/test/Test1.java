package test;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class Test1 {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver","E:\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://127.0.0.1:5500/index.html");
		List <WebElement> theStudents = driver.findElements(By.tagName("option"));
		for (int i=0 ;i<theStudents.size() ; i++) {
			if ( i%2!=0 ) {
			System.out.println("Keep "+theStudents.get(i).getText());
				}
			else  if (i==0 |i%2==0){
				theStudents.get(i).click();
				System.err.println("Delet "+theStudents.get(i).getText());
				driver.findElement(By.xpath("//*[@id=\"remove\"]")).click();
			} 
		}
		Date date = new Date();
		String newDate = date.toString().replace(":", "-");
		TakesScreenshot src = ((TakesScreenshot)driver);
		File srcFile = src.getScreenshotAs(OutputType.FILE);
		File desFile = new File(".//img//"+newDate+".png");
		FileUtils.copyFile(srcFile, desFile);
		}
	}
			
				
		
	


