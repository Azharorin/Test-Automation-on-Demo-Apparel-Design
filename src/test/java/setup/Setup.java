package setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utils.Utils;

import java.io.IOException;
import java.time.Duration;

public class Setup {
    public WebDriver driver;

    @BeforeTest

    public void setup() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("http://192.168.10.233:3000/login");


    }

    @AfterMethod
    public void screenShot(ITestResult result) throws IOException {
        if (ITestResult.FAILURE == result.getStatus()) {
            try {
                Utils utils = new Utils();
                utils.takeScrrenshots(driver);
            } catch (Exception exception) {
                System.out.println(exception);
            }

        }
    }


    @AfterTest
    public void closeDriver() {
        driver.close();
    }


}
