package com.PD.Proxys;

import java.util.ArrayList;
import com.PD.Products.Product;
import com.PD.ProductsDAO.SmartphoneDAO;

public class SmartphoneProxy implements Proxy{
  
    private static SmartphoneProxy sp;
    private ArrayList<Product> smartphones;
    
    private SmartphoneProxy(){
        this.smartphones = new ArrayList<>();
    }
    
    public static synchronized SmartphoneProxy get(){
        if( sp == null ) sp = new SmartphoneProxy();
        return sp;
    }
    
    public ArrayList<Product> getAll(){
        if( this.smartphones.isEmpty() ) this.smartphones = SmartphoneDAO.get().getAll();
        return this.smartphones;
    }
    
    public Product getTablet( int idSmartphone ){
        if( this.smartphones.isEmpty() ) this.smartphones = SmartphoneDAO.get().getAll();
        for( Product smartphone : this.smartphones ) if( smartphone.getId() == idSmartphone ) return smartphone;
        return null;
    }
    
    public boolean add( Product smartphone ){
        SmartphoneDAO.get().add(smartphone);
        this.smartphones.add(smartphone);
        return true;
    }
    
    public boolean update( Product newSmartphone ){
        SmartphoneDAO.get().update(newSmartphone);
        for( Product smartphone : this.smartphones ) if( smartphone.getId() == newSmartphone.getId() ) smartphone = newSmartphone;
        return true;
    }
    
    public boolean delete( Product presentSmartphone ){
        SmartphoneDAO.get().delete(presentSmartphone);
        for( Product smartphone : this.smartphones ) if( smartphone.getId() == presentSmartphone.getId() ) this.smartphones.remove(smartphone);
        return true;
    }

    @Override
    public Product getProduct(int idProduct) {
        if( this.smartphones.isEmpty() ) this.smartphones = SmartphoneDAO.get().getAll();
        for( Product smartphone : this.smartphones ) if( smartphone.getId() == idProduct ) return smartphone;
        return null;
    }

    @Override
    public int sizeProducts() {
        if( this.smartphones.isEmpty() ) this.smartphones = SmartphoneDAO.get().getAll();
        return this.smartphones.size();
    }
    

}
