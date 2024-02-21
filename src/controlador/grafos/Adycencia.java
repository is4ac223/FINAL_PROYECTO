/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.grafos;

/**
 *
 * @author sebastian
 */
public class Adycencia {
    private Integer destino;
    private Double peso;

    public Adycencia(Integer destino, Double peso) {
        this.destino = destino;
        this.peso = peso;
    }

    public Adycencia() {
    }
    

    public Integer getDestino() {
        return destino;
    }

    public void setDestino(Integer destino) {
        this.destino = destino;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }
    
}
