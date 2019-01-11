package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by C842045 on 1/10/2019.
 */
public class TakeScreenshot extends BaseTest {
    /**
     * Take screenshot and store it in the screenshots folder at the project level and store it by using the dynamic date time property by appendign it to the class name
     *
     * @param fileName
     */
    protected void takeScreenshot(String fileName) {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String path = System.getProperty(
                "user.dir") + File.separator + "screenshots" + File.separator + getTodaysDate() + File.separator + getSystemTime() + " " + fileName + ".png";
        try {
            FileUtils.copyFile(scrFile, new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Todays date in yyyyMMdd format
     */
    private static String getTodaysDate() {
        return (new SimpleDateFormat("yyyyMMdd").format(new Date()));
    }

    /**
     * Current time in HHmmssSSS
     */
    private String getSystemTime() {
        return (new SimpleDateFormat("HHmmssSSS").format(new Date()));
    }
}
