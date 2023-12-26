package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    @FindBy(name = "username")
    WebElement txtUsername;
    @FindBy(name = "password")
    WebElement txtPassword;

    @FindBy(css = "[type=submit]")
    public WebElement btnsignIn;

    @FindBy(xpath = "/html/body/div/div/div[2]/form/div[2]/div[2]/div/p")

    WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void doLogin(String username, String password) {
        txtUsername.sendKeys(username);
        txtPassword.sendKeys(password);

        btnsignIn.click();


    }

    public String dologinwithwrongCreds(String username, String password) {
        txtUsername.sendKeys(username);
        txtPassword.sendKeys(password);
        btnsignIn.click();
        return errorMessage.getText();
    }

    public void clearTextFields() {
        txtUsername.clear();
        txtPassword.clear();
    }


}
