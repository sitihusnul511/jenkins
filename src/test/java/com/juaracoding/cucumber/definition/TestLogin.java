package com.juaracoding.cucumber.definition;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestLogin {
	
	WebDriver driver;
	
	@Given("User berada di halaman login")
	public void userHomePage() {
		System.setProperty("webdriver.chrome.drive", "D:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.phptravels.net/login");
	}
	
	@When("User input email")
	public void inputEmail() {
		WebElement btnGotIt = driver.findElement(By.id("cookie_stop"));
		btnGotIt.click();
		WebElement formEmail = driver.findElement(By.name("email"));
		formEmail.sendKeys("user@phptravels.com");
	}
	
	@When("User input password")
	public void inputPassword() {
		WebElement formEmail = driver.findElement(By.name("password"));
		formEmail.sendKeys("demouser");
		WebElement btnLogin = driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[1]/div/div[2]/div[2]/div/form/div[3]/button"));
		btnLogin.click();
	}
	
	@Then("User berhasil login")
	public void berhasilLogin() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		String expect = "Welcome Back";
		String txtWelcome = driver.findElement(By.className("author__meta")).getText();
		System.out.println(txtWelcome);
		assertTrue(expect.contains(txtWelcome));
	}

	
	
	//input invalid account
	
	
	
	
	@When("User input email salah")
	public void inputEmailSalah() {
		WebElement btnGotIt = driver.findElement(By.id("cookie_stop"));
		btnGotIt.click();
		WebElement formEmail = driver.findElement(By.name("email"));
		formEmail.sendKeys("husnul@phptravels.com");
	}
	
	@When("User input password salah")
	public void inputPasswordSalah() {
		WebElement formEmail = driver.findElement(By.name("password"));
		formEmail.sendKeys("demo123");
		WebElement btnLogin = driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[1]/div/div[2]/div[2]/div/form/div[3]/button"));
		btnLogin.click();
	}
	
	@Then("User tidak berhasil login")
	public void gagalLogin() {
		
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		String expect = "Wrong";
		String txtError = driver.findElement(By.className("message")).getText();
		System.out.println(txtError);
		assertThat(txtError,containsString(expect));
	}
}
