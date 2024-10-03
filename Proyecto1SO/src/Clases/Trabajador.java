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
 * @author Windows 10
 */
public class Trabajador extends Thread{
    protected String nombre; //provisional?
    protected double salarioPorHora;
    protected int horasTrabajadas;
    protected Empresa empresa;
    protected int tiempoProduccion;
    protected double salarioTrabajador;
    Semaphore mutex; //semaforo 
    
    //constructor 
    public Trabajador(String nombre, double salarioPorHora, Empresa empresa, Semaphore mutex){
        this.nombre = nombre;
        this.salarioPorHora = salarioPorHora;
        this.horasTrabajadas = 0; //empieza con 0 horas
        this.salarioTrabajador = 0;
        this.empresa = empresa;
        this.tiempoProduccion = 0;
        this.mutex = mutex; //semaforo 
    }
    
    //Metodos comunes
    
    public double calcularSalario(){
        return this.horasTrabajadas * this.salarioPorHora;
    }

    public double getSalarioPorHora() {
        return salarioPorHora;
    }

    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public int getTiempoProduccion() {
        return tiempoProduccion;
    }

    public void setTiempoProduccion(int tiempoProduccion) {
        this.tiempoProduccion = tiempoProduccion;
    }

    public void setSalarioPorHora(double salarioPorHora) {
        this.salarioPorHora = salarioPorHora;
    }

    public void setHorasTrabajadas(int horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

}
            