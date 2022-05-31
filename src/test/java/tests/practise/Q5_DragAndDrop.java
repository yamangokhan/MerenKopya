package tests.practise;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.DHtmlGoodiesPage;
import utilities.Driver;

public class Q5_DragAndDrop {
    // Go to URL : http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html
    // Fill in capitals by country.


    @Test
    public void test() {

        Driver.getDriver().get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");

        DHtmlGoodiesPage dhtmlPage= new DHtmlGoodiesPage();
        Actions actions= new Actions(Driver.getDriver());

        actions.dragAndDrop(dhtmlPage.oslo,dhtmlPage.norway)
                .dragAndDrop(dhtmlPage.stockholm,dhtmlPage.sweden)
                .dragAndDrop(dhtmlPage.washington,dhtmlPage.unitedStates)
                .dragAndDrop(dhtmlPage.copehagen,dhtmlPage.danimark)
                .dragAndDrop(dhtmlPage.seoul,dhtmlPage.southKorea)
                .dragAndDrop(dhtmlPage.madrid,dhtmlPage.spain)
                .dragAndDrop(dhtmlPage.roma,dhtmlPage.italy)
                .perform();

        Driver.closeDriver();
    }
}
