package day16_notations;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

public class C06_SoftAssert extends TestBase {
    @Test
    public void test01() {
        /*
        Softassertion baslangic ve bitis satirlari arasindaki
        tum assertionlari yapip
        bitis satirina geldiginde bize buldugu tum hatalari rapor eder
         */
        // softassert baslangici obje olusturmaktir
        SoftAssert softAssert= new SoftAssert();

        //1- amazon sayfasina gidin
        driver.get("https://www.amazon.com");
        //2- title'in Amazon icerdigini test edin
        String expectedTitle= "amazon";
        String actualTitle= driver.getTitle();
        softAssert.assertTrue(actualTitle.contains(expectedTitle));
        //3- aram kutusunun erisebilir oldugunu kontrol edin
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        softAssert.assertTrue(aramaKutusu.isEnabled());
        //4- arama kutusuna nutella yazip aratin
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
        //5- arama yapildigini test edin
        WebElement sonucYaziElementi= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        softAssert.assertTrue(sonucYaziElementi.isDisplayed());
        //6- arama sonucunun Nutella icerdigini test edin
        softAssert.assertTrue(sonucYaziElementi.getText().contains("Kutella"));

        //sofassert'e bitis satirini soylemek icin assertAll() kullanilir
        softAssert.assertAll();

    }
}
