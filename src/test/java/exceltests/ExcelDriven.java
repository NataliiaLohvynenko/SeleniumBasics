package exceltests;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelDriven {

    public static XSSFWorkbook wb;

    public static XSSFSheet sheet;

    public static XSSFRow row;

    public static XSSFCell cell;

    public static FileInputStream fis;



    public static void main(String[] args) throws IOException {

// TODO Auto-generated method stub

        String value=getCelldata(1,1);

        System.out.println(value);

        String value1=getCelldata(1,2);

        System.out.println(value1);

     //   value=setCelldata("automation",2,2);

      //  System.out.println(value);

    }

    private static String setCellvalue(int i, int j) {

// TODO Auto-generated method stub

        return null;

    }
    public static void setSheet() throws IOException {
        File file = new File("src\\test\\java\\Utils\\test.xlsx");

        fis = new FileInputStream(file.getAbsolutePath());

        wb = new XSSFWorkbook(fis);

        sheet = wb.getSheet("Vegetables");
    }
    public static String getCelldata( int rownum,int col) throws IOException

    {
        setSheet();
        row=sheet.getRow(rownum);

        cell=row.getCell(col);

        return cell.getStringCellValue();

    }



    public static List<String> product() throws IOException {
        List<String> product = new ArrayList<>();

        setSheet();
        Iterator<Row> row = sheet.iterator();
        while (row.hasNext())
        {
            Row nrow=row.next();
            Iterator<Cell> cell = nrow.iterator();
            while (cell.hasNext()){
                Cell ncell = cell.next();
                if(ncell.getCellType()== CellType.STRING)
                { product.add(ncell.getStringCellValue());
            }else if(ncell.getCellType()== CellType.NUMERIC){

                    product.add(Double.toString(ncell.getNumericCellValue()));
                }


        }
        }
        return product;
    }

    public static String setCelldata(String text,int rownum,int col) throws IOException

    {

        fis =new FileInputStream("D:\\data.xlsx");

        wb=new XSSFWorkbook(fis);

        sheet=wb.getSheet("script");

        row=sheet.getRow(2);

        cell=row.getCell(2);

        cell.setCellValue(text);

        String celldata1= cell.getStringCellValue();

        return celldata1;

    }



}
