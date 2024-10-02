/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto1so;

import Clases.Almacen;
import Clases.Empresa;
import Clases.Trabajador;
import Estructuras.LinkedList;
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
    public static void main(String[] args) {
        
        //Prueba de trabajadores como hilos
        Semaphore mutex = new Semaphore(1);
        
        Empresa msi = new Empresa(4);
        
        Trabajador trabajador1 = new Trabajador("Jose", 1, 17, msi, mutex);
        Trabajador trabajador2 = new Trabajador("Juan", 2, 17, msi, mutex);
        Trabajador trabajador3 = new Trabajador("David", 3, 17, msi, mutex);
        Trabajador trabajador4 = new Trabajador("Julio", 4, 17, msi, mutex);
        Trabajador trabajador5 = new Trabajador("Alvaro", 5, 17, msi, mutex);
        
        trabajador1.start();
        trabajador2.start();
        trabajador3.start();
        trabajador4.start();
        trabajador5.start();        
                
                
    }
    
}
