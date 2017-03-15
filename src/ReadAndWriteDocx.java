
package textdatamining;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

public class ReadAndWriteDocx {
    private String In = null; 
    private XWPFDocument newDoc;
    
    public ReadAndWriteDocx(XWPFDocument newDoc) {
        this.newDoc = newDoc;
    }
    
    public ReadAndWriteDocx(String In) {
        this.In = In;
    }

    public XWPFWordExtractor ReadDocx() throws FileNotFoundException, IOException {
        File DocxFile = new File(In);
        FileInputStream Docxfis = new FileInputStream(DocxFile.getAbsolutePath());
        XWPFDocument document = new XWPFDocument(Docxfis);
        XWPFWordExtractor extract = new XWPFWordExtractor(document);
        return extract;
    }

    public XWPFDocument WriteDocx() {
        XWPFDocument newDoc = new XWPFDocument(); //Doc to write new doc to
        return newDoc;
    }

    //H openNewDocx δημιουργεί ένα αρχείο .docx
    public void openNewDocx() {

        try {
            newDoc.write(new FileOutputStream("C:\\Users\\spiros\\Documents\\NetBeansProjects\\TextDataMining\\FinalText.docx"));
        } catch (IOException e) {
            System.out.println("IOException Error!");
            e.printStackTrace();
        }
    }
    
    //Εμφανίζει αυτόματα το .docx που δημιουργήθηκε 
    public void openFinalNewDocx() {

        try {
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(new File("C:\\Users\\spiros\\Documents\\NetBeansProjects\\TextDataMining\\FinalText.docx"));
            }
        } catch (IOException e) {
            System.out.println("IOException Error!");
            e.printStackTrace();
        }
    }
}
