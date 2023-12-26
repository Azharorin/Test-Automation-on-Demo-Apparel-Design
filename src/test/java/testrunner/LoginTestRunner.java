package testrunner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.DashbaordPage;
import page.LoginPage;
import setup.Setup;

import java.time.Duration;

public class LoginTestRunner extends Setup {

    DashbaordPage dashbaordPage;
    LoginPage loginPage;


    @Test(priority = 1, description = "Login with Invalid credentials")

    public void dologinwithinvalidCreds() {

        loginPage = new LoginPage(driver);
        loginPage.dologinwithwrongCreds("admin@Test.com", "Abc123");

        String errorMsg = loginPage.dologinwithwrongCreds("admin@Test.com", "Abc123");
        String errormsgExpected = "Please give at least one number, one lower and upper case letter, one special character";
        //Assert.assertTrue(errorMsg.contains(errormsgExpected), "Error message does not match expected message: " + errorMsg);
        Assert.assertTrue(errorMsg.contains(errormsgExpected));
    }

    @Test(priority = 2, description = "Login with valid credentials")

    public void doLogin() throws InterruptedException {

        loginPage = new LoginPage(driver);
        loginPage.clearTextFields();
        loginPage.doLogin("admin@gigatech.com", "Abc@123");

        //Asserting the url to verify the login

        String expectedUrl = "http://192.168.10.233:3000/dashboard";


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.urlContains(expectedUrl));
        String urlActual = driver.getCurrentUrl();
        Assert.assertTrue(urlActual.contains(expectedUrl));

        dashbaordPage = new DashbaordPage(driver);
       /* Verifying the login dashbaord view is displayed after login
          Those elements txtadmin_name and txtDashbaord.  are taken only to verify the login those are only working for particular websites,
          if i have to test different websites then i have to take certian websites elements to verify the txtelments of this site
       */
        Assert.assertTrue(dashbaordPage.txtDashbaord.isDisplayed());
        Assert.assertTrue(dashbaordPage.txtAdmin_name.isDisplayed());
    }
}
