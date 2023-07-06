package Login;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class Tests {
    @Test
    public void A_successful_login() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.get("https://em.alqemam.com/ET_Final_V12.3.00/login.aspx");
        driver.findElement(By.id("txtUserName")).sendKeys("3333336");
        driver.findElement(By.id("txtUserPass")).sendKeys("24602460");
        driver.findElement(By.id("btnLogin")).click();
        String actual_Result = driver.findElement(By.cssSelector("#cph_main_main_adv_srch > h1")).getText();
        String expected_Result = "بحث سريع بالمعاملات";
        assertTrue(actual_Result.contains(expected_Result));
    }

    @Test
    public void B_invalid_username() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.get("https://em.alqemam.com/ET_Final_V12.3.00/login.aspx");
        driver.findElement(By.id("txtUserName")).sendKeys("11111111111111");
        driver.findElement(By.id("txtUserPass")).sendKeys("24602460");
        driver.findElement(By.id("btnLogin")).click();
        String actual_result = driver.findElement(By.cssSelector("#error_div > label")).getText();
        String expected_result = "عفوا، محاولة غير صالحة لتسجيل الدخول";
        assertTrue(actual_result.contains(expected_result));
    }

    @Test
    public void C_invalid_pass() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.get("https://em.alqemam.com/ET_Final_V12.3.00/login.aspx");
        driver.findElement(By.id("txtUserName")).sendKeys("3333336");
        driver.findElement(By.id("txtUserPass")).sendKeys("666666666666666");
        driver.findElement(By.id("btnLogin")).click();
        String actual_result = driver.findElement(By.cssSelector("#error_div > label:nth-child(1)")).getText();
        System.out.println(actual_result);
        String expected_result = "عفواً، محاولة غير صالحة لتسجيل الدخول";
        assertTrue(actual_result.contains(expected_result));
    }

}
