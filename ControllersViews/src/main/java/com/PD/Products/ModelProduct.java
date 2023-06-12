package com.PD.Products;

public class ModelProduct{

  private final int id;
  private final String name;
  private final Family family;

  public ModelProduct(int id, String name, Family family) {
      this.id = id;
      this.name = name;
      this.family = family;
  }

  public ModelProduct( int id ){
    this( id , null , null );
  }

  public int getId() {
      return id;
  }

  public String getName() {
      return name;
  }

  public Family getFamily() {
      return family;
  }
  
}