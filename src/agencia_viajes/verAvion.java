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
public class verAvion extends javax.swing.JFrame {

    /**
     * Creates new form verAvion
     */
    public verAvion() {
        initComponents();
        try {
            File archivo = new File("Vuelos.txt");
            if(archivo.exists()){
                FileInputStream fis = new FileInputStream("Vuelos.txt");
                ObjectInputStream ois = new ObjectInputStream(fis);
                Avion a2[] = (Avion[]) ois.readObject();
                ois.close();

                JPanel panel = new JPanel(new GridLayout(0, 3, 10, 10));  // GridLayout con 2 columnas
                for (int i = 0; i < a2.length; i++) {
                final int index=i;
                JPanel avionPanel = new JPanel();
                avionPanel.setLayout(new BoxLayout(avionPanel, BoxLayout.Y_AXIS));
                JLabel origenDest = new JLabel(a2[i].getorigen()+"-"+a2[i].getdestino());
                JLabel fechas = new JLabel("Salida: "+a2[i].getfechaS());
                JLabel fechar = new JLabel("Regreso: "+a2[i].getfechaR());
                JLabel precio=new JLabel("Precio: "+String.valueOf(a2[i].getprecio()));
                JLabel photoLabel = new JLabel();
                JLabel habitD=new JLabel("Pasajes Disponibles: "+Integer.toString(a2[i].getpr()));
                JLabel clase=new JLabel("Clase: "+a2[i].tipoClase());
                JLabel aerolinea=new JLabel("Aerolinea: "+a2[i].aerolin());       
                photoLabel.setSize(150, 150);

                ImageIcon imageIcon = new ImageIcon(a2[i].getFoto());
                Image image = imageIcon.getImage().getScaledInstance(photoLabel.getWidth(), photoLabel.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon scaledImageIcon = new ImageIcon(image);

                photoLabel.setIcon(scaledImageIcon);
                JButton verDetalleButton = new JButton("Comprar");
                verDetalleButton.addActionListener(new java.awt.event.ActionListener() {
                    @Override
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        mostrarDetallesAvion(a2[index],index);
                    }
                });
                if(a2[i].getpr()>0){
                    avionPanel.add(origenDest);
                    avionPanel.add(photoLabel);
                    avionPanel.add(fechas);
                    avionPanel.add(fechar);
                    avionPanel.add(precio);
                    avionPanel.add(habitD);
                    avionPanel.add(clase);
                    avionPanel.add(aerolinea);
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
                JLabel no = new JLabel("Lo sentimos, no tenemos Vuelos disponibles por el momento");
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
    private void mostrarDetallesAvion(Avion avion, int index) {
        JFrame detallesFrame = new JFrame("Detalles del Hotel");
        detallesFrame.setSize(380, 350);
        detallesFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel detallesPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        
        detallesPanel.setLayout(new BoxLayout(detallesPanel, BoxLayout.Y_AXIS));

        JLabel origenDest = new JLabel("Origen: " + avion.getorigen()+" Destino: "+avion.getdestino());
        JLabel photoLabel=new JLabel();
        photoLabel.setSize(150, 150);
        JLabel fsalida = new JLabel("Fecha de salida: " + avion.getfechaS());
        JLabel fregreso = new JLabel("Fecha de Regreso: "+avion.getfechaR());
        ImageIcon imageIcon = new ImageIcon(avion.getFoto());
        Image image = imageIcon.getImage().getScaledInstance(photoLabel.getWidth(), photoLabel.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledImageIcon = new ImageIcon(image);
        photoLabel.setIcon(scaledImageIcon);
        JLabel habitacionesR =new JLabel("Pasajes Restantes: "+avion.getpr());
        JLabel clase=new JLabel("Clase: "+avion.tipoClase());
        JLabel precio=new JLabel("Precio: "+avion.getprecio());
        JLabel aerolinea=new JLabel("Aerolinea: "+avion.aerolin());
        JButton comprar = new JButton("Comprar");
        SpinnerModel reservas=new SpinnerNumberModel(1,1,avion.getpr(),1);
        JSpinner reservaciones=new JSpinner(reservas);
        
        comprar.addActionListener(new java.awt.event.ActionListener() {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            double precio = ((Number) reservaciones.getValue()).doubleValue() * avion.getprecio();
            if(Sesion.getUsuarioActual().obtenerCuenta().mostrarS()>=precio){
                compra compraa=new compra(index,avion.getorigen()+"-"+avion.getdestino(),"avion",(Integer)reservaciones.getValue(),precio,Sesion.getUsuarioActual().obtenerCorreo());
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
                avion.dismPas((Integer)reservaciones.getValue());
                try {
                    FileInputStream fis = new FileInputStream("Vuelos.txt");
                    ObjectInputStream ois = new ObjectInputStream(fis);
                    Avion avion2[]= (Avion[]) ois.readObject( );
                    ois.close();
                    avion2[index]=avion;
                    FileOutputStream fos = new FileOutputStream("Vuelos.txt");
                    ObjectOutputStream ous = new ObjectOutputStream(fos);
                    ous.writeObject(avion2);
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
                System.out.println(avion.getpr());
            }else{
                JOptionPane.showMessageDialog(verAvion.this,"Lo siento, saldo insuficiente"); 
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
        detallesPanel.add(aerolinea);
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
