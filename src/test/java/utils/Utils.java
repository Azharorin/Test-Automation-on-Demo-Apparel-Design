package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import sun.security.krb5.internal.crypto.Des;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

    public static void takeScrrenshots(WebDriver driver) throws IOException {
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String time = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss-aa").format(new Date());
        String fileWritepath = "./src/test/resources/screenshots/" + time + ".png";
        File DestFile = new File(fileWritepath);
        FileUtils.copyFile(screenshotFile, DestFile);

    }

}

