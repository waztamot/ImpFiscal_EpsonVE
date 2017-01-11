/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package forms;

import generic.OracleConection;
import generic.iconBarraProgreso;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * Formulario para el control de la configuracion Imp. Fiscal
 * @version 1.0
 * @author Ing. Javier Alarcon
 */
public class frmConfig_Compania extends javax.swing.JDialog {

    /*---------------------------------------------------*/
    /*---               Constructores                 ---*/
    /*---------------------------------------------------*/
    /**
     * Constructor estandar de la clase jDialog
     * @param parent
     * @param modal
     */
    public frmConfig_Compania(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        try {
            JFrame.setDefaultLookAndFeelDecorated(true);
            JDialog.setDefaultLookAndFeelDecorated(true);
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e){
            e.printStackTrace();
        }
        initComponents();
        this.setLocationRelativeTo(null);
        this.iconos = new iconBarraProgreso();
        inicializar();
    }
    
    /**
     * Constructor modificado con archivo de config de la clase jDialog
     * @param parent
     * @param modal
     * @param configGral
     */
    public frmConfig_Compania(java.awt.Frame parent, boolean modal, Properties configGral) {
        super(parent, modal);
        try {
            JFrame.setDefaultLookAndFeelDecorated(true);
            JDialog.setDefaultLookAndFeelDecorated(true);
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e){
            e.printStackTrace();
        }
        initComponents();
        this.setLocationRelativeTo(null);
        this.configGral = configGral;
        this.iconos = new iconBarraProgreso();
        inicializar();
    }

    /**
     * Colocar imagen del titulo de la pantalla
     * @return 
     */
    public Image getIconImage(){
        Image retValue;
        retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("recurso/Iconos/tunal_icon.png"));

        return retValue;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpanelInformacion = new javax.swing.JPanel();
        jlblUnidadOperativa = new javax.swing.JLabel();
        jtxtUnidadOperativa = new javax.swing.JTextField();
        jcmbbUnidOperativa = new javax.swing.JComboBox();
        jlblSerieDoc = new javax.swing.JLabel();
        jcmbbSerieDoc = new javax.swing.JComboBox();
        jcmbbCodigoUnidOpe = new javax.swing.JComboBox();
        jpanelBotones = new javax.swing.JPanel();
        jcmdGuardar = new javax.swing.JButton();
        jcmdCancelar = new javax.swing.JButton();
        jcmdSalir = new javax.swing.JButton();
        jtbarNotificacion = new javax.swing.JToolBar();
        jsprMargen = new javax.swing.JToolBar.Separator();
        jlblLogoTunal = new javax.swing.JLabel();
        jsprMargen1 = new javax.swing.JToolBar.Separator();
        jlblNotificacion = new javax.swing.JLabel();
        jtbarInfo = new javax.swing.JToolBar();
        jlblInfo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Impresora Fiscal Epson VE - El Tunal C.A.");
        setModal(true);
        setResizable(false);

        jpanelInformacion.setBorder(javax.swing.BorderFactory.createTitledBorder("Configuración Compañia"));
        jpanelInformacion.setFocusable(false);

        jlblUnidadOperativa.setText("Unidad. Operativa");
        jlblUnidadOperativa.setFocusable(false);

        jtxtUnidadOperativa.setEditable(false);
        jtxtUnidadOperativa.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtxtUnidadOperativa.setToolTipText("<HTML>\n<BODY>\nCodigo de la Empresa\n</BODY>\n</HTML>");
        jtxtUnidadOperativa.setMinimumSize(new java.awt.Dimension(4, 26));
        jtxtUnidadOperativa.setPreferredSize(new java.awt.Dimension(18, 26));

        jcmbbUnidOperativa.setToolTipText("<HTML>\n<BODY>\nEmpresa donde son generadas las facturas<br/>\n<B>Por ejemplo </B> AutoPartes Zona Libre C.A.\n</BODY>\n</HTML>");
        jcmbbUnidOperativa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcmbbUnidOperativaActionPerformed(evt);
            }
        });

        jlblSerieDoc.setText("Serie de los Doc. Fiscales");
        jlblSerieDoc.setFocusable(false);

        jcmbbSerieDoc.setEditable(true);
        jcmbbSerieDoc.setToolTipText("<HTML>\n<BODY>\nSerie de los documentos fiscales<br/>\n<B>Por ejemplo</B> 0\n</BODY>\n</HTML>");

        jcmbbCodigoUnidOpe.setToolTipText("");
        jcmbbCodigoUnidOpe.setFocusable(false);

        org.jdesktop.layout.GroupLayout jpanelInformacionLayout = new org.jdesktop.layout.GroupLayout(jpanelInformacion);
        jpanelInformacion.setLayout(jpanelInformacionLayout);
        jpanelInformacionLayout.setHorizontalGroup(
            jpanelInformacionLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jpanelInformacionLayout.createSequentialGroup()
                .addContainerGap()
                .add(jpanelInformacionLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jpanelInformacionLayout.createSequentialGroup()
                        .add(jlblUnidadOperativa)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jcmbbCodigoUnidOpe, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jlblSerieDoc))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jpanelInformacionLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jpanelInformacionLayout.createSequentialGroup()
                        .add(jtxtUnidadOperativa, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 30, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jcmbbUnidOperativa, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 186, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jcmbbSerieDoc, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 222, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jpanelInformacionLayout.setVerticalGroup(
            jpanelInformacionLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jpanelInformacionLayout.createSequentialGroup()
                .addContainerGap()
                .add(jpanelInformacionLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jlblUnidadOperativa)
                    .add(jcmbbUnidOperativa, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jtxtUnidadOperativa, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jcmbbCodigoUnidOpe, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jpanelInformacionLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jlblSerieDoc)
                    .add(jcmbbSerieDoc, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jcmbbCodigoUnidOpe.setVisible(false);

        jpanelBotones.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jpanelBotones.setFocusable(false);

        jcmdGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recurso/Iconos/KnobBlue_Guardar32.png"))); // NOI18N
        jcmdGuardar.setMnemonic('G');
        jcmdGuardar.setText("Guardar");
        jcmdGuardar.setToolTipText("Guardar modificaciones en la BD");
        jcmdGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jcmdGuardarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jcmdGuardarMouseExited(evt);
            }
        });
        jcmdGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcmdGuardarActionPerformed(evt);
            }
        });

        jcmdCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recurso/Iconos/Knob_Cancel32.png"))); // NOI18N
        jcmdCancelar.setMnemonic('C');
        jcmdCancelar.setText("Cancelar");
        jcmdCancelar.setToolTipText("Cancelar el proceso");
        jcmdCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jcmdCancelarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jcmdCancelarMouseExited(evt);
            }
        });
        jcmdCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcmdCancelarActionPerformed(evt);
            }
        });

        jcmdSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recurso/Iconos/Knob_LoopOn32.png"))); // NOI18N
        jcmdSalir.setMnemonic('S');
        jcmdSalir.setText("Salir");
        jcmdSalir.setToolTipText("Cerrar pantalla");
        jcmdSalir.setMaximumSize(new java.awt.Dimension(116, 42));
        jcmdSalir.setMinimumSize(new java.awt.Dimension(116, 42));
        jcmdSalir.setPreferredSize(new java.awt.Dimension(116, 42));
        jcmdSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jcmdSalirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jcmdSalirMouseExited(evt);
            }
        });
        jcmdSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcmdSalirActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jpanelBotonesLayout = new org.jdesktop.layout.GroupLayout(jpanelBotones);
        jpanelBotones.setLayout(jpanelBotonesLayout);
        jpanelBotonesLayout.setHorizontalGroup(
            jpanelBotonesLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jpanelBotonesLayout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jcmdGuardar)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jcmdCancelar)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jcmdSalir, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jpanelBotonesLayout.linkSize(new java.awt.Component[] {jcmdCancelar, jcmdGuardar, jcmdSalir}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        jpanelBotonesLayout.setVerticalGroup(
            jpanelBotonesLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jpanelBotonesLayout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jpanelBotonesLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jcmdCancelar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jcmdGuardar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 34, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jcmdSalir, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        jtbarNotificacion.setFloatable(false);
        jtbarNotificacion.setRollover(true);
        jtbarNotificacion.setFocusable(false);
        jtbarNotificacion.setName(""); // NOI18N
        jtbarNotificacion.add(jsprMargen);

        jlblLogoTunal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recurso/Iconos/tunal_icon.png"))); // NOI18N
        jlblLogoTunal.setFocusable(false);
        jtbarNotificacion.add(jlblLogoTunal);

        jsprMargen1.setSeparatorSize(new java.awt.Dimension(20, 10));
        jtbarNotificacion.add(jsprMargen1);

        jlblNotificacion.setText("                 ");
        jlblNotificacion.setFocusable(false);
        jlblNotificacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlblNotificacionMouseExited(evt);
            }
        });
        jtbarNotificacion.add(jlblNotificacion);

        jtbarInfo.setFloatable(false);
        jtbarInfo.setRollover(true);
        jtbarInfo.setFocusable(false);

        jlblInfo.setText("                ");
        jlblInfo.setToolTipText("");
        jlblInfo.setFocusable(false);
        jtbarInfo.add(jlblInfo);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jpanelInformacion, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .add(layout.createSequentialGroup()
                .add(jtbarNotificacion, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 367, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jtbarInfo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 64, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(0, 0, Short.MAX_VALUE))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jpanelBotones, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jpanelInformacion, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jpanelBotones, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jtbarNotificacion, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 25, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jtbarInfo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 25, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Cancelar el proceso de configuracion ConfigCompania
     * @param evt 
     */
    private void jcmdCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcmdCancelarActionPerformed
        // Variables
        String value = "";
        
        //  Proceso
        jlblNotificacionMouseExited(null);
        
        //  Proceso - Unidad Operativa
        value = this.configGral.getProperty("db_empresa").trim();
        this.jcmbbCodigoUnidOpe.setSelectedItem(value.trim());
        this.jcmbbUnidOperativa.setSelectedIndex(this.jcmbbCodigoUnidOpe
                .getSelectedIndex());
        this.jtxtUnidadOperativa.setText(value.trim());
        value = "";
        
        //  Proceso - Serie del Doc. Fiscal
        value = this.configGral.getProperty("db_empresa_serie").trim();
        this.jcmbbSerieDoc.setSelectedItem(value.trim());
    }//GEN-LAST:event_jcmdCancelarActionPerformed

    /**
     * Guardar datos de configuracion ConfigCompania
     * @param evt 
     */
    private void jcmdGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcmdGuardarActionPerformed
        //  Variables
        String value = "";
        
        //  Proceso
        jlblNotificacionMouseExited(null);
        
        //  Proceso - Guardar
        try {
            //  Proceso - Unidad Operativa
            value = this.jtxtUnidadOperativa.getText().trim();
            this.configGral.setProperty("db_empresa", value.trim());
            value = "";
            
            //  Proceso - Serie de los Doc. Fiscales
            value = this.jcmbbSerieDoc.getSelectedItem().toString().trim();
            this.configGral.setProperty("db_empresa_serie", value.trim());
            
            //  Mensaje del sistema
            this.jlblNotificacion.setIcon(iconos.getSuccessImage());
            this.jlblNotificacion.setText("Guardado Exitosamente!");
            this.setOk(true);
        } catch (Exception ex) {
            this.jlblNotificacion.setIcon(iconos.getErrorImage());
            this.jlblNotificacion.setText("Error no se pudo guardar la informacion!");
            Logger.getLogger(frmConfig_Compania.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jcmdGuardarActionPerformed

    /**
     * Salir del formulario actual
     * @param evt 
     */
    private void jcmdSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcmdSalirActionPerformed
        //  Proceso
        this.setVisible(false);
    }//GEN-LAST:event_jcmdSalirActionPerformed

    /**
     * Colocar combinacion de teclas para opcion "Guardar" en progressBar Info
     * @param evt 
     */
    private void jcmdGuardarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcmdGuardarMouseEntered
        //  Proceso
        this.jlblInfo.setText("Alt + G");
    }//GEN-LAST:event_jcmdGuardarMouseEntered

    /**
     * Restaurar progressBar Info
     * @param evt 
     */
    private void jcmdGuardarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcmdGuardarMouseExited
        //  Proceso
        this.jlblInfo.setText("         ");
    }//GEN-LAST:event_jcmdGuardarMouseExited

    /**
     * Colocar combinacion de teclas para opcion "Cancelar" en progressBar Info
     * @param evt 
     */
    private void jcmdCancelarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcmdCancelarMouseEntered
        //  Proceso
        this.jlblInfo.setText("Alt + C");
    }//GEN-LAST:event_jcmdCancelarMouseEntered

    /**
     * Restaurar progressBar Info
     * @param evt 
     */
    private void jcmdCancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcmdCancelarMouseExited
        //  Proceso
        this.jlblInfo.setText("         ");
    }//GEN-LAST:event_jcmdCancelarMouseExited

    /**
     * Colocar combinacion de teclas para opcion "Salir" en progressBar Info
     * @param evt 
     */
    private void jcmdSalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcmdSalirMouseEntered
        //  Proceso
        this.jlblInfo.setText("Alt + S");
    }//GEN-LAST:event_jcmdSalirMouseEntered

    /**
     * Restaurar progressBar Info
     * @param evt 
     */
    private void jcmdSalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcmdSalirMouseExited
        //  Proceso
        this.jlblInfo.setText("         ");
    }//GEN-LAST:event_jcmdSalirMouseExited

    /**
     * Restaurar progressBar Notificacion
     * @param evt 
     */
    private void jlblNotificacionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblNotificacionMouseExited
        //  Proceso
        this.jlblNotificacion.setText("         ");
        this.jlblNotificacion.setIcon(null);
    }//GEN-LAST:event_jlblNotificacionMouseExited

    /**
     * Seleccionar Unidad Operativa
     * @param evt 
     */
    private void jcmbbUnidOperativaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcmbbUnidOperativaActionPerformed
        //  Variable
        List<String> item = new ArrayList();
        String cad;
        
        //  Proceso
        cad = this.jcmbbUnidOperativa.getSelectedItem().toString().trim();
        item.clear();
        item.addAll(Arrays.asList(cad.split("]")));
        if (!item.isEmpty()) {
            this.jtxtUnidadOperativa.setText(item.get(0).trim().substring(1));
        }
    }//GEN-LAST:event_jcmbbUnidOperativaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox jcmbbCodigoUnidOpe;
    private javax.swing.JComboBox jcmbbSerieDoc;
    private javax.swing.JComboBox jcmbbUnidOperativa;
    private javax.swing.JButton jcmdCancelar;
    private javax.swing.JButton jcmdGuardar;
    private javax.swing.JButton jcmdSalir;
    private javax.swing.JLabel jlblInfo;
    private javax.swing.JLabel jlblLogoTunal;
    private javax.swing.JLabel jlblNotificacion;
    private javax.swing.JLabel jlblSerieDoc;
    private javax.swing.JLabel jlblUnidadOperativa;
    private javax.swing.JPanel jpanelBotones;
    private javax.swing.JPanel jpanelInformacion;
    private javax.swing.JToolBar.Separator jsprMargen;
    private javax.swing.JToolBar.Separator jsprMargen1;
    private javax.swing.JToolBar jtbarInfo;
    private javax.swing.JToolBar jtbarNotificacion;
    private javax.swing.JTextField jtxtUnidadOperativa;
    // End of variables declaration//GEN-END:variables

    /*---------------------------------------------------*/
    /*---                  Atributos                  ---*/
    /*---------------------------------------------------*/
    private Properties configGral;
    private iconBarraProgreso iconos;
    private boolean ok;

    /*---------------------------------------------------*/
    /*---             Metodos Set y Get               ---*/
    /*---------------------------------------------------*/
    /**
     * Retorna el archivo properties de config configGral
     * @return configGral
     */
    public Properties getConfigGral() {
        return configGral;
    }

    /**
     * Asignar el archivo properties de config configGral
     * @param configGral
     */
    public void setConfigGral(Properties configGral) {
        this.configGral = configGral;
    }

    /**
     * Retorna si fueron guardados los cambios al archivo de configuracion
     * @return ok
     */
    public boolean isOk() {
        return ok;
    }

    /**
     * Asigna si fueron guardados los cambios al archivo de configuracion
     * @param ok 
     */
    private void setOk(boolean ok) {
        this.ok = ok;
    }
    
    /*---------------------------------------------------*/
    /*---             Metodos especificos             ---*/
    /*---------------------------------------------------*/
    /**
     * Inicializar valores del formulario segun archivo
     * de configuracion
     */
    public final void inicializar(){
        
        //  Variables
        List<String> listaCompania, itemCompania = new ArrayList();
        String value;
        OracleConection oc;
        
        //  Proceso
        this.setOk(false);
        
        //  Proceso - Serie de los documentos
        try {
            value = this.configGral.getProperty("db_serie_posible").trim();
            for (char item : value.toCharArray()){
                this.jcmbbSerieDoc.addItem(item);
            }
            value = this.configGral.getProperty("db_empresa_serie").trim();
            this.jcmbbSerieDoc.setSelectedItem(value.trim());
        } catch (Exception ex) {
            Logger.getLogger(frmConfig_Compania.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //  Proceso - Unidad Operativa
        try {
            value = this.configGral.getProperty("db_empresa").trim();
            this.jtxtUnidadOperativa.setText(value.trim());
            oc = new OracleConection(this.configGral);
            oc.Conectar();
            if (oc.isConnOk()){
                value = this.configGral.getProperty("db_empresa_posible").trim();
                listaCompania = oc.busqueda("Select uoci_uoci,uoci_descri "
                                                + "from ge_tuocia "
                                                + "where uoci_cias in ("
                                                + value.trim()
                                                + ")", 3);
                if (listaCompania != null) {
                    this.jcmbbCodigoUnidOpe.removeAllItems();
                    this.jcmbbUnidOperativa.removeAllItems();
                    for (String cadCompania : listaCompania) {
                        itemCompania.clear();
                        itemCompania.addAll(Arrays.asList(cadCompania.split("-;-")));
                        if (!itemCompania.isEmpty()){
                            this.jcmbbUnidOperativa.addItem("[" + itemCompania
                                    .get(0).trim() + "] - " + itemCompania.
                                            get(1).trim());
                            this.jcmbbCodigoUnidOpe.addItem(itemCompania
                                    .get(0).trim());
                        }
                    }
                }
                value = this.configGral.getProperty("db_empresa").trim();
                this.jtxtUnidadOperativa.setText(value.trim());
                this.jcmbbCodigoUnidOpe.setSelectedItem(jtxtUnidadOperativa
                        .getText().trim());
                this.jcmbbUnidOperativa.setSelectedIndex(this.jcmbbCodigoUnidOpe
                        .getSelectedIndex());
            }
            oc.Desconectar();
        } catch (Exception ex) {
            Logger.getLogger(frmConfig_Compania.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
