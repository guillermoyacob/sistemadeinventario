/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeloDAO;

import config.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Auditoria;

/**
 *
 * @author Guiye
 */
public class AuditoriaDAO implements InterfazAuditoriaDAO{

    @Override
    public List<Auditoria> getRegistros() {
        List<Auditoria> registros = new ArrayList<>();
        String sql = "SELECT * FROM auditoria;";
        try {
            PreparedStatement ps = Conexion.Conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Auditoria auditoria = new Auditoria();
                auditoria.setIdAuditoria(rs.getInt("idAuditoria"));
                auditoria.setNombreProducto(rs.getString("nombreProducto"));
                auditoria.setDescripcionProducto(rs.getString("descripcionProducto"));
                auditoria.setUnidadesProducto(rs.getInt("unidadesProducto"));
                auditoria.setCostoProducto(rs.getDouble("costoProducto"));
                auditoria.setPrecioProducto(rs.getDouble("PrecioProducto"));
                auditoria.setCategoriaProducto(rs.getString("categoriaProducto"));
                auditoria.setIdUsuario(rs.getInt("idUsuario"));
                auditoria.setNombreUsuario(rs.getString("nombreUsuario"));
                auditoria.setDescripcionAccion(rs.getString("descripcionAccion"));
                registros.add(auditoria);
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e);
        }
        
        Conexion.cerrarConexion();
        
        return registros;
    }   

    @Override
    public void agregarRegistro(Auditoria auditoria) {
        int resultado = 0;
        String sql = "INSERT INTO auditoria(nombreProducto, descripcionProducto, unidadesProducto, costoProducto, PrecioProducto, categoriaProducto, idUsuario, nombreUsuario, descripcionAccion) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
        try {
            PreparedStatement ps = Conexion.Conectar().prepareStatement(sql);
            ps.setString(1, auditoria.getNombreProducto());
            ps.setString(2, auditoria.getDescripcionProducto());
            ps.setInt(3, auditoria.getUnidadesProducto());
            ps.setDouble(4, auditoria.getCostoProducto());
            ps.setDouble(5, auditoria.getPrecioProducto());
            ps.setString(6, auditoria.getCategoriaProducto());
            ps.setInt(7, auditoria.getIdUsuario());
            ps.setString(8, auditoria.getNombreUsuario());
            ps.setString(9, auditoria.getDescripcionAccion());
            resultado = ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error al agregar el registro en la base de datos" + e);
        }
        
        Conexion.cerrarConexion();
    }
    
    
}
