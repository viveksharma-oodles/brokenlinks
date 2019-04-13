package tooltip;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tooltip {

	public static void main(String[] args) {									
	     
        String baseUrl = "https://www.oodlestechnologies.com/contactus";					
        System.setProperty("webdriver.chrome.driver","/home/vivek/Downloads/chromedriver");					
        WebDriver driver = new ChromeDriver();					
        driver.get(baseUrl);					
        String expectedTooltip = "Zoom in";	
        
        // Find the view icon at the top right of the header		
        WebElement view = driver.findElement(By.xpath("//button[@title='Zoom in']"));	
        
        //get the value of the "title" attribute of the zoom-in icon		
        String actualTooltip = view.getAttribute("title");	
        
        //Assert the tooltip's value is as expected 		
        System.out.println("Actual Title of Tool Tip" +actualTooltip);							
        if(actualTooltip.equals(expectedTooltip)) {							
            System.out.println("Test Case Passed");					
        }		
        driver.close();			
   }		
}		
	
