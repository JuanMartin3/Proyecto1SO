/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto1so;

import Clases.Almacen;
import Clases.Empresa;
import Clases.Productor;
import Clases.ProjectManager;
import Clases.Ensambladores;
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
        
        
        //Prueba de trabajadores como hilos
        
        Empresa msi = new Empresa(4, 1, 3, 4, 5, 6, 7, 8, 4000, 4, 5, 16);
        
        //Productor trabajador1 = new Productor("Jose", 1, msi);
        //Productor trabajador2 = new Productor("Juan", 2,  msi);
        //Productor trabajador3 = new Productor("David", 3, msi);
        //Productor trabajador4 = new Productor("Julio", 4, msi);
        //Productor trabajador5 = new Productor("Alvaro", 5, msi);
        //ProjectManager pm = new ProjectManager("Juan C.", msi, 10);
        
        Ensambladores ensamblador1 = new Ensambladores("Carlos", msi);

       
        System.out.println("1");
//        trabajador1.start();
//        trabajador2.start();
//        trabajador3.start();
//        trabajador4.start();
//        trabajador5.start();
//        pm.start();
        ensamblador1.start();
        
        msi.pasoDeDias();
        
           
    }
    
}
