/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package progTareaImpFiscal;

import IFDrivers.PnpDriverFiscal;
import generic.OracleConection;
import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * Clase para el control de la Impresion en ImpFiscal (Tarea Programada)
 * @version 1.0
 * @author Ing. Javier Alarcon
 */
public class ImprimirIF implements Job {
    
    /*---------------------------------------------------*/
    /*---                  Atributos                  ---*/
    /*---------------------------------------------------*/
    
    /*---------------------------------------------------*/
    /*---               Constructores                 ---*/
    /*---------------------------------------------------*/
    
    /*---------------------------------------------------*/
    /*---             Metodos Set y Get               ---*/
    /*---------------------------------------------------*/

    /*---------------------------------------------------*/
    /*---             Metodos especificos             ---*/
    /*---------------------------------------------------*/
    /**
     * Metodo para la ejecucion de la tarea programada
     * @param jec
     * @throws JobExecutionException
     */
    @Override
    public void execute(JobExecutionContext jec) throws JobExecutionException {
        //  Variables Internas
        Properties appGral = new Properties(), appIF = new Properties(),
                   appTPrg = new Properties();
        OracleConection oc;
        String  sql, fechaImp, puertoIF, nroImp, serialImp = "", 
                fechaNC = "", tareaProg = "", ivaNC = "0000";
        int velcIF, nError = 0, cabecera;
        List<String> listaFecha, itemFecha = new ArrayList();
        List<String> listaDatos, itemDatos = new ArrayList();
        List<String> listaFact,  itemFact  = new ArrayList();
        List<String> listaNC,    itemNC    = new ArrayList();
        List<String> listaEx,    itemEx    = new ArrayList();
        List<String> listaVl,    itemVl    = new ArrayList();
        PnpDriverFiscal printer;
        double montoNC = 0;
        Date date;
        DateFormat hourdateFormat;
        
        //  Proceso
        try{
            //  Codigo para archivo de configuracion
            String rutPGeneral      = "src/config/appGeneral.properties";
            String rutPImpFisc      = "src/config/impFiscal.properties";
            String rutPTarProg      = "src/config/appTareaProg.properties";
            appGral.load(new FileInputStream(rutPGeneral));
            appIF.load(new FileInputStream(rutPImpFisc));
            appTPrg.load(new FileInputStream(rutPTarProg));
            //  Verificamos si esta activa la tareaPrograma entre los parametros del sistema
            if (appTPrg.getProperty("tp_ejecutar").trim().
                    equalsIgnoreCase("S")){
                puertoIF = appIF.getProperty("puerto_imp");
                velcIF = Integer.parseInt(appIF.getProperty("velocidad_imp").trim());
                printer = new PnpDriverFiscal();
                oc = new OracleConection(appGral);
                oc.Conectar();
                if (oc.isConnOk()){
                    //  Verificamos que no exista una tarea ejecutandose actualmente
                    sql = "select  IMFI_TPSTAT,IMFI_TPFECEJC " +
                            "from    IMFI_TAREA_PROG " +
                            "where   IMFI_TPFECEJC=(" +
                            "    select max(IMFI_TPFECEJC) " +
                            "    from IMFI_TAREA_PROG) " +
                            "and IMFI_TPCIAS =" + appGral.getProperty("db_empresa").trim();
                    listaVl = oc.busqueda(sql, 3);
                    if (listaVl != null) {
                        for (String cadVl : listaVl) {
                            itemVl.clear();
                            itemVl.addAll(Arrays.asList(cadVl.split("-;-")));
                        }
                        if (!itemVl.isEmpty())
                            tareaProg = itemVl.get(0).trim();
                    }
                    if (!tareaProg.trim().equalsIgnoreCase("N")){
                        //  Inicio del proceso
                        if (oc.ejecutar("insert into IMFI_TAREA_PROG values(" + appGral.
                                      getProperty("db_empresa").trim() + ",sysdate,'N')")) {
                        //  Fecha de facturas pendientes Impresiones Pendientes
                        sql = "SELECT TO_char(MAX(IMFI_FCFECFACTIF)+1,'yyyy-mm-dd')" +
                              "    FROM    IMFI_FECHA_CIERRE" +
                              "    WHERE   IMFI_FCCIAS =" + appGral.
                                      getProperty("db_empresa").trim();
                        listaFecha = oc.busqueda(sql, 2);
                        if (listaFecha != null) {
                            for (String cadFecha : listaFecha) {
                                itemFecha.clear();
                                itemFecha.addAll(Arrays.asList(cadFecha.split("-;-")));
                            }
                            if (!itemFecha.isEmpty()){
                                //  Asignamos fecha de busqueda de facturas
                                fechaImp = itemFecha.get(0).trim();
                                //  Impresiones Pendientes
                                sql = "select * from IMFI_DATA_H where IMFI_STAT1 <> 'P' "
                                + "and IMFI_CIAS = " + appGral.getProperty("db_empresa").trim()
                                + " and IMFI_FECFACT=TO_DATE('"+ fechaImp.trim()+"',"
                                + "'YYYY-MM-DD') order by 24";
                                listaDatos = oc.busqueda(sql, 24);
                                if (listaDatos != null) {
                                    for (String cadDatos : listaDatos) {
                                        itemDatos.clear();
                                        itemDatos.addAll(Arrays.asList(cadDatos.split("-;-")));
                                        //  Apertura del puerto de la impresora fiscal
                                        nError = printer.IF_OPEN(puertoIF, String.valueOf(velcIF).trim());
                                        if (!itemDatos.isEmpty() && nError == 0){  
                                            //  Completamos los datos de la factura
                                            sql = "SELECT "         +
                                                "    CTDF_CIAS,"    +
                                                "    SUBSTR(CTDF_DESCRIC,1,36),"    +
                                                "    SUBSTR(CTDF_NRORIF,1,12),"     +
                                                "    SUBSTR(MVDF_DESCRII,1,36),"    +
                                                "    LPAD((RTRIM(LTRIM(TO_CHAR(mvdf_ctddoc,'9999.999')))),7,0)," +
                                                "    LPAD((RTRIM(LTRIM(TO_CHAR(mvdf_prcunim,'99999999.99')))),11,0)," +
                                                //"    REPLACE((mvdf_porimp/100),',','.'),"   +
                                                //"    REPLACE(TO_CHAR(mvdf_porimp,'99.99'),'.','')," +
                                                "    DECODE(mvdf_porimp,0,'0000',REPLACE(TO_CHAR(mvdf_porimp,'99.99'),'.',''))," +
                                                "    SUBSTR(CTDF_DIRECC1, 1,40)||SUBSTR(CTDF_DIRECC2, 1,8)," +
                                                "    RPAD(funciontele(ctdf_clie),48),"      +
                                                "    CTDF_NRODOC,"  +
                                                "    CTDF_TPDC,"    +
                                                "    CTDF_SERIEFC," +
                                                "    CTDF_TPDCFAC," +
                                                "    CTDF_NROFAC,"  +
                                                "    CTDF_OBSERV1||SUBSTR(CTDF_OBSERV2,1,8)," +
                                                "    MVDF_MTIN "    +
                                                " FROM CO_TCTDFAC, co_tmvdfac" +
                                                " WHERE   CTDF_NRODOC ="    + itemDatos.get(7).trim()   +
                                                "    AND CTDF_CIAS    ="    + itemDatos.get(0).trim()   +
                                                "    AND CTDF_SERIEDC ='"   + itemDatos.get(6).trim()   + "'" +
                                                "    AND CTDF_TPDC    ='"   + itemDatos.get(5).trim()   + "'" +
                                                "    AND    mvdf_cias    =    ctdf_cias" +
                                                "    AND    mvdf_tpdc    =    ctdf_tpdc" +
                                                "    AND    mvdf_seriedc =    ctdf_seriedc" +
                                                "    AND    mvdf_nrodoc  =    ctdf_nrodoc";
                                            listaFact = oc.busqueda(sql, 17);
                                            cabecera = 0;
                                            for (String cadFact : listaFact) {
                                                itemFact.clear();
                                                itemFact.addAll(Arrays.asList(cadFact.split("-;-")));
                                                if (cabecera == 0){
                                                    if (itemDatos.get(5).trim().equalsIgnoreCase("FC")){
                                                        printer.OpenFiscalReceipt(itemFact.get(1).
                                                                trim(), 
                                                                itemFact.get(2).trim(), "", "", "", 
                                                                "", "", "", "");
                                                    } else {
                                                        sql = "Select IMFI_NROFACIF,"
                                                                + "IMFI_FECFACTIF,"
                                                                + "IMFI_CTRSENIF,"
                                                                + "SUM((mvdf_prcunim * mvdf_ctddoc) * (1+(mvdf_porimp/100)))" +
                                                              " from"  +
                                                                "    IMFI_DATA_H,co_tmvdfac " +
                                                              " where" +
                                                                "     IMFI_CIAS    ="  + itemDatos.get(0).trim() +
                                                                " and IMFI_TPDC    = 'FC'" +
                                                                " and IMFI_SERIEDC ='" + itemFact.get(11).trim() + "'" +
                                                                " and IMFI_NRODOC  ="  + itemFact.get(13).trim() +
                                                                " and mvdf_cias   = IMFI_CIAS" +
                                                                " and mvdf_tpdc   = IMFI_TPDC" +
                                                                " and mvdf_seriedc = IMFI_SERIEDC" +
                                                                " and mvdf_nrodoc  = IMFI_NRODOC"  +
                                                              " group by IMFI_NROFACIF,IMFI_FECFACTIF,IMFI_CTRSENIF";
                                                        listaNC = oc.busqueda(sql, 5);
                                                        if (listaNC != null) {
                                                            for (String cadNC : listaNC) {
                                                                itemNC.clear();
                                                                itemNC.addAll(Arrays.asList(cadNC.split("-;-")));
                                                            }
                                                            if (!itemNC.isEmpty()){
                                                                fechaNC = itemNC.get(1).trim().substring(8,10) + 
                                                                        "/" + itemNC.get(1).trim().substring(5,7) +
                                                                        "/" + itemNC.get(1).trim().substring(2,4);
                                                                printer.OpenFiscalReceipt(itemFact.get(1).trim(),
                                                                        itemFact.get(2).trim(), itemNC.get(0).trim(), itemNC.get(2).trim(),
                                                                        fechaNC.trim(), itemNC.get(1).trim().substring(11,16),
                                                                        "D", "", "");
                                                            }
                                                        }
                                                    }
                                                }
                                                cabecera++;
                                                sql = "select mtin_cndexc from co_tmtin" +
                                                      " where mtin_cias = "  + itemDatos.get(0).trim() +
                                                      "   and mtin_mtin = '" + itemFact.get(15).trim() +  "'";
                                                listaEx = oc.busqueda(sql, 2);
                                                if (listaEx != null){
                                                    for (String cadEx : listaEx) {
                                                        itemEx.clear();
                                                        itemEx.addAll(Arrays.asList(cadEx.split("-;-")));
                                                    }
                                                    if (!itemEx.isEmpty()){
                                                        if (itemEx.get(0).trim().equalsIgnoreCase("S"))
                                                            itemFact.set(3, itemFact.get(3).trim() + " (E)");
                                                    }
                                                }
                                                if (itemDatos.get(5).trim().equalsIgnoreCase("NC")) {
                                                    montoNC = montoNC + Double.
                                                            valueOf(itemFact.get(5).trim());
                                                    ivaNC   = itemFact.get(6).trim();
                                                } else {
                                                    printer.PrintLineItem(itemFact.get(3).trim(), 
                                                        itemFact.get(4).trim(),
                                                        itemFact.get(5).trim(),
                                                        itemFact.get(6).trim(),
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
                                            if (itemDatos.get(5).trim().equalsIgnoreCase("NC")) {
                                                printer.PrintLineItem("Descuento en Precio", 
                                                    "1.00",
                                                    String.valueOf(montoNC),ivaNC,"M", "", "", "");
                                            }
                                            printer.CloseFiscalReceipt("A");
                                            //printer.PrintFiscalText("Barquisimeto", "S");
                                            if (!itemDatos.get(5).trim().equalsIgnoreCase("FC")){
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
                                                        + "where IMFI_NRODOC ="   + itemDatos.get(7).trim() +
                                                        "    AND IMFI_CIAS ="     + itemDatos.get(0).trim() +
                                                        "    AND IMFI_SERIEDC ='" + itemDatos.get(6).trim() + "'" +
                                                        "    AND IMFI_TPDC = '"   + itemDatos.get(5).trim() + "'";
                                                oc.ejecutar(sql);
                                            } else {
                                                oc.ejecutar("update IMFI_DATA_H set"
                                                        + " IMFI_STAT1 = 'E' where " +
                                                        "IMFI_NRODOC = "          + itemDatos.get(7).trim() +
                                                        "    AND IMFI_CIAS ="     + itemDatos.get(0).trim() +
                                                        "    AND IMFI_SERIEDC ='" + itemDatos.get(6).trim() + "'" +
                                                        "    AND IMFI_TPDC = '"   + itemDatos.get(5).trim() + "'");
                                            }
                                        }
                                        nError = printer.IF_ClOSE();
                                    }
                                }
                            }
                        }
                        if (nError == 0)
                            oc.ejecutar("update IMFI_TAREA_PROG set IMFI_TPSTAT='P' " +
                                    "where  IMFI_TPFECEJC=(" +
                                    "    select max(IMFI_TPFECEJC)  " +
                                    "    from IMFI_TAREA_PROG ) and " +
                                    "IMFI_TPCIAS =" + appGral.
                                      getProperty("db_empresa").trim());
                        else
                            oc.ejecutar("update IMFI_TAREA_PROG set IMFI_TPSTAT='E' " +
                                    "where  IMFI_TPFECEJC=(" +
                                    "    select max(IMFI_TPFECEJC)  " +
                                    "    from IMFI_TAREA_PROG ) and " +
                                    "IMFI_TPCIAS =" + appGral.
                                      getProperty("db_empresa").trim());                    
                        }
                    } else 
                        System.out.println("Proceso activo");
                }
                oc.Desconectar();
                System.out.println("Proceso de Fondo!!!");
                System.out.println(new java.util.Date().toString());
            }
            appGral.clear();            
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
}
 