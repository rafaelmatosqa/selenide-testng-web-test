package pages;

import com.codeborne.selenide.SelenideElement;
import enums.EnumDropDownBootStrap;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;



public class HomePage {

    SelenideElement bootstrapElement = $(By.cssSelector("#switch-version-select"));

    public void chooseTheme(EnumDropDownBootStrap bootstrapDropDownOption){

            $(bootstrapElement).selectOptionContainingText(bootstrapDropDownOption.getValues());

            }
        }





