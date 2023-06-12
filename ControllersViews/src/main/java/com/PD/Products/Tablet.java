package com.PD.Products;

import java.util.Arrays;

public class Tablet extends Product{
    
    private String[] colors;

    public Tablet(int id, String screen, ModelProduct model, String processor, String[] sensors, float[] dimension, int stored, String[] colors) {
        super(id, screen, model, processor, sensors, dimension, stored);
        this.colors = colors;
    }

    public Tablet( int id ){
        super( id );
        this.colors = null;
    }

    @Override
    public String getCaracteristicas() {
        return super.getCaracteristicas() + " colores " + Arrays.toString(colors);
    }

    @Override
    public String getTipo() {
        return "Tablet";
    }

    @Override
    public String getSQLInsert(){
        return super.getSQLInsert() + String.format( " , '%s' " , Arrays.toString(colors));
    }

    public String[] getColors() {
        return colors;
    }

    public void setColors(String[] colors) {
        this.colors = colors;
    }

}
