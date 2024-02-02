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

import static java.awt.image.ImageObserver.HEIGHT;
import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;

public class verHistorialAdmin extends javax.swing.JFrame {

    /**
     * Creates new form verHistorialAdmin
     */
    public verHistorialAdmin() {
        initComponents();
        jTaviones.setDefaultRenderer(Object.class, new ImgTabla());
        String titulos[] = { "Nombre", "Tipo", "Cantidad comprada", "Total pagado", "Fecha de compra","correo"};
        DefaultTableModel tm = new DefaultTableModel(null, titulos) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        try {
            File archivo = new File("Compras.txt");
            if(archivo.exists()){
                FileInputStream fis = new FileInputStream("Compras.txt");
                ObjectInputStream ois = new ObjectInputStream(fis);
                compra c2[] = (compra[]) ois.readObject();
                ois.close();
                for (int i = 0; i < c2.length; i++) {
                    String tipo = c2[i].getTipo();
                    switch (tipo) {
                        case "hotel":
                            FileInputStream fis2 = new FileInputStream("Hoteles.txt");
                            ObjectInputStream ois2 = new ObjectInputStream(fis2);
                            Hotel h2[] = (Hotel[]) ois2.readObject();
                            ois2.close();
                            tm.addRow(new Object[] { h2[c2[i].getId()].getnombre(), "hotel", c2[i].getCantidadC(),
                                    c2[i].getPagado(), c2[i].getFCompra(),c2[i].getCorreoC() });
                            jTaviones.setRowHeight(50);
                            break;
                        case "bus":
                            FileInputStream fis3 = new FileInputStream("Buses.txt");
                            ObjectInputStream ois3 = new ObjectInputStream(fis3);
                            Bus b2[] = (Bus[]) ois3.readObject();
                            ois3.close();
                            tm.addRow(new Object[] { b2[c2[i].getId()].getorigen() + "-" + b2[c2[i].getId()].getdestino(),
                                    "bus", c2[i].getCantidadC(), c2[i].getPagado(), c2[i].getFCompra(),c2[i].getCorreoC() });
                            jTaviones.setRowHeight(50);
                            break;
                        case "avion":
                            FileInputStream fis4 = new FileInputStream("Vuelos.txt");
                            ObjectInputStream ois4 = new ObjectInputStream(fis4);
                            Avion a2[] = (Avion[]) ois4.readObject();
                            ois4.close();
                            tm.addRow(new Object[] { a2[c2[i].getId()].getorigen() + "-" + a2[c2[i].getId()].getdestino(),
                                    "avion", c2[i].getCantidadC(), c2[i].getPagado(), c2[i].getFCompra(),c2[i].getCorreoC() });
                            jTaviones.setRowHeight(50);
                            break;
                        case "crucero":
                            FileInputStream fis5 = new FileInputStream("Cruceros.txt");
                            ObjectInputStream ois5 = new ObjectInputStream(fis5);
                            Crucero cr2[] = (Crucero[]) ois5.readObject();
                            ois5.close();
                            tm.addRow(new Object[] { cr2[c2[i].getId()].getorigen() + "-" + cr2[c2[i].getId()].getdestino(),
                                    "crucero", c2[i].getCantidadC(), c2[i].getPagado(), c2[i].getFCompra(),c2[i].getCorreoC() });
                            jTaviones.setRowHeight(50);
                            break;
                        case "bh":
                            FileInputStream fis6 = new FileInputStream("B_H.txt");
                            ObjectInputStream ois6 = new ObjectInputStream(fis6);
                            Bus_Hotel bh2[] = (Bus_Hotel[]) ois6.readObject();
                            ois6.close();
                            tm.addRow(new Object[] {
                                    bh2[c2[i].getId()].Mostrarviaje().getorigen() + "-"
                                            + bh2[c2[i].getId()].Mostrarviaje().getdestino() + "/Hote: "
                                            + bh2[c2[i].getId()].mostarh().getnombre(),
                                    "Bus_Hotel", c2[i].getCantidadC(), c2[i].getPagado(), c2[i].getFCompra(),c2[i].getCorreoC() });
                            jTaviones.setRowHeight(50);
                            break;
                        case "vh":
                            FileInputStream fis7 = new FileInputStream("V_H.txt");
                            ObjectInputStream ois7 = new ObjectInputStream(fis7);
                            Vuelo_Hotel vh2[] = (Vuelo_Hotel[]) ois7.readObject();
                            ois7.close();
                            tm.addRow(new Object[] {
                                    vh2[c2[i].getId()].Mostrarviaje().getorigen() + "-"
                                            + vh2[c2[i].getId()].Mostrarviaje().getdestino() + "/Hote: "
                                            + vh2[c2[i].getId()].mostarh().getnombre(),
                                    "Vuelo_Hotel", c2[i].getCantidadC(), c2[i].getPagado(), c2[i].getFCompra(),c2[i].getCorreoC() });
                            jTaviones.setRowHeight(50);
                            break;
                    }
                }
            }else{
                    JPanel panel = new JPanel(new GridLayout(0, 1, 10, 10));
                    JPanel avionPanel = new JPanel();
                    avionPanel.setLayout(new BoxLayout(avionPanel, BoxLayout.Y_AXIS));
                    JLabel no = new JLabel("Aun no se han hecho compras");
                    avionPanel.add(no);
                    panel.add(avionPanel);
                    GroupLayout layout = new GroupLayout(getContentPane());
                    getContentPane().setLayout(layout);

                    GroupLayout layout2 = new GroupLayout(getContentPane());
                    getContentPane().setLayout(layout2);

                    // Configurar GroupLayout para manejar el panel
                    layout2.setHorizontalGroup(layout2.createSequentialGroup().addComponent(panel));
                    layout2.setVerticalGroup(layout2.createSequentialGroup().addComponent(panel));

                    // Configurar la ventana principal
                    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    setLocationRelativeTo(null);
                    setVisible(true);   
                }
            

        } catch (Exception e) {
            e.printStackTrace();
        }
        jTaviones.setModel(tm);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTaviones = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTaviones.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {
                        {},
                        {},
                        {},
                        {}
                },
                new String[] {

                }));
        jScrollPane1.setViewportView(jTaviones);

        jButton3.setText("Salir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
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
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, 813, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
                                                .createSequentialGroup()
                                                .addComponent(jButton1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jButton3)))
                                .addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 346,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47,
                                        Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton3)
                                        .addComponent(jButton1))
                                .addContainerGap()));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton3ActionPerformed
        System.exit(0);
        sesionAdmin.cerrarSesion();
    }// GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
        InicioAdmin In = new InicioAdmin();
        In.setVisible(true);
        dispose();
    }// GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(verAvion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(verAvion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(verAvion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(verAvion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new verAvion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTaviones;
    // End of variables declaration//GEN-END:variables
}