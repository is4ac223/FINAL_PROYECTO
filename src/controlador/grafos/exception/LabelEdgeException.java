/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.grafos.exception;

/**
 *
 * @author sebastian
 */
public class LabelEdgeException extends Exception {

    public LabelEdgeException(String msg) {
        super(msg);
    }

    public LabelEdgeException() {
        super("No esta etiquetado");
    }
    
    
}