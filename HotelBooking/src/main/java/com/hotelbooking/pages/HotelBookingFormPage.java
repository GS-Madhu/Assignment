package com.hotelbooking.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HotelBookingFormPage
{
	WebDriver driver;
	WebDriverWait wait;

	private @FindBy(xpath = "//h1") WebElement loginPageHeading;
	private @FindBy(name = "userName") WebElement username;
	private @FindBy(xpath = "//input[@name='userName']/following::div[@id='userErrMsg']") WebElement unameErr;
	private @FindBy(name = "userPwd") WebElement password;
	private @FindBy(xpath = "//input[@name='userPwd']/following::div[@id='pwdErrMsg']") WebElement passErr;
	private @FindBy(xpath = "//input[@value='Login']") WebElement loginBtn;
	private @FindBy(xpath = "//h2") WebElement bookingPageHeading;
	private @FindBy(xpath = "//input[@id='txtFirstName']") WebElement firstName;
	private @FindBy(xpath = "//input[@id='txtLastName']") WebElement lastName;
	private @FindBy(xpath = "//input[@id='txtEmail']") WebElement email;
	private @FindBy(xpath = "//input[@id='txtPhone']") WebElement phone;
	private @FindBy(xpath = "//textarea") WebElement address;
	private @FindBy(xpath = "//select[@name='city']") WebElement cityDropdown;
	private @FindBy(xpath = "//select[@name='state']") WebElement stateDropdown;
	private @FindBy(xpath = "//select[@name='persons']") WebElement guestDropdown;
	private @FindBy(xpath = "//input[@id='txtCardholderName']") WebElement cardHolderName;
	private @FindBy(xpath = "//input[@id='txtDebit']") WebElement cardNumber;
	private @FindBy(xpath = "//input[@id='txtCvv']") WebElement cvv;
	private @FindBy(xpath = "//input[@id='txtMonth']") WebElement expiryMonth;
	private @FindBy(xpath = "//input[@id='txtYear']") WebElement expiryYear;
	private @FindBy(xpath = "//input[@id='btnPayment']") WebElement confirmBtn;	
	private @FindBy(xpath = "//h1") WebElement bookingStatus;

	public HotelBookingFormPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 3);
		this.driver = driver;
	}

	public String verifyHeading()
	{
		wait.until(ExpectedConditions.visibilityOf(loginPageHeading));
		String title = loginPageHeading.getText();
		return title;
	}

	public String enterUsername(String uname)
	{	
		String actualValue;
		username.click(); username.clear(); username.sendKeys(uname);
		//System.out.println("Username entered is : "+ uname + " ");
		loginBtn.click();
		try
		{
			if(unameErr.getText().contains("Please "))
			{
				actualValue = ("Username error : " + unameErr.getText());
			}
			else
			{
				actualValue = "No error on the username field";
			}
		}
		catch (Exception e)
		{
			actualValue = "No error on the username field";
		}
		return actualValue;
	}

	public String enterPassword(String pswd)
	{
		String actualValue;
		password.click(); password.clear(); password.sendKeys(pswd);
		//System.out.println("Password entered is : "+ pswd + " ");
		loginBtn.click();
		try
		{
			if(passErr.getText().contains("Please "))
			{
				actualValue = ("Password error : " + passErr.getText());
			}
			else
			{
				actualValue = "No error on the password field";
			}
		}
		catch (Exception e)
		{
			actualValue = "No error on the password field";
		}
		return actualValue;
	}

	public String clickLoginBtn()
	{
		String actualValue="";
		try
		{
			loginBtn.click();
		}
		catch (NoSuchElementException e1)
		{
		}
		try
		{
			driver.switchTo().alert().getText().contains("Invalid");
			actualValue = driver.switchTo().alert().getText();
			driver.switchTo().alert().accept();
		}
		catch(Exception e2)
		{
			try
			{
				bookingPageHeading.isDisplayed();
				actualValue = "Login successful";
			}
			catch(Exception e3)
			{
				loginPageHeading.isDisplayed();
				actualValue = "Login failed";
			}
		}
		return actualValue;
	}

	public String verifyTitle()
	{
		driver.switchTo().parentFrame();
		return driver.getTitle();
	}

	public void enterFirstName(String fName)
	{
		firstName.click(); firstName.clear(); firstName.sendKeys(fName);
		//return clickConfirm();
	}

	public void enterLastName(String lName)
	{
		lastName.click(); lastName.clear(); lastName.sendKeys(lName);
		//return clickConfirm();
	}

	public void enterEmail(String mail)
	{
		email.click(); email.clear(); email.sendKeys(mail);
		//return clickConfirm();
	}

	public void enterPhone(String mob)
	{
		phone.click(); phone.clear(); phone.sendKeys(mob);
		//return clickConfirm();
	}

	public void enterAddress(String adrs)
	{
		address.click(); address.clear(); address.sendKeys(adrs);
		//return clickConfirm();
	}

	public void selectCity(String city)
	{
		Select select = new Select(cityDropdown);
		select.selectByValue(city);
		//return clickConfirm();
	}

	public void selectState(String state)
	{
		Select select = new Select(stateDropdown);
		select.selectByValue(state);
		//return clickConfirm();
	}

	public void selectGuest(String guest)
	{
		Select select = new Select(guestDropdown);
		select.selectByValue(guest);
		//return clickConfirm();
	}

	public void enterCardHolderName(String cardName)
	{
		cardHolderName.click(); cardHolderName.clear(); cardHolderName.sendKeys(cardName);
		//return clickConfirm();
	}

	public void enterCardNumber(String cardNum)
	{
		cardNumber.click(); cardNumber.clear(); cardNumber.sendKeys(cardNum);
		//return clickConfirm();
	}

	public void enterCvv(String ccvv)
	{
		cvv.click(); cvv.clear(); cvv.sendKeys(ccvv);
		//return clickConfirm();
	}

	public void enterExpiryMonth(String expMon)
	{
		expiryMonth.click(); expiryMonth.clear(); expiryMonth.sendKeys(expMon);
		//return clickConfirm();
	}

	public void enterExpiryYear(String expYear)
	{
		expiryYear.click(); expiryYear.clear(); expiryYear.sendKeys(expYear);
		//return clickConfirm();
	}

	public String clickConfirm()
	{
		String actualValue = null;
		confirmBtn.click();	
		try
		{
			driver.switchTo().alert();
			actualValue = driver.switchTo().alert().getText();
			driver.switchTo().alert().accept();
		}
		catch (Exception e)
		{
			actualValue = "All inputs are validated. No Error popups";
		}
		return actualValue;
	}

	public String verifyBookingStatus()
	{
		String actualValue="";
		try
		{
			wait.until(ExpectedConditions.visibilityOf(bookingStatus));
			actualValue = bookingStatus.getText();
		}
		catch(Exception e1)
		{
			actualValue = "Booking Failed";
		}
		driver.get("C:\\Users\\Madhu\\Desktop\\HotelBooking\\resources\\login.html");
		return actualValue;
	}
}
