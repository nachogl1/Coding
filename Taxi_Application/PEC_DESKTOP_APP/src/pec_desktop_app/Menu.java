
package pec_desktop_app;


import javax.swing.JOptionPane;
import static pec_desktop_app.Controller2.currentMin;


/**
 *
 * @author ig2348z.gre.ac.uk
 */
public class Menu extends javax.swing.JFrame {
   

    public Menu() {
        initComponents();
        this.setTitle("Speedy taxis");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setVisible(true);
        Controller2.jS=false;
        Controller2.sS=false;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButtonStartShift = new javax.swing.JButton();
        jButtonStartJourney = new javax.swing.JButton();
        jButtonFinishJourney = new javax.swing.JButton();
        jButtonFinishShift = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabelStartS = new javax.swing.JLabel();
        jLabelStartJ = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabelTotal = new javax.swing.JLabel();
        jTextFrom = new javax.swing.JTextField();
        jTextTo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonStartShift.setText("Start shift");
        jButtonStartShift.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStartShiftActionPerformed(evt);
            }
        });

        jButtonStartJourney.setText("Start journey");
        jButtonStartJourney.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStartJourneyActionPerformed(evt);
            }
        });

        jButtonFinishJourney.setText("Finish journey");
        jButtonFinishJourney.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFinishJourneyActionPerformed(evt);
            }
        });

        jButtonFinishShift.setText("Finish shift");
        jButtonFinishShift.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFinishShiftActionPerformed(evt);
            }
        });

        jLabelStartS.setText("Clocked out");

        jLabelStartJ.setText("Off duty");

        jLabel1.setText("Total(min):");

        jLabelTotal.setText("0");

        jTextFrom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFromActionPerformed(evt);
            }
        });

        jTextTo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextToActionPerformed(evt);
            }
        });

        jLabel2.setText("From");

        jLabel5.setText("To");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButtonFinishJourney)
                            .addComponent(jButtonStartJourney)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButtonFinishShift)
                                .addGap(8, 8, 8)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabelStartJ)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabelTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 164, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 12, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel5))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jTextFrom)
                                            .addComponent(jTextTo, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel3)
                                        .addGap(42, 42, 42))
                                    .addComponent(jLabel4)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jButtonStartShift)
                        .addGap(37, 37, 37)
                        .addComponent(jLabelStartS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonStartShift)
                            .addComponent(jLabelStartS)
                            .addComponent(jTextFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonStartJourney)
                            .addComponent(jLabelStartJ)
                            .addComponent(jLabel5)
                            .addComponent(jTextTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonFinishJourney)
                            .addComponent(jLabel1)
                            .addComponent(jLabelTotal))
                        .addGap(18, 18, 18)
                        .addComponent(jButtonFinishShift))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel3)
                        .addGap(50, 50, 50)
                        .addComponent(jLabel4)))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonFinishShiftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFinishShiftActionPerformed
        if(Controller2.sS && !Controller2.jS){
        jLabelStartS.setText("Clocked out");
        int d=finishShift(Controller2.shiftId, Integer.parseInt(jLabelTotal.getText()));
        Controller2.shiftId=-1;
        Controller2.sS=false;
        }else{
        JOptionPane.showMessageDialog(jPanel1, "There was an error", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_jButtonFinishShiftActionPerformed

    private void jButtonStartShiftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStartShiftActionPerformed
        if(!Controller2.sS && !Controller2.jS){
        jLabelStartS.setText("Clocked in");
        Controller2.shiftId=createShift(Controller2.userId);   
        Controller2.sS=true;
        }else{
        JOptionPane.showMessageDialog(jPanel1, "There was an error", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonStartShiftActionPerformed

    private void jButtonStartJourneyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStartJourneyActionPerformed
       if(!Controller2.jS && Controller2.sS){
        jLabelStartJ.setText("On duty");      
        Controller2.journeyId=createJourney(Controller2.shiftId);
        Controller2.jS=true;
        }else{
       JOptionPane.showMessageDialog(jPanel1, "There was an error", "Error", JOptionPane.ERROR_MESSAGE);
       }
    }//GEN-LAST:event_jButtonStartJourneyActionPerformed

    private void jButtonFinishJourneyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFinishJourneyActionPerformed
       if(Controller2.jS && Controller2.sS){
        jLabelStartJ.setText("Off duty");
        currentMin=+ finishJourney(Controller2.journeyId,jTextFrom.getText(),jTextTo.getText());  
        int tempVal=Integer.parseInt(jLabelTotal.getText());
        jLabelTotal.setText(String.valueOf(tempVal+currentMin));
        Controller2.journeyId=-1;
        Controller2.jS=false;
        }else{
       JOptionPane.showMessageDialog(jPanel1, "There was an error", "Error", JOptionPane.ERROR_MESSAGE);
       }
    }//GEN-LAST:event_jButtonFinishJourneyActionPerformed

    private void jTextFromActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFromActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFromActionPerformed

    private void jTextToActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextToActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextToActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonFinishJourney;
    private javax.swing.JButton jButtonFinishShift;
    private javax.swing.JButton jButtonStartJourney;
    private javax.swing.JButton jButtonStartShift;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelStartJ;
    private javax.swing.JLabel jLabelStartS;
    private javax.swing.JLabel jLabelTotal;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextFrom;
    private javax.swing.JTextField jTextTo;
    // End of variables declaration//GEN-END:variables

    private static int createJourney(int shiftId) {
        client.JourneyAndShiftsService_Service service = new client.JourneyAndShiftsService_Service();
        client.JourneyAndShiftsService port = service.getJourneyAndShiftsServicePort();
        return port.createJourney(shiftId);
    }

    private static int createShift(int userId) {
        client.JourneyAndShiftsService_Service service = new client.JourneyAndShiftsService_Service();
        client.JourneyAndShiftsService port = service.getJourneyAndShiftsServicePort();
        return port.createShift(userId);
    }

    private static int finishJourney(int journeyId, java.lang.String journeyFrom, java.lang.String journeyTo) {
        client.JourneyAndShiftsService_Service service = new client.JourneyAndShiftsService_Service();
        client.JourneyAndShiftsService port = service.getJourneyAndShiftsServicePort();
        return port.finishJourney(journeyId, journeyFrom, journeyTo);
    }

    private static int finishShift(int shiftId, int shiftDuration) {
        client.JourneyAndShiftsService_Service service = new client.JourneyAndShiftsService_Service();
        client.JourneyAndShiftsService port = service.getJourneyAndShiftsServicePort();
        return port.finishShift(shiftId, shiftDuration);
    }


}
