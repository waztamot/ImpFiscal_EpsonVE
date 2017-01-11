/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package generic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Clase para el control de la configuracion del sistema
 * @version 1.0
 * @author Ing. Javier Alarcon
 */
public class appConfiguracion {
    
    /*---------------------------------------------------*/
    /*---                  Atributos                  ---*/
    /*---------------------------------------------------*/
    private String       rutaConfig;
    private Properties   propsControl;
    private Properties   propsGeneral;
    private Properties   propsImpFiscal;
    private Properties   propsTareaProg;
    
    /*---------------------------------------------------*/
    /*---               Constructores                 ---*/
    /*---------------------------------------------------*/
    /**
     * Constructor null de la clase appConfiguracion
     * @see 
     */
    public appConfiguracion(){
        this.setRutaConfig("src/config/");
        this.propsControl   = new Properties();
        this.propsGeneral   = new Properties();
        this.propsImpFiscal = new Properties();
        this.propsTareaProg = new Properties();
    }

    /**
     * Constructor con ruta de la clase appConfiguracion
     * @param ruta
     */
    public appConfiguracion(String ruta){
        this.setRutaConfig(ruta.trim());
        this.propsControl   = new Properties();
        this.propsGeneral   = new Properties();
        this.propsImpFiscal = new Properties();
        this.propsTareaProg = new Properties();
    }

    /**
     * Constructor con ruta y archivos de config de la clase appConfiguracion
     * @param ruta
     * @param control
     * @param general
     * @param impFiscal
     * @param tareaProg
     */ 
    public appConfiguracion(String ruta, Properties control, 
                                    Properties general, Properties impFiscal,
                                    Properties tareaProg){
        this.setRutaConfig(ruta.trim());
        this.propsControl   = control;
        this.propsGeneral   = general;
        this.propsImpFiscal = impFiscal;
        this.propsTareaProg = tareaProg;
    }

    /*---------------------------------------------------*/
    /*---             Metodos Set y Get               ---*/
    /*---------------------------------------------------*/
    /**
     * Retorna archivo (properties) de config Control
     * @return propsControl
     */
    public Properties getPropsControl() {
        return propsControl;
    }

    /**
     * Asigna el archivo (properties) de config. Control
     * @param aPropsControl 
     */
    public void setPropsControl(Properties aPropsControl) {
        propsControl = aPropsControl;
    }

    /**
     * Retorna archivo (properties) de config General
     * @return propsGeneral
     */
    public Properties getPropsGeneral() {
        return propsGeneral;
    }

    /**
     * Asigna el archivo (properties) de config. General
     * @param aPropsGeneral
     */
    public void setPropsGeneral(Properties aPropsGeneral) {
        propsGeneral = aPropsGeneral;
    }

    /**
     * Retorna archivo (properties) de config ImpFiscal
     * @return propsImpFiscal
     */
    public Properties getPropsImpFiscal() {
        return propsImpFiscal;
    }

    /**
     * Asigna el archivo (properties) de config. ImpFiscal
     * @param aPropsImpFiscal
     */
    public void setPropsImpFiscal(Properties aPropsImpFiscal) {
        propsImpFiscal = aPropsImpFiscal;
    }

    /**
     * Retorna la ruta de configuracion estandar
     * @return rutaConfig
     */
    public String getRutaConfig() {
        return rutaConfig;
    }

    /**
     * Asigna la ruta de configuracion estandar
     * @param rutaConfig 
     */
    private void setRutaConfig(String rutaConfig) {
        this.rutaConfig = rutaConfig;
    }

    /**
     * Retorna el archivo (properties) de config. Tarea Programada
     * @return propsTareaProg
     */
    public Properties getPropsTareaProg() {
        return propsTareaProg;
    }

    /**
     * Asigna el archivo (properties) de config. Tarea Programada
     * @param propsTareaProg 
     */
    public void setPropsTareaProg(Properties propsTareaProg) {
        this.propsTareaProg = propsTareaProg;
    }
    
    /*---------------------------------------------------*/
    /*---             Metodos especificos             ---*/
    /*---------------------------------------------------*/
    /**
     * Leer la configuracion estandar de los archivos
     * @return ok
     */
    public boolean leerConfiguracion(){
        //  Proceso
        try {
            // Codigo para appControl
            String rutPControl      = rutaConfig.trim() + "appControl.properties";
            propsControl.load(new FileInputStream(rutPControl));
            
            // Codigo para appGeneral
            String rutPGeneral      = rutaConfig.trim() + "appGeneral.properties";
            propsGeneral.load(new FileInputStream(rutPGeneral));
            
            // Codigo para appImpFiscal
            String rutPImpFiscal    = rutaConfig.trim() + "impFiscal.properties";
            propsImpFiscal.load(new FileInputStream(rutPImpFiscal));
            
            // Codigo para appTareaProg
            String rutPTareaProg    = rutaConfig.trim() + "appTareaProg.properties";
            propsTareaProg.load(new FileInputStream(rutPTareaProg));
            
            return true;
        } catch (IOException ex) {
            System.out.println("Error: "+ex);
            return false;
        }
    }

    /**
     * Lee el archivo de configuracion de la ruta especifica
     * @param ruta
     * @return props
     */
    public Properties leerConfiguracion(String ruta){
        //  Proceso
        try {
            Properties props =  new Properties();
            props.load(new FileInputStream(ruta));
            return props;
        } catch (IOException ex) {
            System.out.println("Error: "+ex);
            return null;
        }
    }

    /**
     * Lee la configuracion de un archivo y una ruta en especifico
     * @param props
     * @param ruta
     * @return ok
     */
    public boolean leerConfiguracion(Properties props, String ruta){
        //  Proceso
        try {
            props.load(new FileInputStream(ruta));
            return true;
        } catch (IOException ex) {
            System.out.println("Error: "+ex);
            return false;
        }
    }

    /**
     * Guarda los datos en los archivos de configuracion estandar
     * @return ok
     */
    public boolean escribirConfiguracion(){
        //  Variables
        String titulo = "Configuracion de Aplicacion" + " - ";
        
        //  Proceso
        try {
            // Codigo para guardar archivo appControl
            String rutPControl      = rutaConfig.trim() + "appControl.properties";
            propsControl.store(new FileOutputStream(rutPControl), titulo + "Control");
            
            // Codigo para guardar archivo appGeneral
            String rutPGeneral      = rutaConfig.trim() + "appGeneral.properties";
            propsGeneral.store(new FileOutputStream(rutPGeneral), titulo + "General");
            
            // Codigo para guardar archivo appImpFiscal
            String rutPImpFiscal    = rutaConfig.trim() + "impFiscal.properties";
            propsImpFiscal.store(new FileOutputStream(rutPImpFiscal), titulo + "ImpFiscal");
            
            // Codigo para guardar archivo appTareaProg
            String rutPTareaProg    = rutaConfig.trim() + "appTareaProg.properties";
            propsTareaProg.store(new FileOutputStream(rutPTareaProg), titulo + "TareaProg");
            return true;
        } catch (IOException ex) {
            System.out.println("Error: "+ex);
            return false;
        }
    }

    /**
     * Guarda el archivo de configuracion segun una ruta en especifico
     * @param props
     * @param ruta
     * @param titulo
     * @return ok
     */
    public boolean escribirConfiguracion(Properties props, String ruta,
                                                String titulo){
        //  Variables
        String var = "Configuracion de Aplicacion" + " - " + titulo.trim();
        
        //  Proceso
        try {
            //  Codigo para guardar archivo
            props.store(new FileOutputStream(ruta), var);
            return true;
        } catch (IOException ex) {
            System.out.println("Error: "+ex);
            return false;
        }
    }

}
