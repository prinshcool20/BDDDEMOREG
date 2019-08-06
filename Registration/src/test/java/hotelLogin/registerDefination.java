package hotelLogin;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

// pageBean.HotelLoginPageFactory;
import pageBean.RegisterPageFactory;

public class registerDefination {

	private WebDriver driver;
	private RegisterPageFactory registerPageFactory;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\Users\\prinskum\\Desktop\\Module 4\\chromedriver_win32\\chromedriver.exe" );
		
		driver= new ChromeDriver();
	}
	
	@Given("^User is on 'register' Page$")
	public void user_is_on_login_Page() throws Throwable {
	
		driver.get("D:\\Users\\prinskum\\SpringWorkspace\\Registration\\Register.html");
		
		//	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			registerPageFactory = new RegisterPageFactory(driver);

	}

	@When("^user enters invalid UserName$")
	public void user_enters_invalid_UserName() throws Throwable {
		registerPageFactory.setName("");
		registerPageFactory.setLoginButton();
		
		
	}

	@Then("^display 'Please Enter UserName'$")
	public void display_Please_Enter_UserName() throws Throwable {
		String expectedMessage="*Please Enter UserName";
		String actualMessage=registerPageFactory.getNameError().getText();
		Assert.assertEquals(expectedMessage, actualMessage);
		driver.close();	
	}

	@When("^user enters invalid address$")
	public void user_enters_invalid_Address() throws Throwable {
		registerPageFactory.setName("rahul");
		registerPageFactory.setAddress("");
		registerPageFactory.setLoginButton();

	}

	@Then("^display 'Please Enter Address'$")
	public void display_Please_Enter_Address() throws Throwable {
		String expectedMessage="*Please Enter Address";
		String actualMessage=registerPageFactory.getAddressError().getText();
		Assert.assertEquals(expectedMessage, actualMessage);
		driver.close();	

	}
	
	@When("^user enters invalid marks$")
	public void user_enters_invalid_marks() throws Throwable {
		registerPageFactory.setName("rahul");
		registerPageFactory.setAddress("capgemini");
		registerPageFactory.setMarks("");
		registerPageFactory.setLoginButton();

	}

	@Then("^display 'Please Enter Marks'$")
	public void display_Please_Enter_Marks() throws Throwable {
		String expectedMessage="*Please Enter Marks";
		String actualMessage=registerPageFactory.getMarksError().getText();
		Assert.assertEquals(expectedMessage, actualMessage);
		driver.close();	

	}

@When("^user enters invalid details$")
public void user_enters_invalid_details() throws Throwable {
	registerPageFactory.setName("rahul");
	registerPageFactory.setAddress("capgemini");
	registerPageFactory.setMarks("52");
	registerPageFactory.setLoginButton();

}

@Then("^display 'Invalid Register Please try again'$")
public void display_Invalid_Register_Please_try_again() throws Throwable {
	String expectedMessage="*Please Enter Valid Details";
	String actualMessage=driver.switchTo().alert().getText();
	Assert.assertEquals(expectedMessage, actualMessage);
	driver.switchTo().alert().accept();
	driver.close();
}

	@When("^user enters valid details$")
	public void user_enters_valid_details() throws Throwable {
		registerPageFactory.setName("Rahul");
		registerPageFactory.setAddress("Capgemini");
		registerPageFactory.setMarks("85");
		registerPageFactory.setLoginButton();
	
	}

	@Then("^display 'Success' Page$")
	public void display_Success_Page() throws Throwable {
		driver.get("D:\\Users\\prinskum\\SpringWorkspace\\Registration\\success.html");
	//	driver.close();
	}


}