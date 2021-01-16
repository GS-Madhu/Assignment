package com.hotelbooking.testscripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import com.hotelbooking.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ApplicationLoginTest
{
	private WebDriver driver;
	private LoginPage loginpage;
	
	@Given("user launched browser and the application")
	public void user_launched_browser_and_the_application() 
	{
		System.setProperty("webdriver.chrome.driver", "resources//chromedriver-V86.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();	
		driver.get("C:\\Users\\Madhu\\Desktop\\HotelBooking\\resources\\login.html");
	}

	@When("user is on the applicaion login page")
	public void user_is_on_the_applicaion_login_page()
	{
		loginpage = new LoginPage(driver);
		Assert.assertEquals(loginpage.verifyHeading(), "Hotel Booking Application");
		System.out.println("************************************************************************************************************************");
		System.out.println("                                                 RESULT: Login page heading validation passed.");
		System.out.println("************************************************************************************************************************");
		
	}

	@And("user clicks username and enters value {string}")
	public void user_clicks_username_and_enters_value(String uname)
	{
		System.out.println("************************************************************************************************************************");
		System.out.println("                                                 RESULT: "+loginpage.enterUsername(uname));
		System.out.println("************************************************************************************************************************");
	}

	@And("user clicks password and enters value {string}")
	public void user_clicks_password_and_enters_value(String pswd)
	{
		System.out.println("************************************************************************************************************************");
		System.out.println("                                                 RESULT: "+loginpage.enterPassword(pswd));
		System.out.println("************************************************************************************************************************");
	}
	
	@And("user clicks login button")
	public void user_clicks_login_button()
	{
		System.out.println("************************************************************************************************************************");
		System.out.println("                                                 RESULT: "+loginpage.clickLoginBtn());
		System.out.println("************************************************************************************************************************");
	}

	@Then("user close the browser")
	public void user_close_the_browser()
	{
		driver.close();
	}
}
