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
public class verB extends javax.swing.JFrame {

    /**
     * Creates new form verB
     */
    public verB() {
        initComponents();
        try {
            File archivo = new File("Buses.txt");
            if(archivo.exists()){
                FileInputStream fis = new FileInputStream("Buses.txt");
                ObjectInputStream ois = new ObjectInputStream(fis);
                Bus b2[] = (Bus[]) ois.readObject();
                ois.close();

                JPanel panel = new JPanel(new GridLayout(0, 3, 10, 10));  // GridLayout con 2 columnas
                for (int i = 0; i < b2.length; i++) {
                    final int index=i;
                    JPanel avionPanel = new JPanel();
                    avionPanel.setLayout(new BoxLayout(avionPanel, BoxLayout.Y_AXIS));

                    JLabel origenDest = new JLabel(b2[i].getorigen()+"-"+b2[i].getdestino());
                    JLabel fechas = new JLabel("Salida: "+b2[i].getfechaS());
                    JLabel fechar = new JLabel("Regreso: "+b2[i].getfechaR());
                    JLabel precio=new JLabel("Precio: "+String.valueOf(b2[i].getprecio()));
                    JLabel photoLabel = new JLabel();
                    JLabel habitD=new JLabel("Pasajes Disponibles: "+Integer.toString(b2[i].getpr()));
                    JLabel clase=new JLabel("Clase: "+b2[i].tipoClase());
                    photoLabel.setSize(150, 150);

                    ImageIcon imageIcon = new ImageIcon(b2[i].getFoto());
                    Image image = imageIcon.getImage().getScaledInstance(photoLabel.getWidth(), photoLabel.getHeight(), Image.SCALE_SMOOTH);
                    ImageIcon scaledImageIcon = new ImageIcon(image);

                    photoLabel.setIcon(scaledImageIcon);
                    JButton verDetalleButton = new JButton("Comprar");
                    verDetalleButton.addActionListener(new java.awt.event.ActionListener() {
                        @Override
                        public void actionPerformed(java.awt.event.ActionEvent e) {
                            mostrarDetallesBuses(b2[index],index);
                        }
                    });
                    if(b2[i].getpr()>0){
                        avionPanel.add(origenDest);
                        avionPanel.add(photoLabel);
                        avionPanel.add(fechas);
                        avionPanel.add(fechar);
                        avionPanel.add(precio);
                        avionPanel.add(habitD);
                        avionPanel.add(clase);
                        avionPanel.add(verDetalleButton);

                    panel.add(avionPanel);
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
                JLabel no = new JLabel("Lo sentimos, no tenemos Autobuses disponibles por el momento");
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
    private void mostrarDetallesBuses(Bus bus, int index) {
        JFrame detallesFrame = new JFrame("Detalles del Bus");
        detallesFrame.setSize(420, 350);
        detallesFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel detallesPanel = new JPanel();
        detallesPanel.setLayout(new BoxLayout(detallesPanel, BoxLayout.Y_AXIS));

        JLabel origenDest = new JLabel("Origen: " + bus.getorigen()+" Destino: "+bus.getdestino());
        JLabel photoLabel=new JLabel();
        photoLabel.setSize(150, 150);
        JLabel fsalida = new JLabel("Fecha de salida: " + bus.getfechaS());
        JLabel fregreso = new JLabel("Fecha de Regreso: "+bus.getfechaR());
        ImageIcon imageIcon = new ImageIcon(bus.getFoto());
        Image image = imageIcon.getImage().getScaledInstance(photoLabel.getWidth(), photoLabel.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledImageIcon = new ImageIcon(image);
        photoLabel.setIcon(scaledImageIcon);
        JLabel habitacionesR =new JLabel("Pasajes Restantes: "+bus.getpr());
        JLabel clase=new JLabel("Clase: "+bus.tipoClase());
        JLabel precio=new JLabel("Precio: "+bus.getprecio());
        JButton comprar = new JButton("Comprar");
        SpinnerModel reservas=new SpinnerNumberModel(1,1,bus.getpr(),1);
        JSpinner reservaciones=new JSpinner(reservas);
        
        JComponent editor= reservaciones.getEditor();
        Dimension editorPreferredSize=editor.getPreferredSize();
        editor.setPreferredSize(new Dimension(80, editorPreferredSize.height));
        
        comprar.addActionListener(new java.awt.event.ActionListener() {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            double precio = ((Number) reservaciones.getValue()).doubleValue() * bus.getprecio();
            if(Sesion.getUsuarioActual().obtenerCuenta().mostrarS()>=precio){
                compra compraa=new compra(index,bus.getorigen()+"-"+bus.getdestino(),"bus",(Integer)reservaciones.getValue(),precio,Sesion.getUsuarioActual().obtenerCorreo());
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
                bus.dismPas((Integer)reservaciones.getValue());
                try {
                    FileInputStream fis = new FileInputStream("Buses.txt");
                    ObjectInputStream ois = new ObjectInputStream(fis);
                    Bus bus2[]= (Bus[]) ois.readObject( );
                    ois.close();
                    bus2[index]=bus;
                    FileOutputStream fos = new FileOutputStream("Buses.txt");
                    ObjectOutputStream ous = new ObjectOutputStream(fos);
                    ous.writeObject(bus2);
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
                System.out.println(bus.getpr());
            }else{
                JOptionPane.showMessageDialog(verB.this,"Lo siento, saldo insuficiente"); 
            }
        }
        });

        detallesPanel.add(origenDest);
        detallesPanel.add(photoLabel);
        detallesPanel.add(fsalida);
        detallesPanel.add(fregreso);
        detallesPanel.add(habitacionesR);
        detallesPanel.add(clase);
        detallesPanel.add(precio);
        detallesPanel.add(reservaciones);
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
