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
    
   

    public Ensambladores (String nombre, Empresa empresa, Semaphore mutex) {
        super(nombre, empresa);
        
    }

//    @Override
//    public void run() {
//        while (true) {
//            try {
//                // Adquirir el permiso del semáforo del almacén
//                System.out.println(this.nombre + " está intentando adquirir el semáforo.");
//                this.empresa.getAlmacen().adquirirSemaforo();
//                System.out.println(this.nombre + " ha adquirido el semáforo.");
//                
//                // Ensamblar una computadora
//                if (this.empresa.getAlmacen().getCantidadCPU() >= PARTES_CPU &&
//                    this.empresa.getAlmacen().getCantidadRAM() >= PARTES_RAM &&
//                    this.empresa.getAlmacen().getCantidadPlaca() >= PARTES_PLACA &&
//                    this.empresa.getAlmacen().getCantidadFuente() >= PARTES_FUENTE &&
//                    (this.empresa.getAlmacen().getCantidadGPU() >= PARTES_GPU || computadorasConTarjetaGrafica < X)) {
//
//                    this.empresa.getAlmacen().setCantidadCPU(this.empresa.getAlmacen().getCantidadCPU() - PARTES_CPU);
//                    this.empresa.getAlmacen().setCantidadRAM(this.empresa.getAlmacen().getCantidadRAM() - PARTES_RAM);
//                    this.empresa.getAlmacen().setCantidadPlaca(this.empresa.getAlmacen().getCantidadPlaca() - PARTES_PLACA);
//                    this.empresa.getAlmacen().setCantidadFuente(this.empresa.getAlmacen().getCantidadFuente() - PARTES_FUENTE);
//
//                    double precioComputadora;
//                    if (computadorasConTarjetaGrafica == X) {
//                        this.empresa.getAlmacen().setCantidadGPU(this.empresa.getAlmacen().getCantidadGPU() - PARTES_GPU);
//                        computadorasConTarjetaGrafica = 0; // Resetear el contador
//                        precioComputadora = precioConTarjetaGrafica;
//                        System.out.println(this.nombre + " ensambló una computadora con tarjeta gráfica.");
//                        this.mutex.release();
//                         this.empresa.getAlmacen().liberarSemaforo();
//                        System.out.println(this.nombre + " ha liberado el semáforo.");
//                    } else {
//                        computadorasConTarjetaGrafica++;
//                        precioComputadora = precioSinTarjetaGrafica;
//                        System.out.println(this.nombre + " ensambló una computadora sin tarjeta gráfica.");
//                        this.mutex.release();
//                         this.empresa.getAlmacen().liberarSemaforo();
//                        System.out.println(this.nombre + " ha liberado el semáforo.");
//                    }
//
//                    ganancias += precioComputadora;
//                    contadorComputadoras++;
//                    System.out.println(this.nombre + " ensambló una computadora. Total ensambladas: " + contadorComputadoras);
//                    System.out.println("Ganancias totales: $" + ganancias);
//                    this.mutex.release();
//                     this.empresa.getAlmacen().liberarSemaforo();
//                    System.out.println(this.nombre + " ha liberado el semáforo.");
//                } else {
//                    System.out.println(this.nombre + " no pudo ensamblar una computadora por falta de componentes.");
//                    this.mutex.release();
//                     this.empresa.getAlmacen().liberarSemaforo();
//                    System.out.println(this.nombre + " ha liberado el semáforo.");
//                }
//
//                sleep(4000); // Dormir por 2 días
//                
//
//                this.salarioTrabajador += this.salarioPorHora * 2 * 24; // Calcular salario por 2 días de trabajo
//                System.out.println("El salario acumulado de " + this.nombre + " es: $" + this.salarioTrabajador);
//
//                sleep(500);
//
//            } catch (InterruptedException ex) {
//                Logger.getLogger(Trabajador.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//    }
}
