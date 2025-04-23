package Utils;

import java.util.List;

import static Utils.ValidationUtils.isInputDataNotValid;

public class CSVUtils {

    public static void saveDataToCSV(String pathname, CSVConvertible[] data) {
        if (isInputDataNotValid(data)) {
            return;
        }
        FileHandler.createFile(pathname);
        for (CSVConvertible item : data) {
            FileHandler.writeDataToFile(pathname, item.convertToCSV());
        }
    }

    public static void saveDataToCSV(String pathname, List<? extends CSVConvertible> data) {
        if (isInputDataNotValid(data)) {
            return;
        }
        FileHandler.createFile(pathname);
        for (CSVConvertible item : data) {
            FileHandler.writeDataToFile(pathname, item.convertToCSV());
        }
    }

}
