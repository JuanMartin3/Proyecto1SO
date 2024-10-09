/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Thread.sleep;
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
     private double precioPc;
     private double precioPcGPU;
     private int cantCPUPc;
     private int cantRAMPc;
     private int cantPlacaPc;
     private int cantFuentePc;
     private int cantGPUPc;
     private int diasParaEntrega;
     private int diasTranscurridos;
     private int diasSim;
     private int msPorDia;
     private int xPcGPU;
     private int pmAnime;
     private int multaPm;
     
     
     //Trabajadores
     private int cantproductorPlaca;
     private int cantproductorCPU;
     private int cantproductorRAM;
     private int cantproductorFuente;
     private int cantproductorGPU;
     private int cantensamblador;
             
     
     

    public Empresa(int nmrTrabajadores, double precioPc, double precioPcGPU, int cantCPUPc, int cantGPUPc, int cantPlacaPc, int cantRAMPc, int cantFuentePc, int msPorDia, int diasParaEntrega, int xPcGPU, int diasSim ) {
      
        //this.director = director;
        //this.projectManager = projectManager;
        this.nmrTrabajadores = nmrTrabajadores;
        //this.trabajadores = new Trabajador[nmrTrabajadores];
        this.almacen = new Almacen();
        this.gananciasBrutas = 0;
        this.costoOperativo = 0;
        this.utilidadEstudio = 0;
        this.precioPc = precioPc;
        this.precioPcGPU = precioPcGPU;
        this.cantCPUPc = cantCPUPc;
        this.cantGPUPc = cantGPUPc;
        this.cantPlacaPc = cantPlacaPc;
        this.cantRAMPc = cantRAMPc;
        this.cantFuentePc = cantFuentePc;
        this.diasTranscurridos = 0;
        this.diasParaEntrega = diasParaEntrega;
        this.xPcGPU = xPcGPU;
        
        this.pmAnime = 0;
        this.multaPm = 0;
        
        this.diasSim = diasSim;
        this.msPorDia = msPorDia;
    }
    
    //Método para cargar los datos del TXT a la simulación
    public void cargarTiempo(){
        try {
        BufferedReader reader = new BufferedReader(new FileReader("Tiempo.txt"));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] partes = line.split("=");
            if (partes[0].equals("Segundos por día")) {
                this.msPorDia = Integer.parseInt(partes[1])*1000;
            } else if (partes[0].equals("Deadline Day")) {
                this.diasParaEntrega = Integer.parseInt(partes[1]);
            } else if (partes[0].equals("Dias Simulación")) {
                this.diasSim = Integer.parseInt(partes[1]);
            }
        }
        reader.close();
        System.out.println("Datos cargados exitosamente.");
    } catch (IOException e) {
        e.printStackTrace();
        System.out.println("Error al cargar los datos.");
    }
    }
    
    public void cargarApple(){
        try {
        BufferedReader reader = new BufferedReader(new FileReader("Apple.txt"));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] partes = line.split("=");
            if (partes[0].equals("Productor Placa")) {
                cantproductorPlaca = Integer.parseInt(partes[1]);
            } else if (partes[0].equals("Productor CPU")) {
                cantproductorCPU = Integer.parseInt(partes[1]);
            } else if (partes[0].equals("Productor RAM")) {
                cantproductorRAM = Integer.parseInt(partes[1]);
            } else if (partes[0].equals("Productor Fuente")) {
                cantproductorFuente = Integer.parseInt(partes[1]);
            } else if (partes[0].equals("Productor GPU")) {
                cantproductorGPU = Integer.parseInt(partes[1]);
            } else if (partes[0].equals("Ensamblador")) {
                cantensamblador = Integer.parseInt(partes[1]);
            }
        }
        reader.close();
        System.out.println("Datos cargados exitosamente.");
    } catch (IOException e) {
        e.printStackTrace();
        System.out.println("Error al cargar los datos.");
    }
    }
    
    public void cargarMSI(){
        try {
        BufferedReader reader = new BufferedReader(new FileReader("MSI.txt"));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] partes = line.split("=");
            if (partes[0].equals("Productor Placa")) {
                cantproductorPlaca = Integer.parseInt(partes[1]);
            } else if (partes[0].equals("Productor CPU")) {
                cantproductorCPU = Integer.parseInt(partes[1]);
            } else if (partes[0].equals("Productor RAM")) {
                cantproductorRAM = Integer.parseInt(partes[1]);
            } else if (partes[0].equals("Productor Fuente")) {
                cantproductorFuente = Integer.parseInt(partes[1]);
            } else if (partes[0].equals("Productor GPU")) {
                cantproductorGPU = Integer.parseInt(partes[1]);
            } else if (partes[0].equals("Ensamblador")) {
                cantensamblador = Integer.parseInt(partes[1]);
            }
        }
        reader.close();
        System.out.println("Datos cargados exitosamente.");
    } catch (IOException e) {
        e.printStackTrace();
        System.out.println("Error al cargar los datos.");
    }
    }
   
    
    public void pasoDeDias() throws InterruptedException{
        while(diasTranscurridos < this.diasSim){
            sleep(this.msPorDia);
            this.diasTranscurridos += 1;
        }
        sleep(8000);
        System.out.println("");
        System.out.println("*****************************************");
        System.out.println("El inventario de CPUs final es: " + this.getAlmacen().getCantidadCPU());
        System.out.println("El inventario de RAMs final es: " + this.getAlmacen().getCantidadRAM());
        System.out.println("El inventario de GPUs final es: " + this.getAlmacen().getCantidadGPU());
        System.out.println("El inventario de Fuentes final es: " + this.getAlmacen().getCantidadFuente());
        System.out.println("El inventario de Placas final es: " + this.getAlmacen().getCantidadPlaca());  
        System.out.println("El inventario de Pc normales final es: " + this.getAlmacen().getCantPc()); 
        System.out.println("El inventario de Pc con gpu final es: " + this.getAlmacen().getCantPcGPU()); 
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

    public int getPmAnime() {
        return pmAnime;
    }

    public void setPmAnime(int pmAnime) {
        this.pmAnime = pmAnime;
    }
    
    public void setNmrTrabajadores(int nmrTrabajadores) {
        this.nmrTrabajadores = nmrTrabajadores;
    }

    public double getPrecioPc() {
        return precioPc;
    }

    public void setPrecioPc(double precioPc) {
        this.precioPc = precioPc;
    }

    public int getMsPorDia() {
        return msPorDia;
    }

    public void setMsPorDia(int msPorDia) {
        this.msPorDia = msPorDia;
    }

    public int getxPcGPU() {
        return xPcGPU;
    }

    public int getMultaPm() {
        return multaPm;
    }

    public void setMultaPm(int multaPm) {
        this.multaPm = multaPm;
    }

    public void setxPcGPU(int xPcGPU) {
        this.xPcGPU = xPcGPU;
    }
    
    public double getPrecioPcGPU() {
        return precioPcGPU;
    }

    public int getDiasSim() {
        return diasSim;
    }

    public void setDiasSim(int diasSim) {
        this.diasSim = diasSim;
    }

    public void setPrecioPcGPU(double precioPcGPU) {
        this.precioPcGPU = precioPcGPU;
    }

    public int getCantCPUPc() {
        return cantCPUPc;
    }

    public void setCantCPUPc(int cantCPUPc) {
        this.cantCPUPc = cantCPUPc;
    }

    public int getCantRAMPc() {
        return cantRAMPc;
    }

    public void setCantRAMPc(int cantRAMPc) {
        this.cantRAMPc = cantRAMPc;
    }

    public int getCantPlacaPc() {
        return cantPlacaPc;
    }

    public void setCantPlacaPc(int cantPlacaPc) {
        this.cantPlacaPc = cantPlacaPc;
    }

    public int getCantFuentePc() {
        return cantFuentePc;
    }

    public void setCantFuentePc(int cantFuentePc) {
        this.cantFuentePc = cantFuentePc;
    }

    public int getCantGPUPc() {
        return cantGPUPc;
    }

    public void setCantGPUPc(int cantGPUPc) {
        this.cantGPUPc = cantGPUPc;
    }

    public int getDiasTranscurridos() {
        return diasTranscurridos;
    }

    public void setDiasTranscurridos(int diasTranscurridos) {
        this.diasTranscurridos = diasTranscurridos;
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

    public int getDiasParaEntrega() {
        return diasParaEntrega;
    }

    public void setDiasParaEntrega(int diasParaEntrega) {
        this.diasParaEntrega = diasParaEntrega;
    }
      
     
}
