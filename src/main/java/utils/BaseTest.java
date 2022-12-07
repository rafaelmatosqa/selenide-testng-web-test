package utils;


import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;


import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static java.lang.invoke.MethodHandles.lookup;

public class BaseTest {

    private final static Logger logger = LoggerFactory.getLogger(lookup().lookupClass());
    private final static String selenideProperties = "selenide.properties";



    @BeforeClass
    protected void setupClass() throws IOException {

        Properties props = new Properties();
        InputStream inputStream = BaseTest.class
                .getClassLoader()
                .getResourceAsStream(selenideProperties);
        props.load(inputStream);

        if (!props.isEmpty()) {
            for (Object propObj : props.keySet()) {
                String prop = String.valueOf(propObj);

                if (!System.getProperties().containsKey(prop)) {
                    System.setProperty(prop, props.getProperty(prop));
                }
            }
        }

        logger.info("Loading selenide properties as {}", selenideProperties);
    }

    @AfterClass
    protected void cleanupClass() {
        SelenideLogger.removeListener("AllureSelenide");
        if (WebDriverRunner.hasWebDriverStarted()) WebDriverRunner.closeWebDriver();
    }

    @BeforeMethod
    protected void setupTest() {
         open("/v1.x/demo/my_boss_is_in_a_hurry/bootstrap");

    }

    @AfterMethod
    protected void cleanupTest() {
        closeWebDriver();
    }
}

