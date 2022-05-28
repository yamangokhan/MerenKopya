package tests.day18_pom;

import org.testng.annotations.Test;
import utilities.Driver;

public class C01_ConfigReader {

    @Test
    public void test01() {

        Driver.getDriver().get("amazonUrl");
        Driver.getDriver().get("facebookUrl");


    }
}
