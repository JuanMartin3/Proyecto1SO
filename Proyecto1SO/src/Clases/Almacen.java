/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.util.concurrent.Semaphore;
//import static Clases.tipoComponente.CPU;
//import static Clases.tipoComponente.FUENTE_ALIMENTACION;
//import static Clases.tipoComponente.PLACA_BASE;
//import static Clases.tipoComponente.RAM;
//import static Clases.tipoComponente.TARJETA_GRAFICA;

/**
 *
 * @author Windows 10
 */
public class Almacen {
    private int cantidadPlaca;
    private int cantidadCPU;
    private int cantidadRAM;
    private int cantidadFuente;
    private int cantidadGPU;
    private int capacidadPlaca;
    private int capacidadCPU;
    private int capacidadRAM;
    private int capacidadFuente;
    private int capacidadGPU;
    private int cantPc;
    private int cantPcGPU;
    private int contadorPc;
    public Semaphore mutex;
    
    
    //constructor
    public Almacen(){
        this.cantidadPlaca = 200;
        this.cantidadCPU = 200;
        this.cantidadRAM = 200;
        this.cantidadFuente = 200;
        this.cantidadGPU = 200;
        this.capacidadPlaca = 25;
        this.capacidadCPU = 20;
        this.capacidadRAM = 55;
        this.capacidadFuente = 35;
        this.capacidadGPU = 10;
        
        this.cantPc = 0;
        this.cantPcGPU = 0;
        this.contadorPc = 1;
        
        this.mutex = new Semaphore(1);
        //this. del semaforo
    }
    
    public void adquirirSemaforo() throws InterruptedException {
        mutex.acquire();
    }

    public int getContadorPc() {
        return contadorPc;
    }

    public void setContadorPc(int contadorPc) {
        this.contadorPc = contadorPc;
    }

    public Semaphore getMutex() {
        return mutex;
    }

    public void setMutex(Semaphore mutex) {
        this.mutex = mutex;
    }
    
    public void liberarSemaforo(){
        mutex.release();
    }

    public int getCantidadPlaca() {
        return cantidadPlaca;
    }

    public int getCantPc() {
        return cantPc;
    }

    public void setCantPc(int cantPc) {
        this.cantPc = cantPc;
    }

    public int getCantPcGPU() {
        return cantPcGPU;
    }

    public void setCantPcGPU(int cantPcGPU) {
        this.cantPcGPU = cantPcGPU;
    }

    public Semaphore getSemaforo() {
        return mutex;
    }

    public void setSemaforo(Semaphore semaforo) {
        this.mutex = semaforo;
    }

    public void setCantidadPlaca(int cantidadPlaca) {
        this.cantidadPlaca = cantidadPlaca;
    }

    public int getCantidadCPU() {
        return cantidadCPU;
    }

    public void setCantidadCPU(int cantidadCPU) {
        this.cantidadCPU = cantidadCPU;
    }

    public int getCantidadRAM() {
        return cantidadRAM;
    }

    public void setCantidadRAM(int cantidadRAM) {
        this.cantidadRAM = cantidadRAM;
    }

    public int getCantidadFuente() {
        return cantidadFuente;
    }

    public void setCantidadFuente(int cantidadFuente) {
        this.cantidadFuente = cantidadFuente;
    }

    public int getCantidadGPU() {
        return cantidadGPU;
    }

    public void setCantidadGPU(int cantidadGPU) {
        this.cantidadGPU = cantidadGPU;
    }

    public int getCapacidadPlaca() {
        return capacidadPlaca;
    }

    public void setCapacidadPlaca(int capacidadPlaca) {
        this.capacidadPlaca = capacidadPlaca;
    }

    public int getCapacidadCPU() {
        return capacidadCPU;
    }

    public void setCapacidadCPU(int capacidadCPU) {
        this.capacidadCPU = capacidadCPU;
    }

    public int getCapacidadRAM() {
        return capacidadRAM;
    }

    public void setCapacidadRAM(int capacidadRAM) {
        this.capacidadRAM = capacidadRAM;
    }

    public int getCapacidadFuente() {
        return capacidadFuente;
    }

    public void setCapacidadFuente(int capacidadFuente) {
        this.capacidadFuente = capacidadFuente;
    }

    public int getCapacidadGPU() {
        return capacidadGPU;
    }

    public void setCapacidadGPU(int capacidadGPU) {
        this.capacidadGPU = capacidadGPU;
    }
    
   
    
//    public synchronized void incrementarCantidad(tipoComponente componente) {
//        if (cantidadActual < capacidadMaxima) {
//            if (componente == tipoComponente) {
//                cantidadActual++;
//                System.out.println("Se ha añadido un " + componente + " al almacén.");
//            } else {
//                System.err.println("Error: Se está intentando añadir un componente incorrecto al almacén.");
//            }
//        } else {
//            System.err.println("El almacén está lleno.");
//        }
//    }
    
}
