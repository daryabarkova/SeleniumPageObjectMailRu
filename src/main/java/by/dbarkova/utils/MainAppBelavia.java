package by.dbarkova.utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainAppBelavia {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"D:\\JAVA Automation\\Lesson 2\\selenium_drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://en.belavia.by/");
		driver.manage().window().maximize();
		
		WebElement originLocation =  driver.findElement(By.id("OriginLocation_Combobox"));
		originLocation.sendKeys("Minsk (MSQ), BY");
		
		WebElement destinationLocation =  driver.findElement(By.id("DestinationLocation_Combobox"));
		destinationLocation.sendKeys("Baku (BAK), AZ");
		
		//List<WebElement> radioGrp = driver.findElements(By.name("JourneySpan"));
		//radioGrp.get(0).click();
		
		WebElement tripType = driver.findElement(By.xpath("//*[@id='step-2']/div[1]/div/input[contains(@id,'JourneySpan_Ow')]"));
		tripType.click();
		
		WebElement fromCalendar = driver.findElement(By.xpath("//div[@id='step-2']/div[2]/div/div/a"));
		fromCalendar.click();
		
		WebElement startDate = driver.findElement(By.linkText("26"));
		startDate.click();
		
		WebElement searchButton = driver.findElement(By.xpath("//*[@id=\'step-2\']/div[4]/div/button"));
		searchButton.click();
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"calendar\"]/p")));
		
		WebElement price = driver.findElement(By.xpath("//*[@id=\'matrix\']/div[7]"));
		
		System.out.println(price.getText());
		
		//List<WebElement> prices = driver.findElements(By.xpath("//*[@id=\"matrix\"]/div"));
		
		//prices.iterator();
		
		driver.close();
		
	}

}

