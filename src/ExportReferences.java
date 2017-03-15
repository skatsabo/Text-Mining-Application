package textdatamining;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.UnderlinePatterns;
import org.jfree.ui.RefineryUtilities;

public class ExportReferences {

    final static int GUARD = 15;
    private String text;
    private XWPFParagraph para;
    private XWPFRun run;
    private String In;

    public ExportReferences(String text, XWPFParagraph para, XWPFRun run, String In) {
        this.text = text;
        this.para = para;
        this.run = run;
        this.In = In;
    }

    float sumSuntforChart = 0;
    float sumSdoeforChart = 0;
    float sumDSAPDforChart = 0;
    float sumDikforChart = 0;
    float sumEsdaforChart = 0;
    float sumEfetforChart = 0;
    float sumKpdforChart = 0;
    float sumKPolDforChart = 0;
    float sumNdotforChart = 0;
    float sumNdotDforChart = 0;
    float sumPkforChart = 0;
    float sumPlhmforChart = 0;
    float sumProtforChart = 0;
    float sumESumvforChart = 0;
    float sumAkforChart = 0;

    float sumALL = 0;
    float sumSunt = 0;
    float sumSdoe = 0;
    float sumDSAPD = 0;
    float sumDik = 0;
    float sumEsda = 0;
    float sumEfet = 0;
    float sumKpd = 0;
    float sumKPolD = 0;
    float sumNdot = 0;
    float sumNdotD = 0;
    float sumPk = 0;
    float sumPlhm = 0;
    float sumProt = 0;
    float sumESumv = 0;
    float sumAk = 0;

    ArrayList<Float> freqList = new ArrayList<>();//h lista pou peri;exei thn suxnothta emfanishs gia kathe apofash
    ArrayList<Float> ratesList = new ArrayList<>();//h lista pou periexei to sunoliko athroisma gia olla ta pososta
    int height = 600;//gia grafikh

    public void Allreferences() throws IOException, Exception {
        AllFinalsVariables finals = new AllFinalsVariables();

        String number1 = "Αριθμ";
        String number2 = "ΑΡΙΘΜ";
        String reference = null;
        String previousRef = null;
        String word1 = null;

        CreateVectorExcel excel = new CreateVectorExcel();
        excel.OpenExcel();

        Scanner scanner = new Scanner(text);
        para.setAlignment(ParagraphAlignment.BOTH);//gia morfopoihsh
        int textcnt = 0;
        while (scanner.hasNext()) { //Διάβαζε λέξεις μέχρι το τέλος του κειμένου
            run = para.createRun();
            run.setText("  ");

            word1 = scanner.next();
            reference = word1;

            if (word1.indexOf(finals.ar1) > -1
                      || word1.indexOf(finals.ar2) > -1
                      || word1.indexOf(finals.parKey) > -1
                      || word1.indexOf(finals.arthro) > -1
                      || word1.indexOf(finals.bslashKey) > -1) {

                int cnt = 0;
                while (word1.indexOf(number1) <= -1 && word1.indexOf(number2) <= -1
                          && word1.indexOf(finals.sunt) <= -1
                          && word1.indexOf(finals.sdoe) <= -1
                          && word1.indexOf(finals.idioukwdika1) <= -1
                          && word1.indexOf(finals.idioukwdika2) <= -1
                          && word1.indexOf(finals.idiounomou1) <= -1
                          && word1.indexOf(finals.idiounomou2) <= -1
                          && word1.indexOf(finals.anwkwdika) <= -1
                          && word1.indexOf(finals.daspd) <= -1
                          && word1.indexOf(finals.kPold) <= -1
                          && word1.indexOf(finals.esda1) <= -1
                          && word1.indexOf(finals.esda2) <= -1
                          && word1.indexOf(finals.pk) <= -1
                          && word1.indexOf(finals.pk1) <= -1
                          && word1.indexOf(finals.pk2) <= -1
                          && word1.indexOf(finals.kpd) <= -1
                          && word1.indexOf(finals.kpd1) <= -1
                          && word1.indexOf(finals.kpd2) <= -1
                          && word1.indexOf(finals.kpd3) <= -1
                          && word1.indexOf(finals.kpd4) <= -1
                          && word1.indexOf(finals.n) <= -1
                          && word1.indexOf(finals.n1) <= -1
                          && word1.indexOf(finals.ndotd) <= -1
                          && word1.indexOf(finals.ndotd1) <= -1
                          && word1.indexOf(finals.dikasthriou) <= -1
                          && word1.indexOf(finals.plhmmleiodikeiou) <= -1
                          && word1.indexOf(finals.efeteiou1) <= -1
                          && word1.indexOf(finals.protodikeiou) <= -1
                          && word1.indexOf(finals.eurvpaikhsSumvasews) <= -1
                          && word1.indexOf(finals.Ak1) <= -1
                          && word1.indexOf(finals.Ak2) <= -1) {

                    word1 = scanner.next();
                    reference = reference + " " + word1;
                    cnt++;

                    if (cnt > GUARD) {
                        run.setText(reference);
                        run.setText("  ");
                        break;
                    }
                    if (reference.indexOf(number1) > -1 || reference.indexOf(number2) > -1) {
                        break;
                    }

                    if ((reference.indexOf(finals.idioukwdika1) > -1 || (reference.indexOf(finals.idioukwdika2) > -1)
                              || (reference.indexOf(finals.anwkwdika) > -1) || (reference.indexOf(finals.Ak1) > -1)
                              || (reference.indexOf(finals.Ak2) > -1))
                              && (In.indexOf("p") > -1)) {

                        cnt = 50;
                        sumALL++;
                        Find_IKOD_Ref(previousRef, reference);
                    }
                    if ((reference.indexOf(finals.idiounomou1) > -1 || reference.indexOf(finals.idiounomou2) > -1)
                              && (In.indexOf("p") > -1)) {
                        cnt = 50;
                        sumALL++;
                        Find_INOMOY_Ref(scanner, previousRef, word1, reference);
                    }
                    //**********************************************************
                    if ((reference.indexOf(finals.esda1) > -1 || reference.indexOf(finals.esda2) > -1)
                              && (In.indexOf("f") > -1 || (In.indexOf("p") > -1))) {

                        cnt = 50;
                        sumALL++;
                        sumEsda++;
                        sumEsdaforChart++;
                        FormattingType1(reference, finals.DarkCyan);
                        previousRef = reference;

                    }
                    //**********************************************************
                    if (((reference.indexOf(finals.pk) > -1 || reference.indexOf(finals.pk1) > -1 || reference.indexOf(finals.pk2) > -1)
                              && (In.indexOf("g") > -1 || In.indexOf("p") > -1))) {

                        cnt = 50;
                        sumALL++;
                        sumPk++;
                        sumPkforChart++;
                        FormattingType1(reference, finals.BlueViolet);
                        previousRef = reference;
                    }
                    //**********************************************************
                    if ((reference.indexOf(finals.Ak1) > -1 || reference.indexOf(finals.Ak2) > -1)
                              && (In.indexOf("d") > -1 || In.indexOf("p") > -1)) {

                        cnt = 50;
                        sumALL++;
                        sumAk++;
                        sumAkforChart++;
                        FormattingType1(reference, finals.SaddleBrown);
                        previousRef = reference;
                    }
                    //**********************************************************
                    if ((reference.indexOf(finals.dikasthriou) > -1)
                              && (In.indexOf("k") > -1 || In.indexOf("p") > -1)) {

                        cnt = 50;
                        sumALL++;
                        sumDik++;
                        sumDikforChart++;
                        word1 = scanner.next();
                        reference = reference + " " + word1;
                        FormattingType2(reference, finals.DarkOlive);
                        previousRef = reference;

                    }
                    //**********************************************************
                    if ((reference.indexOf(finals.plhmmleiodikeiou) > -1)
                              && (In.indexOf("l") > -1 || In.indexOf("p") > -1)) {

                        cnt = 50;
                        sumALL++;
                        sumPlhm++;
                        sumPlhmforChart++;
                        word1 = scanner.next();
                        reference = reference + " " + word1;
                        FormattingType2(reference, finals.DarkOrange);
                        previousRef = reference;

                    }
                    //**********************************************************
                    if ((reference.indexOf(finals.efeteiou1) > -1)
                              && (In.indexOf("m") > -1 || In.indexOf("p") > -1)) {

                        cnt = 50;
                        sumALL++;
                        sumEfet++;
                        sumEfetforChart++;
                        word1 = scanner.next();
                        reference = reference + " " + word1;
                        FormattingType2(reference, finals.Fuchia);
                        previousRef = reference;

                    }
                    //**********************************************************
                    if ((reference.indexOf(finals.protodikeiou) > -1)
                              && (In.indexOf("n") > -1 || In.indexOf("p") > -1)) {

                        cnt = 50;
                        sumALL++;
                        sumProt++;
                        sumProtforChart++;
                        word1 = scanner.next();
                        reference = reference + " " + word1;
                        FormattingType2(reference, finals.GoldenRod);
                        previousRef = reference;

                    }
                    //**********************************************************
                    if ((reference.indexOf(finals.kpd) > -1 || reference.indexOf(finals.kpd1) > -1
                              || reference.indexOf(finals.kpd2) > -1 || reference.indexOf(finals.kpd3) > -1 || reference.indexOf(finals.kpd4) > -1)
                              && (In.indexOf("h") > -1 || In.indexOf("p") > -1)) {

                        cnt = 50;
                        sumALL++;
                        sumKpd++;
                        sumKpdforChart++;
                        FormattingType1(reference, finals.Red);
                        previousRef = reference;

                    }
                    //**********************************************************
                    if ((reference.indexOf(finals.sunt) > -1)
                              && (In.contains("a") || In.indexOf("p") > -1)) {
                        cnt = 50;
                        sumALL++;
                        sumSunt++;
                        sumSuntforChart++;
                        FormattingType1(reference, finals.IndianRed);
                        previousRef = reference;

                    }
                    //**********************************************************
                    if ((reference.indexOf(finals.kPold) > -1)
                              && (In.indexOf("c") > -1 || In.indexOf("p") > -1)) {
                        cnt = 50;
                        sumALL++;
                        sumKPolD++;
                        sumKPolDforChart++;
                        FormattingType1(reference, finals.LimeGreen);
                        previousRef = reference;

                    }
                    //**********************************************************
                    if ((reference.indexOf(finals.daspd) > -1)
                              && (In.indexOf("e") > -1 || In.indexOf("p") > -1)) {
                        cnt = 50;
                        sumALL++;
                        sumDSAPD++;
                        sumDSAPDforChart++;
                        FormattingType1(reference, finals.Maroon);
                        previousRef = reference;

                    }
                    //**********************************************************
                    if ((reference.indexOf(finals.n) > -1 || reference.indexOf(finals.n1) > -1)
                              && (In.indexOf("i") > -1 || In.indexOf("p") > -1)) {

                        if (reference.indexOf(finals.ndotd) == -1 && reference.indexOf(finals.ndotd1) == -1) {
                            cnt = 50;
                            word1 = scanner.next();
                            Pattern p = Pattern.compile("(1|2|3|4|5|6|7|8|9|0)"); //an meta to N. arithmos ok aliws oxi
                            Matcher m = p.matcher(word1);
                            if (m.find()) {
                                sumNdot++;
                                sumALL++;
                                sumNdotforChart++;
                                reference = reference + " " + word1;
                                FormattingType2(reference, finals.SteelBlue);
                                previousRef = reference;
                            }
                        }
                    }
                    //**********************************************************
                    if ((reference.indexOf(finals.ndotd) > -1 || reference.indexOf(finals.ndotd1) > -1)
                              && (In.indexOf("j") > -1 || In.indexOf("p") > -1)) {

                        cnt = 50;
                        sumALL++;
                        sumNdotD++;
                        sumNdotDforChart++;
                        word1 = scanner.next();
                        reference = reference + " " + word1;
                        FormattingType2(reference, finals.Olive);
                        previousRef = reference;

                    }
                    //**********************************************************
                    if ((reference.indexOf(finals.sdoe) > -1)
                              && (In.indexOf("b") > -1 || In.indexOf("p") > -1)) {

                        cnt = 50;
                        sumALL++;
                        sumSdoe++;
                        sumSdoeforChart++;
                        FormattingType1(reference, finals.Tomato);
                        previousRef = reference;

                    }
                    //**********************************************************
                    if ((reference.indexOf(finals.eurvpaikhsSumvasews) > -1)
                              && (In.indexOf("o") > -1 || In.indexOf("p") > -1)) {
                        cnt = 50;
                        sumALL++;
                        sumESumv++;
                        sumESumvforChart++;
                        FormattingType1(reference, finals.SaddleBrown);
                        previousRef = reference;
                    }
                }
            } else if ((word1.indexOf(finals.n) > -1 || word1.indexOf(finals.n1) > -1)
                      && (In.indexOf("i") > -1 || In.indexOf("p") > -1)) {

                if (word1.indexOf(finals.ndotd) == -1 && word1.indexOf(finals.ndotd1) == -1) {
                    word1 = scanner.next();
                    Pattern p = Pattern.compile("(1|2|3|4|5|6|7|8|9|10)");
                    Matcher m = p.matcher(word1);
                    if (m.find()) {
                        sumALL++;
                        sumNdot++;
                        sumNdotforChart++;
                        reference = reference + " " + word1;
                        FormattingType1(reference, finals.SteelBlue);
                        previousRef = reference;
                    }
                }
            } else if ((word1.indexOf(finals.ndotd) > -1 || word1.indexOf(finals.ndotd1) > -1)
                      && (In.indexOf("j") > -1 || In.indexOf("p") > -1)) {
                sumALL++;
                sumNdotD++;
                sumNdotDforChart++;
                word1 = scanner.next();
                FormattingType1(reference, finals.Olive);
                previousRef = reference;
            } else {
            }
            if (word1.indexOf(number1) > -1 || word1.indexOf(number2) > -1) {
                //System.out.println("\n" + textcnt);
                textcnt++;
                if (textcnt > 1) {
                    freqList = CreateTextVector();
                    excel.setList(freqList);
                    excel.setLinePos(textcnt);
                    excel.Excel();
                }
                sumSunt = 0;
                sumSdoe = 0;
                sumDSAPD = 0;
                sumDik = 0;
                sumEsda = 0;
                sumEfet = 0;
                sumKpd = 0;
                sumKPolD = 0;
                sumNdot = 0;
                sumNdotD = 0;
                sumPk = 0;
                sumPlhm = 0;
                sumProt = 0;
                sumESumv = 0;
                sumAk = 0;
            }

            if (reference.indexOf(finals.sunt) > -1
                      || reference.indexOf(finals.sdoe) > -1
                      || reference.indexOf(finals.kPold) > -1
                      || reference.indexOf(finals.daspd) > -1
                      || reference.indexOf(finals.idioukwdika1) > -1
                      || reference.indexOf(finals.idioukwdika2) > -1
                      || reference.indexOf(finals.idiounomou1) > -1
                      || reference.indexOf(finals.idiounomou2) > -1
                      || reference.indexOf(finals.anwkwdika) > -1
                      || reference.indexOf(finals.esda1) > -1
                      || reference.indexOf(finals.esda2) > -1
                      || reference.indexOf(finals.pk) > -1
                      || reference.indexOf(finals.pk1) > -1
                      || reference.indexOf(finals.pk2) > -1
                      || reference.indexOf(finals.kpd) > -1
                      || reference.indexOf(finals.kpd1) > -1
                      || reference.indexOf(finals.kpd2) > -1
                      || reference.indexOf(finals.kpd3) > -1
                      || reference.indexOf(finals.kpd4) > -1
                      || reference.indexOf(finals.dikasthriou) > -1
                      || reference.indexOf(finals.plhmmleiodikeiou) > -1
                      || reference.indexOf(finals.efeteiou1) > -1
                      || reference.indexOf(finals.n) > -1
                      || reference.indexOf(finals.n1) > -1
                      || reference.indexOf(finals.ndotd) > -1
                      || reference.indexOf(finals.ndotd1) > -1
                      || reference.indexOf(finals.protodikeiou) > -1
                      || reference.indexOf(finals.eurvpaikhsSumvasews) > -1
                      || reference.indexOf(finals.Ak1) > -1
                      || reference.indexOf(finals.Ak2) > -1) {

                if (scanner.hasNext() == false) {//An h teleutea leksh eina anafora stamata
                    break;
                }

                word1 = scanner.next();
            }
            run.setText(word1);
            run.setText("  ");
        }

        textcnt++;
        freqList = CreateTextVector();
        excel.setList(freqList);
        excel.setLinePos(textcnt);
        excel.Excel();
        excel.CloseExcel();
        //excel.openFinalExcel();//Anoigei automata to excel

        //**********************************************************************
        //Gia grafikh AWT Based Application 
        ratesList = CreateRateList();

        if (sumALL != 0) { //ama den exei kamia anafora mhn ftiakseis grafikh
            JFreeChartBar chart = new JFreeChartBar("ChartBar", "Ποσοστό Εμφάνισης", ratesList, sumALL, height);
            chart.pack();
            RefineryUtilities.centerFrameOnScreen(chart);
            chart.setVisible(true);
        }
        //**********************************************************************
    }

    public ArrayList<Float> getList() {
        return freqList;
    }

    public float getSumALL() {
        return sumALL;
    }

    public int getHeight() {
        return height;
    }

    private ArrayList<Float> CreateTextVector() {
        ArrayList<Float> freqList = new ArrayList<>();
        System.out.println("\n" + sumSunt + "," + sumSdoe + "," + sumKPolD + "," + sumDSAPD + "," + sumEsda
                  + "," + sumPk + "," + sumKpd + "," + sumNdot + "," + sumNdotD + "," + sumDik + ","
                  + sumPlhm + "," + sumEfet + "," + sumProt + "," + sumESumv + "," + sumAk + "\n");
        freqList.add(sumSunt);
        freqList.add(sumSdoe);
        freqList.add(sumKPolD);
        freqList.add(sumDSAPD);
        freqList.add(sumEsda);
        freqList.add(sumPk);
        freqList.add(sumKpd);
        freqList.add(sumNdot);
        freqList.add(sumNdotD);
        freqList.add(sumDik);
        freqList.add(sumPlhm);
        freqList.add(sumEfet);
        freqList.add(sumProt);
        freqList.add(sumESumv);
        freqList.add(sumAk);

        return freqList;
    }

    private ArrayList<Float> CreateRateList() {
        ArrayList<Float> ratesList = new ArrayList<>();
        ratesList.add(sumSuntforChart);
        ratesList.add(sumSdoeforChart);
        ratesList.add(sumKPolDforChart);
        ratesList.add(sumDSAPDforChart);
        ratesList.add(sumEsdaforChart);
        ratesList.add(sumPkforChart);
        ratesList.add(sumKpdforChart);
        ratesList.add(sumNdotforChart);
        ratesList.add(sumNdotDforChart);
        ratesList.add(sumDikforChart);
        ratesList.add(sumPlhmforChart);
        ratesList.add(sumEfetforChart);
        ratesList.add(sumProtforChart);
        ratesList.add(sumESumvforChart);
        ratesList.add(sumAkforChart);

        return ratesList;
    }

    private void FormattingType1(String reference, String colour) {
        run.setText(reference + " ");
        run.setColor(colour);
        run.setBold(true);
        run.setItalic(true);
        run.setUnderline(UnderlinePatterns.THICK);
        System.out.println(reference);
    }

    private void FormattingType2(String reference, String colour) {
        run.setColor(colour);
        run.setBold(true);
        run.setItalic(true);
        run.setUnderline(UnderlinePatterns.THICK);
        System.out.println(reference);
    }

    private void Find_IKOD_Ref(String previousRef, String reference) {
        AllFinalsVariables finals = new AllFinalsVariables();

        if (previousRef.indexOf(finals.kPold) > -1) {
            sumKPolD++;
            sumKPolDforChart++;
            FormattingType2(reference, finals.LimeGreen);
        } else if ((previousRef.indexOf(finals.Ak1) > -1 || previousRef.indexOf(finals.Ak2) > -1)) {
            sumAk++;
            sumAkforChart++;
            FormattingType2(reference, finals.SaddleBrown);
        } else if ((previousRef.indexOf(finals.pk) > -1 || previousRef.indexOf(finals.pk1) > -1 || previousRef.indexOf(finals.pk2) > -1)) {
            sumPk++;
            sumPkforChart++;
            FormattingType2(reference, finals.BlueViolet);
        } else if ((previousRef.indexOf(finals.kpd) > -1 || previousRef.indexOf(finals.kpd1) > -1
                  || previousRef.indexOf(finals.kpd2) > -1 || previousRef.indexOf(finals.kpd3) > -1 || previousRef.indexOf(finals.kpd4) > -1)) {
            sumKpd++;
            sumKpdforChart++;
            FormattingType2(reference, finals.Red);
        } else {
            run.setText(reference);
        }
    }

    private void Find_INOMOY_Ref(Scanner scanner, String previousRef, String word1, String reference) {
        AllFinalsVariables finals = new AllFinalsVariables();

        if (previousRef.indexOf(finals.ndotd) > -1 || previousRef.indexOf(finals.ndotd1) > -1) {
            sumNdotD++;
            sumNdotDforChart++;
            word1 = scanner.next();
            FormattingType1(reference, finals.Olive);

        } else if ((word1.indexOf(finals.n) > -1 || word1.indexOf(finals.n1) > -1)) {
            if (word1.indexOf(finals.ndotd) == -1 && word1.indexOf(finals.ndotd1) == -1) {
                word1 = scanner.next();
                Pattern p = Pattern.compile("(1|2|3|4|5|6|7|8|9|10)");
                Matcher m = p.matcher(word1);
                if (m.find()) {
                    sumNdot++;
                    sumNdotforChart++;
                    reference = reference + " " + word1;
                    FormattingType1(reference, finals.SteelBlue);
                }
            }
        } else {
            run.setText(reference);
        }
    }
    //**************************************************************************
}
