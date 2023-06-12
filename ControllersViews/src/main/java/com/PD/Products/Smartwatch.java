package com.PD.Products;

public class Smartwatch extends Product{

  public Smartwatch(int id, String screen, ModelProduct model, String processor, String[] sensors, float[] dimension, int stored) {
      super(id, screen, model, processor, sensors, dimension, stored);
  }

  public Smartwatch( int id ){
    super( id );
  }

  @Override
  public String getTipo() {
    return "Smartwatch";
  }

}