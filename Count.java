package com.tests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Count {
	WebDriver driver;
	
	
	@Test(priority=1)
	  public void beforeTest() throws InterruptedException {
	      System.setProperty("webdriver.chrome.driver", "D:\\AccentureTesting\\chromedriver.exe");
	         driver = new ChromeDriver();
	        Thread.sleep(1000);
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	        driver.get("http://www.google.com");
	        Thread.sleep(1000); 
	       
	        driver.get ( "http://www.newtours.demoaut.com/mercuryregister.php");

	 }
	
	@Test(priority=2)
	public void country_names()  {
		
		WebElement ele=driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[12]/td[2]/select"));
	     Select s=new Select(ele);
	     List<WebElement>l=s.getOptions();
	      int n=l.size();
	      System.out.println("Total count = "+n);
	    //  India Xpath
	    String text=driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[12]/td[2]/select/option[108]")).getText();
	     System.out.println(text);
	       for(int i=0;i<n;i++)
	       {
	          String s1= l.get(i).getText();
	           System.out.println(s1);
	           if(s1.equalsIgnoreCase(text))                                                                                   // if(l.get(i).getText().equalsIgnoreCase("INDIA"))
	         {
	              System.out.println("India is present in list");
	              break;
	          }
	       }
	}    
}
