package com.PD.Products;

public class SmartTV extends Product{
    
  private float weight;

  public SmartTV(){}

  public SmartTV(int id, String screen, ModelProduct model, String processor, String[] sensors, float[] dimension, int stored , float weight) {
      super(id, screen, model, processor, sensors, dimension, stored);
      this.weight = weight;
  }

  @Override
  public String getCaracteristicas() {
      return super.getCaracteristicas() + " peso " + this.weight;
  }

  @Override
  public String getTipo() {
    return "SmartTV";
  }

  @Override
  public String getSQLInsert(){
      return super.getSQLInsert() + String.format( " , %.2f " , this.weight);
  }

  public float getWeight() {
    return weight;
  }

  public void setWeight(float weight) {
    this.weight = weight;
  }

}