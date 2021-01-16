package com.hotelbooking.testscripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import com.hotelbooking.pages.HotelBookingFormPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HotelBookingTest 
{
	private WebDriver driver;
	private HotelBookingFormPage booking;
	
	@Given("user launch the application on the browser")
	public void user_launch_the_application_on_the_browser()
	{
		System.setProperty("webdriver.chrome.driver", "resources//chromedriver-V86.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();	
		driver.get("C:\\Users\\Madhu\\Desktop\\HotelBooking\\resources\\login.html");
	}

	@When("user is on the login page")
	public void user_is_on_the_login_page()
	{
		booking = new HotelBookingFormPage(driver);
		Assert.assertEquals(booking.verifyHeading(), "Hotel Booking Application");
		System.out.println("************************************************************************************************************************");
		System.out.println("                                                 RESULT: Login page heading validation passed.");
		System.out.println("************************************************************************************************************************");
	}

	@When("user clicks and enters username {string}")
	public void user_clicks_and_enters_username(String uName)
	{
		System.out.println("************************************************************************************************************************");
		System.out.println("                                                 RESULT: "+booking.enterUsername(uName));
		System.out.println("************************************************************************************************************************");
	}

	@When("user clicks and enters password {string}")
	public void user_clicks_and_enters_password(String pswd)
	{		
		System.out.println("************************************************************************************************************************");
		System.out.println("                                                 RESULT: "+booking.enterPassword(pswd));
		System.out.println("************************************************************************************************************************");
	}

	@When("user now clicks login")
	public void user_now_clicks_login()
	{
		System.out.println("************************************************************************************************************************");
		System.out.println("                                                 RESULT: "+booking.clickLoginBtn());
		System.out.println("************************************************************************************************************************");
	}
	
	@And("user verifies the title after login")
	public void user_verifies_the_title_after_login()
	{
		Assert.assertEquals(booking.verifyTitle(), "Hotel Booking");
		System.out.println("************************************************************************************************************************");
		System.out.println("                                                 RESULT: Booking page title validation passed.");
		System.out.println("************************************************************************************************************************");
	}

	@And("user clicks firstname and enters value {string}")
	public void user_clicks_firstname_and_enters_value(String fName)
	{
		booking.enterFirstName(fName);
	}

	@And("user clicks lastname and enters value {string}")
	public void user_clicks_lastname_and_enters_value(String lName) 
	{
		booking.enterLastName(lName);
	}

	@And("user clicks email and enters value {string}")
	public void user_clicks_email_and_enters_value(String email) 
	{
		booking.enterEmail(email);
	}

	@And("user clicks mobile and enters value {string}")
	public void user_clicks_mobile_and_enters_value(String phone) 
	{
		booking.enterPhone(phone);
	}

	@And("user clicks address and enters value {string}")
	public void user_clicks_address_and_enters_value(String adrs) 
	{
		booking.enterAddress(adrs);
	}

	@And("user clicks city and selects value {string}")
	public void user_clicks_city_and_selects_value(String city) 
	{
		booking.selectCity(city);
	}

	@And("user clicks state and selects value {string}")
	public void user_clicks_state_and_selects_value(String state) 
	{
		booking.selectState(state);
	}

	@And("user clicks guest and selects value {string}")
	public void user_clicks_guest_and_selects_value(String guest) 
	{
		booking.selectGuest(guest);
	}

	@And("user clicks card holder name and enters value {string}")
	public void user_clicks_card_holder_name_and_enters_value(String cName) 
	{
		booking.enterCardHolderName(cName);
	}

	@And("user clicks card number and enters value {string}")
	public void user_clicks_card_number_and_enters_value(String cNum) 
	{
		booking.enterCardNumber(cNum);
	}

	@And("user clicks cvv and enters value {string}")
	public void user_clicks_cvv_and_enters_value(String cCvv) 
	{
		booking.enterCvv(cCvv);
	}

	@And("user clicks expiry month and enters value {string}")
	public void user_clicks_expiry_month_and_enters_value(String expMon) 
	{
		booking.enterExpiryMonth(expMon);
	}

	@And("user clicks expiry year and enters value {string}")
	public void user_clicks_expiry_year_and_enters_value(String expYear) 
	{
		booking.enterExpiryYear(expYear);
	}

	@And("user verifies the booking confirmation")
	public void user_verifies_the_booking_confirmation() 
	{
		System.out.println("************************************************************************************************************************");
		System.out.println("                                                 RESULT: "+booking.clickConfirm());
		System.out.println("                                                 RESULT: "+booking.verifyBookingStatus());
		System.out.println("************************************************************************************************************************");
	}
	
	@Then("user close the application")
	public void user_close_the_application()
	{
		driver.close();
	}


}
