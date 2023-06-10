package com.PD.Inventorys;

public class FactoryError {
  
  private int idFactoryError;
  private String name;

  public FactoryError( int idFactoryError , String name ){
    this.idFactoryError = idFactoryError;
    this.name = name;
  }

  public int getIdFactoryError() {
    return idFactoryError;
  }

  public String getName() {
    return name;
  }

}
