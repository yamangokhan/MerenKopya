package tests.day22_crossBrowser;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_DataProvider {

    @Test
    public void test01() {
        AmazonPage amazonPage=new AmazonPage();
        // amazon anasayfaya gidelim
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        //nutella icin aram yapalim
        amazonPage.aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
        //sonuclarin nutella icerdigini testedelim
        String expectedKelime = "Nutella";
        String actualSonucYazisi= amazonPage.aramaSonucElementi.getText();

        Assert.assertTrue(actualSonucYazisi.contains(expectedKelime));
        
        //sayfayi kapatalim
        Driver.closeDriver();
    }

    @DataProvider
    public static Object[][] AranacakKelimeler() {
        Object[][] arananKelimeArray= {{"Nutella"}, {"Java"}, {"cigdem"}, {"Netherlands"}};
        return arananKelimeArray;
    }

    @Test(dataProvider = "AranacakKelimeler")
    //arayacagimiz kelimeleri bir liste gibi tutup
    //bana yollayacak bir veri saglayicisi olusturulacak
    public void test02(String arananKelime) {
        AmazonPage amazonPage=new AmazonPage();
        // amazon anasayfaya gidelim
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        //Nutella, Java, cigdem ve Netherlands icin arama yapalim
        amazonPage.aramaKutusu.sendKeys(arananKelime+ Keys.ENTER);
        //sonuclarin aradigimiz kelime icerdigini test edelim
        String expectedKelime = arananKelime;
        String actualSonucYazisi= amazonPage.aramaSonucElementi.getText();
        Assert.assertTrue(actualSonucYazisi.contains(expectedKelime));
        //sayfayi kapatir
        Driver.closeDriver();
    }
}
