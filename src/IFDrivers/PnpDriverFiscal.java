/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package IFDrivers;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Platform;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Clase para el control de la conexion con la impresora fiscal
 * @version 1.0
 * @author Ing. Javier Alarcon
 */
public class PnpDriverFiscal {
    
    /*---------------------------------------------------*/
    /*---                  Atributos                  ---*/
    /*---------------------------------------------------*/
    private pnpDLL pnpdll;
    
    /*---------------------------------------------------*/
    /*---                 Interfaces                  ---*/
    /*---------------------------------------------------*/
    /**
     * Cargar libreria dll para conexion con la impresora fiscal.<br><br>
     * Modelo:<br>
     *      PF-220.<br>
     *      PF-675.<br>
     *      PF-300.<br>
     *      PF300-II.<br>
     */
    public interface pnpDLL extends Library {
        pnpDLL INSTANCE = (pnpDLL) Native.loadLibrary(
            (Platform.isWindows() ? "pnpdll" : "pnpdlltest"), pnpDLL.class);
        /**
         * Inicia documento fiscal.<br><br>
         * Parametros:<br>
         *      Razón Social: Sttring de maximo 80 caracteres (De ser 
         *          mayor es truncado automaticamente).<br>
         *      RIF: String de maximo 12 caracteres.<br><br>
         * Resultados: (String)<br>
         *      OK: Transmision/recepcion fue correcta.<br>
         *      ER: Existe un error.<br>
         *      NP: Puerto No Abuerto.<br>
         *      TO: Se exceddio el tiempo de respuesta esperado del equipo.<br>
         * @param Razon (String)
         * @param RIF   (String)
         * @return String {OK|ER|NP|TO}
         */
        String PFabrefiscal(String Razon, String RIF);

        /**
         * Genera el final de una factura, imprime el total si este no fue generado
         *  por un comando parcial y corta el papel.<br><br>
         * Parametros:<br>
         *      Ninguno.<br><br>
         * Resultados:  (String)<br>
         *      OK: Transmision/recepcion fue correcta.<br>
         *      ER: Existe un error.<br>
         *      NP: Puerto No Abuerto.<br>
         *      TO: Se exceddio el tiempo de respuesta esperado del equipo.<br>
         * @return String {OK|ER|NP|TO}
         */
        String PFtotal();

        /**
         * Genera un reporte de cierre diario o reporte Z.<br><br>
         * Parametros:<br>
         *      Ninguno.<br><br>
         * Resultados:  (String)<br>
         *      OK: Transmision/recepcion fue correcta.<br>
         *      ER: Existe un error.<br>
         *      NP: Puerto No Abuerto.<br>
         *      TO: Se exceddio el tiempo de respuesta esperado del equipo.<br>
         * @return String {OK|ER|NP|TO}
         */
        String PFrepz();

        /**
         * Genera un reporte x en el equipo.<br><br>
         * Parametros:<br>
         *      Ninguno.<br><br>
         * Resultados:  (String)<br>
         *      OK: Transmision/recepcion fue correcta.<br>
         *      ER: Existe un error.<br>
         *      NP: Puerto No Abuerto.<br>
         *      TO: Se exceddio el tiempo de respuesta esperado del equipo.<br>
         * @return String {OK|ER|NP|TO}
         */
        String PFrepx();

        /**
         * Envia un renglon (item o producto) de la factura.<br><br>
         * Parametros:<br>
         *      Descripcion: String Texto descriptivo del producto. El largo maximo 
         *          para el modelo PF-220 es de 20 caracteres y 40 para la PF-300.<br>
         *      cantidad:    String Cantidad a facturar en formato numerico con 
         *          punto decimal de maximo 3 decimales. (Importante que solo 
         *          contenga punto como simbolo decimal y no coma).<br>
         *      monto:       String Monto unitario sin impuesto del producto 
         *          numerico con punto decimal. (Importante que solo contenga punto
         *          como simbolo decimal y no coma).<br>
         *      iva:         String Valor del porcentaje de IVA a calcular en el 
         *          formato EEDD (debe coincidir con el registrado en el equipo)
         *          tamaño de 4 caracteres. Ejemplo: 0000 1200 0800<br><br>
         * Resultados:  (String)<br>
         *      OK: Transmision/recepcion fue correcta.<br>
         *      ER: Existe un error.<br>
         *      NP: Puerto No Abuerto.<br>
         *      TO: Se exceddio el tiempo de respuesta esperado del equipo.<br>
         * @param Descripcion   (String)
         * @param cantidad      (String)
         * @param monto         (String)
         * @param iva           (String)
         * @return String {OK|ER|NP|TO}
         */
        String PFrenglon(String Descripcion, String cantidad, 
               String monto, String iva);

        /**
         * Abre puerto serial fisico del equipo para comunicacion con impresora.<br>
         * Debe ser ejecutado una sola vez.<br><br>
         * Parametros:<br>
         *      numero: String Numero de puerto ejemplo: 1, 2, 3, 4.<br><br>
         * Resultados:  (String)<br>
         *      OK: Transmision/recepcion fue correcta.<br>
         *      ER: Existe un error.<br>
         *      NP: Puerto No Abuerto.<br>
         *      TO: Se exceddio el tiempo de respuesta esperado del equipo.<br>
         * @param numero    (String)
         * @return String {OK|ER|NP|TO}
         */
        String PFabrepuerto(String numero);

        /**
         * Cierra puerto fisico de comunicacion con la impresora.<br><br>
         * Parametros:<br>
         *      Ninguno.<br><br>
         * Resultados:  (String)<br>
         *      OK: Transmision/recepcion fue correcta.<br>
         *      ER: Existe un error.<br>
         *      TO: Se exceddio el tiempo de respuesta esperado del equipo.<br>
         * @return String {OK|ER|TO}
         */
        String PFcierrapuerto();

        /**
         * Genera texto en el visor del cliente conectado en los modelos de equipo
         *  compatibles. (Modelo PF-950)<br><br>
         * Parametros:<br>
         *      edlinea: String Linea de texto a enviar.<br><br>
         * Resultados:  (String)<br>
         *      OK: Transmision/recepcion fue correcta.<br>
         *      ER: Existe un error.<br>
         *      NP: Puerto No Abuerto.<br>
         *      TO: Se exceddio el tiempo de respuesta esperado del equipo.<br>
         * @param edlinea (String)
         * @return String {OK|ER|NP|TO}
         */
        String PFDisplay950(String edlinea);

        /**
         * Inicia documento no fiscal.<br><br>
         * Parametros:<br>
         *      ninguno.<br><br>
         * Resultados: (String)<br>
         *      OK: Transmision/recepcion fue correcta.<br>
         *      ER: Existe un error.<br>
         *      NP: Puerto No Abuerto.<br>
         *      TO: Se exceddio el tiempo de respuesta esperado del equipo.<br>
         * @return String {OK|ER|NP|TO}
         */
        String PFAbreNF();

        /**
         * Envia una linea de texto en documentos no fiscales.<br><br>
         * Parametros:<br>
         *      edlinea: String Texto de linea no fiscal a generar.
         *          (80 caracteres para modelo PF-300 y 40 caracteres para el resto)
         *          Si se envia un texto de mayor tamaño sera truncado.<br><br>
         * Resultados:  (String)<br>
         *      OK: Transmision/recepcion fue correcta.<br>
         *      ER: Existe un error.<br>
         *      NP: Puerto No Abuerto.<br>
         *      TO: Se exceddio el tiempo de respuesta esperado del equipo.<br>
         * @param edlinea
         * @return String {OK|ER|NP|TO}
         */
        String PFLineaNF(String edlinea);

        /**
         * Cierra documento no fiscal.<br><br>
         * Parametros:<br>
         *      ninguno.<br><br>
         * Resultados:  (String)<br>
         *      OK: Transmision/recepcion fue correcta.<br>
         *      ER: Existe un error.<br>
         *      NP: Puerto No Abuerto.<br>
         *      TO: Se exceddio el tiempo de respuesta esperado del equipo.<br>
         * @return String {OK|ER|NP|TO}
         */
        String PFCierraNF();

        /**
         * Envia comando corte de papel para equipos compatibles.<br><br>
         * Parametros:<br>
         *      Ninguno.<br><br>
         * Resultados:  (String)<br>
         *      OK: Transmision/recepcion fue correcta.<br>
         *      ER: Existe un error.<br>
         *      NP: Puerto No Abuerto.<br>
         *      TO: Se exceddio el tiempo de respuesta esperado del equipo.<br>
         * @return String {OK|ER|NP|TO}
         */
        String PFCortar();

        /**
         * Envia una linea de texto fiscal al equipo. <br>Estas lineas se pueden usar: <br>
         *  4 al inicio del documento fiscal. <br>
         *  3 entre cada producto.<br>
         *  20 al final de la factura despues de un cierre parcial.<br><br>
         * Parametros:<br>
         *      edlinea: String Linea de texto fiscal a generar.<br><br>
         * Resultados:  (String)<br>
         *      OK: Transmision/recepcion fue correcta.<br>
         *      ER: Existe un error.<br>
         *      NP: Puerto No Abuerto.<br>
         *      TO: Se exceddio el tiempo de respuesta esperado del equipo.<br>
         * @param edlinea   (String)
         * @return String {OK|ER|NP|TO}
         */
        String PFTfiscal(String edlinea);

        /**
         * Genera un cierre parcial de documento fiscal tipo factura y NC.<br>
         *  Despues de ejecutado este comando toda la informacion de la <br>
         *  factura es almacenada en la memoria fiscal.<br><br>
         * Parametros:<br>
         *      Ninguno.<br><br>
         * Resultados:  (String)<br>
         *      OK: Transmision/recepcion fue correcta.<br>
         *      ER: Existe un error.<br>
         *      NP: Puerto No Abuerto.<br>
         *      TO: Se exceddio el tiempo de respuesta esperado del equipo.<br>
         * @return String {OK|ER|NP|TO}
         */
        String PFparcial();

        /**
         * Solicita el serial del equipo.<br>
         *  Se debe ejecutar el comando PFultimo() para obtener su valor.<br><br>
         * Parametros:<br>
         *      Ninguno.<br><br>
         * Resultados:  (String)<br>
         *      OK: Transmision/recepcion fue correcta.<br>
         *      ER: Existe un error.<br>
         *      NP: Puerto No Abuerto.<br>
         *      TO: Se exceddio el tiempo de respuesta esperado del equipo.<br>
         * @return String {OK|ER|NP|TO}
         * @see PFultimo
         */
        String PFSerial();

        /**
         * Igual que el total pero mientras avanza para el corte de papel genera el
         *  encabezado de la proxima factura para ahorrar papel.<br><br>
         * Parametros:<br>
         *      Ninguno.<br><br>
         * Resultados:  (String)<br>
         *      OK: Transmision/recepcion fue correcta.<br>
         *      ER: Existe un error.<br>
         *      NP: Puerto No Abuerto.<br>
         *      TO: Se exceddio el tiempo de respuesta esperado del equipo.<br>
         * @return String {OK|ER|NP|TO}
         */
        String PFtoteconomico();

        /**
         * Cancela la emision del documento activo actual.<br>
         *  Genera el texto en la impresora de documento cancelado.<br><br>
         * Parametros:<br>
         *      edlinea:    String Comando de cancelacion de documento {C}<br>
         *      monto:      String Monto parametro {0}<br><br>
         * Resultados:  (String)<br>
         *      OK: Transmision/recepcion fue correcta.<br>
         *      ER: Existe un error.<br>
         *      NP: Puerto No Abuerto.<br>
         *      TO: Se exceddio el tiempo de respuesta esperado del equipo.<br>
         * @param edlinea   (String)
         * @param monto     (String)
         * @return String {OK|ER|NP|TO}
         */
        String PFCancelaDoc(String edlinea, String monto);

        /**
         * Abre gaveta de dinero conectada al equipo.<br><br>
         * Parametros:<br>
         *      Ninguno.<br><br>
         * Resultados:  (String)<br>
         *      OK: Transmision/recepcion fue correcta.<br>
         *      ER: Existe un error.<br>
         *      NP: Puerto No Abuerto.<br>
         *      TO: Se exceddio el tiempo de respuesta esperado del equipo.<br>
         * @return String {OK|ER|NP|TO}
         */
        String PFGaveta();

        /**
         * Abre documento fiscal de nota de credito/devolucion.<br><br>
         * Parametros:<br>
         *      razon: String Nombre de la razon social.<br>
         *      rif:   String Numero de RIF sin espacios ni guiones del cliente.<br>
         *      comp:  String Numero de factura objeto de la nota de credito.<br>
         *      maqui: String Serial del equipo fiscal que genero la factura.<br>
         *      fecha: String fecha de la factura original en formato DDMMAA.<br>
         *      hora:  String hora en formato HHMM.<br><br>
         * Resultados:  (String)<br>
         *      OK: Transmision/recepcion fue correcta.<br>
         *      ER: Existe un error.<br>
         *      NP: Puerto No Abuerto.<br>
         *      TO: Se exceddio el tiempo de respuesta esperado del equipo.<br>
         * @param razon (String)
         * @param rif   (String)
         * @param comp  (String)
         * @param maqui (String)
         * @param fecha (String)
         * @param hora  (String)
         * @return String {OK|ER|NP|TO}
         */
        String PFDevolucion(String razon, String rif, String comp,
               String maqui, String fecha, String hora);

        /**
         * Activa el modo validacion para los equipos que soportan el comando.<br><br>
         * Parametros:<br>
         *      Ninguno.<br><br>
         * Resultados:  (String)<br>
         *      OK: Transmision/recepcion fue correcta.<br>
         *      ER: Existe un error.<br>
         *      NP: Puerto No Abuerto.<br>
         *      TO: Se exceddio el tiempo de respuesta esperado del equipo.<br>
         * @return String {OK|ER|NP|TO}
         */
        String PFSlipON();

        /**
         * Desactiva el modo validador SLIP en determinados modelos.<br><br>
         * Parametros:<br>
         *      Ninguno.<br><br>
         * Resultados:  (String)<br>
         *      OK: Transmision/recepcion fue correcta.<br>
         *      ER: Existe un error.<br>
         *      NP: Puerto No Abuerto.<br>
         *      TO: Se exceddio el tiempo de respuesta esperado del equipo.<br>
         * @return String {OK|ER|NP|TO}
         */
        String PFSLIPOFF();

        /**
         * Solicita el estatus fiscal del equipo.<br><br>
         * Parametros:<br>
         *      edlinea: String Letra clave del tipo de estatus solicitado.<br>
         *          N -> datos de los contadores.<br>
         *          E -> valor de ventas exentas.<br>
         *          A -> valor de base imponible a + impuestos.<br>
         *          B -> valor de base imponible b + impuestos.<br>
         *          C -> valor de base imponible c + impuestos.<br>
         *          R -> valor de devoluciones + impuestos.<br>
         *          F -> near end papel de recibo.<br>
         *          J -> near end papel de auditoria.<br>
         *          S -> desactiva el autocutter.<br>
         *          T -> numero de ultima nota de credito generada.<br>
         *          U -> verifica si hay papel en el slip de la impresora.<br>
         *          V -> envia version del FW del equipo.<br><br>
         * Resultados:  (String)<br>
         *      OK: Transmision/recepcion fue correcta.<br>
         *      ER: Existe un error.<br>
         *      NP: Puerto No Abuerto.<br>
         *      TO: Se exceddio el tiempo de respuesta esperado del equipo.<br>
         * @param edlinea   (String)
         * @return String {OK|ER|NP|TO}
         */
        String PFestatus(String edlinea);

        /**
         * Reinicia el equipo. <br>
         *  Comando no necesario pero puede ayudar en resolucion de situaciones
         *  de desarrollo.<br><br>
         * Parametros:<br>
         *      Ninguno.<br><br>
         * Resultados:  (String)<br>
         *      OK: Transmision/recepcion fue correcta.<br>
         *      ER: Existe un error.<br>
         *      NP: Puerto No Abuerto.<br>
         *      TO: Se exceddio el tiempo de respuesta esperado del equipo.<br>
         * @return String {OK|ER|NP|TO}
         */
        String PFreset();

        /**
         * Emite datos de endoso en cheques.<br><br>
         * Parametros:<br>
         *      campo1..3: String Textos a generar en el endoso.<br>
         *      tipoendoso: String Tipo endoso para deposito o cobros.<br><br>
         * Resultados:  (String)<br>
         *      OK: Transmision/recepcion fue correcta.<br>
         *      ER: Existe un error.<br>
         *      NP: Puerto No Abuerto.<br>
         *      TO: Se exceddio el tiempo de respuesta esperado del equipo.<br>
         * @param campo1        (String)
         * @param campo2        (String)
         * @param campo3        (String)
         * @param tipoendoso    (String)
         * @return String {OK|ER|NP|TO}
         */
        String PFendoso(String campo1, String campo2, String campo3,
               String tipoendoso);

        /**
         * Genera validacion en la impresion modelo PF-675.<br><br>
         * Parametros:<br>
         *      campo1..4: Lineas de texto para generar en la validacion superior.<br><br>
         * Resultados:  (String)<br>
         *      OK: Transmision/recepcion fue correcta.<br>
         *      ER: Existe un error.<br>
         *      NP: Puerto No Abuerto.<br>
         *      TO: Se exceddio el tiempo de respuesta esperado del equipo.<br>
         * @param campo1    (String)
         * @param campo2    (String)
         * @param campo3    (String)
         * @param campo4    (String)
         * @return String {OK|ER|NP|TO}
         */
        String PFvalida675(String campo1, String campo2, 
               String campo3, String campo4);

        /**
         * Envia los datos para el llenado de cheques en equipos que soportan 
         *  impresion de cheques.<br><br>
         * Parametros:<br>
         *      mon: String Monto en formato XXXXXXXDD.<br>
         *      ben: String Beneficiario.<br>
         *      fec: String Fecha.<br>
         *      c1..c4: String Valores numericos para cuadre de campos.<br>
         *      campo1: String Valores a emitir en el endoso para equipos que
         *          lo soporten.<br>
         *      campo2: String Valores a emitir en el endoso para equipos que
         *          lo soporten.<br><br>
         * Resultados:  (String)<br>
         *      OK: Transmision/recepcion fue correcta.<br>
         *      ER: Existe un error.<br>
         *      NP: Puerto No Abuerto.<br>
         *      TO: Se exceddio el tiempo de respuesta esperado del equipo.<br>
         * @param mon       (String)
         * @param ben       (String)
         * @param fec       (String)
         * @param c1        (String)
         * @param c2        (String)
         * @param c3        (String)
         * @param c4        (String)
         * @param campo1    (String)
         * @param campo2    (String)
         * @return String {OK|ER|NP|TO}
         */
        String PFCheque2(String mon, String ben, String fec, 
               String c1, String c2, String c3, String c4, String campo1, 
               String campo2);

        /**
         * Cambia la fecha del equipo.<br>
         *  Solo se puede adelantar los dias y retrasar las horas.<br>
         *  (Requiere un reporte z antes de su ejecucion)<br><br>
         * Paramtros:<br>
         *      edfecha:    String fecha a cambiar en formato DDMMAA<br>
         *      edhora:     String hora a cambiar en formato HHMM<br><br>
         * Resultados:  (String)<br>
         *      OK: Transmision/recepcion fue correcta.<br>
         *      ER: Existe un error.<br>
         *      NP: Puerto No Abuerto.<br>
         *      TO: Se exceddio el tiempo de respuesta esperado del equipo.<br>
         * @param edfecha   (String)
         * @param edhora    (String)
         * @return String {OK|ER|NP|TO}
         */
        String PFcambiofecha(String edfecha, String edhora);

        /**
         * Cambia las tasas activas del equipo.<br>
         *  (Se requiere la generacion de un reporte Z antes de su ejecucion de lo
         *  contratio presenta error).<br><br>
         * Parametros:<br>
         *      t1: String Tasa general en formato XXDD donde XX: Entero y DD 
         *          Decimal, Ejemplo: 1200 = 12%.<br>
         *      t2: String Tasa reducida.<br>
         *      t3: String Tasa aumentada.<br><br>
         * Resultados:  (String)<br>
         *      OK: Transmision/recepcion fue correcta.<br>
         *      ER: Existe un error.<br>
         *      NP: Puerto No Abuerto.<br>
         *      TO: Se exceddio el tiempo de respuesta esperado del equipo.<br>
         * @param t1    (String)
         * @param t2    (String)
         * @param t3    (String)
         * @return String {OK|ER|NP|TO}
         */
        String PFcambiatasa(String t1, String t2, String t3);

        /**
         * Envia codigo de barras dependiendo del modelo de impresora.<br><br>
         * Parametros:<br>
         *      edbarra: String valor de la barra (codigo).<br><br>
         * Resultados:  (String)<br>
         *      OK: Transmision/recepcion fue correcta.<br>
         *      ER: Existe un error.<br>
         *      NP: Puerto No Abuerto.<br>
         *      TO: Se exceddio el tiempo de respuesta esperado del equipo.<br>
         * @param edbarra    (String)
         * @return String {OK|ER|NP|TO}
         */
        String PFBarra(String edbarra);

        /**
         * Voltea el cheque para los equipos compatibles.<br><br>
         * Parametros:<br>
         *      Ninguno.<br><br>
         * Resultados:  (String)<br>
         *      OK: Transmision/recepcion fue correcta.<br>
         *      ER: Existe un error.<br>
         *      NP: Puerto No Abuerto.<br>
         *      TO: Se exceddio el tiempo de respuesta esperado del equipo.<br>
         * @return String {OK|ER|NP|TO}
         */
        String PFVoltea();

        /**
         * Realiza la lectura del reloj de la impresora.<br>
         *  (Revisar Function PFUltimo() para obtener resultados)<br><br>
         * Parametros:<br>
         *      Ninguno.<br><br>
         * Resultados:  (String)<br>
         *      OK: Transmision/recepcion fue correcta.<br>
         *      ER: Existe un error.<br>
         *      NP: Puerto No Abuerto.<br>
         *      TO: Se exceddio el tiempo de respuesta esperado del equipo.<br>
         * @return String {OK|ER|NP|TO}
         * @see PFultimo
         */
        String PFLeereloj();

        /**
         * Genera un reporte de memoria fiscal almacenado en el equipo.<br><br>
         * Parametros:<br>
         *       desf:   String Fecha desde en formato DDMMAA.<br>
         *      hasf:   String Fecha hasta en formato DDMMAA.<br>
         *      modmen: String Modo del reporte resumen o detallado.<br><br>
         * Resultados:  (String)<br>
         *      OK: Transmision/recepcion fue correcta.<br>
         *      ER: Existe un error.<br>
         *      NP: Puerto No Abuerto.<br>
         *      TO: Se exceddio el tiempo de respuesta esperado del equipo.<br>
         * @param desf      (String)
         * @param hasf      (String)
         * @param modmem    (String)
         * @return String {OK|ER|NP|TO}
         */
        String PFrepMemNF(String desf, String hasf, String modmem);

        /**
         * Genera reportes de memoria fiscal basados en los numeros de reporte z.<br><br>
         * Parametros:<br>
         *      desn:   String Numero desde de reporte z.<br>
         *      hasn:   String Numero hasta de reporte z.<br>
         *      modmen: String Modo del reporte resumen o detallado.<br><br>
         * Resultados:  (String)<br>
         *      OK: Transmision/recepcion fue correcta.<br>
         *      ER: Existe un error.<br>
         *      NP: Puerto No Abuerto.<br>
         *      TO: Se exceddio el tiempo de respuesta esperado del equipo.<br>
         * @param desn      (String)
         * @param hasn      (String)
         * @param modmem    (String)
         * @return String {OK|ER|NP|TO}
         */
        String PFRepMemoriaNumero(String desn, String hasn, 
               String modmem);

        /**
         * Cambia el tipo de contribuyente al equipo.<br><br>
         * Parametros:<br>
         *      tip:    String tipo de contribuyente<br>
         *                  1 -> Ordinario.<br>
         *                  2 -> No Sujeto al IVA.<br>
         *                  3 -> Formal.<br><br>
         * Resultados:  (String)<br>
         *      OK: Transmision/recepcion fue correcta.<br>
         *      ER: Existe un error.<br>
         *      NP: Puerto No Abuerto.<br>
         *      TO: Se exceddio el tiempo de respuesta esperado del equipo.<br>
         * @param tip   (String)
         * @return String {OK|ER|NP|TO}
         */
        String PFCambtipoContrib(String tip);

        /**
         * Devuelve la ultima respuesta obtenida de la impresora donde cada campo
         *  coincide con los establecidos en el manual de protocolo y para facilitar
         *  su manejo estan separados por comas.<br><br>
         * Parametros:<br>
         *      1,2,3,4.<br><br>
         * Resultados:  (String)<br>
         *      OK: Transmision/recepcion fue correcta.<br>
         *      ER: Existe un error.<br>
         *      NP: Puerto No Abuerto.<br>
         *      TO: Se exceddio el tiempo de respuesta esperado del equipo.<br>
         * @return String {OK|ER|NP|TO}
         */
        String PFultimo();

        /**
         * Cambia el modelo de la impresora para permitir soporte de largos de linea
         *  para el modelo PF-300-II.<br><br>
         * Parametros:<br>
         *      edtexto: String Modelo de la impresora "300" para el modelo 
         *          PF-300-II. Cualquier otro texto para el resto de los modelos.<br><br>
         * Resultados:  (String)<br>
         *      OK: Transmision/recepcion fue correcta.<br>
         *      ER: Existe un error.<br>
         *      NP: Puerto No Abuerto.<br>
         *      TO: Se exceddio el tiempo de respuesta esperado del equipo.<br>
         * @param edtexto   (String)
         * @return String {OK|ER|NP|TO}
         */
        String PFTipoImp(String edtexto);
//----------------------------------------------------------------------------//

        /**
         * Envia la impresion del logo almacenado en la memoria de la impresora.<br>
         *  (Solo para los modelos que lo soportan)<br><br>
         * Parametros:<br>
         *      Ninguno.<br><br>
         * Resultados:  (String)<br>
         *      OK: Transmision/recepcion fue correcta.<br>
         *      ER: Existe un error.<br>
         *      NP: Puerto No Abuerto.<br>
         *      TO: Se exceddio el tiempo de respuesta esperado del equipo.<br>
         * @return String {OK|ER|NP|TO}
         */
        String PFLogoClick();

        /**
         * Solicita la version de produccion del equipo fiscal.<br><br>
         * Parametros:<br>
         *      Ninguno.<br><br>
         * Resultados:  (String)<br>
         *      OK: Transmision/recepcion fue correcta.<br>
         *      ER: Existe un error.<br>
         *      NP: Puerto No Abuerto.<br>
         *      TO: Se exceddio el tiempo de respuesta esperado del equipo.<br>
         * @return String {OK|ER|NP|TO}
         */
        String PFversion();
    }

    
    /*---------------------------------------------------*/
    /*---               Constructores                 ---*/
    /*---------------------------------------------------*/
    /**
     * Contructor Null de la clase PnpDriverFiscal
     */
    public PnpDriverFiscal() {
        this.pnpdll = pnpDLL.INSTANCE;
    }
    
    /*---------------------------------------------------*/
    /*---             Metodos Set y Get               ---*/
    /*---------------------------------------------------*/
    
    /*---------------------------------------------------*/
    /*---             Metodos especificos             ---*/
    /*---------------------------------------------------*/
    /**
     * Abre el puerto de comunicacion con la impresora fiscal<br><br>
     * Parametros:<br>
     *      strVar1: String Numero del puerto de conexion.<br>
     *      strVar2: String Velocidad de conexion del puerto.<br><br>
     * Resultados:  (String)<br>
     *      OK: Transmision/recepcion fue correcta.<br>
     *      ER: Existe un error.<br>
     *      NP: Puerto No Abuerto.<br>
     *      TO: Se exceddio el tiempo de respuesta esperado del equipo.<br>
     * @param strVar1 (String)
     * @param strVar2 (String)
     * @return String {OK|ER|NP|TO}
     */
    public int IF_OPEN(String strVar1, String strVar2) {
        //  Variables
        String res = "";
        
        //  Proceso
        if (!strVar1.isEmpty())
            res = this.pnpdll.PFabrepuerto(strVar1.substring(3).trim());
        
        //  Resultado
        if (res.equalsIgnoreCase("OK"))
            return 0;
        else
            return 1;
    }
    
    /**
     * Cierra el puerto de comunicacion con la impresora fiscal<br><br>
     * Parametros:<br>
     *      Ninguno.<br><br>
     * Resultados:  (String)<br>
     *      OK: Transmision/recepcion fue correcta.<br>
     *      ER: Existe un error.<br>
     *      NP: Puerto No Abuerto.<br>
     *      TO: Se exceddio el tiempo de respuesta esperado del equipo.<br>
     * @return String {OK|ER|NP|TO}
     */
    public int IF_ClOSE() {
        //  Variables
        String res = "";
        
        //  Proceso
        res = this.pnpdll.PFcierrapuerto();
        
        //  Resultado
        if (res.equalsIgnoreCase("OK"))
            return 0;
        else
            return 1;
    }
    
    /**
     * Retorna los valores que regresa la impresora fiscal<br><br>
     * Parametros:<br>
     *      Posicion: int Indica la posicion del parametro de salida.<br><br>
     * Resultados:  (String)<br>
     *      Valor de la impresora fiscal.<br>
     * @param posicion (String)
     * @return String
     */
    public String IF_READ(int posicion) {
        //  Variables
        String res = "";
        List<String> item = new ArrayList();
        
        //  Proceso
        if (posicion > 0 && posicion < 4){
            res = this.pnpdll.PFultimo();
            item.clear();
            item.addAll(Arrays.asList(res.split(",")));
            if (!item.isEmpty())
                res = item.get(posicion-1).trim();
        }
        
        //  Resultado
        return res.trim();
    }
    
    /**
     * Consulta de estado
     * @param	byVar1	Tipo de información solicitada {NEABCDRFJSU}
     * @return 0 si no hay error y != 0 si hay un error
     */
    public int StatusRequest(String byVar1) {
        //  Variables
        String res = "";
        
        //  Proceso
        if (!byVar1.isEmpty())
            res = this.pnpdll.PFestatus(byVar1);
        
        //  Resultado
        if (res.equalsIgnoreCase("OK"))
            return 0;
        else
            return 1;
    }
    
    /**
     * Cierre de jornada fiscal
     * @param	byVar1	Tipo de reporte {ZX}
     * @param	byVar2	Reservado
     * @return 0 si no hay error y != 0 si hay un error
     */
    public int DailyClose(String byVar1, String byVar2){
        //  Variables
        String res = "";
        
        //  Proceso
        if (!byVar1.isEmpty()) {
            if (byVar1.equalsIgnoreCase("X"))
                res = this.pnpdll.PFrepx();
            else if ((byVar1.equalsIgnoreCase("Z")))
                res = this.pnpdll.PFrepz();
        }
        
        //  Resultado
        if (res.equalsIgnoreCase("OK"))
            return 0;
        else
            return 1;
    }

    /**
     * Reporte de auditoria por fechas
     * @param	strVar1	Fecha de inicio de selección DDMMAA (max 6 bytes)
     * @param	strVar2	Fecha de fin de selección DDMMAA (max 6 bytes)
     * @param	byVar3	Calificador de reporte detalle o resumen {DR}
     * @return 0 si no hay error y != 0 si hay un error
     */
    public int DailyCloseByDate(String strVar1, String strVar2, String byVar3){
        //  Variables
        String res = "";
        
        if (!strVar1.isEmpty() && !strVar2.isEmpty() && !byVar3.isEmpty())
            res = this.pnpdll.PFrepMemNF(strVar1, strVar2, byVar3);
        
        //  Resultado
        if (res.equalsIgnoreCase("OK"))
            return 0;
        else
            return 1;
    }

    /**
     * Reporte de auditoria por numero
     * @param	nVar1	Número de Z de inicio de selección (nnnn)
     * @param	nVar2	Número de Z de fin de selección (nnnn)
     * @param	byVar3	Calificador de reporte detalle o resumen {DR}
     * @return 0 si no hay error y != 0 si hay un error
     */
    public int DailyCloseByNumber(String nVar1, String nVar2, String byVar3){
        //  Variables
        String res = "";
        
        //  Proceso
        if (!nVar1.isEmpty() && !nVar2.isEmpty() && !byVar3.isEmpty())
            res = this.pnpdll.PFRepMemoriaNumero(nVar1, nVar2, byVar3);
        
        //  Resultado
        if (res.equalsIgnoreCase("OK"))
            return 0;
        else
            return 1;
    }
    
    /**
     * Abrir comprobante fiscal
     * @param	strVar1	Razón social 1 (max 40 bytes)
     * @param	strVar2	RIF del comprador (max 20 bytes)
     * @param	strVar3	Nro de comprobante (en devolución) (max 20 bytes)
     * @param	strVar4	Serial de la maquina fiscal que realizo el comprobante en devolución (Solo en nota de crédito) (max 20 bytes)
     * @param	strVar5	Fecha del comprobante en devolución (Solo en nota de crédito) (max 6 bytes)
     * @param	strVar6	Hora del comprobante en devolución (max 6 bytes)
     * @param	byVar7	Tipo de documento Nota de Credito {NC}
     * @param	byVar8	Campo reservado
     * @param	byVar9	Campo reservado
     * @return 0 si no hay error y != 0 si hay un error
     */
    public int OpenFiscalReceipt(String strVar1, String strVar2, String strVar3,
                                 String strVar4, String strVar5, String strVar6, 
                                 String byVar7, String byVar8, String byVar9) {
        //  Variables
        String res = "";
        
        //  Proceso
        if (!byVar7.isEmpty())
            res = this.pnpdll.PFDevolucion(strVar1,strVar2,strVar3,strVar4,strVar5,strVar6);
        else
            res = this.pnpdll.PFabrefiscal(strVar1,strVar2);
        
        //  Resultado
        if (res.equalsIgnoreCase("OK"))
            return 0;
        else
            return 1;
    }
    
    /**
     * Imprimir texto fiscal
     * @param strVar1   (String)    Texto a imprimir
     * @param byVar2    (String)    Reservado
     * @return int 0 si no hay error y != 0 si hay un error
     */
    public int PrintFiscalText(String strVar1, String byVar2) {
        //  Variables
        String res = "";
        
        //  Proceso
        if (!strVar1.isEmpty())
            res = this.pnpdll.PFTfiscal(strVar1);
        
        //  Resultado
        if (res.equalsIgnoreCase("OK"))
            return 0;
        else
            return 1;
    }
    
    /**
     * Imprimir item
     * @param	strVar1	Descripción de hasta 20 caracteres (max 20 bytes)
     * @param	dblVar2	Cantidad (nnnn.nnn)
     * @param	dblVar3	Monto del ítem (nnnnnnnn.nn)
     * @param	dblVar4	Tasa del impuesto (EEDD) [EE = entero y DD = decimal]
     * @param	byVar5	Reservado
     * @param	byVar6	Reservado
     * @param	byVar7	Reservado
     * @param	byVar8	Reservado
     * @return 0 si no hay error y != 0 si hay un error
     */
    public int PrintLineItem(String strVar1, String dblVar2, String dblVar3, 
                             String dblVar4, String byVar5,  String byVar6, 
                             String byVar7, String byVar8){
        //  Variables
        String res = "";
        
        //  Proceso
        if (!strVar1.isEmpty() && !dblVar2.isEmpty() && !dblVar3.isEmpty() && 
                !dblVar4.isEmpty())
            res = this.pnpdll.PFrenglon(strVar1, dblVar2, dblVar3, dblVar4);
        
        //  Resultado
        if (res.equalsIgnoreCase("OK"))
            return 0;
        else
            return 1;
    }
    
    /**
     * Subtotal
     * @param	byVar1	Reservado
     * @param	byVar2	Reservado
     * @return 0 si no hay error y != 0 si hay un error
     */
    public int Subtotal(String byVar1, String byVar2){
        //  Variables
        String res = "";
        
        //  Proceso
        res = this.pnpdll.PFparcial();
        
        //  Resultado
        if (res.equalsIgnoreCase("OK"))
            return 0;
        else
            return 1;
    }
    
    /**
     * Cerrar comprobante fiscal
     * @param	byVar1	Calificador de comando {AE}
     * @return 0 si no hay error y != 0 si hay un error
     */
    public int CloseFiscalReceipt(String byVar1){
        //  Variables
        String res = "";
        
        //  Proceso
        if (byVar1.isEmpty())
            res = this.pnpdll.PFtotal();
        else if (byVar1.equalsIgnoreCase("A"))
                res = this.pnpdll.PFparcial();
        
        //  Resultado
        if (res.equalsIgnoreCase("OK"))
            return 0;
        else
            return 1;
    }
    
    /**
     * Abrir comprobante no-fiscal
     * @return 0 si no hay error y != 0 si hay un error
     */
    public int OpenNonFiscalReceipt(){
        //  Variables
        String res = "";
        
        //  Proceso
        res = this.pnpdll.PFAbreNF();
        
        //  Resultado
        if (res.equalsIgnoreCase("OK"))
            return 0;
        else
            return 1;
    }
    
    /**
     * Imprimir texto no-fiscal
     * @param	strVar1	Hasta 40 caracteres de texto fiscal (max 40 bytes)
     * @return 0 si no hay error y != 0 si hay un error
     */
    public int PrintNonFiscalText(String strVar1){
        //  Variables
        String res = "";
        
        //  Proceso
        if (!strVar1.isEmpty())
            res = this.pnpdll.PFLineaNF(strVar1);
        
        //  Resultado
        if (res.equalsIgnoreCase("OK"))
            return 0;
        else
            return 1;
    }
    
    /**
     * Cerrar comprobante no-fiscal
     * @param	byVar1	Reservado.
     * @return 0 si no hay error y != 0 si hay un error
     */
    public int CloseNonFiscalReceipt(String byVar1){
        //  Variables
        String res = "";
        
        //  Proceso
        res = this.pnpdll.PFCierraNF();
        
        //  Resultado
        if (res.equalsIgnoreCase("OK"))
            return 0;
        else
            return 1;
    }
    
    /**
     * Cortar papel
     * @return 0 si no hay error y != 0 si hay un error
     */
    public int PaperCut(){
        //  Variables
        String res = "";
        
        //  Proceso
        res = this.pnpdll.PFCortar();
        
        //  Resultado
        if (res.equalsIgnoreCase("OK"))
            return 0;
        else
            return 1;
    }
    
    /**
     * Activar Split
     * @return 0 si no hay error y != 0 si hay un error
     */
    public int ActivateSlip(){
        //  Variables
        String res = "";
        
        //  Proceso
        res = this.pnpdll.PFSlipON();
        
        //  Resultado
        if (res.equalsIgnoreCase("OK"))
            return 0;
        else
            return 1;
    }
    
    /**
     * Este comando desactiva el funcionamiento del Slip.
     * @return 0 si no hay error y != 0 si hay un error
     */
    public int InActivateSlip(){
        //  Variables
        String res = "";
        
        //  Proceso
        res = this.pnpdll.PFSLIPOFF();
        
        //  Resultado
        if (res.equalsIgnoreCase("OK"))
            return 0;
        else
            return 1;
    }
    
    /**
     * Este comando imprime por el Slip en el formato de un cheque.
     * @param	strVar1	Monto del Cheque (max 12 bytes)
     * @param	strVar2	Beneficiario (max 40 bytes)
     * @param	strVar3	Fecha de emisión (max 20 bytes)
     * @param	byVar4	'E' = Se imprime la frase 'NO ENDOSABLE', 'R' = Se imprime la frase 'NO ENDOSABLE' en negrita {ER}
     * @param	byVar5	Separacion entre lineas monto y benficiario(1 al 7)
     * @param	byVar6	Separacion entre 'la cantidad' y la fecha(1 al 7)
     * @param	byVar7	Separacion entre 'no endosable' y el monto superior(1 al 7)
     * @param	byVar8	Separacion entre 'beneficiario' y la cantidad ( 1 al 7)
     * @return 0 si no hay error y != 0 si hay un error
     */
    public int FormatoCheque(String strVar1, String strVar2, String strVar3, 
                             String byVar4, String byVar5, String byVar6, 
                             String byVar7, String byVar8){
        //  Variables
        String res = "";
        
        //  Proceso
        if (!strVar1.isEmpty() && !strVar2.isEmpty() && !strVar3.isEmpty())
            res = this.pnpdll.PFCheque2(strVar1, strVar2, strVar3, byVar5, 
                    byVar6, byVar7, byVar8, "", "");
        
        //  Resultado
        if (res.equalsIgnoreCase("OK"))
            return 0;
        else
            return 1;
    }
    
    /**
     * Este comando imprime por el Slip el endoso para un cheque.
     * @param	strVar1	Texto a imprimir (max 33 bytes)
     * @param	strVar2	Texto a imprimir (max 40 bytes)
     * @param	strVar3	Texto a Imprimir (max 40 bytes)
     * @param	byVar4	 {DC}
     * @return 0 si no hay error y != 0 si hay un error
     */
    public int FormatoEndoso(String strVar1, String strVar2, String strVar3, 
                             String byVar4){
        //  Variables
        String res = "";
        
        //  Proceso
        if (!strVar1.isEmpty() && !strVar2.isEmpty() && !strVar3.isEmpty() &&
                !byVar4.isEmpty())
            res = this.pnpdll.PFendoso(strVar1, strVar2, strVar3, byVar4);
        
        //  Resultado
        if (res.equalsIgnoreCase("OK"))
            return 0;
        else
            return 1;
    }
    
    /**
     * Obtener el Nro de serie de la impresora
     * @return 0 si no hay error y != 0 si hay un error
     */
    public int SerialRequest(){
        //  Variables
        String res = "";
        
        //  Proceso
        res = this.pnpdll.PFSerial();
        
        //  Resultado
        if (res.equalsIgnoreCase("OK"))
            return 0;
        else
            return 1;
    }
    
}
