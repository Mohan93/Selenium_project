package StepDefinations;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import junit.framework.Assert;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class GreencartStepDefination {
public	WebDriver driver;
public String ProductName;
public String OfferpageName;	
	
	@Given("User is on GreenCart landing page")
	public void user_is_on_green_cart_landing_page() {
		
		//System.setProperty("webdriver.chrome.driver", "C://Users//IWINFE0044//Downloads//chromedriver-win64//chromedriver-win64//chromedriver.exe");

		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
	}
	
	@When("User search with shortname {string} and Extract actual Product")
	public void user_search_with_sortname_and_extract_actual_product(String Shortname) throws InterruptedException {
	    
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(Shortname);
		Thread.sleep(3000);
		String ProductName = driver.findElement(By.cssSelector("h4.product-name")).getText().split("-")[0].trim();
		System.out.println(ProductName +" is extracted from home page");		
		
	}
	
	@Then("User go and Search for {string}  shortname in offers page to check if product exits")
	public void user_go_and_search_for_same_shortname_in_offers_page_to_check_if_product_exits(String Shortname) throws InterruptedException {
	    
		driver.findElement(By.linkText("Top Deals")).click();
		Set<String> S1= driver.getWindowHandles();
		Iterator<String> I1 = S1.iterator();
		String parentWindow = I1.next();
		String childWindow = I1.next();
		
		driver.switchTo().window(childWindow);
		driver.findElement(By.id("search-field")).sendKeys(Shortname);
		
		Thread.sleep(3000);
		String OfferpageName = driver.findElement(By.cssSelector("tr td:nth-child(1)")).getText();
		System.out.println(OfferpageName +"is exracted from Offer page ");

	}
	
	@Then("Validate the product name in offer page with landing page")
	public void Validate_the_product_name_in_offer_with_landing_page() {
		
		Assert.assertEquals(ProductName, OfferpageName);
	}
	
}
