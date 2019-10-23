package Feature.Orange_HRM;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static Feature.Orange_HRM.BasePage.driver;
import static Feature.Orange_HRM.Utils.longDateStamp;
import static org.seleniumhq.jetty9.util.IO.copyFile;

public class Hooks extends BasePage{
    BrowserSelector browserSelector = new BrowserSelector();
    LoadProps loadProps = new LoadProps();

    @Before   //take cucumber.api's dependency
    public void setUpBrowser() {
        browserSelector.setUpBrowser();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/");
    }

    @After
    public void closeBrowser(Scenario scenario)
    {
        if(scenario.isFailed())
        {
            String screenshotName = scenario.getName().replaceAll("[.,:;?!]","")+longDateStamp()+".png";
            try
            {
                //This takes a screenshot from the driver at save it to the specified location
                File sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
                //Building up the destination path for the screenshot to save
                //Also make sure to create a folder 'screenshots' with in the cucumber-report folder
                File destinationPath = new File(System.getProperty("user.dir")+"/target/Destination/screenshots/"+screenshotName);
                //copy taken screenshot from source location to destination location
                copyFile(sourcePath, destinationPath);
                scenario.embed(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES), "image/png");
            }
            catch (IOException e)
            {
            }
        }
        driver.quit();
    }
}
