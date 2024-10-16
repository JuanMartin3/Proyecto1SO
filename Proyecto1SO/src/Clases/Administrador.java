/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Windows 10
 */
public class Administrador extends Trabajador{
    
    public Administrador(Empresa empresa) {
        super(empresa);
    }
    
    public void calcularSalario(){
        this.salarioTrabajador = 24 * 60 * this.empresa.getDiasSim();
        this.empresa.setCostoOperativo(this.empresa.getCostoOperativo() + this.salarioTrabajador);
    };
    
    @Override
    public void run(){
        double horaEnMs = this.empresa.getMsPorDia()/24;
        int diasEntrega = this.empresa.getDiasParaEntrega();
        
        
        while(this.empresa.getDiasTranscurridos() < this.empresa.getDiasSim()) {
            try {
                if(this.empresa.getDiasParaEntrega() == 0){
                    int nmrPc = this.empresa.getAlmacen().getCantPc();
                    int nmrPcGPU = this.empresa.getAlmacen().getCantPcGPU();
                    
                    
                    sleep(this.empresa.getMsPorDia());
                    if(this.empresa.getAlmacen().getCantPc() == 0 && this.empresa.getAlmacen().getCantPcGPU() == 0){
                        
                        System.out.println("");
                        System.out.println("*************************************");
                        System.out.println("No hay PCs para que el administrador venda!");
                        
                        this.empresa.setDiasParaEntrega(diasEntrega);
                    
                    }else{
                        this.empresa.setGananciasBrutas(this.empresa.getGananciasBrutas() + (nmrPc * this.empresa.getPrecioPc()) + (this.empresa.getPrecioPcGPU() * nmrPcGPU));
                        this.empresa.getAlmacen().setCantPc(0);
                        this.empresa.getAlmacen().setCantPcGPU(0);
                        
                        System.out.println("");
                        System.out.println("*************************************");
                        System.out.println("El administrador esta vendiendo PCs!");
                    
                        this.empresa.setDiasParaEntrega(diasEntrega);
                    
                    }
                }else{
                    int horaAdmin = (int)(Math.random() * 24) + 1;   
                    
                    
                    sleep((long) (horaAdmin * horaEnMs));
                    
                    if(this.empresa.getPmAnime() == 1){
                        this.empresa.setMultaPm(this.empresa.getMultaPm() + 100);
                        System.out.println("");
                        System.out.println("*************************************");
                        System.out.println("El administrador multo al Pm!");
                                
                    }else{
                        System.out.println("");
                        System.out.println("*************************************");
                        System.out.println("El administrador no multo al Pm!");
                    }
                    
                    sleep((long) (this.empresa.getMsPorDia() - (horaAdmin * horaEnMs)));
                }
                 
            } catch (InterruptedException ex) {
                Logger.getLogger(Trabajador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        System.out.println("");
        System.out.println("Se le multo "+this.empresa.getMultaPm()+" al PM por ver anime!");
        System.out.println("Se gano "+this.empresa.getGananciasBrutas()+" vendiendo pcs!");
        
    }
}
