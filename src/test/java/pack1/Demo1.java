package pack1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class Demo1 {
    public static void main(String[]args){
        //System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver-win64/chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='http://www.orangehrm.com']"))).click();
       // driver.findElement(By.xpath("//a[@href='http://www.orangehrm.com']")).click();
       Set<String>st=driver.getWindowHandles();
        for (int i = 0; i <st.size(); i++) {
            String win=st.toArray()[i].toString();
            System.out.println(win);
            driver.switchTo().window(win);
            System.out.println(driver.getTitle());
        }
        driver.close();
    }
}
