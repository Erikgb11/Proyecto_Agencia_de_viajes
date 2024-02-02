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
import java.awt.*;
import agencia_viajes.*;
public class verbus extends javax.swing.JFrame {

    /**
     * Creates new form verbus
     */
    public verbus() {
        initComponents();
        try {
            File archivo = new File("Buses.txt");
            if(archivo.exists()){
                FileInputStream fis = new FileInputStream("B_H.txt");
                ObjectInputStream ois = new ObjectInputStream(fis);
                Bus_Hotel bh2[] = (Bus_Hotel[]) ois.readObject();
                ois.close();

                JPanel panel = new JPanel(new GridLayout(0, 3, 10, 10));  // GridLayout con 2 columnas
                for (int i = 0; i < bh2.length; i++) {
                    final int index=i;
                    JPanel busHPanel = new JPanel();
                    busHPanel.setLayout(new BoxLayout(busHPanel, BoxLayout.Y_AXIS));

                    JLabel origenDest = new JLabel(bh2[i].Mostrarviaje().getorigen()+"-"+bh2[i].Mostrarviaje().getdestino());
                    JLabel fechas = new JLabel("Salida: "+bh2[i].Mostrarviaje().getfechaS());
                    JLabel fechar = new JLabel("Regreso: "+bh2[i].Mostrarviaje().getfechaR());
                    JLabel precio=new JLabel("Precio: "+String.valueOf(bh2[i].Mostrarviaje().getprecio()));
                    JLabel photoLabel = new JLabel();
                    JLabel habitD=new JLabel("Pasajes Disponibles: "+Integer.toString(bh2[i].Mostrarviaje().getpr()));
                    JLabel clase=new JLabel("Clase: "+bh2[i].Mostrarviaje().tipoClase());
                    JLabel aerolinea=new JLabel("Compañia: "+bh2[i].Mostrarviaje().comp());       
                    photoLabel.setSize(150, 150);

                    ImageIcon imageIcon = new ImageIcon(bh2[i].Mostrarviaje().getFoto());
                    Image image = imageIcon.getImage().getScaledInstance(photoLabel.getWidth(), photoLabel.getHeight(), Image.SCALE_SMOOTH);
                    ImageIcon scaledImageIcon = new ImageIcon(image);

                    photoLabel.setIcon(scaledImageIcon);

                    JLabel nameLabel = new JLabel(bh2[i].mostarh().getnombre());
                    JLabel localizacion = new JLabel(bh2[i].mostarh().getlocalizacion());
                    JLabel precio2=new JLabel("Precio: "+String.valueOf(bh2[i].mostarh().getpreNo()));
                    JLabel photoLabel2 = new JLabel();
                    JLabel habitD2=new JLabel("Habitaciones Disponibles: "+Integer.toString(bh2[i].mostarh().gethabitacionesR()));
                    photoLabel2.setSize(150, 150);

                    ImageIcon imageIcon2 = new ImageIcon(bh2[i].mostarh().getfoto());
                    Image image2 = imageIcon2.getImage().getScaledInstance(photoLabel2.getWidth(), photoLabel2.getHeight(), Image.SCALE_SMOOTH);
                    ImageIcon scaledImageIcon2 = new ImageIcon(image2);

                    photoLabel2.setIcon(scaledImageIcon2);


                    JButton verDetalleButton = new JButton("Comprar");
                    verDetalleButton.addActionListener(new java.awt.event.ActionListener() {
                        @Override
                        public void actionPerformed(java.awt.event.ActionEvent e) {
                            mostrarDetallesBH(bh2[index],index);
                        }
                    });
                    if(bh2[i].Mostrarviaje().getpr()>0){
                        busHPanel.add(origenDest);
                        busHPanel.add(photoLabel);
                        busHPanel.add(fechas);
                        busHPanel.add(fechar);
                        busHPanel.add(precio);
                        busHPanel.add(habitD);
                        busHPanel.add(clase);
                        busHPanel.add(aerolinea);

                        busHPanel.add(nameLabel);
                        busHPanel.add(photoLabel2);
                        busHPanel.add(localizacion);
                        busHPanel.add(precio2);
                        busHPanel.add(habitD2);
                        busHPanel.add(verDetalleButton);


                    panel.add(busHPanel);
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
                JLabel no = new JLabel("Lo sentimos, aun no tenemos paquetes Autobuses/Hotel disponibles");
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
    private void mostrarDetallesBH(Bus_Hotel bh, int index) {
        JFrame detallesFrame = new JFrame("Detalles del Vuelo/Autobus");
        detallesFrame.setSize(1000, 350);
        detallesFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel detallesPanel = new JPanel();
        detallesPanel.setLayout(new BoxLayout(detallesPanel, BoxLayout.Y_AXIS));

        JLabel origenDest = new JLabel("Origen: " + bh.Mostrarviaje().getorigen()+" Destino: "+bh.Mostrarviaje().getdestino());
        JLabel photoLabel=new JLabel();
        photoLabel.setSize(150, 150);
        JLabel fsalida = new JLabel("Fecha de salida: " + bh.Mostrarviaje().getfechaS());
        JLabel fregreso = new JLabel("Fecha de Regreso: "+bh.Mostrarviaje().getfechaR());
        ImageIcon imageIcon = new ImageIcon(bh.Mostrarviaje().getFoto());
        Image image = imageIcon.getImage().getScaledInstance(photoLabel.getWidth(), photoLabel.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledImageIcon = new ImageIcon(image);
        photoLabel.setIcon(scaledImageIcon);
        JLabel habitacionesR =new JLabel("Pasajes Restantes: "+bh.Mostrarviaje().getpr());
        JLabel clase=new JLabel("Clase: "+bh.Mostrarviaje().tipoClase());
        SpinnerModel reservas=new SpinnerNumberModel(1,1,bh.Mostrarviaje().getpr(),1);
        JSpinner reservaciones=new JSpinner(reservas);
        
        JLabel nameLabel = new JLabel("Nombre: " + bh.mostarh().getnombre());
        JLabel photoLabel2=new JLabel();
        photoLabel2.setSize(150, 150);
        JLabel localizacionLabel = new JLabel("Localización: " + bh.mostarh().getlocalizacion());
        ImageIcon imageIcon2 = new ImageIcon(bh.mostarh().getfoto());
        Image image2 = imageIcon2.getImage().getScaledInstance(photoLabel2.getWidth(), photoLabel2.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledImageIcon2 = new ImageIcon(image2);
        photoLabel2.setIcon(scaledImageIcon2);
        JLabel habitacionesR2 =new JLabel("Habitaciones Restantes: "+bh.mostarh().gethabitacionesR());
        JLabel puntuacion=new JLabel("Puntación: "+bh.mostarh().getpuntuacion());
        JLabel precio2=new JLabel("Precio: "+bh.mostarh().getpreNo());
        JButton comprar = new JButton("Comprar");
        
        JComponent editor= reservaciones.getEditor();
        Dimension editorPreferredSize=editor.getPreferredSize();
        editor.setPreferredSize(new Dimension(80, editorPreferredSize.height));
        
        comprar.addActionListener(new java.awt.event.ActionListener() {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            double precio = ((Number) reservaciones.getValue()).doubleValue() * bh.Mostrarviaje().getprecio();
            if(Sesion.getUsuarioActual().obtenerCuenta().mostrarS()>=precio){
                compra compraa=new compra(index,bh.Mostrarviaje().getorigen()+"-"+bh.Mostrarviaje().getdestino()+"/"+bh.mostarh().getnombre(),"bh",(Integer)reservaciones.getValue(),precio,Sesion.getUsuarioActual().obtenerCorreo());
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
                bh.Mostrarviaje().dismPas((Integer)reservaciones.getValue());
                bh.mostarh().Reser((Integer)reservaciones.getValue());
                try {
                    FileInputStream fis = new FileInputStream("B_H.txt");
                    ObjectInputStream ois = new ObjectInputStream(fis);
                    Bus_Hotel bh2[]= (Bus_Hotel[]) ois.readObject( );
                    ois.close();
                    bh2[index]=bh;
                    FileOutputStream fos = new FileOutputStream("B_H.txt");
                    ObjectOutputStream ous = new ObjectOutputStream(fos);
                    ous.writeObject(bh2);
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
                System.out.println(bh.Mostrarviaje().getpr()+bh.mostarh().gethabitacionesR());
            }
            else{
                JOptionPane.showMessageDialog(verbus.this,"Lo siento, saldo insuficiente"); 
            }
        }
        });

        detallesPanel.add(origenDest);
        detallesPanel.add(photoLabel);
        detallesPanel.add(fsalida);
        detallesPanel.add(fregreso);
        detallesPanel.add(habitacionesR);
        detallesPanel.add(clase);
        detallesPanel.add(reservaciones);
        detallesPanel.add(nameLabel);
        detallesPanel.add(photoLabel2);
        detallesPanel.add(localizacionLabel);
        detallesPanel.add(habitacionesR2);
        detallesPanel.add(puntuacion);
        detallesPanel.add(precio2);
        
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