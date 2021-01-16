package com.hotelbooking.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage
{
	WebDriver driver;
	WebDriverWait wait;

	private @FindBy(xpath = "//h1") WebElement loginPageHeading;
	private @FindBy(xpath = "//h2") WebElement bookingPageHeading;
	private @FindBy(name = "userName") WebElement username;
	private @FindBy(xpath = "//input[@name='userName']/following::div[@id='userErrMsg']") WebElement unameErr;
	private @FindBy(name = "userPwd") WebElement password;
	private @FindBy(xpath = "//input[@name='userPwd']/following::div[@id='pwdErrMsg']") WebElement passErr;
	private @FindBy(xpath = "//input[@value='Login']") WebElement loginBtn;

	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 15);
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
}
