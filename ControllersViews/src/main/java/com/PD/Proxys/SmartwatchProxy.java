package com.PD.Proxys;

import java.util.ArrayList;

import com.PD.Products.Product;
import com.PD.ProductsDAO.SmartwatchDAO;

public class SmartwatchProxy implements Proxy{

  private static SmartwatchProxy sp;
  private ArrayList<Product> smartwatchs;
  
  private SmartwatchProxy(){
      this.smartwatchs = new ArrayList<>();
  }
  
  public static synchronized SmartwatchProxy get(){
      if( sp == null ) sp = new SmartwatchProxy();
      return sp;
  }
  
  @Override
  public ArrayList<Product> getAll(){
      if( this.smartwatchs.isEmpty() ) this.smartwatchs = SmartwatchDAO.get().getAll();
      return this.smartwatchs;
  }
  
  @Override
  public Product getProduct( int idTablet ){
      if( this.smartwatchs.isEmpty() ) this.smartwatchs = SmartwatchDAO.get().getAll();
      for( Product smartwatch : this.smartwatchs ) if( smartwatch.getId() == idTablet ) return smartwatch;
      return null;
  }
  
  @Override
  public boolean add( Product smartwatch ){
      SmartwatchDAO.get().add(smartwatch);
      this.smartwatchs.add(smartwatch);
      return true;
  }
  
  @Override
  public boolean update( Product newSmartwatch ){
      SmartwatchDAO.get().update(newSmartwatch);
      for( Product smartwatch : this.smartwatchs ) if( smartwatch.getId() == newSmartwatch.getId() ) smartwatch = newSmartwatch;
      return true;
  }
  
  @Override
  public boolean delete( Product presentSmartwatch ){
      SmartwatchDAO.get().delete(presentSmartwatch);
      for( Product smartwatch : this.smartwatchs ) if( smartwatch.getId() == presentSmartwatch.getId() ) this.smartwatchs.remove(presentSmartwatch);
      return true;
  }

@Override
public int sizeProducts() {
    if( this.smartwatchs.isEmpty() ) this.smartwatchs = SmartwatchDAO.get().getAll();
    return this.smartwatchs.size();
}
  
  
}