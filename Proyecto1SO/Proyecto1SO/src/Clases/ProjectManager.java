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
    
    public ProjectManager(String nombre, double salarioPorHora, Empresa empresa, Semaphore mutex, int diasParaEntrega) {
        super(nombre, salarioPorHora, empresa, mutex);
        
        this.salarioPorHora = 40;
        this.diasParaEntrega = diasParaEntrega;
    }
    
    @Override
    public void run(){
        int days = 0;
        int contadorEntrega = this.diasParaEntrega;
        int tiempoDia = 0;
        
        while(days <= 0) {
            try {
                while(tiempoDia <= 16){
                    System.out.println("");
                    System.out.println("*****************************************");
                    System.out.println("Project Manager viendo anime!");
                    System.out.println("*****************************************");
                    System.out.println("");
                    sleep(100);
                    System.out.println("");
                    System.out.println("*****************************************");
                    System.out.println("Project Manager viendo trabajando!");
                    System.out.println("*****************************************");
                    System.out.println("");
                    sleep(100);
                    tiempoDia ++;
                }
                
                System.out.println("");
                System.out.println("*****************************************");
                System.out.println("Project Manager cambiando contador!");
                System.out.println("*****************************************");
                System.out.println("");
                 sleep(6000);
                 
                 contadorEntrega --;
                 System.out.println("");
                System.out.println("*****************************************");
                System.out.println("Faltan: "+contadorEntrega+" dias para la entega!");
                System.out.println("*****************************************");
                System.out.println("");
                
                days++;
                 
            } catch (InterruptedException ex) {
                Logger.getLogger(Trabajador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
}
