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
    private String nombre;
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
     
     //Tiempos de produccion
     private int diasProdCPU;
     private double diasProdRAM;
     private int diasProdPlaca;
     private double diasProdFuente;
     private int diasProdGPU;
     
     //Trabajadores
     private int cantproductorPlaca;
     private int cantproductorCPU;
     private int cantproductorRAM;
     private int cantproductorFuente;
     private int cantproductorGPU;
     private int cantensamblador;
     
     private Productor[] productoresCPU;
     private Productor[] productoresGPU;
     private Productor[] productoresRAM;
     private Productor[] productoresPlaca;
     private Productor[] productoresFuente;
     private Ensambladores[] ensambladores;      
     
     

    public Empresa(String nombre, double precioPc, double precioPcGPU, int cantCPUPc, int cantGPUPc, int cantPlacaPc, int cantRAMPc, int cantFuentePc, int xPcGPU, int diasProdCPU, double diasProdRAM, int diasProdPlaca, double diasProdFuente, int diasProdGPU) {
      
        //this.director = director;
        //this.projectManager = projectManager;
        //this.trabajadores = new Trabajador[nmrTrabajadores];
        this.nombre = nombre;
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
        this.diasParaEntrega = 0;
        this.xPcGPU = xPcGPU;
        
        this.pmAnime = 0;
        this.multaPm = 0;
        
        this.productoresCPU = new Productor[1000];
        this.productoresGPU = new Productor[1000];
        this.productoresRAM = new Productor[1000];
        this.productoresFuente = new Productor[1000];
        this.productoresPlaca = new Productor[1000];
        this.ensambladores = new Ensambladores[1000];
        
        this.diasSim = 0;
        this.msPorDia = 0;
        this.cantproductorPlaca = 0;
        this.cantproductorCPU = 0;
        this.cantproductorRAM = 0;
        this.cantproductorFuente = 0;
        this.cantproductorGPU = 0;
        this.cantensamblador= 0;
        
        this.diasProdCPU = diasProdCPU;
        this.diasProdFuente = diasProdFuente;
        this.diasProdGPU = diasProdGPU;
        this.diasProdRAM = diasProdRAM;
        this.diasProdPlaca = diasProdPlaca;
        
    }
    
     public void crearProdCPU(){
        
        for(int i = 0; i< this.cantproductorCPU; i++){
            Productor productor = new Productor(1,this);
            productor.start();
            productoresCPU[i] = productor;
        }
    }
     
     public void crearProdRAM(){
        
        for(int i = 0; i< this.cantproductorRAM; i++){
            Productor productor = new Productor(2,this);
            productor.start();
            productoresRAM[i] = productor;
        }
    }
     
     public void crearProdGPU(){
        
        for(int i = 0; i< this.cantproductorGPU; i++){
            Productor productor = new Productor(4,this);
            productor.start();
            productoresGPU[i] = productor;
        }
    }
     
     public void crearProdPlaca(){
        
        for(int i = 0; i< this.cantproductorPlaca; i++){
            Productor productor = new Productor(3,this);
            productor.start();
            productoresPlaca[i] = productor;
        }
    }
     
     public void crearProdFuente(){
        
        for(int i = 0; i< this.cantproductorFuente; i++){
            Productor productor = new Productor(5,this);
            productor.start();
            productoresFuente[i] = productor;
        }
    }
    
    public void crearEnsamblador(){
     for(int i = 0; i< this.cantensamblador; i++){
            Ensambladores ensamblador = new Ensambladores(this);
            ensamblador.start();
            ensambladores[i] = ensamblador;
        }
    
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
    public void calcularUtilidad(){
        this.utilidadEstudio += this.gananciasBrutas - this.costoOperativo;
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

    public String getNombre() {
        return nombre;
    }

    public int getDiasProdCPU() {
        return diasProdCPU;
    }

    public void setDiasProdCPU(int diasProdCPU) {
        this.diasProdCPU = diasProdCPU;
    }

    public double getDiasProdRAM() {
        return diasProdRAM;
    }

    public void setDiasProdRAM(double diasProdRAM) {
        this.diasProdRAM = diasProdRAM;
    }

    public int getDiasProdPlaca() {
        return diasProdPlaca;
    }

    public void setDiasProdPlaca(int diasProdPlaca) {
        this.diasProdPlaca = diasProdPlaca;
    }

    public double getDiasProdFuente() {
        return diasProdFuente;
    }

    public void setDiasProdFuente(double diasProdFuente) {
        this.diasProdFuente = diasProdFuente;
    }

    public int getDiasProdGPU() {
        return diasProdGPU;
    }

    public void setDiasProdGPU(int diasProdGPU) {
        this.diasProdGPU = diasProdGPU;
    }
    
    

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantproductorPlaca() {
        return cantproductorPlaca;
    }

    public void setCantproductorPlaca(int cantproductorPlaca) {
        this.cantproductorPlaca = cantproductorPlaca;
    }

    public int getCantproductorCPU() {
        return cantproductorCPU;
    }

    public void setCantproductorCPU(int cantproductorCPU) {
        this.cantproductorCPU = cantproductorCPU;
    }

    public int getCantproductorRAM() {
        return cantproductorRAM;
    }

    public void setCantproductorRAM(int cantproductorRAM) {
        this.cantproductorRAM = cantproductorRAM;
    }

    public int getCantproductorFuente() {
        return cantproductorFuente;
    }

    public void setCantproductorFuente(int cantproductorFuente) {
        this.cantproductorFuente = cantproductorFuente;
    }

    public int getCantproductorGPU() {
        return cantproductorGPU;
    }

    public void setCantproductorGPU(int cantproductorGPU) {
        this.cantproductorGPU = cantproductorGPU;
    }

    public int getCantensamblador() {
        return cantensamblador;
    }

    public void setCantensamblador(int cantensamblador) {
        this.cantensamblador = cantensamblador;
    }

    public Productor[] getProductoresCPU() {
        return productoresCPU;
    }

    public void setProductoresCPU(Productor[] productoresCPU) {
        this.productoresCPU = productoresCPU;
    }

    public Productor[] getProductoresGPU() {
        return productoresGPU;
    }

    public void setProductoresGPU(Productor[] productoresGPU) {
        this.productoresGPU = productoresGPU;
    }

    public Productor[] getProductoresRAM() {
        return productoresRAM;
    }

    public void setProductoresRAM(Productor[] productoresRAM) {
        this.productoresRAM = productoresRAM;
    }

    public Productor[] getProductoresPlaca() {
        return productoresPlaca;
    }

    public void setProductoresPlaca(Productor[] productoresPlaca) {
        this.productoresPlaca = productoresPlaca;
    }

    public Productor[] getProductoresFuente() {
        return productoresFuente;
    }

    public void setProductoresFuente(Productor[] productoresFuente) {
        this.productoresFuente = productoresFuente;
    }

   

    public Ensambladores[] getEnsambladores() {
        return ensambladores;
    }

    public void setEnsambladores(Ensambladores[] ensambladores) {
        this.ensambladores = ensambladores;
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
