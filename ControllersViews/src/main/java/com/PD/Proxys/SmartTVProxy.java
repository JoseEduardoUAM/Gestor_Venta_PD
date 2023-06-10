package com.PD.Proxys;

import java.util.ArrayList;

import com.PD.Products.Product;
import com.PD.ProductsDAO.SmartTVDAO;

public class SmartTVProxy implements Proxy{
       
  private static SmartTVProxy sp;
  private ArrayList<Product> smartTVs;
  
  private SmartTVProxy(){
      this.smartTVs = new ArrayList<>();
  }
  
  public static synchronized SmartTVProxy get(){
      if( sp == null ) sp = new SmartTVProxy();
      return sp;
  }
  
  @Override
  public ArrayList<Product> getAll(){
      if( this.smartTVs.isEmpty() ) this.smartTVs = SmartTVDAO.get().getAll();
      return this.smartTVs;
  }
  
  @Override
  public Product getProduct( int idSmartTV ){
      if( this.smartTVs.isEmpty() ) this.smartTVs = SmartTVDAO.get().getAll();
      for( Product smartTV : this.smartTVs ) if( smartTV.getId() == idSmartTV ) return smartTV;
      return null;
  }
  
  @Override
  public boolean add( Product smartTV ){
      SmartTVDAO.get().add(smartTV);
      this.smartTVs.add(smartTV);
      return true;
  }
  
  @Override
  public boolean update( Product newSmartTV ){
      SmartTVDAO.get().update(newSmartTV);
      for( Product smartTV : this.smartTVs ) if( smartTV.getId() == newSmartTV.getId() ) smartTV = newSmartTV;
      return true;
  }
  
  @Override
  public boolean delete( Product presentSmartTV ){
      SmartTVDAO.get().delete(presentSmartTV);
      for( Product smartTV : this.smartTVs ) if( smartTV.getId() == presentSmartTV.getId() ) this.smartTVs.remove(smartTV);
      return true;
  }

@Override
public int sizeProducts() {
    if( this.smartTVs.isEmpty() ) this.smartTVs = SmartTVDAO.get().getAll();
    return this.smartTVs.size();
}
  
}
