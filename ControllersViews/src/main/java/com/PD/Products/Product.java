package com.PD.Products;

import java.util.Arrays;

public abstract class Product{
    
  private int id;
  private String screen;
  private ModelProduct model;
  private String processor;
  private String[] sensors;
  private float[] dimension;
  private int stored;

  public Product(int id, String screen, ModelProduct model, String processor, String[] sensors, float[] dimension, int stored) {
      this.id = id;
      this.screen = screen;
      this.model = model;
      this.processor = processor;
      this.sensors = sensors;
      this.dimension = dimension;
      this.stored = stored;
  }

  public Product( int id ){
    this(id, null, null, null, null, null, 0);
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
