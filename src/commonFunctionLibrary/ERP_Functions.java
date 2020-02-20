
package commonFunctionLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ERP_Functions {
	WebDriver driver;
	String res="";
	
	public String lanchAPP(String url){

		System.setProperty("webdriver.chrome.driver","D:\\sridevi_82\\StockAccounting_DDF\\drivers\\chromedriver.exe");
		 driver=new ChromeDriver();
		 
		 String res="";
			driver.get(url);
			
			driver.manage().window().maximize();
			if(driver.findElement(By.id("btnsubmit")).isDisplayed()){
				res="Pass";
			}else{
				res="Fail";
			}
			
			return res;
	}
	
	public String login(String username,String password ) throws Exception{
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys(username);
		
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(password);
		
		
		driver.findElement(By.id("btnsubmit")).click();
		
		Thread.sleep(5000);
		
		if(driver.findElement(By.id("logout")).isDisplayed()){
			res="Pass";
		}else{
			res="Fail";
		}
		
		return res;
		
	}
	

	public String supplier(String sname,String address,String city,String country,
			String cperson,String pnumber,String mail,String mnumber,String note) throws Exception{
		driver.findElement(By.linkText("Suppliers")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='ewContentColumn']/div[3]/div[1]/div[1]/div[1]/div/a")).click();
		Thread.sleep(5000);
		
		String exp_data=driver.findElement(By.id("x_Supplier_Number")).getAttribute("value");
		
		driver.findElement(By.id("x_Supplier_Name")).sendKeys(sname);
		driver.findElement(By.id("x_Address")).sendKeys(address);
		driver.findElement(By.id("x_City")).sendKeys(city);
		driver.findElement(By.id("x_Country")).sendKeys(country);
		driver.findElement(By.id("x_Contact_Person")).sendKeys(cperson);
		driver.findElement(By.id("x_Phone_Number")).sendKeys(pnumber);
		driver.findElement(By.id("x__Email")).sendKeys(mail);
		driver.findElement(By.id("x_Mobile_Number")).sendKeys(mnumber);
		driver.findElement(By.id("x_Notes")).sendKeys(note);
		
		driver.findElement(By.id("btnAction")).click();
		driver.findElement(By.xpath("//button[text()='OK!']")).click();
		driver.findElement(By.xpath("(//button[text()='OK'])[6]")).click();
		
		
		if(driver.findElement(By.id("psearch")).isDisplayed()){
			driver.findElement(By.id("psearch")).sendKeys(exp_data);
			driver.findElement(By.id("btnsubmit")).click();
			
			
		}else{
			driver.findElement(By.xpath("//*[@id='ewContentColumn']/div[2]/div[2]/div/button")).click();
			driver.findElement(By.id("psearch")).sendKeys(exp_data);
			driver.findElement(By.id("btnsubmit")).click();
		}
		
		String act_data=driver.findElement(By.xpath("//*[@id='el1_a_suppliers_Supplier_Number']/span")).getText();
		

		if(exp_data.equalsIgnoreCase(act_data)){
			res="Pass";
		}else{
			res="Fail";
		}
		
		return res;
		
	}
	
	public String logout() throws Exception {
		driver.findElement(By.linkText("Logout")).click();
		driver.findElement(By.xpath("//button[text()='OK!']")).click();
		
		Thread.sleep(5000);
		
		if(driver.findElement(By.id("btnsubmit")).isDisplayed()){
			res="Pass";
		}else{
			res="Fail";
		}
		
		return res;
		
	}
	
	public void closebrw()
	{
		driver.close();
	}
	
	

	}
	
	
		
	


