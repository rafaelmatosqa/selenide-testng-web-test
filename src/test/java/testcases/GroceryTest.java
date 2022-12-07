package testcases;

import enums.EnumDropDownBootStrap;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.BaseTest;

public class GroceryTest  extends BaseTest {

    HomePage homePage = new HomePage();

    @Test()
    public void test_Register(){
        homePage.chooseTheme(EnumDropDownBootStrap.BOOTSTRAP_V4);

    }
}
