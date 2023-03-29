package com.seot.primefaces.input;
 
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
 
@ManagedBean
@ViewScoped
public class material_pedido {
 
    private Double input1;
 
 
    public material_pedido() {
        this.input1 = new Double(0);
        input1 = 0d;
    }
 
    public Double getInput1() {
        return input1;
    }
 
    public void setInput1(Double input1) {
        this.input1 = input1;
    }
}