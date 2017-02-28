package Clinical_Login_Group.Clinical_Login;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.Proxy.ProxyType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.Authenticator;
import org.openqa.selenium.JavascriptExecutor;

import org.apache.commons.io.FileUtils;
import org.eclipse.jetty.websocket.api.Session;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.sikuli.script.FindFailed;

import org.sikuli.script.Pattern;
 
import org.sikuli.script.Screen;

//import com.gargoylesoftware.htmlunit.javascript.host.URL;

import atu.testrecorder.ATUTestRecorder;
import org.openqa.selenium.WebDriverException;

import java.net.URL; 

@Listeners(JyperionListener.class)
public class Journal_Login extends BaseClass {
	static WebDriver driver = null;
	ATUTestRecorder recorder;
	Calendar calendar = Calendar.getInstance();
	 SimpleDateFormat formater = new SimpleDateFormat("MM_dd_yyyy_hh_mm_ss");
	 
	// We have to create Screen class object to access method
	 
	 Screen screen = new Screen();
	
//	public static final String USERNAME = "mohammadusman1";
//
//	  public static final String AUTOMATE_KEY = "DcmqoNjxD5LjyNHEgpd7";
//
//	  public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
	//private static final String VIDEO_URL = null; 
	//private static RemoteWebDriver driver;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
//		DesiredCapabilities caps = new DesiredCapabilities();
//	    caps.setCapability("browser", "chrome");
//	    caps.setCapability("browser_version", "50");
//	    caps.setCapability("os", "Windows");
//	    caps.setCapability("os_version", "XP");
//	    caps.setCapability("browserstack.debug", "true");
//	    caps.setCapability("browserstack.local", "false");
//	    
//	    caps.setCapability("browserstack.localIdentifier", "Test123");
		Proxy proxy = new Proxy();
		proxy.setAutodetect(false);
		proxy.setProxyType(ProxyType.MANUAL);
		proxy.setHttpProxy("localhost:8080");
		
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(CapabilityType.PROXY, proxy);
		
		
		
		System.setProperty("webdriver.chrome.driver", "E://chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
	options.addArguments("--disable-extensions");
		driver = new ChromeDriver(options);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.navigate().refresh();
	  //  WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
		driver.get("http://www.journalclub.net/Authentication/Login");
		
	
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		  try{
			//	driver.close();
			  }catch (Exception e)
			  {
				  e.printStackTrace();
			  }
				}	
		
	@Test(priority = 1)
	public void Sign_in_User() throws Exception{
			
		try{
		WebElement username = driver.findElement(By.id("UserName"));
		username.clear();
		username.sendKeys("clinical");
		
		
		WebElement password = driver.findElement(By.id("Password"));
		password.clear();
		password.sendKeys("clinar!");
		Thread.sleep(3000);

	
		driver.findElement(By.xpath("//*[@id=\"loginForm\"]/form/div/div[3]/div[2]/button")).click();
		}
		  catch (Exception e){
		  System.out.println("I'm in exception no # 1");
	       //calls the method to take the screenshot.
			getscreenshot();
		 			  
			 //  throw new SkipException("Skipping this exception");
	 	  }
		
	}
	
	
	@Test(priority = 2, enabled = true)
	public void Article_Library() throws Exception{
			
		try{
			// Create the  JavascriptExecutor object
			  JavascriptExecutor js=(JavascriptExecutor)driver; 
			
//			WebDriverWait wait = new WebDriverWait(driver,30);
//		    WebElement myJC = wait.until(
//		    ExpectedConditions.elementToBeClickable(By.id("automationidAO_1")));
//		    myJC.click();
//			System.out.println("hey here");
//		driver.wait(300);
		   WebDriverWait wait11 = new WebDriverWait(driver,90);
		    WebElement JCs = wait11.until(
		    ExpectedConditions.elementToBeClickable(By.id("automationidAP_2")));
		    JCs.click();
			
		//	driver.manage().timeouts().implicitlyWait(30, TimeUnit.MINUTES);			
		
//			WebDriverWait wait4 = new WebDriverWait(driver,90);
//		    WebElement element5 = wait4.until(
//		     ExpectedConditions.elementToBeClickable(By.id("automationidBF_2")));
//		    element5.click(); 
//			Thread.sleep(3000);
						
			WebDriverWait wait5 = new WebDriverWait(driver,90);
		    WebElement element6 = wait5.until(
		     ExpectedConditions.elementToBeClickable(By.id("automationidBO_2")));
		    element6.click(); 
			Thread.sleep(3000);
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
		    		    
			WebDriverWait wait55 = new WebDriverWait(driver,30);
		    WebElement browsefile = wait55.until(
		     ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"uploadPdfFile\"]/div[1]/div[2]/form/div/div[1]/input")));
		    browsefile.sendKeys("C:/Users/Xone-pc/Clinarwrkspc/articleforJC.pdf"); 
		    Thread.sleep(3000);
				
			//driver.findElement(By.xpath("//*[@id=\"uploadPdfFile\"]/div[1]/div[2]/form/div/div[1]/input")).sendKeys("C:/Users/Xone-pc/Clinarwrkspc/articleforJC.pdf");
			driver.findElement(By.xpath("//*[@id=\"uploadPdfFile\"]/div[1]/div[2]/form/div/div[2]/button")).click();
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
			
			browsefile.sendKeys("C:/Users/Xone-pc/Clinarwrkspc/articleforJC.pdf"); 
			driver.findElement(By.xpath("//*[@id=\"uploadPdfFile\"]/div[1]/div[2]/form/div/div[2]/button")).click();
			//*[@id="uploadPdfFile"]/div[1]/div[2]/form/div/div[2]/button
			
			 WebDriverWait txtarea1 = new WebDriverWait(driver,30);
			    WebElement element61 = txtarea1.until(
			     ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ngApp\"]/div/div/div[2]/ng-form/div[2]/textarea")));
			    element61.clear(); 
			    element61.sendKeys("Article - "+ formater.format(calendar.getTime()));
				Thread.sleep(12000);
			
				new Select(driver.findElement(By.xpath("//*[@id=\"ngApp\"]/div/div/div[2]/ng-form/div[3]/div[1]/div/select"))).selectByVisibleText("Cardiology");
				new Select(driver.findElement(By.xpath("//*[@id=\"ngApp\"]/div/div/div[2]/ng-form/div[3]/div[3]/div/select"))).selectByVisibleText("Meta Analysis");
				new Select(driver.findElement(By.xpath("//*[@id=\"ngApp\"]/div/div/div[2]/ng-form/div[3]/div[5]/div/select"))).selectByVisibleText("Therapy");
				//driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
			TimeUnit.SECONDS.sleep(40);
				
				WebElement myDynamicElement = (new WebDriverWait(driver, 90))
						.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"uploadPdfFile\"]/div[2]/div[2]/a")));
				
				 WebDriverWait selfappwait = new WebDriverWait(driver,90);
				    WebElement selfappraise = selfappwait.until(
				     ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"automationidBP_5\"]")));
				    selfappraise.click();
				
				    Pattern image = new Pattern("C:/Users/Xone-pc/Clinarwrkspc/Sikulli/article1.jpg");
				    
				    screen.wait(image, 10);
				    screen.doubleClick(image);
				    	    
//				    Actions action = new Actions(driver);
//				    WebElement element=driver.findElement(By.linkText("SIRT1 activation enhances HDAC inhibition-mediated"));
//
//				    //Double click
//				    action.doubleClick(element).perform();
//				    
//				    WebDriverWait add_notes = new WebDriverWait(driver,90);
//				    WebElement notes_add = add_notes.until(
//				     ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"automationidAdminAC_1\"]")));
//				    notes_add.click();
//				    
//				    WebDriverWait enter_notes = new WebDriverWait(driver,30);
//				    WebElement notes_enter = enter_notes.until(
//				     ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"div_AnnonoteText\"]")));
//				    notes_enter.sendKeys("This is note from Usman the QA");
//				    
//				    
//				    WebDriverWait ok_notes = new WebDriverWait(driver,	30);
//				    WebElement notes_ok = ok_notes.until(
//				     ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"automationidAdminAD_1\"]")));
//				    notes_ok.click();
//				    
//				    WebDriverWait section_notes = new WebDriverWait(driver,30);
//				    WebElement notes_section = section_notes.until(
//				     ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"automationidAdminAB_2\"]")));
//				    notes_section.click();
//				    
				    WebDriverWait thubmnail = new WebDriverWait(driver,90);
				    WebElement click_thumbnail = thubmnail.until(
				     ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"automationidAdminAB_1\"]/i")));
				    click_thumbnail.click();
				    TimeUnit.SECONDS.sleep(2);
				    click_thumbnail.click();
				    
				    
				    WebDriverWait full_screen = new WebDriverWait(driver,90);
				    WebElement screen_full = full_screen.until(
				     ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"automationidAdminAB_4\"]/i")));
				    screen_full.click();
				    TimeUnit.SECONDS.sleep(2);
				    
				    WebDriverWait exit_full_screen = new WebDriverWait(driver,90);
				    WebElement exit_screen_full = exit_full_screen.until(
				     ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"automationidAdminAB_5\"]/i")));
				    exit_screen_full.click();
				    
				    
				    TimeUnit.SECONDS.sleep(62);
				    
				 // find element using id attribute
				  //  WebElement textname= driver.findElement(By.xpath("//*[@id=\"myJqte_editor\"]/div/div[3]/nobr/span"));
				    
				  //highlight that element
				   // highlightelement(textname);
				    
				    WebDriverWait view_answer = new WebDriverWait(driver,90);
				    WebElement answer_view = view_answer.until(
				     ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"automationidAdminAB_7\"]/i")));
				    answer_view.click();
				    TimeUnit.SECONDS.sleep(2);
				  
				    WebDriverWait view_answer_bck = new WebDriverWait(driver,90);
				    WebElement answer_view_bk = view_answer_bck.until(
				     ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"automationIdAdminGuideAA_1\"]")));
				    answer_view_bk.click();
				    
				    TimeUnit.SECONDS.sleep(2);
				    
				    WebDriverWait saveebtn = new WebDriverWait(driver,90);
				    WebElement savebutton = saveebtn.until(
				     ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"automationidAdminAB_6\"]")));
				    savebutton.click();
				    
				    TimeUnit.SECONDS.sleep(8);
				    
				    WebDriverWait bckbtn = new WebDriverWait(driver,90);
				    WebElement backbutton = bckbtn.until(
				     ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"automationidBO_1\"]")));
				    backbutton.click();
				  
				    
				
				   
				
//				//back from article library
//				
//				 WebDriverWait bckbttn = new WebDriverWait(driver,30);
//				    WebElement element651 = bckbttn.until(
//				     ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mainleftmenu\"]/div[3]/div/ul/li/a")));
//				    element651.click(); 
//				
//				    
//				    WebDriverWait bckbttnn = new WebDriverWait(driver,30);
//				    WebElement element6651 = bckbttnn.until(
//				     ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mainleftmenu\"]/div[3]/div/ul/li[1]/a")));
//				    element6651.click(); 
//				    
//				    WebDriverWait wait99 = new WebDriverWait(driver,30);
//				    WebElement JC = wait99.until(
//				    ExpectedConditions.elementToBeClickable(By.id("//*[@id=\"mainleftmenu\"]/div[3]/div/ul/li[2]/a")));
//				    JC.click();
//				    
				
				
			
			
		}
		  catch (Exception e){
		  System.out.println("I'm in exception no # 1");
	       //calls the method to take the screenshot.
			getscreenshot();
		 			  
			 //  throw new SkipException("Skipping this exception");
	 	  }
		
	}
	
	@Test(priority = 3,enabled = true ,dependsOnMethods = { "Article_Library" })	
	public void Create_Journal_Club() throws Exception{
			
		try{
			
				 
		    
//		    
//			//*[@id="mainleftmenu"]/div[3]/div/ul/li[2]/a
			WebDriverWait wait = new WebDriverWait(driver,30);
		    WebElement myJC = wait.until(
		    ExpectedConditions.elementToBeClickable(By.id("automationidAO_1")));
		    myJC.click();
		    
		    //*[@id="automationidBF_1"]  //*[@id="automationidBF_1"]
		
		   WebDriverWait wait11 = new WebDriverWait(driver,30);
		    WebElement JCs = wait11.until(
		    ExpectedConditions.elementToBeClickable(By.id("automationidAR_1")));
		    JCs.click();
//			Thread.sleep(3000);
		
//		  
		
			 WebDriverWait txtarea = new WebDriverWait(driver,30);
			    WebElement element4 = txtarea.until(
			     ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ngApp\"]/div/div/div[1]/div[1]/div[2]/div/ng-form/div[1]/textarea")));
			    element4.clear(); 
			    element4.sendKeys("Usman Journal Club "+ formater.format(calendar.getTime()));
				Thread.sleep(3000);
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.MINUTES);
			
				new Select(driver.findElement(By.xpath("//*[@id=\"ngApp\"]/div/div/div[1]/div[1]/div[2]/div/ng-form/div[2]/div[1]/div/select"))).selectByVisibleText("Cardiology");
				new Select(driver.findElement(By.xpath("//*[@id=\"ngApp\"]/div/div/div[1]/div[1]/div[2]/div/ng-form/div[2]/div[3]/div/select"))).selectByVisibleText("Meta Analysis");
				new Select(driver.findElement(By.xpath("//*[@id=\"ngApp\"]/div/div/div[1]/div[1]/div[2]/div/ng-form/div[2]/div[5]/div/select"))).selectByVisibleText("Therapy");
				Thread.sleep(3000);
				
				driver.findElement(By.xpath("//*[@id=\"__ata_1039\"]")).click();
				Thread.sleep(3000);
				
				new Select(driver.findElement(By.xpath("//*[@id=\"automationidBH_6\"]"))).selectByVisibleText("01");
				
				
				
				new Select(driver.findElement(By.xpath("//*[@id=\"automationidBH_8\"]"))).selectByVisibleText("23");
				Thread.sleep(3000);
				//*[@id="automationidBH_10"]
				
				new Select(driver.findElement(By.xpath("//*[@id=\"automationidBH_10\"]"))).selectByVisibleText("(UTC-09:00) Alaska");
				Thread.sleep(3000);			
				
				driver.findElement(By.id("__activePreSession")).click();
				Thread.sleep(2000);
								
				 WebDriverWait wait33 = new WebDriverWait(driver,30);
				    WebElement savejc = wait33.until(
				     ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ngApp\"]/div/div/div[1]/div[3]/button")));
				    savejc.click(); 
					Thread.sleep(5000);
					
					
					 WebDriverWait wait34 = new WebDriverWait(driver,30);
					    WebElement manusers = wait34.until(
					     ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mainleftmenu\"]/div[2]/div[2]/div/ul/li[3]/a")));
					    manusers.click(); 
						Thread.sleep(5000);
						
									
				
						 WebDriverWait wait35 = new WebDriverWait(driver,30);
						    WebElement invuser = wait35.until(
						     ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"automationidBJ_2\"]")));
						    invuser.click(); 
							Thread.sleep(9000);
							
											    
						    WebDriverWait wait39 = new WebDriverWait(driver,30);
						    WebElement user2 = wait39.until(
						    ExpectedConditions.elementToBeClickable(By.id("__user_5")));
						    user2.click();
				//driver.findElement(By.xpath("//*[@id=\"ngApp\"]/div/div/div[3]/div[1]/div[2]/div[3]/button")).click();
				
						    WebDriverWait wait399 = new WebDriverWait(driver,30);
						    WebElement user29 = wait399.until(
						    ExpectedConditions.elementToBeClickable(By.id("__user_6")));
						    user29.click();
						    
						    WebDriverWait wait389 = new WebDriverWait(driver,30);
						    WebElement user299 = wait389.until(
						    ExpectedConditions.elementToBeClickable(By.id("__user_11")));
						    user299.click();
						    
										
							
							WebDriverWait wait37 = new WebDriverWait(driver,30);
						    WebElement updusers = wait37.until(
						     ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ngApp\"]/div/div/div[3]/div[2]/div[6]/div[2]/button")));
						    updusers.click(); 
							Thread.sleep(9000);
							
							
							new Select(driver.findElement(By.xpath("//*[@id=\"automationidBK_4\"]"))).selectByVisibleText("Teacher");
							new Select(driver.findElement(By.xpath("//*[@id=\"automationidBK_3\"]"))).selectByVisibleText("Presenter");
							
							
							WebDriverWait wait40 = new WebDriverWait(driver,30);
						    WebElement updusers1 = wait40.until(
						     ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ngApp\"]/div/div/div[3]/div[1]/div[7]/div/button")));
						    updusers1.click(); 
							Thread.sleep(9000);
							
						
							WebDriverWait wait44 = new WebDriverWait(driver,30);
						    WebElement backbtn = wait44.until(
						     ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mainleftmenu\"]/div[2]/div[2]/div/ul/li[1]/a")));
						    backbtn.click(); 
							Thread.sleep(9000);
							
							//*[@id="mainleftmenu"]/div[2]/div[2]/div/ul/li[1]/a
							
//							WebDriverWait wait42 = new WebDriverWait(driver,30);
//						    WebElement homebtn = wait42.until(
//						     ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"home\"]")));
//						    homebtn.click(); 
//							Thread.sleep(9000);
//							
//							WebDriverWait wai1t = new WebDriverWait(driver,30);
//						    WebElement myJC1 = wai1t.until(
//						    ExpectedConditions.elementToBeClickable(By.id("automationidAO_1")));
//						    myJC1.click();
//						    
//							WebDriverWait wait41 = new WebDriverWait(driver,30);
//						    WebElement archivebtn = wait41.until(
//						     ExpectedConditions.elementToBeClickable(By.id("automationidAR_2")));
//						    archivebtn.click(); 
//							Thread.sleep(9000);
//							
//							WebDriverWait wait48 = new WebDriverWait(driver,30);
//						    WebElement archiverec = wait48.until(
//						     ExpectedConditions.elementToBeClickable(By.id("//*[@id=\"automationidAT_1\"]")));
//						    archiverec.click(); 
//							Thread.sleep(9000);
//							
//							
//							WebDriverWait wait43 = new WebDriverWait(driver,30);
//						    WebElement backbtn1 = wait43.until(
//						     ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mainleftmenu\"]/div[3]/div/ul/li[1]/a")));
//						    backbtn1.click(); 
//							//Thread.sleep(9000);
//						    
//							WebDriverWait wait52 = new WebDriverWait(driver,30);
//						    WebElement homebtn1 = wait52.until(
//						     ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"home\"]")));
//						    homebtn1.click(); 
//							TimeUnit.SECONDS.sleep(40);
							
							
							WebDriverWait wait53 = new WebDriverWait(driver,100);
							Thread.sleep(9000);
						    WebElement openarticle = wait53.until(
						     ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id=\"automationidBI_1_1\"]/i"))));
						        openarticle.click(); 
						        
							
							WebDriverWait btnplus = new WebDriverWait(driver,100);
						    WebElement plusbtn = btnplus.until(
						     ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"plusbtn\"]/i")));
						    plusbtn.click(); 
						    plusbtn.click();
						    plusbtn.click();
						    plusbtn.click();
						    
						    
						    
							WebDriverWait btnminus = new WebDriverWait(driver,100);
						    WebElement minusbtn = btnminus.until(
						     ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"minusbtn\"]/i")));
						    minusbtn.click(); 
						    minusbtn.click();
						    minusbtn.click();
						    minusbtn.click();
						  						
						    WebDriverWait back_button = new WebDriverWait(driver,100);
							Thread.sleep(9000);
						    WebElement button_back = back_button.until(
						     ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id=\"automationidDA\"]"))));
						    button_back.click();

					
		}
		  catch (Exception e){
		  System.out.println("I'm in exception no # 2");
	       //calls the method to take the screenshot.
			getscreenshot();
		 			  
			//Logout();
			
			//*[@class="ng-binding"]/ul/li[2]/a[2]
			 //  throw new SkipException("Skipping this exception");
	 	  }
		
	}
	
    
	/*public void Logout() throws Exception{
			
		try{
			
			driver.findElement(By.xpath("/html/body/header[1]/div/div[2]/div/div[1]")).click();;
			driver.findElement(By.xpath("//*[@id=\"logoutForm\"]/a")).click();;
			
		}
		
		 catch (Exception e){
			  System.out.println("I'm in exception no # 3");
		       //calls the method to take the screenshot.
				getscreenshot();
			 			  
				
				
				//*[@class="ng-binding"]/ul/li[2]/a[2]
				 //  throw new SkipException("Skipping this exception");
		 	  }
	
		
	}*/
	
	//After complete execution send pdf report by email
	@AfterSuite
	public static void tearDown(){
		sendPDFReportByGMail("mohusmanpasha@gmail.com", "Canada751123", "moh.usman.pasha@gmail.com", "mohusman.pasha@gmail.com", "PDF Report", "please check the attachment");
	}
	
	
	private static void sendPDFReportByGMail(String from, String pass, String to,String cc, String subject,String body) {
		// TODO Auto-generated method stub
		
		 Properties props = System.getProperties();
	        String host = "smtp.gmail.com";
	        props.put("mail.smtp.starttls.enable", "true");
	        props.put("mail.smtp.host", host);
	        props.put("mail.smtp.user", from);
	        props.put("mail.smtp.password", pass);
	        props.put("mail.smtp.port", "587");
	        props.put("mail.smtp.auth", "true");

	     // Get the default Session object.
	        Session session = Session.getDefaultInstance(props);
	        System.out.println("Message Send..4...");
	        // Create a default MimeMessage object.
	        MimeMessage message = new MimeMessage(session);

	        try {
	        	//Set from address
	            message.setFrom(new InternetAddress(from));
	             message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
	           //Set subject
	            message.setSubject(subject);
	            message.setText(body);
	          
	            BodyPart objMessageBodyPart = new MimeBodyPart();
	            
	            objMessageBodyPart.setText("Please Find The Attached Report File!");
	            
	            Multipart multipart = new MimeMultipart();

	            multipart.addBodyPart(objMessageBodyPart);

	            objMessageBodyPart = new MimeBodyPart();

	            //Set path to the pdf report file
	            String filename = "C:/Users/Xone-pc/Clinarwrkspc/mypdf/Clinicalpearl_Test_Report.pdf"; 
	            //Create data source to attach the file in mail
	            DataSource source = new FileDataSource(filename);
	            
	            objMessageBodyPart.setDataHandler(new DataHandler(source));

	            objMessageBodyPart.setFileName(filename);

	            multipart.addBodyPart(objMessageBodyPart);

	            message.setContent(multipart);
	            Transport transport = session.getTransport("smtp");
	            transport.connect(host, from, pass);
	            transport.sendMessage(message, message.getAllRecipients());
	            transport.close();
	        }
	        catch (AddressException ae) {
	            ae.printStackTrace();
	        }
	        catch (MessagingException me) {
	            me.printStackTrace();
	        }
		
	}

	//method to highlight
	public static void highlightelement(WebElement element) {
	for (int i = 0; i < 4; i++) {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript(
	"arguments[0].setAttribute(‘style’, arguments[1]);",element, "color: yellow; border: 4px solid blue;");
	js.executeScript("arguments[0].setAttribute(‘style’, arguments[1]);",
	element, "");
	}
	}
		
		 public void getscreenshot() throws Exception 
	 
		{
		 
		 
		 try{
		      {
	             File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	             String path = "C:/Users/Xone-pc/Clinarwrkspc/Error Screenshots/screensot - "+ formater.format(calendar.getTime()) + ".png";
	             FileUtils.copyFile(scrFile, new File(path));
	             System.out.println("Screenshot has been taken");
	     }

		}catch (IOException e) {
			e.printStackTrace();
			
		}
		 
		

		 
		 
		 
		
		
			

		 
		 
		
		
	
}
	
		
}
	
