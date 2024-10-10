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

public class Productor extends Trabajador {

    protected int tipo;

    public Productor(int tipo, Empresa empresa) {
        super(empresa);
        this.tipo = tipo;
    }

    public void calcularSalario(){
        switch (this.tipo) {
            case 1 -> this.salarioTrabajador += 26 * 24 * this.empresa.getDiasSim();
            case 2 -> this.salarioTrabajador += 40 * 24 * this.empresa.getDiasSim();
            case 3 -> this.salarioTrabajador += 20 * 24 * this.empresa.getDiasSim();
            case 4 -> this.salarioTrabajador += 34 * 24 * this.empresa.getDiasSim();
            default -> this.salarioTrabajador += 16 * 24 * this.empresa.getDiasSim();
        }
        this.empresa.setCostoOperativo(this.empresa.getCostoOperativo() + this.salarioTrabajador);
    }
    
    @Override
    public void run() {
        
        this.calcularSalario();
        while (this.empresa.getDiasTranscurridos() < this.empresa.getDiasSim()) {
            try {  
                // Código para modificar el inventario
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
                
                if (this.tipo == 1 && this.empresa.getAlmacen().getCantidadCPU() <= this.empresa.getAlmacen().getCapacidadCPU() - 1) {
                    
                    sleep(this.empresa.getMsPorDia() * this.empresa.getDiasProdCPU()); //Tiempo de produccion CAMBIAR!!!!!!
                    
                    System.out.println("");
                    this.empresa.getAlmacen().mutex.acquire();
                    System.out.println(this.nombre + " entro al almacen!");
                     
                    
                    this.empresa.getAlmacen().setCantidadCPU(newCantCPU);
                    System.out.println(this.nombre + " Agrego 1 CPU al almacen");
                    
                     this.empresa.getAlmacen().mutex.release();
                     System.out.println("");
                    System.out.println(this.nombre + " salio del almacen!");
                    
                } else if (this.tipo == 2 && this.empresa.getAlmacen().getCantidadRAM() <= this.empresa.getAlmacen().getCapacidadRAM() - 1) {
                    
                    sleep((long) (this.empresa.getMsPorDia() * this.empresa.getDiasProdRAM())); //Tiempo de produccion CAMBIAR!!!!!!
                    
                    System.out.println("");
                    this.empresa.getAlmacen().mutex.acquire();
                    System.out.println(this.nombre + " entro al almacen!");
                     
                    
                    this.empresa.getAlmacen().setCantidadRAM(newCantRAM);
                    System.out.println(this.nombre + " Agrego 1 RAM al almacen");
                    
                    this.empresa.getAlmacen().mutex.release();
                    System.out.println("");
                    System.out.println(this.nombre + " salio del almacen!");
                    
                } else if (this.tipo == 3 && this.empresa.getAlmacen().getCantidadPlaca() <= this.empresa.getAlmacen().getCapacidadPlaca() - 1) {
                    
                    sleep(this.empresa.getMsPorDia() * this.empresa.getDiasProdPlaca()); //Tiempo de produccion CAMBIAR!!!!!!
                    
                    System.out.println("");
                    this.empresa.getAlmacen().mutex.acquire();
                    System.out.println(this.nombre + " entro al almacen!");
                     
                    
                    this.empresa.getAlmacen().setCantidadPlaca(newCantPlaca);
                    System.out.println(this.nombre + " Agrego 1 Placa al almacen");
                    
                    this.empresa.getAlmacen().mutex.release();
                    System.out.println("");
                    System.out.println(this.nombre + " salio del almacen!");
                    
                } else if (this.tipo == 4 && this.empresa.getAlmacen().getCantidadGPU() <= this.empresa.getAlmacen().getCapacidadGPU() - 1) {
                    
                    sleep(this.empresa.getMsPorDia() * this.empresa.getDiasProdGPU()); //Tiempo de produccion CAMBIAR!!!!!!
                    
                    System.out.println("");
                    this.empresa.getAlmacen().mutex.acquire();
                    System.out.println(this.nombre + " entro al almacen!");
                
                    
                    this.empresa.getAlmacen().setCantidadGPU(newCantGPU);
                    System.out.println(this.nombre + " Agrego 1 GPU al almacen");
                    
                    this.empresa.getAlmacen().mutex.release();
                    System.out.println("");
                    System.out.println(this.nombre + " salio del almacen!");
                    
                } else if (this.tipo == 5 && this.empresa.getAlmacen().getCantidadFuente() <= this.empresa.getAlmacen().getCapacidadFuente() - 1) {
                    
                    sleep((long) (this.empresa.getMsPorDia() * this.empresa.getDiasProdFuente())); //Tiempo de produccion CAMBIAR!!!!!!
                    
                    System.out.println("");
                    this.empresa.getAlmacen().mutex.acquire();
                    System.out.println(this.nombre + " entro al almacen!");
                  
                    
                    this.empresa.getAlmacen().setCantidadFuente(newCantFuente);
                    System.out.println(this.nombre + " Agrego 1 Fuente al almacen");
                    
                    this.empresa.getAlmacen().mutex.release();
                    System.out.println("");
                    System.out.println(this.nombre + " salio del almacen!");
                    
                } else {
                    
                    System.out.println("");
                    this.empresa.getAlmacen().mutex.acquire();
                    System.out.println(this.nombre + " entro al almacen!");
                    
                    System.out.println(this.nombre + " Intento agregar un componente a su almacen, pero esta lleno.");
                    
                    this.empresa.getAlmacen().mutex.release();
                    System.out.println("");
                    System.out.println(this.nombre + " salio del almacen!");
                    
                    sleep(this.empresa.getMsPorDia()); //Espera un poco a que se libere el almacen
                }
               

            } catch (InterruptedException ex) {
                Logger.getLogger(Trabajador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
