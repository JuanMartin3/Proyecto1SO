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
    
    public ProjectManager(Empresa empresa) {
        super(empresa);
        
        this.diasParaEntrega = this.empresa.getDiasParaEntrega();
    }
    
      public void calcularSalario(){
        this.salarioTrabajador = (40 * 24 * this.empresa.getDiasSim()) - this.empresa.getMultaPm();
        this.empresa.setCostoOperativo(this.empresa.getCostoOperativo() + this.salarioTrabajador);
}
    
    @Override
    public void run(){
        double horaEnMs = this.empresa.getMsPorDia()/24;
        double mediaHoraEnMs = horaEnMs/2;
        
        while(this.empresa.getDiasTranscurridos() < this.empresa.getDiasSim()) {
            try {
                int hora = 0;
                
                while(hora <= 16){
                    this.empresa.setPmAnime( 1);
                    sleep((long) mediaHoraEnMs);
                    
                    this.empresa.setPmAnime( 0);
                    sleep((long) mediaHoraEnMs);
                    hora ++;
                }
                
                if(this.empresa.getDiasParaEntrega() > 0){
                    this.empresa.setPmAnime( 0);
                    
                     sleep((long) (horaEnMs * 8));

                     this.empresa.setDiasParaEntrega(this.empresa.getDiasParaEntrega() - 1);

                     System.out.println("");
                    System.out.println("*****************************************");
                    System.out.println("Faltan: "+this.empresa.getDiasParaEntrega()+" dias para la entega!");
                    System.out.println("*****************************************");
                    System.out.println("");
                    
                }else{
                    this.empresa.setPmAnime( 0);
                    System.out.println("");
                    System.out.println("*****************************************");
                    System.out.println("No cambia el contador porque espera al que el director venda las pc!");
                    System.out.println("Faltan: "+this.empresa.getDiasParaEntrega()+" dias para la entega!");
                    System.out.println("*****************************************");
                    System.out.println("");
                    sleep((long) (horaEnMs * 8));
                }
                 
            } catch (InterruptedException ex) {
                Logger.getLogger(Trabajador.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            this.empresa.setDiasTranscurridos(this.empresa.getDiasTranscurridos() + 1);
        }
        
         this.empresa.calcularUtilidad();
         calcularSalario();
        
        try {
            sleep(15000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ProjectManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
