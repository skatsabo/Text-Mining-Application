package textdatamining;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author spiros
 */
public class MainFrameForm extends javax.swing.JFrame {

    private String path;
    private int choice;
    String itemText = "MultiLayerPerceptron";//comboBox, αρχικοποιείτε με μια τιμή

    public MainFrameForm() { //constructor
        Image img = Toolkit.getDefaultToolkit().createImage("Blueprint border.jpg");
        ImageIcon im = new ImageIcon();
        BufferedImage img1 = scaleImage(470, 300, "Blueprint border.jpg");
        im.setImage(img1);
        setContentPane(new JLabel(im));

        initComponents();
        
        choice = 0;
        this.path = path;

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        NextButton = new javax.swing.JButton();
        ExitButton = new javax.swing.JButton();
        HeaderSummarisation = new javax.swing.JRadioButton();
        InformationExtraction = new javax.swing.JRadioButton();
        Classify = new javax.swing.JRadioButton();
        ComboBox = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel1.setText("Text Mining in Legal Texts");
        jLabel1.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        NextButton.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        NextButton.setText("Next >>");
        NextButton.setPreferredSize(new java.awt.Dimension(100, 25));
        NextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextButtonActionPerformed(evt);
            }
        });

        ExitButton.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        ExitButton.setText("Exit");
        ExitButton.setPreferredSize(new java.awt.Dimension(100, 25));
        ExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitButtonActionPerformed(evt);
            }
        });

        HeaderSummarisation.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        HeaderSummarisation.setText("Header Summarisation");
        HeaderSummarisation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HeaderSummarisationActionPerformed(evt);
            }
        });

        InformationExtraction.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        InformationExtraction.setText("Hightlight References");
        InformationExtraction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InformationExtractionActionPerformed(evt);
            }
        });

        Classify.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Classify.setText("Classify");
        Classify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClassifyActionPerformed(evt);
            }
        });

        ComboBox.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        ComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "MultiLayerPerceptron", "RBFNetwork", "SMO", "SimpleLogistic" }));
        ComboBox.setToolTipText("");
        ComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(NextButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ExitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(HeaderSummarisation)
                            .addGap(18, 18, 18)
                            .addComponent(InformationExtraction, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(Classify)
                            .addGap(18, 18, 18)
                            .addComponent(ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel1))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(HeaderSummarisation)
                    .addComponent(InformationExtraction))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Classify)
                    .addComponent(ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ExitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextButtonActionPerformed
        //Επιλογή λειτουργίας
        if (choice == 1) {
            new HeaderSummarisationFrame().setVisible(true);;
        }
        if (choice == 2) {
            new ExportRefMenu().setVisible(true);
        }
        if (choice == 3) {
            if (itemText == "MultiLayerPerceptron") {
                new PerceptronFrame().setVisible(true);
            } else if (itemText == "RBFNetwork") {
                new RBFNetworkFrame().setVisible(true);
            } else if (itemText == "SMO") {
                new SMOFrame().setVisible(true);
            } else if (itemText == "SimpleLogistic"){
                new SimpleLogisticFrame().setVisible(true);
            }
        }

    }//GEN-LAST:event_NextButtonActionPerformed

    private void ExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitButtonActionPerformed
        System.exit(0); //Τερματίζει την εφαρμογή
    }//GEN-LAST:event_ExitButtonActionPerformed

    private void HeaderSummarisationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HeaderSummarisationActionPerformed
        choice = 1;
        InformationExtraction.setSelected(false);
        Classify.setSelected(false);
    }//GEN-LAST:event_HeaderSummarisationActionPerformed

    private void InformationExtractionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InformationExtractionActionPerformed
        choice = 2;
        HeaderSummarisation.setSelected(false);
        Classify.setSelected(false);
    }//GEN-LAST:event_InformationExtractionActionPerformed

    private void ClassifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClassifyActionPerformed
        choice = 3;
        HeaderSummarisation.setSelected(false);
        InformationExtraction.setSelected(false);
    }//GEN-LAST:event_ClassifyActionPerformed

    private void ComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxActionPerformed
        ComboBox.getSelectedItem();
        itemText = (String) ComboBox.getSelectedItem();

    }//GEN-LAST:event_ComboBoxActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(MainFrameForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrameForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrameForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrameForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrameForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton Classify;
    private javax.swing.JComboBox ComboBox;
    private javax.swing.JButton ExitButton;
    private javax.swing.JRadioButton HeaderSummarisation;
    private javax.swing.JRadioButton InformationExtraction;
    private javax.swing.JButton NextButton;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

    BufferedImage scaleImage(int WIDTH, int HEIGHT, String filename) { //Φωρτώνει την εικόνα στο gui
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
