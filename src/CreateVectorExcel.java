package textdatamining;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFRow;

public class CreateVectorExcel {

    private ArrayList<Float> freqList;
    private int linepos;
    String filename = null;
    HSSFWorkbook workbook;
    HSSFSheet sheet;

    public CreateVectorExcel() {
    }
    public CreateVectorExcel(ArrayList<Float> freqList) {
        this.freqList = freqList;
    }
    public void setList(ArrayList<Float> freqList){
        this.freqList = freqList;
    }
    public void setLinePos(int linepos){
        this.linepos = linepos;
    }

    public void Excel() {
        try {
            HSSFRow rowhead = sheet.createRow((short) 0);
            rowhead.createCell(0).setCellValue("Συντ");
            rowhead.createCell(1).setCellValue("ΣΔΟΕ");
            rowhead.createCell(2).setCellValue("ΚΠολΔ");
            rowhead.createCell(3).setCellValue("ΔΣΑΠΔ");
            rowhead.createCell(4).setCellValue("ΕΣΔΑ");
            rowhead.createCell(5).setCellValue("ΠΚ");
            rowhead.createCell(6).setCellValue("ΚΠΔ");
            rowhead.createCell(7).setCellValue("Ν.");
            rowhead.createCell(8).setCellValue("ν.δ.");
            rowhead.createCell(9).setCellValue("Δικαστηρίου");
            rowhead.createCell(10).setCellValue("Πλημ/κείου");
            rowhead.createCell(11).setCellValue("Εφετείου");
            rowhead.createCell(12).setCellValue("Πρωτοδικ");
            rowhead.createCell(13).setCellValue("Συμβάσεως");
            rowhead.createCell(14).setCellValue("ΑΚ");

            HSSFRow row = sheet.createRow((short) this.linepos);
            for (int i = 0; i < this.freqList.size(); i++) {
                row.createCell(i).setCellValue(freqList.get(i));
            }

        } catch (Exception ex) {
            System.out.println(ex);

        }
    }

    public void OpenExcel() {
        filename = "C:\\Users\\spiros\\Documents\\NetBeansProjects\\TextDataMining\\ExcelVectorsFile.xls";
        workbook = new HSSFWorkbook();
        sheet = workbook.createSheet("FirstSheet");
    }

    public void CloseExcel() throws FileNotFoundException, IOException {
        FileOutputStream fileOut = new FileOutputStream(filename);
        workbook.write(fileOut);
        fileOut.close();
        System.out.println("Your excel file has been generated!");
    }
    
     public void openFinalExcel() {
        try {
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(new File("C:\\Users\\spiros\\Documents\\NetBeansProjects\\TextDataMining\\ExcelVectorsFile.xls"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
