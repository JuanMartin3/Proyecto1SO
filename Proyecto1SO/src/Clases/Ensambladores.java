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
    
   

    public Ensambladores (Empresa empresa) {
        super(empresa);
        
    }
    
    public void calcularSalario(){
        this.salarioTrabajador = 50 * 24 * this.empresa.getDiasSim();
        this.empresa.setCostoOperativo(this.empresa.getCostoOperativo() + this.salarioTrabajador);
}

    @Override
    public void run() {
        
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
                            this.empresa.getAlmacen().setCantidadCPU(this.empresa.getAlmacen().getCantidadCPU() - this.empresa.getCantCPUPc());
                            this.empresa.getAlmacen().setCantidadFuente(this.empresa.getAlmacen().getCantidadFuente() - this.empresa.getCantFuentePc());
                            this.empresa.getAlmacen().setCantidadPlaca(this.empresa.getAlmacen().getCantidadPlaca() - this.empresa.getCantPlacaPc());
                            this.empresa.getAlmacen().setCantidadRAM(this.empresa.getAlmacen().getCantidadRAM() - this.empresa.getCantRAMPc());
                            this.empresa.getAlmacen().setCantidadGPU(this.empresa.getAlmacen().getCantidadGPU() - this.empresa.getCantGPUPc());
                            this.empresa.getAlmacen().mutex.release();
                            
                            sleep(this.empresa.getMsPorDia() * 2); 
                            
                            
                            //agregamos pc con gpu al almacen
                            this.empresa.getAlmacen().mutex.acquire();
                            this.empresa.getAlmacen().setCantPcGPU(this.empresa.getAlmacen().getCantPcGPU() + 1);
                            this.empresa.getAlmacen().mutex.release();
                            
                            this.empresa.getAlmacen().setContadorPc(this.empresa.getAlmacen().getContadorPc() + 1);
                        }else{
                            //eliminamos los componentes necesarios para armas una pc normal del almacen
                            this.empresa.getAlmacen().mutex.acquire();
                            this.empresa.getAlmacen().setCantidadCPU(this.empresa.getAlmacen().getCantidadCPU() - this.empresa.getCantCPUPc());
                            this.empresa.getAlmacen().setCantidadFuente(this.empresa.getAlmacen().getCantidadFuente() - this.empresa.getCantFuentePc());
                            this.empresa.getAlmacen().setCantidadPlaca(this.empresa.getAlmacen().getCantidadPlaca() - this.empresa.getCantPlacaPc());
                            this.empresa.getAlmacen().setCantidadRAM(this.empresa.getAlmacen().getCantidadRAM() - this.empresa.getCantRAMPc());
                            this.empresa.getAlmacen().mutex.release();
                            
                            sleep(this.empresa.getMsPorDia() * 2); 
                        
                            //agregamos pc normal al almacen
                            this.empresa.getAlmacen().mutex.acquire();
                            this.empresa.getAlmacen().setCantPc(this.empresa.getAlmacen().getCantPc() + 1);
                            this.empresa.getAlmacen().mutex.release();
                            
                            this.empresa.getAlmacen().setContadorPc(this.empresa.getAlmacen().getContadorPc() + 1);
                        }
                   
                } else {
                    
                    
                }

                sleep(this.empresa.getMsPorDia() / 4); // Tiempo entre revisiones del almacen
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Trabajador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
