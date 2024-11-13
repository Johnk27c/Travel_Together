package Vistas;

import Entidades.Turista;
import Persistencia.TuristaData;

/**
 *
 * @author Gabriel Jara
 */
public class VistaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form VistaPrincipal
     */
    public VistaPrincipal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jDesktopPanel = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu_paquetes = new javax.swing.JMenu();
        jMenuItem_consultasClientes = new javax.swing.JMenuItem();
        jMenuItem_contratarPaquete = new javax.swing.JMenuItem();
        jM_cargaPersonas = new javax.swing.JMenuItem();
        jMenu_ventas = new javax.swing.JMenu();
        jMenuItem_estadisticas = new javax.swing.JMenuItem();
        jMenuItem_personalizado = new javax.swing.JMenuItem();
        jMenu_Salir = new javax.swing.JMenu();

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jDesktopPanelLayout = new javax.swing.GroupLayout(jDesktopPanel);
        jDesktopPanel.setLayout(jDesktopPanelLayout);
        jDesktopPanelLayout.setHorizontalGroup(
            jDesktopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 963, Short.MAX_VALUE)
        );
        jDesktopPanelLayout.setVerticalGroup(
            jDesktopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 706, Short.MAX_VALUE)
        );

        jMenu_paquetes.setText("Paquetes");

        jMenuItem_consultasClientes.setText("Consultas Clientes");
        jMenuItem_consultasClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_consultasClientesActionPerformed(evt);
            }
        });
        jMenu_paquetes.add(jMenuItem_consultasClientes);

        jMenuItem_contratarPaquete.setText("Contratar Paquete");
        jMenuItem_contratarPaquete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_contratarPaqueteActionPerformed(evt);
            }
        });
        jMenu_paquetes.add(jMenuItem_contratarPaquete);

        jM_cargaPersonas.setText("jMenuItem2");
        jM_cargaPersonas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jM_cargaPersonasActionPerformed(evt);
            }
        });
        jMenu_paquetes.add(jM_cargaPersonas);

        jMenuBar1.add(jMenu_paquetes);

        jMenu_ventas.setText("Ventas");

        jMenuItem_estadisticas.setText("Estadisticas");
        jMenuItem_estadisticas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_estadisticasActionPerformed(evt);
            }
        });
        jMenu_ventas.add(jMenuItem_estadisticas);

        jMenuItem_personalizado.setText("Personalizado");
        jMenuItem_personalizado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_personalizadoActionPerformed(evt);
            }
        });
        jMenu_ventas.add(jMenuItem_personalizado);

        jMenuBar1.add(jMenu_ventas);

        jMenu_Salir.setText("Salir");
        jMenu_Salir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu_SalirMouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu_Salir);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPanel, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPanel, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem_contratarPaqueteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_contratarPaqueteActionPerformed
        jDesktopPanel.removeAll();
        jDesktopPanel.repaint();
        VistaContratarPaquete vistaContratarPaquete = new VistaContratarPaquete();
        vistaContratarPaquete.setVisible(true);
        jDesktopPanel.add(vistaContratarPaquete);                                    
    }//GEN-LAST:event_jMenuItem_contratarPaqueteActionPerformed

    private void jMenuItem_consultasClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_consultasClientesActionPerformed
        jDesktopPanel.removeAll();
        jDesktopPanel.repaint();
        VistaConsultaCliente vistaConsultasCliente = new VistaConsultaCliente();
        vistaConsultasCliente.setVisible(true);
        jDesktopPanel.add(vistaConsultasCliente);                                    
    }//GEN-LAST:event_jMenuItem_consultasClientesActionPerformed

    
    private void jMenuItem_estadisticasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_estadisticasActionPerformed
        jDesktopPanel.removeAll();
        jDesktopPanel.repaint();
        VistaEstadisticas vistaEstadisticas = new VistaEstadisticas();
        vistaEstadisticas.setVisible(true);
        jDesktopPanel.add(vistaEstadisticas);
    }//GEN-LAST:event_jMenuItem_estadisticasActionPerformed

    private void jMenu_SalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu_SalirMouseClicked
        this.dispose();
    }//GEN-LAST:event_jMenu_SalirMouseClicked

<<<<<<< Updated upstream
    private void jM_cargaPersonasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jM_cargaPersonasActionPerformed
        jDesktopPanel.removeAll();
        jDesktopPanel.repaint();
    VistaCargaPersonas vistaCargaPersonas = new VistaCargaPersonas();
    vistaCargaPersonas.setVisible(true);
    jDesktopPanel.add(vistaCargaPersonas);

    }//GEN-LAST:event_jM_cargaPersonasActionPerformed
=======
    private void jMenuItem_personalizadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_personalizadoActionPerformed
        jDesktopPanel.removeAll();
        jDesktopPanel.repaint();
        VistaPersonalizado vistaPersonalizado = new VistaPersonalizado();
        vistaPersonalizado.setVisible(true);
        jDesktopPanel.add(vistaPersonalizado);
    }//GEN-LAST:event_jMenuItem_personalizadoActionPerformed
>>>>>>> Stashed changes

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
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaPrincipal().setVisible(true);
            }
        });   
        
//        TuristaData turData = new TuristaData();
//        Turista turista1 = new Turista(37090900, "Jon", "Cuello", 31);
//        Turista turista2 = new Turista(43765347, "Rodrigo", "Guerrero", 23);
//        Turista turista3 = new Turista(46936302, "Herrera", "Franco", 18);
//        Turista turista4 = new Turista(42942099, "Lara", "Santiago", 22);
//        Turista turista5 = new Turista(340075560, "Jara", "Gabriel", 36);
//        
//        turData.guardarTurista(turista1);
//        turData.guardarTurista(turista2);
//        turData.guardarTurista(turista3);
//        turData.guardarTurista(turista4);
//        turData.guardarTurista(turista5);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPanel;
    private javax.swing.JMenuItem jM_cargaPersonas;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem_consultasClientes;
    private javax.swing.JMenuItem jMenuItem_contratarPaquete;
    private javax.swing.JMenuItem jMenuItem_estadisticas;
    private javax.swing.JMenuItem jMenuItem_personalizado;
    private javax.swing.JMenu jMenu_Salir;
    private javax.swing.JMenu jMenu_paquetes;
    private javax.swing.JMenu jMenu_ventas;
    // End of variables declaration//GEN-END:variables
}
