package com.PD.Proxys;

import java.util.ArrayList;

import com.PD.Products.Product;

public interface Proxy {
  
  public ArrayList<Product> getAll();

  public Product getProduct( int idProduct );

  public boolean add( Product product );

  public boolean update( Product product );

  public boolean delete( Product product );

  public int sizeProducts();

}
