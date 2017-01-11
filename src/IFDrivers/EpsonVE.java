package IFDrivers;

//Este modulo contiene el código a disposicion por parte de IFDRIVERS
//en una base TAL CUAL. Todo receptor del Modulo se considera
//bajo licencia de los derechos de autor de IFDRIVERS para utilizar el
//codigo fuente siempre en modo que el o ella considere conveniente,
//incluida la copia, la compilacion, su modificacion o la redistribucion,
//con o sin modificaciones. Ninguna licencia o patentes de IFDRivers
//este implicita en la presente licencia.
//
//El usuario del codigo fuente debera entender que IFDRIVERS no puede
//Proporcionar apoyo tecnico para el modulo y no sera Responsable
//de las consecuencias del uso del programa.
//
//Todas las comunicaciones, incluida esta, no deben ser removidos
//del modulo sin el consentimiento previo por escrito de IFDRIVERS
//www: http://www.impresoras-fiscales.com.ar/
//email: soporte@impresoras-fiscales.com.ar

//Instrucciones para usar el driver y las funciones de alto nivel en Java:
//
//1) Instale la libreria Tm2032Jv.dll. Para que Java pueda encuentrar
// la libreria, esta debe estar instalada en un directorio que este incluido en 
// la variable de entorno PATH. 
//2) Agregue este archivo con la clase EpsonVE a su proyecto.
//3) Declare y cree la clase en su codigo. 
// Todas las funciones de la clase EpsonVE seran accesibles tambien 
// desde esta clase: IF_OPEN, IF_CLOSE,etc. mas las funciones de alto nivel.
//
//Por ejemplo:
//
//import IFDrivers.EpsonVE;
//
//EpsonVE m_objEpsonVE = new EpsonVE();
//
//int nError = m_objEpsonVE.IF_OPEN("COM1",9600);
//
//....etc
//
//IMPORTANTE: No debera renombrar ni el nombre del Package ni de la clase. De lo contrario,
//el driver dejara de funcionar.
//

/**
* 
* @author Marcelo
*/
public class EpsonVE
{
/**
* Abrir el puerto de comunicaciones
* @param    strPort    Puerto de comunicaciones
* @param    nSpeed   Velocidad del puerto
* @return     0 si no hay error, -1 si se produjo un error
*/
public native int IF_OPEN(String strPort, int nSpeed);

/**
*  Cerrar el puerto de comunicaciones
* @return     0 si no hay error, -1 si se produjo un error
*/
public native int IF_CLOSE();

/**
*  Leer un campo de la respuesta del controlador fiscal
* @param    nField    Nro del campo de la respuesta fiscal a recuperar
* @return     El valor del campo
*/
public native String IF_READ(int nField);

/**
*  Enviar un comando a la impresora fiscal
* @param    strCommand    Comando a enviar
* @return     0 si no hay error, -1 si se produjo un error
*/
public native int IF_WRITE(String strCommand);

/**
*  Leer el código de estado del mecanismo impresor
* @param    nBit    Nro del bit a leer (1 a 16)
* @return     1 si esta en On, 0 si esta en Off
*/
public native int IF_ERROR1(int nBit);

/**
*  Leer el código de estado del controlador fiscal
* @param    nBit    Nro del bit a leer (1 a 16)
* @return     1 si esta en On, 0 si esta en Off
*/
public native int IF_ERROR2(int nBit);

/**
*  Habilitar o deshabilitar la depuración de comandos
* @param    nTrace   1 para habilitar, 0 para deshabilitar la depuracion
*/
public native void IF_TRACE(int nTrace);

public native void IF_SERIAL(String strSerial);

static
{
System.loadLibrary("Tm2032Jv");
}

//***************************************************************
// 1. Comandos de Control Fiscal
/**
* Consulta de estado
* @param	byVar1	Tipo de información solicitada {NEABCDRFJSU}
* @return 0 si no hay error y != 0 si hay un error
*/
public int StatusRequest(String byVar1)
{
String strBuff = "@StatusRequest" + "|" + byVar1;

int nError = IF_WRITE(strBuff);

return (nError);
}

/**
* Cierre de jornada fiscal
* @param	byVar1	Tipo de reporte {ZX}
* @param	byVar2	parametro de impresion
* @return 0 si no hay error y != 0 si hay un error
*/
public int DailyClose(String byVar1, String byVar2)
{
String strBuff = "@DailyClose" + "|" + byVar1 + "|" + byVar2;

int nError = IF_WRITE(strBuff);

return (nError);
}

/**
* Reporte de auditoria por fechas
* @param	strVar1	Fecha de inicio de selección AAMMDD (max 6 bytes)
* @param	strVar2	Fecha de fin de selección AAMMDD (max 6 bytes)
* @param	byVar3	Calificador de reporte {DMRC}
* @return 0 si no hay error y != 0 si hay un error
*/
public int DailyCloseByDate(String strVar1, String strVar2, String byVar3)
{
String strBuff = "@DailyCloseByDate" + "|" + strVar1 + "|" + strVar2 + "|" + 
                   byVar3;

int nError = IF_WRITE(strBuff);

return (nError);
}

/**
* Reporte de auditoria por numero
* @param	nVar1	Número de Z de inicio de selección (nnnn)
* @param	nVar2	Número de Z de fin de selección (nnnn)
* @param	byVar3	Calificador de reporte
* @return 0 si no hay error y != 0 si hay un error
*/
public int DailyCloseByNumber(Integer nVar1, Integer nVar2, String byVar3)
{
String strBuff = "@DailyCloseByNumber" + "|" + nVar1.toString() + "|" + nVar2.toString() + "|" + 
                   byVar3;

int nError = IF_WRITE(strBuff);

return (nError);
}

//***************************************************************
// 2. Comandos para generar comprobantes fiscales
/**
* Abrir comprobante fiscal
* @param	strVar1	Razón social 1 (max 40 bytes)
* @param	strVar2	RIF del comprador (max 20 bytes)
* @param	strVar3	Nro de comprobante (en devolución) (max 20 bytes)
* @param	strVar4	Serial de la maquina fiscal que realizo el comprobante en devolución (Solo en nota de crédito) (max 20 bytes)
* @param	strVar5	Fecha del comprobante en devolución (Solo en nota de crédito) (max 6 bytes)
* @param	strVar6	Hora del comprobante en devolución (max 6 bytes)
* @param	byVar7	Tipo de documento {TD}
* @param	byVar8	Campo reservado
* @param	byVar9	Campo reservado
* @return 0 si no hay error y != 0 si hay un error
*/
public int OpenFiscalReceipt(String strVar1, String strVar2, String strVar3, String strVar4, 
                             String strVar5, String strVar6, 
                              String byVar7, String byVar8, String byVar9)
{
String strBuff = "@OpenFiscalReceipt" + "|" + strVar1 + "|" + strVar2 + "|" + 
                   strVar3 + "|" + strVar4 + "|" + strVar5 + "|" + strVar6 + "|" + 
                    byVar7 + "|" + byVar8 + "|" + byVar9;

int nError = IF_WRITE(strBuff);

return (nError);
}

/**
* Imprimir texto fiscal
* @param	strVar1	Texto Fiscal a Imprimir (max 26 bytes)
* @param	byVar2	Calificador de Impresión {SO}
* @return 0 si no hay error y != 0 si hay un error
*/
public int PrintFiscalText(String strVar1, String byVar2)
{
String strBuff = "@PrintFiscalText" + "|" + strVar1 + "|" + byVar2;

int nError = IF_WRITE(strBuff);

return (nError);
}

/**
* Imprimir item
* @param	strVar1	Descripción de hasta 20 caracteres (max 20 bytes)
* @param	dblVar2	Cantidad (nnnn.nnn)
* @param	dblVar3	Monto del ítem (nnnnnnnn.nn)
* @param	dblVar4	Tasa impositiva (.nnnn)
* @param	byVar5	Calificador de ítem de línea {Mm}
* @param	byVar6	Reservado
* @param	byVar7	Reservado
* @param	byVar8	Reservado
* @return 0 si no hay error y != 0 si hay un error
*/
public int PrintLineItem(String strVar1, Double dblVar2, Double dblVar3, Double dblVar4, 
                         String byVar5, String byVar6, String byVar7, 
                          String byVar8)
{
String strBuff = "@PrintLineItem" + "|" + strVar1 + "|" + dblVar2.toString() + "|" + 
                   dblVar3.toString() + "|" + dblVar4.toString() + "|" + 
                    byVar5 + "|" + byVar6 + "|" + byVar7 + "|" + byVar8;

int nError = IF_WRITE(strBuff);

return (nError);
}

/**
* Subtotal
* @param	byVar1	Reservado
* @param	byVar2	Reservado
* @return 0 si no hay error y != 0 si hay un error
*/
public int Subtotal(String byVar1, String byVar2)
{
String strBuff = "@Subtotal" + "|" + byVar1 + "|" + byVar2;

int nError = IF_WRITE(strBuff);

return (nError);
}

/**
* Pago,Cancelar y Descuento en Comprobante fiscal
* @param	strVar1	Descripción de 20 caracteres (max 20 bytes)
* @param	dblVar2	Monto de pago (nnnnnn.nn)
* @param	byVar3	Calificador de comando {CTDP}
* @param	dblVar4	Tasa impositiva sobre la que aplica la promoción (.nnnn)
* @return 0 si no hay error y != 0 si hay un error
*/
public int ReturnRecharge(String strVar1, Double dblVar2, String byVar3, Double dblVar4)
{
String strBuff = "@ReturnRecharge" + "|" + strVar1 + "|" + dblVar2.toString() + "|" + 
                   byVar3 + "|" + dblVar4.toString();

int nError = IF_WRITE(strBuff);

return (nError);
}

/**
* Cerrar comprobante fiscal
* @param	byVar1	Calificador de comando {AE}
* @return 0 si no hay error y != 0 si hay un error
*/
public int CloseFiscalReceipt(String byVar1)
{
String strBuff = "@CloseFiscalReceipt" + "|" + byVar1;

int nError = IF_WRITE(strBuff);

return (nError);
}

//***************************************************************
// 3. Comandos para generar documentos no fiscales
/**
* Abrir comprobante no-fiscal
* @return 0 si no hay error y != 0 si hay un error
*/
public int OpenNonFiscalReceipt()
{
String strBuff = "@OpenNonFiscalReceipt";

int nError = IF_WRITE(strBuff);

return (nError);
}

/**
* Imprimir texto no-fiscal
* @param	strVar1	Hasta 40 caracteres de texto fiscal (max 40 bytes)
* @return 0 si no hay error y != 0 si hay un error
*/
public int PrintNonFiscalText(String strVar1)
{
String strBuff = "@PrintNonFiscalText" + "|" + strVar1;

int nError = IF_WRITE(strBuff);

return (nError);
}

/**
* Cerrar comprobante no-fiscal
* @param	byVar1	Calificador de comando. 'E' = indica cierre económico. Se imprime encabezado del próximo comprobante
* @return 0 si no hay error y != 0 si hay un error
*/
public int CloseNonFiscalReceipt(String byVar1)
{
String strBuff = "@CloseNonFiscalReceipt" + "|" + byVar1;

int nError = IF_WRITE(strBuff);

return (nError);
}

//***************************************************************
// 4. Comandos de control de la impresora
/**
* Cortar papel
* @return 0 si no hay error y != 0 si hay un error
*/
public int PaperCut()
{
String strBuff = "@PaperCut";

int nError = IF_WRITE(strBuff);

return (nError);
}

/**
* Avanzar papel de tickets
* @return 0 si no hay error y != 0 si hay un error
*/
public int FeedReceipt()
{
String strBuff = "@FeedReceipt";

int nError = IF_WRITE(strBuff);

return (nError);
}

/**
* Activar Split
* @return 0 si no hay error y != 0 si hay un error
*/
public int ActivateSlip()
{
String strBuff = "@ActivateSlip";

int nError = IF_WRITE(strBuff);

return (nError);
}

/**
* Este comando desactiva el funcionamiento del Slip.
* @return 0 si no hay error y != 0 si hay un error
*/
public int InActivateSlip()
{
String strBuff = "@InActivateSlip";

int nError = IF_WRITE(strBuff);

return (nError);
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
public int FormatoCheque(String strVar1, String strVar2, String strVar3, String byVar4, 
                         String byVar5, String byVar6, String byVar7, 
                          String byVar8)
{
String strBuff = "@FormatoCheque" + "|" + strVar1 + "|" + strVar2 + "|" + strVar3 + "|" + 
                   byVar4 + "|" + byVar5 + "|" + byVar6 + "|" + 
                    byVar7 + "|" + byVar8;

int nError = IF_WRITE(strBuff);

return (nError);
}

/**
* Este comando imprime por el Slip el endoso para un cheque.
* @param	strVar1	Texto a imprimir (max 33 bytes)
* @param	strVar2	Texto a imprimir (max 40 bytes)
* @param	strVar3	Texto a Imprimir (max 40 bytes)
* @param	byVar4	 {ABC}
* @return 0 si no hay error y != 0 si hay un error
*/
public int FormatoEndoso(String strVar1, String strVar2, String strVar3, String byVar4)
{
String strBuff = "@FormatoEndoso" + "|" + strVar1 + "|" + strVar2 + "|" + strVar3 + "|" + 
                   byVar4;

int nError = IF_WRITE(strBuff);

return (nError);
}

//***************************************************************
// 5. Comandos generales
/**
* Ingresar fecha y hora 
* @param	strVar1	Formato de Fecha AAMMDD (Año, Mes, Día) (max 6 bytes)
* @param	strVar2	Formato de Hora HHMMSS (Hora, Minutos, Segundos) (max 6 bytes)
* @return 0 si no hay error y != 0 si hay un error
*/
public int SetDateTime(String strVar1, String strVar2)
{
String strBuff = "@SetDateTime" + "|" + strVar1 + "|" + strVar2;

int nError = IF_WRITE(strBuff);

return (nError);
}

/**
* Consultar fecha y hora
* @return 0 si no hay error y != 0 si hay un error
*/
public int GetDateTime()
{
String strBuff = "@GetDateTime";

int nError = IF_WRITE(strBuff);

return (nError);
}

/**
* Programar texto de encabezamiento 
* @param	nVar1	Número de línea de datos fijos (nn)
* @param	strVar2	Texto Fiscal de hasta 40 caracteres (max 40 bytes)
* @return 0 si no hay error y != 0 si hay un error
*/
public int SetHeader(Integer nVar1, String strVar2)
{
String strBuff = "@SetHeader" + "|" + nVar1.toString() + "|" + strVar2;

int nError = IF_WRITE(strBuff);

return (nError);
}

/**
* Programar texto de cola
* @param	nVar1	Número de línea de datos fijos (nn)
* @param	strVar2	Texto Fiscal de hasta 40 caracteres (max 40 bytes)
* @return 0 si no hay error y != 0 si hay un error
*/
public int SetTrailer(Integer nVar1, String strVar2)
{
String strBuff = "@SetTrailer" + "|" + nVar1.toString() + "|" + strVar2;

int nError = IF_WRITE(strBuff);

return (nError);
}

/**
* Abrir gaveta de dinero 1
* @return 0 si no hay error y != 0 si hay un error
*/
public int OpenDrawer1()
{
String strBuff = "@OpenDrawer1";

int nError = IF_WRITE(strBuff);

return (nError);
}

/**
* Abrir gaveta de dinero 2
* @return 0 si no hay error y != 0 si hay un error
*/
public int OpenDrawer2()
{
String strBuff = "@OpenDrawer2";

int nError = IF_WRITE(strBuff);

return (nError);
}

/**
* Obtener el Nro de serie de la impresora
* @return 0 si no hay error y != 0 si hay un error
*/
public int SerialRequest()
{
String strBuff = "@SerialRequest";

int nError = IF_WRITE(strBuff);

return (nError);
}

/**
* Obtener el Nro de serie de la impresora
* @param	dblVar1	Tasa Standard (.nnnn)
* @param	dblVar2	Tasa IVA 2 (.nnnn)
* @param	dblVar3	Tasa IVA 3 (.nnnn)
* @return 0 si no hay error y != 0 si hay un error
*/
public int ProgramTaxes(Double dblVar1, Double dblVar2, Double dblVar3)
{
String strBuff = "@ProgramTaxes" + "|" + dblVar1.toString() + "|" + dblVar2.toString() + "|" + 
                   dblVar3.toString();

int nError = IF_WRITE(strBuff);

return (nError);
}

}
