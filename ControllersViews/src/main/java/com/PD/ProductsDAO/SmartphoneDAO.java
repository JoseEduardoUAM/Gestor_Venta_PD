package com.PD.ProductsDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.PD.DataBase.Connect;
import com.PD.FunctionsUtils.FuntionUtil;
import com.PD.Products.Product;
import com.PD.Products.Smartphone;
import com.PD.Proxys.ModelProxy;
import com.PD.Proxys.Proxy;

public class SmartphoneDAO implements Proxy{
      
    private static SmartphoneDAO smartphoneDAO;

    private SmartphoneDAO(){ }

    public static synchronized SmartphoneDAO get(){
        if( smartphoneDAO == null ) smartphoneDAO = new SmartphoneDAO();
        return smartphoneDAO;
    }

  @Override
  public ArrayList<Product> getAll(){
      ArrayList<Product> smartphones = new ArrayList<>();
      Connect conn;
      try {
          conn = new Connect();
      } catch (Exception e) {
          System.out.println("Error al conectarse en la base de datos");
          return smartphones;
      }
      try {
          ResultSet result = conn.iniciarConexion().createStatement().executeQuery("SELECT * FROM Smartphone");
          ModelProxy mp = ModelProxy.get();
          while( result.next() ){
              smartphones.add( 
                  new Smartphone( result.getInt(1) , result.getString(2) , mp.getModel( result.getInt(3) ) , result.getString(4) , result.getString(5).split("\\[|\\]|,") , FuntionUtil.getArrayFloat(result.getString(6)) , result.getInt(7) , result.getString(8).split("\\[|\\]|,") , result.getInt(9) )
              );
          }
      } catch (Exception e) {
          System.out.println(e);
          return smartphones;
      }
      return smartphones;
  }

  @Override
  public boolean add( Product smartphone ){
      Connect conn;
      try {
          conn = new Connect();
      } catch (Exception e) {
          return false;
      }
      try {
          PreparedStatement st = conn
              .iniciarConexion()
              .prepareStatement( String.format( "INSERT INTO Smartphone VALUES( %s )" , ((Smartphone) smartphone).getSQLInsert() ) );
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
  public boolean update( Product smartphone ){
      Connect conn;
      try {
          conn = new Connect();
      } catch (Exception e) {
          return false;
      }
      try {
          PreparedStatement st = conn
              .iniciarConexion()
              .prepareStatement( String.format("UPDATE Smartphone SET  WHERE idSmartphone=?" , smartphone.getSQLUpdate() , smartphone.getId() ));
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
  public boolean delete( Product smartphonet ){
      Connect conn;
      try {
          conn = new Connect();
      } catch (Exception e) {
          return false;
      }
      try {
          PreparedStatement st = conn
              .iniciarConexion()
              .prepareStatement("DELETE FROM Smartphone WHERE idSmartphone = ?");
          st.setInt(1, smartphonet.getId());
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