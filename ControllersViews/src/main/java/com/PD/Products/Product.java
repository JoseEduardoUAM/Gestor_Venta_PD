package com.PD.Products;

import java.util.Arrays;

public abstract class Product{
    
  private final int id;
  private final String screen;
  private final ModelProduct model;
  private final String processor;
  private final String[] sensors;
  private final float[] dimension;
  private final int stored;

  public Product(int id, String screen, ModelProduct model, String processor, String[] sensors, float[] dimension, int stored) {
      this.id = id;
      this.screen = screen;
      this.model = model;
      this.processor = processor;
      this.sensors = sensors;
      this.dimension = dimension;
      this.stored = stored;
  }

  public int getId() {
      return id;
  }

  public String getSQLInsert(){
    return String.format(
        "0 , '%s' , %d , '%s' , '%s' , '%s' , %d",
        this.screen , this.model.getId() , this.processor , Arrays.toString(this.sensors) , Arrays.toString(this.dimension) , this.stored
    );
  }

  public String getSQLUpdate(){
    return String.format(
        "screen='%s' , idModel=%d , processor='%s' , sensors='%s' , dimension='%s' , stored = %d", 
        this.screen , this.model.getId() , this.processor , this.sensors , this.dimension , this.stored
    );
  }

  public String getCaracteristicas(){
    return "Pantalla " +  this.screen + " procesador " + this.processor + " sensores " + Arrays.toString(this.sensors) + " dimenciones " + Arrays.toString(this.dimension) + " almacenamiento " + this.stored;
  }

  public abstract String getTipo();

}
