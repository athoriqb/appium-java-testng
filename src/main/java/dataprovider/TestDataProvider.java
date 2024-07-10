package dataprovider;

import java.text.ParseException;
import java.util.List;

import org.testng.annotations.DataProvider;
import utils.CsvUtils;

public class TestDataProvider {

    @DataProvider(name = "genderData")
    public static Object[][] getGenderData() {
        List<String[]> data = CsvUtils.readAll("src/test/resources/testdataapi.csv");
        Object[][] dataArray = new Object[data.size() - 1][];
        for (int i = 1; i < data.size(); i++) {
            dataArray[i - 1] = data.get(i);
        }
        return dataArray;
    }
}
