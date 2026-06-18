package com.mycompany.prueba1.apache.dao;

import com.mycompany.prueba1.apache.conexion.ConexionBD;
import com.mycompany.prueba1.apache.modelo.Usuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UsuarioDAO { 
    
public boolean actualizarEstado(int idUsuario, Boolean nuevoEstado, String rolEjecutor) {
  if (!"ADMIN".equals(rolEjecutor)) {
      System.out.println("ERROR DAO: Permiso denegado. Solo administradores pueden cambiar estados");
      return false;
  }  
   String sql = "UPDATE usuarios SET activo=? WHERE id = ?";
  try (Connection con = ConexionBD.obetenerConexion();
       PreparedStatement ps = con.prepareStatement(sql)) {
      
      ps.setBoolean(1, nuevoEstado);
      ps.setInt(2, idUsuario);
      
      int filasAfectadas = ps.executeUpdate();
      return filasAfectadas > 0; 
              
  } catch (SQLException e) {
      
      System.out.println("Error de base de datos: " + e.getMessage());
  }   return false;
}
    
public void insertar(Usuario usuario) {
    
String sql = "INSERT INTO usuarios (nombre, clave) VALUES (?, ?)";

try (Connection con = ConexionBD.obetenerConexion();
PreparedStatement ps = con.prepareStatement(sql)) {
    
    ps.setString(1, usuario.getNombre());
    ps.setString(2, usuario.getClave());
    
    ps.executeUpdate();
 
  System.out.println("Usuario insertado correctamente ");
  
} catch (SQLException e) {
    
    System.out.println("Error al insertar: " + e.getMessage());
    
    
}

}

public List<Usuario> listar() {
    
    List<Usuario> lista = new ArrayList<>();
    
    String sql = "SELECT * FROM usuarios";
    
    try (Connection con = ConexionBD.obetenerConexion();
    Statement st = con.createStatement();
    ResultSet rs = st.executeQuery(sql))  {
        
        while (rs.next()) {
           
            Usuario usuario = new Usuario(rs.getInt("id"), rs.getString("nombre"), rs.getString("clave"), rs.getBoolean("activo"));
            
           
            lista.add(usuario);
        }
    } catch (SQLException e) {
            
            System .out.println("Error el listar:" + e.getMessage());
            
            }
    return lista;
      
}
public void actualizar(String nombre, String nuevaClave) {
    
    String sql = "UPDATE usuarios SET clave=? WHERE nombre=?";
    
    try (Connection con = ConexionBD.obetenerConexion();
    PreparedStatement ps = con.prepareStatement(sql)) {
        
        ps.setString(1, nuevaClave);
        ps.setString(2, nombre);
        ps.executeUpdate();
        
        System.out.println("Usuario actualizado correctamente:");      
    
} catch (SQLException e) {
    
    System.out.println("Error al actualizar:" + e.getMessage());
    
    }
}
    
public void eliminar(String nombre) {
    
    String sql ="DELETE FROM usuarios WHERE nombre=?";
    
    try (Connection con = ConexionBD.obetenerConexion();
    PreparedStatement ps = con.prepareStatement(sql)) {
        
        ps.setString(1,nombre);
        ps.executeUpdate();
      
       System.out.println("Usuario eliminado correctamente:");    
    } catch (SQLException e) {
        System.out.println("Error al eliminar:" + e.getMessage());
    }
}
    
}
