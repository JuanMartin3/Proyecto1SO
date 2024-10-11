/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.io.FileWriter;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Windows 10
 */
public class ProjectManager extends Trabajador{
    int diasParaEntrega;
    
    public ProjectManager(Empresa empresa) {
        super(empresa);
        
        this.diasParaEntrega = this.empresa.getDiasParaEntrega();
    }
    
      public void calcularSalario(){
           int costoAgg = (40 * 24 * this.empresa.getDiasSim()) - this.empresa.getMultaPm();
          this.empresa.setCostoOperativo(this.empresa.getCostoOperativo() + costoAgg); 
          
        this.salarioTrabajador = (40 * 24 * this.empresa.getDiasSim()) - this.empresa.getMultaPm();
        
}
    
    @Override
    public void run(){
        double horaEnMs = this.empresa.getMsPorDia()/24;
        double mediaHoraEnMs = horaEnMs/2;
        
        while(this.empresa.getDiasTranscurridos() < this.empresa.getDiasSim()) {
           
            try {
                
                if(this.empresa.getNombre().equals("MSI")){
                     try {
                            FileWriter writer = new FileWriter("Datos MSI.txt");
                            writer.write("Utilidad MSI=" + this.empresa.getUtilidadEstudio() + "\n");
                            writer.write("Costo Operativo MSI=" +   this.empresa.getCostoOperativo() + "\n");
                            writer.write("Ganancias Brutas MSI=" +   this.empresa.getGananciasBrutas() + "\n");
                            writer.write("Multas PM MSI=" +   this.empresa.getMultaPm() + "\n");
                            writer.write("CPU MSI=" +  this.empresa.getAlmacen().getCantidadCPU() + "\n");
                            writer.write("Placas MSI=" +   this.empresa.getAlmacen().getCantidadPlaca() + "\n");
                            writer.write("RAM MSI=" +   this.empresa.getAlmacen().getCantidadRAM() + "\n");
                            writer.write("Fuentes MSI=" +   this.empresa.getAlmacen().getCantidadFuente() + "\n");
                            writer.write("GPU MSI=" +  this.empresa.getAlmacen().getCantidadGPU() + "\n");
                            writer.write("PCN MSI=" +   this.empresa.getAlmacen().getCantPc() + "\n");
                            writer.write("PCGPU MSI=" +   this.empresa.getAlmacen().getCantPcGPU() + "\n");
                            writer.close();
                            System.out.println("Datos guardados exitosamente.");
                        } catch (IOException e) {
                            e.printStackTrace();
                            System.out.println("Error al guardar los datos.");
                        }
                }else{
                    try{
                        FileWriter writer = new FileWriter("Datos Apple.txt");
                        writer.write("Utilidad Apple=" +  this.empresa.getUtilidadEstudio() + "\n");
                        writer.write("Costo Operativo Apple=" +   this.empresa.getCostoOperativo() + "\n");
                        writer.write("Ganancias Brutas Apple=" +   this.empresa.getGananciasBrutas() + "\n");
                        writer.write("Multas PM Apple=" +   this.empresa.getMultaPm() + "\n");
                        writer.write("CPU Apple=" +  this.empresa.getAlmacen().getCantidadCPU() + "\n");
                        writer.write("Placas Apple=" +   this.empresa.getAlmacen().getCantidadPlaca() + "\n");
                        writer.write("RAM Apple=" +   this.empresa.getAlmacen().getCantidadRAM() + "\n");
                        writer.write("Fuentes Apple=" +   this.empresa.getAlmacen().getCantidadFuente() + "\n");
                        writer.write("GPU Apple=" +  this.empresa.getAlmacen().getCantidadGPU() + "\n");
                        writer.write("PCN Apple=" +   this.empresa.getAlmacen().getCantPc() + "\n");
                        writer.write("PCGPU Apple=" +   this.empresa.getAlmacen().getCantPcGPU() + "\n");
                        writer.close();
                        System.out.println("Datos guardados exitosamente.");
                    } catch (IOException e) {
                        e.printStackTrace();
                        System.out.println("Error al guardar los datos.");
                    }
                }
                
                int hora = 0;
                
                while(hora <= 16){
                    this.empresa.setPmAnime( 1);
                    sleep((long) mediaHoraEnMs);
                    
                    this.empresa.setPmAnime( 0);
                    sleep((long) mediaHoraEnMs);
                    hora ++;
                }
                
                if(this.empresa.getDiasParaEntrega() > 0){
                    this.empresa.setPmAnime( 0);
                    
                     sleep((long) (horaEnMs * 8));

                     this.empresa.setDiasParaEntrega(this.empresa.getDiasParaEntrega() - 1);

                     System.out.println("");
                    System.out.println("*****************************************");
                    System.out.println("Faltan: "+this.empresa.getDiasParaEntrega()+" dias para la entega!");
                    System.out.println("*****************************************");
                    System.out.println("");
                    
                }else{
                    this.empresa.setPmAnime( 0);
                    System.out.println("");
                    System.out.println("*****************************************");
                    System.out.println("No cambia el contador porque espera al que el director venda las pc!");
                    System.out.println("Faltan: "+this.empresa.getDiasParaEntrega()+" dias para la entega!");
                    System.out.println("*****************************************");
                    System.out.println("");
                    sleep((long) (horaEnMs * 8));
                }
                 
            } catch (InterruptedException ex) {
                Logger.getLogger(Trabajador.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            this.empresa.setDiasTranscurridos(this.empresa.getDiasTranscurridos() + 1);
        }
        
         calcularSalario();
          this.empresa.calcularUtilidad();
        
        if(this.empresa.getNombre().equals("MSI")){
                     try {
                            FileWriter writer = new FileWriter("Datos MSI.txt");
                            writer.write("Utilidad MSI=" + this.empresa.getUtilidadEstudio() + "\n");
                            writer.write("Costo Operativo MSI=" +   this.empresa.getCostoOperativo() + "\n");
                            writer.write("Ganancias Brutas MSI=" +   this.empresa.getGananciasBrutas() + "\n");
                            writer.write("Multas PM MSI=" +   this.empresa.getMultaPm() + "\n");
                            writer.write("CPU MSI=" +  this.empresa.getAlmacen().getCantidadCPU() + "\n");
                            writer.write("Placas MSI=" +   this.empresa.getAlmacen().getCantidadPlaca() + "\n");
                            writer.write("RAM MSI=" +   this.empresa.getAlmacen().getCantidadRAM() + "\n");
                            writer.write("Fuentes MSI=" +   this.empresa.getAlmacen().getCantidadFuente() + "\n");
                            writer.write("GPU MSI=" +  this.empresa.getAlmacen().getCantidadGPU() + "\n");
                            writer.write("PCN MSI=" +   this.empresa.getAlmacen().getCantPc() + "\n");
                            writer.write("PCGPU MSI=" +   this.empresa.getAlmacen().getCantPcGPU() + "\n");
                            writer.close();
                            System.out.println("Datos guardados exitosamente.");
                        } catch (IOException e) {
                            e.printStackTrace();
                            System.out.println("Error al guardar los datos.");
                        }
                }else{
                    try{
                        FileWriter writer = new FileWriter("Datos Apple.txt");
                        writer.write("Utilidad Apple=" +  this.empresa.getUtilidadEstudio() + "\n");
                        writer.write("Costo Operativo Apple=" +   this.empresa.getCostoOperativo() + "\n");
                        writer.write("Ganancias Brutas Apple=" +   this.empresa.getGananciasBrutas() + "\n");
                        writer.write("Multas PM Apple=" +   this.empresa.getMultaPm() + "\n");
                        writer.write("CPU Apple=" +  this.empresa.getAlmacen().getCantidadCPU() + "\n");
                        writer.write("Placas Apple=" +   this.empresa.getAlmacen().getCantidadPlaca() + "\n");
                        writer.write("RAM Apple=" +   this.empresa.getAlmacen().getCantidadRAM() + "\n");
                        writer.write("Fuentes Apple=" +   this.empresa.getAlmacen().getCantidadFuente() + "\n");
                        writer.write("GPU Apple=" +  this.empresa.getAlmacen().getCantidadGPU() + "\n");
                        writer.write("PCN Apple=" +   this.empresa.getAlmacen().getCantPc() + "\n");
                        writer.write("PCGPU Apple=" +   this.empresa.getAlmacen().getCantPcGPU() + "\n");
                        writer.close();
                        System.out.println("Datos guardados exitosamente.");
                    } catch (IOException e) {
                        e.printStackTrace();
                        System.out.println("Error al guardar los datos.");
                    }
                }
        
        
        
    }
}
