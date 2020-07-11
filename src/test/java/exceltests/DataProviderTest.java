package exceltests;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DataProviderTest {

    DataFormatter formatter = new DataFormatter();
    public DataProviderTest() throws FileNotFoundException {
    }

    @Test(dataProvider = "excel")
    public void testCaseeData(String field1, String field2, String field3) {
        System.out.println(field1 + field2 + field3);

    }


    @DataProvider(name = "excel")
    public Object[] getData() throws IOException {



        File file = new File("src\\test\\resources\\testData.xlsx");
        FileInputStream fis = new FileInputStream(file.getAbsolutePath());
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sh = wb.getSheet("data");
        int rowCoun = sh.getPhysicalNumberOfRows();

        XSSFRow row = sh.getRow(0);
        int columnCount = row.getLastCellNum();

        Object data[][] = new Object[rowCoun-1][columnCount];

        for(int i=0;i<rowCoun-1;i++){
            row=sh.getRow(i+1);
            for(int j=0; j<columnCount; j++){

                XSSFCell cell = row.getCell(j);


                data[i][j] = formatter.formatCellValue(cell);
            }
        }
        return data;
    }


}
