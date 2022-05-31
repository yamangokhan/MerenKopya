package tests.practise;

import org.testng.annotations.Test;
import utilities.Driver;
import utilities.TestBase;

public class Q2_DependsOn extends TestBase {
           /*
    birbirine bagimli testler olusturun..
    .beforClass olusturup setUp ayarlarini yapin..
      birbirine bagimli testler olusturarak;
          ilk once facebook a gidin
          sonra facebook a bagimli olarak google a gidin,
          daha sonra google a bagimli olarak amazon a gidin
    driver i kapatin
 */

    @Test
    public void facebookTest(){
        Driver.getDriver().get("https://www.facebook.com");

    }

    @Test (dependsOnMethods = "facebookTest")
    public void googleTest(){
        Driver.getDriver().get("https://www.google.com");
    }

    @Test(dependsOnMethods = "googleTest")
    public void amazonTest() {
        Driver.getDriver().get("https://www.amazon.com");
    }

}
