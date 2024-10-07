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
    
    public Administrador(String nombre, Empresa empresa) {
        super(nombre, empresa);
    }
    
    public void calcularSalario(){
        this.salarioTrabajador = 24 * 60 * this.empresa.getDiasSim();
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
                    
                    this.empresa.setGananciasBrutas(this.empresa.getGananciasBrutas() + (nmrPc * this.empresa.getPrecioPc()) + (this.empresa.getPrecioPcGPU() * nmrPcGPU));
                    this.empresa.getAlmacen().setCantPc(0);
                    this.empresa.getAlmacen().setCantPcGPU(0);
                    System.out.println("Se vendieron PCs!");
                    
                    this.empresa.setDiasParaEntrega(diasEntrega);
                }else{
                    int horaAdmin = (int)(Math.random() * 24) + 1;   
                    
                    
                    sleep((long) (horaAdmin * horaEnMs));
                    
                    if(this.empresa.getPmAnime() == 1){
                        this.empresa.setMultaPm(this.empresa.getMultaPm() + 100);
                        System.out.println("Se multo al Pm!");
                                
                    }else{
                    
                        System.out.println("No se multo al Pm!");
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
