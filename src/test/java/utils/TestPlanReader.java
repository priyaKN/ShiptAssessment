package utils;

import com.opencsv.CSVReader;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Created by C842045 on 1/10/2019.
 */
public class TestPlanReader {
    /**
     * Thsi method returns the list of testdata objects by reading the file specified in the path
     * Note: Classname must be same as csv file name
     *
     * @param method
     * @return
     */
    @DataProvider(name = "csvReader")
    public static Iterator<Object[]> csvReader(Method method) {
        List<Object[]> list     = new ArrayList<Object[]>();
        String         pathname = "src/test/testPlans/loginPage/" + method.getDeclaringClass().getSimpleName() + ".csv";
        File           file     = new File(pathname);
        try {
            CSVReader reader = new CSVReader(new FileReader(file));
            String[]  keys   = reader.readNext();
            if (keys != null) {
                String[] dataParts;
                while ((dataParts = reader.readNext()) != null) {
                    Map<String, String> testData = new HashMap<String, String>();
                    for (int i = 0; i < keys.length; i++) {
                        testData.put(keys[i], dataParts[i]);
                    }
                    list.add(new Object[]{testData});
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File " + pathname + " was not found.\n" + e.getStackTrace().toString());
        } catch (IOException e) {
            throw new RuntimeException("Could not read " + pathname + " file.\n" + e.getStackTrace().toString());
        }
        return list.iterator();
    }
}
