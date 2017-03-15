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
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import weka.classifiers.Evaluation;
import weka.classifiers.functions.RBFNetwork;
import weka.core.Instances;
import weka.core.Utils;

/**
 *
 * @author spiros
 */
public class RBFNetworkFrame extends javax.swing.JFrame {

    String createModel = null;
    String path = null;
    Instances train;

    RBFNetwork rbf = new RBFNetwork();

    public RBFNetworkFrame() {
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

        ResultsDialog = new javax.swing.JDialog();
        CloseDialogButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        ChooserFileARFF = new javax.swing.JFileChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        ClusteringSeedField = new javax.swing.JTextField();
        MaxItsField = new javax.swing.JTextField();
        MinStdDevField = new javax.swing.JTextField();
        NumClustersField = new javax.swing.JTextField();
        RidgeField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        TrainingButton = new javax.swing.JButton();
        OpenARFFfile = new javax.swing.JButton();
        ClussificationButton = new javax.swing.JButton();
        CloseRBFNetworkFrame = new javax.swing.JButton();

        ResultsDialog.setMinimumSize(new java.awt.Dimension(600, 550));

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
                .addContainerGap(450, Short.MAX_VALUE)
                .addComponent(CloseDialogButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
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
        jLabel2.setText("Create a RBFNetwork Model");

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        jLabel3.setText("ClusteringSeed :");

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        jLabel4.setText("MaxIts:");

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        jLabel5.setText("MinStdDev :");

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        jLabel6.setText("NumClusters :");

        jLabel7.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        jLabel7.setText("Ridge :");

        ClusteringSeedField.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        ClusteringSeedField.setText("1");

        MaxItsField.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        MaxItsField.setText("-1");

        MinStdDevField.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        MinStdDevField.setText("0.1");

        NumClustersField.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        NumClustersField.setText("2");

        RidgeField.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        RidgeField.setText("1.0E-8");

        jLabel8.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel8.setText("For training push the button :");

        jLabel9.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel9.setText("For choose file push the button :");

        TrainingButton.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        TrainingButton.setText("Training");
        TrainingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TrainingButtonActionPerformed(evt);
            }
        });

        OpenARFFfile.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        OpenARFFfile.setText("Open");
        OpenARFFfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenARFFfileActionPerformed(evt);
            }
        });

        ClussificationButton.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        ClussificationButton.setText("Classification");
        ClussificationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClussificationButtonActionPerformed(evt);
            }
        });

        CloseRBFNetworkFrame.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        CloseRBFNetworkFrame.setText("Close");
        CloseRBFNetworkFrame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseRBFNetworkFrameActionPerformed(evt);
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
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ClusteringSeedField))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(97, 97, 97)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(MinStdDevField)
                            .addComponent(MaxItsField)
                            .addComponent(RidgeField)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(59, 59, 59)
                        .addComponent(NumClustersField))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel8))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(OpenARFFfile, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                                    .addComponent(TrainingButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(CloseRBFNetworkFrame, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ClussificationButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(ClusteringSeedField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(MaxItsField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(MinStdDevField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(NumClustersField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(RidgeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(23, 23, 23))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(TrainingButton)
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(OpenARFFfile)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ClussificationButton, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(CloseRBFNetworkFrame)
                .addContainerGap(65, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TrainingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TrainingButtonActionPerformed
        createModel = "-B " + NumClustersField.getText() + " -S " + ClusteringSeedField.getText() + " -R " + RidgeField.getText()
                  + " -M " + MaxItsField.getText() + " -W " + MinStdDevField.getText();
        System.out.println(createModel);
        try {
            FileReader trainreader = new FileReader("C:\\Users\\spiros\\Documents\\TrainingSet.arff");
            train = new Instances(trainreader);
            train.setClassIndex(train.numAttributes() - 1);

            rbf.setOptions(Utils.splitOptions(createModel));
            rbf.buildClassifier(train);

            Evaluation eval = new Evaluation(train);
            eval.evaluateModel(rbf, train);

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

    private void OpenARFFfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpenARFFfileActionPerformed
        if (ChooserFileARFF.showOpenDialog(this) == ChooserFileARFF.APPROVE_OPTION) {
            path = ChooserFileARFF.getSelectedFile().getAbsolutePath();
            System.out.println(path);
        }
    }//GEN-LAST:event_OpenARFFfileActionPerformed

    private void ClussificationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClussificationButtonActionPerformed
        try {
            FileReader testreader = new FileReader(path);
            Instances test = new Instances(testreader);
            test.setClassIndex(test.numAttributes() - 1);

            Evaluation eval = new Evaluation(train);
            eval.evaluateModel(rbf, test);
            jTextArea1.setText(eval.toSummaryString("\nRBFNetwork - Classification Results\n"
                                                    + "=================================\n", false) + "\n\n"
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
    }//GEN-LAST:event_ClussificationButtonActionPerformed

    private void CloseRBFNetworkFrameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseRBFNetworkFrameActionPerformed
        this.dispose();
    }//GEN-LAST:event_CloseRBFNetworkFrameActionPerformed

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
            java.util.logging.Logger.getLogger(RBFNetworkFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RBFNetworkFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RBFNetworkFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RBFNetworkFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RBFNetworkFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser ChooserFileARFF;
    private javax.swing.JButton CloseDialogButton;
    private javax.swing.JButton CloseRBFNetworkFrame;
    private javax.swing.JButton ClussificationButton;
    private javax.swing.JTextField ClusteringSeedField;
    private javax.swing.JTextField MaxItsField;
    private javax.swing.JTextField MinStdDevField;
    private javax.swing.JTextField NumClustersField;
    private javax.swing.JButton OpenARFFfile;
    private javax.swing.JDialog ResultsDialog;
    private javax.swing.JTextField RidgeField;
    private javax.swing.JButton TrainingButton;
    private javax.swing.JLabel jLabel1;
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
