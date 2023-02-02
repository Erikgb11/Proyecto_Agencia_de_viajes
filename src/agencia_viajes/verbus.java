/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agencia_viajes;

/**
 *
 * @author HP
 */
import java.io.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class verbus extends javax.swing.JFrame {

    /**
     * Creates new form verbus
     */
    public verbus() {
        initComponents();
        jTbuses.setDefaultRenderer(Object.class,new ImgTabla());
        String titulos[]={"indice","Destino","Tipo transporte","Origen","Salida","Regreso","Pasaje","Precio","Clase","Nombre","Localizacion","Puntuacion"};
        DefaultTableModel tm =new DefaultTableModel(null,titulos){public boolean isCellEditable(int row,int column){
            return false;
        }};
        try{
            FileInputStream fis = new FileInputStream("B_H.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Bus_Hotel h2[]= (Bus_Hotel[]) ois.readObject( );
            ois.close();
            for(int i=0;i<h2.length;i++){
                tm.addRow(new Object[]{String.valueOf(i),h2[i].Mostrarviaje().getdestino(),h2[i].Mostrarviaje().gettipotra(),h2[i].Mostrarviaje().getorigen(),h2[i].Mostrarviaje().getfechaS(),h2[i].Mostrarviaje().getfechaR(),String.valueOf(h2[i].Mostrarviaje().getpas()),String.valueOf(h2[i].getprecio()),h2[i].Mostrarviaje().tipoClase(),
                h2[i].mostarh().getnombre(),h2[i].mostarh().getlocalizacion(),String.valueOf(h2[i].mostarh().getpuntuacion()),String.valueOf(h2[i].mostarh().getpreNo())});
                jTbuses.setRowHeight(50);
            }
            
        }catch(Exception e) { e.printStackTrace(); }
        jTbuses.setModel(tm);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTbuses = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTbuses.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTbuses);

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 711, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(125, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        System.exit(0);
        try{
            FileInputStream fis = new FileInputStream("Clientes.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Cliente clientes2[]= (Cliente[]) ois.readObject();
            ois.close();
            int el=0,c=0;
            for(int i=0; i<clientes2.length; i++){
                if(clientes2[i].getactivo()==1){
                    c=i;
                }
            }
            clientes2[c].editaract();
            FileOutputStream fs = new FileOutputStream("Clientes.txt");
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(clientes2);
            os.close();
        } catch(Exception e) { e.printStackTrace(); }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Inicio In=new Inicio();
        In.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(verbus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(verbus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(verbus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(verbus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new verbus().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTbuses;
    // End of variables declaration//GEN-END:variables
}
