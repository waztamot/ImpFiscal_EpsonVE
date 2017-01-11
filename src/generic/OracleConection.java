/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package generic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase para el control de la conexion con BD Oracle
 * @version 1.0
 * @author Ing. Javier Alarcon
 */
public class OracleConection {

    /*---------------------------------------------------*/
    /*---                  Atributos                  ---*/
    /*---------------------------------------------------*/
    private Connection conn;
    private boolean connOk;
    private Properties config;

    /*---------------------------------------------------*/
    /*---               Constructores                 ---*/
    /*---------------------------------------------------*/
    /**
     * Contructor Null de la clase OracleConection
     */
    public OracleConection() {
        this.config = null;
    }
    
    /**
     * Constructor de la clase OracleConection con
     * que recibe como parametro objeto de configuracion
     * @param appC 
     */
    @SuppressWarnings("OverridableMethodCallInConstructor")
    public OracleConection(Properties appC) {
        this.setConfig(appC);
    }
    
    /*---------------------------------------------------*/
    /*---             Metodos Set y Get               ---*/
    /*---------------------------------------------------*/
    /** 
     * Retorna variable de conexion con Oracle
     * @return conn (java.sql.Connection)
     */
    public Connection getConn() {
        return conn;
    }

    /**
     * Asignar variable de conexion con Oracle
     * @param Conn
     */
    public void setConn(Connection Conn) {
        this.conn = Conn;
        try {
            if ((!conn.isClosed()) && (conn.isValid(500)))
                this.connOk = true;
            else{
                this.connOk = false;
                this.conn.close();
                this.conn = null;
            }
        } catch (SQLException ex) {
            this.connOk = false;
            Logger.getLogger(OracleConection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Retorna si la conexion esta establecida o no
     * @return boolean
     */
    public boolean isConnOk() {
        return connOk;
    }

    /**
     * Retorno de objeto de configuracion
     * @return config
     */
    public Properties getConfig() {
        return config;
    }

    /**
     * Asignar objeto de configuracion
     * @param c
     */
    public void setConfig(Properties c) {
        this.config = c;
    }
    
    /*---------------------------------------------------*/
    /*---             Metodos especificos             ---*/
    /*---------------------------------------------------*/
    /**
     * Establecer la conexion con la BD Oracle segun parametros
     * @return OracleConection
     */
    public OracleConection Conectar() {
        try{
            if (this.config.containsKey("db_class_forName")) {
                Class.forName(this.config.getProperty("db_class_forName"));
                String BaseDeDatos = this.config.getProperty("db_string_jdbc");
                conn = DriverManager.getConnection(BaseDeDatos,
                        this.config.getProperty("db_user_jdbc").trim(),
                        this.config.getProperty("db_pass_jdbc").trim());
                if(conn!=null){
                    System.out.println("Conexion exitosa!");
                    this.connOk = true;
                }
                else{
                    System.out.println("Conexion fallida");
                    this.connOk = false;
                }
            }
        }
        catch(SQLException ex) {
            this.connOk = false;
            Logger.getLogger(OracleConection.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (ClassNotFoundException ex) {
            Logger.getLogger(OracleConection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this;
    }
    
    /**
     * Finalizar la conexion con la BD Oracle
     * @return OracleConection
     */
    public OracleConection Desconectar(){
        try{
            this.conn.close();
            this.connOk = false;
        }
        catch(SQLException ex) {
            this.connOk = false;
            Logger.getLogger(OracleConection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this;
    }
    
    /**
     * Realiza una busqueda en la base de datos y retorna el resultado de la 
     * busqueda o el valor null en caso de producirse algun error
     * @param sql
     * @param nroCampos
     * @return resultado
     */
    public List<String> busqueda(String sql, int nroCampos){
        //  Variables
        ResultSet rs = null;
        Statement st = null;
        boolean vl = false;
        List<String> resultado;
        String cad = "";
        
        //  Inicializar
        resultado =  new ArrayList();
        
        //  Proceso
        try{
            if (this.isConnOk()){
                st = this.conn.createStatement();
                rs = st.executeQuery(sql);
                if (rs != null){
                    vl = true;
                    while(rs.next()){
                        cad = "";
                        for (int i = 1; i < nroCampos; i++) {
                            if (rs.getString(i) != null)
                                cad = cad.trim() + rs.getString(i).trim() + "-;-";
                            else
                                cad = cad.trim() + " " + "-;-";
                        }
                        if (!cad.isEmpty())
                            resultado.add(cad);
                    }
                }
            } else
                System.out.println("No conexion");
        } catch(SQLException se){
            se.printStackTrace();
        } finally {
            try{
                if(rs!=null)
                rs.close();
            }catch(SQLException seRs){seRs.printStackTrace();}
            try{
                if(st!=null)
                    st.close();
            }catch(SQLException seSt){seSt.printStackTrace();}
        }
        
        //  Resultado
        if (vl) {
            return resultado;
        } else
            return null;
    }
    
    /**
     * Realiza una sentencia (Insert, Update or Delete) en la base de datos y 
     * retorna el resultado false en caso de producirse algun error de ser 
     * exitosa la sentencia retornara true
     * @param sql
     * @return valido
     */
    public boolean ejecutar(String sql){
        //  Varialbes
        boolean valido = false;
        Statement st = null;
        
        //  Proceso
        try {
            if (this.isConnOk()){
                st = this.conn.createStatement();
                if (st.executeUpdate(sql) != 0)
                    valido = true;
                //this.conn.commit();
            } else
                System.out.println("No conexion");
        } catch(SQLException se){
            se.printStackTrace();
        } finally {
            try{
                if(st!=null)
                    st.close();
            }catch(SQLException seSt){seSt.printStackTrace();}
        }
        
        //  Resultado
        return valido;
    }
}
