package OrangeHRM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrangeHRMAutomation {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        String baseUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

        driver.get(baseUrl);

        if (driver.getCurrentUrl().contains("login"))
            System.out.println("ATC_L01 PASS - Application Launched");
        else
            System.out.println("ATC_L01 FAIL");
   	      Thread.sleep(3000);
        if (driver.getTitle().contains("OrangeHRM"))
            System.out.println("ATC_L02 PASS - Login Page Verified");
        else
            System.out.println("ATC_L02 FAIL");

        String type = driver.findElement(By.name("password")).getAttribute("type");
   	     Thread.sleep(3000);
        if (type.equals("password"))
            System.out.println("ATC_L06 PASS");
        else
            System.out.println("ATC_L06 FAIL");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        String required = driver.findElement(By.xpath("(//span[text()='Required'])[1]")).getText();
   	    Thread.sleep(3000);
        if (required.equals("Required"))
            System.out.println("ATC_L05 PASS");
        else
            System.out.println("ATC_L05 FAIL");

        driver.get(baseUrl);

        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("Wrong123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        String error = driver.findElement(By.xpath("//p[contains(@class,'alert-content-text')]")).getText();
   	    Thread.sleep(3000);
        if (error.equals("Invalid credentials"))
            System.out.println("ATC_L04 PASS");
        else
            System.out.println("ATC_L04 FAIL");
        driver.get(baseUrl);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//p[normalize-space()='Forgot your password?']"))).click();
   	    Thread.sleep(3000);
        if (driver.getCurrentUrl().contains("requestPasswordResetCode"))
            System.out.println("ATC_L07 PASS");
        else
            System.out.println("ATC_L07 FAIL");

        driver.get(baseUrl);
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
   	    Thread.sleep(3000);
        if (driver.getCurrentUrl().contains("dashboard"))
            System.out.println("ATC_L08 PASS");
        else
            System.out.println("ATC_L08 FAIL");
   	    Thread.sleep(3000);
        if (driver.findElement(By.xpath("//h6[text()='Dashboard']")).isDisplayed())
            System.out.println("ATC_L09 PASS");
        else
            System.out.println("ATC_L09 FAIL");
   	    Thread.sleep(3000);
        if (driver.findElement(By.xpath("//h6[text()='Dashboard']")).isDisplayed())
            System.out.println("ATC_D01 PASS");
        else
            System.out.println("ATC_D01 FAIL");
   	    Thread.sleep(3000);
        if (driver.getCurrentUrl().contains("dashboard"))
            System.out.println("ATC_D02 PASS");
        else
            System.out.println("ATC_D02 FAIL");
   	   Thread.sleep(3000);
        if (driver.getTitle().contains("OrangeHRM"))
            System.out.println("ATC_D03 PASS");
        else
            System.out.println("ATC_D03 FAIL");
   	    Thread.sleep(3000);
        if (driver.findElements(By.xpath("//h6[text()='Dashboard']")).size() > 0)
            System.out.println("ATC_D04 PASS");
        else
            System.out.println("ATC_D04 FAIL");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()='PIM']")).click();
   	   
        if (driver.getCurrentUrl().contains("pim"))
            System.out.println("ATC_D05 PASS");
        else
            System.out.println("ATC_D05 FAIL");

        driver.navigate().back();
   	    Thread.sleep(2000);
        if (driver.findElement(By.className("oxd-userdropdown-tab")).isDisplayed())
            System.out.println("ATC_D06 PASS");
        else
            System.out.println("ATC_D06 FAIL");

        driver.navigate().refresh();
   	    Thread.sleep(2000);
        if (driver.findElement(By.xpath("//h6[text()='Dashboard']")).isDisplayed())
            System.out.println("ATC_D07 PASS");
        else
            System.out.println("ATC_D07 FAIL");

        driver.findElement(By.className("oxd-userdropdown-tab")).click();

        Thread.sleep(2000);

        driver.findElement(By.linkText("Logout")).click();

        if (driver.getCurrentUrl().contains("login"))
            System.out.println("ATC_D08 PASS");
        else
            System.out.println("ATC_D08 FAIL");
        Thread.sleep(2000);
        driver.navigate().back();
        driver.navigate().refresh();

        if (driver.getCurrentUrl().contains("login"))
            System.out.println("ATC_L10 PASS");
        else
            System.out.println("ATC_L10 FAIL");

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
   	   Thread.sleep(2000);
        if (driver.getCurrentUrl().contains("login"))
            System.out.println("ATC_D09 PASS");
        else
            System.out.println("ATC_D09 FAIL");

        driver.quit();

        System.out.println("======================================");
        System.out.println("OrangeHRM Automation Completed");
        System.out.println("======================================");
    }
}