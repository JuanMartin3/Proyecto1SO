/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Windows 10
 */
public class Trabajador {
    protected String nombre;
    protected int cedula;
    protected double salarioPorHora;
    protected boolean estaTrabajando;
    protected int horasTrabajadas;
    protected Almacen almacenAsignado;
    
    //constructor 
    public Trabajador(String nombre, int cedula, double salarioPorHora, Almacen almacenAsignado, int horasTrabajadas){
        this.nombre = nombre;
        this.cedula = cedula;
        this.salarioPorHora = salarioPorHora;
        this.estaTrabajando = false; //empieza sin estar trabajando
        this.horasTrabajadas = 0; //empieza con 0 horas
        this.almacenAsignado = almacenAsignado;
    }
    
    //Metodos comunes
    public void emprezarTurno(){
        this.estaTrabajando = true;
    }
    
    public void terminarTurno(){
        this.estaTrabajando = false;
        this.horasTrabajadas += 8;
    }
    
    public double calcularSalario(){
        return this.horasTrabajadas * this.salarioPorHora;
    }
    
    
}
