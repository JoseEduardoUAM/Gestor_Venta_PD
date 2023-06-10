package com.PD.DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
    
  private Connection con;
  private final String DATABASE;
  private final String USER;
  private final String PASSWORD;

  public Connect(){
      this.DATABASE = "Manager_Products";
      this.USER = "root";
      this.PASSWORD = "";
  }

  public Connection iniciarConexion(){
      try {
          // MARIADB = org.mariadb.jdbc.Driver
          // MYSQL   = com.mysql.cj.jdbc.Driver
          Class.forName("org.mariadb.jdbc.Driver");
      } catch (ClassNotFoundException ex) {
          throw new RuntimeException("Ocurrio un error con el driver !!!");
      }
      try {
          // MARIADB = jdbc:mariadb://127.0.0.1:3306/
          // MYSQL = jdbc:mysql://127.0.0.1:3306/
          this.con = DriverManager.getConnection( 
              "jdbc:mariadb://127.0.0.1:3306/" + this.DATABASE, this.USER , this.PASSWORD 
          );
          return con;
      } catch (SQLException ex) {
          throw new RuntimeException("Ocurrio un error al conectarse a la base de datos !!!");
      }
  }
  
  public void finalizarConexion(){
      try {
          if( con != null ) con.close();
      } catch (SQLException ex) {
          throw new RuntimeException("Ocurrio un error al cerrar la conexion !!!");
      }
  }

}
