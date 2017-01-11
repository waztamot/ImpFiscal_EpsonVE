/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package forms;

import IFDrivers.PnpDriverFiscal;
import generic.OracleConection;
import generic.appConfiguracion;
import generic.iconBarraProgreso;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import progTareaImpFiscal.ProgramadorTarea;

/**
 * Formulario para el control de impresion de la impresora fiscal
 * @version 1.0
 * @author Ing. Javier Alarcon
 */
public class frmPrincipal extends javax.swing.JFrame {

    /*---------------------------------------------------*/
    /*---               Constructores                 ---*/
    /*---------------------------------------------------*/
    /**
     * Constructor estandar de la clase jFrame
     * @see frmPrincipal
     */
    @SuppressWarnings({"BroadCatchBlock", "TooBroadCatch"})
    public frmPrincipal() {
        try {
            JFrame.setDefaultLookAndFeelDecorated(true);
            JDialog.setDefaultLookAndFeelDecorated(true);
            /**
             *          Posibles visualizaciones estandar de Java 
             * UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());  //  S.O
             * UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"); //  Nimbus
             * UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");  //  Metal
             * UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel"); //  Windows
             * UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");  //  Windows Classic
             * UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel"); //  GTK
             * UIManager.setLookAndFeel("com.apple.laf.AquaLookAndFeel");    //  Mac OS X
             * UIManager.setLookAndFeel("com.sun.java.swing.plaf.mac.MacLookAndFeel");   //  Mac OS
             * UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");   //  Java Classic
             */
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        }catch (Exception e){
            e.printStackTrace();
        }
        initComponents();
        this.setLocationRelativeTo(null);
        this.iconos = new iconBarraProgreso();
        this.modeloFact = (DefaultTableModel) this.jtableFactPendiente.getModel();
        this.modeloHist = (DefaultTableModel) this.jtableFactHistorial.getModel();
        inicializar();
    }
    
    /**
     * Constructor modificado con objeto de config de la clase jFrame
     * @param config
     */
    public frmPrincipal(appConfiguracion config) {
        try {
            JFrame.setDefaultLookAndFeelDecorated(true);
            JDialog.setDefaultLookAndFeelDecorated(true);
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        }catch (Exception e){
            e.printStackTrace();
        }
        initComponents();
        this.setLocationRelativeTo(null);
        this.iconos = new iconBarraProgreso();
        this.appC = config;
        this.modeloFact = (DefaultTableModel) this.jtableFactPendiente.getModel();
        this.modeloHist = (DefaultTableModel) this.jtableFactHistorial.getModel();
        inicializar();
    }
    
    /**
     * Constructor modificado con objeto de config y de conexion DB de 
     * la clase jFrame
     * @param config
     * @param oraconn 
     */
    public frmPrincipal(appConfiguracion config, OracleConection oraconn) {
        try {
            JFrame.setDefaultLookAndFeelDecorated(true);
            JDialog.setDefaultLookAndFeelDecorated(true);
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        }catch (Exception e){
            e.printStackTrace();
        }
        initComponents();
        this.setLocationRelativeTo(null);
        this.iconos = new iconBarraProgreso();
        this.appC = config;
        this.conn = oraconn;
        this.modeloFact = (DefaultTableModel) this.jtableFactPendiente.getModel();
        this.modeloHist = (DefaultTableModel) this.jtableFactHistorial.getModel();
        inicializar();
    }
    
    /**
     * Icono del formulario
     * @return retValue
     */
    @Override
    public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().
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

        jtabPanelFacturas = new javax.swing.JTabbedPane();
        jpanelFacturasPendientes = new javax.swing.JPanel();
        jspanelFactPendiente = new javax.swing.JScrollPane();
        jtableFactPendiente = new javax.swing.JTable();
        jpanelFacturasImpresas = new javax.swing.JPanel();
        jspanelFactHistorial = new javax.swing.JScrollPane();
        jtableFactHistorial = new javax.swing.JTable();
        jpanelResultado = new javax.swing.JPanel();
        jlblNroFactura = new javax.swing.JLabel();
        jlblFechaFactura = new javax.swing.JLabel();
        jlblNroFacturaValor = new javax.swing.JLabel();
        jlblFechaFacturaValor = new javax.swing.JLabel();
        jlblUsuario = new javax.swing.JLabel();
        jlblStatusImp = new javax.swing.JLabel();
        jlblUsuarioValor = new javax.swing.JLabel();
        jblStatusImpValor = new javax.swing.JLabel();
        jpanelBotones = new javax.swing.JPanel();
        jcmdRefrescar = new javax.swing.JButton();
        jcmdImprimir = new javax.swing.JButton();
        jcmdCancelar = new javax.swing.JButton();
        jtbarNotificacion = new javax.swing.JToolBar();
        jsprMargen = new javax.swing.JToolBar.Separator();
        jlblLogoTunal = new javax.swing.JLabel();
        jcmbbEmpresa = new javax.swing.JComboBox();
        jsprMargen1 = new javax.swing.JToolBar.Separator();
        jlblNotificacion = new javax.swing.JLabel();
        jtbarInfo = new javax.swing.JToolBar();
        jsprMargen2 = new javax.swing.JToolBar.Separator();
        jlblInfo = new javax.swing.JLabel();
        jmenuBarSistema = new javax.swing.JMenuBar();
        jmenuAcciones = new javax.swing.JMenu();
        jmenuItemImprimir = new javax.swing.JMenuItem();
        jmenuItemRefrescar = new javax.swing.JMenuItem();
        jsprAccion = new javax.swing.JPopupMenu.Separator();
        jmenuItemStatusFactura = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jmenuItemUtlReporteZ = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jmenuItemCierreZ = new javax.swing.JMenuItem();
        jmenuItemCierreX = new javax.swing.JMenuItem();
        jmenuItemReporteAuditoria = new javax.swing.JMenuItem();
        jmenuHerramientas = new javax.swing.JMenu();
        jmenuItemConfigDB = new javax.swing.JMenuItem();
        jmenuItemConfigIF = new javax.swing.JMenuItem();
        jsprHerramienta = new javax.swing.JPopupMenu.Separator();
        jmenuItemConfigCP = new javax.swing.JMenuItem();
        jmenuItemConfigVD = new javax.swing.JMenuItem();
        jsprHerramienta2 = new javax.swing.JPopupMenu.Separator();
        jmenuItemConfigTareaProg = new javax.swing.JMenuItem();
        jmenuAyuda = new javax.swing.JMenu();
        jmenuItemManualUsuario = new javax.swing.JMenuItem();
        jmenuItemAcercaDe = new javax.swing.JMenuItem();
        jmenuSalir = new javax.swing.JMenu();
        jmenuItemSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Impresora Fiscal Epson VE - El Tunal C.A.");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImage(getIconImage());
        setResizable(false);

        jtabPanelFacturas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtabPanelFacturasMouseClicked(evt);
            }
        });

        jtableFactPendiente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nro Doc.", "Tipo Doc.", "Doc Ref.", "Fecha Doc.", "Cliente", "Enviada por", "Estatus", "compania", "Serie", "serieFC"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtableFactPendiente.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtableFactPendiente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtableFactPendienteMouseClicked(evt);
            }
        });
        jspanelFactPendiente.setViewportView(jtableFactPendiente);
        if (jtableFactPendiente.getColumnModel().getColumnCount() > 0) {
            jtableFactPendiente.getColumnModel().getColumn(0).setMinWidth(70);
            jtableFactPendiente.getColumnModel().getColumn(0).setPreferredWidth(70);
            jtableFactPendiente.getColumnModel().getColumn(0).setMaxWidth(70);
            jtableFactPendiente.getColumnModel().getColumn(1).setMinWidth(60);
            jtableFactPendiente.getColumnModel().getColumn(1).setPreferredWidth(60);
            jtableFactPendiente.getColumnModel().getColumn(1).setMaxWidth(60);
            jtableFactPendiente.getColumnModel().getColumn(2).setMinWidth(60);
            jtableFactPendiente.getColumnModel().getColumn(2).setPreferredWidth(60);
            jtableFactPendiente.getColumnModel().getColumn(2).setMaxWidth(60);
            jtableFactPendiente.getColumnModel().getColumn(3).setMinWidth(80);
            jtableFactPendiente.getColumnModel().getColumn(3).setPreferredWidth(80);
            jtableFactPendiente.getColumnModel().getColumn(3).setMaxWidth(80);
            jtableFactPendiente.getColumnModel().getColumn(4).setMinWidth(300);
            jtableFactPendiente.getColumnModel().getColumn(4).setPreferredWidth(300);
            jtableFactPendiente.getColumnModel().getColumn(4).setMaxWidth(300);
            jtableFactPendiente.getColumnModel().getColumn(5).setMinWidth(150);
            jtableFactPendiente.getColumnModel().getColumn(5).setPreferredWidth(150);
            jtableFactPendiente.getColumnModel().getColumn(5).setMaxWidth(150);
            jtableFactPendiente.getColumnModel().getColumn(6).setMinWidth(50);
            jtableFactPendiente.getColumnModel().getColumn(6).setPreferredWidth(50);
            jtableFactPendiente.getColumnModel().getColumn(6).setMaxWidth(50);
            jtableFactPendiente.getColumnModel().getColumn(7).setMinWidth(0);
            jtableFactPendiente.getColumnModel().getColumn(7).setPreferredWidth(0);
            jtableFactPendiente.getColumnModel().getColumn(7).setMaxWidth(0);
            jtableFactPendiente.getColumnModel().getColumn(8).setMinWidth(47);
            jtableFactPendiente.getColumnModel().getColumn(8).setPreferredWidth(47);
            jtableFactPendiente.getColumnModel().getColumn(8).setMaxWidth(47);
            jtableFactPendiente.getColumnModel().getColumn(9).setMinWidth(0);
            jtableFactPendiente.getColumnModel().getColumn(9).setPreferredWidth(0);
            jtableFactPendiente.getColumnModel().getColumn(9).setMaxWidth(0);
        }

        org.jdesktop.layout.GroupLayout jpanelFacturasPendientesLayout = new org.jdesktop.layout.GroupLayout(jpanelFacturasPendientes);
        jpanelFacturasPendientes.setLayout(jpanelFacturasPendientesLayout);
        jpanelFacturasPendientesLayout.setHorizontalGroup(
            jpanelFacturasPendientesLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jpanelFacturasPendientesLayout.createSequentialGroup()
                .addContainerGap()
                .add(jspanelFactPendiente, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 838, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpanelFacturasPendientesLayout.setVerticalGroup(
            jpanelFacturasPendientesLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jpanelFacturasPendientesLayout.createSequentialGroup()
                .addContainerGap()
                .add(jspanelFactPendiente, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                .addContainerGap())
        );

        jtabPanelFacturas.addTab("Documentos Pendientes", jpanelFacturasPendientes);

        jtableFactHistorial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Estatus", "Nro Doc.", "Tipo Doc.", "Fecha Doc.", "Cliente", "Vendedor", "Nro Doc IF.", "Fecha Doc IF."
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jspanelFactHistorial.setViewportView(jtableFactHistorial);
        if (jtableFactHistorial.getColumnModel().getColumnCount() > 0) {
            jtableFactHistorial.getColumnModel().getColumn(0).setMinWidth(50);
            jtableFactHistorial.getColumnModel().getColumn(0).setPreferredWidth(50);
            jtableFactHistorial.getColumnModel().getColumn(0).setMaxWidth(50);
            jtableFactHistorial.getColumnModel().getColumn(1).setMinWidth(70);
            jtableFactHistorial.getColumnModel().getColumn(1).setPreferredWidth(70);
            jtableFactHistorial.getColumnModel().getColumn(1).setMaxWidth(70);
            jtableFactHistorial.getColumnModel().getColumn(2).setMinWidth(70);
            jtableFactHistorial.getColumnModel().getColumn(2).setPreferredWidth(70);
            jtableFactHistorial.getColumnModel().getColumn(2).setMaxWidth(70);
            jtableFactHistorial.getColumnModel().getColumn(3).setMinWidth(90);
            jtableFactHistorial.getColumnModel().getColumn(3).setPreferredWidth(90);
            jtableFactHistorial.getColumnModel().getColumn(3).setMaxWidth(90);
            jtableFactHistorial.getColumnModel().getColumn(4).setMinWidth(257);
            jtableFactHistorial.getColumnModel().getColumn(4).setPreferredWidth(257);
            jtableFactHistorial.getColumnModel().getColumn(4).setMaxWidth(257);
            jtableFactHistorial.getColumnModel().getColumn(5).setMinWidth(120);
            jtableFactHistorial.getColumnModel().getColumn(5).setPreferredWidth(120);
            jtableFactHistorial.getColumnModel().getColumn(5).setMaxWidth(120);
            jtableFactHistorial.getColumnModel().getColumn(6).setMinWidth(70);
            jtableFactHistorial.getColumnModel().getColumn(6).setPreferredWidth(70);
            jtableFactHistorial.getColumnModel().getColumn(6).setMaxWidth(70);
            jtableFactHistorial.getColumnModel().getColumn(7).setMinWidth(90);
            jtableFactHistorial.getColumnModel().getColumn(7).setPreferredWidth(90);
            jtableFactHistorial.getColumnModel().getColumn(7).setMaxWidth(90);
        }

        org.jdesktop.layout.GroupLayout jpanelFacturasImpresasLayout = new org.jdesktop.layout.GroupLayout(jpanelFacturasImpresas);
        jpanelFacturasImpresas.setLayout(jpanelFacturasImpresasLayout);
        jpanelFacturasImpresasLayout.setHorizontalGroup(
            jpanelFacturasImpresasLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jpanelFacturasImpresasLayout.createSequentialGroup()
                .addContainerGap()
                .add(jspanelFactHistorial, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 838, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpanelFacturasImpresasLayout.setVerticalGroup(
            jpanelFacturasImpresasLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jpanelFacturasImpresasLayout.createSequentialGroup()
                .addContainerGap()
                .add(jspanelFactHistorial, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                .addContainerGap())
        );

        jtabPanelFacturas.addTab("Historial Documentos", jpanelFacturasImpresas);

        jpanelResultado.setBorder(javax.swing.BorderFactory.createTitledBorder("Información Imp. Fiscal"));

        jlblNroFactura.setText("Nro Doc.:");

        jlblFechaFactura.setText("Fecha Doc.:");

        jlblNroFacturaValor.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jlblNroFacturaValor.setForeground(new java.awt.Color(0, 153, 0));
        jlblNroFacturaValor.setText("--");

        jlblFechaFacturaValor.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        jlblFechaFacturaValor.setForeground(new java.awt.Color(0, 0, 102));
        jlblFechaFacturaValor.setText("--");

        jlblUsuario.setText("Usuario:");

        jlblStatusImp.setText("Estatus:");

        jlblUsuarioValor.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        jlblUsuarioValor.setForeground(new java.awt.Color(0, 0, 102));
        jlblUsuarioValor.setText("--");

        jblStatusImpValor.setForeground(new java.awt.Color(0, 153, 0));
        jblStatusImpValor.setText("--");
        jblStatusImpValor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        org.jdesktop.layout.GroupLayout jpanelResultadoLayout = new org.jdesktop.layout.GroupLayout(jpanelResultado);
        jpanelResultado.setLayout(jpanelResultadoLayout);
        jpanelResultadoLayout.setHorizontalGroup(
            jpanelResultadoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jpanelResultadoLayout.createSequentialGroup()
                .addContainerGap()
                .add(jpanelResultadoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jlblNroFactura)
                    .add(jlblFechaFactura))
                .add(18, 18, 18)
                .add(jpanelResultadoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(jlblNroFacturaValor, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                    .add(jlblFechaFacturaValor, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jpanelResultadoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jpanelResultadoLayout.createSequentialGroup()
                        .add(jlblUsuario)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(jlblUsuarioValor, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .add(jpanelResultadoLayout.createSequentialGroup()
                        .add(jlblStatusImp)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(jblStatusImpValor, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jpanelResultadoLayout.setVerticalGroup(
            jpanelResultadoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jpanelResultadoLayout.createSequentialGroup()
                .add(jpanelResultadoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jlblNroFactura)
                    .add(jlblNroFacturaValor)
                    .add(jlblUsuario)
                    .add(jlblUsuarioValor))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jpanelResultadoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jlblFechaFactura)
                    .add(jlblFechaFacturaValor)
                    .add(jlblStatusImp)
                    .add(jblStatusImpValor)))
        );

        jpanelBotones.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jcmdRefrescar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recurso/Iconos/Refresh32.png"))); // NOI18N
        jcmdRefrescar.setMnemonic('R');
        jcmdRefrescar.setText("Refrescar");
        jcmdRefrescar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jcmdRefrescarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jcmdRefrescarMouseExited(evt);
            }
        });
        jcmdRefrescar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcmdRefrescarActionPerformed(evt);
            }
        });

        jcmdImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recurso/Iconos/print32.png"))); // NOI18N
        jcmdImprimir.setMnemonic('p');
        jcmdImprimir.setText("Imprimir");
        jcmdImprimir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jcmdImprimirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jcmdImprimirMouseExited(evt);
            }
        });
        jcmdImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcmdImprimirActionPerformed(evt);
            }
        });

        jcmdCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recurso/Iconos/Knob_Cancel32.png"))); // NOI18N
        jcmdCancelar.setMnemonic('C');
        jcmdCancelar.setText("Cancelar");
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

        org.jdesktop.layout.GroupLayout jpanelBotonesLayout = new org.jdesktop.layout.GroupLayout(jpanelBotones);
        jpanelBotones.setLayout(jpanelBotonesLayout);
        jpanelBotonesLayout.setHorizontalGroup(
            jpanelBotonesLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jpanelBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .add(jcmdRefrescar)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jcmdImprimir)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jcmdCancelar)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpanelBotonesLayout.setVerticalGroup(
            jpanelBotonesLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jpanelBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .add(jpanelBotonesLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jcmdImprimir, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .add(jcmdRefrescar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .add(jcmdCancelar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 38, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
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

        jcmbbEmpresa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcmbbEmpresa.setMaximumSize(new java.awt.Dimension(150, 32767));
        jcmbbEmpresa.setMinimumSize(new java.awt.Dimension(150, 25));
        jtbarNotificacion.add(jcmbbEmpresa);

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
        jtbarInfo.add(jsprMargen2);

        jlblInfo.setText("                ");
        jlblInfo.setToolTipText("");
        jlblInfo.setFocusable(false);
        jtbarInfo.add(jlblInfo);

        jmenuAcciones.setMnemonic('A');
        jmenuAcciones.setText("Acciones");

        jmenuItemImprimir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jmenuItemImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recurso/Iconos/print16.png"))); // NOI18N
        jmenuItemImprimir.setText("Imprimir");
        jmenuItemImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenuItemImprimirActionPerformed(evt);
            }
        });
        jmenuAcciones.add(jmenuItemImprimir);

        jmenuItemRefrescar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        jmenuItemRefrescar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recurso/Iconos/Refresh16.png"))); // NOI18N
        jmenuItemRefrescar.setText("Refrescar");
        jmenuItemRefrescar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenuItemRefrescarActionPerformed(evt);
            }
        });
        jmenuAcciones.add(jmenuItemRefrescar);
        jmenuAcciones.add(jsprAccion);

        jmenuItemStatusFactura.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        jmenuItemStatusFactura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recurso/Iconos/Knob_Search16.png"))); // NOI18N
        jmenuItemStatusFactura.setText("Estatus Documento");
        jmenuItemStatusFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenuItemStatusFacturaActionPerformed(evt);
            }
        });
        jmenuAcciones.add(jmenuItemStatusFactura);
        jmenuAcciones.add(jSeparator1);

        jmenuItemUtlReporteZ.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jmenuItemUtlReporteZ.setText("Visualizar Ult. Cierre");
        jmenuItemUtlReporteZ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenuItemUtlReporteZActionPerformed(evt);
            }
        });
        jmenuAcciones.add(jmenuItemUtlReporteZ);
        jmenuAcciones.add(jSeparator2);

        jmenuItemCierreZ.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jmenuItemCierreZ.setMnemonic('Z');
        jmenuItemCierreZ.setText("Cierre Diario (Z)");
        jmenuItemCierreZ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenuItemCierreZActionPerformed(evt);
            }
        });
        jmenuAcciones.add(jmenuItemCierreZ);

        jmenuItemCierreX.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jmenuItemCierreX.setMnemonic('X');
        jmenuItemCierreX.setText("Cierre de Caja (X)");
        jmenuItemCierreX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenuItemCierreXActionPerformed(evt);
            }
        });
        jmenuAcciones.add(jmenuItemCierreX);

        jmenuItemReporteAuditoria.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jmenuItemReporteAuditoria.setText("Reporte Auditoria");
        jmenuItemReporteAuditoria.setVisible(false);
        jmenuItemReporteAuditoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenuItemReporteAuditoriaActionPerformed(evt);
            }
        });
        jmenuAcciones.add(jmenuItemReporteAuditoria);

        jmenuBarSistema.add(jmenuAcciones);

        jmenuHerramientas.setMnemonic('H');
        jmenuHerramientas.setText("Herramientas");

        jmenuItemConfigDB.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jmenuItemConfigDB.setText("Configuración DB");
        jmenuItemConfigDB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenuItemConfigDBActionPerformed(evt);
            }
        });
        jmenuHerramientas.add(jmenuItemConfigDB);

        jmenuItemConfigIF.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jmenuItemConfigIF.setText("Configuración Imp. Fiscal");
        jmenuItemConfigIF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenuItemConfigIFActionPerformed(evt);
            }
        });
        jmenuHerramientas.add(jmenuItemConfigIF);
        jmenuHerramientas.add(jsprHerramienta);

        jmenuItemConfigCP.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jmenuItemConfigCP.setText("Configuración Compañia");
        jmenuItemConfigCP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenuItemConfigCPActionPerformed(evt);
            }
        });
        jmenuHerramientas.add(jmenuItemConfigCP);

        jmenuItemConfigVD.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jmenuItemConfigVD.setText("Verificar Datos");
        jmenuItemConfigVD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenuItemConfigVDActionPerformed(evt);
            }
        });
        jmenuHerramientas.add(jmenuItemConfigVD);
        jmenuHerramientas.add(jsprHerramienta2);

        jmenuItemConfigTareaProg.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jmenuItemConfigTareaProg.setText("Configuración Tarea Prog.");
        jmenuItemConfigTareaProg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenuItemConfigTareaProgActionPerformed(evt);
            }
        });
        jmenuHerramientas.add(jmenuItemConfigTareaProg);

        jmenuBarSistema.add(jmenuHerramientas);

        jmenuAyuda.setMnemonic('u');
        jmenuAyuda.setText("Ayuda");

        jmenuItemManualUsuario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jmenuItemManualUsuario.setText("Manual de Usuario");
        jmenuAyuda.add(jmenuItemManualUsuario);

        jmenuItemAcercaDe.setText("Acerca de...");
        jmenuAyuda.add(jmenuItemAcercaDe);

        jmenuBarSistema.add(jmenuAyuda);

        jmenuSalir.setMnemonic('S');
        jmenuSalir.setText("Salir");
        jmenuSalir.setToolTipText("");

        jmenuItemSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jmenuItemSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recurso/Iconos/Knob_LoopOn16.png"))); // NOI18N
        jmenuItemSalir.setText("Salir");
        jmenuItemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenuItemSalirActionPerformed(evt);
            }
        });
        jmenuSalir.add(jmenuItemSalir);

        jmenuBarSistema.add(jmenuSalir);

        setJMenuBar(jmenuBarSistema);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(jtbarNotificacion, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 740, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jtbarInfo, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jtabPanelFacturas)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(jpanelResultado, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(jpanelBotones, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jtabPanelFacturas, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 314, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(jpanelBotones, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jpanelResultado, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 11, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jtbarNotificacion, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 25, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jtbarInfo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 25, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Llamada a formulario de configuración de impresora fiscal
     * @param evt 
     */
    private void jmenuItemConfigIFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenuItemConfigIFActionPerformed
        //  Variables
        frmConfig_login vntLogin;
        frmConfig_ImpFiscal vntImpFiscal;
        
        //  Proceso
        jlblNotificacionMouseExited(null);
        //  Proceso - Llamar a formulario ConfigImpFiscal
        try {
            vntLogin = new frmConfig_login(this, true, "admin", 
                    this.appC.getPropsControl());
            vntLogin.setVisible(true);
            if (vntLogin.isOk()){
                vntLogin.dispose();
                vntImpFiscal = new frmConfig_ImpFiscal(this, true, 
                        this.appC.getPropsImpFiscal());
                vntImpFiscal.setVisible(true);
                if (vntImpFiscal.isOk()){
                    this.appC.setPropsImpFiscal(vntImpFiscal.getConfigFiscal());
                    vntImpFiscal.dispose();
                    if (this.appC.escribirConfiguracion(this.appC.getPropsImpFiscal(), 
                            this.appC.getRutaConfig().trim()+"impFiscal.properties", 
                            "ImpFiscal")){
                        //  Mensaje del sistema
                        this.jlblNotificacion.setIcon(iconos.getSuccessImage());
                        this.jlblNotificacion.setText("Se guardo corrrectamente la configuracion!");
                    } else{
                        this.jlblNotificacion.setIcon(iconos.getErrorImage());
                        this.jlblNotificacion.setText("Fallo la conexion con la BD!");
                    }
                }
            } else {
                this.jlblNotificacion.setIcon(iconos.getWarningImage());
                this.jlblNotificacion.setText("Error en la verificación de los datos");
            }
        } catch (Exception ex) {
            this.jlblNotificacion.setIcon(iconos.getErrorImage());
            this.jlblNotificacion.setText("Fallo la conexion con la BD!");
            Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jmenuItemConfigIFActionPerformed

    /**
     * Refrescar listado de facturas pendientes segun listado siquel
     * @param evt 
     */
    private void jmenuItemRefrescarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenuItemRefrescarActionPerformed
        //  Proceso
        jcmdRefrescarActionPerformed(null);
    }//GEN-LAST:event_jmenuItemRefrescarActionPerformed

    /**
     * Restaurar progressBar Notificacion
     * @param evt 
     */
    private void jlblNotificacionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblNotificacionMouseExited
        //  Proceso
        this.jlblNotificacion.setText("         ");
        this.jlblNotificacion.setIcon(null);
        this.jlblNroFacturaValor.setText("--");
        this.jlblFechaFacturaValor.setText("--");
        this.jblStatusImpValor.setForeground(Color.gray); //[204,0,0]
        this.jblStatusImpValor.setText("--");
        this.jlblUsuarioValor.setText(this.appC.getPropsControl().
                getProperty("usu_cntr").trim());
    }//GEN-LAST:event_jlblNotificacionMouseExited

    /**
     * Salir del sistema Imp. Fiscal El Tunal
     * @param evt 
     */
    private void jmenuItemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenuItemSalirActionPerformed
        //  Proceso
        if(JOptionPane.showConfirmDialog(this, "Esta seguro que desea salir del sistema?", 
                "Impresora Fiscal Epson VE - El Tunal C.A.", JOptionPane.OK_CANCEL_OPTION) == 0){
            this.conn.Desconectar();
            System.exit(0);
        }
            
    }//GEN-LAST:event_jmenuItemSalirActionPerformed

    /**
     * Colocar combinacion de teclas para opcion "Refrescar" en progressBar Info
     * @param evt 
     */
    private void jcmdRefrescarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcmdRefrescarMouseEntered
        //  Proceso
        this.jlblInfo.setText("Alt + R");
    }//GEN-LAST:event_jcmdRefrescarMouseEntered

    /**
     * Restaurar progressBar Info
     * @param evt 
     */
    private void jcmdRefrescarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcmdRefrescarMouseExited
        //  Proceso
        this.jlblInfo.setText("         ");
    }//GEN-LAST:event_jcmdRefrescarMouseExited

    /**
     * Colocar combinacion de teclas para opcion "Imprimir" en progressBar Info
     * @param evt 
     */
    private void jcmdImprimirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcmdImprimirMouseEntered
        //  Proceso
        this.jlblInfo.setText("Alt + P");
    }//GEN-LAST:event_jcmdImprimirMouseEntered

    /**
     * Restaurar progressBar Info
     * @param evt 
     */
    private void jcmdImprimirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcmdImprimirMouseExited
        //  Proceso
        this.jlblInfo.setText("         ");
    }//GEN-LAST:event_jcmdImprimirMouseExited

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
     * Refrescar listado de facturas pendientes segun listado siquel
     * @param evt 
     */
    private void jcmdRefrescarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcmdRefrescarActionPerformed
        //  Variables
        String sql = "", value = "", puertoImp, fechaImp ="";
        List<String> lista = null, item = null;
        List<String> listaFec = null, itemFec = null;
        Date fecha = null;
        DateFormat fechaFormat = null;
        
        //  Inicializar
        this.modeloFact.getDataVector().removeAllElements();
        this.modeloFact.fireTableDataChanged();
        this.modeloFact.setRowCount(0);
        item = new ArrayList();
        itemFec = new ArrayList();
        
        //  Proceso
        jlblNotificacionMouseExited(null);
        //  Verificacion
        if (this.conn.isConnOk()) {
            sql =   "Select " +
                    "       to_char(max(TUNAL.IMFI_FECHA_CIERRE.IMFI_FCFECFACTIF)+1,'YYYY-MM-DD') " +
                    "from   TUNAL.IMFI_FECHA_CIERRE " +
                    "where  TUNAL.IMFI_FECHA_CIERRE.IMFI_FCCIAS=" + this.appC.getPropsGeneral().
                                getProperty("db_empresa").trim();
            listaFec = this.conn.busqueda(sql, 2);
            if (listaFec != null) {
                for (String cadFec : listaFec) {
                    itemFec.clear();
                    itemFec.addAll(Arrays.asList(cadFec.split("-;-")));
                }
                if (!itemFec.isEmpty())
                    fechaImp = itemFec.get(0).trim();
            }
            if (fechaImp.isEmpty()){
                fecha = new Date();
                fechaFormat = new SimpleDateFormat("yyyy-MM-dd");
                fechaImp = fechaFormat.format(fecha).trim();
            }
            //  Validar fecha ImpFiscal
            if (this.jlblUsuario.getText().equals("Eltunal2014"))
                sql = "select * from IMFI_DATA_H where IMFI_STAT1 <> 'P' "
                        + "and IMFI_FECFACT=TO_DATE('"+fechaImp.trim()+"',"
                        + "'YYYY-MM-DD') order by 24";
            else
                sql = "select * from IMFI_DATA_H where IMFI_STAT1 <> 'P' "
                        + "and IMFI_CIAS = " + this.appC.getPropsGeneral().
                                getProperty("db_empresa").trim()
                        + "and IMFI_SERIEDC = '" + this.appC.getPropsGeneral().
                                getProperty("db_empresa_serie").trim() + "'"
                        + " and IMFI_FECFACT=TO_DATE('"+fechaImp.trim()+"',"
                        + "'YYYY-MM-DD') order by 24";
            lista = this.conn.busqueda(sql, 24);

            if (lista != null) {
                for (String cad : lista) {
                    item.clear();
                    item.addAll(Arrays.asList(cad.split("-;-")));
                    value = (item.get(16).trim().equalsIgnoreCase("N")) ? 
                            "Nuevo" : "Error";
                    this.modeloFact.addRow(new Object[]{Integer.parseInt(
                            item.get(7).trim()),item.get(5).trim(),item.get(4).trim(),
                            item.get(8).trim().substring(0, 10),item.get(10).trim() + " - " 
                                + item.get(11).trim(),item.get(14).trim(),
                                value.trim(),item.get(0).trim(),item.get(6).trim(),
                                item.get(3).trim()});
                }
            } else {
                this.jlblNotificacion.setIcon(iconos.getWarningImage());
                this.jlblNotificacion.setText("No se encontraron datos "
                        + "disponibles para la impresion");
            }
        } else {
            this.jlblNotificacion.setIcon(iconos.getErrorImage());
            this.jlblNotificacion.setText("Perdida de conexion con la BD!");
            Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, 
                    null, "Perdida de conexion");
        }
    }//GEN-LAST:event_jcmdRefrescarActionPerformed

    /**
     * Enviar datos a impresora fiscal
     * @param evt 
     */
    private void jcmdImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcmdImprimirActionPerformed
        //  Variables
        PnpDriverFiscal printer = new PnpDriverFiscal();
        int nError = 0, velocidadImp, cabecera;
        String puertoImp, horaImp, fechaFact, sql, compania,serie,serieFC,tpdoc, 
                nrodc, nroImp, serialImp = "", fechaNC = "", tareaProg = "", ivaNC = "0000";
        List<String> datos, item = new ArrayList();
        List<String> datosNC, itemNC = new ArrayList();
        List<String> datosEx, itemEx = new ArrayList();
        List<String> datosVl, itemVl = new ArrayList();
        Date date = null;
        DateFormat hourdateFormat = null;
        double montoNC = 0;
        
        //  Proceso
        jlblNotificacionMouseExited(null);
        //  Verificamos seleccion correcta
        if (this.jtableFactPendiente.getSelectedRow() >= 0 ) {
            if (this.jtableFactPendiente.getSelectedRow() == 0) {
                //  Datos necesarios para el proceso
                fechaFact = this.modeloFact.getValueAt(
                    this.jtableFactPendiente.getSelectedRow(), 3).toString();
                compania  = this.modeloFact.getValueAt(
                    this.jtableFactPendiente.getSelectedRow(), 7).toString();
                serie     = this.modeloFact.getValueAt(
                    this.jtableFactPendiente.getSelectedRow(), 8).toString();
                serieFC   = this.modeloFact.getValueAt(
                    this.jtableFactPendiente.getSelectedRow(), 9).toString();
                tpdoc     = this.modeloFact.getValueAt(
                    this.jtableFactPendiente.getSelectedRow(), 1).toString();
                nrodc     = this.modeloFact.getValueAt(
                    this.jtableFactPendiente.getSelectedRow(), 0).toString();
                puertoImp = this.appC.getPropsImpFiscal().getProperty("puerto_imp");
                velocidadImp = Integer.parseInt(this.appC.getPropsImpFiscal().
                        getProperty("velocidad_imp").trim());
                sql = "select  IMFI_TPSTAT,IMFI_TPFECEJC " +
                        "from    IMFI_TAREA_PROG " +
                        "where   IMFI_TPFECEJC=(" +
                        "    select max(IMFI_TPFECEJC) " +
                        "    from IMFI_TAREA_PROG) " +
                        "and IMFI_TPCIAS =" + compania.trim();
                datosVl = this.conn.busqueda(sql, 3);
                if (datosVl != null) {
                    for (String cadVl : datosVl) {
                        itemVl.clear();
                        itemVl.addAll(Arrays.asList(cadVl.split("-;-")));
                    }
                    if (!itemVl.isEmpty())
                        tareaProg = itemVl.get(0).trim();
                }
                if (!tareaProg.equalsIgnoreCase("N")){
                    //  Apertura del puerto de la impresora fiscal
                    nError = printer.IF_OPEN(puertoImp, String.valueOf(velocidadImp));
                    if (nError == 0) {
                        /*nError = printer.GetDateTime();
                        if (nError == 0) {
                            horaImp = printer.IF_READ(3);
                            horaImp = "20" + horaImp.substring(0,2) + "-" +
                                    horaImp.substring(2,4) + "-" + horaImp.substring(4);
                            horaImp = "2014-01-02";*/
                            /*if (fechaFact.equalsIgnoreCase(horaImp.trim())) {*/
                                sql = "SELECT " +
                                        "    CTDF_CIAS," +
                                        "    SUBSTR(CTDF_DESCRIC,1,36)," +
                                        "    SUBSTR(CTDF_NRORIF,1,12)," +
                                        "    SUBSTR(MVDF_DESCRII,1,36)," +
                                        "    LPAD((RTRIM(LTRIM(TO_CHAR(mvdf_ctddoc,'9999.999')))),7,0)," +
                                        "    LPAD((RTRIM(LTRIM(TO_CHAR(mvdf_prcunim,'99999999.99')))),11,0)," +
                                        //"    REPLACE((mvdf_porimp/100),',','.')," +
                                        //"    REPLACE(TO_CHAR(mvdf_porimp,'99.99'),'.','')," +
                                        "    DECODE(mvdf_porimp,0,'0000',REPLACE(TO_CHAR(mvdf_porimp,'99.99'),'.',''))," +
                                        "    SUBSTR(CTDF_DIRECC1, 1,40)||SUBSTR(CTDF_DIRECC2, 1,8)," +
                                        "    RPAD(funciontele(ctdf_clie),48)," +
                                        "    CTDF_NRODOC," +
                                        "    CTDF_TPDC," +
                                        "    CTDF_SERIEFC," +
                                        "    CTDF_TPDCFAC," +
                                        "    CTDF_NROFAC," +
                                        "    CTDF_OBSERV1||SUBSTR(CTDF_OBSERV2,1,8)," +
                                        "    MVDF_MTIN " +
                                        " FROM CO_TCTDFAC, co_tmvdfac" +
                                        " WHERE   CTDF_NRODOC = " + nrodc.trim() +
                                        "    AND CTDF_CIAS =" + compania.trim() +
                                        "    AND CTDF_SERIEDC ='" + serie.trim() + "'" +
                                        "    AND CTDF_TPDC = '" + tpdoc.trim() +"'" +
                                        "    AND    mvdf_cias    =    ctdf_cias" +
                                        "    AND    mvdf_tpdc    =    ctdf_tpdc" +
                                        "    AND    mvdf_seriedc =    ctdf_seriedc" +
                                        "    AND    mvdf_nrodoc  =    ctdf_nrodoc";
                                datos = this.conn.busqueda(sql, 17);
                                cabecera = 0;
                                if (datos != null) {
                                    for (String cad : datos) {
                                        item.clear();
                                        item.addAll(Arrays.asList(cad.split("-;-")));
                                        if (cabecera == 0){
                                            if (tpdoc.trim().equalsIgnoreCase("FC")){
                                                printer.OpenFiscalReceipt(item.get(1).
                                                        trim(), 
                                                        item.get(2).trim(), "", "", "", 
                                                        "", "", "", "");
                                            } else {
                                                sql = "Select IMFI_NROFACIF,"
                                                        + "IMFI_FECFACTIF,"
                                                        + "IMFI_CTRSENIF,"
                                                        + "SUM((mvdf_prcunim * mvdf_ctddoc) * (1+(mvdf_porimp/100)))" +
                                                      " from" +
                                                        "    IMFI_DATA_H,co_tmvdfac " +
                                                      " where" +
                                                        "     IMFI_CIAS    =" + compania.trim() +
                                                        " and IMFI_TPDC    = 'FC'" +
                                                        " and IMFI_SERIEDC ='" + serieFC.trim() + "'" +
                                                        " and IMFI_NRODOC  ="  + item.get(13).trim() +
                                                        " and mvdf_cias   = IMFI_CIAS" +
                                                        " and mvdf_tpdc   = IMFI_TPDC" +
                                                        " and mvdf_seriedc = IMFI_SERIEDC" +
                                                        " and mvdf_nrodoc  = IMFI_NRODOC"  +
                                                      " group by IMFI_NROFACIF,IMFI_FECFACTIF,IMFI_CTRSENIF";
                                                datosNC = this.conn.busqueda(sql, 5);
                                                if (datosNC != null) {
                                                    for (String cad2 : datosNC) {
                                                        itemNC.clear();
                                                        itemNC.addAll(Arrays.asList(cad2.split("-;-")));
                                                    }
                                                    if (!itemNC.isEmpty()){
                                                        fechaNC = itemNC.get(1).trim().substring(8,10) + 
                                                                "/" + itemNC.get(1).trim().substring(5,7) +
                                                                "/" + itemNC.get(1).trim().substring(2,4);
                                                        printer.OpenFiscalReceipt(item.get(1).trim(),
                                                                item.get(2).trim(), itemNC.get(0).trim(), itemNC.get(2).trim(),
                                                                fechaNC.trim(), itemNC.get(1).trim().substring(11,16),
                                                                "D", "", "");
                                                    }
                                                }
                                            }
                                        }
                                        cabecera++;
                                        sql = "select mtin_cndexc from co_tmtin" +
                                              " where mtin_cias = " + compania.trim() +
                                              "   and mtin_mtin = '" + item.get(15).trim() +  "'";
                                        datosEx = this.conn.busqueda(sql, 2);
                                        if (datosEx != null){
                                            for (String cad3 : datosEx) {
                                                itemEx.clear();
                                                itemEx.addAll(Arrays.asList(cad3.split("-;-")));
                                            }
                                            if (!itemEx.isEmpty()){
                                                if (itemEx.get(0).trim().equalsIgnoreCase("S"))
                                                    item.set(3, item.get(3).trim() + " (E)");
                                            }
                                        }
                                        if (tpdoc.trim().equalsIgnoreCase("NC")) {
                                            montoNC = montoNC + Double.
                                                    valueOf(item.get(5).trim());
                                            ivaNC   = item.get(6).trim();
                                        } else {
                                            printer.PrintLineItem(item.get(3).trim(), 
                                                item.get(4).trim(),
                                                item.get(5).trim(),
                                                item.get(6).trim(),
                                                "M", "", "", "");
                                        }
                                        /* Descuento por monto en item
                                        printer.PrintLineItem(item.get(3).trim(), 
                                                Double.valueOf(item.get(4).trim()),
                                                Double.valueOf(item.get(5).trim()),
                                                Double.valueOf(item.get(6).trim()),
                                                "M", "", "", "");
                                        */
                                    }
                                    if (tpdoc.trim().equalsIgnoreCase("NC")) {
                                            printer.PrintLineItem("Descuento en Precio", 
                                                "1.00",
                                                String.valueOf(montoNC),ivaNC,"M", "", "", "");
                                    }
                                    printer.CloseFiscalReceipt("A");
                                    //printer.PrintFiscalText("Barquisimeto", "S");
                                    if (!tpdoc.trim().equalsIgnoreCase("FC")){
                                        printer.PrintFiscalText("Observacion","S");
                                        //printer.PrintNonFiscalText("===========");
                                        printer.PrintFiscalText("Nro. Fact: " + 
                                                itemNC.get(0).trim(),"S");
                                        printer.PrintFiscalText("Fec. Fact: " + 
                                                fechaNC.trim(),"S");
                                        printer.PrintFiscalText("Mto. Fact: " +
                                                Double.valueOf(itemNC.get(3).trim())
                                                        .toString().trim(),"S");
                                    }
                                    nError = printer.CloseFiscalReceipt("");
                                    if (nError == 0){
                                        nroImp = printer.IF_READ(3).trim();
                                        if (printer.SerialRequest()==0)
                                            serialImp = printer.IF_READ(3).trim();
                                        date = new Date();
                                        hourdateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                                        sql = "update IMFI_DATA_H set"
                                                + " IMFI_STAT1 = 'P' , IMFI_NROFACIF="
                                                + nroImp.trim() + ", IMFI_FECFACTIF=TO_DATE('"
                                                + hourdateFormat.format(date) + "','DD/MM/YYYY HH24:mi:ss'), IMFI_CTRSENIF='"
                                                + serialImp.trim() + "' "
                                                + "where IMFI_NRODOC = " + nrodc.trim() +
                                                "    AND IMFI_CIAS =" + compania.trim() +
                                                "    AND IMFI_SERIEDC ='" + serie.trim() + "'" +
                                                "    AND IMFI_TPDC = '" + tpdoc.trim() +"'";
                                        this.conn.ejecutar(sql);
                                        jcmdRefrescarActionPerformed(null);
                                        this.jlblNotificacion.setIcon(iconos.getSuccessImage());
                                        this.jlblNotificacion.setText("El documento fue impreso correctamente!");
                                        this.jblStatusImpValor.setForeground(Color.green);
                                        this.jblStatusImpValor.setText("Impreso");
                                    }else{
                                        this.conn.ejecutar("update IMFI_DATA_H set"
                                                + " IMFI_STAT1 = 'E' where " +
                                                "IMFI_NRODOC = " + nrodc.trim() +
                                                "    AND IMFI_CIAS =" + compania.trim() +
                                                "    AND IMFI_SERIEDC ='" + serie.trim() + "'" +
                                                "    AND IMFI_TPDC = '" + tpdoc.trim() +"'");
                                        this.jlblNotificacion.setIcon(iconos.getErrorImage());
                                        this.jlblNotificacion.setText("Error al imprimir el documento!");
                                        this.jblStatusImpValor.setForeground(Color.red);
                                        this.jblStatusImpValor.setText("Error");
                                    }
                                }
                            /*} else {
                                this.jlblNotificacion.setIcon(iconos.getErrorImage());
                                this.jlblNotificacion.setText("Factura con fecha anterior!");
                            }
                        }*/
                    } else {
                        this.jlblNotificacion.setIcon(iconos.getErrorImage());
                        this.jlblNotificacion.setText("Perdida de conexion con la Impresora Fiscal!");
                    }
                } else {
                    this.jcmdRefrescarActionPerformed(null);
                    this.jlblNotificacion.setIcon(iconos.getWarningImage());
                    this.jlblNotificacion.setText("Se esta ejecutando una impresión espere unos min. por favor!");
                    JOptionPane.showMessageDialog(this, "Se esta ejecutando una impresión espere unos min. por favor!", 
                "Impresora Fiscal Epson VE - El Tunal C.A.", JOptionPane.INFORMATION_MESSAGE);
                }
                //  Cerrar impresora fiscal
                printer.IF_ClOSE();
            } else {
                this.jlblNotificacion.setIcon(iconos.getWarningImage());
                this.jlblNotificacion.setText("Debe seleccionar los documentos en estricto orden!");
                JOptionPane.showMessageDialog(this, "Debe seleccionar los documentos en estricto orden!", 
                "Impresora Fiscal Epson VE - El Tunal C.A.", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            this.jlblNotificacion.setIcon(iconos.getWarningImage());
            this.jlblNotificacion.setText("Debe seleccionar una factura a imprimir!");
        }
    }//GEN-LAST:event_jcmdImprimirActionPerformed

    /**
     * Cancelar el proceso
     * @param evt 
     */
    private void jcmdCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcmdCancelarActionPerformed
        //  Proceso
        this.jcmdRefrescarActionPerformed(null);
        this.jlblNotificacionMouseExited(null);
        this.jtabPanelFacturas.setSelectedIndex(0);
        this.jlblNroFacturaValor.setText("--");
        this.jlblFechaFacturaValor.setText("--");
        this.jlblUsuarioValor.setText(this.appC.getPropsControl().
                getProperty("usu_cntr"));
    }//GEN-LAST:event_jcmdCancelarActionPerformed

    /**
     * Llamar al formulario de configuración de Base de datos
     * @param evt 
     */
    private void jmenuItemConfigDBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenuItemConfigDBActionPerformed
        //  Variables
        frmConfig_login vntLogin;
        frmConfig_BD vntBD;
        
        //  Proceso
        jlblNotificacionMouseExited(null);
        //  Proceso - Llamar a formulario ConfigBaseDatos
        try {
            vntLogin = new frmConfig_login(this, true, "admin", 
                    this.appC.getPropsControl());
            vntLogin.setVisible(true);
            if (vntLogin.isOk()){
                vntLogin.dispose();
                vntBD = new frmConfig_BD(this, true, 
                        this.appC.getPropsGeneral());
                vntBD.setVisible(true);
                if (vntBD.isOk()){
                    this.appC.setPropsGeneral(vntBD.getConfigGeneral());
                    vntBD.dispose();
                    if (this.appC.escribirConfiguracion(this.appC.getPropsGeneral(), 
                            this.appC.getRutaConfig().trim()+"appGeneral.properties", 
                            "General")){
                        //  Mensaje del sistema
                        this.jlblNotificacion.setIcon(iconos.getSuccessImage());
                        this.jlblNotificacion.setText("Se guardo corrrectamente la configuracion!");
                    } else{
                        this.jlblNotificacion.setIcon(iconos.getErrorImage());
                        this.jlblNotificacion.setText("Fallo la conexion con la BD!");
                    }
                }
            } else {
                this.jlblNotificacion.setIcon(iconos.getWarningImage());
                this.jlblNotificacion.setText("Error en la verificación de los datos");
            }
        } catch (Exception ex) {
            this.jlblNotificacion.setIcon(iconos.getErrorImage());
            this.jlblNotificacion.setText("Fallo la conexion con la BD!");
            Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jmenuItemConfigDBActionPerformed

    /**
     * Llamar al formulario de configuración de Datos de usuario
     * @param evt 
     */
    private void jmenuItemConfigVDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenuItemConfigVDActionPerformed
        //  Variables
        frmConfig_login vntLogin;
        frmConfig_VerificarDatos vntVD;
        
        //  Proceso
        jlblNotificacionMouseExited(null);
        //  Proceso - Llamar a formulario ConfigVerificarDatos
        try {
            vntLogin = new frmConfig_login(this, true, "admin", 
                    this.appC.getPropsControl());
            vntLogin.setVisible(true);
            if (vntLogin.isOk()){
                vntLogin.dispose();
                vntVD = new frmConfig_VerificarDatos(this, true, 
                        this.appC.getPropsControl());
                vntVD.setVisible(true);
                if (vntVD.isOk()){
                    this.appC.setPropsControl(vntVD.getConfigControl());
                    vntVD.dispose();
                    if (this.appC.escribirConfiguracion(this.appC.getPropsControl(), 
                            this.appC.getRutaConfig().trim()+"appControl.properties", 
                            "Control")){
                        //  Mensaje del sistema
                        this.jlblNotificacion.setIcon(iconos.getSuccessImage());
                        this.jlblNotificacion.setText("Se guardo corrrectamente la configuracion!");
                    } else{
                        this.jlblNotificacion.setIcon(iconos.getErrorImage());
                        this.jlblNotificacion.setText("Fallo la conexion con la BD!");
                    }
                }
            } else {
                this.jlblNotificacion.setIcon(iconos.getWarningImage());
                this.jlblNotificacion.setText("Error en la verificación de los datos");
            }
        } catch (Exception ex) {
            this.jlblNotificacion.setIcon(iconos.getErrorImage());
            this.jlblNotificacion.setText("Fallo la conexion con la BD!");
            Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jmenuItemConfigVDActionPerformed

    /**
     * Seleccionar la pantalla de facturas pendientes
     * @param evt 
     */
    private void jtabPanelFacturasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtabPanelFacturasMouseClicked
        //  Variables
        String sql = "";
        List<String> lista = null, item = null;

        //  Proceso
        if (this.jtabPanelFacturas.getSelectedIndex() == 0)
            jcmdRefrescarActionPerformed(null);
        else {
            //  Inicializar
            this.modeloHist.getDataVector().removeAllElements();
            this.modeloHist.fireTableDataChanged();
            this.modeloHist.setRowCount(0);
            item = new ArrayList();

            //  Proceso
            jlblNotificacionMouseExited(null);
            if (this.conn.isConnOk()) {
                if (this.jlblUsuario.getText().equals("Eltunal2014"))
                    sql = "select * from IMFI_DATA_H where IMFI_STAT1 = 'P' "
                            + "and ROWNUM <= 20 "
                            + "order by 19 desc";
                else
                    sql = "select * from IMFI_DATA_H where IMFI_STAT1 = 'P'"
                            + "and IMFI_CIAS = " + this.appC.getPropsGeneral().
                                    getProperty("db_empresa")
                            + "and IMFI_SERIEDC = '" + this.appC.getPropsGeneral().
                                getProperty("db_empresa_serie").trim() + "'"
                            + "and ROWNUM <= 20 "
                            + " order by 19 desc";
                lista = this.conn.busqueda(sql, 24);

                if (lista != null) {
                    for (String cad : lista) {
                        item.clear();
                        item.addAll(Arrays.asList(cad.split("-;-")));
                        this.modeloHist.addRow(new Object[]{
                            true,Integer.parseInt(item.get(7).trim()),
                            item.get(5).trim(),item.get(8).trim(),
                            item.get(10).trim() + " - " + item.get(11).trim(),
                            item.get(14).trim(),item.get(17).trim(),
                            item.get(18).trim()});
                    }
                } else {
                    this.jlblNotificacion.setIcon(iconos.getWarningImage());
                    this.jlblNotificacion.setText("No se encontraron datos "
                            + "disponibles para la impresion");
                }
            } else {
                this.jlblNotificacion.setIcon(iconos.getErrorImage());
                this.jlblNotificacion.setText("Perdida de conexion con la BD!");
                Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, 
                        null, "Perdida de conexion");
            }
        }
    }//GEN-LAST:event_jtabPanelFacturasMouseClicked

    /**
     * Seleccionar la tabla de facturas pendientes
     * @param evt 
     */
    private void jtableFactPendienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtableFactPendienteMouseClicked
        //  Variables
        String value = "";
        
        //  Proceso
        if (this.jtableFactPendiente.getSelectedRow() >= 0  ){
            value = this.modeloFact.getValueAt(
                    this.jtableFactPendiente.getSelectedRow(), 0).toString();
            if (!value.isEmpty()) {
                this.jlblNroFacturaValor.setText(value);
                value = "";
            }
            value = this.modeloFact.getValueAt(
                    this.jtableFactPendiente.getSelectedRow(), 3).toString();
            if (!value.isEmpty()) {
                this.jlblFechaFacturaValor.setText(value);
                value = "";
            }
            value = this.modeloFact.getValueAt(
                    this.jtableFactPendiente.getSelectedRow(), 6).toString();
            if (!value.isEmpty()) {
                this.jblStatusImpValor.setText(value);
                if (!value.equalsIgnoreCase("Error"))
                    this.jblStatusImpValor.setForeground(Color.gray);
                else
                    this.jblStatusImpValor.setForeground(Color.red);
            }
        }
    }//GEN-LAST:event_jtableFactPendienteMouseClicked

    /**
     * Imprimir Documentos fiscales (Facturas, Notas de Credito)
     * @param evt 
     */
    private void jmenuItemImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenuItemImprimirActionPerformed
        //  Proceso
        jcmdImprimirActionPerformed(null);
    }//GEN-LAST:event_jmenuItemImprimirActionPerformed

    /**
     * Cierre Diario de la impresora fiscal
     * @param evt 
     */
    private void jmenuItemCierreZActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenuItemCierreZActionPerformed
        //  Variables
        PnpDriverFiscal printer = new PnpDriverFiscal();
        int nError = 0, velocidadImp, cantDocIF = 0, cantDocSQ = 0;
        String puertoImp, sql, cmp, ser;
        List<String> listaDoc, itemDoc = new ArrayList();
        List<String> listaFec, itemFec = new ArrayList();
        Date fecActual = new Date(), fechaCProx = null;
        Calendar cal;
        
        //  Inicializar
        puertoImp = this.appC.getPropsImpFiscal().getProperty("puerto_imp");
        velocidadImp = Integer.parseInt(this.appC.getPropsImpFiscal().
                getProperty("velocidad_imp").trim());
        cmp = this.appC.getPropsGeneral().getProperty("db_empresa").trim();
        ser = this.appC.getPropsGeneral().getProperty("db_empresa_serie").trim();

        //  Proceso
        jlblNotificacionMouseExited(null);
        this.jmenuItemUtlReporteZActionPerformed(null);
        if (this.conn.isConnOk()) {
            //  Calcular documentos pendientes
            sql = "Select count (*) from TUNAL.IMFI_DATA_H " +
                    "where TUNAL.IMFI_DATA_H.IMFI_CIAS=" + cmp.trim() + 
                    " and TUNAL.IMFI_DATA_H.IMFI_SERIEDC  = '" + ser.trim() + "'" +
                    " and TUNAL.IMFI_DATA_H.IMFI_STAT1   <> 'P'" +
                    " and TUNAL.IMFI_DATA_H.IMFI_FECFACT  =" +
                    "    (Select " +
                    "        max(TUNAL.IMFI_FECHA_CIERRE.IMFI_FCFECFACTIF+1)" +
                    "     from   TUNAL.IMFI_FECHA_CIERRE" +
                    "     where  TUNAL.IMFI_FECHA_CIERRE.IMFI_FCCIAS=" + cmp.trim()
                    +    ")";
            listaDoc = this.conn.busqueda(sql, 2);
            if (listaDoc != null) {
                for (String cadDoc : listaDoc) {
                    itemDoc.clear();
                    itemDoc.addAll(Arrays.asList(cadDoc.split("-;-")));
                }
                cantDocIF = Integer.parseInt(itemDoc.get(0).trim());
                sql = "";
                listaDoc = null;
            }
            sql = "select count(*) from CO_TCTDFAC " +
                        "where  CO_TCTDFAC.CTDF_NROIMP  is null " +
                        " and   CO_TCTDFAC.CTDF_CIAS    =" + cmp.trim() +
                        " and   CO_TCTDFAC.CTDF_SERIEDC = '" + ser.trim() + "'" +
                        " and   CO_TCTDFAC.CTDF_FECFACT =" +
                        "    (Select " +
                        "        max(TUNAL.IMFI_FECHA_CIERRE.IMFI_FCFECFACTIF)+1" +
                        "     from   TUNAL.IMFI_FECHA_CIERRE " +
                        "     where  TUNAL.IMFI_FECHA_CIERRE.IMFI_FCCIAS=" 
                        + cmp.trim() + ")";
            listaDoc = this.conn.busqueda(sql, 2);
            if (listaDoc != null) {
                for (String cadDoc : listaDoc) {
                    itemDoc.clear();
                    itemDoc.addAll(Arrays.asList(cadDoc.split("-;-")));
                }
                cantDocSQ = Integer.parseInt(itemDoc.get(0).trim());
            }
            //  Validar documentos pendientes
            if (cantDocIF == 0 && cantDocSQ == 0) {
                sql = "Select " +
                      "       to_char(max(TUNAL.IMFI_FECHA_CIERRE.IMFI_FCFECFACTIF)+1,'YYYY-MM-DD') " +
                      "from   TUNAL.IMFI_FECHA_CIERRE " +
                      "where  TUNAL.IMFI_FECHA_CIERRE.IMFI_FCCIAS=" + cmp.trim();
                listaFec = this.conn.busqueda(sql, 2);
                if (listaFec != null) {
                    for (String cadFec : listaFec) {
                    itemFec.clear();
                    itemFec.addAll(Arrays.asList(cadFec.split("-;-")));
                    }
                    if (!itemFec.isEmpty())
                        try {
                            fechaCProx = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").
                                    parse(itemFec.get(0).trim() + "  00:00:00.0");
                        } catch (ParseException ex) {
                            Logger.getLogger(frmPrincipal.class.getName()).
                                    log(Level.SEVERE, null, ex);
                        }
                }
                if (fechaCProx != null) {
                    if (fechaCProx.before(fecActual) || fechaCProx.equals(fecActual)){
                        if(JOptionPane.showConfirmDialog(this, "Desea realizar el cierre diario del dia " + new SimpleDateFormat("dd-MM-yyyy").
                                            format(fechaCProx).trim() +"?", 
                            "Impresora Fiscal Epson VE - El Tunal C.A.", JOptionPane.OK_CANCEL_OPTION) == 0){
                        //  Apertura del puerto de la impresora fiscal
                        nError = printer.IF_OPEN(puertoImp, String.valueOf(velocidadImp));
                        if (nError == 0) {
                            printer.DailyClose("Z", "");
                        }else{
                            this.jlblNotificacion.setIcon(iconos.getErrorImage());
                            this.jlblNotificacion.setText("Perdida de conexion con la Impresora Fiscal!");
                        }
                        //  Cerrar impresora fiscal
                        nError = printer.IF_ClOSE();
                        if (nError == 0) {
                            sql = "insert into TUNAL.IMFI_FECHA_CIERRE "
                                    + " values(" + cmp.trim() + ",to_date('"
                                    + new SimpleDateFormat("yyyy-MM-dd").
                                            format(fechaCProx).trim() 
                                    + "','YYYY-MM-DD'),sysdate,user)";
                            if (this.conn.ejecutar(sql)) {
                                this.jlblNotificacion.setIcon(iconos.getSuccessImage());
                                this.jlblNotificacion.setText("Se genero el cierre diario Correctamente! Fecha Ult. Cierre: " + new SimpleDateFormat("dd-MM-yyyy").format(fechaCProx));
                                JOptionPane.showMessageDialog(this, "<HTML><BODY><b>Se genero el cierre diario Correctamente!</b><br>"
                                        + "<b>Fecha Ult. Cierre:</b><font color='green'> " 
                                        + new SimpleDateFormat("dd-MM-yyyy").format(fechaCProx).trim()
                                        + "</font><br></BODY></HTML>",
                                "Impresora Fiscal Epson VE - El Tunal C.A.", JOptionPane.INFORMATION_MESSAGE);
                                cal = Calendar.getInstance(); 
                                cal.setTime(fechaCProx); 
                                cal.add(Calendar.DATE, 1);
                                fechaCProx = cal.getTime();
                                sql = "UPDATE co_tctrl " +
                                        "SET ctrl_fecfact = to_date('" + 
                                        new SimpleDateFormat("yyyy-MM-dd").
                                            format(fechaCProx).trim() + 
                                                "','YYYY-MM-DD')," +
                                        "    ctrl_fecmod  = sysdate," +
                                        "    ctrl_usemod  = user," +
                                        "    ctrl_prgmod  = 'INTERFAZ' " +
                                        "WHERE " +
                                        "    ctrl_cias    =" + cmp.trim();
                                this.conn.ejecutar(sql);
                            } else {
                                this.jlblNotificacion.setIcon(iconos.getErrorImage());
                                this.jlblNotificacion.setText("Fallo la conexion con la BD luego de generar el Cierre Diario!");
                                JOptionPane.showMessageDialog(this, "Fallo la conexion con la BD luego de generar el Cierre Diario!", 
                                "Impresora Fiscal Epson VE - El Tunal C.A.", JOptionPane.INFORMATION_MESSAGE);
                            }
                        } else {
                            this.jlblNotificacion.setIcon(iconos.getErrorImage());
                            this.jlblNotificacion.setText("Perdida de conexion con la Impresora Fiscal!");
                            JOptionPane.showMessageDialog(this, "Perdida de conexion con la Impresora Fiscal!", 
                            "Impresora Fiscal Epson VE - El Tunal C.A.", JOptionPane.ERROR_MESSAGE);
                        }
                        }
                    } else {
                        this.jlblNotificacion.setIcon(iconos.getErrorImage());
                        this.jlblNotificacion.setText("Ya realizo el cierre del diario de la fecha: " + new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
                        JOptionPane.showMessageDialog(this, "Ya realizo el cierre del diario de la fecha: " + new SimpleDateFormat("dd-MM-yyyy").format(new Date()), 
                        "Impresora Fiscal Epson VE - El Tunal C.A.", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else {
                if (cantDocIF > 0) {
                    this.jlblNotificacion.setIcon(iconos.getErrorImage());
                    this.jlblNotificacion.setText("Tiene documentos por imprimir en la Impresora Fiscal!");
                    JOptionPane.showMessageDialog(this, "Tiene documentos por imprimir en la Impresora Fiscal!", 
                    "Impresora Fiscal Epson VE - El Tunal C.A.", JOptionPane.ERROR_MESSAGE);
                } else {
                    this.jlblNotificacion.setIcon(iconos.getErrorImage());
                    this.jlblNotificacion.setText("Tiene documentos por imprimir en Siquel!");
                    JOptionPane.showMessageDialog(this, "Tiene documentos por imprimir en Siquel!", 
                    "Impresora Fiscal Epson VE - El Tunal C.A.", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            this.jlblNotificacion.setIcon(iconos.getErrorImage());
            this.jlblNotificacion.setText("Fallo la conexion con la BD!");
        }
    }//GEN-LAST:event_jmenuItemCierreZActionPerformed

    /**
     * Llamar al formulario de configuración de Tarea Programada
     * @param evt 
     */
    private void jmenuItemConfigTareaProgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenuItemConfigTareaProgActionPerformed
        //  Variables
        frmConfig_login vntLogin;
        frmConfig_TareaProg vntTP;
        
        //  Proceso
        jlblNotificacionMouseExited(null);
        //  Proceso - Llamar a formulario ConfigTareaProg
        try {
            vntLogin = new frmConfig_login(this, true, "admin", 
                    this.appC.getPropsControl());
            vntLogin.setVisible(true);
            if (vntLogin.isOk()){
                vntLogin.dispose();
                vntTP = new frmConfig_TareaProg(this, true, 
                        this.appC.getPropsTareaProg());
                vntTP.setVisible(true);
                if (vntTP.isOk()){
                    this.appC.setPropsTareaProg(vntTP.getConfigTareaProg());
                    vntTP.dispose();
                    if (this.appC.escribirConfiguracion(this.appC.getPropsTareaProg(), 
                            this.appC.getRutaConfig().trim()+"appTareaProg.properties", 
                            "TareaProg")){
                        //  Mensaje del sistema
                        this.jlblNotificacion.setIcon(iconos.getSuccessImage());
                        this.jlblNotificacion.setText("Se guardo corrrectamente la configuracion!");
                    } else{
                        this.jlblNotificacion.setIcon(iconos.getErrorImage());
                        this.jlblNotificacion.setText("Fallo la conexion con la BD!");
                    }
                }
            } else {
                this.jlblNotificacion.setIcon(iconos.getWarningImage());
                this.jlblNotificacion.setText("Error en la verificación de los datos");
            }
        } catch (Exception ex) {
            this.jlblNotificacion.setIcon(iconos.getErrorImage());
            this.jlblNotificacion.setText("Fallo la conexion con la BD!");
            Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jmenuItemConfigTareaProgActionPerformed

    /**
     * Llamar al formulario de configuración de Compania y Serie de Doc. Fiscal
     * @param evt 
     */
    private void jmenuItemConfigCPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenuItemConfigCPActionPerformed
        //  Variables
        frmConfig_login vntLogin;
        frmConfig_Compania vntCC;
        
        //  Proceso
        jlblNotificacionMouseExited(null);
        //  Proceso - Llamar a formulario ConfigCompania
        try {
            vntLogin = new frmConfig_login(this, true, "admin", 
                    this.appC.getPropsControl());
            vntLogin.setVisible(true);
            if (vntLogin.isOk()){
                vntLogin.dispose();
                vntCC = new frmConfig_Compania(this, true, 
                        this.appC.getPropsGeneral());
                vntCC.setVisible(true);
                if (vntCC.isOk()){
                    this.appC.setPropsTareaProg(vntCC.getConfigGral());
                    vntCC.dispose();
                    if (this.appC.escribirConfiguracion(this.appC.getPropsGeneral(), 
                            this.appC.getRutaConfig().trim()+"appGeneral.properties", 
                            "General")){
                        //  Mensaje del sistema
                        this.jlblNotificacion.setIcon(iconos.getSuccessImage());
                        this.jlblNotificacion.setText("Se guardo corrrectamente la configuracion!");
                    } else{
                        this.jlblNotificacion.setIcon(iconos.getErrorImage());
                        this.jlblNotificacion.setText("Fallo la conexion con la BD!");
                    }
                }
            } else {
                this.jlblNotificacion.setIcon(iconos.getWarningImage());
                this.jlblNotificacion.setText("Error en la verificación de los datos");
            }
        } catch (Exception ex) {
            this.jlblNotificacion.setIcon(iconos.getErrorImage());
            this.jlblNotificacion.setText("Fallo la conexion con la BD!");
            Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jmenuItemConfigCPActionPerformed

    /**
     * Llamar al formulario de Status Factura
     * @param evt 
     */
    private void jmenuItemStatusFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenuItemStatusFacturaActionPerformed
        //  Variables
        frmEstatusDocumentoFI vntEF;
        
        //  Proceso
        jlblNotificacionMouseExited(null);
        //  Proceso - Llamar a formulario Estatus Factura
        try {
            vntEF = new frmEstatusDocumentoFI(this, true, this.appC.getPropsGeneral());
            vntEF.setVisible(true);
        } catch (Exception ex) {
            this.jlblNotificacion.setIcon(iconos.getErrorImage());
            this.jlblNotificacion.setText("Fallo la conexion con la BD!");
            Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jmenuItemStatusFacturaActionPerformed

    /**
     * Llamar al formulario de cierre de caja
     * @param evt 
     */
    private void jmenuItemCierreXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenuItemCierreXActionPerformed
        //  Variables
        PnpDriverFiscal printer = new PnpDriverFiscal();
        int nError = 0, velocidadImp;
        String puertoImp;
        
        //  Inicializar
        puertoImp = this.appC.getPropsImpFiscal().getProperty("puerto_imp");
        velocidadImp = Integer.parseInt(this.appC.getPropsImpFiscal().
                getProperty("velocidad_imp").trim());

        //  Proceso
        jlblNotificacionMouseExited(null);
        try {
            //  Apertura del puerto de la impresora fiscal
            nError = printer.IF_OPEN(puertoImp, String.valueOf(velocidadImp));
            if (nError == 0) {
                printer.DailyClose("X", "");
                //  Cerrar impresora fiscal
                nError = printer.IF_ClOSE();
            } else {
                this.jlblNotificacion.setIcon(iconos.getErrorImage());
                this.jlblNotificacion.setText("Perdida de conexion con la Impresora Fiscal!");
            }
            if (nError == 0) {
                this.jlblNotificacion.setIcon(iconos.getSuccessImage());
                this.jlblNotificacion.setText("Se genero el cierre de caja Correctamente!");
                JOptionPane.showMessageDialog(this, "Se genero el cierre de caja Correctamente!", 
                "Impresora Fiscal Epson VE - El Tunal C.A.", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception ex) {
            this.jlblNotificacion.setIcon(iconos.getErrorImage());
            this.jlblNotificacion.setText("Error al generar el cierre de caja!");
            Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jmenuItemCierreXActionPerformed

    /**
     * Llamar al formulario de reporte de auditoria
     * @param evt 
     */
    private void jmenuItemReporteAuditoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenuItemReporteAuditoriaActionPerformed
        //  Variables
        frmReporteAuditoria vntRA;
        
        //  Proceso
        jlblNotificacionMouseExited(null);
        //  Proceso - Llamar a formulario Estatus Factura
        try {
            vntRA = new frmReporteAuditoria(this, true, this.appC.getPropsGeneral());
            vntRA.setVisible(true);
        } catch (Exception ex) {
            this.jlblNotificacion.setIcon(iconos.getErrorImage());
            this.jlblNotificacion.setText("Fallo la conexion con la BD!");
            Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jmenuItemReporteAuditoriaActionPerformed

    /**
     * Llamar al formulario de ultimo reporte z impreso y fecha sistema actual
     * @param evt 
     */
    private void jmenuItemUtlReporteZActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenuItemUtlReporteZActionPerformed
        //  Variable
        String sql, cmp;
        List<String> listaFec, itemFec = new ArrayList();
        
        //  Inicializar
        try {
            cmp = this.appC.getPropsGeneral().getProperty("db_empresa").trim();

            //  Proceso
            jlblNotificacionMouseExited(null);
            if (this.conn.isConnOk()) {
                sql = "Select " +
                        "       to_char(max(TUNAL.IMFI_FECHA_CIERRE.IMFI_FCFECFACTIF)+1,'DD-MM-YYYY'), " +
                        "       to_char(max(TUNAL.IMFI_FECHA_CIERRE.IMFI_FCFECFACTIF),'DD-MM-YYYY') " +
                        "from   TUNAL.IMFI_FECHA_CIERRE " +
                        "where  TUNAL.IMFI_FECHA_CIERRE.IMFI_FCCIAS=" + cmp.trim();
                listaFec = this.conn.busqueda(sql, 3);
                if (listaFec != null) {
                    for (String cadFec : listaFec) {
                        itemFec.clear();
                        itemFec.addAll(Arrays.asList(cadFec.split("-;-")));
                    }
                    if (!itemFec.isEmpty())
                        JOptionPane.showMessageDialog(this, "<HTML><BODY><b>Fechas de cierre del sistema</b><br><br>" + 
                                "<b>Fecha actual Siquel: </b><font color='green'>" +itemFec.get(0).trim()+ "</font><br>" + 
                                "<b>Fecha ult Reporte Z: </b><font color='red'>" +itemFec.get(1).trim()+ "</font><br></BODY></HTML>",
                        "Impresora Fiscal Epson VE - El Tunal C.A.", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                this.jlblNotificacion.setIcon(iconos.getErrorImage());
                this.jlblNotificacion.setText("Fallo la conexion con la BD!");
                Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, "Fallo la conexion con la BD!");
            }
        } catch (Exception ex) {
            this.jlblNotificacion.setIcon(iconos.getErrorImage());
                this.jlblNotificacion.setText("Fallo la conexion con la BD!");
                Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jmenuItemUtlReporteZActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JLabel jblStatusImpValor;
    private javax.swing.JComboBox jcmbbEmpresa;
    private javax.swing.JButton jcmdCancelar;
    private javax.swing.JButton jcmdImprimir;
    private javax.swing.JButton jcmdRefrescar;
    private javax.swing.JLabel jlblFechaFactura;
    private javax.swing.JLabel jlblFechaFacturaValor;
    private javax.swing.JLabel jlblInfo;
    private javax.swing.JLabel jlblLogoTunal;
    private javax.swing.JLabel jlblNotificacion;
    private javax.swing.JLabel jlblNroFactura;
    private javax.swing.JLabel jlblNroFacturaValor;
    private javax.swing.JLabel jlblStatusImp;
    private javax.swing.JLabel jlblUsuario;
    private javax.swing.JLabel jlblUsuarioValor;
    private javax.swing.JMenu jmenuAcciones;
    private javax.swing.JMenu jmenuAyuda;
    private javax.swing.JMenuBar jmenuBarSistema;
    private javax.swing.JMenu jmenuHerramientas;
    private javax.swing.JMenuItem jmenuItemAcercaDe;
    private javax.swing.JMenuItem jmenuItemCierreX;
    private javax.swing.JMenuItem jmenuItemCierreZ;
    private javax.swing.JMenuItem jmenuItemConfigCP;
    private javax.swing.JMenuItem jmenuItemConfigDB;
    private javax.swing.JMenuItem jmenuItemConfigIF;
    private javax.swing.JMenuItem jmenuItemConfigTareaProg;
    private javax.swing.JMenuItem jmenuItemConfigVD;
    private javax.swing.JMenuItem jmenuItemImprimir;
    private javax.swing.JMenuItem jmenuItemManualUsuario;
    private javax.swing.JMenuItem jmenuItemRefrescar;
    private javax.swing.JMenuItem jmenuItemReporteAuditoria;
    private javax.swing.JMenuItem jmenuItemSalir;
    private javax.swing.JMenuItem jmenuItemStatusFactura;
    private javax.swing.JMenuItem jmenuItemUtlReporteZ;
    private javax.swing.JMenu jmenuSalir;
    private javax.swing.JPanel jpanelBotones;
    private javax.swing.JPanel jpanelFacturasImpresas;
    private javax.swing.JPanel jpanelFacturasPendientes;
    private javax.swing.JPanel jpanelResultado;
    private javax.swing.JScrollPane jspanelFactHistorial;
    private javax.swing.JScrollPane jspanelFactPendiente;
    private javax.swing.JPopupMenu.Separator jsprAccion;
    private javax.swing.JPopupMenu.Separator jsprHerramienta;
    private javax.swing.JPopupMenu.Separator jsprHerramienta2;
    private javax.swing.JToolBar.Separator jsprMargen;
    private javax.swing.JToolBar.Separator jsprMargen1;
    private javax.swing.JToolBar.Separator jsprMargen2;
    private javax.swing.JTabbedPane jtabPanelFacturas;
    private javax.swing.JTable jtableFactHistorial;
    private javax.swing.JTable jtableFactPendiente;
    private javax.swing.JToolBar jtbarInfo;
    private javax.swing.JToolBar jtbarNotificacion;
    // End of variables declaration//GEN-END:variables

    /*---------------------------------------------------*/
    /*---                  Atributos                  ---*/
    /*---------------------------------------------------*/
    private appConfiguracion appC;
    private OracleConection conn;
    private iconBarraProgreso iconos;
    private DefaultTableModel modeloFact, modeloHist;
    
    /*---------------------------------------------------*/
    /*---             Metodos Set y Get               ---*/
    /*---------------------------------------------------*/
    /**
     * Retorna el objeto de configuracion del sistema
     * @return appC
     */
    public appConfiguracion getAppC() {
        return appC;
    }

    /**
     * Asigna el objeto de configuracion del sistema
     * @param appC 
     */
    public void setAppC(appConfiguracion appC) {
        this.appC = appC;
    }

    /**
     * Retorna el objeto de conexion a BD
     * @return conn
     */
    public OracleConection getConn() {
        return conn;
    }

    /**
     * Asigna el objeto de conexion a BD
     * @param conn 
     */
    public void setConn(OracleConection conn) {
        this.conn = conn;
    }

    /**
     * Retorna el objeto que control la barra de estado del sistema
     * @return iconos
     */
    public iconBarraProgreso getIconos() {
        return iconos;
    }

    /**
     * Asigna el objeto que control la barra de estado del sistema
     * @param iconos 
     */
    public void setIconos(iconBarraProgreso iconos) {
        this.iconos = iconos;
    }

    /**
     * Retorna el objeto contenedor de las facturas a imprimir
     * @return modeloFact
     */
    public DefaultTableModel getModeloFact() {
        return modeloFact;
    }

    /**
     * Asigna el objeto contenedor de las facturas a imprimir
     * @param modeloFact 
     */
    public void setModeloFact(DefaultTableModel modeloFact) {
        this.modeloFact = modeloFact;
    }

    /**
     * Retorna el objeto contenedor del historial de facturas impresas
     * @return modeloHist
     */
    public DefaultTableModel getModeloHist() {
        return modeloHist;
    }

    /**
     * Asigna el objeto contenedor del historial de facturas impresas
     * @param modeloHist 
     */
    public void setModeloHist(DefaultTableModel modeloHist) {
        this.modeloHist = modeloHist;
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
        
        //  Proceso
        try {
            this.jcmbbEmpresa.setVisible(false);
            jcmdRefrescarActionPerformed(null);
            new ProgramadorTarea().iniciarTareas();
        } catch (Exception ex) {
            Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
