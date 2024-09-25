/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import static Clases.tipoComponente.CPU;
import static Clases.tipoComponente.FUENTE_ALIMENTACION;
import static Clases.tipoComponente.PLACA_BASE;
import static Clases.tipoComponente.RAM;
import static Clases.tipoComponente.TARJETA_GRAFICA;

/**
 *
 * @author Windows 10
 */
public class Almacen {
    private tipoComponente tipoComponente;
    private int cantidadActual;
    private int capacidadMaxima;
    //falta el semaforo para garantizar que solo un trabajador a la vez pueda acceder o modificar el inventario (exclusión mutua)
    
    //constructor
    public Almacen(tipoComponente tipoComponente){
        this.tipoComponente = tipoComponente;
        if (null != this.tipoComponente)switch (this.tipoComponente) {
            case PLACA_BASE:
                this.capacidadMaxima = 25;
                break;
            case CPU:
                this.capacidadMaxima = 20;
                break;
            case RAM:
                this.capacidadMaxima = 55;
                break;
            case FUENTE_ALIMENTACION:
                this.capacidadMaxima = 35;
                break;
            case TARJETA_GRAFICA:
                this.capacidadMaxima = 35;
                break;
            default:
                break;
        }
        this.cantidadActual = 0;
        //this. del semaforo
    }
    
    //get del tipo de componente
    public tipoComponente getTipoComponente(){
        return tipoComponente;
    }
    
    //get de la cantidad actual
    public int getCantidadActual(){
        return cantidadActual;
    }
    
    //get de la capacidad maxima del almacen
    public int getCapacidadMaxima(){
        return capacidadMaxima;
    }

    public void setTipoComponente(tipoComponente tipoComponente) {
        this.tipoComponente = tipoComponente;
    }

    public void setCantidadActual(int cantidadActual) {
        this.cantidadActual = cantidadActual;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }
    
    
}
