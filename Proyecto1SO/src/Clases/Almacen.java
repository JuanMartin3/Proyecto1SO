/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

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
    public Almacen(tipoComponente tipoComponente, int capacidadMaxima ){
        this.tipoComponente = tipoComponente;
        this.capacidadMaxima = capacidadMaxima;
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
}
