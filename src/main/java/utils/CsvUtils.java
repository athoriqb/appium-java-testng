package utils;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvException;
import config.TestDataMobile;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class CsvUtils {
    public static List<String[]> readAll(String filePath) {
        List<String[]> list = new ArrayList<>();
        try (CSVReader csvReader = new CSVReader(new FileReader(filePath))) {
            list = csvReader.readAll();
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List<TestDataMobile> readTestData(String filePath) {
        try (Reader reader = new FileReader(filePath)) {
            CsvToBean<TestDataMobile> csvToBean = new CsvToBeanBuilder<TestDataMobile>(reader)
                    .withType(TestDataMobile.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            return csvToBean.parse();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
