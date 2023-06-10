package com.PD.Proxys;

import java.util.ArrayList;

import com.PD.Products.Product;
import com.PD.ProductsDAO.TabletDAO;

public class TabletProxy implements Proxy{
    
  private static TabletProxy tp;
  private ArrayList<Product> tablets;
  
  private TabletProxy(){
      this.tablets = new ArrayList<>();
  }
  
  public static synchronized TabletProxy get(){
      if( tp == null ) tp = new TabletProxy();
      return tp;
  }
  
  @Override
  public ArrayList<Product> getAll(){
      if( this.tablets.isEmpty() ) this.tablets = TabletDAO.get().getAll();
      return this.tablets;
  }
  
  @Override
  public Product getProduct( int idTablet ){
      if( this.tablets.isEmpty() ) this.tablets = TabletDAO.get().getAll();
      for( Product tablet : this.tablets ) if( tablet.getId() == idTablet ) return tablet;
      return null;
  }
  
  @Override
  public boolean add( Product tablet ){
    TabletDAO.get().add(tablet);
    this.tablets.add(tablet);
    return true;
  }
  
  @Override
  public boolean update( Product newTablet ){
    TabletDAO.get().update(newTablet);
      for( Product tablet : this.tablets ) if( tablet.getId() == newTablet.getId() ) tablet = newTablet;
      return true;
  }
  
  @Override
  public boolean delete( Product presentTablet ){
    TabletDAO.get().delete(presentTablet);
      for( Product tablet : this.tablets ) if( tablet.getId() == presentTablet.getId() ) this.tablets.remove(tablet);
      return true;
  }

  @Override
  public int sizeProducts() {
    if( this.tablets.isEmpty() ) this.tablets = TabletDAO.get().getAll();
    return this.tablets.size();
  }
  
}
