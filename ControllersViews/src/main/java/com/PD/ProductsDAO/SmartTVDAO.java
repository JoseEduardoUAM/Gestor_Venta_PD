package com.PD.ProductsDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.PD.DataBase.Connect;
import com.PD.FunctionsUtils.FuntionUtil;
import com.PD.Products.Product;
import com.PD.Products.SmartTV;
import com.PD.Proxys.ModelProxy;
import com.PD.Proxys.Proxy;

public class SmartTVDAO implements Proxy{
    
    private static SmartTVDAO smartTVDAO;

    private SmartTVDAO() { }

    public static synchronized SmartTVDAO get(){
        if( smartTVDAO == null ) smartTVDAO = new SmartTVDAO();
        return smartTVDAO;
    }

  @Override
  public ArrayList<Product> getAll(){
      ArrayList<Product> smarttvs = new ArrayList<>();
      Connect conn;
      try {
          conn = new Connect();
      } catch (Exception e) {
          System.out.println("Error al conectarse en la base de datos");
          return smarttvs;
      }
      try {
          ResultSet result = conn.iniciarConexion().createStatement().executeQuery("SELECT * FROM SmartTV");
          ModelProxy mp = ModelProxy.get();
          while( result.next() ){
              smarttvs.add( 
                  new SmartTV( result.getInt(1) , result.getString(2) , mp.getModel( result.getInt(3) ) , result.getString(4) , result.getString(5).split("\\[|\\]|,") , FuntionUtil.getArrayFloat(result.getString(6)) , result.getInt(7) , result.getFloat(8) )
              );
          }
      } catch (Exception e) {
          System.out.println(e);
          return smarttvs;
      }
      return smarttvs;
  }

  @Override
  public boolean add( Product smarttv ){
      Connect conn;
      try {
          conn = new Connect();
      } catch (Exception e) {
          return false;
      }
      try {
          PreparedStatement st = conn
              .iniciarConexion()
              .prepareStatement( String.format("INSERT INTO SmartTV VALUES( %s )" , smarttv.getSQLInsert()) );
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
  public boolean update( Product smarttv ){
      Connect conn;
      try {
          conn = new Connect();
      } catch (Exception e) {
          return false;
      }
      try {
          PreparedStatement st = conn
              .iniciarConexion()
              .prepareStatement(String.format("UPDATE SmartTV SET %s WHERE idSmartTV=%d",smarttv.getSQLUpdate() , smarttv.getId()));
          int update = st.executeUpdate();
          conn.finalizarConexion();
          if (update <= 0) return false;
      } catch (Exception e) {
          System.out.println(e);
          conn.finalizarConexion();
          return false;
      }
      return true;
  }
  
  @Override
  public boolean delete( Product smarttv ){
      Connect conn;
      try {
          conn = new Connect();
      } catch (Exception e) {
          return false;
      }
      try {
          PreparedStatement st = conn
              .iniciarConexion()
              .prepareStatement("DELETE FROM SmartTV WHERE idSmartTV = ?");
          st.setInt(1, smarttv.getId());
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