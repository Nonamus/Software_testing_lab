import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
Test case for looking on a capability of taken tickets for only childs
Expected value: We can't get some tickets with our conditions
 */

public class TestCase {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

        String url = "https://aviago.by/";

        WebDriver driver = new ChromeDriver();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.get(url);

        driver.findElement(By.xpath( "//*[@id=\"pax\"]/div[2]/div[2]/span/a[1]" )).click();

        driver.findElement(By.xpath( "//*[@id=\"pax\"]/div[1]/div[2]/span/a[2]" )).click();

        driver.findElement(By.xpath("//*[@id=\"cty0\"]")).sendKeys("Minsk");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[2]")));

        driver.findElement(By.xpath("/html/body/div[3]/div[2]")).click();

        driver.findElement(By.xpath("//*[@id=\"cty1\"]")).sendKeys("Moscow");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[2]")));

        driver.findElement(By.xpath("/html/body/div[4]/div[2]")).click();


        driver.findElement(By.xpath("//*[@id=\"sf\"]/div[3]/div[2]/div")).submit();

        if(driver.findElements(By.id("searchResList")).size() == 0)
        {
            System.out.println("Test case complete without any wrong situations");
        }
        else
        {
            System.out.println("Test case complete badly. we mustn't take any tickets with only child passengers");
        }

        driver.close();

    }
}