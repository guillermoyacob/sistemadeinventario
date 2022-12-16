/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeloDAO;

import java.util.List;
import modelo.Usuario;

/**
 *
 * @author Guiye
 */
public interface InterfazUsuarioDAO {
    public List<Usuario> getUsuarios();
    public Usuario getId(int id);
    public Usuario getUsuario(String usuario);
    public Usuario getUsuario(String usuario, String contrasenia);
    public int add(Usuario usuario);
    public int update(Usuario usuario);
    public int delete(int id);
}
