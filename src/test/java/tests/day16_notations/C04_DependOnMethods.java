package tests.day16_notations;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class C04_DependOnMethods {
    /*
    DependsOnMethods test methodlarinin calisma sirasina karismaz
    Sadece bagli olan test, baglandigi testin sonucuna bakar
    baglandigi test PASSED olmazsa, baglanan test hic calismaz(ignore)
     */

        WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test01() {
        driver.get("https://www.amazon.com");
    }

    @Test (dependsOnMethods = "test01", priority= 0)
    public void test02() {
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
    }

    @Test (dependsOnMethods = "test02")
    public void test03() {

        WebElement sonucYaziElementi= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        Assert.assertTrue(sonucYaziElementi.getText().contains("Nutella"));

    }
}
