/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import static java.lang.Thread.sleep;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ensambladores extends Trabajador {
    
   

    public Ensambladores (String nombre, Empresa empresa) {
        super(nombre, empresa);
        
    }
    
    public void calcularSalario(){
        this.salarioTrabajador = 50 * 24 * this.empresa.getDiasSim();
}

    @Override
    public void run() {
        int X = this.empresa.getxPcGPU();
        
        calcularSalario();
        
        while (this.empresa.getDiasTranscurridos() < this.empresa.getDiasSim()) {
            try {
               
                
                // Ensamblar una computadora
                if (this.empresa.getAlmacen().getCantidadCPU() >= this.empresa.getCantCPUPc() &&
                    this.empresa.getAlmacen().getCantidadRAM() >= this.empresa.getCantRAMPc() &&
                    this.empresa.getAlmacen().getCantidadPlaca() >= this.empresa.getCantPlacaPc() &&
                    this.empresa.getAlmacen().getCantidadFuente() >= this.empresa.getCantFuentePc()) {
                        if(this.empresa.getAlmacen().getContadorPc() % this.empresa.getxPcGPU() == 0 && this.empresa.getAlmacen().getCantidadGPU() >= this.empresa.getCantGPUPc()){
                            //eliminamos los componentes necesarios para armas una pc con gpu del almacen
                            this.empresa.getAlmacen().mutex.acquire();
                            System.out.println("");
                            System.out.println(this.nombre + " entro al almacen para agarrar partes para un pc con Gpu!");
                            this.empresa.getAlmacen().setCantidadCPU(this.empresa.getAlmacen().getCantidadCPU() - this.empresa.getCantCPUPc());
                            this.empresa.getAlmacen().setCantidadFuente(this.empresa.getAlmacen().getCantidadFuente() - this.empresa.getCantFuentePc());
                            this.empresa.getAlmacen().setCantidadPlaca(this.empresa.getAlmacen().getCantidadPlaca() - this.empresa.getCantPlacaPc());
                            this.empresa.getAlmacen().setCantidadRAM(this.empresa.getAlmacen().getCantidadRAM() - this.empresa.getCantRAMPc());
                            this.empresa.getAlmacen().setCantidadGPU(this.empresa.getAlmacen().getCantidadGPU() - this.empresa.getCantGPUPc());
                            System.out.println("");
                            System.out.println(this.nombre + " salio del almacen!");
                            this.empresa.getAlmacen().mutex.release();
                            
                            sleep(this.empresa.getMsPorDia() * 2); 
                            
                            
                            //agregamos pc con gpu al almacen
                            this.empresa.getAlmacen().mutex.acquire();
                            System.out.println("");
                            System.out.println(this.nombre + " entro al almacen para guardar un Pc con Gpu!");
                            this.empresa.getAlmacen().setCantPcGPU(this.empresa.getAlmacen().getCantPcGPU() + 1);
                            System.out.println("");
                            System.out.println(this.nombre + " salio del almacen!");
                            this.empresa.getAlmacen().mutex.release();
                            
                            this.empresa.getAlmacen().setContadorPc(this.empresa.getAlmacen().getContadorPc() + 1);
                        }else{
                            //eliminamos los componentes necesarios para armas una pc normal del almacen
                            this.empresa.getAlmacen().mutex.acquire();
                            System.out.println("");
                            System.out.println(this.nombre + " entro al almacen para agarrar partes para un pc normal!");
                            this.empresa.getAlmacen().setCantidadCPU(this.empresa.getAlmacen().getCantidadCPU() - this.empresa.getCantCPUPc());
                            this.empresa.getAlmacen().setCantidadFuente(this.empresa.getAlmacen().getCantidadFuente() - this.empresa.getCantFuentePc());
                            this.empresa.getAlmacen().setCantidadPlaca(this.empresa.getAlmacen().getCantidadPlaca() - this.empresa.getCantPlacaPc());
                            this.empresa.getAlmacen().setCantidadRAM(this.empresa.getAlmacen().getCantidadRAM() - this.empresa.getCantRAMPc());
                            System.out.println("");
                            System.out.println(this.nombre + " salio del almacen!");
                            this.empresa.getAlmacen().mutex.release();
                            
                            sleep(this.empresa.getMsPorDia() * 2); 
                        
                            //agregamos pc normal al almacen
                            this.empresa.getAlmacen().mutex.acquire();
                            System.out.println("");
                            System.out.println(this.nombre + " entro al almacen para guardar un Pc normal!");
                            this.empresa.getAlmacen().setCantPc(this.empresa.getAlmacen().getCantPc() + 1);
                            System.out.println("");
                            System.out.println(this.nombre + " salio del almacen!");
                            this.empresa.getAlmacen().mutex.release();
                            
                            this.empresa.getAlmacen().setContadorPc(this.empresa.getAlmacen().getContadorPc() + 1);
                        }
                   
                } else {
                    System.out.println("No hay los componentes suficientes para armar una pc!");
                    
                }

                sleep(2000); // Tiempo entre revisiones del almacen
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Trabajador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("El salario acumulado de "+this.nombre+" es: "+this.salarioTrabajador);
    }
}
