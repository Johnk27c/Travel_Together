
package Vistas;

import Entidades.Paquete;
import Persistencia.Conexion;
import Persistencia.PaqueteData;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;

/**
 *
 * @author Santiago Lara
 */
public class VistaEstadisticas extends javax.swing.JInternalFrame {
    private Connection conexion = null;
    private DefaultTableModel tabla = new DefaultTableModel();
    private DefaultTableModel tabla2 = new DefaultTableModel();
    private PaqueteData accesoPaquete = new PaqueteData();
    
    public VistaEstadisticas() {
        initComponents();
        conexion = Conexion.getConexion();
        tabla = new DefaultTableModel();
        armarCabeceraPaquetes();
        armarCabeceraFiltro();
        cargarTabla();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_paquetes = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        botonMes = new javax.swing.JRadioButton();
        botonTemporada = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_Filtrado = new javax.swing.JTable();
        botonSalir = new javax.swing.JButton();

        setClosable(true);

        jLabel1.setText("Paquetes comprados últimos 2 meses");

        jTable_paquetes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable_paquetes);

        jLabel2.setText("Buscar por:");

        botonMes.setText("Mes");
        botonMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMesActionPerformed(evt);
            }
        });

        botonTemporada.setText("Temporada");
        botonTemporada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonTemporadaActionPerformed(evt);
            }
        });

        jLabel3.setText("Mes Inicio:");

        jLabel4.setText("Mes Fin:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jTable_Filtrado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable_Filtrado);

        botonSalir.setText("Salir");
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonMes)
                        .addGap(18, 18, 18)
                        .addComponent(botonTemporada)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(botonSalir)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(botonMes)
                    .addComponent(botonTemporada))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonSalir)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonMesActionPerformed

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_botonSalirActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void botonTemporadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonTemporadaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonTemporadaActionPerformed

    private void armarCabeceraPaquetes() {
        ArrayList<Object> cabecera = new ArrayList<>();
        cabecera.add("codPaq");
        cabecera.add("Nombre");
        cabecera.add("Destino");
        cabecera.add("Tipo");
        cabecera.add("Fecha In");
        cabecera.add("Fecha Fin");
        for (Object i : cabecera) {
            tabla.addColumn(i);
        }
        jTable_paquetes.setModel(tabla);
    }

    
    private void armarCabeceraFiltro() {
        ArrayList<Object> cabecera = new ArrayList<>();
        cabecera.add("Destino");
        cabecera.add("Cantidad Paquetes");
        for (Object i : cabecera) {
            tabla2.addColumn(i);
        }
        jTable_Filtrado.setModel(tabla2);
    }

    
    private void cargarTabla(){
        LocalDate fechaLimite = LocalDate.now().minusMonths(2);
        ArrayList<Paquete> lista = accesoPaquete.buscarPaqueteDesde(fechaLimite);
        System.out.println(lista);
        borrarfilaTabla();
        for (Paquete paquete : lista) {
            tabla.addRow(new Object []{
            paquete.getCodPaquete(), paquete.getTurista().getNombre()+" "+paquete.getTurista().getApellido(), paquete.getBoleto().getCiudadDestino().getNombre(),paquete.getTipo(), paquete.getFechaIni(), paquete.getFechaFin()
            });
        }

    }
    
     private void borrarfilaTabla() {
        
        int indice = tabla.getRowCount() - 1;

        for (int i = indice; i >= 0; i--) {
            tabla.removeRow(i);
        }
     }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton botonMes;
    private javax.swing.JButton botonSalir;
    private javax.swing.JRadioButton botonTemporada;
    private javax.swing.JComboBox<String> jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable_Filtrado;
    private javax.swing.JTable jTable_paquetes;
    // End of variables declaration//GEN-END:variables
}
