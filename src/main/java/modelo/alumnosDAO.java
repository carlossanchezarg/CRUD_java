/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class alumnosDAO {
   Connection conexion;
   public alumnosDAO(){
        Conexion con = new Conexion(); 
        conexion = con.getConnection(con.getDb(),con.getUserMysql(),con.getPassMysql());
   }
   
   public List<alumnos> listarAlumnos(){
           
       PreparedStatement ps;
       ResultSet rs;
       List<alumnos> lista = new ArrayList<>();
       try{
           ps = conexion.prepareStatement("SELECT idalumnos, nombre,apellido,email FROM alumnos");
           rs = ps.executeQuery(); 
           while(rs.next()){
               int id = rs.getInt("idalumnos");
               String nombre = rs.getString("nombre");
               String apellido = rs.getString("apellido");
               String email = rs.getString("email");    
               alumnos alu = new alumnos(id, nombre, apellido, email);
               lista.add(alu);
           }
           return lista;
       }catch(SQLException e){
           System.out.println(e.toString());
           return null;
       }
       
   }
   
   public alumnos mostrarAlumno(int _id){
       PreparedStatement ps;
       ResultSet rs;
       alumnos alumno = null;
       
       try{
           ps = conexion.prepareStatement("SELECT idalumnos, nombre,apellido,email FROM alumnos WHERE idalumnos =?");
           ps.setInt(1, _id);
           rs = ps.executeQuery();
           
           while(rs.next()){
               int id = rs.getInt("idalumnos");
               String nombre = rs.getString("nombre");
               String apellido = rs.getString("apellido");
               String email = rs.getString("email");
               
               alumno = new alumnos(id, nombre, apellido, email);
           }
           return alumno;
       }catch(SQLException e){
           System.out.println(e.toString());
           return null;
       }
   }
   
   public boolean insertarAlumnos(alumnos alumno){
       PreparedStatement ps;
       try{
           ps = conexion.prepareStatement("INSERT INTO alumnos(nombre, apellido,email) VALUES (?,?,?)");
           ps.setString(1,alumno.getNombre());
           ps.setString(2,alumno.getApellido());
           ps.setString(3,alumno.getEmail());
           ps.execute();
           return true;
       }catch(SQLException e){
           System.out.println(e.toString());
           return false;
       }
   }
   
   public boolean actualizarAlumno(alumnos alumno){
        PreparedStatement ps;
       try{
           ps = conexion.prepareStatement("UPDATE alumnos SET nombre=?, apellido=?,email=? WHERE idalumnos=?");
           ps.setString(1,alumno.getNombre());
           ps.setString(2,alumno.getApellido());
           ps.setString(3,alumno.getEmail());
           ps.setInt(4, alumno.getId());
           ps.execute();
           return true;
       }catch(SQLException e){
           System.out.println(e.toString());
           return false;
       }
   }
   
   public boolean eliminarAlumno(int _id){
        PreparedStatement ps;
       try{
           ps = conexion.prepareStatement("DELETE FROM alumnos WHERE idalumnos=?");
           ps.setInt(1, _id);
           ps.execute();
           
           return true;
       }catch(SQLException e){
           System.out.println(e.toString());
           return false;
       }
   }
}