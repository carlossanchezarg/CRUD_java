/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;


/**
 *
 * @author Carlos
 */

import java.sql.*;

public class Conexion {

   
    private String driver = "com.mysql.jdbc.Driver";
    private String host = "jdbc:mysql://localhost:3306/";
    private String userMysql="root";
    private String passMysql="root";
    private String db="prueba";



   

    
    public Connection getConnection(String database, String userMysql, String passMysql ) {
        Connection conn = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(host + database, userMysql, passMysql);
            
        } catch(ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    
    public static void main(String[] args) throws SQLException{
         String userMysql="root";
         String passMysql="root";
         String base="prueba";
         Connection conexion=null;
         Conexion con=new Conexion();
         conexion=con.getConnection(base,userMysql,passMysql);
         
         PreparedStatement ps;
         ResultSet rs;
         ps=conexion.prepareStatement("SELECT * FROM alumnos");
         rs=ps.executeQuery();
         while(rs.next()){
             int id=rs.getInt("idalumnos");
             String nombre=rs.getString("nombre");
             String apellido=rs.getString("apellido");
             String email=rs.getString("email");
             //System.out.println("id:"+id+" Nombre: "+ nombre+ " Apellido: " + apellido+" Email: "+email);
         }
    }

    public String getDriver() {
        return driver;
    }

    public String getHost() {
        return host;
    }

    public String getUserMysql() {
        return userMysql;
    }

    public String getPassMysql() {
        return passMysql;
    }

    public String getDb() {
        return db;
    }


    

}