/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package juegosokoban;

/**
 *
 * @author Diego Rueda y Brahian Gonzales
 */
public class Inicializador extends javax.swing.JFrame {

    /**
     * Creates new form Inicializador
     */
    private String nombre;
    private String edad;
    private String sexo;
    private String nivel;
    
        
        
    public Inicializador() {
        initComponents();        
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JLdatusuario = new javax.swing.JLabel();
        JLnombre = new javax.swing.JLabel();
        JLedad = new javax.swing.JLabel();
        JLsexo = new javax.swing.JLabel();
        JLdatjuego = new javax.swing.JLabel();
        JLnivel = new javax.swing.JLabel();
        JTnombre = new javax.swing.JTextField();
        JTedad = new javax.swing.JTextField();
        JCBsexo = new javax.swing.JComboBox();
        JCBnivel = new javax.swing.JComboBox();
        JBjugar = new javax.swing.JButton();
        JLtitulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Datos - Juego Sokoban ");
        setBounds(new java.awt.Rectangle(300, 300, 0, 0));

        JLdatusuario.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        JLdatusuario.setText("Datos De Usuario:");

        JLnombre.setText("Nombre:");

        JLedad.setText("Edad:");

        JLsexo.setText("Sexo:");

        JLdatjuego.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        JLdatjuego.setText("Datos De Juego:");

        JLnivel.setText("Nivel:");

        JTnombre.setText("Player1");
        JTnombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTnombreActionPerformed(evt);
            }
        });

        JCBsexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Masculino", "Femenino" }));
        JCBsexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCBsexoActionPerformed(evt);
            }
        });

        JCBnivel.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nivel 1", "Nivel 2", "Nivel 3", "Nivel 4", "Nivel 5", "Nivel 6", "Nivel 7", "Nivel 8", "Nivel 9" }));

        JBjugar.setText("JUGAR");
        JBjugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBjugarActionPerformed(evt);
            }
        });

        JLtitulo.setFont(new java.awt.Font("Comic Sans MS", 3, 24)); // NOI18N
        JLtitulo.setForeground(new java.awt.Color(51, 153, 0));
        JLtitulo.setText("LION WARRIORS");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(39, 39, 39)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(JLedad)
                                    .add(JLsexo))
                                .add(31, 31, 31))
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                .add(JLnombre)
                                .add(18, 18, 18)))
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(JTnombre)
                            .add(JTedad)
                            .add(JCBsexo, 0, 95, Short.MAX_VALUE)))
                    .add(layout.createSequentialGroup()
                        .add(39, 39, 39)
                        .add(JLdatusuario)))
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(92, 92, 92)
                        .add(JLnivel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 35, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(JCBnivel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 90, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(JLdatjuego)
                        .add(75, 75, 75))))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .add(0, 0, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(JBjugar)
                        .add(174, 174, 174))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(JLtitulo)
                        .add(108, 108, 108))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(JLtitulo)
                .add(19, 19, 19)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(JLdatusuario)
                    .add(JLdatjuego))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(JTnombre, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(JLnombre)
                    .add(JLnivel)
                    .add(JCBnivel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(JTedad, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(JLedad))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(JCBsexo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(JLsexo))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(JBjugar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JTnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTnombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTnombreActionPerformed

    private void JCBsexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCBsexoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JCBsexoActionPerformed

    private void JBjugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBjugarActionPerformed
        // TODO add your handling code here:
        this.nombre=this.JTnombre.getText();
        this.edad=this.JTedad.getText();
        this.sexo=(String) this.JCBsexo.getSelectedItem();
        this.nivel=(String) this.JCBnivel.getSelectedItem();
        System.out.println(this.nombre+" "+this.edad+" "+this.sexo); 
        Juego juego = new Juego(this.nivel,this.nombre);
        this.dispose();
    }//GEN-LAST:event_JBjugarActionPerformed

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
            java.util.logging.Logger.getLogger(Inicializador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicializador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicializador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicializador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Inicializador().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBjugar;
    private javax.swing.JComboBox JCBnivel;
    private javax.swing.JComboBox JCBsexo;
    private javax.swing.JLabel JLdatjuego;
    private javax.swing.JLabel JLdatusuario;
    private javax.swing.JLabel JLedad;
    private javax.swing.JLabel JLnivel;
    private javax.swing.JLabel JLnombre;
    private javax.swing.JLabel JLsexo;
    private javax.swing.JLabel JLtitulo;
    private javax.swing.JTextField JTedad;
    private javax.swing.JTextField JTnombre;
    // End of variables declaration//GEN-END:variables
}
