/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package forms;

import generic.iconBarraProgreso;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * Formulario para el control de la configuracion de sesion
 * @version 1.0
 * @author Ing. Javier Alarcon
 */
public class frmConfig_VerificarDatos extends javax.swing.JDialog {

    /*---------------------------------------------------*/
    /*---               Constructores                 ---*/
    /*---------------------------------------------------*/
    /**
     * Constructor estandar de la clase jDialog
     * @param parent
     * @param modal 
     */
    public frmConfig_VerificarDatos(java.awt.Frame parent, boolean modal) {
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
     * @param configControl 
     */
    public frmConfig_VerificarDatos(java.awt.Frame parent, boolean modal, Properties configControl) {
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
        this.configControl = configControl;
        this.iconos = new iconBarraProgreso();
        inicializar();
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
        jlblValoresDefect = new javax.swing.JLabel();
        jlblUsuarionew = new javax.swing.JLabel();
        jlblClaveold = new javax.swing.JLabel();
        jpassClaveold = new javax.swing.JPasswordField();
        jtxtUsuarionew = new javax.swing.JTextField();
        jlblClavenew = new javax.swing.JLabel();
        jpassClavenew = new javax.swing.JPasswordField();
        jlblUsuarioold = new javax.swing.JLabel();
        jtxtUsuarioold = new javax.swing.JTextField();
        jlblRepClave = new javax.swing.JLabel();
        jpassRepClave = new javax.swing.JPasswordField();
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

        jpanelInformacion.setBorder(javax.swing.BorderFactory.createTitledBorder("Configuración Administrador"));
        jpanelInformacion.setFocusable(false);

        jlblValoresDefect.setFont(new java.awt.Font("Dialog", 1, 8)); // NOI18N
        jlblValoresDefect.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recurso/Iconos/user_48.png"))); // NOI18N
        jlblValoresDefect.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlblValoresDefectMouseClicked(evt);
            }
        });

        jlblUsuarionew.setText("Usuario nuevo");

        jlblClaveold.setText("Clave vieja");

        jpassClaveold.setToolTipText("<HTML>\n<BODY>\nClave viaja para la cambiar la configuración del sistema<br/>\n</BODY>\n</HTML>");

        jtxtUsuarionew.setToolTipText("<HTML>\n<BODY>\nUsuario nuevo para la cambiar la configuración del sistema<br/>\n</BODY>\n</HTML>");

        jlblClavenew.setText("Clave nueva");

        jpassClavenew.setToolTipText("<HTML>\n<BODY>\nClave nueva para la cambiar la configuración del sistema<br/>\n</BODY>\n</HTML>");

        jlblUsuarioold.setText("Usuario viejo");

        jtxtUsuarioold.setToolTipText("<HTML>\n<BODY>\nUsuario viejo para cambio de configuración<br/>\n</BODY>\n</HTML>");

        jlblRepClave.setText("Repetir clave");
        jlblRepClave.setToolTipText("<HTML>\n<BODY>\nRepetir clave nueva para la cambiar la configuración del sistema<br/>\n</BODY>\n</HTML>");

        org.jdesktop.layout.GroupLayout jpanelInformacionLayout = new org.jdesktop.layout.GroupLayout(jpanelInformacion);
        jpanelInformacion.setLayout(jpanelInformacionLayout);
        jpanelInformacionLayout.setHorizontalGroup(
            jpanelInformacionLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jpanelInformacionLayout.createSequentialGroup()
                .addContainerGap()
                .add(jpanelInformacionLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jlblUsuarionew)
                    .add(jlblClaveold)
                    .add(jlblClavenew)
                    .add(jlblRepClave)
                    .add(jlblUsuarioold))
                .add(19, 19, 19)
                .add(jpanelInformacionLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jpassClavenew)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jpanelInformacionLayout.createSequentialGroup()
                        .add(jpanelInformacionLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, jtxtUsuarionew, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, jtxtUsuarioold))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jlblValoresDefect))
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jpassClaveold)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jpassRepClave))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpanelInformacionLayout.setVerticalGroup(
            jpanelInformacionLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jpanelInformacionLayout.createSequentialGroup()
                .addContainerGap()
                .add(jpanelInformacionLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jpanelInformacionLayout.createSequentialGroup()
                        .add(jpanelInformacionLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jtxtUsuarioold, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jlblUsuarioold))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(jpanelInformacionLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jtxtUsuarionew, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jlblUsuarionew)))
                    .add(jlblValoresDefect, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 52, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jpanelInformacionLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jlblClaveold)
                    .add(jpassClaveold, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jpanelInformacionLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jlblClavenew)
                    .add(jpassClavenew, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jpanelInformacionLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jlblRepClave)
                    .add(jpassRepClave, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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
                .addContainerGap()
                .add(jcmdGuardar)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jcmdCancelar)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jcmdSalir, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpanelBotonesLayout.setVerticalGroup(
            jpanelBotonesLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jpanelBotonesLayout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jpanelBotonesLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jcmdCancelar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 34, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jcmdGuardar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 34, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
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
                .add(jtbarNotificacion, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 356, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jtbarInfo, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jpanelBotones, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(layout.createSequentialGroup()
                        .add(47, 47, 47)
                        .add(jpanelInformacion, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(jpanelInformacion, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jpanelBotones, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jtbarNotificacion, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 25, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jtbarInfo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 25, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Restaurar valores por defecto para la verificacion de datos (login)
     * @param evt 
     */
    private void jlblValoresDefectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblValoresDefectMouseClicked
        //  Condicion
        if (evt.getButton() == evt.BUTTON3 && evt.isShiftDown() && 
                evt.isControlDown() && evt.isAltDown() && evt.getClickCount() == 3) {
            frmConfig_login vntLogin = new frmConfig_login(null, true, "SUPER", this.configControl);
            vntLogin.setVisible(true);
            if (vntLogin.isOk()){
                //  Proceso
                try {
                    //  Proceso - Usuario
                    this.configControl.setProperty("usu_cntr",this.configControl.
                        getProperty("usu_cntr_def").trim());
                    //  Proceso - Clave
                    this.configControl.setProperty("clv_cntr",this.configControl.
                        getProperty("clv_cntr_def").trim());
                    //  Incializar pantalla
                    jcmdCancelarActionPerformed(null);
                    //  Mensaje del sistema
                    this.jlblNotificacion.setIcon(iconos.getSuccessImage());
                    this.jlblNotificacion.setText("Restaurado Exitosamente!");
                    this.setOk(false);
                } catch (Exception ex) {
                    this.jlblNotificacion.setIcon(iconos.getErrorImage());
                    this.jlblNotificacion.setText("Error no se pudo restaurar la informacion!");
                    Logger.getLogger(frmConfig_VerificarDatos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_jlblValoresDefectMouseClicked

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
     * Guardar datos de configuracion para la verificacion de datos (login)
     * @param evt 
     */
    private void jcmdGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcmdGuardarActionPerformed
        //  Variables
        String valclv = "", valusu = "";
        
        //  Proceso
        try {
            valusu = this.configControl.getProperty("usu_cntr").trim();
            valclv = this.configControl.getProperty("clv_cntr").trim();
            if (valusu.equals(this.jtxtUsuarioold.getText().trim()) && 
                    valclv.equals(this.jpassClaveold.getText().trim())) {
                if (this.jpassClavenew.getText().trim().equals(
                        this.jpassRepClave.getText().trim())) {
                    this.configControl.setProperty("usu_cntr", 
                            this.jtxtUsuarionew.getText().trim());
                    this.configControl.setProperty("clv_cntr", 
                            this.jpassClavenew.getText().trim());
                    //  Mensaje del Sistema
                    this.jlblNotificacion.setIcon(iconos.getSuccessImage());
                    this.jlblNotificacion.setText("Guardado Exitosamente!");
                    this.setOk(true);
                } else {
                    this.jlblNotificacion.setIcon(iconos.getWarningImage());
                    this.jlblNotificacion.setText("Error en la verificacion de la clave!");
                }
            } else {
                this.jlblNotificacion.setIcon(iconos.getWarningImage());
                this.jlblNotificacion.setText("Error Usuario/Clave incorrecto!");
            }
        } catch (Exception ex) {
            this.jlblNotificacion.setIcon(iconos.getErrorImage());
            this.jlblNotificacion.setText("Error no se pudo guardar la informacion!");
            Logger.getLogger(frmConfig_VerificarDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jcmdGuardarActionPerformed

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
     * Cancelar el proceso de configuracion para la verificacion de datos (login)
     * @param evt 
     */
    private void jcmdCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcmdCancelarActionPerformed
        //  Proceso
        this.jtxtUsuarioold.setText("");
        this.jtxtUsuarionew.setText("");
        this.jpassClaveold.setText("");
        this.jpassClavenew.setText("");
        this.jpassRepClave.setText("");
    }//GEN-LAST:event_jcmdCancelarActionPerformed

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
     * Salir del formulario actual
     * @param evt 
     */
    private void jcmdSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcmdSalirActionPerformed
        //  Proceso
        this.setVisible(false);
    }//GEN-LAST:event_jcmdSalirActionPerformed

    /**
     * Restaurar progressBar Notificacion
     * @param evt 
     */
    private void jlblNotificacionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblNotificacionMouseExited
        //  Proceso
        this.jlblNotificacion.setText("         ");
        this.jlblNotificacion.setIcon(null);
    }//GEN-LAST:event_jlblNotificacionMouseExited

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jcmdCancelar;
    private javax.swing.JButton jcmdGuardar;
    private javax.swing.JButton jcmdSalir;
    private javax.swing.JLabel jlblClavenew;
    private javax.swing.JLabel jlblClaveold;
    private javax.swing.JLabel jlblInfo;
    private javax.swing.JLabel jlblLogoTunal;
    private javax.swing.JLabel jlblNotificacion;
    private javax.swing.JLabel jlblRepClave;
    private javax.swing.JLabel jlblUsuarionew;
    private javax.swing.JLabel jlblUsuarioold;
    private javax.swing.JLabel jlblValoresDefect;
    private javax.swing.JPanel jpanelBotones;
    private javax.swing.JPanel jpanelInformacion;
    private javax.swing.JPasswordField jpassClavenew;
    private javax.swing.JPasswordField jpassClaveold;
    private javax.swing.JPasswordField jpassRepClave;
    private javax.swing.JToolBar.Separator jsprMargen;
    private javax.swing.JToolBar.Separator jsprMargen1;
    private javax.swing.JToolBar jtbarInfo;
    private javax.swing.JToolBar jtbarNotificacion;
    private javax.swing.JTextField jtxtUsuarionew;
    private javax.swing.JTextField jtxtUsuarioold;
    // End of variables declaration//GEN-END:variables
    
    /*---------------------------------------------------*/
    /*---                  Atributos                  ---*/
    /*---------------------------------------------------*/
    private Properties configControl;
    private iconBarraProgreso iconos;
    private boolean ok;

    /*---------------------------------------------------*/
    /*---             Metodos Set y Get               ---*/
    /*---------------------------------------------------*/
    /**
     * Retorna el archivo properties de config de control
     * @return configControl
     */
    public Properties getConfigControl() {
        return configControl;
    }

    /**
     * Asignar el archivo properties de config de Control
     * @param configControl
     */
    public void setConfigControl(Properties configControl) {
        this.configControl = configControl;
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
        
        //  Proceso
        try {
            this.setOk(false);
            jcmdCancelarActionPerformed(null);
        } catch (Exception ex) {
            Logger.getLogger(frmConfig_VerificarDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
