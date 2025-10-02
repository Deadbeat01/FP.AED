/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;
import java.sql.*;
/**
 *
 * @author ayllo
 */
public class conexion {
    Connection cn;
    PreparedStatement ps;
    ResultSet rs;
    
    public conexion(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/nexo","root","root");  
            System.out.println("Conectado BD");
        }catch(Exception e){
        System.out.println("Error al conectar BD");
      }
    }
    public Connection getConnection(){
        return cn;
    }
    public int Ralumnos(int codalumno,String nombres, String apellidos,String dni,int edad,int celular,int estado) throws SQLException{
        int res=0;
        
        
        try{
            ps=cn.prepareStatement("insert into alumno(codalumno,nombres,apellidos,dni,edad,celular,estado)values(?,?,?,?,?,?");
            ps.setInt(1, codalumno);
            ps.setString(2, nombres);
            ps.setString(3, apellidos);
            ps.setString(4, dni);
            ps.setInt(5, edad);
            ps.setInt(6, celular);
            ps.setInt(7,estado);
            res=ps.executeUpdate();
            System.out.println("Usuario Registrado correctamente");
            
            
        }catch(Exception e){
            System.out.println("Error al registrar");
        }
        return res;
    }
    
}
