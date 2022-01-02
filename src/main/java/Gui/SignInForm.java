/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Gui;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Model.Concesionario;
/**
 *
 * @author adria
 */
public class SignInForm extends javax.swing.JFrame {

    /**
     * Creates new form SignInForm
     */
    public SignInForm() {
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

        background = new javax.swing.JPanel();
        telefonoText = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        nameText = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        correoText = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        direccionText = new javax.swing.JTextField();
        ConfirmarDatos = new javax.swing.JButton();
        passwordText = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        apellidosText1 = new javax.swing.JTextField();
        dniText = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        background.setBackground(new java.awt.Color(204, 255, 255));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        telefonoText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telefonoTextActionPerformed(evt);
            }
        });
        background.add(telefonoText, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 296, 260, -1));

        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Password");
        background.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 264, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Registrarse");
        background.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(151, 6, 90, 32));
        background.add(nameText, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 56, 260, -1));

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nombre:");
        background.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 56, -1, 24));

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Apellidos:");
        background.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 102, -1, -1));
        background.add(correoText, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 140, 260, -1));

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Correo:");
        background.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 140, 50, -1));

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("DNI:");
        background.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 186, 50, -1));

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Dirección:");
        background.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 228, -1, -1));
        background.add(direccionText, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 224, 260, -1));

        ConfirmarDatos.setText("Confirmar Datos");
        ConfirmarDatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ConfirmarDatosMouseClicked(evt);
            }
        });
        ConfirmarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmarDatosActionPerformed(evt);
            }
        });
        background.add(ConfirmarDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 330, -1, 30));

        passwordText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordTextActionPerformed(evt);
            }
        });
        background.add(passwordText, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 260, 260, -1));

        jButton2.setText("Cancelar");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        background.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 332, -1, -1));

        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Tlfn");
        background.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 300, -1, -1));
        background.add(apellidosText1, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 98, 260, -1));
        background.add(dniText, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 182, 260, -1));

        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 380));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void passwordTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordTextActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        new AppMainForm().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton2MouseClicked

    private void ConfirmarDatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ConfirmarDatosMouseClicked
        // TODO add your handling code here:
        String nombreCompleto = nameText.getText() + correoText.getText();
        int telefono = Integer.parseInt(telefonoText.getText());
        String Correo = asignarCorreo(correoText.getText());
        String Dni = asignarDni(dniText.getText());
        if(Correo == null || Dni == null){
            new DatosIncorrectos().setVisible(true);
        }
        String Direccion = direccionText.getText();
        String Contraseña = passwordText.getText();
        Concesionario.setClienteActual(Concesionario.crearCliente(
                (String) Correo, telefono, Correo,(String) Dni, Direccion, Contraseña)); 
        new AppMainForm().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_ConfirmarDatosMouseClicked

    private void ConfirmarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmarDatosActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_ConfirmarDatosActionPerformed

    private void telefonoTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telefonoTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telefonoTextActionPerformed

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
            java.util.logging.Logger.getLogger(SignInForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SignInForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SignInForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignInForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignInForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ConfirmarDatos;
    private javax.swing.JTextField apellidosText1;
    private javax.swing.JPanel background;
    private javax.swing.JTextField correoText;
    private javax.swing.JTextField direccionText;
    private javax.swing.JTextField dniText;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField nameText;
    private javax.swing.JTextField passwordText;
    private javax.swing.JTextField telefonoText;
    // End of variables declaration//GEN-END:variables

    private String asignarCorreo(String text) {
         Pattern pattern = Pattern
                .compile("([a-z0-9]+(\\\\.?[a-z0-9])*)+@(([a-z]+)\\\\.([a-z]+))+");
 
        Matcher m = pattern.matcher("");
        if(m.find()){
            return text;
        }else{
            return null;
        }
    }

    private String asignarDni(String text) {
        Pattern pattern = Pattern
                .compile("[0-9]{7,8}[A-Z a-z]");
        Matcher m = pattern.matcher("");
        if(m.find()){
            return text;
        }else{
            return null;
        }        
    }
}
