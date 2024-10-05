/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import static java.lang.Thread.sleep;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Windows 10
 */
public class ProjectManager extends Trabajador{
    int diasParaEntrega;
    
    public ProjectManager(String nombre, Empresa empresa, int diasParaEntrega) {
        super(nombre, empresa);
        
        this.diasParaEntrega = diasParaEntrega;
    }
    
    @Override
    public void run(){
        double horaEnMs = this.empresa.getMsPorDia()/24;
        double mediaHoraEnMs = horaEnMs/2;
        
        
        while(this.empresa.getDiasTranscurridos() < this.empresa.getDiasSim()) {
            try {
                diasParaEntrega = this.empresa.getDiasParaEntrega();
                int hora = 0;
                
                while(hora <= 16){
                    System.out.println("");
                    System.out.println("Project Manager viendo anime!");
                    System.out.println("");
                    sleep((long) mediaHoraEnMs);
                    System.out.println("");
                    System.out.println("Project Manager viendo trabajando!");
                    System.out.println("");
                    sleep((long) mediaHoraEnMs);
                    hora ++;
                }
                
                System.out.println("");
                System.out.println("*****************************************");
                System.out.println("Project Manager cambiando contador!");
                System.out.println("*****************************************");
                System.out.println("");
                 sleep((long) (horaEnMs * 8));
                 
                 diasParaEntrega --;
                 this.empresa.setDiasParaEntrega(diasParaEntrega);
                 
                 System.out.println("");
                System.out.println("*****************************************");
                System.out.println("Faltan: "+this.empresa.getDiasParaEntrega()+" dias para la entega!");
                System.out.println("*****************************************");
                System.out.println("");
                
                 
            } catch (InterruptedException ex) {
                Logger.getLogger(Trabajador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
}
