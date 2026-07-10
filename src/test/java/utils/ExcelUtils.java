package utils;
import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.DataProvider;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtils {
    public static Object[][] getExcelData(String filePath, String sheetName) throws IOException {
        FileInputStream file = new FileInputStream(new File(filePath));
        Workbook workbook = WorkbookFactory.create(file);
        Sheet sheet = workbook.getSheet(sheetName);
        int rowCount = sheet.getPhysicalNumberOfRows();
        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
        Object[][] data = new Object[rowCount - 1][colCount]; // To ignore the header row

        for (int i = 1; i < rowCount; i++) { // Start from 1 to skip the header row
            for (int j = 0; j < colCount; j++) {
                data[i - 1][j] = sheet.getRow(i).getCell(j).toString();
            }
        }
        workbook.close();
        return data;
    }
    @DataProvider(name = "excelData")
    public Object[][] getData() throws Exception {
        String path = "src/test/resources/CheckoutData.xlsx";
        return ExcelUtils.getExcelData(path, "Sheet1");
    }
}