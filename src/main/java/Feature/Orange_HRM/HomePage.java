package Feature.Orange_HRM;

import org.openqa.selenium.By;

public class HomePage extends Utils {
    private By _enterUserName = By.id("txtUsername");
    private By _enterPassword = By.id("txtPassword");
    private By _clickLOGIN = By.id("btnLogin");

    public void enterValidLoginInformation()
    {
        sendText(_enterUserName,"Admin");
        sendText(_enterPassword,"admin123");
        clickOnElement(_clickLOGIN);
    }

    public void enterInvalidLoginInformation(String username, String password)
    {
        sendText(_enterUserName,username);
        sendText(_enterPassword,password);
        clickOnElement(_clickLOGIN);
    }
}
