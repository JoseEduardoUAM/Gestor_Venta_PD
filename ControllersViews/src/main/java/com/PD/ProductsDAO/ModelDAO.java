package com.PD.ProductsDAO;

import com.PD.DataBase.Connect;
import com.PD.Products.ModelProduct;
import com.PD.Proxys.FamilyProxy;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ModelDAO {
    
  public static ArrayList<ModelProduct> getAll(){
      ArrayList<ModelProduct> familys = new ArrayList<>();
      Connect conn;
      try {
          conn = new Connect();
      } catch (Exception e) {
          System.out.println("Error al conectarse en la base de datos");
          return familys;
      }
      try {
          ResultSet result = conn.iniciarConexion().createStatement().executeQuery("SELECT * FROM Model");
          FamilyProxy fp = FamilyProxy.get();
          while( result.next() ){
              familys.add( 
                  new ModelProduct( result.getInt(1) , result.getString(2) , fp.getFamily( result.getInt(3) ) )
              );
          }
      } catch (Exception e) {
          System.out.println("Error al obtener el arreglo de objetos");
          return familys;
      }
      return familys;
  }

  public static boolean add( ModelProduct model ){
      Connect conn;
      try {
          conn = new Connect();
      } catch (Exception e) {
          return false;
      }
      try {
          PreparedStatement st = conn
              .iniciarConexion()
              .prepareStatement( "INSERT INTO Model VALUES( 0 , ? , ? )" );
          st.setString(1, model.getName());
          st.setInt(2, model.getFamily().getId() );
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

  public static boolean update( ModelProduct model ){
      Connect conn;
      try {
          conn = new Connect();
      } catch (Exception e) {
          return false;
      }
      try {
          PreparedStatement st = conn
              .iniciarConexion()
              .prepareStatement("UPDATE Model SET nameModel=? , idFamily=? WHERE idModel=?");
          st.setString(1, model.getName());
          st.setInt(2, model.getFamily().getId());
          st.setInt(3, model.getId());
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
  
  public static boolean delete( ModelProduct model ){
      Connect conn;
      try {
          conn = new Connect();
      } catch (Exception e) {
          return false;
      }
      try {
          PreparedStatement st = conn
              .iniciarConexion()
              .prepareStatement("DELETE FROM Model WHERE idModel=?");
          st.setInt(1, model.getId());
          int delete = st.executeUpdate();
          conn.finalizarConexion();
          if (delete <= 0) return false;
      } catch (Exception e) {
          conn.finalizarConexion();
          return false;
      }
      return true;
  }
  
}
