package brokenlinks;


//import java.net.URL;
//import java.net.HttpURLConnection;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//public class brokenlink {
//
//	private static final String HttpURLConnection = null;
//
//	public static void main(String[] args) {
//		
//		System.setProperty("webdriver.chrome.driver", "/home/vivek/Documents/driver/chromedriver");
//		WebDriver driver=new ChromeDriver();
//		driver.get("http://www.amazon.com");
//
//		List<WebElement> linkslist = driver.findElements(By.tagName("a"));;
//		linkslist.addAll(driver.findElements(By.tagName("img")));
//		
//		List<WebElement> activelinks=new ArrayList<WebElement>();
//        
//		for(int i=0;i<linkslist.size();i++) {
//			System.out.println(linkslist.get(i).getAttribute("href"));
//						
//			if(linkslist.get(i).getAttribute("href")!=null) {
//			activelinks.add(linkslist.get(i));
//          
//			System.out.println("size of active links and images"+activelinks.size());
//			
//			for(int j=0;j<activelinks.size();j++)
//			{
//				(HttpURLConnection)new URL(activelinks.get(j).getAttribute("href").open
//
//
//		
//		
//
//	}
//
//		}
//	}
//}
import java.util.List;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class brokenlink {
	
	public static void main(String[] args) throws InterruptedException, MalformedURLException, IOException {

		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\VIVEK\\Downloads\\automnoodls\\chromedriver.exe/");
		
		//FirefoxOptions options = new FirefoxOptions();
		//options.setCapability("marionette", false);
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://vwo.com/");
		
		java.util.List<WebElement> linkslist = driver.findElements(By.tagName("a"));
		linkslist.addAll(driver.findElements(By.tagName("img")));
		
		System.out.println("size of linkslist and imgs are:"+linkslist.size());
		
		
		List<WebElement> activelinks=new ArrayList<WebElement>();
		
		for(int i=0;i<linkslist.size();i++) {
			System.out.println(linkslist.get(i).getAttribute("href"));
			
			if(linkslist.get(i).getAttribute("href")!= null && (!linkslist.get(i).getAttribute("href").contains("tel")&& (!linkslist.get(i).getAttribute("href").contains("mailto:") ))) {
				activelinks.add(linkslist.get(i));
				
				
				
				
				
			}
		}
		System.out.println("size ofactive linkand imgs are:"+activelinks.size());

		
		
		for(int j=0; j<activelinks.size();j++) {
			
			HttpURLConnection connection=(HttpURLConnection)new URL(activelinks.get(j).getAttribute("href")).openConnection();
			
			connection.connect();
			String response=connection.getResponseMessage();
			connection.disconnect();
			
			System.out.println(activelinks.get(j).getAttribute("href")+"--->"+response);
					
					
					
					
					
					
					
					
			
		}

}
}
