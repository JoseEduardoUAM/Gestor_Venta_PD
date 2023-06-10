package com.PD.Proxys;

import java.util.ArrayList;

import com.PD.Products.Product;

public class ProductsProxy {
  
  private static ProductsProxy pp;
  private ArrayList<Product> allProducts;

  private ProductsProxy(){  
    this.allProducts = new ArrayList<>();
  }

  public static synchronized ProductsProxy get(){
    if( pp == null ) pp = new ProductsProxy();
    return pp;
  }

  public ArrayList<Product> getAll(){
    if( this.allProducts.isEmpty() ){
      allProducts.addAll( SmartTVProxy.get().getAll() );
      allProducts.addAll( SmartwatchProxy.get().getAll() );
      allProducts.addAll( TabletProxy.get().getAll() );
    }
    return this.allProducts;
  }

  public Product getProduct( int idProduct ){
    if( this.allProducts.isEmpty() ){
      allProducts.addAll( SmartTVProxy.get().getAll() );
      allProducts.addAll( SmartwatchProxy.get().getAll() );
      allProducts.addAll( TabletProxy.get().getAll() );
      allProducts.addAll( SmartphoneProxy.get().getAll() );
    }
    for( Product product : this.allProducts ) if( product.getId() == idProduct ) return product;
    return null;
  }

}
