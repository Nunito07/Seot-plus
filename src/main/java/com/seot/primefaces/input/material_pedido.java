package com.seot.primefaces.input;
 
import java.io.Serializable;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
 
@ViewScoped
@Named
public class material_pedido implements Serializable{
 
    private Double input1;
 
 
    public material_pedido() {
        this.input1 = Double.valueOf(0);
        input1 = 0d;
    }
 
    public Double getInput1() {
        return input1;
    }
 
    public void setInput1(Double input1) {
        this.input1 = input1;
    }
}