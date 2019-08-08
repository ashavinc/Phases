package com.Phase2.SfdcTestCases;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class Phase2RemainingTestcasesTest extends ReusableMethods{
	
	
	
	@AfterClass
	public static void logger()
	{
	ReusableMethods.report.endTest(logger);
		ReusableMethods.report.flush();
	}
	
		
	public static void initialize_driver() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Vincent Mari\\drivers\\chromedriver_win32 (1)\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

	}
	
	public static void launchUrl() {
		initialize_driver();
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		System.out.println("Salesforce application opened");
	}
	 public static void login() throws InterruptedException
		
		{
			WebElement Uname=driver.findElement(By.xpath("//input[@id='username']"));
			enterText(Uname, "vincentpremkumar-glxf@force.com", "UserName");
			WebElement pwd=driver.findElement(By.xpath("//input[@id='password']"));
			pwd.clear();
			enterText(pwd, "salesforce1", "Password");
			
		    WebElement login = driver.findElement(By.xpath("//*[@id='Login']"));
		    clickObj(login, "login");
		
		}
	
	@Test 
	public static void tc_05() throws InterruptedException{
		CreateTestScriptReport("TC05_UserMenuDropDown");
		initialize_driver();
		launchUrl();
		login();
		 Thread.sleep(3000); 
	WebElement clickdropdown=driver.findElement(By.id("userNavButton"));
	
	clickObj(clickdropdown, "clickdropdown");

	Thread.sleep(3000);
	}
	
	@Test 
	public static void tc_06() throws InterruptedException {
		CreateTestScriptReport("TC06_MyProfile");
		initialize_driver();
		launchUrl();
		login();

	//to select myprofile
		WebElement clickdropdown=driver.findElement(By.id("userNavButton"));
		clickObj(clickdropdown, "clickdropdown");
	WebElement profiledropdown=driver.findElement(By.xpath("//a[contains(text(),'My Profile')]"));
	clickObj(profiledropdown,"profile");
	//profiledropdown.click();
		//edit contact
	WebElement editbutton=driver.findElement(By.xpath("//a[@class='contactInfoLaunch editLink']//img"));
	clickObj(editbutton, "Editbutton");
	//editbutton.click();
	Thread.sleep(5000);
	
	//move to About tab

	driver.switchTo().frame("contactInfoContentId");
	WebElement abouttab=driver.findElement(By.xpath("//li[@id='aboutTab']"));
	clickObj(abouttab, "Abouttab");	
	//abouttab.click();
		Thread.sleep(5000);
    
	//edit lastname
	WebElement lastnameedit=driver.findElement(By.xpath("//input[@id='lastName']"));
	lastnameedit.clear();
	lastnameedit.sendKeys("gfdgdfg");
	Thread.sleep(5000);
	
	//save all button
	WebElement saveallbutton=driver.findElement(By.xpath("//input[@class='zen-btn zen-primaryBtn zen-pas']"));
	clickObj(saveallbutton, "SaveAll");
	//saveallbutton.click();
	Thread.sleep(5000);
	
	//post
	WebElement post=driver.findElement(By.xpath("//span[contains(@class,'publisherattachtext')][contains(text(),'Post')]"));
	clickObj(post, "post");
	//post.click();
	Thread.sleep(3000);
	
	WebElement frame=driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']"));
	switchFrame(driver,frame);
	//driver.switchTo().frame(frame);
	
	String message="India wins";
	WebElement textbox=driver.findElement(By.xpath("/html[1]/body[1]"));
	textbox.sendKeys(message);
	driver.switchTo().defaultContent();
	Thread.sleep(5000);

	WebElement sharebutton=driver.findElement(By.xpath("//input[@id='publishersharebutton']"));
	clickObj(sharebutton, "Sharebutton");
	//sharebutton.click();
	Thread.sleep(5000);
	
	WebElement file = driver.findElement(By.xpath("//span[contains(@class,'publisherattachtext')][contains(text(),'File')]"));
	clickObj(file, "file");
	//file.click();
	WebElement fileuploadbutton=driver.findElement(By.xpath("//a[@id='chatterUploadFileAction']"));
	clickObj(fileuploadbutton,"fileupload");
	//fileuploadbutton.click();
	
	WebElement choosefile=driver.findElement(By.xpath("//input[@id='chatterFile']"));
	choosefile.sendKeys("C:\\Users\\Vincent Mari\\Documents\\file.txt");
	
	WebElement share=driver.findElement(By.xpath("//input[@id='publishersharebutton']"));
	share.click();
	Thread.sleep(5000);
	
	WebElement photoupload=driver.findElement(By.xpath("//span[@id='displayBadge']"));
	photoupload.click();
	driver.switchTo().frame("uploadPhotoContentId");
	Thread.sleep(5000);

	
	WebElement choosepicfile=driver.findElement(By.xpath("//input[@id='j_id0:uploadFileForm:uploadInputFile']"));
	choosepicfile.sendKeys("C:\\Users\\Vincent Mari\\140.jpg");
    Thread.sleep(5000);
		
//  Runtime.getRuntime().exec("C:\\Users\\Vincent Mari\\AutoIt\\ImageUpload.exe");		
//   Thread.sleep(5000);
//
    WebElement savephoto=driver.findElement(By.xpath("//input[@id='j_id0:j_id7:save']"));
    savephoto.click();
    Thread.sleep(3000);
	}

    @Test
    public static void tc_07() throws InterruptedException{
    	CreateTestScriptReport("TC07_MySettings");
		initialize_driver();
		launchUrl();
		login();

	
    WebElement drpdown=driver.findElement(By.id("userNavButton"));
	drpdown.click();
	Thread.sleep(5000);
	WebElement mysettings=driver.findElement(By.xpath("//a[contains(text(),'My Settings')]"));
	mysettings.click();
	Thread.sleep(5000);
	
	WebElement personal=driver.findElement(By.xpath("//div[@id='PersonalInfo']//a[@class='header setupFolder']"));
	personal.click();
	Thread.sleep(5000);
	
	WebElement loginhistory=driver.findElement(By.xpath("//span[@id='LoginHistory_font']"));
	loginhistory.click();
	Thread.sleep(5000);
	
	//WebElement downloadloginhistory=driver.findElement(By.linkText("Download login history for last six months, including logins from outside the website, such as API logins (Excel .csv file) »"));
	//downloadloginhistory.click();
	
	WebElement displaylayout=driver.findElement(By.xpath("//div[@id='DisplayAndLayout']//a[@class='header setupFolder']"));
	displaylayout.click();
	
	WebElement mytabs=driver.findElement(By.xpath("//a[@id='CustomizeTabs_font']"));
	mytabs.click();
	
	
	WebElement customApp=driver.findElement(By.xpath("//select[@id='p4']"));
	Select chatter=new Select(customApp);
	chatter.selectByValue("02u4P0000017iUY");
	Thread.sleep(5000);
	
	WebElement availableTabs=driver.findElement(By.xpath("//select[@id='duel_select_0']"));
	Select reportselect=new Select(availableTabs);
	reportselect.selectByValue("report");
	Thread.sleep(5000);
	
	
	WebElement addarrow=driver.findElement(By.xpath("//img[@class='rightArrowIcon']"));
	addarrow.click();
	Thread.sleep(5000);
		
	WebElement email=driver.findElement(By.xpath("//div[@id='EmailSetup']//a[@class='header setupFolder']"));
	email.click();
	
	
	WebElement emailsettings=driver.findElement(By.xpath("//div[@id='EmailSetup']//a[@class='header setupFolder']"));
	emailsettings.click();
	
	WebElement calendersremainders=driver.findElement(By.xpath("//span[@id='CalendarAndReminders_font']"));
	calendersremainders.click();
	Thread.sleep(5000);
	WebElement reminders=driver.findElement(By.xpath("//span[@id='Reminders_font']"));
	reminders.click();
		Thread.sleep(5000);
	
	WebElement reminderbutton=driver.findElement(By.xpath("//input[@id='testbtn']"));
	reminderbutton.click();
	Thread.sleep(5000);
	}
    
    @Test
    public static void tc_08() throws Exception {
    	CreateTestScriptReport("TC08_DevConsole");
		initialize_driver();
		launchUrl();
		login();
		Thread.sleep(3000);

	WebElement dpdown=driver.findElement(By.id("userNavButton"));
	dpdown.click();
	Thread.sleep(5000);
	WebElement developerconsole=driver.findElement(By.xpath("//a[@class='debugLogLink menuButtonMenuLink']"));
	developerconsole.click();
	Thread.sleep(5000);
    }

	
	@Test
 public static void tc_09() throws InterruptedException {   
		CreateTestScriptReport("TC09_Logout");
		initialize_driver();
		launchUrl();
		login();
		Thread.sleep(3000);

	WebElement drpdwn=driver.findElement(By.id("userNavButton"));
		drpdwn.click();
	
	Thread.sleep(5000);
	WebElement logout=driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
	logout.click();
	Thread.sleep(5000);
	}

//--------------------------------------------------------------------------------------
	
	@Test
	public static void tc_10() throws InterruptedException {
		CreateTestScriptReport("TC10_Account");
		initialize_driver();
		launchUrl();
		login();
		 Thread.sleep(3000);
	
		 WebElement Account = driver.findElement(By.xpath("//a[contains(@title,'Accounts Tab')]"));
			clickObj(Account, "Account");

			WebElement new_Element = driver.findElement(By.xpath("//input[contains(@title,'New')]"));
			clickObj(new_Element, "new_Element");
			
			WebElement account_name = driver.findElement(By.xpath("//input[@id='acc2']"));
			//account_name.clear();
			enterText(account_name, "accountss", "AccountName");

			WebElement save = driver.findElement(By.xpath(" //td[@id='bottomButtonRow']//input[@title='Save']"));
			clickObj(save, "SaveButton");
			driver.close();
			Thread.sleep(3000);
		
		}

	}
	
	
