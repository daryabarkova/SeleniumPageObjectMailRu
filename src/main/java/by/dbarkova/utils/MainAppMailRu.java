package by.dbarkova.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainAppMailRu {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\JAVA Automation\\Lesson 2\\selenium_drivers\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://mail.ru/");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("mailbox:login")).sendKeys("bdw89");
		driver.findElement(By.id("mailbox:password")).sendKeys("2705223");
		driver.findElement(By.xpath("//*[@id='mailbox:submit']/input")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'b-toolbar__left\']/div/div/div[2]/div/a/span")));
		
		driver.findElement(By.xpath("//*[@id=\'b-toolbar__left\']/div/div/div[2]/div/a/span")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@id,'composeForm')]/div[1]/div/div[3]/div[4]/div/div/div[2]/div/input")));
		
		driver.findElement(By.xpath("//*[contains(@id,'composeForm')]/div[1]/div/div[3]/div[4]/div/div/div[2]/div/input")).sendKeys("lalala");
		driver.findElement(By.xpath("//*[contains(@id,'composeForm')]/div[1]/div/div[3]/div[1]/div/div/div[2]/div/div/div/textarea[2]")).sendKeys("a_shimanovich@inbox.ru");
		
		driver.switchTo().frame(driver.findElement(By.xpath("//*[contains(@id,'composeEditor_ifr')]")));
		WebElement eMessageBody = driver.findElement(By.id("tinymce"));
		eMessageBody.sendKeys("lalalalalalalalalalalalalalalalalala");
		driver.switchTo().defaultContent();
		
		driver.findElement(By.xpath("//*[@id=\"b-toolbar__right\"]/div[3]/div/div[2]/div[1]/div/span")).click();
		
		System.out.println("The message has been sent");
	
		driver.findElement(By.xpath("//*[@id=\'b-nav_folders\']/div/div[4]/a/span")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"b-letters\"]/div/div[5]/div/div[2]/div[2]/div/a/div[4]/div[2]/div[2]")));
	
		String recipient = driver.findElement(By.xpath("//*[@id=\"b-letters\"]/div/div[5]/div/div[2]/div[2]/div/a/div[4]/div[2]/div[2]")).getText();
		System.out.println(recipient);
		
		String subject = driver.findElement(By.xpath("//*[@id=\"b-letters\"]/div/div[5]/div/div[2]/div[1]/div/a/div[4]/div[2]/div[1]/div")).getText();
		System.out.println(subject);
		
		driver.close();
	}

}
