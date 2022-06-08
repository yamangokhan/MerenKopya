package tests.day21_ReusablleMethods_HtmlReports;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C03_pozitifLoginTestiRaporlu extends TestBaseRapor {
    BrcPage brcPage= new BrcPage();

    @Test
    public void test01() {
        extentTest=extentReports.createTest("Pozitif Login","Gecerli username ve sifre ile gecis yapabilmeli");

        // Bir test method olustur positiveLoginTest()
        //https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));
        extentTest.info("Brc anasayfaya gidildi");
        //login butonuna bas
        brcPage.ilkLoginButonu.click();
        extentTest.info("Login butonuna tiklandi");
        //test data user email: customer@bluerentalcars.com
        brcPage.emailTextBox.sendKeys(ConfigReader.getProperty("brcValidEmail"));
        extentTest.info("Gecerli email yazildi");
        //test data password : 12345
        brcPage.passwordTextBox.sendKeys(ConfigReader.getProperty("brcValidPassword"));
        extentTest.info("Gecerli passwor yazildi");
        //login butonuna tiklayin
        brcPage.ikinciLoginButonu.click();
        extentTest.info("Login butonuna basildi");
        //Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et

        String actualUsername=brcPage.kullaniciProfilIsmi.getText();
        String expectedUsername= ConfigReader.getProperty("brcValidUsername");
        Assert.assertEquals(expectedUsername,actualUsername);
        extentTest.pass("kullanici basarili sekilde giris yapti");

        Driver.closeDriver();

    }

}
