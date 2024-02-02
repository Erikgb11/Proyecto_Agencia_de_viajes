/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agencia_viajes;

import javax.swing.*;
import java.io.*;
import javax.activation.*;
import javax.mail.*;
import java.util.*;

import javax.mail.internet.*;
import agencia_viajes.*;
/**
 *
 * @author erikg
 */
public class editAdmin extends javax.swing.JFrame {

    /**
     * Creates new form editAdmin
     */
    public editAdmin() {
        initComponents();
        jTName.setText(sesionAdmin.getUsuarioActual().getNombre());
        jTCorreo.setText(sesionAdmin.getUsuarioActual().getCorreo());
    }
    public static void transfer_to_email(String correo, String nombre) {
        System.out.println(correo + " " + nombre);
        String correoEnvia = "Aqui va tu correo";
        String contraseña = "Aqui va tu contraseña generada(sin espacios)";
        String mensaje = "Hola " + nombre
                + "tu cuenta ha sido editada correctamente";

        Properties objectPEC = new Properties();
        objectPEC.put("mail.smtp.host", "smtp.gmail.com");
        objectPEC.setProperty("mail.smtp.starttls.enable", "true");
        objectPEC.put("mail.smtp.port", "587");
        objectPEC.setProperty("mail.smtp.port", "587");
        objectPEC.put("mail.smtp.user", correoEnvia);
        objectPEC.setProperty("mail.smtp.auth", "true");

        Session sesion = Session.getDefaultInstance(objectPEC);
        MimeMessage mail = new MimeMessage(sesion);

        try {
            mail.setFrom(new InternetAddress(correoEnvia));
            mail.addRecipient(Message.RecipientType.TO, new InternetAddress(correo));
            mail.setSubject("Se creo tu cuenta correctamente");
            mail.setText(mensaje);

            Transport transporte = sesion.getTransport("smtp");
            transporte.connect(correoEnvia, contraseña);
            transporte.sendMessage(mail, mail.getRecipients(Message.RecipientType.TO));
            transporte.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTCorreo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPassword1 = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jPassword2 = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        jPassword3 = new javax.swing.JPasswordField();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setText("Crear Sesión");

        jLabel1.setText("Nombre");

        jTName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTNameActionPerformed(evt);
            }
        });

        jLabel2.setText("Correo");

        jLabel3.setText("Nueva contraseña");

        jLabel4.setText("Contraseña Actual");

        jLabel5.setText("Confirmar Contraseña");

        jButton3.setText("Aceptar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton2.setText("Cerrar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("Atrás");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGap(100, 100, 100)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(138, 138, 138)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPassword3, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                    .addComponent(jPassword2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPassword1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTCorreo, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTName, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(137, 137, 137))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(149, 149, 149))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(146, 146, 146))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(172, 172, 172))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(170, 170, 170))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(148, 148, 148))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGap(1, 1, 1)
                .addComponent(jTName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addGap(1, 1, 1)
                .addComponent(jPassword1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPassword2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPassword3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1)
                    .addComponent(jButton3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTNameActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String name=jTName.getText();
        String correo=jTCorreo.getText();
        char[] contraChars1 = jPassword1.getPassword();
        String contra1 = new String(contraChars1);
        char[] contraChars2 = jPassword2.getPassword();
        String contra2 = new String(contraChars2);
        char[] contraChars3 = jPassword3.getPassword();
        String contra3 = new String(contraChars3);

        String patronCorreo = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        String patronContrasena = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
        
        if(contra1.equals(sesionAdmin.getUsuarioActual().getContra())){
            if(correo.matches(patronCorreo)){
                if(contra2.isEmpty()&&contra3.isEmpty()){
                    Admin admin=new Admin(name,correo,sesionAdmin.getUsuarioActual().getContra());
                    try {
                        FileInputStream fis = new FileInputStream("Admins.txt");
                        ObjectInputStream ois = new ObjectInputStream(fis);
                        Admin admins2[]= (Admin[]) ois.readObject( );
                        ois.close();
                        
                        FileInputStream fis1 = new FileInputStream("Clientes.txt");
                        ObjectInputStream ois1 = new ObjectInputStream(fis1);
                        Cliente clientes2[]= (Cliente[]) ois1.readObject( );
                        ois.close();
                        int c=0;
                        for(int j=0;j<clientes2.length;j++){
                            if(clientes2[j].obtenerCorreo().equals(correo)){
                                c++;
                            }
                        }
                        if(c==0){
                            for(int i=0; i<admins2.length; i++){
                                if(!(admins2[i].getCorreo().equals(sesionAdmin.getUsuarioActual().getCorreo()))){
                                    if(admins2[i].getCorreo().equals(correo)){
                                        c++;
                                    }
                                }
                            }
                            if(c==0){
                                for(int i=0; i<admins2.length; i++){
                                    if((admins2[i].getCorreo().equals(sesionAdmin.getUsuarioActual().getCorreo()))){
                                        admins2[i]=admin;
                                    }
                                }
                                FileOutputStream fos = new FileOutputStream("Admins.txt");
                                ObjectOutputStream ous = new ObjectOutputStream(fos);
                                ous.writeObject(admins2);
                                ous.close();
                                JOptionPane.showMessageDialog(this,"Perfil editado Exitosamente");
                                sesionAdmin.cerrarSesion();
                                Isesion Is=new Isesion();
                                Is.setVisible(true);
                                dispose();
                            }else{
                                int i=JOptionPane.showConfirmDialog(this,"Correo en uso \n Quieres intentar de nuevo?");
                                if(i==1||i==2){
                                    InicioAdmin IA=new InicioAdmin();
                                    IA.setVisible(true);
                                    dispose();
                                }
                            }
                        }else{
                            int i=JOptionPane.showConfirmDialog(this,"Correo en uso \n Quieres intentar de nuevo?");
                            if(i==1||i==2){
                                InicioAdmin IA=new InicioAdmin();
                                IA.setVisible(true);
                                dispose();
                            }
                        }
                        
                        } catch(Exception e) { e.printStackTrace(); }
                }else if(contra2.equals(contra3)){
                    if(contra2.matches(patronContrasena)){
                        Admin admin=new Admin(name,correo,contra2);
                        try {
                            FileInputStream fis = new FileInputStream("Admins.txt");
                            ObjectInputStream ois = new ObjectInputStream(fis);
                            Admin admins2[]= (Admin[]) ois.readObject( );
                            ois.close();

                            FileInputStream fis1 = new FileInputStream("Clientes.txt");
                            ObjectInputStream ois1 = new ObjectInputStream(fis1);
                            Cliente clientes2[]= (Cliente[]) ois1.readObject( );
                            ois.close();
                            int c=0;
                            for(int j=0;j<clientes2.length;j++){
                                if(clientes2[j].obtenerCorreo().equals(correo)){
                                    c++;
                                }
                            }
                            if(c==0){
                                for(int i=0; i<admins2.length; i++){
                                    if(!(admins2[i].getCorreo().equals(sesionAdmin.getUsuarioActual().getCorreo()))){
                                        if(admins2[i].getCorreo().equals(correo)){
                                            c++;
                                        }
                                    }
                                }
                                if(c==0){
                                    for(int i=0; i<admins2.length; i++){
                                        if((admins2[i].getCorreo().equals(sesionAdmin.getUsuarioActual().getCorreo()))){
                                            admins2[i]=admin;
                                        }
                                    }
                                    FileOutputStream fos = new FileOutputStream("Admins.txt");
                                    ObjectOutputStream ous = new ObjectOutputStream(fos);
                                    ous.writeObject(admins2);
                                    ous.close();
                                    JOptionPane.showMessageDialog(this,"Perfil editado Exitosamente");
                                    transfer_to_email(sesionAdmin.getUsuarioActual().getCorreo(),sesionAdmin.getUsuarioActual().getNombre());
                                    sesionAdmin.cerrarSesion();
                                    Isesion Is=new Isesion();
                                    Is.setVisible(true);
                                    dispose();
                                }else{
                                    int i=JOptionPane.showConfirmDialog(this,"Correo en uso \n Quieres intentar de nuevo?");
                                    if(i==1||i==2){
                                        InicioAdmin IA=new InicioAdmin();
                                        IA.setVisible(true);
                                        dispose();
                                    }
                                }
                            }else{
                                int i=JOptionPane.showConfirmDialog(this,"Correo en uso \n Quieres intentar de nuevo?");
                                if(i==1||i==2){
                                    InicioAdmin IA=new InicioAdmin();
                                    IA.setVisible(true);
                                    dispose();
                                }
                            }

                        } catch(Exception e) { e.printStackTrace(); }
                    }else{
                        int i=JOptionPane.showConfirmDialog(this,"Lo siento, Tu contraseña debe tener al menos una letra, un digito, un caracter especial @, $, !, %, *, ?, & y 8 caracteres \n Quieres intentar de nuevo?");
                        if(i==1||i==2){
                            InicioAdmin IA=new InicioAdmin();
                            IA.setVisible(true);
                            dispose();
                        }
                    }
                }else{
                    int i=JOptionPane.showConfirmDialog(this,"Lo siento, tus contraseñas no coinciden \n Quieres intentar de nuevo?");
                    if(i==1||i==2){
                        InicioAdmin IA=new InicioAdmin();
                        IA.setVisible(true);
                        dispose();
                    }
                }
            }else{
                int i=JOptionPane.showConfirmDialog(this,"Lo siento, esa no es un correo valido \n Quieres intentar de nuevo?");
                if(i==1||i==2){
                    InicioAdmin IA=new InicioAdmin();
                    IA.setVisible(true);
                    dispose();
                }
            }
        }else{
            int i=JOptionPane.showConfirmDialog(this,"Lo siento, esa no es tu contraseña \n Quieres intentar de nuevo?");
            if(i==1||i==2){
                InicioAdmin IA=new InicioAdmin();
                IA.setVisible(true);
                dispose();
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        InicioAdmin IA=new InicioAdmin();
        IA.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        sesionAdmin.cerrarSesion();
        System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(editAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(editAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(editAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(editAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new editAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPasswordField jPassword1;
    private javax.swing.JPasswordField jPassword2;
    private javax.swing.JPasswordField jPassword3;
    private javax.swing.JTextField jTCorreo;
    private javax.swing.JTextField jTName;
    // End of variables declaration//GEN-END:variables
}