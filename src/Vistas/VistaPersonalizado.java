/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vistas;

import Entidades.Alojamiento;
import Entidades.Ciudad;
import Entidades.Estadia;
import Entidades.Paquete;
import Entidades.Pension;
import Persistencia.AlojamientoData;
import Persistencia.PensionData;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jon_kevin27
 */
public class VistaPersonalizado extends javax.swing.JInternalFrame {

    ArrayList<Alojamiento> alojamientos = new ArrayList();
    ArrayList<String> pensiones = new ArrayList();
    private HashSet<Pension> listarPensiones = new HashSet();
    private PensionData accesoPension = new PensionData();
    private DefaultTableModel modelo = new DefaultTableModel();
    private Paquete paqueteActual;
    private String origenActual;
    private VistaContratarPaquete vistaContratar;
    private VistaConsultaCliente vistaConsulta;
    private AlojamientoData accesoAlojamiento = new AlojamientoData();

    /**
     * Creates new form VistaPersonalizado
     */
    public VistaPersonalizado(Paquete paquete, String origenVista, VistaContratarPaquete vistaContratar, VistaConsultaCliente vistaConsulta) {
        initComponents();
        this.paqueteActual = paquete;
        this.origenActual = origenVista;
        modelo = new DefaultTableModel();
        cargarCbxAlojamientos();// carga los tipos de alojamientos
        cargarCbxPension();// carga las pensiones
        cargarCbxTransporte();// carga los transportes
        armarCabecera();
        jCbx_alojamientos.setSelectedIndex(-1);
        jCbx_transporte.setSelectedIndex(-1);
        jCbx_pension.setSelectedIndex(-1);
        this.vistaContratar = vistaContratar;
        this.vistaConsulta = vistaConsulta;
        cargarAlojamientosDestino();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jCbx_alojamientos = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_alojamientos = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jCbx_pension = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jRbt_si = new javax.swing.JRadioButton();
        jRbt_no = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jCbx_transporte = new javax.swing.JComboBox<>();
        btn_confirmar = new javax.swing.JButton();

        setClosable(true);

        jLabel1.setText("Tipo de alojamiento:");

        jCbx_alojamientos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCbx_alojamientosActionPerformed(evt);
            }
        });

        jLabel2.setText("ALOJAMIENTOS DISPONIBLES");

        jTable_alojamientos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable_alojamientos);

        jLabel3.setText("Pensión:");

        jLabel4.setText("Traslado:");

        jRbt_si.setText("SI");
        jRbt_si.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRbt_siActionPerformed(evt);
            }
        });

        jRbt_no.setText("NO");
        jRbt_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRbt_noActionPerformed(evt);
            }
        });

        jLabel5.setText("Transporte:");

        btn_confirmar.setText("Confirmar preferencias");
        btn_confirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_confirmarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jLabel1)
                                .addGap(47, 47, 47)
                                .addComponent(jCbx_alojamientos, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(153, 153, 153)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(97, 97, 97)
                        .addComponent(jRbt_si)
                        .addGap(54, 54, 54)
                        .addComponent(jRbt_no))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addGap(51, 51, 51)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCbx_transporte, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCbx_pension, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(14, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_confirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(168, 168, 168))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jCbx_alojamientos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jCbx_pension, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jRbt_si)
                    .addComponent(jRbt_no))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jCbx_transporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(btn_confirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRbt_siActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRbt_siActionPerformed
        jRbt_no.setSelected(false);
    }//GEN-LAST:event_jRbt_siActionPerformed

    private void jRbt_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRbt_noActionPerformed
        jRbt_si.setSelected(false);
    }//GEN-LAST:event_jRbt_noActionPerformed

    private void btn_confirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_confirmarActionPerformed
        if (opcionesSeleccionadasOK()) {
            //Setea transporte y precio de boleto
            paqueteActual.getBoleto().setTransporte((String) jCbx_transporte.getSelectedItem());
            switch ((String) jCbx_transporte.getSelectedItem()) {
                case "Avión - PRIMERA  CLASE":
                    paqueteActual.getBoleto().setPrecio(150000);
                    break;
                case "Avión - CLASE MEDIA":
                    paqueteActual.getBoleto().setPrecio(100000);
                    break;
                case "Colectivo - EJECUTIVO":
                    paqueteActual.getBoleto().setPrecio(60000);
                    break;
                default:
                    paqueteActual.getBoleto().setPrecio(35000);
                    break;
            }
            //Setea pension
            paqueteActual.setRegimen((Pension) jCbx_pension.getSelectedItem());
            //Setea traslados
            if (jRbt_si.isSelected()) {
                paqueteActual.setPrecioTraslados(0.01);
            } else {
                paqueteActual.setPrecioTraslados(0);
            }
            //Setea Estadia
            int codAlojamiento = (int) modelo.getValueAt(jTable_alojamientos.getSelectedRow(), 0);
            System.out.println("Codigo alojamiento "+codAlojamiento);
            Alojamiento alojamientoElegido = accesoAlojamiento.buscarAlojamientoPorId(codAlojamiento);
            System.out.println(alojamientoElegido);
            double precioNoche = alojamientoElegido.getPrecioNoche();
            Estadia nuevaEstadia = new Estadia();
            paqueteActual.setEstadia(nuevaEstadia);
            paqueteActual.getEstadia().setAlojamiento(alojamientoElegido);
           //Calculo de días para total de estadía
            long difDiasMilSeg = pasarADate(paqueteActual.getFechaIni()).getTime() - pasarADate(paqueteActual.getFechaFin()).getTime();
            long diasEstadia = TimeUnit.DAYS.convert(difDiasMilSeg, TimeUnit.MILLISECONDS);
            paqueteActual.getEstadia().setMonto(diasEstadia*precioNoche);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Debe seleccionar todas las opciones");
        }
        if(origenActual=="Contratar"){
        vistaContratar.cargarDatosPaqueteActual();            
        }
        this.dispose();
    }//GEN-LAST:event_btn_confirmarActionPerformed

    private void jCbx_alojamientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCbx_alojamientosActionPerformed
        if (jCbx_alojamientos.getSelectedItem() != null) {
            borrarfilaTabla();
            ArrayList<Alojamiento> lista = filtrarAlojamientosPorTipo((String) jCbx_alojamientos.getSelectedItem());
            for (Alojamiento alojamiento : lista) {
                modelo.addRow(new Object[]{alojamiento.getCodAlojam(), alojamiento.getNombreAlojamiento(), alojamiento.getDireccion(), alojamiento.getCapacidad(), alojamiento.getHabitaciones(), alojamiento.getBanios(), alojamiento.getPrecioNoche()});
            }
        }
    }//GEN-LAST:event_jCbx_alojamientosActionPerformed

    private void armarCabecera() {
        ArrayList<Object> filaCabecera = new ArrayList<>();
        filaCabecera.add("Cod. Alojamiento");
        filaCabecera.add("Nombre");
        filaCabecera.add("Dirección");
        filaCabecera.add("Capacidad");
        filaCabecera.add("Habitaciones");
        filaCabecera.add("Baños");
        filaCabecera.add("Precio");
        for (Object it : filaCabecera) {
            modelo.addColumn(it);
        }
        jTable_alojamientos.setModel(modelo);
    }

    private void borrarfilaTabla() {
        int indice = modelo.getRowCount() - 1;

        for (int i = indice; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }

    public void cargarCbxAlojamientos() {
        ArrayList<String> tipodealojamiento = new ArrayList();
        String[] tiposdealojamientos = {"Cabaña", "Posada", "Hotel"};
        for (String elemento : tiposdealojamientos) {
            jCbx_alojamientos.addItem(elemento);
        }
    }

    public void cargarCbxPension() {
        HashSet<Pension> listaPensionespornombre = accesoPension.listarPensiones();
        jCbx_pension.removeAllItems();
        for (Pension nombre : listaPensionespornombre) {
            jCbx_pension.addItem(nombre);
        }
        listarPensiones = listaPensionespornombre;
    }

    public void cargarCbxTransporte() {
        ArrayList<String> transporte = new ArrayList();
        String[] transportes = {"Avión - PRIMERA  CLASE", "Avión - CLASE MEDIA", "Colectivo - EJECUTIVO", "Colectivo - SEMICAMA"};
        for (String elemento : transportes) {
            jCbx_transporte.addItem(elemento);
        }
    }

    public void cargarAlojamientosDestino() {
        Ciudad origen = paqueteActual.getBoleto().getCiudadDestino();
        this.alojamientos = accesoAlojamiento.buscarAlojamientPorCiudad(origen.getCodCiudad());
        for (Alojamiento alojamiento : alojamientos) {
            modelo.addRow(new Object[]{alojamiento.getCodAlojam(), alojamiento.getNombreAlojamiento(), alojamiento.getDireccion(), alojamiento.getCapacidad(), alojamiento.getHabitaciones(), alojamiento.getBanios(), alojamiento.getPrecioNoche()});
        }
    }

    public ArrayList<Alojamiento> filtrarAlojamientosPorTipo(String tipo) {
        ArrayList<Alojamiento> listaNueva = new ArrayList();
        if (jCbx_alojamientos.getSelectedItem() != null) {
            for (Alojamiento alojamiento : alojamientos) {
                if (alojamiento.getTipo().equals(tipo)) {
                    listaNueva.add(alojamiento);
                }
            }
        }
        return listaNueva;
    }

    private boolean opcionesSeleccionadasOK() {
        return jTable_alojamientos.getSelectedRow() != -1 && jCbx_pension.getSelectedItem() != null && (jRbt_si.isSelected() || jRbt_no.isSelected() && jCbx_transporte.getSelectedItem() != null);
    }
    private Date pasarADate(LocalDate fechaLocal) {
        Date fecha = Date.from(fechaLocal.atStartOfDay(ZoneId.systemDefault()).toInstant());
        return fecha;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_confirmar;
    private javax.swing.JComboBox<String> jCbx_alojamientos;
    private javax.swing.JComboBox<Pension> jCbx_pension;
    private javax.swing.JComboBox<String> jCbx_transporte;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRbt_no;
    private javax.swing.JRadioButton jRbt_si;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_alojamientos;
    // End of variables declaration//GEN-END:variables
}
