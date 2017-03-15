package textdatamining;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import weka.classifiers.Evaluation;
import weka.core.Instances;
import weka.classifiers.functions.SMO;
import weka.core.Utils;

/**
 *
 * @author spiros
 */
public class SMOFrame extends javax.swing.JFrame {

    String createModel = null;
    String path = null;
    Instances train;

    SMO smo = new SMO();

    public SMOFrame() {
        Image img = Toolkit.getDefaultToolkit().createImage("Blueprint border.jpg");
        ImageIcon im = new ImageIcon();

        BufferedImage img1 = scaleImage(490, 520, "Blueprint border.jpg");

        im.setImage(img1);
        setContentPane(new JLabel(im));

        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ChooserFileARFF = new javax.swing.JFileChooser();
        ResultsDialog = new javax.swing.JDialog();
        CloseDialogButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cField = new javax.swing.JTextField();
        epsilonField = new javax.swing.JTextField();
        KernelField = new javax.swing.JTextField();
        NumFoldsField = new javax.swing.JTextField();
        RandomSeedField = new javax.swing.JTextField();
        ToleranceParametreField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        TrainingButton = new javax.swing.JButton();
        OpenARFFFile = new javax.swing.JButton();
        ClassificationButton = new javax.swing.JButton();
        CloseSMOFrame = new javax.swing.JButton();

        ResultsDialog.setMinimumSize(new java.awt.Dimension(550, 430));

        CloseDialogButton.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        CloseDialogButton.setText("Close");
        CloseDialogButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseDialogButtonActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Courier New", 0, 13)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout ResultsDialogLayout = new javax.swing.GroupLayout(ResultsDialog.getContentPane());
        ResultsDialog.getContentPane().setLayout(ResultsDialogLayout);
        ResultsDialogLayout.setHorizontalGroup(
            ResultsDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ResultsDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ResultsDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ResultsDialogLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(CloseDialogButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE))
                .addContainerGap())
        );
        ResultsDialogLayout.setVerticalGroup(
            ResultsDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ResultsDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(CloseDialogButton)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel1.setText("Classification in Legal Texts");

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel2.setText("Create a SMO Model");

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        jLabel3.setText("c :");

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        jLabel4.setText("epsilon :");

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        jLabel5.setText("Kernel :");

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        jLabel6.setText("NumFolds :");

        jLabel7.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        jLabel7.setText("RandomSeed :");

        jLabel8.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        jLabel8.setText("ToleranceParametre :");

        cField.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        cField.setText("1.0");

        epsilonField.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        epsilonField.setText("1.0E-12");

        KernelField.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        KernelField.setText("PolyKernel -C 250007 -E 1.0");

        NumFoldsField.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        NumFoldsField.setText("-1");

        RandomSeedField.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        RandomSeedField.setText("1");

        ToleranceParametreField.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        ToleranceParametreField.setText("0.001");

        jLabel9.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel9.setText("For training push the button :");

        jLabel10.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel10.setText("For choose file push the button :");

        TrainingButton.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        TrainingButton.setText("Training");
        TrainingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TrainingButtonActionPerformed(evt);
            }
        });

        OpenARFFFile.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        OpenARFFFile.setText("Open");
        OpenARFFFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenARFFFileActionPerformed(evt);
            }
        });

        ClassificationButton.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        ClassificationButton.setText("Classification");
        ClassificationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClassificationButtonActionPerformed(evt);
            }
        });

        CloseSMOFrame.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        CloseSMOFrame.setText("Close");
        CloseSMOFrame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseSMOFrameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(130, 130, 130)
                        .addComponent(cField))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(95, 95, 95)
                        .addComponent(epsilonField))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(100, 100, 100)
                        .addComponent(KernelField))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(80, 80, 80)
                        .addComponent(NumFoldsField))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(61, 61, 61)
                        .addComponent(RandomSeedField))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(ToleranceParametreField))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(37, 37, 37)
                                .addComponent(TrainingButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(OpenARFFFile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CloseSMOFrame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ClassificationButton, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(epsilonField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(KernelField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(NumFoldsField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(RandomSeedField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8))
                    .addComponent(ToleranceParametreField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(TrainingButton))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(OpenARFFFile)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ClassificationButton, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(CloseSMOFrame)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TrainingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TrainingButtonActionPerformed
        createModel = "-C " + cField.getText() + " -L " + ToleranceParametreField.getText() + " -P " + epsilonField.getText()
                  + " -N 0" + " -V " + NumFoldsField.getText() + " -W" + RandomSeedField.getText() + " -K weka.classifiers.function.supportVector." + KernelField.getText();
        System.out.println(createModel);
        try {
            FileReader trainreader = new FileReader("C:\\Users\\spiros\\Documents\\TrainingSet.arff");
            train = new Instances(trainreader);
            train.setClassIndex(train.numAttributes() - 1);

            smo.setOptions(Utils.splitOptions(createModel));
            smo.buildClassifier(train);

            Evaluation eval = new Evaluation(train);
            eval.evaluateModel(smo, train);

            jTextArea1.setText(eval.toSummaryString("\nTraining Results\n"
                                                    + "================\n", false) + "\n\n"
                      + eval.toClassDetailsString() + "\n\n" + eval.toMatrixString());

            ResultsDialog.setVisible(true);

            System.out.println(eval.toSummaryString("\nTRAIN Results\n======\n", false));
            System.out.println(eval.toClassDetailsString());
            System.out.println(eval.confusionMatrix());
            System.out.println(eval.toMatrixString());

            trainreader.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PerceptronFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PerceptronFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(PerceptronFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_TrainingButtonActionPerformed

    private void OpenARFFFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpenARFFFileActionPerformed
        if (ChooserFileARFF.showOpenDialog(this) == ChooserFileARFF.APPROVE_OPTION) {
            path = ChooserFileARFF.getSelectedFile().getAbsolutePath();
            System.out.println(path);
        }
    }//GEN-LAST:event_OpenARFFFileActionPerformed

    private void ClassificationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClassificationButtonActionPerformed
        try {
            FileReader testreader = new FileReader(path);
            Instances test = new Instances(testreader);
            test.setClassIndex(test.numAttributes() - 1);

            Evaluation eval = new Evaluation(train);
            eval.evaluateModel(smo, test);
            jTextArea1.setText(eval.toSummaryString("\nSMO - Classification Results\n"
                                                    + "=============================\n", false) + "\n\n"
                      + eval.toClassDetailsString() + "\n\n" + eval.toMatrixString());

            ResultsDialog.setVisible(true);

            System.out.println(eval.toSummaryString("\nResults\n======\n", false));
            System.out.println(eval.toClassDetailsString());
            System.out.println(eval.confusionMatrix());
            System.out.println(eval.toMatrixString());
            testreader.close();
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        } catch (Exception ex) {
            Logger.getLogger(PerceptronFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ClassificationButtonActionPerformed

    private void CloseSMOFrameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseSMOFrameActionPerformed
        this.dispose();
    }//GEN-LAST:event_CloseSMOFrameActionPerformed

    private void CloseDialogButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseDialogButtonActionPerformed
        ResultsDialog.setVisible(false);
    }//GEN-LAST:event_CloseDialogButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public void main() {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SMOFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SMOFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SMOFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SMOFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SMOFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser ChooserFileARFF;
    private javax.swing.JButton ClassificationButton;
    private javax.swing.JButton CloseDialogButton;
    private javax.swing.JButton CloseSMOFrame;
    private javax.swing.JTextField KernelField;
    private javax.swing.JTextField NumFoldsField;
    private javax.swing.JButton OpenARFFFile;
    private javax.swing.JTextField RandomSeedField;
    private javax.swing.JDialog ResultsDialog;
    private javax.swing.JTextField ToleranceParametreField;
    private javax.swing.JButton TrainingButton;
    private javax.swing.JTextField cField;
    private javax.swing.JTextField epsilonField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables

    BufferedImage scaleImage(int WIDTH, int HEIGHT, String filename) {
        BufferedImage bi = null;

        try {
            ImageIcon ii = new ImageIcon(filename); // path to image
            bi = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
            Graphics2D g2d = (Graphics2D) bi.createGraphics();
            g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
            g2d.drawImage(ii.getImage(), 0, 0, WIDTH, HEIGHT, null);
        } catch (Exception e) {
            return null;
        }
        return bi;
    }
}
