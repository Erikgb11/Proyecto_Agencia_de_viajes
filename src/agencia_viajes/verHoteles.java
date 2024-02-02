/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agencia_viajes;

import java.io.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import agencia_viajes.*;

/**
 *
 * @author HP
 */
public class verHoteles extends javax.swing.JFrame {

    public verHoteles() {
        initComponents();
        try {
            File archivo = new File("Hoteles.txt");
            if(archivo.exists()){
                FileInputStream fis = new FileInputStream("Hoteles.txt");
                ObjectInputStream ois = new ObjectInputStream(fis);
                Hotel h2[] = (Hotel[]) ois.readObject();
                ois.close();

                JPanel panel = new JPanel(new GridLayout(0, 3, 10, 10));  // GridLayout con 2 columnas
                for (int i = 0; i < h2.length; i++) {
                    final int index=i;
                    JPanel hotelPanel = new JPanel();
                    hotelPanel.setLayout(new BoxLayout(hotelPanel, BoxLayout.Y_AXIS));

                    JLabel nameLabel = new JLabel(h2[i].getnombre());
                    JLabel localizacion = new JLabel(h2[i].getlocalizacion());
                    JLabel precio=new JLabel("Precio: "+String.valueOf(h2[i].getpreNo()));
                    JLabel photoLabel = new JLabel();
                    JLabel habitD=new JLabel("Habitaciones Disponibles: "+Integer.toString(h2[i].gethabitacionesR()));
                    photoLabel.setSize(150, 150);

                    ImageIcon imageIcon = new ImageIcon(h2[i].getfoto());
                    Image image = imageIcon.getImage().getScaledInstance(photoLabel.getWidth(), photoLabel.getHeight(), Image.SCALE_SMOOTH);
                    ImageIcon scaledImageIcon = new ImageIcon(image);

                    photoLabel.setIcon(scaledImageIcon);
                    JButton verDetalleButton = new JButton("Comprar");
                    verDetalleButton.addActionListener(new java.awt.event.ActionListener() {
                        @Override
                        public void actionPerformed(java.awt.event.ActionEvent e) {
                            mostrarDetallesHotel(h2[index],index);
                        }
                    });
                    if(h2[i].gethabitacionesR()>0){
                        hotelPanel.add(nameLabel);
                        hotelPanel.add(photoLabel);
                        hotelPanel.add(localizacion);
                        hotelPanel.add(precio);
                        hotelPanel.add(habitD);
                        hotelPanel.add(verDetalleButton);

                    panel.add(hotelPanel);
                    }

                }

                JScrollPane scrollPane = new JScrollPane(panel);
                GroupLayout layout = new GroupLayout(getContentPane());
                getContentPane().setLayout(layout);

                layout.setHorizontalGroup(
                        layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jButton1)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 697, Short.MAX_VALUE)
                                        .addComponent(jButton3)
                                        .addContainerGap())
                );

                layout.setVerticalGroup(
                        layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(jButton3)
                                                .addComponent(jButton1))
                                        .addContainerGap())
                );
            }else{
                JPanel panel = new JPanel(new GridLayout(0, 1, 10, 10));
                JPanel avionPanel = new JPanel();
                avionPanel.setLayout(new BoxLayout(avionPanel, BoxLayout.Y_AXIS));
                JLabel no = new JLabel("Lo sentimos, aun no tenemos Hoteles disponibles");
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
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 697, Short.MAX_VALUE)
                                .addComponent(jButton3)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(333, 333, 333)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton3)
                                        .addComponent(jButton1))
                                .addContainerGap())
        );

        pack();
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
        Sesion.cerrarSesion();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        Inicio In = new Inicio();
        In.setVisible(true);
        dispose();
    }
    private void mostrarDetallesHotel(Hotel hotel, int index) {
        JFrame detallesFrame = new JFrame("Detalles del Hotel");
        detallesFrame.setSize(380, 350);
        detallesFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel detallesPanel = new JPanel();
        detallesPanel.setLayout(new BoxLayout(detallesPanel, BoxLayout.Y_AXIS));

        JLabel nameLabel = new JLabel("Nombre: " + hotel.getnombre());
        JLabel photoLabel=new JLabel();
        photoLabel.setSize(150, 150);
        JLabel localizacionLabel = new JLabel("Localización: " + hotel.getlocalizacion());
        ImageIcon imageIcon = new ImageIcon(hotel.getfoto());
        Image image = imageIcon.getImage().getScaledInstance(photoLabel.getWidth(), photoLabel.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledImageIcon = new ImageIcon(image);
        photoLabel.setIcon(scaledImageIcon);
        JLabel habitacionesR =new JLabel("Habitaciones Restantes: "+hotel.gethabitacionesR());
        JLabel puntuacion=new JLabel("Puntación: "+hotel.getpuntuacion());
        JLabel precio=new JLabel("Precio: "+hotel.getpreNo());
        JButton comprar = new JButton("Comprar");
        SpinnerModel reservas=new SpinnerNumberModel(1,1,hotel.gethabitacionesR(),1);
        JSpinner reservaciones=new JSpinner(reservas);
        
        JComponent editor= reservaciones.getEditor();
        Dimension editorPreferredSize=editor.getPreferredSize();
        editor.setPreferredSize(new Dimension(80, editorPreferredSize.height));
        
        comprar.addActionListener(new java.awt.event.ActionListener() {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            double precio = ((Number) reservaciones.getValue()).doubleValue() * hotel.getpreNo();
            if(Sesion.getUsuarioActual().obtenerCuenta().mostrarS()>=precio){
                compra compraa=new compra(index,hotel.getnombre(),"hotel",(Integer)reservaciones.getValue(),precio,Sesion.getUsuarioActual().obtenerCorreo());
                System.out.println(compraa);
                compra compras[]={compraa};
                try {
                    File archivo = new File("Compras.txt");
                    if (!archivo.exists()) {
                        try {
                            FileOutputStream fs = new FileOutputStream("Compras.txt");
                            ObjectOutputStream os = new ObjectOutputStream(fs);
                            os.writeObject(compras);
                            os.close();
                        }  catch(Exception ex) { ex.printStackTrace(); }
                    }else{
                        FileInputStream fis = new FileInputStream("Compras.txt");
                        ObjectInputStream ois = new ObjectInputStream(fis);
                        compra compras2[]= (compra[]) ois.readObject( );
                        ois.close();
                        try {
                            compra[] compras3 = new compra[compras2.length+1];
                            for(int i=0; i<compras2.length; i++){
                                compras3[i]=compras2[i];
                            }
                            compras3[compras2.length]=compraa;
                            for(int i=0; i<compras3.length; i++){
                                System.out.println(compras3[i]);
                            }
                            FileOutputStream fs = new FileOutputStream("Compras.txt");
                            ObjectOutputStream os = new ObjectOutputStream(fs);
                            os.writeObject(compras3);
                            os.close();
                        } catch(Exception ex) { ex.printStackTrace(); }
                    }
                } catch(Exception ex) { ex.printStackTrace(); }
                hotel.Reser((Integer)reservaciones.getValue());
                try {
                    FileInputStream fis = new FileInputStream("Hoteles.txt");
                    ObjectInputStream ois = new ObjectInputStream(fis);
                    Hotel hotel2[]= (Hotel[]) ois.readObject( );
                    ois.close();
                    hotel2[index]=hotel;
                    FileOutputStream fos = new FileOutputStream("Hoteles.txt");
                    ObjectOutputStream ous = new ObjectOutputStream(fos);
                    ous.writeObject(hotel2);
                    ous.close();
                    } catch(Exception ex) { ex.printStackTrace(); }
                Sesion.getUsuarioActual().obtenerCuenta().disD(precio);
                try {
                    FileInputStream fis = new FileInputStream("Clientes.txt");
                    ObjectInputStream ois = new ObjectInputStream(fis);
                    Cliente cliente2[]= (Cliente[]) ois.readObject( );
                    ois.close();
                    for(int i=0;i<cliente2.length;i++){
                        if(Sesion.getUsuarioActual().obtenerCorreo().equals(cliente2[i].obtenerCorreo())){
                            cliente2[i]=Sesion.getUsuarioActual();
                        }
                    }
                    FileOutputStream fos = new FileOutputStream("Clientes.txt");
                    ObjectOutputStream ous = new ObjectOutputStream(fos);
                    ous.writeObject(cliente2);
                    ous.close();
                    
                    } catch(Exception ex) { ex.printStackTrace(); }
                System.out.println(hotel.gethabitacionesR());
            }else{
                JOptionPane.showMessageDialog(verHoteles.this,"Lo siento, saldo insuficiente"); 
            }
        }
        });

        detallesPanel.add(nameLabel);
        detallesPanel.add(photoLabel);
        detallesPanel.add(localizacionLabel);
        detallesPanel.add(habitacionesR);
        detallesPanel.add(puntuacion);
        detallesPanel.add(reservaciones);
        detallesPanel.add(precio);
        detallesPanel.add(comprar);
        detallesFrame.add(detallesPanel);
        detallesFrame.setVisible(true);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new verHoteles().setVisible(true);
            }
        });
    }

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
}
