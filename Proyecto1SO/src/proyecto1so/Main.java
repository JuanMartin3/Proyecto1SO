/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto1so;

import Clases.Almacen;
import Clases.Empresa;
import Clases.Productor;
import Clases.ProjectManager;
import Clases.Trabajador;
import Estructuras.LinkedList;
import static java.lang.Thread.sleep;
import java.util.concurrent.Semaphore;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Windows 10
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        
        double duracionDia = 8500;
        
        //Prueba de trabajadores como hilos
        Semaphore mutex = new Semaphore(1);
        
        Empresa msi = new Empresa(4);
        
        Productor trabajador1 = new Productor("Jose", 1, 40, msi, mutex);
        Productor trabajador2 = new Productor("Juan", 2, 40, msi, mutex);
        Productor trabajador3 = new Productor("David", 3, 40, msi, mutex);
        Productor trabajador4 = new Productor("Julio", 4, 40, msi, mutex);
        Productor trabajador5 = new Productor("Alvaro", 5, 40, msi, mutex);
        
        ProjectManager pm = new ProjectManager("Juan C.", 40, msi, mutex, 10);
        
        trabajador1.start();
        trabajador2.start();
        trabajador3.start();
        trabajador4.start();
        trabajador5.start();
        pm.start();
        
        sleep((long) (duracionDia*2));
        System.out.println("");
        System.out.println("*****************************************");
        System.out.println("El inventario de CPUs final es: " + msi.getAlmacen().getCantidadCPU());
        System.out.println("El inventario de RAMs final es: " + msi.getAlmacen().getCantidadRAM());
        System.out.println("El inventario de GPUs final es: " + msi.getAlmacen().getCantidadGPU());
        System.out.println("El inventario de Fuentes final es: " + msi.getAlmacen().getCantidadFuente());
        System.out.println("El inventario de Placas final es: " + msi.getAlmacen().getCantidadPlaca());       
    }
    
}
