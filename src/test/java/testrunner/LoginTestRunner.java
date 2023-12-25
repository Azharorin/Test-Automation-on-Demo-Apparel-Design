package testrunner;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.DashbaordPage;
import page.LoginPage;
import setup.Setup;

public class LoginTestRunner extends Setup {

    DashbaordPage dashbaordPage;
    LoginPage loginPage;


@Test(priority = 1,description = "Login with Invalid credentials")
     public void dologinwithinvalidCreds() {

        loginPage= new LoginPage(driver);
        //loginPage.dologinwithwrongCreds("admin@Test.com", "Abc123");

        String errorMsg = loginPage.dologinwithwrongCreds("admin@Test.com", "Abc123");
        String errormsgExpected = "Please give at least one number, one lower and upper case letter, one special character";
        //Assert.assertTrue(errorMsg.contains(errormsgExpected), "Error message does not match expected message: " + errorMsg);
        Assert.assertTrue(errorMsg.contains(errormsgExpected));



    }
    @Test(priority = 2, description ="Login with valid credentials")

    public void doLogin() throws InterruptedException {

      loginPage= new LoginPage(driver);
      loginPage.clearTextFields();

      loginPage.doLogin("admin@Test.com","Abc@123");
     // Thread.sleep(1000);
      String urlActual= driver.getCurrentUrl();
     // System.out.println(urlActual);

        // Verifyting the login

      String expectedUrl="http://TESTURL.COM/dashboard";
      Assert.assertTrue(urlActual.contains(expectedUrl));

      dashbaordPage=new DashbaordPage(driver);
      //Verifying the login
      Assert.assertTrue(dashbaordPage.txtDashbaord.isDisplayed());


    }


}
