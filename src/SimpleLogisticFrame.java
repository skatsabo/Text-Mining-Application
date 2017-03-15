
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
import weka.classifiers.functions.SimpleLogistic;
import weka.core.Instances;
import weka.core.Utils;

/**
 *
 * @author spiros
 */
public class SimpleLogisticFrame extends javax.swing.JFrame {
    
    String createModel = null;
    String path = null;
    Instances train;

    SimpleLogistic slog = new SimpleLogistic();

    public SimpleLogisticFrame() {
        Image img = Toolkit.getDefaultToolkit().createImage("Blueprint border.jpg");
        ImageIcon im = new ImageIcon();

        BufferedImage img1 = scaleImage(490, 465, "Blueprint border.jpg");

        im.setImage(img1);
        setContentPane(new JLabel(im));
        
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ChooserFileARFF = new javax.swing.JFileChooser();
        ResultsDialog = new javax.swing.JDialog();
        jButton1 = new javax.swing.JButton();
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
        TrainingButton = new javax.swing.JButton();
        OpenARFFFile = new javax.swing.JButton();
        ClassificationButton = new javax.swing.JButton();
        CloseSimpleLogisticButton = new javax.swing.JButton();
        HeuristicStopField = new javax.swing.JTextField();
        MaxBoostingIterationsField = new javax.swing.JTextField();
        NumBoostingIterationsField = new javax.swing.JTextField();
        WeightTrimBetaField = new javax.swing.JTextField();

        ResultsDialog.setMinimumSize(new java.awt.Dimension(550, 430));

        jButton1.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jButton1.setText("Close");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Courier New", 0, 13)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setMinimumSize(new java.awt.Dimension(550, 430));
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
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE))
                .addContainerGap())
        );
        ResultsDialogLayout.setVerticalGroup(
            ResultsDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ResultsDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel1.setText("Classification in Legal Texts");

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel2.setText("Create o SimpleLogistic Model");

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        jLabel3.setText("HeuristicStop :");

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        jLabel4.setText("MaxBoostingIterations :");

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        jLabel5.setText("NumBoostingIterations :");

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        jLabel6.setText("WeightTrimBeta :");

        jLabel7.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel7.setText("For training push the butoon :");

        jLabel8.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel8.setText("For choose file push the button :");

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

        CloseSimpleLogisticButton.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        CloseSimpleLogisticButton.setText("Close");
        CloseSimpleLogisticButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseSimpleLogisticButtonActionPerformed(evt);
            }
        });

        HeuristicStopField.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        HeuristicStopField.setText("50");

        MaxBoostingIterationsField.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        MaxBoostingIterationsField.setText("500");

        NumBoostingIterationsField.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        NumBoostingIterationsField.setText("0");

        WeightTrimBetaField.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        WeightTrimBetaField.setText("0.0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(143, 143, 143))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(NumBoostingIterationsField))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(WeightTrimBetaField, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
                                    .addComponent(MaxBoostingIterationsField)
                                    .addComponent(HeuristicStopField)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(TrainingButton, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                            .addComponent(OpenARFFFile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addComponent(jLabel7))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CloseSimpleLogisticButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ClassificationButton, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(HeuristicStopField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(MaxBoostingIterationsField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(NumBoostingIterationsField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(WeightTrimBetaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(TrainingButton))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(OpenARFFFile)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ClassificationButton, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(CloseSimpleLogisticButton)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TrainingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TrainingButtonActionPerformed
        createModel = "-I " + NumBoostingIterationsField.getText() + " -M " + MaxBoostingIterationsField.getText() + " -H " 
                  + HeuristicStopField.getText();
        System.out.println(createModel);
        try {
            FileReader trainreader = new FileReader("C:\\Users\\spiros\\Documents\\TrainingSet.arff");
            train = new Instances(trainreader);
            train.setClassIndex(train.numAttributes() - 1);

            slog.setOptions(Utils.splitOptions(createModel));
            slog.buildClassifier(train);

            Evaluation eval = new Evaluation(train);
            eval.evaluateModel(slog, train);

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
            eval.evaluateModel(slog, test);
            jTextArea1.setText(eval.toSummaryString("\nSimpleLogistic - Classification Results\n"
                                                    + "=====================================\n", false) + "\n\n"
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

    private void CloseSimpleLogisticButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseSimpleLogisticButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_CloseSimpleLogisticButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ResultsDialog.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(SimpleLogisticFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SimpleLogisticFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SimpleLogisticFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SimpleLogisticFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SimpleLogisticFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser ChooserFileARFF;
    private javax.swing.JButton ClassificationButton;
    private javax.swing.JButton CloseSimpleLogisticButton;
    private javax.swing.JTextField HeuristicStopField;
    private javax.swing.JTextField MaxBoostingIterationsField;
    private javax.swing.JTextField NumBoostingIterationsField;
    private javax.swing.JButton OpenARFFFile;
    private javax.swing.JDialog ResultsDialog;
    private javax.swing.JButton TrainingButton;
    private javax.swing.JTextField WeightTrimBetaField;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
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
