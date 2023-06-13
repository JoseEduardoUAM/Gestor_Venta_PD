package com.PD.ProductsDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.PD.DataBase.Connect;
import com.PD.FunctionsUtils.FuntionUtil;
import com.PD.Products.ModelProduct;
import com.PD.Products.Product;
import com.PD.Products.Smartwatch;
import com.PD.Proxys.Proxy;

public class SmartwatchDAO implements Proxy{
    
  private static SmartwatchDAO smartwatchDAO;

  private SmartwatchDAO(){ }
  
  public static synchronized SmartwatchDAO get(){
    if( smartwatchDAO == null ) smartwatchDAO = new SmartwatchDAO();
    return smartwatchDAO;
  }

  @Override
  public ArrayList<Product> getAll(){
      ArrayList<Product> smartwatchs = new ArrayList<>();
      Connect conn;
      try {
          conn = new Connect();
      } catch (Exception e) {
          System.out.println("Error al conectarse en la base de datos");
          return smartwatchs;
      }
      try {
          ResultSet result = conn.iniciarConexion().createStatement().executeQuery("SELECT * FROM Smartwatch");
          while( result.next() ){
              smartwatchs.add( 
                  new Smartwatch( result.getInt(1) , result.getString(2) , new ModelProduct( result.getInt(3) ) , result.getString(4) , result.getString(5).replaceAll("\\[", "").replaceAll("]", "").split(",") , FuntionUtil.getArrayFloat(result.getString(6)) , result.getInt(7) )
              );
          }
      } catch (Exception e) {
          System.out.println("Error al obtener el arreglo de objetos");
          return smartwatchs;
      }
      return smartwatchs;
  }

  @Override
  public boolean add( Product smartwatch ){
      Connect conn;
      try {
          conn = new Connect();
      } catch (Exception e) {
          return false;
      }
      try {
          PreparedStatement st = conn
              .iniciarConexion()
              .prepareStatement( String.format("INSERT INTO Smartwatch VALUES( %s )" , smartwatch.getSQLInsert() ) );
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
  public boolean update( Product smartwatch ){
      Connect conn;
      try {
          conn = new Connect();
      } catch (Exception e) {
          return false;
      }
      try {
          PreparedStatement st = conn
              .iniciarConexion()
              .prepareStatement( String.format( "UPDATE Smartwatch SET %s WHERE idSmartwatch=%d" , smartwatch.getSQLUpdate() , smartwatch.getId() ));
          int update = st.executeUpdate();
          conn.finalizarConexion();
          if (update <= 0) return false;
      } catch (Exception e) {
          System.out.println( e );
          conn.finalizarConexion();
          return false;
      }
      return true;
  }
  
  @Override
  public boolean delete( Product smartwatch ){
      Connect conn;
      try {
          conn = new Connect();
      } catch (Exception e) {
          return false;
      }
      try {
          PreparedStatement st = conn
              .iniciarConexion()
              .prepareStatement("DELETE FROM Smartwatch WHERE idSmartwatch = ?");
          st.setInt(1, smartwatch.getId());
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
