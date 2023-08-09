package browser;
import org.openqa.selenium.*;

import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.interactions.Actions;
import java.util.List;


public class task2 {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        Actions actions = new Actions(driver);

        try {
            // Step 0
            driver.get("https://omayo.blogspot.in/");
            // Explore the site
            
            // Step 1
            WebElement nameField = driver.findElement(By.xpath("//input[@id='text1']"));
            nameField.sendKeys("Your Name");
            
            WebElement textField2 = driver.findElement(By.xpath("//input[@id='text2']"));
            String textData = textField2.getAttribute("value");
            textField2.clear();
            textField2.sendKeys("Description about my personality");
            
            // Step 2
            List<WebElement> tableRows = driver.findElements(By.xpath("//table[@id='webtable']/tbody/tr"));
            for (WebElement row : tableRows) {
                List<WebElement> cells = row.findElements(By.tagName("td"));
                for (WebElement cell : cells) {
                    System.out.print(cell.getText() + "\t");
                }
                System.out.println();
            }
            
            // Rest of the steps...
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
