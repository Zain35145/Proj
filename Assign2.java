package Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assign2 {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();



        // Create a new ChromeDriver instance
        ChromeDriver driver = new ChromeDriver();


        // Open Google in the browser
        driver.get("https://omayo.blogspot.in/");

        // Get the page title
        //String pageTitle = driver.getTitle()s;

		WebElement text_field_1=driver.findElement(By.xpath("//textarea[@id='ta1']"));
		text_field_1.sendKeys("Zain is resilient !");

		WebElement text_field_2 = driver.findElement(By.xpath("//div[@id='HTML11']//div[@class='widget-content']//textarea"));
		text_field_2.getText();
		String written_text= text_field_2.getText().toString();
		System.out.print(written_text + "\t" + "\n");
		text_field_2.clear();
		text_field_2.sendKeys("Zain is unappologetically opinionated !");
		WebElement field_username = driver.findElement(By.xpath("//form[@name='form1']//input[@type='text']"));
		field_username.sendKeys("Zain-Ul-Hassan");
		WebElement field_password = driver.findElement(By.xpath("//form[@name='form1']//input[@type='password']"));
		field_password.sendKeys("12345Zain");
		WebElement login_button = driver.findElement(By.xpath("//form[@name='form1']//button[@type='button']"));
		login_button.click();
		driver.switchTo().frame("iframe1");
		driver.switchTo().defaultContent();
		driver.switchTo().frame("iframe2");
		driver.switchTo().defaultContent();
		WebElement user_name = driver.findElement(By.xpath("//form[@name='login']//input[@name='userid']"));
	    user_name.sendKeys("Zain-Ul-Hassan");
	    WebElement password_ = driver.findElement(By.xpath("//form[@name='login']//input[@name='pswrd']"));
	    password_.sendKeys("12345Zain");
	    WebElement login_2 = driver.findElement(By.xpath("//form[@name='login']//input[@value='Login']"));
	    login_2.click();
	       
	    driver.switchTo().alert().accept();
	    
	     WebElement table = driver.findElement(By.xpath("//table[contains(@id,'table')]")); 
	     
        // Get all rows within the table
	     
	     List<WebElement> rows1 = table.findElements(By.tagName("thead"));
	        

         // Iterate through rows
     for (WebElement row1 : rows1) {
         // Get all cells within the row
         List<WebElement> cells1 = row1.findElements(By.tagName("th"));

         // Iterate through cells

         for (WebElement cell1 : cells1) {
             // Print cell text
             System.out.print(cell1.getText() + "\t");
         }

         System.out.println(); // Move to the next line for the next row
     }
	     

        List<WebElement> rows = table.findElements(By.tagName("tr"));
        

            // Iterate through rows
        for (WebElement row : rows) {
        	
            // Get all cells within the row
            List<WebElement> cells = row.findElements(By.tagName("td"));

            // Iterate through cells

            for (WebElement cell : cells) {
                // Print cell text
                System.out.print(cell.getText() + "\t");
                
                
            }

            
            System.out.println(); // Move to the next line for the next row
            
        }
        WebElement multis = driver.findElement(By.xpath("//select[contains(@id,'multiselect')]"));
        Select multi=new Select(multis);
        multi.selectByVisibleText("Hyundai");
        WebElement fstdd = driver.findElement(By.xpath("//select[contains(@id,'drop')]"));
        Select select1=new Select(fstdd);
       select1.selectByVisibleText("doc 3");
       WebElement  pretext = driver.findElement(By.xpath("//div[@class='widget-content']//input[@name='fname']"));
       pretext.clear();
       pretext.sendKeys("Hello World!");
       WebElement clickE = driver.findElement(By.id("//div[@class='widget-content']//button[contains(@id, 'but')]"));
       clickE.click();
       
//       WebElement click1= driver.findElement(By.xpath("//div[@class='widget-content']//button[contains(@id, 'but')]"));
//       click1.click();
//       WebElement click2 = driver.findElement(By.xpath("//div[@class='widget-content']//button[contains(@id, 'but')]"));
//       click2.click();
//       
//       WebElement click3 = driver.findElement(By.xpath("//div[@class='widget-content']//button[contains(@id, 'but')]"));
//       click3.click();
//       
//       
       
       List<WebElement> allbuttons=driver.findElements(By.xpath("//div[@class='widget-content']//button[contains(@name, 'samename')]"));
       int[] indices = {0,2};
       for (int index : indices) {
    	   if(index >= 0 && index < allbuttons.size()) {
    		   allbuttons.get(index).click();
    	   }
    	   
       }
		

	}
	

}
