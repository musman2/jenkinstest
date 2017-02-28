package Clinical_Login_Group.Clinical_Login_Group.Clinical_Login;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import junit.framework.Assert;

public class Sample_Login {
 
	public static WebDriver driver = null;
	
 
 @BeforeTest
    public void setup() throws Exception { 
	 
	    System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
	    options.addArguments("--disable-extensions");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://phptravels.org/clientarea.php"); 
    } 
 

 
 @DataProvider
 public Object[][] Positive_login_Scenario(){
  Object[][] Datadriven = new Object[3][2];
  
  Datadriven[0][0] = "mohusmanpasha@gmail.com";      // For testing the login test scenario with valid and different email ID and passwords 
  Datadriven[0][1] = "Click.123";
  
  Datadriven[1][0] = "moh.usmanpasha@gmail.com";
  Datadriven[1][1] = "Click.123";
  
  Datadriven[2][0] = "mohusman.pasha@gmail.com";
  Datadriven[2][1] = "Click.123";
  
   return Datadriven; 
 }
 
 
 @DataProvider
 public Object[][] Negetive_login_Scenario(){
  Object[][] Datadriven = new Object[2][2];
  
  Datadriven[0][0] = "";                          // For testing the blank fields test scenario
  Datadriven[0][1] = "";
  
  Datadriven[1][0] = "mohammad@xyz.com";         // For testing the invalid email ID or password test scenario
  Datadriven[1][1] = "Click.123";
  
  
   return Datadriven; 
 }
 
 
 @Test(priority= 1 ,dataProvider="Positive_login_Scenario")
 public void Positive_LogIn_Test(String Userid, String Pwd){
   driver.findElement(By.id("inputEmail")).clear();
   driver.findElement(By.id("inputEmail")).sendKeys(Userid);
   driver.findElement(By.id("inputPassword")).clear();
   driver.findElement(By.id("inputPassword")).sendKeys(Pwd);
   driver.findElement(By.id("login")).click();
   driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
   
   //Verifying the Dashboard actual message with expected message
   Assert.assertEquals("Welcome Back, Mohammad",driver.findElement(By.xpath("//*[@id=\"main-body\"]/div[1]/div[1]/div/h1")).getText());
 
   driver.findElement(By.xpath("//*[@id=\"Secondary_Navbar-Account\"]/a")).click();
   driver.findElement(By.xpath("//*[@id=\"Secondary_Navbar-Account-Logout\"]/a")).click();
   driver.findElement(By.xpath("//*[@id=\"main-body\"]/div[1]/div/div/div[3]/p/a")).click();
 
  
  }
 
 
 @Test(priority = 2,dataProvider="Negetive_login_Scenario")
 public void Negetive_LogIn_Test(String UserId, String Pswd){
   driver.findElement(By.id("inputEmail")).clear();
   driver.findElement(By.id("inputEmail")).sendKeys(UserId);
   driver.findElement(By.id("inputPassword")).clear();
   driver.findElement(By.id("inputPassword")).sendKeys(Pswd);
   driver.findElement(By.id("login")).click();
   
 //Verifying the login failure actual message with expected message
   Assert.assertEquals("Login Details Incorrect. Please try again.",driver.findElement(By.xpath("//*[@id=\"main-body\"]/div[1]/div/div/div[2]")).getText());
   
    driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
 
  }
  
 
 @ AfterTest
 public void tearDown() throws Exception { 
   driver.quit();
     } 
}