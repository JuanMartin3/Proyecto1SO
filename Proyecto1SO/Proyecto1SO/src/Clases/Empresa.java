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
     //private Trabajador director;
     //private Trabajador projectManager;
     //private Trabajador[] trabajadores;
     private int nmrTrabajadores;
     private Almacen almacen;
     private double gananciasBrutas;
     private double costoOperativo;
     private double utilidadEstudio;
     //private int diasParaEntrega;

    public Empresa(int nmrTrabajadores) {
      
        //this.director = director;
        //this.projectManager = projectManager;
        this.nmrTrabajadores = nmrTrabajadores;
        //this.trabajadores = new Trabajador[nmrTrabajadores];
        this.almacen = new Almacen();
        this.gananciasBrutas = 0;
        this.costoOperativo = 0;
        this.utilidadEstudio = 0;
        //this.diasParaEntrega = diasParaEntrega;
    }
    
    //metodo para agregar un trabajador
    public void agregarTrabajadores(Trabajador trabajador){
        
    }
    
   //metodo para calcular utilidad
    public void calcularUtilidad(double costo, double ganancia){
        this.utilidadEstudio += ganancia - costo;
    }

//    public Trabajador getDirector() {
//        return director;
//    }
//
//    public void setDirector(Trabajador director) {
//        this.director = director;
//    }
//
//    public Trabajador getProjectManager() {
//        return projectManager;
//    }
//
//    public void setProjectManager(Trabajador projectManager) {
//        this.projectManager = projectManager;
//    }
//
//    public Trabajador[] getTrabajadores() {
//        return trabajadores;
//    }

//    public void setTrabajadores(Trabajador[] trabajadores) {
//        this.trabajadores = trabajadores;
//    }

    public int getNmrTrabajadores() {
        return nmrTrabajadores;
    }

    public void setNmrTrabajadores(int nmrTrabajadores) {
        this.nmrTrabajadores = nmrTrabajadores;
    }

    
    public Almacen getAlmacen() {
        return almacen;
    }

    public void setAlmacen(Almacen almacen) {
        this.almacen = almacen;
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

//    public int getDiasParaEntrega() {
//        return diasParaEntrega;
//    }
//
//    public void setDiasParaEntrega(int diasParaEntrega) {
//        this.diasParaEntrega = diasParaEntrega;
//    }
      
     
}
