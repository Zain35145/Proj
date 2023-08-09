package browser;


	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import io.github.bonigarcia.wdm.WebDriverManager;

	public class slee {
	    public static void main(String[] args) {
	        // Set up Chrome driver using WebDriverManager
	        WebDriverManager.chromedriver().setup();

	        // Create a new ChromeDriver instance
	        WebDriver driver = new ChromeDriver();

	        // Open Google in the browser
	        driver.get("https://www.google.com");

	        // Get the page title
	        String pageTitle = driver.getTitle();

	        // Check if the title is displayed
	        boolean isTitleDisplayed = pageTitle != null && !pageTitle.isEmpty();

	        // Print test result
	        if (isTitleDisplayed) {
	            System.out.println("Test Case Passed: Page title is displayed - " + pageTitle);
	        } else {
	            System.out.println("Test Case Failed: Page title is not displayed");
	        }

	        // Close the browser
	        driver.quit();
	    }
	}



