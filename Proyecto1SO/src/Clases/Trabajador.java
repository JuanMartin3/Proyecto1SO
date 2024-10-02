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
    protected int tipo;
    protected double salarioPorHora;
    protected int horasTrabajadas;
    protected Empresa empresa;
    protected int tiempoProduccion;
    protected double salarioTrabajador;
    Semaphore mutex; //semaforo 
    
    //constructor 
    public Trabajador(String nombre, int tipo, double salarioPorHora, Empresa empresa, Semaphore mutex){
        this.nombre = nombre;
        this.tipo = tipo;
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

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
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

    
    @Override
    public void run(){
        int days = 0;
        while(days <= 5) {
            try {
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
                
                this.mutex.acquire();
                
                this.salarioTrabajador += this.salarioPorHora;
                 System.out.println("El salario acumulado de "+this.nombre+" es: $"+this.salarioTrabajador);
                 
                 if(this.tipo == 1){
                    this.empresa.getAlmacen().setCantidadCPU(newCantCPU);
                    System.out.println(this.nombre + " Agrego 1 CPU al almacen");
                 
                 }
                 else if(this.tipo == 2){
                    this.empresa.getAlmacen().setCantidadRAM(newCantRAM);
                    System.out.println(this.nombre + " Agrego 1 RAM al almacen");
                 }
                 else if(this.tipo == 3){
                    this.empresa.getAlmacen().setCantidadPlaca(newCantPlaca);
                    System.out.println(this.nombre + " Agrego 1 Placa al almacen");
                 }
                 else if(this.tipo == 4){
                    this.empresa.getAlmacen().setCantidadGPU(newCantGPU);
                    System.out.println(this.nombre + " Agrego 1 GPU al almacen");
                 }
                 else{
                    this.empresa.getAlmacen().setCantidadFuente(newCantFuente);
                    System.out.println(this.nombre + " Agrego 1 Fuente al almacen");
                 }
                
                 sleep(500);
                 
                 this.mutex.release();
                 sleep(1000);
                 days ++;
                 
            } catch (InterruptedException ex) {
                Logger.getLogger(Trabajador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("El inventario de CPUs final es: " + this.getEmpresa().getAlmacen().getCantidadCPU());
        System.out.println("El inventario de RAMs final es: " + this.getEmpresa().getAlmacen().getCantidadRAM());
        System.out.println("El inventario de GPUs final es: " + this.getEmpresa().getAlmacen().getCantidadGPU());
        System.out.println("El inventario de Fuentes final es: " + this.getEmpresa().getAlmacen().getCantidadFuente());
        System.out.println("El inventario de Placas final es: " + this.getEmpresa().getAlmacen().getCantidadPlaca());
    }
}
            