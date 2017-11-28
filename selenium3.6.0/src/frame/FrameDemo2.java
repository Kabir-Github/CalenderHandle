package frame;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameDemo2 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "F:\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.google.com/recaptcha/api2/demo");
		int number = findNumberOfFrame(driver, By.xpath(".//*[@id='recaptcha-anchor']/div[5]"));
		driver.switchTo().frame(number);
		driver.findElement(By.xpath(".//*[@id='recaptcha-anchor']/div[5]")).click();
		driver.switchTo().defaultContent();

		Thread.sleep(6000L);

		int number1 = findNumberOfFrame(driver, By.xpath(".//*[@id='recaptcha-verify-button']"));
		driver.switchTo().frame(number1);
		driver.findElement(By.xpath(".//*[@id='recaptcha-verify-button']")).click();
		driver.switchTo().defaultContent();

	}

	public static int findNumberOfFrame(WebDriver driver, By by) {
		int i;
		int framecount = driver.findElements(By.tagName("iframe")).size();
		for (i = 0; i < framecount; i++) {
			driver.switchTo().frame(i);
			int count = driver.findElements(by).size();
			if (count > 0) {
				break;
			} else {
				System.out.println("Loop continue..");
				System.out.println("Not Present Element into the Website.");
				driver.switchTo().defaultContent();
			}
		}

		driver.switchTo().defaultContent();
		return i;

	}

}
