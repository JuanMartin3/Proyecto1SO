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
 * @author Juan Martin
 */
//public class Productor extends Trabajador{
//    
//    public Productor(String nombre, double salarioPorHora, Empresa empresa, Semaphore mutex) {
//        super(nombre, salarioPorHora, empresa, mutex);
//    }
    
//    @Override
//    public void Run(){
//        int days = 0;
//        while(days <= 5) {
//            try {
//                
//                this.mutex.acquire();
//                
//                this.salarioTrabajador += this.salarioPorHora;
//                 System.out.println("El salario acumulado de "+this.nombre+" es: $"+this.salarioTrabajador);
//                 sleep(500);
//                 
//                 this.mutex.release();
//                 sleep(1000);
//                 days ++;
//                 
//            } catch (InterruptedException ex) {
//                Logger.getLogger(Trabajador.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//    }
//    
//}
