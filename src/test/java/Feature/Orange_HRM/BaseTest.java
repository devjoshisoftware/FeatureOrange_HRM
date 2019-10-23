package Feature.Orange_HRM;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static Feature.Orange_HRM.BasePage.driver;

public class BaseTest {
    BrowserSelector browserSelector = new BrowserSelector();
    static String timeStamp = new SimpleDateFormat("dd.MM.yy.HH.mm.ss").format(new Date());

    @BeforeTest
    public void openBrowser()
    {
        browserSelector.setUpBrowser();
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");
    }
    @AfterTest
    public void tearDown()
    {

        driver.quit();
    }
}
