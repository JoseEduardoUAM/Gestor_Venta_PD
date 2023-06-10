package com.PD.Proxys;

import com.PD.Products.ModelProduct;
import com.PD.ProductsDAO.ModelDAO;
import java.util.ArrayList;

public class ModelProxy {
    
    private static ModelProxy mp;
    private ArrayList<ModelProduct> models;

    private ModelProxy() {
        this.models = new ArrayList<>();
    }
    
    public static synchronized ModelProxy get(){
        if( mp == null ) mp = new ModelProxy();
        return mp;
    }
    
    public ArrayList<ModelProduct> getAll(){
        if( this.models.isEmpty() ) this.models = ModelDAO.getAll();
        return this.models;
    }
    
    public ModelProduct getModel( int idModel ){
        if( this.models.isEmpty() ) this.models = ModelDAO.getAll();
        for( ModelProduct model : this.models ) if( model.getId() == idModel ) return model;
        return null;
    }
    
    public boolean add( ModelProduct model ){
        ModelDAO.add(model);
        this.models.add(model);
        return true;
    }
    
    public boolean update( ModelProduct newModel ){
        ModelDAO.update(newModel);
        for( ModelProduct model : this.models ) if( model.getId() == newModel.getId() ) model = newModel;
        return true;
    }
    
    public boolean delete( ModelProduct presentModel ){
        ModelDAO.delete(presentModel);
        for( ModelProduct model : this.models ) if( model.getId() == presentModel.getId() ) this.models.remove(model);
        return true;
    }
    
}
