/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Windows 10
 */
public class Ensambladores extends Trabajador{
    
    public Ensambladores(String nombre, double salarioPorHora, Empresa empresa, Semaphore mutex) {
        super(nombre, salarioPorHora, empresa, mutex);
    }
    
}
