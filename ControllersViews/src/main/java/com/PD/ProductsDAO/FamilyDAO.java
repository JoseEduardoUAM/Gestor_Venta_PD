package com.PD.ProductsDAO;

import com.PD.DataBase.Connect;
import com.PD.Products.Family;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class FamilyDAO {
    
  public static ArrayList<Family> getAll(){
      ArrayList<Family> familys = new ArrayList<>();
      Connect conn;
      try {
          conn = new Connect();
      } catch (Exception e) {
          System.out.println("Error al conectarse en la base de datos");
          return familys;
      }
      try {
          ResultSet result = conn.iniciarConexion().createStatement().executeQuery("SELECT * FROM Family");
          while( result.next() ){
              familys.add( 
                  new Family( result.getInt(1) , result.getString(2) )
              );
          }
      } catch (Exception e) {
          System.out.println("Error al obtener el arreglo de objetos");
          return familys;
      }
      return familys;
  }

  public static boolean add( Family family ){
      Connect conn;
      try {
          conn = new Connect();
      } catch (Exception e) {
          return false;
      }
      try {
          PreparedStatement st = conn
              .iniciarConexion()
              .prepareStatement( "INSERT INTO Family VALUES( 0 , ? )" );
          st.setString(1, family.getName());
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

  public static boolean update( Family family ){
      Connect conn;
      try {
          conn = new Connect();
      } catch (Exception e) {
          return false;
      }
      try {
          PreparedStatement st = conn
              .iniciarConexion()
              .prepareStatement("UPDATE Family SET nameFamily=? WHERE idFamily=?");
          st.setString(1, family.getName());
          st.setInt(2, family.getId());
          int update = st.executeUpdate();
          conn.finalizarConexion();
          if (update <= 0) return false;
      } catch (Exception e) {
          conn.finalizarConexion();
          return false;
      }
      return true;
  }
  
  public static boolean delete( Family family ){
      Connect conn;
      try {
          conn = new Connect();
      } catch (Exception e) {
          return false;
      }
      try {
          PreparedStatement st = conn
              .iniciarConexion()
              .prepareStatement("DELETE FROM Family WHERE idFamily=?");
          st.setInt(1, family.getId());
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

