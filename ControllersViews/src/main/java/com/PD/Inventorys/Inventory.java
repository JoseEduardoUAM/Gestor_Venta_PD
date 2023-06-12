package com.PD.Inventorys;

import java.util.Arrays;

import com.PD.Products.Product;
import com.PD.Products.Smartphone;
import com.PD.Products.Smartwatch;
import com.PD.Products.Tablet;
import com.PD.States.*;
import com.PD.States.Stored;

public class Inventory {

  private int idInventory;
  private State state;
  private Product product;
  private float price;
  private String[] factoryError;

  public Inventory(int idInventory, State state, Product product, float price, String[] factoryError) {
    this.idInventory = idInventory;
    this.state = state;
    this.product = product;
    this.price = price;
    this.factoryError = factoryError;
  }

  public int getIdInventory() {
    return idInventory;
  }

  public String getTypeProduct() {
    return product.getTipo();
  }

  public String getDescriptionProduct() {
    return product.getCaracteristicas();
  }

  public String getFactoryErrors() {
    return Arrays.toString(this.factoryError);
  }

  public String getState() {
    return state.getState();
  }

  public float getPrice() {
    return price;
  }

  public String getSQLInsert() {
    int idState;
    if (this.state instanceof Stored)
      idState = 1;
    else if (this.state instanceof Devolution)
      idState = 2;
    else if (this.state instanceof Reparacion)
      idState = 3;
    else
      idState = 4;
    if (this.product instanceof Smartphone)
      return String.format(" 0 , %d , %d , 0 , 0 , 0 , %.3f , '%s' ", idState, product.getId(), price,
          Arrays.toString(factoryError));
    else if (this.product instanceof Smartwatch)
      return String.format(" 0 , %d , 0 , %d , 0 , 0 , %.3f , '%s' ", idState, product.getId(), price,
          Arrays.toString(factoryError));
    else if (this.product instanceof Tablet)
      return String.format(" 0 , %d ,0 , 0 , %d , 0 , %.3f , '%s' ", idState, product.getId(), price,
          Arrays.toString(factoryError));
    else
      return String.format(" 0 , %d , 0 , 0 , 0 , %d , %.3f , '%s' ", idState, product.getId(), price,
          Arrays.toString(factoryError));
  }

  public void setProduct(Product product) {
    this.product = product;
  }

}
