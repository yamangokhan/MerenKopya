package tests.day16_notations;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.TestBase;
public class C02_BeforeClass_AfterClass extends TestBase {
    //JUnitte @BeforeClass ve @AfterClass notasyonuna  sahip
    //methodlar static olmak zorundaydi
    //TestNG bu zorunluluktan bizi kuratriyor

    /*
    TestNG bize daha fazla before after notasyonlari sunar
    diger before/after notasyonlari tanimlayacagimiz
     grup, test veya sut'den once ve sonra calisirlar
     ileride xml dosyalari ile birlikte bunu gorecegiz
     */


    @BeforeClass
    public void beforeClassMethods() {
        System.out.println("Before Class");
    }
    @AfterClass
    public void afterClassMethods() {
        System.out.println("After Class");
    }
    @Test
    public void test01() {
        driver.get("https://www.amazon.com");
        System.out.println(driver.getCurrentUrl());
    }
    @Test
    public void test02() {
        driver.get("https://www.bestbuy.com");
        System.out.println(driver.getCurrentUrl());
    }
    @Test
    public void techproedTest() {
        driver.get("https://techproeducation.com/");
        System.out.println(driver.getCurrentUrl());
    }
}
