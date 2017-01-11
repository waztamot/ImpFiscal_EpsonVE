/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package impfiscal_epsonve;

import forms.frmInicio;
import forms.frmPrincipal;
import generic.OracleConection;
import generic.appConfiguracion;

/**
 * Clase principal para el control y gestion de la app
 * @version 1.0
 * @author Ing. Javier Alarcon
 **/
public class ImpFiscal_EpsonVE {

    /*---------------------------------------------------*/
    /*---                  Atributos                  ---*/
    /*---------------------------------------------------*/
    private boolean ok;
    private appConfiguracion appConfig;
    private OracleConection connOra;

    /*---------------------------------------------------*/
    /*---               Constructores                 ---*/
    /*---------------------------------------------------*/
    /**
     * Constructor null de la clase ImpFiscal_EpsonVE
     */
    @SuppressWarnings("OverridableMethodCallInConstructor")
    public ImpFiscal_EpsonVE() {
        
        this.ok = false;
        this.setAppConfig(new appConfiguracion());
        
        if (this.appConfig.leerConfiguracion())
            ok = true;
    }

    /*---------------------------------------------------*/
    /*---             Metodos Set y Get               ---*/
    /*---------------------------------------------------*/
    /**
     * Retorno status del app
     * @return ok
     */
    public boolean isOk() {
        return this.ok;
    }

    /**
     * Asignar status del app
     * @param ok 
     */
    public void setOk(boolean ok) {
        this.ok = ok;
    }

    /**
     * Retorna objeto de configuracion
     * @return appConfig
     */
    public appConfiguracion getAppConfig() {
        return this.appConfig;
    }

    /**
     * Asignar objeto de configuracion
     * @param appConfig 
     */
    public void setAppConfig(appConfiguracion appConfig) {
        this.appConfig = appConfig;
    }

    /**
     * Retorno objeto de conexion a BD
     * @return connOra
     */
    public OracleConection getConnOra() {
        return this.connOra;
    }

    /**
     * Asignar objeto de conexion a BD
     * @param connOra 
     */
    public void setConnOra(OracleConection connOra) {
        this.connOra = connOra;
    }
    
    /*---------------------------------------------------*/
    /*---                 Metodo MAIN                 ---*/
    /*---------------------------------------------------*/
    @SuppressWarnings("null")
    public static void main(String[] args) {
        // TODO code application logic here
        ImpFiscal_EpsonVE impFiscal = new ImpFiscal_EpsonVE();
        frmInicio vntInicio = null;
        frmPrincipal vntPrincipal = null;
        boolean valido = true;
        
        if (impFiscal.isOk()){
            vntInicio = new frmInicio();
            vntInicio.setAppConfig(impFiscal.getAppConfig());
            vntInicio.setVisible(true);
        }
        
        while ((impFiscal.isOk()) && (valido == true)){
            
            if (!vntInicio.isVisible()){
                impFiscal.connOra = vntInicio.getConnOra();
                impFiscal.appConfig = vntInicio.getAppConfig();
                vntPrincipal = new frmPrincipal(impFiscal.appConfig, 
                        impFiscal.connOra);
                vntPrincipal.setVisible(true);
                valido = false;
            }
            
        }
    }

}