package techy.selenium.april.excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

public class ReadExcelFile {

    static String filePath = "/Users/tuhidzmac/My Document/TestData.xlsx";
    static File file = new File(filePath);

    public static String[][] readExcelToArray(String filePath) throws IOException {

        InputStream ExcelFile = new FileInputStream(filePath);

        XSSFWorkbook workBook = new XSSFWorkbook(ExcelFile);
        XSSFSheet sheet = workBook.getSheetAt(0);

        XSSFRow row;
        XSSFCell cell;

        /*-----------------This block of of code is for .XLS files--------------
        HSSFWorkbook wb = new HSSFWorkbook(ExcelFile);
        HSSFSheet sheet = wb.getSheetAt(0);
        HSSFRow row;
        HSSFCell cell;*/

        int totalRow = sheet.getPhysicalNumberOfRows();
        int totalCol = sheet.getRow(0).getPhysicalNumberOfCells();

        String[][] testdata = new String[totalRow][totalCol];

        int rowNum = 0;
        int colNum = 0;

        Iterator<Row> rows = sheet.rowIterator();
        while (rows.hasNext()) {
            row = (XSSFRow) rows.next();
            Iterator<Cell> cells = row.cellIterator();
            while (cells.hasNext()) {
                cell = (XSSFCell) cells.next();
                testdata[rowNum][colNum] = cell.toString();
                colNum ++;

            }
            colNum = 0;
            rowNum++;
        }

        return testdata;
    }

    public static void print2DStrArray(String[][] testdata) {
        for (int rowNum = 1; rowNum < testdata.length; rowNum++) {
            for (int colNum = 0; colNum < testdata[rowNum].length; colNum++) {
                System.out.print(testdata[rowNum][colNum] + "\t");
            }
            System.out.print("\n");
        }
    }
}
