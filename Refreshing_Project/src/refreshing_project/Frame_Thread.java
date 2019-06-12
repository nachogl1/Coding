/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package refreshing_project;

/**
 *
 * @author Ignacio_Gonzalez
 */
class DaughterWindow extends javax.swing.JFrame implements Runnable {

    public DaughterWindow() {
        initComponents();
        this.setVisible(true);
        this.setTitle("Thread #"+String.valueOf(Thread.currentThread().getId()));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getId());
    }

}

public class Frame_Thread extends javax.swing.JFrame {

    public Frame_Thread() {
        initComponents();
        this.setVisible(true);
        this.setTitle("Father");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        hija = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        hija.setText("Hija");
        hija.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hijaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(hija)
                .addContainerGap(54, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(57, Short.MAX_VALUE)
                .addComponent(hija)
                .addGap(53, 53, 53))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void hijaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hijaActionPerformed
       
        new Thread(() -> {
            DaughterWindow d = new DaughterWindow();
        }).start();

    }//GEN-LAST:event_hijaActionPerformed

    public static void main(String args[]) {
        Frame_Thread test = new Frame_Thread();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton hija;
    // End of variables declaration//GEN-END:variables
}
