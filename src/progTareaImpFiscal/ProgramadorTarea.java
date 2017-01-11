/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package progTareaImpFiscal;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerUtils;
import org.quartz.impl.StdSchedulerFactory;

/**
 * Clase para el control de la Tarea Programada
 * @version 1.0
 * @author Ing. Javier Alarcon
 */
public class ProgramadorTarea {
    
    /*---------------------------------------------------*/
    /*---                  Atributos                  ---*/
    /*---------------------------------------------------*/
    private Scheduler horario;
    
    /*---------------------------------------------------*/
    /*---               Constructores                 ---*/
    /*---------------------------------------------------*/
    /**
     * Constructor null de la clase
     * @see ProgramadorTarea
     */
    public ProgramadorTarea() {
    }
    
    /*---------------------------------------------------*/
    /*---             Metodos Set y Get               ---*/
    /*---------------------------------------------------*/
    /**
     * Retorna el valor del horario creado
     * @return horario
     */
    public Scheduler getHorario() {    
        return horario;
    }

    /**
     * Asigna el valor del horario creado
     * @param horario 
     */
    public void setHorario(Scheduler horario) {
        this.horario = horario;
    }

    /*---------------------------------------------------*/
    /*---             Metodos especificos             ---*/
    /*---------------------------------------------------*/
    /**
     * Método para crear el horario
     * @return 
     */
    private void crearProgramacion(String retardoTmp) {
        try {
            //Creando la programing
            SchedulerFactory factoria = new StdSchedulerFactory();
            //Obteniendo el horario
            horario = factoria.getScheduler();
            //Damos inicio al horario con un retardo de 15 min (900 Seg)
            /*if (retardoTmp.trim().isEmpty())
                horario.startDelayed(900);
            else
                horario.startDelayed(Integer.parseInt(retardoTmp.trim()));*/
            horario.startDelayed(60);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    /**
     * Método que da la information mas detallada sobre el horario, 
     * como hora de inicio de la tarea y cada cuanto tiempo se ejecute la tarea
     * @see ProgramadorTarea
     */
    public void iniciarTareas() {
        //  Variables
        String tiempoEsp = "", IntervaloTmp = "";
        
        //Archivos de Configuracion para tarea programada
        try {
            Properties appTPrg = new Properties();
            String rutPTarProg = "src/config/appTareaProg.properties";
            appTPrg.load(new FileInputStream(rutPTarProg));
            
            tiempoEsp    = appTPrg.getProperty("tp_tiempo_espera_seg").trim();
            IntervaloTmp = appTPrg.getProperty("tp_intervalo_min").trim();
        } catch (IOException ioEx) {
            System.out.println(ioEx.getMessage());
        }
        
        if (this.horario == null) {
            this.crearProgramacion(tiempoEsp);
        }
        
        //Información sobre la tarea
        //La information que se pide un nombre, a que grupo pertenece 

        //y a que clase que implemente de Job va a ser llamado
        JobDetail job = new JobDetail("TareaImprimirIF", null, ImprimirIF.class);
        //Creamos un trigger y le decimos cada cuanto queremos que se invoque la tarea o Job
        //Tenemos los métodos como los siguientes
        //TriggerUtils.makeSecondlyTrigger(tiempo) --> Para invocar una tarea cada cierto segundos
        //TriggerUtils.makeMinutelyTrigger(tiempo) --> Para invocar una tarea cada cierto minutos
        //TriggerUtils.makeHourlyTrigger(tiempo) --> Para invocar una tarea cada cierta hora
        //Entre otros mas que pueden revisar en la documentation
        //Trigger trigger = TriggerUtils.makeMinutelyTrigger(Integer.
        //        parseInt(IntervaloTmp.trim()));
        Trigger trigger = TriggerUtils.makeSecondlyTrigger(30);
        //En que momento va a iniciar la tarea
        trigger.setStartTime(new Date());
        //El nombre del trigger que debe ser unico
        trigger.setName("ImpIFCadaCincoMinutos");
        try {
            this.horario.scheduleJob(job, trigger);
        } catch (SchedulerException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
