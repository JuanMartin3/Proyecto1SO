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
    
    private int contadorComputadoras;
    private int computadorasConTarjetaGrafica;
    private int X;
    private double ganancias;

    private static final int PARTES_CPU = 3;
    private static final int PARTES_RAM = 4;
    private static final int PARTES_PLACA = 2;
    private static final int PARTES_FUENTE = 6;
    private static final int PARTES_GPU = 5; // solo para computadoras con tarjeta gráfica

    private double precioSinTarjetaGrafica;
    private double precioConTarjetaGrafica;

    public Ensambladores (String nombre, double salarioPorHora, Empresa empresa, Semaphore mutex, int X, double precioSinTarjetaGrafica, double precioConTarjetaGrafica) {
        super(nombre, salarioPorHora, empresa, mutex);
        this.contadorComputadoras = 0;
        this.computadorasConTarjetaGrafica = 0;
        this.X = X;
        this.ganancias = 0.0;
        this.precioSinTarjetaGrafica = precioSinTarjetaGrafica;
        this.precioConTarjetaGrafica = precioConTarjetaGrafica;
    }

    @Override
    public void run() {
        while (true) {
            try {
                // Adquirir el permiso del semáforo del almacén
                System.out.println(this.nombre + " está intentando adquirir el semáforo.");
                this.empresa.getAlmacen().adquirirSemaforo();
                System.out.println(this.nombre + " ha adquirido el semáforo.");
                
                // Ensamblar una computadora
                if (this.empresa.getAlmacen().getCantidadCPU() >= PARTES_CPU &&
                    this.empresa.getAlmacen().getCantidadRAM() >= PARTES_RAM &&
                    this.empresa.getAlmacen().getCantidadPlaca() >= PARTES_PLACA &&
                    this.empresa.getAlmacen().getCantidadFuente() >= PARTES_FUENTE &&
                    (this.empresa.getAlmacen().getCantidadGPU() >= PARTES_GPU || computadorasConTarjetaGrafica < X)) {

                    this.empresa.getAlmacen().setCantidadCPU(this.empresa.getAlmacen().getCantidadCPU() - PARTES_CPU);
                    this.empresa.getAlmacen().setCantidadRAM(this.empresa.getAlmacen().getCantidadRAM() - PARTES_RAM);
                    this.empresa.getAlmacen().setCantidadPlaca(this.empresa.getAlmacen().getCantidadPlaca() - PARTES_PLACA);
                    this.empresa.getAlmacen().setCantidadFuente(this.empresa.getAlmacen().getCantidadFuente() - PARTES_FUENTE);

                    double precioComputadora;
                    if (computadorasConTarjetaGrafica == X) {
                        this.empresa.getAlmacen().setCantidadGPU(this.empresa.getAlmacen().getCantidadGPU() - PARTES_GPU);
                        computadorasConTarjetaGrafica = 0; // Resetear el contador
                        precioComputadora = precioConTarjetaGrafica;
                        System.out.println(this.nombre + " ensambló una computadora con tarjeta gráfica.");
                    } else {
                        computadorasConTarjetaGrafica++;
                        precioComputadora = precioSinTarjetaGrafica;
                        System.out.println(this.nombre + " ensambló una computadora sin tarjeta gráfica.");
                    }

                    ganancias += precioComputadora;
                    contadorComputadoras++;
                    System.out.println(this.nombre + " ensambló una computadora. Total ensambladas: " + contadorComputadoras);
                    System.out.println("Ganancias totales: $" + ganancias);
                } else {
                    System.out.println(this.nombre + " no pudo ensamblar una computadora por falta de componentes.");
                }

                sleep(2 * 24 * 60 * 60 * 1000); // Dormir por 2 días

                this.mutex.release();
                System.out.println(this.nombre + " ha liberado el semáforo.");
                this.empresa.getAlmacen().liberarSemaforo(); // Liberar el permiso del semáforo del almacén

                this.salarioTrabajador += this.salarioPorHora * 2 * 24; // Calcular salario por 2 días de trabajo
                System.out.println("El salario acumulado de " + this.nombre + " es: $" + this.salarioTrabajador);

                sleep(500);

            } catch (InterruptedException ex) {
                Logger.getLogger(Trabajador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
