#Automation
/** Automate the functionality to book the train from https://www.makemytrip.com/railways/
Check if you have landed in the correct page
Print the URL and Title of the Page
Click on FROM
Enter the city in FROM: DELHI
Click on TO
Enter the city in TO: LUCKNOW 
Click on Travel Date
Select a date: 20 May
Click on class.
Select a class from dropdown: Third AC.
Click on SEARCH Button. **/
  
package project;
import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Question01 {
	public void launchBrowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\koumu\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromeDriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/railways/");
		String title = null;
		System.out.println("title of the page is:" +title);
		String url = driver.getCurrentUrl();
		System.out.println("url is"+url);
		driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div/div/div/div[2]/div/div[1]/label/span")).click();
		Thread.sleep(1000);
		String a="Delhi";
		CharSequence[] b=new CharSequence[] {a};
		driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div/div/div/div[2]/div/div[1]/div/div/div/input")).sendKeys(b);
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		int length=driver.findElements(By.cssSelector("ul.react-autosuggest_suggestions-list>li")).size();
		System.out.println("length is" +length);
		for(int i=0;i<length;i++) {
			String element=((WebElement)driver.findElements(By.cssSelector("ul.react-autosuggest_suggestions-list>li.div>div>p.searchedResult.font14.darkText>span")).get(i))
				.getText();
			System.out.println("element"+element);
			if(element.equals("Delhi")) {
				((WebElement)driver.findElements(By.cssSelector("ul.react-autosuggest_suggestions-list>li.div>div>p.serachedResult.font14.darkText>span")).get(i)).click();
				break;
			}
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div/div/div/div[2]/p/a")).click();
		driver.close(); 
	}
	public static void main(String args[]) throws InterruptedException {
		Question01 obj = new Question01();
		obj.launchBrowser();
	}

}

