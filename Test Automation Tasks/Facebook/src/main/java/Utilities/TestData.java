package Utilities;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;
public class TestData {

        static FileInputStream registrationData;
        final String registrationDataFilePath="src\\main\\java\\Data\\RegistrationData.xlsx";
        static FileInputStream loginData;
        final String loginDataFilePath="src\\main\\java\\Data\\LoginData.xlsx";

       @DataProvider
        public Object[][] getRegistrationExcelData() throws IOException {
            registrationData=new FileInputStream(registrationDataFilePath);
            XSSFWorkbook wb=new XSSFWorkbook(registrationData);
            XSSFSheet sheet=wb.getSheetAt(0);
            int rowsNo= sheet.getLastRowNum();
            int colsNo=sheet.getRow(0).getPhysicalNumberOfCells();
            String [][]registrationExcelData=new String[rowsNo][colsNo];

            for (int i=0;i<rowsNo;i++)
                for (int j=0;j<colsNo;j++){
                    XSSFRow row= sheet.getRow(i+1);
                    registrationExcelData[i][j]=row.getCell(j).toString();
                }
            wb.close();
            return  registrationExcelData;
        }

    @DataProvider
    public Object[][] getLoginExcelData() throws IOException {
        loginData=new FileInputStream(loginDataFilePath);
        XSSFWorkbook wb=new XSSFWorkbook(loginData);
        XSSFSheet sheet=wb.getSheetAt(0);
        int rowsNo= sheet.getLastRowNum();
        int colsNo=sheet.getRow(0).getPhysicalNumberOfCells();
        String [][]loginExcelData=new String[rowsNo][colsNo];

        for (int i=0;i<rowsNo;i++)
            for (int j=0;j<colsNo;j++){
                XSSFRow row= sheet.getRow(i+1);
                loginExcelData[i][j]=row.getCell(j).toString();
            }
        wb.close();
        return  loginExcelData;
    }

}
