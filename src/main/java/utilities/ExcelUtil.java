package utilities;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.WorkbookFactory; 
public class ExcelUtil {
   private static Workbook workbook;
   private static Sheet sheet;

   public static void loadExcel(String filePath) {
       try (FileInputStream fis = new FileInputStream(filePath)) {
           workbook = WorkbookFactory.create(fis);
           sheet = workbook.getSheetAt(0);
       } catch (Exception e) {
           System.out.println("Error loading Excel file");
           e.printStackTrace();
       }
   }

   public static int getRowCount() {
       if (sheet == null) {
           throw new RuntimeException("Sheet is not loaded. Call loadExcel() first.");
       }
       return sheet.getLastRowNum();
   }

   public static String getCellData(int row, int col) {
       if (sheet == null) {
           throw new RuntimeException("Sheet is not loaded. Call loadExcel() first.");
       }
       Row r = sheet.getRow(row);
       if (r == null) return "";
       Cell cell = r.getCell(col);
       if (cell == null) return "";
       switch (cell.getCellType()) {
           case STRING:
               return cell.getStringCellValue();
           case NUMERIC:
               if (DateUtil.isCellDateFormatted(cell)) {
                   return cell.getDateCellValue().toString();
               } else {
                   return String.valueOf((long) cell.getNumericCellValue());
               }
           case BOOLEAN:
               return String.valueOf(cell.getBooleanCellValue());
           case FORMULA:
               return cell.getCellFormula();
           default:
               return "";
       }
   }

   public static void writeResult(int rowNum, int colNum, String result) {
       if (sheet == null) {
           throw new RuntimeException("Sheet is not loaded. Call loadExcel() first.");
       }
       try {
           Row row = sheet.getRow(rowNum);
           if (row == null) {
               row = sheet.createRow(rowNum);
           }
           Cell cell = row.getCell(colNum);
           if (cell == null) {
               cell = row.createCell(colNum);
           }
           cell.setCellValue(result);
       } catch (Exception e) {
           System.out.println("Error writing result");
           e.printStackTrace();
       }
   }

   public static void saveExcel(String filePath) {
       try (FileOutputStream fos = new FileOutputStream(filePath)) {
           workbook.write(fos);
           fos.flush(); 
       } catch (Exception e) {
           System.out.println("Error saving Excel file");
           e.printStackTrace();
       } finally {
           try {
               if (workbook != null) {
                   workbook.close();
               }
           } catch (Exception e) {
               e.printStackTrace();
           }
       }
   }
   
   public static void closeExcel() {
	   try {
		   if(workbook != null) {
			   workbook.close();
		   }
	   }
	   catch(Exception e) {
		   e.printStackTrace();
	   }
   }
}