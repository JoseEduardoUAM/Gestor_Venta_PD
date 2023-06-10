package com.PD.Proxys;

import com.PD.Products.Family;
import com.PD.ProductsDAO.FamilyDAO;
import java.util.ArrayList;

public class FamilyProxy {
    
    private static FamilyProxy fp;
    private ArrayList<Family> familis;
    
    private FamilyProxy(){
        this.familis = new ArrayList<>();
    }
    
    public static synchronized FamilyProxy get(){
        if( fp == null ) fp = new FamilyProxy();
        return fp;
    }
    
    public ArrayList<Family> getAll(){
        if( this.familis.isEmpty() ) this.familis = FamilyDAO.getAll();
        return this.familis;
    }
    
    public Family getFamily( int idFamily ){
        if( this.familis.isEmpty() ) this.familis = FamilyDAO.getAll();
        for( Family family : this.familis ) if( family.getId() == idFamily ) return family;
        return null;
    }
    
    public boolean add( Family family ){
        FamilyDAO.add(family);
        this.familis.add(family);
        return true;
    }
    
    public boolean update( Family newFamily ){
        FamilyDAO.update(newFamily);
        for( Family family : this.familis ) if( family.getId() == newFamily.getId() ) family = newFamily;
        return true;
    }
    
    public boolean delete( Family presentFamily ){
        FamilyDAO.delete(presentFamily);
        for( Family family : this.familis ) if( family.getId() == presentFamily.getId() ) this.familis.remove(family);
        return true;
    }
    
}
