/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agencia_viajes;

/**
 *
 * @author erikg
 */
import java.io.*;
import javax.swing.*;
import java.awt.*;
import javax.activation.*;
import javax.mail.*;
import java.util.*;

import javax.mail.internet.*;
public class cAdmin extends javax.swing.JFrame {

    /**
     * Creates new form cAdmin
     */
    public cAdmin() {
        initComponents();
    }
    public static void transfer_to_email(String correo, String nombre) {
        System.out.println(correo + " " + nombre);
        String correoEnvia = "Aqui va tu correo";
        String contraseña = "Aqui va tu contraseña generada(sin espacios)";
        String mensaje = "Hola " + nombre
                + ", bienvenid@ administrador, tu cuenta en APP-Agencia de viajes ha sido creada con exito.";

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

        jButton1 = new javax.swing.JButton();
        jTName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTCorreo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPassword1 = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jPassword2 = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Atrás");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Nombre");

        jLabel2.setText("Correo");

        jLabel3.setText("Contraseña");

        jLabel4.setText("Confirma Contraseña");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setText("Crear Sesión");

        jButton2.setText("Cerrar");

        jButton3.setText("Aceptar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(146, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(43, 43, 43)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTCorreo)
                                    .addComponent(jPassword1)
                                    .addComponent(jPassword2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addComponent(jLabel4)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(45, 45, 45))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(35, 35, 35)))
                        .addGap(129, 129, 129))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(149, 149, 149))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(70, 70, 70)
                .addComponent(jButton3)
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPassword1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPassword2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        InicioAdmin IA=new InicioAdmin();
        IA.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String name=jTName.getText();
        String correo=jTCorreo.getText();
        char[] contraChars1 = jPassword1.getPassword();
        String contra1 = new String(contraChars1);
        char[] contraChars2 = jPassword2.getPassword();
        String contra2 = new String(contraChars2);
        
        String patronCorreo = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        String patronContrasena = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
        
        Admin admin=new Admin(name,correo,contra1);
        
        System.out.println(admin);
        Admin admins[]={admin};
        try {
            File archivo = new File("Admins.txt");
            File archivo2 = new File("Clientes.txt");
            if (correo.matches(patronCorreo)) {
                if (contra2.matches(patronContrasena)) {
                    if (contra1.equals(contra2)) {
                        int el = 0;
                        if (archivo2.exists()) {
                            FileInputStream fis2 = new FileInputStream("Clientes.txt");
                            ObjectInputStream ois2 = new ObjectInputStream(fis2);
                            Cliente cliente2[] = (Cliente[]) ois2.readObject();
                            ois2.close();
                            for (int i = 0; i < cliente2.length; i++) {
                                if (cliente2[i].obtenerCorreo().equals(admin.getCorreo())) {
                                    el++;
                                }
                            }
                        }
                        if (el == 0) {
                            if (!archivo.exists()) {
                                try {
                                    FileOutputStream fs = new FileOutputStream("Admins.txt");
                                    ObjectOutputStream os = new ObjectOutputStream(fs);
                                    os.writeObject(admins);
                                    os.close();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                JOptionPane.showMessageDialog(this, "Perfil creado Exitosamente");
                                transfer_to_email(admin.getCorreo(), admin.getNombre());
                            } else {
                                FileInputStream fis3 = new FileInputStream("Admins.txt");
                                ObjectInputStream ois3 = new ObjectInputStream(fis3);
                                Admin admins2[] = (Admin[]) ois3.readObject();
                                ois3.close();
                                for (int i = 0; i < admins2.length; i++) {
                                    if ((admins2[i].getNombre().equals(admin.getNombre()))|| (admins2[i].getCorreo().equals(admin.getCorreo()))) {
                                        el++;
                                    }
                                    System.out.println(el);
                                }
                                if (el > 0) {
                                    int j = JOptionPane.showConfirmDialog(this,"Usuario existente \n Quieres intentar de nuevo?");
                                    if (j == 1 || j == 2) {
                                        Isesion Is = new Isesion();
                                        Is.setVisible(true);
                                        dispose();
                                    }
                                } else {
                                    try {
                                            Admin[] a3 = new Admin[admins2.length+1];
                                            for(int e=0; e<admins2.length; e++){
                                                a3[e]=admins2[e];
                                            }
                                            a3[admins2.length]=admin;
                                            for(int e=0; e<a3.length; e++){
                                                System.out.println(a3[e]);
                                            }
                                            FileOutputStream fs = new FileOutputStream("Admins.txt");
                                            ObjectOutputStream os = new ObjectOutputStream(fs);
                                            os.writeObject(a3);
                                            os.close();
                                    } catch(Exception e) { e.printStackTrace(); }
                                        JOptionPane.showMessageDialog(this,"Perfil creado Exitosamente");
                                        transfer_to_email(admin.getCorreo(), admin.getNombre());
                                    }
                            }
                            InicioAdmin Is = new InicioAdmin();
                            Is.setVisible(true);
                            dispose();
                        } else {
                            int j = JOptionPane.showConfirmDialog(this,"Usuario existente \n Quieres intentar de nuevo?");
                            if (j == 1 || j == 2) {
                                Isesion Is = new Isesion();
                                Is.setVisible(true);
                                dispose();
                            }
                        }

                    } else {
                        int y = JOptionPane.showConfirmDialog(this,"Lo siento, las contraseñas no coinciden \n Quieres intentar de nuevo?");
                        if (y == 1 || y == 2) {
                            Isesion Is = new Isesion();
                            Is.setVisible(true);
                            dispose();
                        }
                    }
                } else {
                    int j = JOptionPane.showConfirmDialog(this,"Tu contraseña debe tener al menos una letra, un digito, un caracter especial @, $, !, %, *, ?, & y 8 caracteres, Intentalo de nuevo");
                    if (j == 1 || j == 2) {
                        Isesion Is = new Isesion();
                        Is.setVisible(true);
                        dispose();
                    }
                }
            } else {
                int j = JOptionPane.showConfirmDialog(this, "Ese no es un correo, ¿quieres intentar con un correo?");
                if (j == 1 || j == 2) {
                    Isesion Is = new Isesion();
                    Is.setVisible(true);
                    dispose();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(cAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cAdmin().setVisible(true);
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
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPasswordField jPassword1;
    private javax.swing.JPasswordField jPassword2;
    private javax.swing.JTextField jTCorreo;
    private javax.swing.JTextField jTName;
    // End of variables declaration//GEN-END:variables
}
