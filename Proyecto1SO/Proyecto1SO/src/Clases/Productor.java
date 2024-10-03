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
public class Productor extends Trabajador{
    
    protected int tipo;
    
    public Productor(String nombre, int tipo, double salarioPorHora, Empresa empresa, Semaphore mutex) {
        super(nombre, salarioPorHora, empresa, mutex);
        this.tipo = tipo;
    }
    
    @Override
    public void run(){
        int days = 0;
        while(days <= 5) {
            try {
                int cantCPU = this.empresa.getAlmacen().getCantidadCPU();
                int newCantCPU = cantCPU + 1;
                
                int cantRAM = this.empresa.getAlmacen().getCantidadRAM();
                int newCantRAM = cantRAM + 1;
                
                int cantPlaca = this.empresa.getAlmacen().getCantidadPlaca();
                int newCantPlaca = cantPlaca + 1;
                
                int cantGPU = this.empresa.getAlmacen().getCantidadGPU();
                int newCantGPU = cantGPU + 1;
                
                int cantFuente = this.empresa.getAlmacen().getCantidadFuente();
                int newCantFuente = cantFuente + 1;
                
                this.mutex.acquire();
                
                this.salarioTrabajador += this.salarioPorHora;
                 System.out.println("El salario acumulado de "+this.nombre+" es: $"+this.salarioTrabajador);
                 
                 if(this.tipo == 1 && this.empresa.getAlmacen().getCantidadCPU() <= this.empresa.getAlmacen().getCapacidadCPU() - 1){
                    this.empresa.getAlmacen().setCantidadCPU(newCantCPU);
                    System.out.println(this.nombre + " Agrego 1 CPU al almacen");
                 
                 }
                 else if(this.tipo == 2 && this.empresa.getAlmacen().getCantidadRAM() <= this.empresa.getAlmacen().getCapacidadRAM() - 1){
                    this.empresa.getAlmacen().setCantidadRAM(newCantRAM);
                    System.out.println(this.nombre + " Agrego 1 RAM al almacen");
                 }
                 else if(this.tipo == 3 && this.empresa.getAlmacen().getCantidadPlaca() <= this.empresa.getAlmacen().getCapacidadPlaca() - 1){
                    this.empresa.getAlmacen().setCantidadPlaca(newCantPlaca);
                    System.out.println(this.nombre + " Agrego 1 Placa al almacen");
                 }
                 else if(this.tipo == 4 && this.empresa.getAlmacen().getCantidadPlaca() <= this.empresa.getAlmacen().getCapacidadPlaca() - 1){
                    this.empresa.getAlmacen().setCantidadGPU(newCantGPU);
                    System.out.println(this.nombre + " Agrego 1 GPU al almacen");
                 }
                 else if(this.tipo == 5 && this.empresa.getAlmacen().getCantidadFuente() <= this.empresa.getAlmacen().getCapacidadFuente() - 1){
                    this.empresa.getAlmacen().setCantidadFuente(newCantFuente);
                    System.out.println(this.nombre + " Agrego 1 Fuente al almacen");
                 }
                 else{
                    System.out.println(this.nombre + " Intento agregar un componente a su almacen, pero esta lleno.");
                 }
                
                 sleep(500);
                 
                 this.mutex.release();
                 sleep(1000);
                 days ++;
                 
            } catch (InterruptedException ex) {
                Logger.getLogger(Trabajador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
}
