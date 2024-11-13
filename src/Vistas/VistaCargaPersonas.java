/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vistas;

import Entidades.Turista;
import Persistencia.TuristaData;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class VistaCargaPersonas extends javax.swing.JInternalFrame {

    private TuristaData turistaD = new TuristaData();
    private Turista turistaActual = null;
    private HashSet<Turista> listaTuristas = new HashSet();
    private DefaultTableModel modelo = new DefaultTableModel();

    /**
     * Creates new form VistaCargaPersonas
     */
    public VistaCargaPersonas() {
        initComponents();
        armarCabecera();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jT_nombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jT_apellido = new javax.swing.JTextField();
        jT_dni = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jB_buscar = new javax.swing.JButton();
        jB_agregar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTB_turistas = new javax.swing.JTable();
        jB_finalizar = new javax.swing.JButton();
        jD_fechaNacimiento = new com.toedter.calendar.JDateChooser();

        jLabel1.setText("Nombre :");

        jLabel2.setText("Apellido");

        jLabel3.setText("DNI");

        jLabel4.setText("Fecha de nacimiento");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Cargar Personas");

        jB_buscar.setText("Buscar");
        jB_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_buscarActionPerformed(evt);
            }
        });

        jB_agregar.setText("Agregar");
        jB_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_agregarActionPerformed(evt);
            }
        });

        jTB_turistas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "DNI", "Nombre", "Apellido", "Edad"
            }
        ));
        jScrollPane2.setViewportView(jTB_turistas);

        jB_finalizar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jB_finalizar.setText("Finalizar Compra");
        jB_finalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_finalizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jT_dni, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jB_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jT_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jT_apellido, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(58, 58, 58)
                        .addComponent(jD_fechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jB_finalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jB_agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jT_dni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jB_buscar))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jT_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jT_apellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(62, 62, 62))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jD_fechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jB_agregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jB_finalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jB_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_agregarActionPerformed
        try {
            int dni = Integer.valueOf(jT_dni.getText());
            String nombre = jT_nombre.getText();
            String apellido = jT_apellido.getText();

            if (nombre.isEmpty() || apellido.isEmpty() || jD_fechaNacimiento.getDate() == null) {
                JOptionPane.showMessageDialog(this, "No deben haber campos vacios");
                return;
            }
            for (Turista t : listaTuristas) {
                if (t.getDni() == dni) {
                    JOptionPane.showMessageDialog(this, "El DNI ingresado ya existe");
                    return;
                }
            }
            LocalDate fechaNac = jD_fechaNacimiento.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            Turista nuevoTurista = new Turista(dni, nombre, apellido, fechaNac);
            listaTuristas.add(nuevoTurista);
            cargarTabla();
            limpiarCampos();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Debe Ingresar un DNI valido");

        }
    }//GEN-LAST:event_jB_agregarActionPerformed

    private void jB_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_buscarActionPerformed
        try {
            int dni = Integer.valueOf(jT_dni.getText());
            turistaActual = turistaD.buscarTuristaPorDNI(dni);
            if (turistaActual != null) {
                jT_nombre.setText(turistaActual.getNombre());
                jT_apellido.setText(turistaActual.getApellido());
                LocalDate lc = turistaActual.getFechaNac();
                java.util.Date date = java.util.Date.from(lc.atStartOfDay(ZoneId.systemDefault()).toInstant());
                jD_fechaNacimiento.setDate(date);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Debe ingresar un DNI valido");
        }

    }//GEN-LAST:event_jB_buscarActionPerformed

    private void jB_finalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_finalizarActionPerformed
        if (listaTuristas.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe agregar turistas para finalizar su compra");
            return;
        }
        for (Turista t : listaTuristas) {
            turistaD.guardarTurista(t);
        }
        JOptionPane.showMessageDialog(this, "Solo pueden darse de baja 30 dias antes y modificaciones 10 dias antes de la fecha de inicio");
        listaTuristas.clear();
        limpiarCampos();
        cargarTabla();
    }//GEN-LAST:event_jB_finalizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jB_agregar;
    private javax.swing.JButton jB_buscar;
    private javax.swing.JButton jB_finalizar;
    private com.toedter.calendar.JDateChooser jD_fechaNacimiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTB_turistas;
    private javax.swing.JTextField jT_apellido;
    private javax.swing.JTextField jT_dni;
    private javax.swing.JTextField jT_nombre;
    // End of variables declaration//GEN-END:variables
    private void armarCabecera() {
        modelo.addColumn("DNI");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Edad");
        jTB_turistas.setModel(modelo);
    }

    private void limpiarCampos() {
        jT_dni.setText("");
        jT_nombre.setText("");
        jT_apellido.setText("");
        jD_fechaNacimiento.setDate(null);
    }

    private void cargarTabla() {
        modelo.setRowCount(0);
        for (Turista t : listaTuristas) {
            modelo.addRow(new Object[]{t.getDni(), t.getNombre(), t.getApellido(), t.calcularEdad()});
        }
    }
}
