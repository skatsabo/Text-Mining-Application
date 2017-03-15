package textdatamining;

import java.io.IOException;
import java.util.Scanner;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.UnderlinePatterns;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;


public class HeaderSummarisationResults {

    String number1 = "Αριθμός";
    String number2 = "ΑΡΙΘΜΟΣ";

    String dikastes = ":";

    String eishghths1 = "Εισηγητή";
    String eishghths3 = "Εισηγήτρια";

    String key = "του";//άντρας
    String key1 = "της";//γυναίκα
    String antieisag = "Αντεισαγγ"; //***

    String plhrej1 = "πληρεξούσιους"; //άντρας
    String plhrej2 = "πληρεξούσιο"; //άντρας
    String plhrej3 = "πληρεξούσια"; //γυναίκα

    private String text = null;
    private XWPFParagraph para = null;
    private XWPFRun run = null;

    public HeaderSummarisationResults(String text, XWPFParagraph para, XWPFRun run) {
        this.text = text;
        this.para = para;
        this.run = run;
    }

    public void setPara(XWPFParagraph para) {
        this.para = para;
    }

    public void setRun(XWPFRun run) {
        this.run = run;
    }

    public void findHeader() throws IOException {
        String word = null;
        String word1 = null;
        String word2 = null;
        String word3 = null;

        int sumJudge = 0;
        int sumProponent = 0;
        int sumAdvocate = 0;
        int sumLawers = 0;
        int sumLawer = 0;

        String text1 = text.replace("-", " ");//gia thn periptvsh tou eisigith vgazw paules
        Scanner scanner = new Scanner(text1);
        int cnt = 0;
        while (scanner.hasNext()) { //Διάβαζε λέξεις μέχρι το τέλος του κειμένου
            para.setAlignment(ParagraphAlignment.LEFT);
            run = para.createRun();

            word3 = word2;
            word2 = word1;
            word1 = word;
            word = scanner.next();

            if (word.indexOf(number1) > -1 || word.indexOf(number2) > -1) {
                cnt++;
                if (cnt > 1) {//σε πρτίπτωση που βρεί και άλλα κείμενα
                    sumJudge = 0;
                    sumProponent = 0;
                    sumAdvocate = 0;
                    sumLawers = 0;
                    sumLawer = 0;

                    run.addBreak();
                    cnt--;
                }
                FindNumber(scanner);
            }
            if (word.indexOf(dikastes) > -1 && sumJudge == 0) {
                sumJudge++;
                FindJudge(scanner);
            }
            if ((word.indexOf(eishghths1) > -1 || word.indexOf(eishghths3) > -1) && sumProponent == 0) {
                sumJudge = 1;//an vre meta ton eisigith ton dikasth na mhn mpei...tha einai lathos kok
                sumProponent++;
                FindProponent(word, word1, word2, word3);
            }
            if (word.indexOf(antieisag) > -1 && sumAdvocate == 0) {
                sumJudge = 1;
                sumProponent = 1;
                sumAdvocate++;
                FindAdvocate(scanner, word, word1);
            }
            if (word.indexOf(plhrej1) > -1 && sumLawers == 0 ) {
                sumJudge = 1;
                sumProponent = 1;
                sumAdvocate = 1;
                sumLawers++;
                FindLawers(scanner, word);
            }
            if ((word.indexOf(plhrej2) > -1 || word.indexOf(plhrej3) > -1) && (sumLawer <= 1) && (sumLawers == 0)) {
                sumJudge = 1;
                sumProponent = 1;
                sumAdvocate = 1;
                sumLawer++;
                FindLawer(scanner, word, sumLawer);
            }
        }
        System.out.println();
    }

    private void FindNumber(Scanner scanner) {
        //εντοπίζει τον αριθμό του κειμένου
        String number = null;
        String word = scanner.next();
        if (word.indexOf("/") > -1){
            number = "Αριθμ. " + word;
        }
        else{   //se periptvsh pou o arithmos toy keimenoy den einai h epvmenh lejh
            word = scanner.next();
            number = "Αριθμ. " + word;
        }
        run.addBreak();
        run.setText(number);
        run.setColor("0000FF");
        run.setBold(true);
        run.setItalic(true);
        run.setUnderline(UnderlinePatterns.THICK);
        run.addBreak();
    }

    private void FindJudge(Scanner scanner) {
        //Προεδρεύων ο Αντιπρόεδρος
        String Judge = scanner.next();
        Judge = Judge + " " + scanner.next();
        String word = scanner.next();
        
        //Δήμητρα Παπαντωνοπούλου, Βιολέττα Κυτέα , Θεοδώρα Γκοΐνη
        if (word.indexOf("Προεδρεύουσα") > -1 || Judge.indexOf("Δήμητρα Παπαντωνοπούλου") > -1 
                  || Judge.indexOf("Βιολέττα Κυτέα") > -1 ||  Judge.indexOf("Θεοδώρα Γκοΐνη") > -1) {
            Judge = Judge.replace(",", " ");
            run.setText("Προεδρεύουσα η Αντιπρόεδρος " + Judge);
            run.setColor("0000FF");
            run.setBold(true);
            run.addBreak();
        } else {
            String[] result = Judge.split(" ");
            Judge = (String) result[0].subSequence(0, 1);
            Judge = Judge.concat(".");
            Judge = Judge.concat(" ");
            Judge = Judge.concat(result[1]);

            if (Judge.indexOf(',') > -1) {
                Judge = Judge.replace(",", "ς");
            } else {
                Judge = Judge.concat("ς");
            }
            run.setText("Προεδρεύων ο Αντιπρόεδρος " + Judge);
            run.setColor("0000FF");
            run.setBold(true);
            run.addBreak();
        }
    }

    private void FindProponent(String word, String word1, String word2, String word3) {
        //Εισηγητής/τρια
        String Proponent = null;

        if (word.indexOf(eishghths1) > -1) {

            Proponent = word2 + " " + word1;
            String[] result = Proponent.split(" ");
            Proponent = (String) result[0].subSequence(0, 1);
            Proponent = Proponent.concat(".");
            Proponent = Proponent.concat(" ");
            Proponent = Proponent.concat(result[1]);

            if (Proponent.indexOf(',') > -1) {
                Proponent = Proponent.replace(",", "ς");
            } else {
                Proponent = Proponent.concat("ς");
            }
            run.setText("Εισηγητής ο Αρεοπαγίτης " + Proponent);
            run.setColor("0000FF");
            run.setBold(true);
            //run.setText(", ");
            run.addBreak();

        } else {
            Proponent = word3 + " " + word2 + "-" + word1;
            Proponent = Proponent.replace(",", " ");
            run.setText("Εισηγήτρια η Αρεοπαγίτης " + Proponent);
            run.setColor("0000FF");
            run.setBold(true);
            //run.setText(", ");
            run.addBreak();
        }
    }

    private void FindAdvocate(Scanner scanner, String word, String word1) {
        //Εισαγγελεύς
        String Advocate = null;

        if (word1.indexOf(key) > -1) {
            word = scanner.next();
            word = scanner.next();
            word = scanner.next();
            word = scanner.next();
            Advocate = word.concat(" " + scanner.next());

            String[] result = Advocate.split(" ");

            char[] Str2 = new char[2];
            result[1].getChars(result[1].length() - 2, result[1].length(), Str2, 0);

            if (Str2[0] == 'ο' && Str2[1] == 'υ') {
                result[1] = result[1].replace("υ", "ς");
            } else {
                result[1] = result[1].concat("ς");
            }

            Advocate = (String) result[0].subSequence(0, 1);
            Advocate = Advocate.concat(".");
            Advocate = Advocate.concat(" ");
            Advocate = Advocate.concat(result[1]);
            run.setText("Εισαγγελεύς " + Advocate);
            run.setColor("0000FF");
            run.setBold(true);
            run.addBreak();
        }
        if (word1.indexOf(key1) > -1) {
            word = scanner.next();
            word = scanner.next();
            word = scanner.next();
            word = scanner.next();
            Advocate = word.concat(scanner.next());
            Advocate = Advocate.replace("ς", " ");
            run.setText("Εισαγγελεύς " + Advocate);
            run.setColor("0000FF");
            run.setBold(true);
            //run.setText(", ");
            run.addBreak();
        }

    }

    private void FindLawers(Scanner scanner, String word) {
        //Δικηγόροι
        String Lawers1 = null;
        String Lawers2 = null;

        word = scanner.next();
        word = scanner.next();
        word = scanner.next();
        Lawers1 = word.concat(" " + scanner.next());
        word = scanner.next();
        word = scanner.next();
        Lawers2 = word.concat(" " + scanner.next());

        String[] result = Lawers1.split(" ");
        Lawers1 = (String) result[0].subSequence(0, 1);
        Lawers1 = Lawers1.concat(".");
        Lawers1 = Lawers1.concat(" ");
        Lawers1 = Lawers1.concat(result[1]);

        if (Lawers1.indexOf(',') > -1) {
            Lawers1 = Lawers1.replace(",", "ς");
        } else {
            Lawers1 = Lawers1.concat("ς");
        }

        result = Lawers2.split(" ");
        Lawers2 = (String) result[0].subSequence(0, 1);
        Lawers2 = Lawers2.concat(".");
        Lawers2 = Lawers2.concat(" ");
        Lawers2 = Lawers2.concat(result[1]);

        if (Lawers2.indexOf(',') > -1) {
            Lawers2 = Lawers2.replace(",", "ς");
        } else {
            Lawers2 = Lawers2.concat("ς");
        }
        run.setText("Δικηγόροι " + Lawers1 + " και " + Lawers2);
        run.setColor("0000FF");
        run.setBold(true);
        //run.setText(", ");
        run.addBreak();

    }

    private void FindLawer(Scanner scanner, String word, int cnt) {
        //Δικηγόρος
        String Lawer = null;

        String key3 = word;
        word = scanner.next();
        word = scanner.next();
        word = scanner.next();
        Lawer = word.concat(" " + scanner.next());
        if (key3.indexOf(plhrej2) > -1) {//***άντρας***
            String[] result = Lawer.split(" ");
            Lawer = (String) result[0].subSequence(0, 1);
            Lawer = Lawer.concat(".");
            Lawer = Lawer.concat(" ");
            Lawer = Lawer.concat(result[1]);

            if (Lawer.indexOf(',') > -1) {
                Lawer = Lawer.replace(",", "ς");
            } else {
                Lawer = Lawer.concat("ς");
            }
        } else {//***γυναίκα***
            Lawer = Lawer.replace(",", " ");
        }
        if (cnt == 1) {
            run.setText("Δικηγόρος " + Lawer);
            run.setColor("0000FF");
            run.setBold(true);
            run.addBreak();
            if (cnt == 2) {
                System.out.println(", " + Lawer);
                run.setText(", " + Lawer);
                run.setColor("0000FF");
                run.setBold(true);
                run.addBreak();
            }
        }
    }
}
