package stepDefination;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SimpleTest 
{
	WebDriver driver; 
	
	@Given("^Open Chrome & launch O(\\d+) site$")
	public void open_Chrome_launch_O_site(int arg1) {
		/*DesiredCapabilities c = new DesiredCapabilities();
		c.setCapability(ChromeOptions.CAPABILITY, true);*/
		System.setProperty("webdriver.chrome.driver", "//home//cts1//Downloads/chromedriver");
		//System.setProperty("webdriver.gecko.driver","/home/cts1/Downloads/");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://zeus-lb.ref.o2.co.uk/mymobile");

	}

	@When("^I valid \"([^\"]*)\" and valid \"([^\"]*)\"$")
	public void i_valid_username_and_valid_password(String uname, String pass){
		driver.findElement(By.name("username")).sendKeys(uname);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.name("password")).sendKeys(pass);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.id("passwordO2Submit")).click();
		
	}

	@Then("^Get the Details from the page$")
	public void get_the_Details_from_the_page() throws InterruptedException{
		driver.getTitle();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement st = driver.findElement(By.id("o2-page-wrapper"));
		System.out.println(st.getText());
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lpfInfoIcon")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lpfInfoIcon")));
		driver.findElement(By.id("lpfInfoIcon")).click();
		//driver.switchTo().frame(0); - as there no use of iframe
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("overlay-content")));
		WebElement m = driver.findElement(By.className("overlay-content"));
		System.out.println(m.getText());
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("closeOverlayIcon")));
		driver.findElement(By.id("closeOverlayIcon")).click();
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("signOutLink")));
		driver.findElement(By.className("signOutLink")).click();
		Thread.sleep(10000);
		driver.close();
		driver.quit();
	}
	
}
