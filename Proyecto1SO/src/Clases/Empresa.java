/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;
import Estructuras.LinkedList;
/**
 *
 * @author Windows 10
 */
public class Empresa {
     private String nombre;
     private Trabajador director;
     private Trabajador projectManager;
     private LinkedList<Trabajador> trabajadores;
     private Almacen almacenPlacas;
     private Almacen almacenCPU;
     private Almacen almacenRAM;
     private Almacen almacenGraficas;
     private Almacen almacenFuentes;
     private double gananciasBrutas;
     private double costoOperativo;
     private double utilidadEstudio;
     private int diasParaEntrega;

    public Empresa(String nombre, Trabajador director, Trabajador projectManager, LinkedList<Trabajador> trabajadores, Almacen almacenPlacas, Almacen almacenCPU, Almacen almacenRAM, Almacen almacenGraficas, Almacen almacenFuentes, double gananciasBrutas, double costoOperativo, double utilidadEstudio, int diasParaEntrega) {
        this.nombre = nombre;
        this.director = director;
        this.projectManager = projectManager;
        this.trabajadores = new LinkedList<>();
        this.almacenPlacas = new Almacen(tipoComponente.PLACA_BASE);
        this.almacenCPU = new Almacen(tipoComponente.CPU);
        this.almacenRAM = new Almacen(tipoComponente.RAM);
        this.almacenGraficas = new Almacen(tipoComponente.TARJETA_GRAFICA);
        this.almacenFuentes = new Almacen(tipoComponente.FUENTE_ALIMENTACION);
        this.gananciasBrutas = 0;
        this.costoOperativo = 0;
        this.utilidadEstudio = 0;
        this.diasParaEntrega = diasParaEntrega;
    }
    
    //metodo para agregar un trabajador
    public void agregarTrabajador(Trabajador trabajador){
        trabajadores.appendLast(trabajador);
    }
    
   //metodo para calcular utilidad
    public void calcularUtilidad(double costo, double ganancia){
        this.utilidadEstudio += ganancia - costo;
    }
    
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Trabajador getDirector() {
        return director;
    }

    public void setDirector(Trabajador director) {
        this.director = director;
    }

    public Trabajador getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(Trabajador projectManager) {
        this.projectManager = projectManager;
    }

    public LinkedList<Trabajador> getTrabajadores() {
        return trabajadores;
    }

    public void setTrabajadores(LinkedList<Trabajador> trabajadores) {
        this.trabajadores = trabajadores;
    }

    public Almacen getAlmacenPlacas() {
        return almacenPlacas;
    }

    public void setAlmacenPlacas(Almacen almacenPlacas) {
        this.almacenPlacas = almacenPlacas;
    }

    public Almacen getAlmacenCPU() {
        return almacenCPU;
    }

    public void setAlmacenCPU(Almacen almacenCPU) {
        this.almacenCPU = almacenCPU;
    }

    public Almacen getAlmacenRAM() {
        return almacenRAM;
    }

    public void setAlmacenRAM(Almacen almacenRAM) {
        this.almacenRAM = almacenRAM;
    }

    public Almacen getAlmacenGraficas() {
        return almacenGraficas;
    }

    public void setAlmacenGraficas(Almacen almacenGraficas) {
        this.almacenGraficas = almacenGraficas;
    }

    public Almacen getAlmacenFuentes() {
        return almacenFuentes;
    }

    public void setAlmacenFuentes(Almacen almacenFuentes) {
        this.almacenFuentes = almacenFuentes;
    }

    public double getGananciasBrutas() {
        return gananciasBrutas;
    }

    public void setGananciasBrutas(double gananciasBrutas) {
        this.gananciasBrutas = gananciasBrutas;
    }

    public double getCostoOperativo() {
        return costoOperativo;
    }

    public void setCostoOperativo(double costoOperativo) {
        this.costoOperativo = costoOperativo;
    }

    public double getUtilidadEstudio() {
        return utilidadEstudio;
    }

    public void setUtilidadEstudio(double utilidadEstudio) {
        this.utilidadEstudio = utilidadEstudio;
    }

    public int getDiasParaEntrega() {
        return diasParaEntrega;
    }

    public void setDiasParaEntrega(int diasParaEntrega) {
        this.diasParaEntrega = diasParaEntrega;
    }
      
     
}
