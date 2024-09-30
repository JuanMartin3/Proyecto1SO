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
public class Trabajador extends Thread{
    protected String nombre;
    protected int cedula;
    protected double salarioPorHora;
    protected boolean estaTrabajando;
    protected int horasTrabajadas;
    protected Almacen almacenAsignado;
    protected tipoComponente tipoComponente;
    protected int tiempoProduccion;
    Semaphore mutex;
    
    //constructor 
    public Trabajador(String nombre, int cedula, double salarioPorHora, int horasTrabajadas, Almacen almacenAsignado, tipoComponente tipoComponente, int tiempoProduccion, Semaphore mutex){
        this.nombre = nombre;
        this.cedula = cedula;
        this.salarioPorHora = salarioPorHora;
        this.estaTrabajando = false; //empieza sin estar trabajando
        this.horasTrabajadas = 0; //empieza con 0 horas
        this.almacenAsignado = almacenAsignado;
        this.tipoComponente = tipoComponente;
        this.tiempoProduccion = tiempoProduccion;
        this.mutex = mutex;
    }
    
    //Metodos comunes
    public void emprezarTurno(){
        this.estaTrabajando = true;
    }
    
    public void terminarTurno(){
        this.estaTrabajando = false;
        this.horasTrabajadas += 24;
    }
    
    public double calcularSalario(){
        return this.horasTrabajadas * this.salarioPorHora;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCedula() {
        return cedula;
    }

    public double getSalarioPorHora() {
        return salarioPorHora;
    }

    public boolean isEstaTrabajando() {
        return estaTrabajando;
    }

    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public Almacen getAlmacenAsignado() {
        return almacenAsignado;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public void setSalarioPorHora(double salarioPorHora) {
        this.salarioPorHora = salarioPorHora;
    }

    public void setEstaTrabajando(boolean estaTrabajando) {
        this.estaTrabajando = estaTrabajando;
    }

    public void setHorasTrabajadas(int horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    public void setAlmacenAsignado(Almacen almacenAsignado) {
        this.almacenAsignado = almacenAsignado;
    }
    
    @Override
    public void run(){
        while (!isInterrupted()){
            try {
               
                mutex.acquire();

                switch (tipoComponente) {
                    case PLACA_BASE:
                        almacenAsignado.incrementarCantidad(tipoComponente.PLACA_BASE);
                        System.out.println(nombre + " ha producido una placa base.");
                        break;
                    case CPU:
                        almacenAsignado.incrementarCantidad(tipoComponente.CPU);
                        System.out.println(nombre + " ha producido un CPU.");
                        break;
                    case RAM:
                        almacenAsignado.incrementarCantidad(tipoComponente.RAM);
                        System.out.println(nombre + " ha producido un CPU.");
                        break;
                    case FUENTE_ALIMENTACION:
                        almacenAsignado.incrementarCantidad(tipoComponente.FUENTE_ALIMENTACION);
                        System.out.println(nombre + " ha producido un CPU.");
                        break;
                    case TARJETA_GRAFICA:
                        almacenAsignado.incrementarCantidad(tipoComponente.TARJETA_GRAFICA);
                        System.out.println(nombre + " ha producido un CPU.");
                        break;
                
                }

                
                mutex.release();

                

            } catch (InterruptedException e) {
                System.err.println("El trabajador " + nombre + " ha sido interrumpido.");
            }
        }
    }
}
            