
package com.mycompany.prueba1.apache.principal;

import com.mycompany.prueba1.apache.dao.UsuarioDAO;
import com.mycompany.prueba1.apache.modelo.Usuario;
import java.util.List;


public class main { 
    
    public static void main(String[] args) {
        
        UsuarioDAO dao = new UsuarioDAO();
        dao.insertar(new Usuario("Carlos", "1234"));
        dao.insertar(new Usuario("Matias", "abdcd"));
        
        List<Usuario> lista = dao.listar();
        
        for (Usuario u : lista) {
            System.out.println("Nombre:" + u.getNombre() + "Clave:" + u.getClave());
        }
        dao.actualizar("Carlos", "0000");
        dao.eliminar("Maria");
    } 
    
}
