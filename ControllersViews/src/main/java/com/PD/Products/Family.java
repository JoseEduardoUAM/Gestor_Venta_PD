package com.PD.Products;

public class Family {

  private int id;
  private String name;

    public Family(){ }

  public Family(int id, String name) {
      this.id = id;
      this.name = name;
  }

  public int getId() {
      return id;
  }

  public String getName() {
      return name;
  }

public void setId(int id) {
    this.id = id;
}

public void setName(String name) {
    this.name = name;
}

}