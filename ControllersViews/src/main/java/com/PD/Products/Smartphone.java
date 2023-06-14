package com.PD.Products;

import java.util.Arrays;

public class Smartphone extends Product{
    
    private String[] colors;
    private int numberSIM;

    public Smartphone( int id ){
        super(id);
        this.colors = null;
        this.numberSIM = 0;
    }

    public Smartphone(int id, String screen, ModelProduct model, String processor, String[] sensors, float[] dimension, int stored, String[] colors, int numberSIM) {
        super(id, screen, model, processor, sensors, dimension, stored);
        this.colors = colors;
        this.numberSIM = numberSIM;
    }

    @Override
    public String getCaracteristicas() {
        return super.getCaracteristicas() + " colores " + Arrays.toString(this.colors) + " numero de SIM " + this.numberSIM;
    }

    @Override
    public String getTipo() {
        return "Smartphone";
    }

    @Override
    public String getSQLInsert(){
        return super.getSQLInsert() + String.format( ", '%s' , '%d' " , Arrays.toString(this.colors) , this.numberSIM);
    }

}