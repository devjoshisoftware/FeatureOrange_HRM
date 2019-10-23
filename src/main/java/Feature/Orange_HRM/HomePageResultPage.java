package Feature.Orange_HRM;

import org.openqa.selenium.By;
import org.testng.Assert;

public class HomePageResultPage extends Utils {
    public void verifyIsOnHomepage()
    {
        assertEqualURL("https://opensource-demo.orangehrmlive.com/");
    }
    public void verifyValidLogin(String login_message)
    {
        String text = driver.findElement(By.linkText(login_message)).getText();
        Assert.assertEquals(text, login_message);
        System.out.println(text);
    }
    public void verifyInvalidLogin(String login_message)
    {
        String text = driver.findElement(By.cssSelector("#spanMessage,"+login_message)).getText();
        System.out.println(text);
        Assert.assertEquals(login_message,text);
    }
}
