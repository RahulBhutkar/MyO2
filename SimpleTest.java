package stepDefination;

import Model.BillDetails;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class SimpleTest 
{
	WebDriver driver; 
	
	/*@Given("^Open Chrome & launch O(\\d+) site$")
	public void open_Chrome_launch_O_site(int arg1) {
		System.setProperty("webdriver.chrome.driver", "//home//cts1//Downloads/chromedriver");
		//System.setProperty("webdriver.gecko.driver","/home/cts1/Downloads/");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://zeus-lb.ref.o2.co.uk/mymobile");

	}

	@When("^I valid \"([^\"]*)\" and valid \"([^\"]*)\"$")
	public void i_valid_username_and_valid_password(String uname, String pass){
		driver.findElement(By.name("username")).sendKeys("011111082");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.name("password")).sendKeys("password");
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
		*/
	private void assertTrue(boolean displayed) {
		// TODO Auto-generated method stub
		
	}
	
	@Given("^I login as valid user \"([^\"]*)\"$")
	public void i_login_as_valid_user(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    System.setProperty("webdriver.chrome.driver", "//home//cts1//Downloads/chromedriver");
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get("https://zeus-lb.ref.o2.co.uk/mymobile");
	        driver.findElement(By.name("username")).sendKeys("011111082@gmail.com");
	        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	        driver.findElement(By.name("password")).sendKeys("password");
	        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	        driver.findElement(By.id("passwordO2Submit")).click();
	        System.out.println("Passed");
	}

	private void assertEquals(String pagename, WebElement webElement) {
	        // TODO Auto-generated method stub
	        
	    }
	@Then("^I should see \"([^\"]*)\" widget$")
	public void i_should_see_widget(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    String title = "O2 | My device";
	        assertEquals(title, driver.getTitle());
	        System.out.println("Passed");
	}

	    private void assertEquals(String title, String title_name) {
	        // TODO Auto-generated method stub
	        
	    }


	@Then("^I should see bill summary as follows$")
	public void i_should_see_bill_summary_as_follows(DataTable arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)
	    assertEquals(370.81, driver.findElement(By.id("latestBillAmount")));
	    System.out.println("Passed");
	}

	    private void assertEquals(double d, WebElement findElement) {
	        // TODO Auto-generated method stub
	        
	    }

	@Then("^I should see bill details as follows$")
	public void i_should_see_bill_details_as_follows(DataTable arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)
	        assertEquals(BillDetails.billed_on, driver.findElement(By.xpath(".//*[@id='latestBillDetails']/div[2]/div/div[1]/label[2]/time/time")));
	        assertEquals(BillDetails.payment_was, driver.findElement(By.xpath(".//*[@id='latestBillDetails']/div[2]/div/div[2]/label[2]/time/time")));
	        assertEquals(BillDetails.Balance, driver.findElement(By.xpath(".//*[@id='latestBillDetails']/div[2]/div/div[3]/label[2]/span")));
	        System.out.println("Passed");
	}

	@Then("^I should see balance info icon on widget$")
	public void i_should_see_balance_info_icon_on_widget() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    WebElement infoicon = driver.findElement(By.id("balanceInfoIcon"));
	       assertTrue(infoicon.isDisplayed());
	       System.out.println("Passed");
	}

	@Then("^I should see the \"([^\"]*)\" button on widget$")
	public void i_should_see_the_button_on_widget(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    WebElement infoicon = driver.findElement(By.id("viewLatestBillButton"));
	        assertTrue(infoicon.isDisplayed());
	        System.out.println("Passed");
	    
	}

	@Then("^I should see page name as \"([^\"]*)\"$")
	public void i_should_see_page_name_as(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    assertEquals(BillDetails.title_name, driver.getTitle());
	        System.out.println("Passed");
	        driver.findElement(By.id("viewLatestBillButton")).click();
	}

	@Then("^I should see Device number as \"([^\"]*)\"$")
	public void i_should_see_Device_number_as(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    WebDriverWait wait = new WebDriverWait(driver, 500);
	        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("mpn"))));
	        assertEquals(BillDetails.msidn, driver.findElement(By.id("mpn")));
	        System.out.println("Passed");
	}

	@Then("^I should see Billing period as \"([^\"]*)\"$")
	public void i_should_see_Billing_period_as(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    assertEquals(BillDetails.bill_period, driver.findElement(By.xpath(".//*[@id='bill-period']/span[2]")));
	    System.out.println("Passed");
	}

	@Then("^I should see Tariff charges as \"([^\"]*)\"$")
	public void i_should_see_Tariff_charges_as(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    assertEquals(BillDetails.Tariff, driver.findElement(By.id("tariffCharge_value_07011111082")));
	            System.out.println("Passed");
	}

	@Then("^I should see Monthly extras as \"([^\"]*)\"$")
	public void i_should_see_Monthly_extras_as(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    assertEquals(BillDetails.Monthly_extras, driver.findElement(By.id("monthlyExtra_value_07011111082")));
	            System.out.println("Passed");
	}

	@Then("^I should see Sub total of tariff as \"([^\"]*)\"$")
	public void i_should_see_Sub_total_of_tariff_as(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    assertEquals(BillDetails.Sub_total, driver.findElement(By.id("monthlyExtraCost_sub_value_07011111082")));
	            System.out.println("Passed");
	}

	@Then("^I should see Minutes as \"([^\"]*)\"$")
	public void i_should_see_Minutes_as(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    assertEquals(BillDetails.Minutes, driver.findElement(By.id("minute_value_07011111082")));
	            System.out.println("Passed");
	}

	@Then("^I should see Messages as \"([^\"]*)\"$")
	public void i_should_see_Messages_as(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    assertEquals(BillDetails.Messages, driver.findElement(By.id("message_value_07011111082")));
	            System.out.println("Passed");
	}

	@Then("^I should see Data as \"([^\"]*)\"$")
	public void i_should_see_Data_as(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    assertEquals(BillDetails.Data, driver.findElement(By.id("data_value_07011111082")));
	            System.out.println("Passed");
	}

	@Then("^I should see Charges when abroad as \"([^\"]*)\"$")
	public void i_should_see_Charges_when_abroad_as(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    assertEquals(BillDetails.Charges, driver.findElement(By.id("charges_when_abroad_value_07011111082")));
	        System.out.println("Passed");
	}

	@Then("^I should see Premium & information services as \"([^\"]*)\"$")
	public void i_should_see_Premium_information_services_as(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    assertEquals(BillDetails.Premium, driver.findElement(By.id("premium_info_value_07011111082")));
	            System.out.println("Passed");
	}

	@Then("^I should see Things you've bought as \"([^\"]*)\"$")
	public void i_should_see_Things_you_ve_bought_as(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    assertEquals(BillDetails.Things, driver.findElement(By.id("things_bought_value_07011111082")));
	            System.out.println("Passed");
	}

	@Then("^I should see Sub total as \"([^\"]*)\"$")
	public void i_should_see_Sub_total_as(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    assertEquals(BillDetails.Sub_total2, driver.findElement(By.id("extra_charges_and_purchases_sub_value_07011111082")));
	        System.out.println("Passed");
	}

	@Then("^I should see Discounts as \"([^\"]*)\"$")
	public void i_should_see_Discounts_as(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    assertEquals(BillDetails.Discounts, driver.findElement(By.id("discounts_value")));
	        System.out.println("Passed");
	}

	@Then("^I should see Order charges as \"([^\"]*)\"$")
	public void i_should_see_Order_charges_as(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    assertEquals(BillDetails.Order_charges, driver.findElement(By.id("order_charges_value")));
	        System.out.println("Passed");
	}

	@Then("^I should see Total before VAT as \"([^\"]*)\"$")
	public void i_should_see_Total_before_VAT_as(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    assertEquals(BillDetails.Total_before_VAT, driver.findElement(By.id("total_before_vat_value")));
	        System.out.println("Passed");
	}

	@Then("^I should see VAT as \"([^\"]*)\"$")
	public void i_should_see_VAT_as(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    assertEquals(BillDetails.VAT, driver.findElement(By.id("vat_value")));
	        System.out.println("Passed");
	}

	@Then("^I should see Total airtime bill as \"([^\"]*)\"$")
	public void i_should_see_Total_airtime_bill_as(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    assertEquals(BillDetails.Total_airtime_bill, driver.findElement(By.id("total_airtime_bill_value")));
	        System.out.println("Passed");
	        driver.close();
	        driver.quit();
	}
}
