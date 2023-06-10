package com.PD.ProductsDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.PD.DataBase.Connect;
import com.PD.Products.Product;
import com.PD.Products.Tablet;
import com.PD.Proxys.ModelProxy;
import com.PD.Proxys.Proxy;
import com.PD.FunctionsUtils.FuntionUtil;

public class TabletDAO implements Proxy {
    
    private static TabletDAO tabletDAO;

    private TabletDAO(){}

    public static synchronized TabletDAO get(){
        if( tabletDAO == null ) tabletDAO = new TabletDAO();
        return tabletDAO;
    }

    @Override
    public ArrayList<Product> getAll(){
        ArrayList<Product> tablets = new ArrayList<>();
        Connect conn;
        try {
            conn = new Connect();
        } catch (Exception e) {
            System.out.println("Error al conectarse en la base de datos");
            return tablets;
        }
        try {
            ResultSet result = conn.iniciarConexion().createStatement().executeQuery("SELECT * FROM Tablet");
            ModelProxy mp = ModelProxy.get();
            while( result.next() ){
                tablets.add( 
                    new Tablet( result.getInt(1) , result.getString(2) , mp.getModel( result.getInt(3) ) , result.getString(4) , result.getString(5).split("\\[|\\]|\\,") , FuntionUtil.getArrayFloat(result.getString(6)) , result.getInt(7) , result.getString(8).split("\\[|\\]|,") )
                );
            }
        } catch (Exception e) {
            System.out.println(e);
            return tablets;
        }
        return tablets;
    }

    @Override
    public boolean add( Product tablet ){
        Connect conn;
        try {
            conn = new Connect();
        } catch (Exception e) {
            return false;
        }
        try {
            PreparedStatement st = conn
                .iniciarConexion()
                .prepareStatement( String.format("INSERT INTO Tablet VALUES( %s )" , tablet.getSQLInsert() ) );
            
            int insert = st.executeUpdate();
            conn.finalizarConexion();
            if (insert <= 0) return false;
        } catch (Exception e) {
            System.out.println(e);
            if( conn != null )conn.finalizarConexion();
            return false;
        }
        return true;
    }

    @Override
    public boolean update( Product tablet ){
        Connect conn;
        try {
            conn = new Connect();
        } catch (Exception e) {
            return false;
        }
        try {
            PreparedStatement st = conn
                .iniciarConexion()
                .prepareStatement( String.format("UPDATE Tablet SET %s WHERE idTablet= %d" , tablet.getSQLUpdate() , tablet.getId() ) );
            int update = st.executeUpdate();
            conn.finalizarConexion();
            if (update <= 0) return false;
        } catch (Exception e) {
            conn.finalizarConexion();
            return false;
        }
        return true;
    }
    
    @Override
    public boolean delete( Product tablet ){
        Connect conn;
        try {
            conn = new Connect();
        } catch (Exception e) {
            return false;
        }
        try {
            PreparedStatement st = conn
                .iniciarConexion()
                .prepareStatement("DELETE FROM tablet WHERE idTablet = ?");
            st.setInt(1, tablet.getId());
            int delete = st.executeUpdate();
            conn.finalizarConexion();
            if (delete <= 0) return false;
        } catch (Exception e) {
            conn.finalizarConexion();
            return false;
        }
        return true;
    }

    @Override
    public Product getProduct(int idProduct) {
        throw new UnsupportedOperationException("Unimplemented method 'getProduct'");
    }

    @Override
    public int sizeProducts() {
        throw new UnsupportedOperationException("Unimplemented method 'sizeProducts'");
    }

}
